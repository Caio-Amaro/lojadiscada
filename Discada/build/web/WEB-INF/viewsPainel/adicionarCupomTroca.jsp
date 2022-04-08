<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>               
    <!-- Page content-->
    <div class="container-fluid" >
        <h4 id="sloganUm" class="mt-4" style="margin-bottom: 1em;">ADICIONAR NOVO CUPOM DE TROCA</h4>
        <hr>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-8">
         
               <form action="${pageContext.request.contextPath}/adicionarCupomTroca" method="POST" class="list-group-item">

                        <h5 id="sloganUm">Nome do Cupom</h5>
                        <input id="blockProductDois" class="form-control form-control-lg" name="nomecupom" type="text" >

                        <h5 id="sloganUm" style="margin-top:1em;">ID do Cliente</h5>
                        <input id="blockProductDois" class="form-control" type="text" name="idcliente">
                
                        
                           <h5 id="sloganUm" style="margin-top: 2em;" >Valor do Cupom de Troca</h5>
                           <p> | IMPORTANTE! Adicione um valor em REAIS | </p>
                           
                        
                        <hr>
                           <input id="blockProductDois" style="margin-bottom: 1.5em;" type="text" name="valorcupom" class="form-control" placeholder="valor em R$">
                           <input name="troca" type="hidden" value="1">
                        <div class="form-group">
                            <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 5em;">
                                  <i class="bi bi-plus-circle-dotted"> CRIAR NOVO CUPOM DE TROCA</i>
                            </button>
                        </div>
                </form>
            </div>
            <div class="col-4">
                <h5 id="sloganUm">Consulte Id do Cliente</h5>
                    <table class="table">
                        <tr>                                    
                           <th>ID</th>
                           <th>Nome</th>
                           <th>Sobrenome</th>
                        </tr>
                    <c:forEach var="ob" items="${clientg}">
                        <tr style="font-family:monospace; ">
                            <td>${ob.cliid}</td>
                            <td>${ob.clinome}</td>
                            <td>${ob.clisobrenome}</td>
                        </tr>
                                
                    </c:forEach>
                    </table>
             </div>
        </div>
    </div>
</body>
      

