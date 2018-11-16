package com.wzzm.cart.controller;


import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.*;
import com.wzzm.cart.pojo.ResultBean;
import com.wzzm.cart.pojo.Shopcart;
import com.wzzm.cart.service.ShowShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("text/")
@Api(value = "购物车内商品展示/删除")
public class ShowshopcartController {
    @Autowired
    private ShowShopCartService showscs;

    public ShowShopCartService getShowscs() {
        return showscs;
    }
    public void setShowscs(ShowShopCartService showscs) {
        this.showscs = showscs;
    }

    /**
     * 显示购物车内接口
     * @param uuid 用户id
     * @return
     */
    @RequestMapping(value = "getshowinfo", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "显示购物车内商品",httpMethod = "GET", notes = "查询", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404,message = "404:找不到合适的路径"),
            @ApiResponse(code = 500, message = "500:通用报错（数据、逻辑、外键关联等、不区分错误类型）"),
            @ApiResponse(code = 0, message = "没有找到合适的资源"),
            @ApiResponse(code = -1, message = "-1:异常"),
            @ApiResponse(code = 1, message = "1:正常运行"),
    })
    @ApiImplicitParam(paramType = "query",required = false,name="uuid",dataType = "int",value = "用户id")
    public String shoplist(@RequestParam("uuid") int uuid){
        Shopcart sc= new Shopcart();
        sc.setUuid(uuid);
        /*return showscs.shoplist(sc);*/
        return JSON.toJSONString(showscs.shoplist(sc));
    }

    /**
     * 按照id删除购物车商品
     * @param uuid 用户ID
     * @param goodid 商品id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleshop",method = RequestMethod.DELETE)
    @ApiOperation(value = "按照id删除购物车商品", notes = "删除", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404,message = "404:找不到合适的路径"),
            @ApiResponse(code = 500, message = "500:通用报错（数据、逻辑、外键关联等、不区分错误类型）"),
            @ApiResponse(code = 0, message = "没有找到合适的资源"),
            @ApiResponse(code = -1, message = "-1:异常"),
            @ApiResponse(code = 1, message = "1:正常运行"),
    })
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",required = false,name="uuid",dataType = "int",value = "用户id"),
            @ApiImplicitParam(paramType = "query",required = false,name="goodid",dataType = "int",value = "商品id")
    })
    public String delejudge(@RequestParam ("uuid") int uuid, @RequestParam("goodid") int goodid){
        Shopcart sc= new Shopcart();
        sc.setUuid(uuid);
        sc.setGoodid(goodid);
        return JSON.toJSONString(showscs.deleshopinfo(sc));
    }
}
