package com.wzzm.show.cn.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzzm.show.cn.dao.GoodsFormDao;
import com.wzzm.show.cn.pojo.GoodsForm;
import com.wzzm.show.cn.pojo.ResultBean;
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
    public ResultBean<String> getPageByIndexInfo(Integer index, Integer pagesize, Integer tid) {
        ResultBean resultBean = new ResultBean();
        if (tid == null){
            return resultBean.nulls("tid");
        }
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> paginginfo = gsfd.selinfo(tid);
        if (paginginfo.size() == 0){
            return resultBean.error(null);
        }
        PageInfo<GoodsForm> pages = new PageInfo<GoodsForm>(paginginfo);
        return resultBean.success(pages);
        //return JSON.toJSONString(pages);
    }

    /**
     * 根据商品名模糊查询商品信息并分页显示
     * @param index
     * @param pagesize
     * @return
     */
    @Transactional
    @Override
    public ResultBean<String> getPageByIndexFuzzy(Integer index, Integer pagesize, String gname) {
        ResultBean resultBean = new ResultBean();
        if (gname == null){
            return resultBean.nulls("gname");
        }
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> pagingfuzzy = gsfd.selfuzzy(gname);
        if (pagingfuzzy.size() == 0){
            return resultBean.error(null);
        }
        PageInfo<GoodsForm> page = new PageInfo<GoodsForm>(pagingfuzzy);
        return resultBean.success(page);
        //return JSON.toJSONString(page);
    }

    @Transactional
    @Override
    public ResultBean<String> getPageByIndexGoods(Integer index, Integer pagesize, Integer gid) {
        ResultBean resultBean = new ResultBean();
        if (gid == null){
            return resultBean.nulls("gid");
        }
        PageHelper.startPage(index,pagesize);
        List<GoodsForm> paginggoods = gsfd.selgoodsinfo(gid);
        if (paginggoods.size() == 0){
            return resultBean.error(null);
        }
        PageInfo<GoodsForm> paging = new PageInfo<GoodsForm>(paginggoods);
        return resultBean.success(paging);
        //return JSON.toJSONString(paging);
    }


}
