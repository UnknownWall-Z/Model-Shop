package com.memory.shop.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.memory.shop.api.goods.domain.*;
import com.memory.shop.api.goods.service.*;
import com.memory.shop.api.goods.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmh on 2017/10/12.
 */
@Controller
public class ShoppingCarController {

    @Reference
    private IShoppingCarService shoppingCarService;

    @Reference
    private IProductSkuService productSkuService;

    @Reference
    private IProductSkuPropertyService productSkuPropertyService;

    @Reference
    private IProductImageService productImageService;

    @Reference
    private IUserAddressService userAddressService;

    @Reference
    private IDistrictService districtService;


    @RequestMapping("/addShoppingCar")
    @ResponseBody
    public AjaxResult addShoppingCar(String skuId,int number,Long userId){
        AjaxResult json = new AjaxResult();
        try {
            ShoppingCar car = new ShoppingCar();
            car.setSkuId(skuId);
            car.setNumber(number);
            ProductSku productSku = productSkuService.selectBySkuCode(skuId);
            car.setProductId(productSku.getProduct().getId());
            car.setProductName(productSku.getProduct().getName());
            car.setPrice(productSku.getPrice());
            car.setUserId(userId);
            List<String> strings = productSkuPropertyService.selectValuesByProductSkuId(productSku.getId());
            StringBuilder sb = new StringBuilder();
            for (String string : strings) {
                sb.append(string);
            }
            car.setSkuProperty(sb.toString());
            shoppingCarService.insert(car);
        }catch (Exception e){
            e.printStackTrace();
            json.setMsg(e.getMessage());
        }
        return json;
    }


    @RequestMapping("/shoppingCar")
    @ResponseBody
    public List<ShoppingCarVO> shoppingCar(Long userId){

        return getItems(userId);
    }

    private List<ShoppingCarVO> getItems(Long userId){
        List<ShoppingCarVO> list = new ArrayList<>();
        List<ShoppingCar> carList = shoppingCarService.selectByUserId(userId);
        List<String> imageUrls = new ArrayList<>();
        for (ShoppingCar car : carList) {
            List<ProductImage> productImages = productImageService.selectByProductId(car.getProductId());
            for (ProductImage productImage : productImages) {
                imageUrls.add(productImage.getImagePath());
            }
            ShoppingCarVO carVO = new ShoppingCarVO();
            carVO.setImgUrl(imageUrls);
            carVO.setPrice(car.getPrice());
            carVO.setProductName(car.getProductName());
            carVO.setShoppingItemId(car.getId());
            carVO.setSkuProperty(car.getSkuProperty());
            carVO.setNumber(car.getNumber());
            list.add(carVO);
        }
        return list;
    }

    @RequestMapping("/shoppingCar_edit")
    @ResponseBody
    public AjaxResult changeNumber(Long shoppingItemId,int number){
        AjaxResult json = new AjaxResult();
        try {
            ShoppingCar car = shoppingCarService.selectByPrimaryKey(shoppingItemId);
            if(number != 0){
                car.setNumber(number);
                shoppingCarService.updateByPrimaryKey(car);
            }else {
                shoppingCarService.deleteByPrimaryKey(shoppingItemId);
            }
        }catch (Exception e){
            json.setMsg(e.getMessage());
        }
        return json;
    }


    @RequestMapping("/shoppingCar_settlement")
    @ResponseBody
    public SettleMentVO settleMent(Long userId){
        SettleMentVO settleMentVO = new SettleMentVO();
        try {
            BigDecimal totalPrice = new BigDecimal(0.00);
            List<ShoppingCar> carList = shoppingCarService.selectByUserId(userId);
            for (ShoppingCar item : carList) {
               totalPrice = totalPrice.add(item.getPrice().multiply(new BigDecimal(item.getNumber())));
            }
            settleMentVO.setTotalPrice(totalPrice);
            ResultVO result = new ResultVO();
            result.setItems(getItems(userId));
            AddressVO address = new AddressVO();
            UserAddress userAddress = userAddressService.selectDefaultAddress(userId);
            address.setDeliverUser(userAddress.getName());
            address.setDeliverPhone(userAddress.getPhone());
            address.setAdressId(userAddress.getId());
            StringBuilder sb = new StringBuilder();
            sb.append(userAddress.getProvince().getDistrictName()).append(userAddress.getCity().getDistrictName()).append(userAddress.getDistrict().getDistrictName()).append(userAddress.getDetail());
            address.setDeliverAddressFullString(sb.toString());
            result.setDefaultAddress(address);
            settleMentVO.setResult(result);
        }catch (Exception e){
            settleMentVO.setErrorMsg(e.getMessage());
        }
        return settleMentVO;
    }

