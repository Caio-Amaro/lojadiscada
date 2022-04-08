                
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
<body>
    <div class="container-fluid">
        <h3 id="sloganUm" class="mt-4">Controle de Clientes</h3>
        <form class="form-inline" action="${pageContext.request.contextPath}/consultaNomeCliente" method="POST">
            <div class="row ">            
                <div class="container-fluid">
                    <div class="col-6">
                        <input type="search" id="form1" name="nomecliente" class="form-control" placeholder="Nome do Clientes" />
                        <button type="button" class="btn btn-outline-dark" style="margin-top: 1em;">
                            <i class="bi bi-box-seam"> PESQUISAR </i>
                        </button>
                    </div>                              
                </div>
            </div>
        </form>
        <hr>
    </div>



<div class="">
    <table class="table">
        <thead  class="thead-dark">
            <tr>
                <th scope="col">ID do Cliente</th>
                <th scope="col">Nome</th>                              
                <th scope="col">Sobrenome</th>
                <th scope="col">E-mail</th>
                <th scope="col">DDD</th>
                <th scope="col">Telefone</th>
                <th scope="col">Ativação</th>
                <th scope="col"></th>

            </tr>
        </thead>
               

        <tbody>
            
            <c:forEach var="obj" items="${cliet}">
                <tr>
                    <th scope="row">${obj.cliid}</th>
                    <td>${obj.clinome}</td>
                    <td>${obj.clisobrenome}</td>
                    <td>${obj.cliemail}</td>
                    <td>${obj.cliddd}</td>
                    <td>${obj.clitelefone}</td>
                    <td>
                        <c:choose>
                            <c:when test="${obj.cliativo != 1}">
                                <span style="color: red;">DESATIVADO</span>
                            </c:when>
                            <c:when test="${obj.cliativo == 1}">
                                <span style="color: green;">ATIVO</span>
                            </c:when>
                        </c:choose>
                    </td>
                    <td>
                        <form action="${pageContext.request.contextPath}/detalheClientes" method="GET">
                            <div style="margin-top: .5em;">
                                <input type="hidden" value="${obj.cliid}" name="idcliente">
                                <button style="margin-top:.5em; margin-left: .1em; width: 100%; height: auto;" type="submit" class="btn btn-warning my-1">Ver Dados Detalhados</button>                                      
                            </div>
                        </form>

                    </td>
                </tr>
            </c:forEach>  
        </tbody>
    </table>
</div>
</body>
<%-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../../js/scripts.js"></script>--%>

</html>
