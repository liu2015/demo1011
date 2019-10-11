package com.example.demo.UserService.impl;

import com.example.demo.UserService.Userservice;
import com.example.demo.entity.TUser;
import com.example.demo.mapper.TUserMapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.UserService.impl
 * @ClassName: UserServiceimpl
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/11 14:59
 * @Version: 1.0
 */
public class UserServiceimpl implements Userservice {

    @Autowired
    TUserMapper tUserMapper;

    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public TUser selectOne(TUser tUser) {
        return tUserMapper.selectOne( tUser );
    }
}
