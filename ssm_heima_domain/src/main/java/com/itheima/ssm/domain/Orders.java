package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateFormatUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

//订单
@Data
public class Orders {

    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private Integer orderStatus;
    private String orderStatusStr;
    private Integer peopleCount;

    private Product product;
    private List<Traveller> travellers;
    private Member member;


    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        if (orderTime != null) {
            orderTimeStr = DateFormatUtils.dateToString(orderTime, "yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
        if (orderStatus != null) {
            if (orderStatus == 0) {
                orderStatusStr = "未支付";
            }
            if (orderStatus == 1) {
                orderStatusStr = "已支付";
            }
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payType != null) {
            if (payType == 0) {
                payTypeStr = "支付宝";
            } else if (payType == 1) {
                payTypeStr = "微信";
            } else {
                payTypeStr = "其他";
            }
        }
        return payTypeStr;
    }
}
