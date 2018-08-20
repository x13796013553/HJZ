package com.xxx.webservice.controller.admin;

import com.xxx.webservice.utils.ConvertUtil;
import com.xxx.webservice.utils.FileUtil;
import com.xxx.webservice.utils.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {

    @RequestMapping("/file")
    public String showFilePage() {
        return "admin/addFile";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Map uploadFile(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request) {
        Map map = new HashMap();
        Map mapAdd = new HashMap();
        try {
            // 上传新文件
            for (int i = 0; i < file.length; i++) {
                String nowString = ConvertUtil.getNowString("yyyy-MM-dd");
//                mapAdd = FileUtil.simUpload("/WEB-INF/classes/static/admin/upload/file/" + nowString, file[i], request,
//                        IPUtils.getIP(URI.create(request.getRequestURL().toString())) + "/static/admin/upload/file/" + nowString);
                mapAdd = FileUtil.simUpload("/WEB-INF/classes/static/admin/upload/file/" + nowString, file[i], request,
                        "/static/admin/upload/file/" + nowString);
            }
            if(file.length == 1){
                map.put("titleImage",mapAdd.get("url"));
            }
            map.put("status", "1");
            return map;
        } catch (Exception e) {
            map.put("msg", "上传出错了！！" + e.getMessage());
            System.out.println("上传出错了！！" + e.getMessage());
            return map;
        }
    }
}
