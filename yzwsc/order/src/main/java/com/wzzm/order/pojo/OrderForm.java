package com.wzzm.order.pojo;

import java.util.Date;

/**
 *订单表
 */
public class OrderForm {
    private Integer oid;    //订单ID
    private String onum;    //订单数量
    private Integer uid;    //微信用户ID
    private Integer goodid;   //商品ID
    private Date odatetime; //订单产生时间
    private Integer aid;    //地址ID
    private Integer state;  //状态 0.代付款 1.代发货 2.待收货 3.待评价
    private String bianhao;//订单编号

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }
    public String getBiavnhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }



    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


    public Date getOdatetime() {
        return odatetime;
    }

    public void setOdatetime(Date odatetime) {
        this.odatetime = odatetime;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
}
