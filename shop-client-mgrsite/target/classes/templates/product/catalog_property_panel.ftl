<#list productCatalogPropertyList as vo>
    <tr>
        <td>
        	${vo.name}
        	<input type="hidden"  name="productCatalogPropertyValue[${vo_index}].name" value="${vo.name}">
        </td>
        <td>
            <#if vo.type == 2>
                <select class="form-control" name="productCatalogPropertyValue[${vo_index}].value">
                    <#list vo.catalogPropertyValues as v>
                        <option value="${v.value}">${v.value}</option>
                    </#list>
                </select>
            <#elseif  vo.type == 0>
                 <input name="productCatalogPropertyValue[${vo_index}].value" class="form-control">
            <#else>
            </#if>
        </td>
    </tr>
</#list>