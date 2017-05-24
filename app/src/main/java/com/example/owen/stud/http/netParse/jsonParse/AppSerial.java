package com.example.owen.stud.http.netParse.jsonParse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by owen on 2017/5/7.
 */

public class AppSerial {

    private String id;
    @SerializedName("name")
    private String hname;
    @SerializedName("version")
    private String hversion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHversion() {
        return hversion;
    }

    public void setHversion(String hversion) {
        this.hversion = hversion;
    }

}
