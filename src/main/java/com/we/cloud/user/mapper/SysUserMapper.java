package com.we.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.we.cloud.user.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName SysUserMapper
 * @description 用户Mapper
 * @author wecloud
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {


}