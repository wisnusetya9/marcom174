<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:forEach items="${souvenirsettlementModelList}" var="souvenirsettlementModel" varStatus="number">
	<tr>
		<td>${number.count}</td>
		<td>${souvenirsettlementModel.code}</td>
		<td>${souvenirsettlementModel.requestByUser.username}</td>
		<td>
			<fmt:formatDate value="${souvenirsettlementModel.request_date}" pattern="dd/MM/yyyy"/>
		</td>
		<td>
			<fmt:formatDate value="${souvenirsettlementModel.dueDate}" pattern="dd/MM/yyyy"/>
		</td>
		<td>
			<c:choose>
				<c:when test="${souvenirsettlementModel.status == 1}">
					Submitted
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 2}">
					In Progress
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 3}">
					Received By Requester
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 4}">
					Settlement
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 5}">
					Approved Settlement
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 6}">
					Close Request
				</c:when>
				<c:when test="${souvenirsettlementModel.status == 0}">
					Rejected
				</c:when>
				<c:otherwise>
				
				</c:otherwise>
			</c:choose>	
		</td>
		<td><fmt:formatDate value="${souvenirsettlementModel.createdDate}" pattern="dd/MM/yyyy"/></td>
		<td>
			${souvenirsettlementModel.createdByUser.roleModel.nama}
		</td>
		<td>
			<button style="border: none;padding: 0;background: none;" type="button" id="button-approval" value="${souvenirsettlementModel.id}">
				<i class="fa fa-pencil"></i>
			</button>
		</td>
	</tr>
</c:forEach>