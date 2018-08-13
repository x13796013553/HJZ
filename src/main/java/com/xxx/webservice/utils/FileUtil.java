package com.xxx.webservice.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileUtil {

    /**
     * 2 * 单文件上传 3 * @param file 4 * @param request 5 * @return 6 * @throws
     * IllegalStateException 7 * @throws IOException 8 * @throws JSONException 9
     */
    public static Map simUpload(String inputPath, MultipartFile file, HttpServletRequest request, String requestPath) throws Exception {
        if (!file.isEmpty()) {
            String path = request.getSession().getServletContext().getRealPath(inputPath);
            // 定义文件
            File parent = new File(path);
            if (!parent.exists())
                parent.mkdirs();

            HashMap<String, Object> map = new HashMap<String, Object>();

            String oldName = file.getOriginalFilename();

            long size = file.getSize();

            // 使用TmFileUtil文件上传工具获取文件的各种信息
            // 优化文件大小
            String sizeString = countFileSize(size);
            // 获取文件后缀名
            String ext = getExtNoPoint(oldName);
            // 随机重命名，10位时间字符串
            String newFileName = IDUtils.genImageName();

            String url = inputPath + "/" + newFileName + oldName;

            // 文件传输，parent文件
            file.transferTo(new File(parent, newFileName + oldName));

            map.put("oldname", oldName);// 文件原名称
            map.put("ext", ext);
            map.put("size", sizeString);
            map.put("name", newFileName);// 文件新名称
            map.put("url", requestPath + "/" + newFileName + oldName);
            map.put("localUrl",url);

            map.put("status", "1");
            // 返回map
            return map;
        } else {
            return null;
        }
    }

    // 删除文件
    public static Integer deleteFile(String path, HttpServletRequest request) {
        if(path == null) {
            path = "";
        }
        String realPath = request.getSession().getServletContext().getRealPath("");
        realPath = realPath.replace("/", "\\"); // 数据库中取出的路径转换成真实路径
        File file = new File(realPath + path);
        boolean b;
        if (file.exists() && file.isFile()) {
            b = file.delete();
            if (b == true) {
                // 删除成功返回1
                return 1;
            } else {
                // 删除失败返回-2
                return -2;
            }
        }
        // 文件不存在，返回-1
        return -1;
    }

    // 优化文件大小

    public static String countFileSize(long size) {
        float fsize = size;
        String fileSizeString;
        if (fsize < 1024) {
            fileSizeString = String.format("%.2f", fsize) + "B"; // 2f表示保留两位小数
        } else if (fsize < 1048576) {
            fileSizeString = String.format("%.2f", fsize / 1024) + "KB";
        } else if (fsize < 1073741824) {
            fileSizeString = String.format("%.2f", fsize / 1024 / 1024) + "MB";
        } else if (fsize < 1024 * 1024 * 1024) {
            fileSizeString = String.format("%.2f", fsize / 1024 / 1024 / 1024) + "GB";
        } else {
            fileSizeString = "0B";
        }
        return fileSizeString;
    }

    // 获取文件后缀
    public static String getExtNoPoint(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 多文件上传
     */
    public static String uploadFiles(HttpServletRequest request){
        List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                    return "1";
                } catch (Exception e) {
                    stream =  null;
                    return "You failed to upload " + i + " =>" + e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " becausethe file was empty.";
            }
        }
        return "upload successful";
    }
}
