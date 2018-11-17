package com.wzzm.order.service;

import com.wzzm.order.pojo.AddressForm;
import com.wzzm.order.pojo.ResultBean;


public interface AddressService1 {
    /**
     *
     *
     * @return
     */
    ResultBean<String> seladd(AddressForm ad);
    /**
     * 添加地址
     * @return
     */

    ResultBean<String> address(AddressForm arf);
    /**
     * 查找所有的地址
     * @param ad
     * @return
     */
    ResultBean<String> selall(AddressForm ad);

    /**
     * 查找地址个数
     * @param ad
     * @return
     */
    int selsite(AddressForm ad);

    /**
     * 根据用户id和地址编号删除
     * @param ad
     * @return
     */
    ResultBean<String> delsite(AddressForm ad);
}
