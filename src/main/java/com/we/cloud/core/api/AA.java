package com.we.cloud.core.api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhaoxudong
 * @ClassName AA
 * @description
 * @date 2021/3/19 15:21
 */
public class AA {

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("admin"));
    }
}
