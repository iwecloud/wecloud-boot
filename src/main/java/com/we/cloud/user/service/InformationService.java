package com.we.cloud.user.service;

import com.we.cloud.core.security.CustomUser;
import com.we.cloud.core.utils.LoginContext;
import com.we.cloud.user.dto.UserInformation;
import org.springframework.stereotype.Service;

@Service
public class InformationService {

    public UserInformation queryUserInformation(){

        CustomUser customUser = LoginContext.getUser();
        if(null == customUser){
            // TODO: 未登录异常！

        }



        return UserInformation.builder()
                .userId(customUser.getId())
                .userName(customUser.getUsername())
                .phone("")
                .role(customUser.getRole())
                .roleList(customUser.getRoleList())
                .tenant(customUser.getTenant())
                .tenantList(customUser.getTenantList()).build();

    }
}
