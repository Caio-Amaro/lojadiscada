<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<!-- Page content-->

<h4 style="text-align: center;" class="mt-4">PESQUISA ANUAL DE MOVIMENTA��O</h4>

<div class="container-fluid">
    <hr>
    <form action="${pageContext.request.contextPath}/pesquisaVendasMes" method="POST">
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            <label>ESCOLHA O PRODUTO PARA AN�LISE ANUAL DE PROGRESS�O</label>
            
            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendas" method="POST">
                <div class="row">
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/m�s/ano">
                    </div>
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/m�s/ano">
                    </div>

                    <div style="margin-top: .5em;">
                        <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVAN�AR NA PESQUISA</button>
                    </div>
                </div>
            </form>
        </div>
    </form>
</div>
        <hr>
        <hr>  <%-- transform: rotateX(180deg); --%>
  <h3>Gr�fico de Progress�o de Vendas</h3>
  <h1>Teste ${dtini}</h1>
  <h1>Teste Dois ${testee}</h1>
  <h1>Teste Dtr�s ${testeei}</h1>
  <c:forEach var="tey" items="${tes}">
      <p>tetetete : ${tey}</p>
      
  </c:forEach>
<div style="margin-top: 3em; margin-bottom: 10em;" class="row">
   
    
   
</div>     
        <p style="margin-top: 30em;"></p>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>       
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
