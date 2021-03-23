package com.we.cloud.core.security;


import com.we.cloud.core.user.domain.SysUser;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDetailsServieImpl
 * @description 实现Spring Security的UserDetailsService接口
 *
 * @author zhaoxudong
 * @date 2020/4/25 14:12
 */
@Service
public class UserDetailsServieImpl implements UserDetailsService {


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
        SysUser sysUser = new SysUser();

        // throw new UsernameNotFoundException("用户不存在");

        sysUser.setLoginname("admin");
        sysUser.setName("admin");
        sysUser.setPassword("{bcrypt}$2a$10$XH7UQhotU.ov4d0PowcWF.l95brkMVzwdD2GC1qtHVEWnhwnhuVeC");


        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        SimpleGrantedAuthority simpleGrantedAuthority;
        simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_ADMIN");
        authorities.add(simpleGrantedAuthority);

        return new User(sysUser.getLoginname(), sysUser.getPassword(), authorities);
    }
}
