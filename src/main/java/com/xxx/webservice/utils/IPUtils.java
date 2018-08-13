package com.xxx.webservice.utils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class IPUtils {

    public static Map<String, Double> getLngAndLat(String address) {
        Map<String, Double> map = new HashMap<String, Double>();
        String url = "http://api.map.baidu.com/geocoder/v2/?address=" + address + "&output=json&ak=F454f8a5efe5e577997931cc01de3974";
        String json = loadJSON(url);
        JSONObject obj = JSONObject.fromObject(json);
        if (obj.get("status").toString().equals("0")) {
            double lng = obj.getJSONObject("result").getJSONObject("location").getDouble("lng");
            double lat = obj.getJSONObject("result").getJSONObject("location").getDouble("lat");
            map.put("lng", lng);
            map.put("lat", lat);
            //System.out.println("经度："+lng+"---纬度："+lat);
        } else {
            //System.out.println("未找到相匹配的经纬度！");
        }
        return map;
    }

    public static String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL oracle = new URL(url);
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return json.toString();
    }


    // 获取域名ip及端口号
    public static URI getIP(URI uri) {
        URI effectiveURI = null;

        try {
            // URI(String scheme, String userInfo, String host, int port, String
            // path, String query,String fragment)
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI;
    }

    public static void main(String[] args) {
        /*把代码中的ak值（红色字部分）更改为你自己的ak值，在百度地图API中注册一下就有。
        调用方式：*/

        Map<String, Double> map = getLngAndLat("哈尔滨市平房区联盟大街49号");
        System.out.println("经度：" + map.get("lng") + "---纬度：" + map.get("lat"));
    }

}
