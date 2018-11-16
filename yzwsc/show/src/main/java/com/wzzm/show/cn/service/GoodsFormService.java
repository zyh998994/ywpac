package com.wzzm.show.cn.service;

import com.wzzm.show.cn.pojo.ResultBean;

public interface GoodsFormService {
    /**
     *根据商品名模糊查询商品信息
     * @param gname
     * @return
     */
    //List<GoodsForm> selfuzzy(String gname);

    /**
     * 根据商品类型查询商品信息
     * @param tid
     * @return
     */
  // List<GoodsForm> selinfo(Integer tid);

    /**
     * 根据商品类型查询商品信息并分页显示商品信息
     * @param index 起始页数
     * @param pagesize 每页显示条数
     * @return
     */
    ResultBean<String> getPageByIndexInfo(Integer index, Integer pagesize, Integer tid);

    /**
     * 根据商品名模糊查询商品信息并分页显示
     * @param index
     * @param pagesize
     * @return
     */
    ResultBean<String> getPageByIndexFuzzy(Integer index, Integer pagesize, String gname);

    /**
     * 根据商品ID查询商品所有信息并分页显示
     * @param index
     * @param pagesize
     * @return
     */
    ResultBean<String> getPageByIndexGoods(Integer index, Integer pagesize, Integer gid);
}
