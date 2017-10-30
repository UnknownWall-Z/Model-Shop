<#list productCatalogPropertyList as vo>
    <tr>
        <td>
        	${vo.name}
        	<input type="hidden"  name="productCatalogPropertyValue[${vo_index}].name" value="${vo.name}">
        </td>
        <td>
            <#--<input name="productCatalogPropertyValue[${vo_index}].value" class="form-control" value="${vo.value}">-->
           <#if vo.type == 2>
                <select class="form-control" name="productCatalogPropertyValue[${vo_index}].value" id="showProperty">
                    <#list vo.catalogPropertyValues as v>
                        <option value="${v.value}">${v.value}</option>
                    </#list>
                </select>
                <script>
                    $("#showProperty option[value='${vo.tempValue}']").attr("selected",true);
                </script>
            <#elseif  vo.type == 0>
                <input name="productCatalogPropertyValue[${vo_index}].value" class="form-control" value="${vo.tempValue}">
            <#else>
            </#if>
        </td>
    </tr>
</#list>