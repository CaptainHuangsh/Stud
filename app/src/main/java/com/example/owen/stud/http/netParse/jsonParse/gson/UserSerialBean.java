package com.example.owen.stud.http.netParse.jsonParse.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by owen on 2017/5/23.
 */

public class UserSerialBean {
    //@SerializedName注解Bean类，有效的增加了代码的可读性
    private String id;

    @SerializedName("n")
    private String userName;

    @SerializedName("p")
    private String password;

    @SerializedName("s")
    private String  sex;
}
