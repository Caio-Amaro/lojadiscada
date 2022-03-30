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
                                                    <c:choose>
                                                        <c:when test="${cup.idtipo == 1 && enviacupom != 1}">
                                                            <p>
                                                                <input name="valorescup" type="checkbox" value="${cup.valorcupom}">
                                                                <input style="display:none;" name="idcupomtroca" type="checkbox" value="${cup.idcupom}" checked>                                                          
                                                                <label class="form-check-label" for="flexCheckDefault">
                                                                    ${cup.nomecupom} : R$ ${cup.valorcupom}
                                                                </label>
                                                            </p>
                                                        </c:when>
                                                    </c:choose>
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
                                        <select class="form-select" name="valordocupom" multiple aria-label="multiple select example">
                                            <c:forEach var="cup" items="${cupo}">
                                                <c:choose>
                                                    <c:when test="${cup.idtipo != 1 && enviacupom != 1}">
                                                        <option value="${cup.valorcupom}">${cup.nomecupom} ${cup.valorcupom}% </option>                                                        
                                                    </c:when>
                                                </c:choose>                                                
                                            </c:forEach>
                                        </select>                                     
                                    </div>
                                </div>
                            </div>
                        </div>                    
                    </div>
                <input type="hidden" name="valorcompra" value="${cart.subtotal}">
                <input type="hidden" name="enviacupom" value="1">
                
                <c:choose>
                    <c:when test="${enviacupom != 1}">
                        <button style="margin-top: 2em; width: 50%;" id="botbot" type="submit" class="btn btn-outline-dark">APLICAR</button>         
                    </c:when>
                    <c:otherwise>                        
                        <button style="margin-top: 2em; width: 50%;" disabled id="botbot" type="submit" class="btn btn-outline-dark">CUPOM JÁ APLICADO</button>         
                        <div style="margin-top: 1em;" class="alert alert-info" role="alert">
                            <p>Olá ${cliente.clinome}, seus cupons foram aplicados. Finalize o pagamento e obrigado!</p>
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
                                        <option required selected value="${en.endid}"> ${en.endnomedestino} : CEP ${en.endcep}</option>
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
                                          <p> Valor Total Do Pedido : <strong>R$ ${cart.subtotal}</strong></p>
                                          <p> Valor a ser acertado é de <strong>R$ <fmt:formatNumber value="${vlrFinalCupom}" type="currency"  /></strong></p>                                      
                                          <input name="vlrtotal" value="<fmt:formatNumber value="${vlrFinalCupom}" type="currency"  />" type="hidden"> <%-- controlar as subtrações no servlet --%>
                                          <input name="vlrtotalpedido" value="${cart.subtotal}" type="hidden"> <%-- valor total do pedido --%>
                                          <hr>
                                          <p style="text-align: center;"><strong>Você pode usar mais de um cartão! Escolha um cartão acima e aplique o valor</strong></p>

                                          <input id="ent" type="text" class="form-control" name="valoraplicado" value="" placeholder="INSIRA APENAS O VALOR">
                                          <button id="botCup" type="submit" class="btn btn-outline-dark">APLICAR</button>
                                        </div>
                                    </div>
                                          <p> ${msgValor} </p>
                                          <p> ${msgpagamento}</p>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>            
        <hr>

        <div class="container">
            <a href="finalizaCompraDois.html" type="button" class="btn btn-OUTLINE-success">CONFIRMA</a>
            <p>O BOTÃO ACIMA SÓ ESTARÁ DISPONÍVEL ASSIM QUE O VALOR DO PAGAMENTO FOR IGUAL R$ 0.00 </p>
            <p>SE O VALOR DO CUPOM FOR SUPERIOR A COMPRA, GERA UM NOVO CUPOM COM A DIFERENÇA (SOBRA DO VALOR).</p>
        </div>

        
                  
    </section>
</body>    