<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>




<!-- Page content-->

<h4 style="text-align: center;" class="mt-4">PESQUISA ANUAL DE MOVIMENTAÇÃO</h4>

<div class="container-fluid">
    <hr>
    <form action="${pageContext.request.contextPath}/pesquisaVendasMes" method="POST">
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            <label>ESCOLHA O PRODUTO PARA ANÁLISE ANUAL DE PROGRESSÃO</label>
            <select name="prod" class="form-control">
                <c:forEach var="prt" items="${ControleProduto.proDao.listaObjetos}">
                    <option value="${prt.proid}">${prt.pronome}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-outline-primary my-1">AVANÇAR NA PESQUISA</button>
        </div>
    </form>
</div>
        <hr>
        <hr>  <%-- transform: rotateX(180deg); --%>
  <h3>Gráfico de Progressão de Vendas / 2020 - 2021 /</h3>       
<div style="margin-top: 3em; margin-bottom: 10em;" class="row">
   
    <div class="col-12 col-md-1" style="margin-right: -1.2em;">
            <c:forEach var="valor7" items="${pedo7}"> 
                <c:set var="cont7" value="${cont7 + valor7.quantidade}"/>
                <c:set var="final" value="${final + valor7.valortotalitem}"/>                
            </c:forEach>
        <p style="font-size: 10px;">OUT.2020</p>
        <p style="font-size: 12px;"><strong>R$ ${final}</strong></p>
        <p style="border:solid black 2px;  
           background-color: #00BFFF; height:${cont7*30}%;"></p>
    </div>
    
   <div class="col-12 col-md-1" style="margin-right: -1em;">
            <c:forEach var="valor6" items="${pedo6}"> 
                <c:set var="cont6" value="${cont6 + valor6.quantidade}"/>
                <c:set var="final1" value="${final1 + valor6.valortotalitem}"/>
            </c:forEach>
            <p style="font-size: 10px;">NOV.2020</p>
            <p style="font-size: 12px;"><strong>R$ ${final1}</strong></p>
            <p style="background-color: #00BFFF; height:${cont6*30}%;
               border:solid black 2px;"></p>
            
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1.2em;">
        <c:forEach var="valor5" items="${pedo5}"> 
            <c:set var="cont5" value="${cont5 + valor5.quantidade}"/>
            <c:set var="final2" value="${final2 + valor5.valortotalitem}"/>
        </c:forEach>
        <p style="font-size: 10px;">DEZ.2020</p>
        <p style="font-size: 12px;"><strong>R$ ${final2}</strong></p>
        <p style="background-color: #00BFFF; height:${cont5*30}%;
            border:solid black 2px;"></p>
      
    </div>
        
    <div class="col-12 col-md-1" style="margin-right: -1.2em;">
        <c:forEach var="valor4" items="${pedo4}"> 
            <c:set var="cont4" value="${cont4 + valor4.quantidade}"/>
            <c:set var="final3" value="${final3 + valor4.valortotalitem}"/>            
        </c:forEach>
        <p style="font-size: 10px;">JAN.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final3}</strong></p>
        <p style="background-color: #00BFFF; height:${cont4*50}%;
            border:solid black 2px;"></p>       
    </div>
        
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valorx1" items="${pedox1}"> 
            <c:set var="contx1" value="${contx1 + valorx1.quantidade}"/>
            <c:set var="final4" value="${final4 + valorx1.valortotalitem}"/>             
        </c:forEach>
        <p style="font-size: 10px;">FEV.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final4}</strong></p>
        <p style="background-color: #00BFFF; height:${contx1*30}%;
            border:solid black 2px;"></p>
               
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valorx2" items="${pedox2}"> 
            <c:set var="contx2" value="${contx2 + valorx2.quantidade}"/>
            <c:set var="final5" value="${final5 + valorx2.valortotalitem}"/>             
        </c:forEach>
        <p style="font-size: 10px;">MAR.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final5}</strong></p>
        <p style="background-color: #00BFFF; height:${contx2*30}%;
            border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valorx3" items="${pedox3}"> 
            <c:set var="contx3" value="${contx3 + valorx3.quantidade}"/>
            <c:set var="final6" value="${final6 + valorx3.valortotalitem}"/>
        </c:forEach>
        <p style="font-size: 10px;">ABR.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final6}</strong></p>
        <p style="background-color: #00BFFF; height:${contx3*30}%;
            border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valorx4" items="${pedox4}"> 
            <c:set var="contx4" value="${contx4 + valorx4.quantidade}"/>
            <c:set var="final7" value="${final7 + valorx4.valortotalitem}"/>            
        </c:forEach>
        <p style="font-size: 10px;">MAI.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final7}</strong></p>
         <p style="background-color: #00BFFF; height:${contx4*30}%;
            border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valo3" items="${pedo3}"> 
            <c:set var="con3" value="${con3 + valo3.quantidade}"/>
            <c:set var="final8" value="${final8 + valo3.valortotalitem}"/>            
        </c:forEach>
        <p style="font-size: 10px;">JUN.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final8}</strong></p>
        <p style="background-color: #00BFFF; height:${con3*30}%;
         border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valo2" items="${pedo2}"> 
            <c:set var="con2" value="${con2 + valo2.quantidade}"/>
             <c:set var="final9" value="${final9 + valo2.valortotalitem}"/>  
        </c:forEach>
        <p style="font-size: 10px;">JUL.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final9}</strong></p>
        <p style="background-color: #00BFFF; height:${con2*30}%;
        border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valo1" items="${pedo1}"> 
            <c:set var="con1" value="${con1 + valo1.quantidade}"/>
             <c:set var="final10" value="${final10 + valo1.valortotalitem}"/>
        </c:forEach>
        <p style="font-size: 10px;">AGO.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final10}</strong></p>
        <p style="background-color: #00BFFF; height:${con1*30}%;
        border:solid black 2px;"></p>
    </div>
    
    <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="valo" items="${peto}"> 
            <c:set var="con" value="${con + valo.quantidade}"/>
            <c:set var="final11" value="${final11 + valo.valortotalitem}"/>
        </c:forEach>
        <p style="font-size: 10px;">SET.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final11}</strong></p>
        <p style="background-color: #00BFFF; height:${con*20}%;
        border:solid black 2px;"></p>
    </div>
    
     <div class="col-12 col-md-1" style="margin-right: -1em;">
        <c:forEach var="val" items="${ped}"> 
            <c:set var="co" value="${co + val.quantidade}"/>
            <c:set var="final12" value="${final12 + val.valortotalitem}"/>
        </c:forEach>
        <p style="font-size: 10px;">OUT.2021</p>
        <p style="font-size: 12px;"><strong>R$ ${final2}</strong></p>
        <p style="background-color: #00BFFF; height:${co*30}%;
        border:solid black 2px;"></p>
    </div>
   
</div>     
        <p style="margin-top: 30em;"></p>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>       
<!-- Core theme JS-->
<script src="/js/scripts.js"></script>
