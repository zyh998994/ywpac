package com.wzzm.cart.dao;


import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wzzm.cart.pojo.GoodsForm;
import com.wzzm.cart.pojo.Shopcart;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
@EnableSwagger
@MapperScan(value = "com.wzzm.cart.dao.ShopcartDao")
public interface ShopcartDao {
    /**
     * 获取商品信息，和商家id
     * @param gf
     * @return
     */
    GoodsForm seleinfo(GoodsForm gf);



    /**
     * 新增商品到购物车
     * @param sc
     * @return
     */
    int inserjudge(Shopcart sc);

    /**
     * 修改前查询
     * @return
     */
    Shopcart seleShop(Shopcart sc);

    /**
     * 修改订单数量
     * @param sc
     * @return
     */
    int updateorderinfo(Shopcart sc);

    /**
     * 展示购物车的商品
     * @param sc
     * @return
     */
    List<Shopcart> selescilist(Shopcart sc);

    /**
     * 删除数据库中的内容
     * @param sc
     * @return
     */
    int deleshopcart(Shopcart sc);


}
