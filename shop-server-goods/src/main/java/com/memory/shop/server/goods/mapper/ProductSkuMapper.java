package com.memory.shop.server.goods.mapper;

import com.memory.shop.api.goods.domain.ProductSku;
import java.util.List;

public interface ProductSkuMapper {

    //提交

    int deleteByPrimaryKey(Long id);

    int insert(ProductSku record);

    ProductSku selectByPrimaryKey(Long id);

    List<ProductSku> selectAll();



    int updateByPrimaryKey(ProductSku record);

	List<ProductSku> selectByProductId(Long id);

    ProductSku selectBySkuCode(String code);
}