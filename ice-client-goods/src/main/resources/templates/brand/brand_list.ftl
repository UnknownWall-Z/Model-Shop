<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ice哥城管理平台</title>
<#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js" ></script>

<style type="text/css">
        #realAuthForm input ,#realAuthForm select{
            width: 260px;
        }
        .idCardItem{
            width: 160px;
            height: 150px;
            float:left;
            margin-right:10px;
            border: 1px solid #e3e3e3;
            text-align: center;
            padding: 5px;
        }
        .uploadImg{
            width: 120px;
            height: 100px;
            margin-top: 5px;
        }
        .swfupload{
            left: 0px;
            cursor: pointer;
        }
        .uploadify{
            height: 20px;
            font-size:13px;
            line-height:20px;
            text-align:center;
            position: relative;
            margin-left:auto;
            margin-right:auto;
            cursor:pointer;
            background-color: #337ab7;
            border-color: #2e6da4;
            color: #fff;
        }
        .uploadExample{
            width: 200px;
            height: 130px;
            margin-bottom: 20px;
        }
</style>

<script type="text/javascript">
		//console.error("Hello World")		
	$(function(){
		$("#query").click(function(){
			$("#currentPage").val(1);
			$("#searchForm").submit();
		});
		
		$("#pagination_container").twbsPagination({
			totalPages:${pageResult.totalPage},
			visiblePages:5,
			startPage:${pageResult.currentPage},
			first:"首页",
			prev:"上一页",
			next:"下一页",
			last:"末页",
			onPageClick:function(event,page){
				$("#currentPage").val(page);
				$("#searchForm").submit();
			}
		});
		
		$("table > tbody > tr").click(function () {
			$("table > tbody > tr").removeClass("active");
			
		    $(this).addClass("active");
		    
		    $("#brandIdHidden").val($(this).data("id"));
	    });
		
		$(".edit-brand").click(function(){
			if($("#brandIdHidden").val() && $("#brandIdHidden").val() != ""){
                $("#editForm")[0].reset();
                $("#id").val($("#brandIdHidden").val());
                $.ajax({
                    type: "POST",
                    url: "/brand/get",
                    async: false,
                    data: {id:$("#brandIdHidden").val()},
                    success: function(data){
                        $("#myModal2 [name=chineseName]").val(data.chineseName);
                        $("#myModal2 [name=english]").val(data.english);
                        $("#myModal2 [name=createdDate]").val(data.createdDate);
                        $("#myModal2 [name=foundDate]").val(data.foundDate);
                        $("#myModal2 [name=url]").val(data.url);
                        $("#myModal2 [name=lastModifiedDate]").val(data.lastModifiedDate);
                        $("#uploadImg").attr("src",data.logo);
                        $("#myModal2 [name=description]").html(data.description);
                    }
                });
                $("#myModal2").modal("show");
			}else{
				$.messager.alert("请选择需要编辑的品牌")
			}
		})
		
		$(".show-brand").click(function(){
			if($("#brandIdHidden").val() && $("#brandIdHidden").val() != ""){
                $.ajax({
                    type: "POST",
                    url: "/brand/get",
                    async: false,
                    data: {id:$("#brandIdHidden").val()},
                    success: function(data){
                        $("#myModal1 [name=chineseName]").html(data.chineseName);
                        $("#myModal1 [name=english]").html(data.english);
                        $("#myModal1 [name=createdDate]").html(data.createdDate);
                        $("#myModal1 [name=foundDate]").html(data.foundDate);
                        $("#myModal1 [name=url]").html(data.url);
                        $("#myModal1 [name=lastModifiedDate]").html(data.lastModifiedDate);
                        $("#myModal1 [name=logo]").attr("src",data.logo);
                        $("#myModal1 [name=description]").html(data.description);
                    }
                });
                $("#myModal1").modal("show");
			}else{
				$.messager.alert("请选择需要查看的品牌")
			}
		});
		
		$(".add-brand").click(function(){
            $("#editForm")[0].reset();
            $("#myModal2").modal("show");
		});

        $("#comfirm").click(function(){
            $("#editForm").ajaxSubmit(function(data){
                if(data.success){
                    $("#currentPage").val(1);
                    $("#searchForm").submit();
                }
            });
        });

        $("#uploadBtn").uploadify({
            swf : "/js/plugins/uploadify/uploadify.swf",
            uploader : "/brand/uploadImage",
            fileObjName : "image",
            buttonText : "上传正面",
            fileTypeExts : "*.gif;*.jpg;*.png;*.jpeg",
            multi:false,
            overrideEvents : ["onSelect","onUploadSuccess"],
            onUploadSuccess : function(file, data, response){
                if(response){
                    $("#uploadImg").attr("src",data);
                    $("#uploadImage").val(data);
                }
            }
        });
	});
