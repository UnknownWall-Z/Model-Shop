package com.memory.shop.server.order.mapper;

import com.memory.shop.api.order.domain.District;
import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Short districtId);

    int insert(District record);

    District selectByPrimaryKey(Short districtId);

    List<District> selectAll();

    int updateByPrimaryKey(District record);
}