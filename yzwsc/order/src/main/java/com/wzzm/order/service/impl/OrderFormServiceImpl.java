package com.wzzm.order.service.impl;
import com.alibaba.fastjson.JSON;

import com.wzzm.order.dao.OrderFormDao;
import com.wzzm.order.dao.ShopcartDao;
import com.wzzm.order.pojo.GoodsForm;
import com.wzzm.order.pojo.OrderForm;
import com.wzzm.order.service.OrdeFomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service("order")
public class OrderFormServiceImpl implements OrdeFomService {

    @Resource
    private OrderFormDao ofd;

    public OrderFormDao getOfd() {
        return ofd;
    }

    public void setOfd(OrderFormDao ofd) {
        this.ofd = ofd;
    }
    @Resource
    private ShopcartDao scd;
    public ShopcartDao getScd() {
        return scd;
    }

    public void setScd(ShopcartDao scd) {
        this.scd = scd;
    }




    /**
     * 获取要添加到购物车的商品的信息
     * @param gf
     * @return
     */
    @Override
    public GoodsForm seleinfo(GoodsForm gf) {
        return scd.seleinfo(gf);
    }

    @Override
    public List<OrderForm> selall() {
        return ofd.selall();
    }

    @Override
    public String selall1() {

        List<OrderForm> selall = selall();
        List<GoodsForm> goo = new ArrayList<GoodsForm>();
        GoodsForm gi = new GoodsForm();
        if(selall != null){
        for (OrderForm gid:selall
             ) {
            gi.setGid(gid.getGoodid());

            GoodsForm go = ofd.selall1(gi);
           goo.add(go);
        }
            return JSON.toJSONString(goo);
        }else{
            return "空的";
        }
    }

    @Override
    public List<OrderForm> selobi(OrderForm stat){
        return ofd.selobii(stat);
    }

    @Override
    public String selobi1(OrderForm stat) {
        List<OrderForm> selobi = selobi(stat);
        List<GoodsForm> goo = new ArrayList();
        GoodsForm gi = new GoodsForm();
        if(selobi != null){
            for (OrderForm gid:selobi
                 ) {
                gi.setGid(gid.getGoodid());
               GoodsForm se = ofd.selall1(gi);
                goo.add(se);
            }
            return JSON.toJSONString(goo);
        }else{
            return "空的";
        }
    }


    @Override
    public String  insorder(GoodsForm gsf) {

        if(gsf.getExt1() <= seleinfo(gsf).getExt1()){
            return "库存不够";
        }

            ofd.insorder(gsf);
        return "库存不够";
     }
}