</script>
</head>
<body>
<input type="hidden" id="brandIdHidden"/>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
				<#assign currentMenu="brand_list" />
				<#include "../common/menu.ftl" />
			</div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>品牌管理</h3>
				</div>
				<div class="row">
					<!-- 提交分页的表单 -->
					<form id="searchForm" class="form-inline" method="post" action="/brand">
						<input type="hidden" name="currentPage" id="currentPage" value=""/>
						<div class="form-group">
						</div>
						<div class="form-group">
						    <label>关键字</label>
						    <input class="form-control" type="text" name="keyword" value="${(qo.keyword)!''}">
						</div>
						<div class="form-group">
							<button id="query" type="button" class="btn btn-success"><i class="icon-search"></i> 查询</button>
							<a href="javascript:;" class="btn btn-success edit-brand">编辑品牌</a>
							<a href="javascript:;" class="btn btn-success show-brand">查看品牌</a>
							<a href="javascript:;" class="btn btn-success add-brand">增加品牌</a>
						</div>
					</form>
				</div>

				<div class="panel panel-default">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>中文名称</th>
								<th>英文名称</th>
								<th>添加日期</th>
								<th>创建日期</th>
								<th>品牌链接</th>
								<th>最后修改日期</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<#list pageResult.listData as data>
							<tr data-id="${data.id}">
						        <td>${data.chineseName!""}</td>
								<td>${data.english}</td>
								<#--<td>${(data.createdDate?string("yyyy-MM-dd"))!""}</td>-->
								<#--<td>${(data.foundDate?string("yyyy-MM-dd"))!""}</td>-->
						        <td>${data.url!""}</td>
						        <td>${data.logo}</td>
						        <td>${data.telephone}</td>
						        <#--<td>${(data.lastModifiedDate?string("yyyy-MM-dd"))!""}</td>-->
							</tr>
							</#list>
						</tbody>
					</table>
					<div style="text-align: center;" id="pagination_container">
						
					</div>
				</div>

                <div class="modal fade" id="myModal1" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                    <fieldset>
                                        <div id="legend" class="">
                                            <legend>品牌查看</legend>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">中文名称</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="chineseName"></label>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">英文姓名</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="english"></label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">添加日期</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="createdDate"></label>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">创建日期</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="foundDate"></label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">URL</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="url"></label>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">最后修改日期</label>
                                            <div class="col-sm-4">
                                                <label class="form-control" name="lastModifiedDate"></label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">Logo图标</label>
                                            <div class="col-sm-4">
                                                <img src="" name="logo" style="width: 150px;"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="name">品牌描述</label>
                                            <div class="col-sm-6">
                                                <textarea name="description" rows="4" cols="60" readonly="readonly"></textarea>
                                            </div>
                                        </div>
                                    </fieldset>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-body">
                                <form class="form-horizontal" id="editForm" method="post" action="/brand/save">
                                    <input type="hidden" name="id" id="id" value="" />
                                    <fieldset>
                                        <div id="legend" class="">
                                            <legend>品牌查看</legend>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">中文名称</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="chineseName"></input>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">英文姓名</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="english"></input>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">添加日期</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="createdDate" onclick="WdatePicker()"></input>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">创建日期</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="foundDate" onclick="WdatePicker()"></input>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <label class="col-sm-2 control-label" for="name">URL</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="url"></input>
                                            </div>
                                            <label class="col-sm-2 control-label" for="name">最后修改日期</label>
                                            <div class="col-sm-4">
                                                <input class="form-control" name="lastModifiedDate" onclick="WdatePicker()"></input>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label" for="name">品牌描述</label>
                                            <div class="col-sm-6">
                                                <textarea name="description" rows="4" cols="60"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2  control-label" for="address">Logo照片</label>
                                            <div class="col-sm-6">
                                                <div class="idCardItem">
                                                    <div>
                                                        <a href="javascript:;" id="uploadBtn" >上传照片</a>
                                                    </div>
                                                    <img alt="" src="" class="uploadImg" id="uploadImg" />
                                                    <input type="hidden" name="logo" id="uploadImage" />
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" id="comfirm">确定</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>
                        </div>
                    </div>
                </div>

			</div>
		</div>
	</div>
</body>
</html>