package com.wzzm.order.pojo;

/**
 *地址表
 */

public class AddressForm {
    private Integer oid;    //地址ID
    private String address; //收货地址
    private String phone;   //收货联系电话
    private String postcode;    //收货地址邮编
    private Integer uuid;   //用户ID
    private String consignee; //收货人姓名
    private Integer defau;
    public String getConsignee() {
        return consignee;
    }
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }


    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }
}
