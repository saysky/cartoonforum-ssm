package com.example.forum.config.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.forum.core.sys.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @author example
 */
@Component
public class UserSecurityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws IOException {
        //请求的url
        String requestURL = request.getRequestURI();
        System.out.println("请求的url :" + requestURL);
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            // 如果没有登录, 进入登录流程
            response.sendRedirect("/login");
            return false;
        }

        //从session里读取当前用户的权限URL列表
        Set<String> urls = (Set<String>) request.getSession().getAttribute("permissionUrls");
        if (urls.contains(requestURL)) {
            return true;
        }

        //没有权限
        if (isAjax((HttpServletRequest) request)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = response.getWriter();
            Map<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "没有权限访问");
            writer.write(JSONObject.toJSONString(map));
        } else {
            response.sendRedirect("/403");
        }

        return false;
    }


    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}

