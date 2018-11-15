package com.wzzm.order.dao;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wzzm.order.pojo.GoodsForm;
import com.wzzm.order.pojo.OrderForm;
import com.wzzm.order.pojo.Shopcart;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
@EnableSwagger
@MapperScan(value = "com.wzzm.order.dao.OrderFormDao")
public interface OrderFormDao {

    /**
     *  根据购物车的订单
     *  添加到订单表
     * @return
     */

    List<Shopcart> selorder(Shopcart shopid);


    /**
     *增加订单
     * @return
     */
    int insorder(GoodsForm gsf);
    /**
     *  订单展示
     * @return
        */


    List<OrderForm> selall();

    /**
     * 根据订单id展示全部商品
     * @return
     */

    GoodsForm selall1( GoodsForm gi);

    /**
     * 跟据状态显示
     * @return
     */
     List<OrderForm> selobii(OrderForm state);

    /**
     * 修改订单
     * @param ord
     * @return
     */
    OrderForm updorder(OrderForm ord);

}
