package com.wzzm.order.pojo;

/**
 * 商家表
 */
public class StoreForm {
    private Integer sid;    //商家ID
    private String sname;   //商家名
    private String simage;  //商家头像

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSimage() {
        return simage;
    }

    public void setSimage(String simage) {
        this.simage = simage;
    }
}
