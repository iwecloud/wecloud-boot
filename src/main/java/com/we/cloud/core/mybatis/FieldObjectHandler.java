package com.we.cloud.core.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.we.cloud.core.utils.LoginContext;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author zhaoxudong
 * @ClassName FieldObjectHandler
 * @description
 * @date 2021/4/15 21:58
 */

@Component
public class FieldObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createdBy", () -> LoginContext.getUserId(), Long.class);
        this.strictUpdateFill(metaObject, "lastUpdatedBy", () -> LoginContext.getUserId(), Long.class);

        this.strictInsertFill(metaObject, "createdDate", () -> new Date(), Date.class);
        this.strictUpdateFill(metaObject, "lastUpdatedDate", () -> new Date(), Date.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "lastUpdatedBy", () -> LoginContext.getUserId(), Long.class);
        this.strictUpdateFill(metaObject, "lastUpdatedDate", () -> new Date(), Date.class);
    }
}
