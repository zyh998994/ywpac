package com.wzzm.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.wzzm.order.dao.AddressFormDao;
import com.wzzm.order.pojo.AddressForm;
import com.wzzm.order.pojo.ResultBean;
import com.wzzm.order.service.AddressService1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("address")
public class AddressServiceimpl implements AddressService1 {
   @Resource
    private AddressFormDao arf;

    public AddressFormDao getArf() {
        return arf;
    }

    public void setArf(AddressFormDao arf) {
        this.arf = arf;
    }

    @Override
    public ResultBean<String> seladd(AddressForm ad) {
        ResultBean resultBean = new ResultBean();
        if(ad==null){return resultBean.nulls("ad");}
        AddressForm seladd = arf.seladd(ad);

        if(seladd != null) {
           // return JSON.toJSONString(seladd);
            return resultBean.success(seladd);
        }else{
            return resultBean.error("请填写地址");

        }
    }

    /**
     * 所有地址
     * @param ada
     * @return
     */
    @Override
    public ResultBean<String> selall(AddressForm ada) {
        ResultBean resultBean = new ResultBean();
        if(ada==null){return resultBean.nulls("ada");}
        List<AddressForm> selall = arf.selall(ada);
        if(selall.size() == 0) {
           /// return JSON.toJSONString(selall);
            return resultBean.error(null);
        }else {
            return resultBean.success(selall);
        }
    }

    /**
     * gshu
     * @param ad
     * @return
     */
    @Override
    public int selsite(AddressForm ad) {

        return arf.selsite(ad);
    }

    @Override
    public ResultBean<String> delsite(AddressForm ad) {
        ResultBean resultBean = new ResultBean();
        if(ad==null){return resultBean.nulls("ad");}
        int delsite = arf.delsite(ad);
        if(delsite>0) {
            return resultBean.success("删除成功");
        }else{
            return resultBean.success("删除失败");
        }
    }

    @Override
    public ResultBean<String> address(AddressForm arf) {
        ResultBean resultBean = new ResultBean();
        if(arf==null){return resultBean.nulls("arf");}
        if(selsite(arf)<=3){
            String address = arf.getAddress();
            String phone = arf.getPhone();
            String postcode = arf.getPostcode();
            if(address.length()>50){
                return resultBean.success("地址字数达到上限");
            }else if(phone.length() != 11 ){
                return resultBean.success("手机号错误");
            }else {
                return resultBean.success("成功");
            }
        }else{
            return resultBean.success("对不起，最大地址数为3，请先删除");
        }


    }



}
