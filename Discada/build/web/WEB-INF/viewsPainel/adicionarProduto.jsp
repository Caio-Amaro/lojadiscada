<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>               
    <!-- Page content-->
    <div class="container-fluid" >
        <h4 id="sloganUm" class="mt-4" style="margin-bottom: 1em;">ADICIONAR NOVO PRODUTO</h4>
        <hr>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-8">
                
                <form action="${pageContext.request.contextPath}/adicionarProduto" method="POST" class="list-group-item">

                        <h6 id="sloganUm">TÍTULO DO PRODUTO</h6>                        
                        <input id="blockProductDois" class="form-control form-control-lg" name="titulo" type="text" >

                        <h6 id="sloganUm" style="margin-top:2em;">DESCRIÇÃO DO PRODUTO</h6>
                        <textarea id="blockProductDois" class="form-control" name="descricao" rows="5"></textarea>

                        <hr>                        
                        
                            <h5 id="sloganUm"> ENTREGA </h5>
                        
                        <hr>
                            <div class="col-12 col-md-6">
                                <label id="sloganUm" style="margin-top: 2em;">Peso (Kg)</label>
                                <input id="blockProductDois" type="text" name="peso" class="form-control">
                            </div>
                            
                            <div class="col-12 col-md-6">
                                <label id="sloganUm" style="margin-top: 2em;">Altura (cm)</label>
                                <input id="blockProductDois" type="text" name="altura" class="form-control">
                            </div>
                        
                            <div class="col-12 col-md-6">
                                <label id="sloganUm" style="margin-top: 2em;">Largura (cm)</label>
                                <input id="blockProductDois" type="text" name="largura" class="form-control">
                            </div>
                            <div class="col-12 col-md-6">
                                <label id="sloganUm" style="margin-top: 2em;">Comprimento (cm)</label>
                                <input id="blockProductDois" type="text" name="compri" class="form-control">
                            </div>
                            
                            <div class="col-12 col-md-6">
                                <label id="sloganUm" style="margin-top: 2em;">Preço do Produto R$</label>
                                <input id="blockProductDois" type="text" name="preco" class="form-control">
                            </div>
                        
                        <div class="col-12 col-md-6">
                            <label id="sloganUm" style="margin-top: 2em;">Quantidade</label>
                            <input id="blockProductDois" type="text" name="qtd" class="form-control">
                        </div>

                        <hr>
                        
                        <label id="sloganUm" for="categoria">Escolha uma Categoria</label>
                        <div class="col-12 col-md-6">
                            
                            <select id="blockProductDois" name="categoria" class="form-control">
                                <option selected>Escolha Por Categoria</option>
                                <c:forEach var="obj" items="${categ}">
                                    <option value="${obj.catid}">${obj.catnome}</option>
                                </c:forEach>
                            </select>
                        </div>
                                                
                        <div class="form-group" style="margin-top: 2em;">
                            <label id="sloganUm"> Adicone Imagens do Produto</label>
                            <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                        </div>
                            
                        <hr>
                        <div class="form-group">
                            <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 5em;">
                                  <i class="bi bi-plus-circle-dotted"> CRIAR NOVO PRODUTO</i>
                            </button>
                        </div>
                        
                </form>   
            </div>
      </div>
    </div> 
</body>
