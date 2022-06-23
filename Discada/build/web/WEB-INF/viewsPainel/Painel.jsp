<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <!-- Teste Gráfico JS -->
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.5.1/chart.min.js"></script>--%>
 
     <!-- FIm do Teste -->
     
   

</head>
<body>

    <div class="col-12" style="margin-top: .5em; margin-bottom: 1em;">
    
        <div class="container">
             <h3 id="sloganUm" style="text-align: center;">PAINEL ADMINISTRATIVO DISCADA</h3>
         </div>

         <hr>
         <section class="container">         
             <div class="row">
                 <div class="col-4 mb-4">                        
                     <div class="card" style="width: 18rem; text-align: center; margin-left: 3em;" id="blockProductDois">
                         <div class="card-body">
                                <h5 id="sloganUm" class="card-title">Vendas no Dia - R$</h5>
                                <h3 style="color: #3C3D59; font-family: fantasy;"> 3.890,77 </h3>                         
                         </div>
                     </div>
                 </div>

                 <div class="col-4 mb-4" style="width: 18rem; text-align: center;">
                      <div class="card" id="blockProductDois">
                         <div class="card-body">                         
                                <h5 id="sloganUm"> Acumulado da Semana - R$</h5>
                                <h3 style="color: #3C3D59; font-family: fantasy;"> 16.890,65 </h3>                          
                         </div>
                     </div>
                 </div>

                 <div class="col-4 mb-4">
                     <div class="card" style="width: 18rem; text-align: center;" id="blockProductDois">
                         <div class="card-body">
                             <h5 id="sloganUm" class="card-title">Acumulado do Mês - R$</h5>
                             <h3 style="color: #3C3D59; font-family: fantasy;"> 45.783,89 </h3>                               
                         </div>
                     </div>
                 </div>
             </div>
        </section>
    
    <br>
    <div class="row" style="padding: 1em;">
            <form class="form-inline"  action="${pageContext.request.contextPath}/Painel" method="POST">                
                <div class="row">
                    <div class="col-6">
                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                    </div>
                    <div class="col-6">
                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                    </div>
                </div>    
                <div class="row">
                    <div class="col-6">
                        <label id="sloganUm" style="margin-top: 2em;">Produto 1</label>
                        <select name="produt1" class="form-select" aria-label="Default select example">                                    
                            <c:forEach var="prd" items="${produtoscom}"> 
                                <option value="${prd.proid}">${prd.pronome}</option>                    
                            </c:forEach>                    
                        </select>
                    </div>
                    <div class="col-6">
                        <label id="sloganUm" style="margin-top: 2em;">Produto 2</label>
                        <select name="produt2" class="form-select" aria-label="Default select example">                                    
                            <c:forEach var="prd" items="${produtoscom}"> 
                                <option value="${prd.proid}">${prd.pronome}</option>                    
                            </c:forEach>                    
                        </select>
                    </div>
                    <div style="margin-top: .5em;">
                        <input id="defe" type="hidden" value="defe" name="defe" >
                        <button style="margin-top:.5em; margin-left: .1em; width: 20%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                    </div> 
                </div>
             </form>                
        </div>
            
        <section class="container">            
                <div class="col-12">
                    <div  class="row">
                    <div class="card" style="width: 30%; text-align: center; margin-left: 1em;" id="blockProductDois">
                        <div class="card-body">
                            
                               <div class="mb-4">
                                   <h5 id="sloganUm"> ${npro1}</h5>                                   
                                   <h6 style="color: #3C3D59; font-family: fantasy;">Quantidade :</h6> <strong> ${spro1} </strong>
                                   <h6 style="color: #3C3D59; font-family: fantasy;">Valor R$ </h6> <strong> ${vpro1} </strong>
                               </div>
                            
                        </div>
                    </div>
            
                    <div class="card" style="width: 30%; text-align: center; margin-left: 3em;" id="blockProductDois">
                        <div class="card-body">
                            
                                <div class="mb-4">
                                    <h5 id="sloganUm"> ${npro2} </h5>                                    
                                    <h6 style="color: #3C3D59; font-family: fantasy;">Quantidade :</h6> <strong> ${spro2} </strong>  
                                    <h6 style="color: #3C3D59; font-family: fantasy;">Valor R$ </h6> <strong> ${vpro2} </strong>   
                                </div>                            
                        </div>
                    </div>
                    </div>
                </div>
                <p style=" margin-bottom: 5em;"></p>
        </section>
    </div>    
</body>

  
    