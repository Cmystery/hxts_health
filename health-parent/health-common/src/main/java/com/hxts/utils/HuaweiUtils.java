package com.hxts.utils;

import com.obs.services.ObsClient;
import com.obs.services.model.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.obs.services.model.SpecialParamEnum.ACL;

public class HuaweiUtils {


    //Access Key Id
    public static String ak = "3P3GNLNHJ6NATOKCJBMM";

    //Secret Access Key
    public static String sk = "A4X9sh1HLuDSxt9aR5bKNDl82uFwdVgMhbhBre8c";

    //桶名称
    public static String bucketName = "health-picture";

    // 终端节点访问Endpoint
    public static String endpoint = "obs.cn-east-2.myhuaweicloud.com";




    /**
     * 上传文件--流式
     *
     * @param fileName 上传文件名称
     * @param is       文件流
     * @return
     */
    public static String uploadFile(String fileName, InputStream is) throws IOException {
        ObsClient obsClient = null;
        try {
            obsClient = new ObsClient(ak, sk, endpoint);
            HeaderResponse response = obsClient.putObject(bucketName, fileName, is);
            //log.info(JSONObject.toJSONString(response));
            // 可选：调用成功后，记录调用成功的HTTP状态码和服务端请求ID
            int statusCode = response.getStatusCode();
            if (200 == statusCode) {
                String objectUrl = fileName;
                return objectUrl;
            }
        } finally {
            obsClient.close();
        }
        return null;
    }

    /**
     * 上传文件--字节数组
     *
     * @param fileName 上传文件名称
     * @param is       文件流
     * @return
     */
    public static boolean uploadFileByte(String fileName, byte[] is) {
        ObsClient obsClient = null;
        try {
            obsClient = new ObsClient(ak, sk, endpoint);
            HeaderResponse response = obsClient.putObject(bucketName, fileName, new ByteArrayInputStream(is));

            // 可选：调用成功后，记录调用成功的HTTP状态码和服务端请求ID
            int statusCode = response.getStatusCode();
            if (200 == statusCode) {
                return true;
            }
            obsClient.close();
        } catch (IOException e) {
            //log.info("文件上传失败：{}", e.getMessage(), e);
        }
        return false;
    }

    /**
     * 删除对象
     * @param
     * @param fileName  需要删除的对象全名 例："site/20190817/localFile.sh"
     * @return
     */
    public DeleteObjectResult deleteObject(String fileName) {
        ObsClient obsClient = new ObsClient(ak, sk, endpoint);
        return obsClient.deleteObject(bucketName, fileName);
    }


}
