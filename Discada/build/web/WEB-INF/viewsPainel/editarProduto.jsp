<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>               
    <!-- Page content-->
    <div class="container-fluid" >
        <h2 class="mt-4" style="margin-bottom: 1em;">ADICIONAR NOVO PRODUTO</h2>
        <hr>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-8">
                
                <form action="${pageContext.request.contextPath}/editarProduto" method="POST" class="list-group-item">

                        <h4>Título do Produto</h4>
                        <input class="form-control form-control-lg" name="nome" type="text" value="${selecionaProd.pronome}">

                        <h4 style="margin-top:1em;">Descrição do Produto</h4>
                        <textarea class="form-control" name="descr" rows="5">${selecionaProd.prodescr}</textarea>

                        <hr>                        
                        
                            <h5> ENTREGA </h5>
                        
                        <hr>
                            <div class="col-12 col-md-6">
                                <label>Peso (Kg)</label>
                                <input type="text" name="peso" class="form-control"  value="${selecionaProd.propeso}">
                            </div>
                            
                            <div class="col-12 col-md-6">
                                <label>Altura (cm)</label>
                                <input type="text" name="altura" class="form-control" value="${selecionaProd.proaltura}">
                            </div>
                        
                            <div class="col-12 col-md-6">
                                <label>Largura (cm)</label>
                                <input type="text" name="largura" class="form-control" value="${selecionaProd.prolargura}">
                            </div>
                            <div class="col-12 col-md-6">
                                <label>Comprimento (cm)</label>
                                <input type="text" name="compri" class="form-control" value="${selecionaProd.procompri}">
                            </div>
                            
                            <div class="col-12 col-md-6">
                                <label>Preço do Produto R$</label>
                                <input type="text" name="preco" class="form-control" value="${selecionaProd.propreco}">
                            </div>
                        
                        <div class="col-12 col-md-6">
                            <label>Quantidade</label>
                            <input type="text" name="qtd" class="form-control" value="${selecionaProd.proqtda}">
                        </div>

                        <hr>
                        
                        <label for="categoria">Escolha uma Categoria</label>
                        <div class="col-12 col-md-6">
                            
                            <select name="categoria" class="form-control">
                                <c:forEach var="obj" items="${categ}">
                                    <option value="${obj.catid}">${obj.catnome}</option>
                                </c:forEach>
                            </select>
                        </div>
                        
                        <div class="col-12 col-md-6" style="margin-top: 1.2em;">
                            <c:choose>
                                <c:when test="${selecionaProd.proativo == 1}">
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" name="desativar" value="0">
                                <label class="form-check-label" for="flexSwitchCheckDefault">DESATIVAR O PRODUTO DA VITRINE?</label>
                            </div>
                                </c:when>
                            </c:choose>
                            
                             <c:choose>
                                <c:when test="${selecionaProd.proativo != 1}">
                            <div class="form-check form-switch">
                                <input class="form-check-input" type="checkbox" name="desativar" value="1">
                                <label class="form-check-label" for="flexSwitchCheckDefault">ATIVAR O PRODUTO NA VITRINE?</label>
                            </div>
                                </c:when>
                            </c:choose>
                        </div>
                        
                        <input type="hidden" name="idproduto" value="${selecionaProd.proid}">
                                                
                        <div class="form-group" style="margin-top: 2em;">
                            <button type="submit" class="btn btn-primary" style="margin-bottom: 5em;">
                                  <i class="bi bi-plus-circle-dotted"> EDITAR DADOS DO PRODUTO</i>
                            </button>
                        </div>
                </form>   
            </div>
      </div>
    </div> 
</body>

