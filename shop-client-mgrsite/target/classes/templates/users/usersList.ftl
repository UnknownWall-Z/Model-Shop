<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ice哥商城管理平台</title>
<#include "../common/header.ftl"/>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
    <script type="text/javascript">
        $(function () {

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
<#assign currentMenu="users_list">
<#include "../common/top.ftl"/>
    <div class="row">
        <div class="col-sm-3">
        <#include "../common/menu.ftl" />
        </div>
        <div class="col-sm-9">
            <div class="page-header">
                <h3>用户管理</h3>
            </div>
            <form id="searchForm" class="form-inline" method="post" action="/usersList">
                <input type="hidden" id="currentPage" name="currentPage" value=""/>
                <div class="form-group">
                    <label>用户名称</label>
                    <input class="form-control" type="text" name="nickName"  value='${qo.nickName!""}'/>
                </div>
                <div class="form-group">
                    <label>积分范围</label>
                    <input class="form-control minAccount" type="text" name="minAccount" value='${qo.minAccount!""}'/>~
                    <input class="form-control maxAccount" type="text" name="maxAccount" value='${qo.maxAccount!""}'/>
                </div>
                <div class="form-group">
                    <button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
                </div>
            </form>
            <div class="panel panel-default">
                <table class="table">
                    <thead>
                    <tr>
                        <th>用户编号</th>
                        <th>用户名</th>
                        <th>用户邮箱</th>
                        <th>用户电话</th>
                        <th>用户生日</th>
                        <th>用户积分</th>
                        <th>用户平台余额</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <#list pageResult.listdata as item>
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.nickName!""}</td>
                        <td>${item.email!""}</td>
                        <td>${item.phone!""}</td>
                        <td>${(item.birthday?string("yyyy-MM-dd"))!""}</td>
                        <td>${item.account!""}</td>
                        <td>${item.userMoney!""}</td>
                        <td>
                            <a href="userInfo?id=${item.id}"><u>用户详情</u></a>
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