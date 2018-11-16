package com.wzzm.cart.service;


import com.wzzm.cart.pojo.ResultBean;
import com.wzzm.cart.pojo.Shopcart;

import java.util.List;

public interface ShowShopCartService {
    /**
     * 展示购物车全部商品
     * @return
     */
    ResultBean<List<Shopcart>> shoplist(Shopcart sc);

    /**
     * 删除
     * @param sc
     * @return
     */
    ResultBean<String> deleshopinfo(Shopcart sc);



}
