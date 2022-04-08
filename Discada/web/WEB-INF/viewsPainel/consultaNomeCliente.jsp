                
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
<div class="container-fluid">
    <h1 class="mt-4">Controle de Clientes</h1>

    <form action="${pageContext.request.contextPath}/consultaNomeCliente" method="POST">
        <div class="row ">
            <div class="col-12 col-md-5">
                <input type="search" name="nomecliente" class="form-control" placeholder="Nome do Produto" />
            </div>
            <div class="col-6 col-md-2">
                <button type="submit" class="btn btn-primary">
                    <i class="bi bi-box-seam"> PESQUISA</i>
                </button>
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
                <th scope="col"></th>

            </tr>
        </thead>


        <tbody>
            <c:forEach var="obj" items="${clienome}">
                <tr>
                    <th scope="row">${obj.cliid}</th>
                    <td>${obj.clinome}</td>
                    <td>${obj.clisobrenome}</td>
                    <td>${obj.cliemail}</td>
                    <td>${obj.cliddd}</td>
                    <td>${obj.clitelefone}</td>
                    <td>
                        <form action="${pageContext.request.contextPath}/detalheClientes" method="GET">
                            <div style="margin-top: .5em;">
                                <input type="hidden" value="${obj.cliid}" name="idcliente">
                                <button style="margin-top:.5em; margin-left: .1em; width: 100%; height: auto;" type="submit" class="btn btn-outline-warning my-1">DETALHES DO CLIENTE</button>                                      
                            </div>
                        </form>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../../js/scripts.js"></script>

</html>
