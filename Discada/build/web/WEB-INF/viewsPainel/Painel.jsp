<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.io.*, javax.imageio.*, java.awt.image.*, javax.servlet.*, javax.servlet.http.*,org.jfree.chart.*, org.jfree.chart.plot.*, org.jfree.data.category.*"%>
        <!-- Teste Gr�fico JS -->
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>--%>
 
     <!-- FIm do Teste -->
     
   

</head>
<body>
    
<h4 style="text-align: center;" class="mt-4">PESQUISA ANUAL DE MOVIMENTA��O ${prodOne}</h4>

</body>


    
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            
            <label>ESCOLHA O PRODUTO PARA AN�LISE ANUAL DE PROGRESS�O</label>
            
            
            <form class="form-inline" id="formAction"  action="${pageContext.request.contextPath}/Painel" method="POST">
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
                        <input id="defe" type="hidden" value="defe" name="defe" >
                        <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">Gerar Teste</button>
                    </div>
                </div>
            </form>
            
        </div>
    


<%-- <body onload="drawChart()"> --%>
   
    
  <%--  <div class="container">
         <h3 id="sloganUm" style="text-align: center;" class="mt-4">PAINEL ADMINISTRATIVO DISCADA</h3>
     </div>

     <hr>
     <section class="container">
         <div class="row" style="margin-left: 1em;">

             <div class="col-12 col-md-4">                        
                 <div class="card" style="width: 18rem; text-align: center;" id="blockProductDois">
                     <div class="card-body">
                         <h5 id="sloganUm" class="card-title">Vendas no Dia - R$</h5>
                         <h3 style="color: #3C3D59; font-family: fantasy;"> 3.890,77 </h3>                               
                     </div>
                 </div>
             </div>

             <div class="col-12 col-md-4">
                  <div class="card" style="width: 18rem; text-align: center;" id="blockProductDois">
                     <div class="card-body">
                         <h5 id="sloganUm"> Acumulado da Semana - R$</h5>
                         <h3 style="color: #3C3D59; font-family: fantasy;"> 16.890,65 </h3> 
                     </div>
                 </div>
             </div>

             <div class="col-12 col-md-4">
                 <div class="card" style="width: 18rem; text-align: center;" id="blockProductDois">
                     <div class="card-body">
                         <h5 id="sloganUm" class="card-title">Acumulado do M�s - R$</h5>
                         <h3 style="color: #3C3D59; font-family: fantasy;"> 45.783,89 </h3>                               
                     </div>
                 </div>
             </div>
         </div>

         <br>

         <canvas id="myChart" width="300" height="150"></canvas>

         <div class="row">

             <div class="col-12 col-md-3">
                 <div class="card" style="width: 18rem;">
                     <div class="card-body">
                         <h5 class="card-title">Pedidos Abertos</h5>
                         <h3 style="color:blueviolet;"> 9 </h3>                                
                         <p class="card-text">Providencie o envio dos seus pedidos</p>
                         <a href="pedido/ControlePedidos.html" class="btn btn-outline-primary">Veja Aqui</a>                                
                     </div>
                 </div>
             </div>


             <div class="col-12 col-md-3">
                 <div class="card" style="width: 18rem;">
                     <div class="card-body">
                             <h5 class="card-title">Novos Clientes</h5>
                             <h3 style="color:blueviolet;"> 3 </h3>                                
                             <p class="card-text">Veja aqui os novos clientes que entaram na loja</p>
                             <a href="cliente/controleClientes.html" class="btn btn-outline-primary">Veja Aqui</a>                                
                     </div>
                 </div>
             </div>

             <div class="col-12 col-md-3">
                 <div class="card" style="width: 18rem;">
                     <div class="card-body">
                             <h5 class="card-title">Pagamentos</h5>
                             <h3 style="color:blueviolet;"> 2 </h3>                                
                             <p class="card-text">Voc� tem novos pagamentos recebidos</p>
                             <a href="venda/relatorioVendasGeral.html" class="btn btn-outline-primary">Veja Aqui</a>
                     </div>
                 </div>
             </div>

             <div class="col-12 col-md-3">
                 <div class="card" style="width: 18rem;">
                     <div class="card-body">
                             <h5 class="card-title">Estoque Baixo</h5>
                             <h3 style="color:red;"> 6 </h3>                                
                             <p class="card-text">Alerta! Alguns produtos est�o com estoque baixo</p>
                             <a href="estoque/controleEstoque.html" class="btn btn-outline-primary">Veja Aqui</a>
                     </div>
                 </div>
             </div>

         </div>
    </section> --%>
</body>

  
    