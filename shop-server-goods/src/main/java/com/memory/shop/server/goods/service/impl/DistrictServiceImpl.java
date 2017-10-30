package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.District;
import com.memory.shop.api.goods.service.IDistrictService;
import com.memory.shop.server.goods.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by zmh on 2017/10/13.
 */
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<Map<Long,String>> selectFirst() {
        return districtMapper.selectFirst();
    }

    @Override
    public List<Map<Long,String>> selectSec() {
        return districtMapper.selectSec();
    }

    @Override
    public List<Map<Long,String>> selectThird() {
        return districtMapper.selectThird();
    }

    @Override
    public District selectByPrimaryKey(Long districtId) {
        return districtMapper.selectByPrimaryKey(districtId);
    }

    @Override
    public int updateByPrimaryKey(District record) {
        return districtMapper.updateByPrimaryKey(record);
    }
}
