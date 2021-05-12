package com.we.cloud.core.security;
import com.we.cloud.user.domain.SysRole;
import com.we.cloud.user.domain.SysTenant;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

/**
 * @author zhaoxudong
 * @ClassName User
 * @description
 * @date 2021/3/26 17:10
 */
@Data
public class CustomUser extends User{

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 当前租户
     */
    private SysTenant tenant;

    /**
     * 租户列表
     */
    private List<SysTenant> tenantList;

    /**
     * 当前角色
     */
    private SysRole role;

    /**
     * 角色列表
     */
    private List<SysRole> roleList;

    public CustomUser(String username, String password, Long id, SysTenant tenant, SysRole role, List<SysTenant> tenantList, List<SysRole> roleList, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.id = id;
        this.tenant = tenant;
        this.role = role;
        this.tenantList = tenantList;
        this.roleList = roleList;
    }

   /* public CustomUser(Long id, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long tenantId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.tenantId = tenantId;
        this.id = id;
    }*/
}
