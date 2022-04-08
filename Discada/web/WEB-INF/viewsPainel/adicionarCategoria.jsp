
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
                                <form action="${pageContext.request.contextPath}/adicionarCategoria" method="POST">
                                
                                    <h5>Nome da Categoria</h5>
                                    <input name="nomecat" class="form-control form-control-lg" type="text">
                                     <hr>

                                    <button type="submit" class="btn btn-primary">
                                            <i class="bi bi-plus-circle-dotted"> CRIAR NOVA CATEGORIA</i>
                                    </button>

                                </form>
                            </div>
                            
                        </div>

                    
                        <div class="col-8" style="background-color: #F5FFFA;">
                                <div class="">
                                    <table class="table">
                                            <thead>
                                            <tr>
                                              <th scope="col">Id</th>
                                              <th scope="col">Nome</th>
                                              <th scope="col"></th>
                                              <th scope="col"></th>
                                              
                                            </tr>
                                        </thead>
                                      
                                    <tbody>
                                        <c:forEach var="obj" items="${ControleCategoria.catDao.listaObjetos}">
                                            <tr>
                                                  <th>${obj.catid}</th>
                                                  <td>${obj.catnome}</td>
                                                  <td><a class="btn btn-outline-secondary" href="/loja/editarCategoria?${obj.catid}" role="button">Editar</a></td>              
                                                  <td> <a href="/loja/adicionarCategoria?${obj.catid}" name="idRemove" class="btn btn-danger">Excluir</a></td>
                                            </tr>
                                    </  </c:forEach>
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