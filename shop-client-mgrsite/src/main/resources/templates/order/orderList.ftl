<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ice哥商城管理平台</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js" ></script>

    <script type="text/javascript">
        $(function () {
            $(".beginDate,.endDate").click(function () {
                WdatePicker();
            });

            $("#pagination").twbsPagination({
                totalPages : ${pageResult.totalPage},
                startPage : ${pageResult.currentPage},
                visiblePages : 3,
                first : "首页",
                prev : "上一页",
                next : "下一页",
                last : "尾页",
                onPageClick : function(event, page) {
                    $("#currentPage").val(page);
                    $("#searchForm").submit();
                }
            });

            $("#query").click(function () {
                $("#currentPage").val(1);
                $("#searchForm").submit();
            });

        })
    </script>
</head>
<body>
<div class="container">
<#assign currentMenu="order_list">
<#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
        <#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>订单管理</h3>
            </div>
            <form id="searchForm" class="form-inline" method="post" action="/orderList">
                <input type="hidden" id="currentPage" name="currentPage" value=""/>
                <div class="form-group">
                    <label>订单号</label>
                    <input class="form-control" type="text" name="orderSn"  value='${qo.orderSn!""}'/>
                </div>
                <div class="form-group">
                    <label>订单状态</label>
                    <select class="form-control" name="orderState" id="orderState">
                        <option value="-1">全部</option>
                        <option value="0">未确认</option>
                        <option value="1">已确认</option>
                        <option value="2">已完成</option>
                    </select>
                    <script type="text/javascript">
                        $("#orderState option[value=${qo.orderState}]").attr("selected",true);
                    </script>
                </div>
                <div class="form-group">
                    <label>支付状态</label>
                    <select class="form-control" name="payState" id="payState">
                        <option value="-1">全部</option>
                        <option value="0">未付款</option>
                        <option value="1">已付款</option>
                    </select>
                    <script type="text/javascript">
                        $("#payState option[value=${qo.payState}]").attr("selected",true);
                    </script>
                </div>
                <div class="form-group">
                    <label>物流状态</label>
                    <select class="form-control" name="shippingState" id="shippingState">
                        <option value="-1">全部</option>
                        <option value="0">未发货</option>
                        <option value="1">已发货</option>
                        <option value="2">已收货</option>
                    </select>
                    <script type="text/javascript">
                        $("#shippingState option[value=${qo.shippingState}]").attr("selected",true);
                    </script>
                </div>
                <div class="form-group">
                    <label>订单开始时间</label>
                    <input class="form-control beginDate" type="text" name="beginDate" value='${(qo.beginDate?string("yyyy-MM-dd"))!""}'/>~
                    <label>订单结束时间</label>
                    <input class="form-control endDate" type="text" name="endDate" value='${(qo.endDate?string("yyyy-MM-dd"))!""}'/>
                </div>
                <div class="form-group">
                    <button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                </div>
            </form>
            <div class="panel panel-default">
                <table class="table">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>收货人</th>
                        <th>下单时间</th>
                        <th>总金额</th>
                        <th>订单状态</th>
                        <th>付款状态</th>
                        <th>发货状态</th>
                        <th>收货地址</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <#list pageResult.listdata as item>
                    <tr>
                        <td>${item.orderSn!""}</td>
                        <td>${item.consignee!""}</td>
                        <td>${(item.orderDate?string("yyyy-MM-dd"))!""}</td>
                        <td>${item.orderAmount!""}</td>
                        <td>${item.orderStatusDisplay!""}</td>
                        <td>${item.payStatusDisplay!""}</td>
                        <td>${item.shippingStatusDisplay!""}</td>
                        <td>${item.address!""}</td>
                        <td>
                            <a href="orderInfo?id=${item.id}"><u>订单详情</u></a>
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
                <div style="text-align: center;">
                    <ul id="pagination" class="pagination"></ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>