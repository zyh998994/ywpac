package com.wzzm.cart.service.impl;


import com.wzzm.cart.dao.ShopcartDao;
import com.wzzm.cart.pojo.GoodsForm;
import com.wzzm.cart.pojo.Shopcart;
import com.wzzm.cart.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SCSI")
public class ShopcartServiceImpl implements ShopcartService {
    @Autowired
    private ShopcartDao shop;

    public ShopcartDao getShop() {
        return shop;
    }

    public void setShop(ShopcartDao shop) {
        this.shop = shop;
    }

    /**
     * 获取要添加到购物车的商品的信息
     * @param gf
     * @return
     */
    @Override
    public GoodsForm seleinfo(GoodsForm gf) {

        return shop.seleinfo(gf);
    }

    /**
     * 添加到购物车
     * @param goodf 商品信息
     * @param num   同一商品的订单数量
     * @return
     */
    @Override
    public String inseinfo(GoodsForm goodf, int num, Shopcart sc) {
       try {
            sc.setShopid(0);
            if(seleinfo(goodf).getGstate() == 1){
                sc.setGoodid(seleinfo(goodf).getGid());
            }else {
                return "该商品已经下架";
            }
            if(num < 1){
                return "添加到购物车商品数量小于1";//添加到购物车商品数量小于1
            }else if(num >= seleinfo(goodf).getExt1()){
                return "添加到购物车商品数量大于库存";//添加到购物车商品数量大于库存
            }else {
                sc.setShopnum(num);
            }
            int judge = shop.inserjudge(sc);
            if(judge > 0){
                return "添加成功，请到购物车查看";
            }else {
                return "添加失败";
            }
       }catch (Exception e){
            return "数据异常，空指针或者没有数据";
       }
    }

    @Override
    public String updaorderinfo(Shopcart sc, GoodsForm goodf, int num) {

        try {
            sc.setShopid(seleinfo(goodf).getGid());
            if(num < 1){
                return "添加到购物车商品数量小于1";
            }else if(num > (seleinfo(goodf).getExt1() - shop.seleShop(sc).getShopid())){
                return "添加到购物车商品数量大于库存";
            }else {
                sc.setShopnum(shop.seleShop(sc).getShopnum() + num);
            }
            int judge = shop.updateorderinfo(sc);
            if(judge > 0){
                return "添加成功";
            }else {
                return "添加失败";
            }
        }catch (Exception e){
            return "空指针或数据异常";
        }

    }

    @Override
    public Object judge(Shopcart sc, GoodsForm goodf, int num) {
        System.out.println(123);
        System.out.println(seleinfo(goodf).getGid());
        sc.setGoodid(seleinfo(goodf).getGid());
        if(shop.seleShop(sc) != null){
            return updaorderinfo(sc, goodf, num);
        }else {
           return inseinfo(goodf, num, sc);
        }
    }

    @Override
    public String updaShopnum(Shopcart sc, String choose) {
        System.out.println(1);
        try {
            GoodsForm gf = new GoodsForm();
            gf.setGid(sc.getGoodid());

           /* System.out.println(gf.getGid());
            System.out.println(seleinfo(gf).getExt1());*/

            switch (choose){
                case "y":
                    System.out.println(sc.getShopnum() + "--" + seleinfo(gf).getExt1());
                    if((shop.seleShop(sc).getShopnum() + 1) > seleinfo(gf).getExt1()){
                        sc.setShopnum(shop.seleShop(sc).getShopnum()) ;
                    }else {
                        sc.setShopnum(shop.seleShop(sc).getShopnum() + 1);
                    }
                    break;
                case "n":
                    if((shop.seleShop(sc).getShopnum() - 1) < 1){
                        sc.setShopnum(1) ;
                    }else {
                        sc.setShopnum(shop.seleShop(sc).getShopnum() - 1);
                    }
                    break;
                default:
                    break;
            }
            int judge = shop.updateorderinfo(sc);
            if(judge > 0){
                return "修改成功";
            }else {
                return "修改失败";
            }
        }catch (Exception e){
            return "参数错误";
        }
    }


}
