package top.hechaopeng.test;

import top.hechaopeng.utils.Base64Util;
import top.hechaopeng.utils.FileUtil;
import top.hechaopeng.utils.HttpUtil;

import java.net.URLEncoder;

/**
 * 人脸查找——识别
 */
public class Identify {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String identify() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/identify";
        try {
             // 本地文件路径
            String filePath = "D:\\pic\\IMG_20180419_170048.jpg";
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");

            String filePath2 = "D:\\pic\\IMG_20180419_170049.jpg";
            byte[] imgData2 = FileUtil.readFileByBytes(filePath2);
            String imgStr2 = Base64Util.encode(imgData2);
            String imgParam2 = URLEncoder.encode(imgStr2, "UTF-8");

            String param = "group_id=" + "disappearance_children" + "&user_top_num=" + "1" + "&face_top_num=" + "1" + "&images=" + imgParam;

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
        Identify.identify();
    }
}