package com.xxx.frame.Controller.BackStageManagement;

import com.xxx.frame.Entity.Model.ResultModel;
import com.xxx.frame.Util.UpLoadFileUtil;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequestMapping("Manager")
@RestController
public class FileController {

    @RequestMapping("/upLoadFile")
    private ResultModel upLoadFile(HttpServletRequest request,
                                   HttpServletResponse response){
        // 转型为MultipartHttpRequest(重点的所在)这个就是上面ajax中提到如果直接访问此接口而不加"/"，此转型就会报错
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        return UpLoadFileUtil.fileUpload(file);
    }
}
