package com.we.cloud.core.security;


import com.we.cloud.user.domain.SysRole;
import com.we.cloud.user.domain.SysTenant;
import com.we.cloud.user.domain.SysUser;
import com.we.cloud.user.service.SysRoleService;
import com.we.cloud.user.service.SysTenantService;
import com.we.cloud.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UserDetailsServieImpl
 * @description 实现Spring Security的UserDetailsService接口
 *
 * @author zhaoxudong
 * @date 2020/4/25 14:12
 */
@Service
public class UserDetailsServieImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysTenantService tenantService;

    /**
     * loadUserByUsername : 实现根据用户名返回用户信息方法
     * 返回UserDetails，这是一个接口，通常返回它的字类org.springframework.security.core.userdetails.User
     * User的构造需要三个参数：用户名，密码，角色集
     * @author zhaoxudong
     * @date 2020/4/25 14:13
     * @param loginName
     * @return org.springframework.security.core.userdetails.UserDetails
     */
    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        List<SysUser> userList = sysUserService.queryUserByLoginname(loginName);

        if(CollectionUtils.isEmpty(userList)){
            throw new UsernameNotFoundException("用户不存在");
        }

        // 主账号
        SysUser sysUser = userList.get(0);

        // 查询用户的主租户、租户列表
        List<Long> tenantIds = userList.stream().map(SysUser::getTenantId).collect(Collectors.toList());
        List<SysTenant> tenantList = tenantService.queryTenantById(tenantIds);
        SysTenant tenant = tenantList.get(0);

        // 查询用户在主租户下的角色列表
        List<SysRole> roleList = roleService.queryUserRoleList(sysUser.getId(), tenant.getId());
        if(CollectionUtils.isEmpty(roleList)){
            // TODO: 用户无角色
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority simpleGrantedAuthority;
        simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities.add(simpleGrantedAuthority);

        return new CustomUser(sysUser.getLoginname(), sysUser.getPassword(),
                sysUser.getId(), tenant, roleList.get(0),
                tenantList, roleList,
                authorities);
    }
}
