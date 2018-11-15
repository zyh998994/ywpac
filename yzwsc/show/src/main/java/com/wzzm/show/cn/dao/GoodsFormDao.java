package com.wzzm.show.cn.dao;

import com.mangofactory.swagger.plugin.EnableSwagger;
import com.wzzm.show.cn.pojo.GoodsForm;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@EnableSwagger
@MapperScan(value = "com.wzzm.show.cn.dao.GoodsFormDao")
public interface GoodsFormDao {

 /**
  * 根據商品名模糊查詢商品信息并分页显示
  * @return
  */
   List<GoodsForm> selfuzzy(@Param("gname") String gname);

    /**
     * 根据商品类型查询商品信息并分页显示
     * @param tid
     * @return
     */
    List<GoodsForm> selinfo(@Param("tid") Integer tid);


    /**
     * 根据商品ID查询商品详细信息并分页显示
     * @param gid
     * @return
     */
    List<GoodsForm> selgoodsinfo(@Param("gid") Integer gid);
}
