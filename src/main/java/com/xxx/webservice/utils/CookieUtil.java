package com.xxx.webservice.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie工具类
 *
 * @author Administrator
 */

public class CookieUtil {

    public static Cookie[] getCookies() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie[] c = request.getCookies();
        return c;
    }

    public static void showCookie() {
        Cookie[] c = getCookies();
        for (int i = 0; i < (c == null ? 0 : c.length); i++) {
            System.out.println("一条cookie____  name: " + c[i].getName() + "  || value: " + c[i].getValue());
        }
    }

    public static void saveCookie(Cookie cookie) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.addCookie(cookie);
    }

    /**
     * 添加cookie
     *
     * @param name
     */
    public static void addCookie(String name, String values) {
        try {

            String v = values;

            Cookie cookie = new Cookie(name, v);
            cookie.setPath("/");
            cookie.setMaxAge(3600);// 设置保存cookie最大时长
            saveCookie(cookie);

        } catch (Exception e) {
            System.out.println(" -------添加cookie 失败！--------" + e.getMessage());
        }
    }


    /**
     * 获取cookie
     *
     * @param name
     * @return
     */
    public static String getCookie(String name) {
        try {

            Cookie[] cookies = getCookies();

            for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
                if ((name).equalsIgnoreCase(cookies[i].getName())) {
                    return URLDecoder.decode(cookies[i].getValue(), "UTF-8");
                }
            }

        } catch (Exception e) {
            System.out.println(" --------获取String cookie 失败--------   " + e.getMessage());
        }
        return null;
    }

    /**
     * 删除cookie
     *
     * @param name
     */
    public static String removeCookie(String name) {
        try {

            Cookie[] cookies = getCookies();

            for (int i = 0; i < (cookies == null ? 0 : cookies.length); i++) {
                if ((name).equalsIgnoreCase(cookies[i].getName())) {

                    Cookie cookie = new Cookie(name, "");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);// 设置保存cookie最大时长为0，即使其失效
                    saveCookie(cookie);
                }
            }
            return "1";
        } catch (Exception e) {
            return " -------删除cookie失败！--------" + e.getMessage();
        }
    }

}
