<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items = "${souvenirSettlementModelList}" var="souvenirSettlementModel" varStatus="number">
<tr>
	<td>${number.count}</td>
	<td>${souvenirSettlementModel.code}</td>
	<%-- <td>${souvenirSettlementModel.requestByUser.roleModel.nama}</td> --%>
	<td>${souvenirSettlementModel.requestByUser.username}</td>
	<td>
		<fmt:formatDate value="${souvenirSettlementModel.request_date}" pattern="dd/MM/yyyy"/>
	</td>
	<td>
		<fmt:formatDate value="${souvenirSettlementModel.dueDate}" pattern="dd/MM/yyyy"/>
	</td>
	<td>
	<%-- ${souvenirSettlementModel.status} --%>
				<c:choose>
				<c:when test="${souvenirSettlementModel.status == 1}">
					Submitted
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 2}">
					In Progress
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 3}">
					Received By Requester
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 4}">
					Settlement
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 5}">
					Approved Settlement
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 6}">
					Close Request
				</c:when>
				<c:when test="${souvenirSettlementModel.status == 0}">
					Rejected
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose>
	</td>
	
	<td>
		<fmt:formatDate value="${souvenirSettlementModel.createdDate}" pattern="dd/MM/yyyy"/>
	</td>
	<%-- <td>${souvenirSettlementModel.createdByUser.roleModel.nama}</td>	 --%>
	<td>${souvenirSettlementModel.createdByUser.username}</td>	
	<td>
		<button type="button" style="background: none; border: 0; padding-right: 0;" id="button-detail" value="${souvenirSettlementModel.id}">
			<i class="fa fa-search"></i>
		</button>
		<button type="button" style="background: none; border: 0; padding-right: 0;" id="button-settlement" value="${souvenirSettlementModel.id}">
			<i class="fa fa-check"></i>
		</button>
		<%-- <button type="button" style="background: none; border: 0; padding-right: 0;"  id="button-edit" value="${souvenirSettlementModel.id}">
			<i class="fa fa-pencil"></i>
		</button> --%>
		
	
	</td>
</tr>
</c:forEach>