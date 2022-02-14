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
        String userNO = postData.getAsString("UserNO");

        User user = mapper.getByWeiXinNO(userNO);

        if (user == null) {
            return new UniformResponseHandler<>().sendErrorResponse_UserDefined(new UserDefinedException(CodeAndMsg.SQLIDNOTEXIST));
        }

        return new UniformResponseHandler<>().sendSuccessResponse(user);
    }
}
