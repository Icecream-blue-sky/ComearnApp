package com.example.team.comearnapp.bean;

import java.io.Serializable;

/**
 * Created by 邹特强 on 2018/4/2.
 * 接受登录时服务器返回的信息的javabean类
 */

public class LoginResponseData implements Serializable {
    /**
     * 用户信息javabean类
     */
    private User user;
    /**
     * 返回给前端的token, 用于请求验证
     */
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
