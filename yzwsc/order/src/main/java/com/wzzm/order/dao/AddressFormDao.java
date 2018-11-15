package com.wzzm.order.dao;


import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wzzm.order.pojo.AddressForm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
@SpringBootApplication
@EnableSwagger
@MapperScan(value = "com.wzzm.order.dao.AddressFormDao")
public interface AddressFormDao {


     /**
     * 根据唯一标识和默认来判断
     *查找
     * @return
     */
   AddressForm seladd(AddressForm ad);

    /**
     * 查找所有的地址
     * @param ad
     * @return
     */
   List<AddressForm> selall(AddressForm ad);

    /**
     * 查找地址个数
     * @param ad
     * @return
     */
   int selsite(AddressForm ad);
    /**
     * 添加地址
     * @param addrs
     * @return
     */
    int address(AddressForm addrs);

    /**
     * 根据用户ID和地址id删除
     * @param addrs
     * @return
     */
    int delsite(AddressForm addrs);
}
