package com.wzzm.show.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzzm.show.cn.dao.GoodsFormDao;
import com.wzzm.show.cn.pojo.GoodsForm;
import com.wzzm.show.cn.service.GoodsFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("GoodsFormService")
public class GoodsFormServiceImpl implements GoodsFormService {
    @Autowired
    private GoodsFormDao gsfd;

    public GoodsFormDao getGsfd() {
        return gsfd;
    }

    public void setGsfd(GoodsFormDao gsfd) {
        this.gsfd = gsfd;
    }

    /**
     * 根据商品名模糊查询商品信息
     * @param gname
     * @return
     */
    /*@Transactional
    @Override
    public List<GoodsForm> selfuzzy(String gname) {
        return gsfd.selfuzzy(gname);
    }*/

    /**
     * 根据商品类型查询商品信息
     * @param tid
     * @return
     */
    /*@Transactional
    @Override
    public List<GoodsForm> selinfo(Integer tid) {
        return gsfd.selinfo(tid);
    }*/

    /**
     * 根据商品类型查询商品信息并分页显示商品信息
     * @param index 起始页数
     * @param pagesize 每页显示条数
     * @return
     */
    @Transactional
    @Override
    public String getPageByIndexInfo(Integer index, Integer pagesize, Integer tid) {
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> paginginfo = gsfd.selinfo(tid);
        PageInfo<GoodsForm> pages = new PageInfo<GoodsForm>(paginginfo);
        return JSON.toJSONString(pages);
    }

    /**
     * 根据商品名模糊查询商品信息并分页显示
     * @param index
     * @param pagesize
     * @return
     */
    @Transactional
    @Override
    public String getPageByIndexFuzzy(Integer index, Integer pagesize, String gname) {
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> pagingfuzzy = gsfd.selfuzzy(gname);
        PageInfo<GoodsForm> page = new PageInfo<GoodsForm>(pagingfuzzy);
        return JSON.toJSONString(page);
    }

    @Transactional
    @Override
    public String getPageByIndexGoods(Integer index, Integer pagesize, Integer gid) {
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> paginggoods = gsfd.selgoodsinfo(gid);
        PageInfo<GoodsForm> paging = new PageInfo<GoodsForm>(paginggoods);
        return JSON.toJSONString(paging);
    }


}
