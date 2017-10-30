<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ice哥商城管理平台</title> <#include "../common/header.ftl"/>
<script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
<script type="text/javascript" src="/js/plugins/jquery.twbsPagination.min.js"></script>
<script type="text/javascript" src="/js/plugins/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/js/plugins/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/js/plugins/uploadify/jquery.uploadify.js"></script>
    <style type="text/css">
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
    </style>
<script type="text/javascript">
	$(function() {
		$(".uploadImage").uploadify(
			{
				swf : "/js/plugins/uploadify/uploadify.swf",
				uploader : "/product/uploadProductImage",
				buttonText : "选择图片",
				fileObjName : "file",
				fileTypeExts : "*.gif; *.jpg; *.png",
				overrideEvents : [  "onUploadSuccess", "onUploadProgress", "onSelect" ],
				onUploadSuccess : function(file, data) {
					var $wrapper = this.wrapper;
					var $div = $wrapper.parent('div').parent('div');
					//data = JSON.parse(data);
					$div.find('img').attr('src', data);
					$div.find('input').val(data);
					//$div.find('input').val(data.id);
			}
		});
    })

	$(function() {
		var editor = CKEDITOR.replace('desc');
		$('#myTabs a').click(function(e) {
			e.preventDefault()
			$(this).tab('show')
		});

		$("#saveButton").click(function() {
			$("#desc").html(editor.getData());
			$("#productUpdateForm").ajaxSubmit(function(data) {
				if (data.success) {
					$.messager.confirm("提示", "保存成功", function() {
						window.location.href = "/product/get";
					})
				} else {
					$.messager.alert("提示", data.msg);
				}
			})
		});

	});
	
	function changeCatalog(obj){
		var catalogId = $(obj).val();
		if (catalogId){
			//重新加载商品的属性面板
			$('#productPropertyPanel').load(
					'/catalogProperty/propertyValue/get/'
							+ catalogId);
			//重新加载商品sku
			/* $('#productSkuPanel').load(
				'/getSkuPropertyPanel.do?catalogId='
						+ catalogId); */
		}
		else {
			//商品属性面板
			$('#productPropertyPanel').empty();
			//sku面板
			$('#productSkuPanel').empty();
		}
	}
</script>
</head>
<body>
	<div class="container">
		<#include "../common/top.ftl"/>
		<div class="row">
			<div class="col-sm-3">
			<#assign currentMenu="add_product" /> 
			<#include "../common/menu.ftl" /></div>
			<div class="col-sm-9">
				<div class="page-header">
					<h3>商品编辑</h3>
				</div>

				<div class="panel panel-default">
					<div id="myTabs">

						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active"><a href="#base" aria-controls="base" role="tab" data-toggle="tab">基本信息</a></li>
							<li role="presentation"><a href="#detail" aria-controls="detail" role="tab" data-toggle="tab">商品详情</a></li>
							<li role="presentation"><a href="#image" aria-controls="image" role="tab" data-toggle="tab">商品相册</a></li>
							<li role="presentation"><a href="#property" aria-controls="property" role="tab" data-toggle="tab">商品属性</a></li>
							<!-- <li role="presentation"><a href="#sku" aria-controls="sku" role="tab" data-toggle="tab">sku</a></li>-->						
						</ul>

						<!-- 提交商品保存表单 -->
						<form action="/product/updateProduct" method="post" id="productUpdateForm">
							<!-- Tab panes -->
							<div class="tab-content">

								<div role="tabpanel" class="tab-pane active" id="base">
									<!-- 基本信息的页面 -->
									<#include "product_eidt_base_info.ftl"/>
								</div>

								<div role="tabpanel" class="tab-pane" id="detail">
									<!-- 商品详情 -->
									<div class="row">
										<div class="col-lg-12">
											<div class="form-group">
												<textarea id="desc" name="productDesc.details" class="ckeditor" rows="10" >${productDesc.details}</textarea>
											</div>
										</div>
									</div>
								</div>
								<#--商品相册-->
								<div role="tabpanel" class="tab-pane" id="image">
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
                                        <#macro productImage number productImages>
                                            <div class="col-lg-3 col-md-6">
                                                <div class="image-div">
                                                    <div>
                                                        <a href="javascript:;" id="uploadImage-btn${number}" class="uploadImage">上传</a>
                                                    </div>
                                                    <img class="uploadImg"
                                               			 src='${(productImages[number].imagePath=='')?string("/53fe2b8b-a0f3-4596-a939-912c98dd9a2d.png",productImages[number].imagePath)}'/>
                                                    <input type="hidden" name="productImages[${number}].imagePath" value="${(productImages[number].imagePath)!""}">
                                                </div>
                                                <div class="input-group">
                                                    <select class="form-control" name="productImages[${number}].sequence" id="sequence${number}">
                                                        <#list 1..8 as index>
                                                            <option value="${index}">${index}</option>
                                                        </#list>
                                                    </select>
                                                    <script>
                                                        $("#sequence${number} option[value=${(productImages[number].sequence)!"5"}]").attr("selected",true);
                                                    </script>
                                                    <span class="input-group-addon">
													<label id="coverState${number}">
														<input type="radio"  class="productImageCover" name="productImages[${number}].cover" value="1">
														<span>封面</span>
													</label>
													<script>
														$("#coverState${number} input[value=${(productImages[number].cover)!"0"}]").attr("checked",true);
													</script>
													</span>
                                                </div>
                                            </div>
                                        </#macro>
										<div class="row"><#list 0..7 as number> <@productImage number productImages/> </#list></div>
                                    </div>
                                </div>
								<#--属性-->
								<div role="tabpanel" class="tab-pane" id="property">
									<div style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
										<table class="table table-bordered catalog-property-table">
											<thead>
												<tr>
													<th>名称</th>
													<th>值</th>
												</tr>
											</thead>
											<tbody id="productPropertyPanel">
											</tbody>
                                            <script>
                                                var productId = $("#productId").val();
                                                var catalogId = $("#catalogId").val();
                                                if (productId){
                                                    //重新加载商品的属性面板
                                                    $('#productPropertyPanel').load(
                                                            '/catalogProperty/propertyValue/show/'
                                                            + productId+"/"+catalogId);
                                                    //重新加载商品sku
                                                    /* $('#productSkuPanel').load(
                                                        '/getSkuPropertyPanel.do?catalogId='
                                                                + catalogId); */
                                                }
                                                else {
                                                    //商品属性面板
                                                    $('#productPropertyPanel').empty();
                                                    //sku面板
                                                    $('#productSkuPanel').empty();
                                                }
                                            </script>
										</table>
									</div>
								</div>
								<!-- <div role="tabpanel" class="tab-pane" id="sku">
									<div id="productSkuPanel" style="padding-bottom: 10px; padding-left: 10px; padding-right: 10px; padding-top: 10px;">
									</div>
								</div> -->
							</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-primary" id="saveButton">保存</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>