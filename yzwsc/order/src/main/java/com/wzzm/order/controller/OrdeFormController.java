package com.wzzm.order.controller;

import com.alibaba.fastjson.JSON;
import com.wzzm.order.pojo.OrderForm;
import com.wzzm.order.service.OrdeFomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/oder")
public class OrdeFormController {
    @Resource
    private OrdeFomService od;
    public OrdeFomService getOd() {
        return od;
    }

    public void setOd(OrdeFomService od) {
        this.od = od;
    }


    @ResponseBody
    @RequestMapping(value = "showor")
    public String show(){

        return od.selall1();
    }
    @ResponseBody
    @RequestMapping(value = "show1or")
    public String show1(OrderForm or){
        or.setState(2);
        return JSON.toJSONString(od.selobi1(or));
    }


}
