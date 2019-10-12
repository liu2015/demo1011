package com.example.demo.mapper;

import com.example.demo.entity.SysUser;
import mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends MyMapper<SysUser> {
 SysUser findUser(SysUser user);

}