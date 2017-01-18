package com.ydb.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ligeng on 17/1/17.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("MyInterceptor executing");
        // 是否登录
        // URL鉴权
        // 非法访问后台URL，强行踢下线。
        // 敏感词过滤
        return  true;
    }
}
