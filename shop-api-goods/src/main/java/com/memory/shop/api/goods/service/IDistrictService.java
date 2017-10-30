package com.memory.shop.api.goods.service;

import com.memory.shop.api.goods.domain.District;

import java.util.List;
import java.util.Map;

/**
 * Created by zmh on 2017/10/13.
 */
public interface IDistrictService {
    List<Map<Long,String>> selectFirst();

    List<Map<Long,String>> selectSec();

    List<Map<Long,String>> selectThird();

    District selectByPrimaryKey(Long districtId);

    int updateByPrimaryKey(District record);
}
