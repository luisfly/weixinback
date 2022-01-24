package com.example.weixinback.backcontrollers;

import com.example.weixinback.Dao.FileListMapper;
import com.example.weixinback.utils.CustResponseEntity;
import com.example.weixinback.utils.UniformResponseHandler;
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
        int ID = postData.getAsNumber("ID").intValue();

        System.out.println("ID:" + ID);

        return new UniformResponseHandler<>().sendSuccessResponse();
    }
}
