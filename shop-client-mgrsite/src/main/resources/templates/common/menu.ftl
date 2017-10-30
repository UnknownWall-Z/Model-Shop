<ul id="menu" class="list-group">
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#permissionmanage_detail"><span>安全管理</span></a>
		<ul class="in" id="permissionmanage_detail">
			<li class="ipLog"><a href="/log"><span>日志管理</span></a></li>
		</ul>
	</li>
	<li class="list-group-item">
		<a href="#" data-toggle="collapse" data-target="#product_list">
			<span>商品管理</span>
		</a>
		<ul class="in" id="product_list">
			<li class="add_product"><a href="/product/add">商品录入</a></li>
			<li class="product_list"><a href="/product/get">商品列表</a></li>
			<li class="brand_list"><a href="/brand">品牌管理</a></li>
			<li class="catalog"><a href="/catalog">分类管理</a></li>
			<li class="catalogProperty"><a href="/catalogProperty">分类属性管理</a></li>
			<li class="skuProperty"><a href="/skuProperty">sku属性管理</a></li>
		</ul>
	</li>
    <li class="list-group-item">
        <a href="#" data-toggle="collapse" data-target="#order_list">
            <span>订单管理</span>
        </a>
        <ul class="in" id="order_list">
            <li class="order_list"><a href="/orderList">订单列表</a></li>
            <li class="OK_list"><a href="/OKList">订单确认列表</a></li>
            <li class="invoice_list"><a href="/invoiceList">发货单列表</a></li>
        </ul>
    </li>
    <li class="list-group-item">
        <a href="#" data-toggle="collapse" data-target="#users_list">
            <span>用户管理</span>
        </a>
        <ul class="in" id="users_list">
            <li class="users_list"><a href="/usersList">用户列表</a></li>
            <#--<li class="users_add"><a href="/usersAdd">添加会员</a></li>-->
           <#-- <li class="invoice_list"><a href="/invoiceList">发货单列表</a></li>-->
        </ul>
    </li>
</ul>

<#if currentMenu??>
<script type="text/javascript">
	$(".in li.${currentMenu}").addClass("active");
</script>
</#if>