package com.example.demo.Controller;

import com.example.demo.UserService.impl.SysUserServiceimpl;
import com.example.demo.entity.SysUser;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.Controller
 * @ClassName: SysUserController
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/12 13:55
 * @Version: 1.0
 */
@Controller
public class SysUserController {

    @Autowired
    SysUserServiceimpl sysUserServiceimpl;

    @RequestMapping("/login")
    @SelectProvider(type=BaseSelectProvider.class, method="dynamicSQL")
    public SysUser selectOne(SysUser user) {
        return sysUserServiceimpl.selectOne( user );
    }


}
