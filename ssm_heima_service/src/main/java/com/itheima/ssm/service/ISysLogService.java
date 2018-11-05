package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 查询所有的日志信息
     * @return
     * @throws Exception
     */
    List<SysLog> findSysLogAll(Integer page, Integer size) throws Exception;

    /**
     * 保存日志信息
     *
     * @param sysLog
     * @throws Exception
     */
    void saveSysLog(SysLog sysLog) throws Exception;
}
