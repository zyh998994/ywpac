package com.wzzm.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.wzzm.order.dao.AddressFormDao;
import com.wzzm.order.pojo.AddressForm;
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
    public String seladd(AddressForm ad) {
        AddressForm seladd = arf.seladd(ad);
        if(seladd != null) {
            return JSON.toJSONString(seladd);
        }else{
            return "请填写收货地址";
        }
    }

    /**
     * 所有地址
     * @param ada
     * @return
     */
    @Override
    public String selall(AddressForm ada) {
        List<AddressForm> selall = arf.selall(ada);

        return JSON.toJSONString(selall);
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
    public String delsite(AddressForm ad) {
        int delsite = arf.delsite(ad);
        if(delsite>0) {
            return "删除成功";
        }else{
            return "删除失败";
        }
    }

    @Override
    public String address(AddressForm arf) {
        if(selsite(arf)<=3){
            String address = arf.getAddress();
            String phone = arf.getPhone();
            String postcode = arf.getPostcode();
            if(address.length()>50){
                return "地址字数达到上限";
            }else if(phone.length() != 11 ){
                return "手机号错误";
            }else {
                return "成功";
            }
        }else{
            return "对不起，最大地址数为3，请先删除";
        }


    }



}
