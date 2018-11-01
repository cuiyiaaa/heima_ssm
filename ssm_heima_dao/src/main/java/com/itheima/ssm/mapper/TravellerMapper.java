package com.itheima.ssm.mapper;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerMapper {

    /**
     * 根据ID查询对应信息
     * @param id
     * @return
     */
    List<Traveller> findTravellerById(String id);
}
