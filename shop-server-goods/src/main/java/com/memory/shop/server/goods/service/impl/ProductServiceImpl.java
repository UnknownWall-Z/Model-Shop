package com.memory.shop.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.memory.shop.api.goods.domain.*;
import com.memory.shop.api.goods.query.PageResult;
import com.memory.shop.api.goods.query.ProductQueryObject;
import com.memory.shop.api.goods.service.IProductService;
import com.memory.shop.server.goods.mapper.ProductCatalogPropertyValueMapper;
import com.memory.shop.server.goods.mapper.ProductDescMapper;
import com.memory.shop.server.goods.mapper.ProductImageMapper;
import com.memory.shop.server.goods.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by zmh on 2017/9/28.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDescMapper productDescMapper;
    @Autowired
    private ProductImageMapper productImageMapper;
    @Autowired
    private ProductCatalogPropertyValueMapper productPropertyMapper;

    @Override
    public void insert(ProductInfo productInfo) {
        Product product = productInfo.getProduct();
        ProductDesc productDesc = productInfo.getProductDesc();
        List<ProductImage> productImages = productInfo.getProductImages();
        List<ProductCatalogPropertyValue> productCatalogPropertyValue = productInfo.getProductCatalogPropertyValue();

        if (product.getName()==null){
            throw new RuntimeException("请输入商品信息");
        }
        product.setCreatedDate(new Date());
        product.setLastModifiedDate(new Date());
        productMapper.insert(product);

        if (productDesc.getDetails()==null || productDesc.getDetails()==""){
            throw new RuntimeException("商品详情还未填写!");
        }
        productDesc.setProductId(product.getId());
        productDescMapper.insert(productDesc);

        if (productImages.size()==0){
            throw new RuntimeException("请上传商品图片!");
        }
        for (ProductImage productImage : productImages) {
            productImage.setProductId(product.getId());
            productImageMapper.insert(productImage);
        }

//        if (productCatalogPropertyValue.size()==0){
//            throw new RuntimeException("商品属性还未填写!");
//        }
        if (productCatalogPropertyValue.size()>0){
            for (ProductCatalogPropertyValue catalogPropertyValue : productCatalogPropertyValue) {
                catalogPropertyValue.setProductId(product.getId());
                productPropertyMapper.insert(catalogPropertyValue);
            }
        }

    }
    @Override
    public void insertProduct(Product product) {

        product.setCreatedDate(new Date());
        product.setLastModifiedDate(new Date());
        productMapper.insert(product);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product selectById(Long id){return this.productMapper.selectByPrimaryKey(id);}

    @Override
    public PageResult queryPage(ProductQueryObject queryObject) {
        int count = productMapper.queryForCount(queryObject);
        if (count>0){
            List<Product> listDate = productMapper.queryForList(queryObject);
            return new PageResult(listDate,count,queryObject.getCurrentPage(),queryObject.getPageSize());
        }
        return PageResult.empty(queryObject.getPageSize());
    }

    @Override
    public void update(ProductInfo productInfo) {
        Product product = productInfo.getProduct();
        ProductDesc productDesc = productInfo.getProductDesc();
        List<ProductImage> productImages = productInfo.getProductImages();
        List<ProductCatalogPropertyValue> productCatalogPropertyValue = productInfo.getProductCatalogPropertyValue();
        //更新商品基本信息
        productMapper.updateByPrimaryKey(product);
        //更新商品详情
        productDesc.setProductId(product.getId());
        productDescMapper.updateByProductId(productDesc);
        //更新商品相册
            //先删除所有的图片再添加
        productImageMapper.deleteByProductId(product.getId());
        for (ProductImage image : productImages) {
            image.setProductId(product.getId());
            productImageMapper.insert(image);
        }
        //更新商品属性
            //删除原来的属性,再重新保存
        productPropertyMapper.deleteByProductId(product.getId());
        for (ProductCatalogPropertyValue value : productCatalogPropertyValue) {
            value.setProductId(product.getId());
            productPropertyMapper.insert(value);
        }
    }
}