    @RequestMapping("/MyDeliverAddress")
    @ResponseBody
    public AddressListVO myDeliverAddress(Long userId){
        AddressListVO listVO = new AddressListVO();
        try {
            List<AddressVO> addressVOList = new ArrayList<>();
            List<UserAddress> addressList = userAddressService.selectAddressList(userId);
            for (UserAddress userAddress : addressList) {
                AddressVO addressVO = new AddressVO();
                addressVO.setAdressId(userAddress.getId());
                addressVO.setDeliverUser(userAddress.getName());
                addressVO.setDeliverPhone(userAddress.getPhone());
                StringBuilder sb = new StringBuilder();
                sb.append(userAddress.getProvince().getDistrictName()).append(userAddress.getCity().getDistrictName()).append(userAddress.getDistrict().getDistrictName()).append(userAddress.getDetail());
                addressVO.setDeliverAddressFullString(sb.toString());
                addressVOList.add(addressVO);
            }
            listVO.setResult(addressVOList);
        }catch (Exception e){
            listVO.setErrorMsg(e.getMessage());
        }
        return listVO;
    }


    @RequestMapping("/MyDeliverAddress_toEdit")
    @ResponseBody
    public AddressEditVO addressEditResult(Long addressId){
        AddressEditVO editVO = new AddressEditVO();
        try {
            AddressEditResultVO result = new AddressEditResultVO();
            UserAddress userAddress = userAddressService.selectDefaultAddress(addressId);
            StringBuilder sb = new StringBuilder();
            sb.append(userAddress.getProvince().getDistrictName()).append(userAddress.getCity().getDistrictName()).append(userAddress.getDistrict().getDistrictName()).append(userAddress.getDetail());
            result.setAddress(sb.toString());
            result.setAddressId(addressId);
            result.setDefault(userAddress.getIsDefault());
            result.setDeliverPhone(userAddress.getPhone());
            result.setDeliverUser(userAddress.getName());
            result.setRegionFirst(districtService.selectFirst());
            result.setRegionSec(districtService.selectSec());
            result.setRegionThird(districtService.selectThird());
            editVO.setResult(result);
        }catch (Exception e){
            e.printStackTrace();
            editVO.setErrorMsg(e.getMessage());
        }
        return editVO;
    }


    @RequestMapping("/MyDeliverAddress_edit")
    @ResponseBody
    public AjaxResult myDeliverAddressEdit(Long userId, Long addressId,String deliverUser,String deliverPhone,Long regionFirstId,Long regionSecId,Long regionThirdId,String address,boolean isDefault){
        AjaxResult json = new AjaxResult();
        try {
            District province = districtService.selectByPrimaryKey(regionFirstId);
            District city = districtService.selectByPrimaryKey(regionSecId);
            District district = districtService.selectByPrimaryKey(regionThirdId);
            UserAddress userAddress = userAddressService.selectDefaultAddress(addressId);
            userAddress.setProvince(province);
            userAddress.setCity(city);
            userAddress.setDistrict(district);
            userAddress.setName(deliverUser);
            userAddress.setPhone(deliverPhone);
            userAddress.setDetail(address);
            userAddress.setIsDefault(isDefault);
            userAddress.setUserId(userId);
            if(addressId != null){
                userAddressService.updateByPrimaryKey(userAddress);
            }else {
                userAddress.setId(null);
                userAddressService.insert(userAddress);
            }
        }catch (Exception e){
            json.setMsg(e.getMessage());
        }
        return json;
    }


    @RequestMapping("/MyDeliverAddress_del")
    @ResponseBody
    public AjaxResult myDeliverAddressDel(Long addressId){
        AjaxResult json = new AjaxResult();
        try {
           userAddressService.deleteByPrimaryKey(addressId);
        }catch (Exception e){
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @RequestMapping("/shoppingCar_order")
    @ResponseBody
    public OrderResultVO shoppingCarOrder(Long addressId,Long[] skuId,Integer[] number,BigDecimal[] price,int paymentType){
        OrderResultVO result = new OrderResultVO();
        try {
            result.setPaymentType(paymentType);

        }catch (Exception e){
            result.setErrorMsg(e.getMessage());
        }
        return result;
    }


}
