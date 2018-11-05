package com.itheima.ssm.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DemoMapper {

    void add(Map<String, Object> map);

    void save(@Param("name") String name, @Param("ids") List<String> ids);

    void saveDemo(List<String> demoList);

    void saveDemo2(String[] ids);
}
