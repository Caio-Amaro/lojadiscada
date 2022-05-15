<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>
    
    <script type="text/javascript">
      function drawChart() {
        var stars = [11850, 52122, 14825, 6939, 69763];
        var starsDois = [3850, 5122, 142825, 639, 663];
        var frameworks = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho'];
        new Chart('myChart', {
          type: 'line',
          data: {
            labels: frameworks,
            datasets: [{
              label: 'Vendas Gerais',
              data: stars               
            },{
              label: 'Vendas Gerais',
              data: starsDois               
            }]
          },
        });
      }
    </script>
     <!-- FIm do Teste -->

</head>

<body onload="drawChart()">

<!-- Page content-->

<h4 style="text-align: center;" class="mt-4">PESQUISA ANUAL DE MOVIMENTAÇÃO</h4>

<div class="container-fluid">
    <hr>
    <form action="${pageContext.request.contextPath}/pesquisaVendasBean" method="POST">
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            <label>ESCOLHA O PRODUTO PARA ANÁLISE ANUAL DE PROGRESSÃO</label>
            
            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendas" method="POST">
                <div class="row">
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                    </div>
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                    </div>

                    <div style="margin-top: .5em;">
                        <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                    </div>
                </div>
            </form>
        </div>
    </form>
</div>
        <hr>
        <hr>  <%-- transform: rotateX(180deg); --%>
  <h3>Gráfico de Progressão de Vendas</h3>
  
  <c:forEach var="tey1" items="${prodOneUm}">
      <p>Produto : ${tey1}</p>      
  </c:forEach>
  <c:forEach var="tey" items="${prodOne}">
      <p>Quantidade : ${tey}</p>      
  </c:forEach>
    <c:forEach var="tey2" items="${prodOneDois}">
      <p>Vendas : R$ ${tey2}</p>      
  </c:forEach>
  
      <%-- --------------------------------------------- --%>
  
  <c:forEach var="te1" items="${prodTwOne}">
      <p>Produto : ${te1}</p>      
  </c:forEach>
  <c:forEach var="te" items="${prodTw}">
      <p>Quantidade : ${te}</p>      
  </c:forEach>  
  <c:forEach var="te2" items="${prodTwDois}">
      <p>Vendas : R$ ${te2}</p>      
  </c:forEach>    
      
      
<div style="margin-top: 3em; margin-bottom: 10em;" class="row">
   
    
   
</div>     
        <p style="margin-top: 30em;"></p>
</body>

