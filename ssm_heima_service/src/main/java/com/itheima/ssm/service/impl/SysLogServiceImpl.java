package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.mapper.SysLogMapper;
import com.itheima.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogMapper mapper;

    @Override
    public List<SysLog> findSysLogAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page, size);
        return mapper.findSysLogAll();
    }

    @Override
    public void saveSysLog(SysLog sysLog) throws Exception {
        mapper.saveSysLog(sysLog);
    }
}
