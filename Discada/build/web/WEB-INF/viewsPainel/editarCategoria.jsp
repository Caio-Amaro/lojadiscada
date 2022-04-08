
                
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
                <div class="container-fluid" >
                    <h2 class="mt-4" style="margin-bottom: 1em;">GERENCIAR CATEGORIA</h2>
                    <hr>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-4">
                            <div>
                                <form action="${pageContext.request.contextPath}/editarCategoria" method="POST" class="list-group-item">
                                
                                    <h5>Nome da Categoria</h5>
                                    <input class="form-control form-control-lg" name="catnome" type="text" value="${selecioca.catnome}" >
                                    <input type="hidden" value="${selecioca.catid}" name="idcat">
                                    <hr>

                                    <button type="submit" class="btn btn-primary">
                                            <i class="bi bi-plus-circle-dotted"> EDITAR CATEGORIA</i>
                                    </button>

                                </form>
                            </div>
                            
                        </div>

                    
                        <div class="col-8" style="background-color: #F5FFFA;">
                                <div class="">
                                    <table class="table">
                                            <thead>
                                            <tr>
                                            <h5>Categorias Cadastradas</h5>
                                            <hr>
                                              <th scope="col">ID</th>
                                              <th scope="col">NOME DA CATEGORIA</th>
                                            </tr>
                                        </thead>
                                      
                                    <tbody>
                                            
                                        <c:forEach var="oj" items="${ControleCategoria.catDao.listaObjetos}">
                                            <tr>
                                                  <th>#${oj.catid}</th>
                                                  <td style="text-transform: uppercase;"><strong>${oj.catnome}</strong></td>
                                                  
                                                  
                                            </tr>
                                        </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>

            </div>    
        </div>
    </body>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../../js/scripts.js"></script>

</html>