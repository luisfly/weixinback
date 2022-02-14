package com.example.weixinback.backcontrollers;

import com.example.weixinback.Dao.UserMapper;
import com.example.weixinback.Entity.User;
import com.example.weixinback.utils.CodeAndMsg;
import com.example.weixinback.utils.CustResponseEntity;
import com.example.weixinback.utils.UniformResponseHandler;
import com.example.weixinback.utils.UserDefinedException;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 获取用户的 controller
 */
@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserMapper mapper;

    @ResponseBody
    @PostMapping("/api/GetUser")
    public CustResponseEntity GetUser(@RequestBody JSONObject postData) {
        String userNO = postData.getAsString("WeiXinNO");

        User user = mapper.getByWeiXinNO(userNO);

        if (user == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse(user);
    }

    @ResponseBody
    @PostMapping("/api/GetByUserNO")
    public CustResponseEntity GetByUserNO(@RequestBody JSONObject postData) {
        String userNO = postData.getAsString("UserNO");

        User user = mapper.getById(userNO);

        if (user == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse(user);
    }

    @ResponseBody
    @PostMapping("/api/CreateUser")
    public CustResponseEntity CreateUser(@RequestBody JSONObject postData) {
        User user = new User();
        user.setUserName(postData.getAsString("UserName"));
        user.setUserNO(postData.getAsString("UserNO"));
        user.setWeiXinNO(postData.getAsString("WeiXinNO"));

        try {
            mapper.insert(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().indexOf("Duplicate entry", 0) != -1) {
                return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.REPEATERROR));
            }

        }

        return new UniformResponseHandler<>().sendSuccessResponse(user);
    }
}
