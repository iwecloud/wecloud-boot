package com.we.cloud.core.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpHeaders;

/**
 * @author zhaoxudong
 * @ClassName PageUtil
 * @description
 * @date 2021/5/10 15:17
 */
public class PageUtil {

    public static <T> Page<T> getPage(int page, int pageSize) {
        return new Page((long)page, (long)pageSize);
    }

    public static HttpHeaders getTotalHeader(Page<?> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Total-Count", "" + page.getTotal());
        return headers;
    }

}
