package top.hechaopeng.test;

import top.hechaopeng.utils.Base64Util;
import top.hechaopeng.utils.FileUtil;
import top.hechaopeng.utils.HttpUtil;
import java.net.URLEncoder;

/**
 * 人脸探测
 */
public class FaceDetect {


    public static String detect() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v1/detect";
        try {
            // 本地文件路径
            String filePath = "D:\\pic\\IMG_20180419_170048.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String param = "max_face_num=" + 5 + "&face_fields=" + "age,beauty,expression,faceshape,gender,glasses,landmark,race,qualities" + "&image=" + imgParam;

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.2da9ce31b96affbea67dcb890caa3ad0.2592000.1526718572.282335-10860434";

            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        FaceDetect.detect();
    }
}