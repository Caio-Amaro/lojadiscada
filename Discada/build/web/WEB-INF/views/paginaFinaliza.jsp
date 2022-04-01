<%-- 
    Document   : paginaFinaliza
    Created on : 21/03/2022, 13:58:15
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>    
    <section class="py-5 bg-light">
        <form action="${pageContext.request.contextPath}/paginaFinaliza" method="POST">
            <div style="text-align: center; margin-top: -1em;">            
                <h2 id="sloganUm"> FINALIZAR O PEDIDO 1 / 2</h2>                        
            </div>
        <hr>
                <!-- insert cards / block one -->

            <div class="container" style="margin-bottom: 1em;">
            <form action="${pageContext.request.contextPath}/paginaFinaliza" method="POST">
                <div  class="row justify-content-md-center">
                    <div class="row">                        
                        <div class="col-12 col-md-4">
                            <div class="card-deck">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 id="sloganUm" class="card-title">Escolha o Cupom de Troca</h5>
                                        <p>Combine seus cupons, caso queira.</p>
                                            <c:forEach var="cup" items="${cupo}">
                                                <div class="form-check">
                                                <c:choose>
                                                    <c:when test="${cup.idtipo == 1 && enviacupom != 1}">
                                                        <p>
                                                            <input class="form-check-input" name="idcupomtroca" type="checkbox" value="${cup.idcupom}">
                                                            <%--<input class="form-check-input" name="valorescup" type="checkbox" value="${cup.valorcupom}">--%>                                                                                                                     
                                                            <label class="form-check-label" for="flexCheckDefault">
                                                                ${cup.nomecupom} : R$ ${cup.valorcupom}
                                                            </label>
                                                        </p>
                                                    </c:when>
                                                </c:choose>
                                                </div>
                                            </c:forEach>                                                                                                    
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-md-4">
                            <div class="card-deck">
                                <div class="card">
                                    <div class="card-body">
                                        
                                        <h5 id="sloganUm" class="card-title">Escolha o Cupom de Desconto</h5>
                                        <p>Apenas um cupom de desconto é válido</p>                                        
                                            <c:forEach var="cup" items="${cupo}">
                                                <c:choose>
                                                    <c:when test="${cup.idtipo != 1 && enviacupom != 1}">
                                                        <span>${cup.nomecupom} ${cup.valorcupom}% </span>
                                                        <p>Insira esse código: <strong>${cup.idcupom}</strong></p>
                                                        <input type="hidden" name="valordocupom" value="${cup.valorcupom}">
                                                    </c:when>
                                                </c:choose>                                                
                                            </c:forEach>
                                        <input type="text" class="form-control" name="cupdescontoid" value="${cup.idcupom}" placeholder="código aqui">
                                    </div>
                                </div>
                            </div>
                        </div>                    
                    </div>
                <input type="hidden" name="valorcompra" value="${cart.subtotal}">
                <input type="hidden" name="enviacupom" value="1">
                <input type="hidden" name="idcl" value="${cliente.cliid}">
                
                <c:choose>
                    <c:when test="${enviacupom != 1}">
                        <button style="margin-top: 2em; width: 50%;" id="botbot" type="submit" class="btn btn-outline-dark">APLICAR</button>         
                    </c:when>
                    <c:otherwise>                        
                        <button style="margin-top: 2em; width: 50%;" disabled id="botbot" type="submit" class="btn btn-outline-dark">CUPOM JÁ APLICADO</button>         
                        <div style="margin-top: 1em;" class="alert alert-info" role="alert">
                            <p>Olá ${cliente.clinome}, cupom desabilitado pelo estágio da compra!</p>
                        </div>
                    </c:otherwise>
                </c:choose>
                </div>
                
            </form>
            <%--<p>${MSG10}</p> <p>${cup.valorcupom}</p> TRATAR ESSA MENSAGEM --%>
            
            </div>

                <hr>
                <div class="container">
                    <form action="${pageContext.request.contextPath}/cupomTroca" method="POST">
                        <div class="row">
                            <div class="col-12 col-md-4">                            
                                <h6 id="sloganUm"> ESCOLHA SEU ENDEREÇO DE ENVIO ABAIXO OU <a href="/Discada/paginaEndereco" type="button" class="btn btn-outline-dark"><i class="bi bi-house-door"></i> Cadastrar Novo Endereço</a></h6>
                                <select name="envio" class="form-select" multiple aria-label="multiple select example">                            
                                    <c:forEach var="en" items="${end}">
                                        <option required value="${en.endid}"> ${en.endnomedestino} : CEP ${en.endcep}</option>
                                    </c:forEach> 

                                </select>
                            </div>                        

                            <div class="col-12 col-md-4">
                                <h6 id="sloganUm"> ESCOLHA SUA FORMA DE PAGAMENTO OU <a href="/Discada/cadastroCartao" type="button" class="btn btn-outline-dark"><i class="bi bi-credit-card"></i> Cadastrar Novo Cartão</a> </h6>
                                <select name="cartao" class="form-select" multiple aria-label="multiple select example">
                                    <option SIZE="4" SELECTED value="1">Boleto Bancário</option>
                                    <c:forEach var="cre" items="${cred}"> 
                                        <option value="${cre.creid}">Nome: ${cre.crenome} - N°: ${cre.crenumero}</option>                    
                                    </c:forEach>                    

                                </select>
                            </div>

                            <div class="col-12 col-md-4">
                                <div class="card-deck" id="blockProductDois">
                                    <div class="card">
                                        <div class="card-body">
                                            <h5 id="sloganUm"> Escolha o Valor para o método de pagamento </h5>
                                            <p> Valor Total Do Pedido : <strong><fmt:formatNumber value=" ${cart.subtotal}" type="currency"  /></strong></p>
                                            <c:choose> 
                                                <c:when test="${vlrFinalCupom == null}">
                                                    <p> Valor a ser acertado é de <strong><fmt:formatNumber value=" ${cart.subtotal}" type="currency"  /></strong></p>
                                                    <input name="vlrtotal" value="${cart.subtotal}" type="hidden"> <%-- controlar as subtrações no servlet --%>
                                                </c:when>
                                                <c:otherwise>
                                                    <span> Valor a ser acertado é de <fmt:formatNumber value="${vlrFinalCupom}" type="currency"  /></span>
                                                    <%--<p> Valor a ser acertado é de <strong>${vlrFinalCupom}</strong></p>--%>
                                                    <input name="vlrtotal" value="${vlrFinalCupom}" type="hidden"> <%-- controlar as subtrações no servlet --%>
                                                </c:otherwise>
                                          </c:choose>
                                          
                                          <input name="vlrtotalpedido" value="${cart.subtotal}" type="hidden"> <%-- valor total do pedido --%>
                                          <hr>
                                          <p style="text-align: center;"><strong>Você pode usar mais de um cartão! Escolha um cartão acima e aplique o valor</strong></p>
                                          <input type="hidden" name="enviacupom" value="1">
                                          <input id="ent" type="text" class="form-control" name="valoraplicado" value="" placeholder="INSIRA APENAS O VALOR">
                                          <c:choose> 
                                                <c:when test="${vlrFinalCupom != 0 || vlrFinalCupom > 0}">
                                                    <button id="botCupdois" type="submit" class="btn btn-outline-dark">APLICAR</button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button id="botCupdois" disabled type="submit" class="btn btn-dark">CONCLUÍDO!</button>
                                                </c:otherwise>
                                          </c:choose>
                                          
                                        </div>
                                    </div>
                                        <div style="margin-top: 1em;" class="alert alert-info" role="alert">
                                            <p>Olá ${cliente.clinome}, ${msgpagamento}</p>
                                        </div>
                                    <input type="hidden" name="idcl" value="${cliente.cliid}">     
                                </div>
                            </div>
                        </div>
                    </form>
                </div> 
        <div class="container">
            <form action="${pageContext.request.contextPath}/paginaFinalizaDois" method="POST">
                <c:if test="${vlrFinalCupom == 0}">
                    <input type="hidden" name="valorsomacupi" value="${vlrCum}">
                    <input type="hidden" name="idpedido" value="${pedido.idpedido}">
                    <input type="hidden" name="clid" value="${cliente.cliid}">
                    <button style="margin-left:50em; " type="submit" class="btn btn-OUTLINE-success">APENAS CONFIRME SUA AQUI!</button>
                </c:if>
            </form>
        </div>
        <hr>
        
                  
    </section>
</body>    