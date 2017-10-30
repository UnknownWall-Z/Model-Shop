<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ice哥商城管理平台</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
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
                <legend>用户基本信息</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>用户ID</th>
                        <th>昵称</th>
                        <th>邮箱</th>
                        <th>注册时间</th>
                        <th>最后登录时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${users.id}</td>
                        <td>${users.nickName!""}</td>
                        <td>${users.email!""}</td>
                        <td>2015-08-08</td>
                        <td>2017-08-16</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>用户账户信息</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>账户资金</th>
                        <th>账户冻结资金</th>
                        <th>用户等级</th>
                        <th>等级积分</th>
                        <th>会员积分</th>
                        <th>会员账户流水</th>
                        <th>充值金额</th>
                        <th>提现金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${users.userMoney}</td>
                        <td>你猜~~</td>
                        <td>青铜会员</td>
                        <td>0~1500</td>
                        <td>${users.account}</td>
                        <td>查看详细流水</td>
                        <td>1000</td>
                        <td>不给提现~~</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>用户订单信息</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>有效订单数</th>
                        <th>成功交易金额</th>
                        <th>最近交易时间</th>
                        <th>最近交易金额</th>
                        <th>退货次数</th>
                        <th>退货金额</th>
                        <th>发货后退货率</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>12</td>
                        <td>10086</td>
                        <td>2012-12-22</td>
                        <td>666</td>
                        <td>2</td>
                        <td>123</td>
                        <td>50%</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
                <legend>用户地址</legend>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>收货人</th>
                        <th>联系方式</th>
                        <th>收货地址</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderInfo.consignee!""}</td>
                        <td>${orderInfo.mobile!""}</td>
                        <td>${orderInfo.address!""}</td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>


</body>
</html>