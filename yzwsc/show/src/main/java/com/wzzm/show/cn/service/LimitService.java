package com.wzzm.show.cn.service;

public interface LimitService {
    /**
     * 分页
     * @param index 起始页数
     * @param pagesize 每页显示条数
     * @return
     */
    String getPageByIndex(Integer index, Integer pagesize);
}
