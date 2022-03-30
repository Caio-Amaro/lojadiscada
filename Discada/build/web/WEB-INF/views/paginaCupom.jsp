<%-- 
    Document   : paginaCupom
    Created on : 28/03/2022, 14:27:07
    Author     : Caio Costa Amaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>    
    <section class="py-5 bg-light">

        <div style="text-align: center; margin-top: -1em;">
            <h5 id=sloganUm> GERENCIADOR DE CUPONS</h5>
            <p>Olá ${cliente.clinome}. Essa é a listagem Geral dos Cupons de Troca e Desconto</p>                        
        </div>
        
            <div id="sloganUm" style="text-align: center;">
                <c:choose>
                    <c:when test="${cupo == null}">
                        <p> Não há nenhum cupom disponível </p>
                    </c:when>
                </c:choose>
            </div>

    <!-- insert cards / block one -->

        <div  class="container">
            <div class="row justify-content-md-center" style="text-align: center;">
                <c:forEach var="cpo" items="${cupo}"> 
                    <div class="col col-md-3">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title"><strong>${cpo.nomecupom}</strong></h5>
                                <p class="card-text">codigo.: ${cpo.idcupom}</p>                        
                                <p class="card-text">                                
                                    <c:choose>
                                        <c:when test="${cpo.idtipo == 1}">                                
                                            <p style="background-color:#B0E0E6; border-radius: 10px 5%; width: 100%; text-align: center;">
                                               <fmt:formatNumber value="${cpo.valorcupom}" type="currency"  /> PARA TROCA
                                            </p>
                                        </c:when>                                 
                                        <c:when test="${cpo.idtipo == 2}">                                     
                                            <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black;">
                                                ${cpo.valorcupom}% DE DESCONTO
                                            </p>
                                        </c:when>
                                    </c:choose>  
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <hr>
    </section>    
</body>
