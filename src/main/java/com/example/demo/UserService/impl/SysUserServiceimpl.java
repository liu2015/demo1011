package com.example.demo.UserService.impl;

import com.example.demo.entity.SysUser;
import com.example.demo.mapper.SysUserMapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.UserService.impl
 * @ClassName: SysUserService
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/11 16:41
 * @Version: 1.0
 * 这里是登录功能实现
 */
@Service
public class SysUserServiceimpl {
    @Autowired
    SysUserMapper sysUserMapper;

    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public SysUser selectOne(SysUser user) {
        return sysUserMapper.selectOne( user );
    }

    public SysUser findUser(SysUser user) {
        return sysUserMapper.findUser( user );
    }
}
