<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/jsp/template/header.jsp" />

<div class="row-fluid">

	<c:if test="${not empty analise.analise_lines_id}">
		<div class=" bs-docs-example">
	      <div class="bs-docs-text"> Mapa Tem�tico </div>
			<div class="row-fluid ">

				<div class="row-fluid span6">
					<img
						src="${pageContext.servletContext.contextPath}/mapa/${userID}/mapa_${analise.analise_lines_id}/mapa.png">
				</div>
				<div class="row-fluid span2">

					<table class="table table-bordered">
					<thead>
					    <tr>
					      <th>Informa��es</th>
					     
					    </tr>
					  </thead>
						<tbody>
							<tr>
								<th>�rea</th>
								<td>${analise.analiseHeader.area.nome}</td>
							</tr>
							
							<tr>
								<th>Amostra</th>
								<td>${analise.analiseHeader.amostra.descricao}</td>
							</tr>
							
							<tr>
								<th>Modelo</th>
								<td>${analise.modelo}</td>
							</tr>
							
							<tr>
								<th>M�todo</th>
								<td>${analise.metodo}</td>
							</tr>
							
							<tr>
								<th>Interpolador</th>
								<td>${analise.analiseHeader.tipo_analise}</td>
							</tr>
						</tbody>
					</table>

				</div>
			</div>
			
			<form action="<c:url value='/visualizaGeo'/> " method="post" >
		        <input id="analiseId" type="hidden" name="analiseId" value="${analise.analiseHeader.analise_header_id}" class="input-mini"/>    		 
				<button class="btn  btn-primary" type="submit"><i class="icon-circle-arrow-left icon-white"></i> Voltar</button>
		    </form>
			
		</div>
	</c:if>
</div>


<c:import url="/WEB-INF/jsp/template/footer.jsp" />

