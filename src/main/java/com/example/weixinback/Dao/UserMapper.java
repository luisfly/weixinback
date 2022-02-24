package com.example.weixinback.Dao;

import com.example.weixinback.Entity.FileList;
import com.example.weixinback.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public boolean insert(User user);
    public boolean delete(String userNO);
    public boolean update(User user);
    public User getById(String userNO);

    public User getByWeiXinNO(String weiXinNO);
}
