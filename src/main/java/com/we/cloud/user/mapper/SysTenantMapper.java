package com.we.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.we.cloud.user.domain.SysTenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SysTenantMapper
 * @description 租户
 * @author wecloud
 */
@Mapper
public interface SysTenantMapper extends BaseMapper<SysTenant> {

}
