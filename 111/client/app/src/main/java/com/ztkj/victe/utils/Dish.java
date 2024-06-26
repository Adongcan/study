package com.ztkj.victe.utils;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Dish {
    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String dish(String filePath,String accessToken) {
        // 请求url
//        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v2/dish";
//        String url = "https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic";
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
            // 本地文件路径
//            String filePath = "[本地文件路径]";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util2.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
//            String accessToken = "[调用鉴权接口获取的token]";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
//            Log.e("TAG",result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String add(String filePath,String userid,String taccessToken,String user_info) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";

        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util2.encode(imgData);
//            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("group_id", "group_repeat");
            map.put("user_id", userid);
            map.put("image_type", "BASE64");
            map.put("user_info", user_info);
//            map.put("liveness_control", "NORMAL");
//            map.put("image_type", "FACE_TOKEN");
//            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = taccessToken;

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String faceSearch(String filePath,String taccessToken) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util2.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("liveness_control", "NORMAL");
            map.put("group_id_list", "group_repeat");
            map.put("image_type", "BASE64");
//            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken =taccessToken;

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
