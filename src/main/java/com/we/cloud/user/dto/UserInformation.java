package com.we.cloud.user.dto;

import com.we.cloud.user.domain.SysRole;
import com.we.cloud.user.domain.SysTenant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserInformation {

    private Long userId;

    private String userName;

    private String phone;

    private SysRole role;

    private List<SysRole> roleList;

    private SysTenant tenant;

    private List<SysTenant> tenantList;
}