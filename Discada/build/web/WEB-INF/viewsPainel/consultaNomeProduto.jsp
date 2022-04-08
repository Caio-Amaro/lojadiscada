<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Page content-->
                <div class="container-fluid">
                    <h1 class="mt-4" style="margin-bottom: 1em;">Controle de Estoque</h1>
                       
                        <form action="${pageContext.request.contextPath}/consultaNomeProduto" method="POST">
                            <div class="row ">
                                <div class="col-12 col-md-5">
                                    <input type="search" name="srch" class="form-control" placeholder="Nome do Produto" />
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
                        <thead>
                        <tr>
                          <th scope="col">Id Produto</th>
                          <th scope="col">Título</th>
                          <th scope="col">Qtda Estoque</th>
                          <th scope="col">Preço</th>
                          <th scope="col">Categoria</th>
                          <th></th>
                          <th></th>
                        </tr>
                    </thead>
                  
                <tbody>                    
                        <c:forEach var="obj" items="${prodcon}">
                            <tr>
                            
                              <th>#${obj.proid}</th>
                              <td>${obj.pronome}</td>
                              <td style="color:green;">${obj.proqtda}</td>
                              <td> 
                                <c:choose>
                                    <c:when test="${obj.propreco != null && obj.propreco > 0 }">
                                        <fmt:formatNumber value="${obj.propreco}" type="currency"/>
                                    </c:when>
                                </c:choose>
                              </td>                              
                              <td>${obj.proidcategoria.getCatnome()}</td>
                              <td><a class="btn btn-outline-secondary" href="/loja/editarProduto?${obj.proid}" role="button">Editar</a></td>              
                              <td> <a href="/loja/controleEstoque?${obj.proid}" name="idRemove" class="btn btn-danger">Excluir</a></td>
                            
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