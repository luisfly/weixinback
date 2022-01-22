package com.example.weixinback.Entity;

import java.io.Serializable;
import java.util.Date;

public class FileList implements Serializable {

    private int ID;
    private String filename;
    private String filetype;
    private Date createDate;
    private String createUser;
    private int parentID;
    private int tag;


}
