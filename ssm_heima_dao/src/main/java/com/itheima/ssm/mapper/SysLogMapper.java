package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

public interface SysLogMapper {

    /**
     * 查询日志的信息
     * @return
     * @throws Exception
     */
    List<SysLog> findSysLogAll() throws Exception;

    /**
     * 添加日志信息
     * @param sysLog
     * @throws Exception
     */
    void saveSysLog(SysLog sysLog) throws Exception;
}
