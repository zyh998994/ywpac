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
    public String deleshopinfo(Shopcart sc) {
         try {

             if(scd.deleshopcart(sc) > 0){
                 return "删除成功";
             }else {
                 return "删除失败";
             }
         }catch (Exception e){
             return "参数错误";
         }
    }


}
