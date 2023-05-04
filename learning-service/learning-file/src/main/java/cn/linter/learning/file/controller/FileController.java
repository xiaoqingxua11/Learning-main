package cn.linter.learning.file.controller;

import cn.hutool.core.io.IoUtil;
import cn.linter.learning.common.entity.Result;
import cn.linter.learning.common.entity.ResultStatus;
import cn.linter.learning.file.service.FileService;
import com.alibaba.cloud.commons.lang.StringUtils;
import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 文件控制器
 *
 * @author wangxiaoyang
 * @date 2020/11/15
 */
@RestController
public class FileController {

    private final FileService fileService;

    private final MinioClient minioClient;

    public FileController(FileService fileService, MinioClient minioClient) {
        this.fileService = fileService;
        this.minioClient = minioClient;
    }

    @PostMapping("videos")
    public Result<String> uploadVideo(@RequestParam MultipartFile multipartFile) throws Exception {
        return Result.of(ResultStatus.SUCCESS, fileService.uploadVideo(multipartFile));
    }

    @PostMapping("cover-pictures")
    public Result<String> uploadCoverPicture(@RequestParam MultipartFile multipartFile) throws Exception {
        return Result.of(ResultStatus.SUCCESS, fileService.uploadCoverPicture(multipartFile));
    }

    @PostMapping("profile-pictures")
    public Result<String> uploadProfilePicture(@RequestParam MultipartFile multipartFile) throws Exception {
        return Result.of(ResultStatus.SUCCESS, fileService.uploadProfilePicture(multipartFile));
    }

    @PostMapping("work-file")
    public Result<String> uploadWorkFile(@RequestParam MultipartFile multipartFile) throws Exception {
        return Result.of(ResultStatus.SUCCESS, fileService.uploadWorkFile(multipartFile));
    }
    @GetMapping("download")
    public void queryCourse(@RequestParam("url")String url, @RequestParam("name")String name, HttpServletResponse response) {
        InputStream inputStream = null;
        try {
            if (StringUtils.isBlank(name)) {
                return;
            }
            // 获取文件对象
            GetObjectArgs build = GetObjectArgs.builder().bucket("work-file").object(url.substring(url.lastIndexOf("/") + 1)).build();
            inputStream = minioClient.getObject(build);
            // 获取绑定客户端的流
            ServletOutputStream out = null;
            try {
                out = response.getOutputStream();
                // 把输入流中的数据写入到输出流中
                IoUtil.copy(inputStream, out);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.flush();
                        out.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
