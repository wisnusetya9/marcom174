<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<c:forEach items="${productModelList}" var="productModel" varStatus="number">
	<tr>
		<td>${number.count}</td>
		<td>${productModel.code}</td>
		<td>${productModel.name}</td>
		<td>${productModel.description}</td>
		<td>
			<fmt:formatDate value="${productModel.createdDate}" pattern="dd/MM/yyyy"/>
		</td>
		
		<td>${productModel.createdBy}</td>
		<td>
			<button type="button" style="background: none; border: 0; padding-right: 0; " id="button-detail" value="${productModel.id}"><i class="fa fa-search"></i></button>
			<button type="button" style="background: none; border: 0; padding-right: 0;" id="button-edit" value="${productModel.id}"><i class="fa fa-pencil"></i></button>
			<button type="button" style="background: none; border: 0; padding-right: 0;" id="button-delete" value="${productModel.id}"><i class="fa fa-trash"></i></button>
		</td>
	</tr>
</c:forEach>