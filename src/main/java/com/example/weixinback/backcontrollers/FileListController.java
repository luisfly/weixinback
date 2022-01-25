package com.example.weixinback.backcontrollers;

import com.example.weixinback.Dao.FileListMapper;
import com.example.weixinback.Entity.FileList;
import com.example.weixinback.utils.CodeAndMsg;
import com.example.weixinback.utils.CustResponseEntity;
import com.example.weixinback.utils.UniformResponseHandler;
import com.example.weixinback.utils.UserDefinedException;
import org.springframework.beans.factory.annotation.Autowired;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;

/**
 * 获取文件列表的 controller
 */
@CrossOrigin("*")
@RestController
public class FileListController {

    @Autowired
    private FileListMapper mapper;

    @ResponseBody
    @PostMapping("/api/GetFileList")
    public CustResponseEntity GetFileList(@RequestBody JSONObject postData) {
        int id = postData.getAsNumber("ID").intValue();

        FileList filelist = mapper.getById(id);

        if (filelist == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse(filelist);
    }
}
