package com.wzzm.order.pojo;

import javax.xml.crypto.Data;

/**
 *商品表
 */
public class GoodsForm {
    private Integer gid;    //商品ID
    private String gname;   //商品名
    private float gprice;   //商品价格
    private String ginfo;   //商品信息
    private String gimage;  //商品展示图片（上）
    private String ginfoimage;  //商品信息图片
    private Data gdate; //上架时间
    private Integer sid;    //商家ID
    private Integer gstate; //商品状态
    private Integer tid;    //种类ID
    private String specs1;  //
    private Integer specs2; //
    private String specs3;  //
    private String specs4;  //
    private Integer ext1; //库存
    private String ext2;
    private String exts3;

    public String getSpecs1() {
        return specs1;
    }

    public void setSpecs1(String specs1) {
        this.specs1 = specs1;
    }

    public Integer getSpecs2() {
        return specs2;
    }

    public void setSpecs2(Integer specs2) {
        this.specs2 = specs2;
    }

    public String getSpecs3() {
        return specs3;
    }

    public void setSpecs3(String specs3) {
        this.specs3 = specs3;
    }

    public String getSpecs4() {
        return specs4;
    }

    public void setSpecs4(String specs4) {
        this.specs4 = specs4;
    }

    public Integer getExt1() {
        return ext1;
    }

    public void setExt1(Integer ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExts3() {
        return exts3;
    }

    public void setExts3(String exts3) {
        this.exts3 = exts3;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public float getGprice() {
        return gprice;
    }

    public void setGprice(float gprice) {
        this.gprice = gprice;
    }

    public String getGinfo() {
        return ginfo;
    }

    public void setGinfo(String ginfo) {
        this.ginfo = ginfo;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

    public String getGinfoimage() {
        return ginfoimage;
    }

    public void setGinfoimage(String ginfoimage) {
        this.ginfoimage = ginfoimage;
    }

    public Data getGdate() {
        return gdate;
    }

    public void setGdate(Data gdate) {
        this.gdate = gdate;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGstate() {
        return gstate;
    }

    public void setGstate(Integer gstate) {
        this.gstate = gstate;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }
}
