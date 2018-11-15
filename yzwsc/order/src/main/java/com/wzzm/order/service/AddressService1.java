package com.wzzm.order.service;

import com.wzzm.order.pojo.AddressForm;


public interface AddressService1 {
    /**
     *
     *
     * @return
     */
    String seladd(AddressForm ad);
    /**
     * 添加地址
     * @return
     */

    String address(AddressForm arf);
    /**
     * 查找所有的地址
     * @param ad
     * @return
     */
    String selall(AddressForm ad);

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
    String delsite(AddressForm ad);
}
