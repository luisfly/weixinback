package com.example.weixinback.Dao;

import com.example.weixinback.Entity.FileList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileListMapper {

    public boolean insert(FileList file);
    public boolean delete(int id);
    public boolean update(FileList file);
    public FileList getById(int id);
}
