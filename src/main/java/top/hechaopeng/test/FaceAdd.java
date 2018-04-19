package top.hechaopeng.test;

import top.hechaopeng.utils.Base64Util;
import top.hechaopeng.utils.FileUtil;
import top.hechaopeng.utils.HttpUtil;

import java.net.URLEncoder;

/**
 * 人脸注册
 */
public class FaceAdd {


    public static String add() {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v2/faceset/user/add";
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

            String param = "uid=" + "test_user_5" + "&user_info=" + "userInfo5" + "&group_id=" + "test_group_2" + "&images=" + imgParam + "," + imgParam2;

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
        FaceAdd.add();
    }
}