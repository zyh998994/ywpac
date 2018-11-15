package com.wzzm.cart.service;

import com.wzzm.cart.pojo.GoodsForm;
import com.wzzm.cart.pojo.Shopcart;

public interface ShopcartService {
    /**
     * 获取添加到购物车商品的信息
     * @param gf
     * @return
     */
    GoodsForm seleinfo(GoodsForm gf);

    /**
     * 添加商品到购物车
     * @param goodf 商品信息
     * @param num   同一商品的订单数量
     * @return
     */

    String inseinfo(GoodsForm goodf, int num, Shopcart sc);

    /**
     * 修改数量
     * @param sc
     * @return
     */
    String updaorderinfo(Shopcart sc, GoodsForm goodf, int num);

    /**
     * 判断用户要添加到购物车的东西
     * @param sc
     * @param goodf
     * @param num
     * @return
     */
    Object judge(Shopcart sc, GoodsForm goodf, int num);

    /**
     * 增加或减少数量购物车里的数量
     * @param sc
     * @param choose
     * @return
     */
    String updaShopnum(Shopcart sc, String choose);
}
