package com.example.configuration;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.shiro_roleAndPermission;
import com.example.service.Shiro_authorize;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class shiro_realm extends AuthorizingRealm {

    @Autowired
    private Shiro_authorize shiro_authorize;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        List<String> roleString = JSONObject.parseArray(shiro_authorize.authorizePassword(username).getRole()).toJavaList(String.class);
        List<String> permissionString = JSONObject.parseArray(shiro_authorize.authorizePassword(username).getPermission()).toJavaList(String.class);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(roleString);
        authorizationInfo.addStringPermissions(permissionString);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String user_name = token.getPrincipal().toString();
        shiro_roleAndPermission student = shiro_authorize.authorizePassword(user_name);
        if ( student == null) {
            return null;
        }
        System.out.println("密码是"+token.getCredentials());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user_name,student.getPassword(),getName());
        return authenticationInfo;
    }
}
