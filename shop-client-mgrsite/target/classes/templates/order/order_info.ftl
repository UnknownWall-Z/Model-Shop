<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ice哥商城管理平台</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="/js/pcasunzip.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#audit1").click(function () {
                $("#myModal").modal("show");
            });
            //确认订单按钮
            $("#btn_audit1").click(function () {
                var form = $("#editform1");
                form.find("[name=state]").val($(this).val());
                $("#myModal1").modal("hide");
                form.ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.confirm("提示", "确认订单成功！已在备货中！", function () {
                            window.location.reload();
                        });
                    }
                });
            });
            //发货订单按钮
            $("#audit2").click(function () {
                $("#myModa2").modal("show");
            });
            $("#btn_audit2").click(function () {
                var form = $("#editform2");
                form.find("[name=state]").val($(this).val());
                $("#myModa2").modal("hide");
                form.ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.confirm("提示", "发货成功！已在配送中！", function () {
                            window.location.reload();
                        });
                    }
                });

            });
            //完成按钮
            $("#audit4").click(function () {
                $("#myModa4").modal("show");
            });
            $("#btn_audit4").click(function () {
                var form = $("#editform4");
                form.find("[name=state]").val($(this).val());
                $("#myModa4").modal("hide");
                form.ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.confirm("提示", "已完成订单", function () {
                            window.location.reload();
                        });
                    }
                });
            });
            $("#provinceId").change(function () {
                $.get("getCityByProvinceId/" + $("#provinceId").val(), function (data) {
                    if (data.status) {
                        var result = "<option>选择城市</option>";
                        $.each(data.obj, function (n, value) {
                            result += "<option value='" + value.cityid + "'>" + value.city + "</option>";
                        });
                        $("#cityId").html('');
                        $("#cityId").append(result);
                    }
                }, "json");
            });
            $("#cityId").change(function () {
                $.get("getAreaByCityId/" + $("#cityId").val(), function (data) {
                    if (data.status) {
                        var result = "<option>选择区域</option>";
                        $.each(data.obj, function (n, value) {
                            result += "<option value='" + value.areaid + "'>" + value.area + "</option>";
                        });
                        $("#areaId").html('');
                        $("#areaId").append(result);
                    }
                }, "json");
            });
        });

    </script>
<body>
<div class="container">
<#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
        <#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>订单详情</h3>
            </div>
        <#-- <form id="searchForm" class="form-inline" method="post" action="">
             <input type="hidden" id="currentPage" name="currentPage" value=""/>
         </form>-->
            <fieldset>
                <legend>用户详情</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>用户ID</th>
                        <th>邮箱</th>
                        <th>昵称</th>
                        <th>平台账户余额</th>
                        <th>注册时间</th>
                        <th>最后登录时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${users.id}</td>
                        <td>${users.email!""}</td>
                        <td>${users.nickName!""}</td>
                        <td>${users.userMoney!""}</td>
                        <td>2015-08-08</td>
                        <td>2017-08-16</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>用户交易汇总</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>有效订单</th>
                        <th>成功交易金额</th>
                        <th>退货次数</th>
                        <th>退货金额</th>
                        <th>发货后退货率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>有没有效我也不知道</td>
                        <td>10086</td>
                        <td>8</td>
                        <td>888</td>
                        <td>50%</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>订单备注</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>UID</th>
                        <th>添加人</th>
                        <th>时间</th>
                        <th>内容</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>44453</td>
                        <td>${users.nickName!""}</td>
                        <td>${(orderInfo.orderDate?string("yyyy-MM-dd"))!""}</td>
                        <td>快点发货！</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <div class="row">
                <div class="col-xs-3">
                    <fieldset style="border-color: #00a7ff">
                        <legend>订单详情</legend>

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>订单号</th>
                                <th>${orderInfo.id}</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>订单状态</td>
                                <td>${orderInfo.orderStatusDisplay}</td>
                            </tr>
                            <tr>
                                <td>要求发票</td>
                                <td>不要白不要</td>
                            </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
                <div class="col-xs-1"></div>
                <div class="col-xs-3">
                    <fieldset style="border-color: #00a7ff">
                        <legend>订单时间</legend>
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>创建时间</th>
                                <th>${(orderInfo.orderDate?string("yyyy-MM-dd"))!""}</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>付款时间</td>
                                <td>2222-22-22</td>
                            </tr>
                            <tr>
                                <td>发货时间</td>
                                <td>${(orderInfo.sendDate?string("yyyy-MM-dd"))!""}</td>
                            </tr>
                            <tr>
                                <td>完成时间</td>
                                <td>${(orderInfo.finishDate?string("yyyy-MM-dd"))!""}</td>
                            </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
                <div class="col-xs-1"></div>
                <div class="col-xs-3">
                    <fieldset style="border-color: #00a7ff">
                        <legend>付款详情</legend>

                        <table class="table table-bordered">
                            <thead>
                            </thead>
                            <tbody>
                            <tr>
                                <td>付款金额</td>
                                <td>${orderInfo.orderAmount!""}</td>
                            </tr>
                            <tr>
                                <td>减免金额</td>
                                <td>88</td>
                            </tr>
                            <tr>
                                <td>付款IP</td>
                                <td>66666</td>
                            </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
                <div class="col-xs-1"></div>
            </div>
            <fieldset>
                <legend>订单商品详情</legend>
                <div class="col-xs-4" style="font-size: 20px">
                    <th>订单号：</th>
                    <th>${orderInfo.orderSn!""}</th>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>商品名称</th>
                        <th>SKU</th>
                        <th>单价</th>
                        <th>数量</th>
                        <th>总价</th>
                        <th>商品类型</th>
                        <th>组套信息</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1</td>
                        <td>2</td>
                        <td>3</td>
                        <td>4</td>
                        <td>5</td>
                        <td>6</td>
                        <td>7</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>

            <div class="col-xs-5">
                <fieldset style="border-color: #00a7ff">
                    <legend>地址详情</legend>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>用户邮箱</th>
                            <th>${users.email!""}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>邮编</td>
                            <td>${orderInfo.zipcode!""}</td>
                        </tr>
                        <tr>
                            <td>收货人</td>
                            <td>${orderInfo.consignee!""}</td>
                        </tr>
                        <tr>
                            <td>手机</td>
                            <td>${users.phone!""}</td>
                        </tr>
                        </tbody>
                    </table>
                </fieldset>
            </div>
            </br>
            <div class="col-xs-10">
                <th>
                <#if orderInfo.orderStatus == 0>
                    <a class="btn btn-success" id="audit1" value="0" type="button">订单确认</a>
                <#else>
                    <div>
                        <p class="bg-success" style="height: 40px">该订单已经确认！在备货中！</p>
                    </div>
                </#if>
                <#if orderInfo.shippingStatus == 0>
                    <a class="btn btn-success" id="audit2" value="0" type="button">发货</a>
                <#else>
                    <div>
                        <p class="bg-info" style="height: 29px">已经发货！正在配送中！</p>
                    </div>
                </#if>
                <#if orderInfo.payStatus==0>
                    <a class="btn btn-success" id="audit4" value="0" type="button">完成订单</a>
                <#else >
                    <div>
                        <p class="bg-danger" style="height: 29px">已完成订单！</p>
                    </div>
                </#if>

                </th>
            </div>
            <div class="col-xs-12">
                <fieldset>
                    <legend>操作记录</legend>
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>操作时间</th>
                            <th>备注</th>
                            <th>操作后订单状态</th>
                            <th>操作人</th>
                        </tr>
                        </thead>
                        <tbody id="myTbody">
                        <#list actions!'' as item>
                        <tr>
                            <td>${(item.actionTime?string("yyyy-MM-dd HH:mm:ss"))!""}</td>
                            <td>${item.actionNote!""}</td>
                            <td>操作订单成功</td>
                            <td>${item.actionUser.nickName!""}</td>

                        </tr>
                        </#list>
                        </tbody>

                    </table>
                </fieldset>
            </div>
            <div class="col-xs-3">
                <a class="btn btn-primary" href="orderList">返回订单列表页面</a>
            </div>
        </div>
    </div>
