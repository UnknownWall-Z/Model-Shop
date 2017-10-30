package com.memory.ice.api.service;

import com.memory.ice.api.domain.IceBrand;
import com.memory.ice.api.query.IceBrandQueryObject;
import com.memory.ice.api.query.PageResult;

/**
 * 品牌
 */
public interface IceBrandService {

    void save(IceBrand iceBrand);

    void update(IceBrand iceBrand);

    PageResult query(IceBrandQueryObject qo);

    String test();

}
