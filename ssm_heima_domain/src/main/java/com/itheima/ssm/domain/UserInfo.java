package com.itheima.ssm.domain;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {
    private String id; //主键UUID
    private String username;  //用户名
    private String email; //邮箱，非空唯一
    private String password; //密码
    private String phoneNum; //电话
    private Integer status; //状态

    private String statusStr;
    private List<Role> roleList;  //角色集合

    public String getStatusStr() {
        if (status != null) {
            if (status == 0) {
                statusStr = "未开启";
            }
            if (status == 1) {
                statusStr = "开启";
            }
        }
        return statusStr;
    }
}
