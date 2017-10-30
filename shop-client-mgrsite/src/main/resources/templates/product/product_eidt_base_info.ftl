<div style="padding-bottom: 10px;padding-left: 10px;padding-right: 10px;padding-top: 10px;">
	<div class="row">
		<div class="col-lg-6">
			<div class="form-group">
                <input id ="productId" type="hidden"  name="product.id"  value=${product.id} >
				<label>商品名称</label> <input class="form-control" name="product.name"  value=${product.name}>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="form-group">
				<label>商品编号</label> <input class="form-control" name="product.code" value=${product.code}>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="form-group">
				<label>所属品牌</label>
                <select class="form-control" name="product.brand.id" id="brandSelect">
					<option value="-1">请选择</option>
          		 	 <#list brands as brand>
               			 <option value="${brand.id}">${brand.chineseName}</option>
					</#list>
				</select>
				<script type="text/javascript">
					$("#brandSelect").val(${product.brand.id});
				</script>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="form-group">
				<label>所属分类</label>
				<select class="form-control"
					id="catalogId" name="product.catalog.id" onchange="changeCatalog(this)">
					<option value="-1">请选择</option>
					<#list catalogs as catalog>
						<option value="${catalog.id}">${catalog.name}</option>
					</#list>
				</select>
                <script>
                    $("#catalogId").val(${product.catalog.id});
                </script>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="form-group">
				<label>市场售价</label>
                <input class="form-control" name="product.marketPrice"  value=${product.marketPrice}>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="form-group">
				<label>基础售价</label>
                <input class="form-control" name="product.basePrice" value=${product.basePrice}>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6">
			<div class="form-group">
				<label>是否上架</label>
				<div id="State1">
					<label class="radio-inline"> <input type="radio" name="product.shelves" value="true" ${(product.shelves)?string('checked','')} >是 </label>
					<label class="radio-inline"> <input type="radio" name="product.shelves" value="false" ${(product.shelves)?string('','checked')}>否 </label>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="form-group">
				<label>是否推荐</label>
				<div id="State2">
					<label class="radio-inline"> <input type="radio" name="product.recommended" value="true" ${(product.recommended)?string('checked','')}>是</label>
                    <label class="radio-inline"> <input type="radio"name="product.recommended" value="false" ${(product.recommended)?string('','checked')}>否</label>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				<label>商品关键字</label>
                <input class="form-control" placeholder="以逗号分隔" name="product.keyword" value=${product.keyword}>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="form-group">
				<label>商品标签</label>
				<textarea class="form-control" rows="3" placeholder="以逗号分隔"
                          name="product.impressions" >${product.impressions}</textarea>
			</div>
		</div>
	</div>
</div>