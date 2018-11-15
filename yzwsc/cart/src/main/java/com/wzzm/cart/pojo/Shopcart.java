package com.wzzm.cart.pojo;

/**
 *购物车表
 */
public class Shopcart {
    private Integer shopid; //
    private Integer uuid;   //
    private Integer goodid; //
    private Integer shopnum;    //
    private GoodsForm gf;
    private StoreForm sf;
    public GoodsForm getGf() {
        return gf;
    }

    public void setGf(GoodsForm gf) {
        this.gf = gf;
    }

    public StoreForm getSf() {
        return sf;
    }

    public void setSf(StoreForm sf) {
        this.sf = sf;
    }


    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getShopnum() {
        return shopnum;
    }

    public void setShopnum(Integer shopnum) {
        this.shopnum = shopnum;
    }
}
