package com.wzzm.show.cn.controller;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.*;
import com.wzzm.show.cn.service.GoodsFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/goodsinfo")
@Api(value = "/goodsinfo")
@ApiModel(description = "群组")
public class GoodsFormController {
    @ApiModelProperty(required = true,value = "群组的ID")
    @Autowired
    private GoodsFormService gsfs;

    public GoodsFormService getGsfs() {
        return gsfs;
    }

    public void setGsfs(GoodsFormService gsfs) {
        this.gsfs = gsfs;
    }

   /* @ResponseBody
    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String selfuzzy(String gname){
        System.out.println("aaaa" + gname);
        List<GoodsForm> goodList = gsfs.selfuzzy(gname);
        model.addAttribute("goodList",goodList);
        for (GoodsForm goods:goodList){
            System.out.println(goods.getGname() + goods.getGprice() + goods.getGinfo() + goods.getGimage() + goods.getGinfoimage());
        }
        System.out.println(goodList);
        return JSON.toJSONString(goodList);
        return JSON.toJSONString("success");
        return "{\"login\":\"success\"}";
        return "success";
    }*/

    /**
     * 模糊查询，根据商品名查询出商品并分页显示
     * @param
     * @param
     * @return
     */
   @RequestMapping(value = "/fuzzyshow",method = RequestMethod.GET)
   @ApiOperation(value = "模糊查询并分页显示",notes = "模糊查询并分页显示",produces = "application/json")
   @ApiResponses({@ApiResponse(code = 400,message = "Invalid user supplied")})
   @ResponseBody
   public String selfuzzy(@ApiParam(name = "gname",value = "商品名",required = true)@RequestParam String gname){
       return JSON.toJSONString(gsfs.getPageByIndexFuzzy(1,5,gname));
   }
   /*public String getsel(String gname, Model model){
       System.out.println(gname + "1111111111111");
       List<GoodsForm> goodList = gsfs.selfuzzy(gname);
       model.addAttribute("goodList",goodList);
       System.out.println(goodList);
       *//*for (GoodsForm goods:goodList){
           System.out.println(goods.getGname() + goods.getGprice() + goods.getGinfo() + goods.getGimage() + goods.getGinfoimage());
       }*//*
       return JSON.toJSONString(goodList);
   }*/


    /**
     * ，根据商品类型展示出商品信息并分页显示
     * @param
     * @return
     */
    @RequestMapping(value = "/goodsshow",method = RequestMethod.GET)
    @ApiOperation(value = "根据商品类型展示商品信息并分页显示",notes = "根据商品类型展示商品信息并分页显示",produces = "application/json")
    @ApiResponses({@ApiResponse(code = 400,message = "Invalid user supplied")})
    @ResponseBody
    public String selinfo(@ApiParam(name = "tid",value = "商品类型ID",required = true)@RequestParam Integer tid){
        return JSON.toJSONString(gsfs.getPageByIndexInfo(1,5,tid));
    }
   /* public String selinfo(Integer tid, Model model){
       List<GoodsForm> goodshow = gsfs.selinfo(tid);
       model.addAttribute("goodshow",goodshow);
       System.out.println(goodshow);
       return JSON.toJSONString(goodshow);
   }*/

    /**
     * 根据商品ID查询商品所有信息并分页显示
     * @return
     */
   @RequestMapping(value = "/goodsinfoshow",method = RequestMethod.GET)
   @ApiOperation(value = "根据商品ID查询商品所有信息并分页显示",notes = "根据商品ID查询商品所有信息并分页显示",produces = "application/json")
   @ApiResponses({@ApiResponse(code = 400,message = "Invalid user supplied")})
   @ResponseBody
    public String selgoodsinfo(@ApiParam(name = "gid",value = "商品ID",required = true)@RequestParam Integer gid){
       return JSON.toJSONString(gsfs.getPageByIndexInfo(1,3,gid));
   }
}
