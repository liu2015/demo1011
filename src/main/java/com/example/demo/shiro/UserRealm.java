package com.example.demo.shiro;

import com.example.demo.UserService.Userservice;
import com.example.demo.UserService.impl.SysUserServiceimpl;
import com.example.demo.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: demo1011
 * @Package: com.example.demo.shiro
 * @ClassName: UserRealm
 * @Author: ZHY
 * @Description: ${description}
 * @Date: 2019/10/11 14:54
 * @Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    SysUserServiceimpl userservice;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
/** 执行授权
 * @Method doGetAuthorizationInfo
 * @Author ZHY
 * @Version  1.0
 * @Description
 * @param principalCollection
 * @Return org.apache.shiro.authz.AuthorizationInfo
 * @Exception
 * @Date 2019/10/11 14:54
 */
        System.out.println( "授权" );
        Subject subject=SecurityUtils.getSubject();
        SysUser user=(SysUser) subject.getPrincipal();

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo(  );
        simpleAuthorizationInfo.addStringPermission( user.getLoginName() );
        return simpleAuthorizationInfo;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println( "认证" );

        UsernamePasswordToken user=(UsernamePasswordToken) authenticationToken;
        SysUser sysUser=new SysUser();
//        sysUser.getUserName( user.getUsername() );
//        sysUser.setPassword( String.copyValueOf( user.getPassword() ) );
        sysUser.setLoginName( user.getUsername() );
        sysUser.setPassword( String.copyValueOf( user.getPassword() ) );

//        System.out.println( "显示认证的内容··········"+sysUser.getLoginName()+sysUser.getPassword() );

        SysUser newUser=userservice.selectOne( sysUser );

        System.out.println( "显示认证的内容··········"+newUser.getLoginName()+newUser.getPassword() );
        System.out.println( "这个是看看认证时候存储的是什么"+newUser.toString() );
        if (newUser==null)
        {
            return null;
        }

        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");
    }




}
