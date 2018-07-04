package com.cloudy.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2018/7/4.
 */
public class MyRealm1 implements Realm {

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        if (!"zhang".equals(username)) {
            throw new UnknownAccountException();    // 如果用户名错误
        }
        if (!"123".equals(password)) {
            throw new IncorrectCredentialsException();  // 密码错误
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
