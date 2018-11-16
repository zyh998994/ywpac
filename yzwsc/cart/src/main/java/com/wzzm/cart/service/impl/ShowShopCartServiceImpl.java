package com.wzzm.cart.service.impl;


import com.wzzm.cart.dao.ShopcartDao;
import com.wzzm.cart.pojo.ResultBean;
import com.wzzm.cart.pojo.Shopcart;
import com.wzzm.cart.service.ShowShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SSCSI")
public class ShowShopCartServiceImpl implements ShowShopCartService {
    @Autowired
    private ShopcartDao scd;
   /* public ShopcartDao getScd() {
        return scd;
    }
    public void setScd(ShopcartDao scd) {
        this.scd = scd;
    }*/


    @Override
    public ResultBean<List<Shopcart>> shoplist(Shopcart sc) {
        ResultBean resultBean = new ResultBean();
        if(sc == null){
            return resultBean.nulls("sc");
        }
        List<Shopcart> shop = scd.selescilist(sc);
        if(shop.size() == 0){
            return resultBean.error(null);
        }
        return resultBean.success(shop);
    }

    @Override
    public ResultBean<String> deleshopinfo(Shopcart sc) {
        ResultBean resultBean = new ResultBean();
        if(sc == null){
            return resultBean.nulls("sc");
        }
        int dele = scd.deleshopcart(sc);
        if(dele == 0){
            return resultBean.error("添加失败");
        }
        return resultBean.success(dele);
    }


}
