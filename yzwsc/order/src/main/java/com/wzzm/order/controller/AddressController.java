package com.wzzm.order.controller;

import com.alibaba.fastjson.JSON;
import com.wordnik.swagger.annotations.*;
import com.wzzm.order.pojo.AddressForm;
import com.wzzm.order.service.AddressService1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@RequestMapping("/api/site")
@Controller
@Api(value = "/site")
@ApiModel(description = "群組")
public class AddressController {
    @ApiModelProperty(required = true , value = "群组id")
    @Resource
    private AddressService1 add;

    public AddressService1 getAdd() {
        return add;
    }

    public void setAdd(AddressService1 add) {
        this.add = add;
    }

    /**
     * 显示默认地址
     * @param ad
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getall" , method = RequestMethod.GET)
    @ApiOperation(value = "显示默认地址" , notes = "显示默认地址" , produces = "application/jsons")
    @ApiResponses({@ApiResponse(code = 400,message = "inasfdqc")})
    public String selsite(@ApiParam(name="ad" , value = "用户ID" ,required = true) AddressForm ad){
        return JSON.toJSONString(add.seladd(ad));
    }
    /**
     * 添加地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.GET)
    @ApiOperation(value = "添加地址" , notes = "添加地址地址" , produces = "application/jsons")
    @ApiResponses({@ApiResponse(code = 400,message = "ina")})
    public String site(@ApiParam(name="ad" , value = "用户ID" ,required = true)@RequestBody AddressForm arf){

        return JSON.toJSONString(add.address(arf));
    }

    /**
     * 展示地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value="show1" ,method = RequestMethod.GET)
    @ApiOperation(value = "添加地址" , notes = "添加地址地址" , produces = "application/jsons")
    @ApiResponses({@ApiResponse(code = 400,message = "ina")})
    public String showsite(@ApiParam(name="arf" , value = "用户ID" ,required = true) AddressForm arf){
        arf.setUuid(1);
        return JSON.toJSONString(add.selall(arf));
    }
    /**
     * 删除地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value="dele" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除地址" , notes = "删除地址" , produces = "application/jsons")
    @ApiResponses({@ApiResponse(code = 400,message = "ina")})
    public String delsite(@ApiParam(name="arf" , value = "用户ID" ,required = true)AddressForm arf){
        arf.setUuid(1);
        arf.setOid(1);

        return JSON.toJSONString(add.delsite(arf));
    }
}
