package com.itheima.ssm.domain;

import com.itheima.ssm.utils.DateFormatUtils;
import lombok.Data;

import java.util.Date;

@Data
public class SysLog {
    private String id;
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    public String getVisitTimeStr() {
        if (visitTime != null) {
            visitTimeStr = DateFormatUtils.dateToString(visitTime, "yyyy-MM-dd HH:ss");
        }
        return visitTimeStr;
    }

}
