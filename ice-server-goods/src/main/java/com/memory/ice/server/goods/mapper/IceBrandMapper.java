package com.memory.ice.server.goods.mapper;

import com.memory.ice.api.domain.IceBrand;
import com.memory.ice.api.query.IceBrandQueryObject;

import java.util.List;

public interface IceBrandMapper {

    int insert(IceBrand record);

    IceBrand selectByPrimaryKey(Long id);

    List<IceBrand> selectAll();

    int updateByPrimaryKey(IceBrand record);

    int count(IceBrandQueryObject qo);

    java.util.List<IceBrand> ListData(IceBrandQueryObject qo);

}