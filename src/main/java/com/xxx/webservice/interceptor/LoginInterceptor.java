package com.xxx.webservice.interceptor;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    // 访问之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            return true;
        }


        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final Method method = handlerMethod.getMethod();
        final Class<?> clazz = method.getDeclaringClass();
        if (clazz.isAnnotationPresent(Auth.class) || method.isAnnotationPresent(Auth.class)) {
            if (handlerSession(request) == false) {
                response.sendRedirect("/login");
                return false;
            } else {
                return true;
            }
        }

        return true;

    }

    // 检查当前用户是否登录--检查Cookie中是否有值
    public boolean handlerSession(HttpServletRequest request) {
        // 获取Cookie
        Cookie[] cookies = request.getCookies();

        // 先判断cookies是否为空
        if (null == cookies) {
            // 返回到登录页面
            return false;
        } else {
            if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                //如果是ajax请求响应头会有，x-requested-with
                return true;
                //response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
            }

            String userId = null;
            String password = null;
            // cookies中不为空，则遍历Cookie，看是否有Cookie叫userId
            for (Cookie cookie : cookies) {
                userId = cookie.getName();
                password = cookie.getValue();
                if ("userId".equalsIgnoreCase(userId)) {
                    if (password == null || "".equalsIgnoreCase(password)) {
                        // 用户未登录，返回到登录页面
                        return false;
                    } else {
                        // 有值，直接跳转到主页面，就不用登录了
                        return true;
                    }
                }
            }
            // 用户未登录，返回到登录页面
            return false;
        }
    }

}
