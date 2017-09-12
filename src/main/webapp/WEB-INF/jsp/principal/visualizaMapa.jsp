<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/jsp/template/header.jsp"/>

<div class="row-fluid">
    <h1>${lineId}</h1>
    <c:if test="${not empty lineId}">
        <div class="row-fluid bs-docs-example" >
            <div class="row-fluid bs-docs-example">
                <img src="${pageContext.servletContext.contextPath}/mapa/${userID}/mapa_${lineId}/mapa.png">                
            </div>
        </div>
    </c:if>
</div>


<c:import url="/WEB-INF/jsp/template/footer.jsp"/>