<#--确认订单模态框-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form class="form-horizontal" id="editform1" method="post" action="/orderInfoQRDD">
                        <fieldset>
                            <div id="legend" class="">
                                <legend>确认订单</legend>
                            </div>
                            <input type="hidden" name="id" value="${orderInfo.id}"/>
                            <input type="hidden" name="state" value=""/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="name">确认备注</label>
                                <div class="col-sm-6">
                                    <textarea name="remark" rows="4" cols="60"></textarea>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="btn_audit1" class="btn btn-success btn_audit" value="0">确认订单</button>
                    <button type="button" id="btn_audit1" class="btn btn-warning btn_audit" value="1">丑拒</button>
                </div>
            </div>
        </div>
    </div>
<#--发货订单模态框-->
    <div class="modal fade" id="myModa2" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form class="form-horizontal" id="editform2" method="post" action="/orderInfoFH">
                        <fieldset>
                            <div id="legend" class="">
                                <legend>发货订单</legend>
                            </div>
                            <input type="hidden" name="id" value="${orderInfo.id}"/>
                            <input type="hidden" name="state" value=""/>
                            <div>
                                省：<select id="province" name="province"></select>
                                市：<select id="city" name="city"></select>
                                县/区：<select id="district" name="district"></select>
                                <script type="text/javascript">
                                    new PCAS("province", "city", "district", '--请选择省份--', '--请选择城市--', '--请选择地区--');
                                </script>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="name">收货地址</label>
                                <div class="col-sm-6">
                                    <textarea name="address" rows="4" cols="60"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="name">确认备注</label>
                                <div class="col-sm-6">
                                    <textarea name="remark" rows="4" cols="60"></textarea>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="btn_audit2" class="btn btn-success btn_audit" value="0">确认订单</button>
                    <button type="button" id="btn_audit2" class="btn btn-warning btn_audit" value="1">丑拒</button>
                </div>
            </div>
        </div>
    </div>
<#--完成模态框-->
    <div class="modal fade" id="myModa4" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <form class="form-horizontal" id="editform4" method="post" action="/orderInfoWCDD">
                        <fieldset>
                            <div id="legend" class="">
                                <legend>完成订单</legend>
                            </div>
                            <input type="hidden" name="id" value="${orderInfo.id}"/>
                            <input type="hidden" name="state" value=""/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label" for="name">确认备注</label>
                                <div class="col-sm-6">
                                    <textarea name="remark" rows="4" cols="60"></textarea>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" id="btn_audit4" class="btn btn-success btn_audit" value="0">确认完成订单</button>
                    <button type="button" id="btn_audit4" class="btn btn-warning btn_audit" value="1">丑拒</button>
                </div>
            </div>
        </div>
    </div>


</body>
</html>