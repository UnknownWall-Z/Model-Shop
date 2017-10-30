package com.memory.shop.server.goods.mapper;


import com.memory.shop.api.goods.domain.District;

import java.util.List;
import java.util.Map;

public interface DistrictMapper {
    int deleteByPrimaryKey(Long districtId);

    int insert(District record);

    District selectByPrimaryKey(Long districtId);

    List<Map<Long,String>> selectFirst();

    List<Map<Long,String>> selectSec();

    List<Map<Long,String>> selectThird();

    int updateByPrimaryKey(District record);
}