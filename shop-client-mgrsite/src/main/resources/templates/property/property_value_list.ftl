<div class="modal-body">

		<input type="hidden" name="catalogProperty.id" value="${catalogProperty.id}"/>
	  <div class="form-group">
	  	<label>
	  		${catalogProperty.name}
	  	</label> 
	  	<div id="valueDiv">
			<script>
                var sequence = 0;
                function countValue() {
                    sequence++;
                }
			</script>
		  	<#list list as data>
		  		<div style="height: 50px;">
				    <input type="text" class="form-control" value="${data.value}" style="width: 200px;margin-bottom: 5px;float: left;">
					<h3 style="float: left;margin: 0;">
						<span class="label label-primary" style="cursor: pointer;" onclick="deleteValue(this,${data.id})">-</span>
					</h3>
		    	</div>
			<script>
                countValue();
			</script>
		    </#list>
	  	</div>
		<h3><span class="label label-primary" style="cursor: pointer;" onclick="addValue()">+</span></h3>
	  	<div class="modal-footer">
			<button type="button" class="btn btn-primary" onclick="submitValueForm()">关闭</button>
		</div>
	  </div>
</div>
