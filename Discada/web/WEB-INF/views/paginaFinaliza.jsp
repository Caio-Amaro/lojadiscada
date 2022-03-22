<%-- 
    Document   : paginaFinaliza
    Created on : 21/03/2022, 13:58:15
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>    
    <section class="py-5 bg-light">
        <form action="${pageContext.request.contextPath}/paginaFinaliza" method="POST">
            <div style="text-align: center; margin-top: -1em;">            
                <h2 id="sloganUm"> FINALIZAR O PEDIDO 1 / 2</h2>                        
            </div>
        <hr>
                <!-- insert cards / block one -->

            <div class="container" style="margin-bottom: 1em;">
                <div  class="row justify-content-md-center">
                    <div class="row">                        
                        <div class="col-12 col-md-6">                            
                            <h6 id="sloganUm"> ESCOLHA SEU ENDEREÇO DE ENVIO ABAIXO OU <a href="/Discada/paginaEndereco" type="button" class="btn btn-outline-dark"><i class="bi bi-house-door"></i> Cadastrar Novo Endereço</a></h6>
                            <select name="envio" class="form-select" multiple aria-label="multiple select example">                            
                                <c:forEach var="en" items="${end}">
                                    <option required value="${en.endid}"> ${en.endnomedestino} - ${en.endcep}</option>
                                </c:forEach> 

                            </select>
                        </div>                        

                        <div class="col-12 col-md-6">
                            <h6 id="sloganUm"> ESCOLHA SUA FORMA DE PAGAMENTO OU <a href="/loja/cadastroCartao" type="button" class="btn btn-outline-dark"><i class="bi bi-credit-card"></i> Cadastrar Novo Cartão</a> </h6>
                            <select name="cartao" class="form-select" multiple aria-label="multiple select example">
                                <option SIZE="4" SELECTED value="1">Boleto Bancário</option>
                                <c:forEach var="cre" items="${cred}"> 
                                    <option value="${cre.creid}">Nome: ${cre.crenome} - N°: ${cre.crenumero}</option>                    
                                </c:forEach>                    

                            </select>
                        </div>

                    </div>

                </div>
            </div>

                <hr>
                <div class="container">
                    <div class="row">
                        <div class="col-12 col-md-4">
                            <div class="card-deck">
                                <div class="card">
                                    <div class="card-body">
                                      <h5 id="sloganUm" class="card-title">Escolha o Cupom de Troca</h5>
                                      <p>Você pode escolher mais de um cupom de troca, caso tenha disponível</p>
                                        <input class="form-check-input" type="checkbox" value="${cup.idcupom}" name="idcupomtroca">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Cupom Trooca VT DISC : R$ 139.90
                                        </label>
                                        <br>
                                        <input class="form-check-input" type="checkbox" value="${cup.idcupom}" name="idcupomtroca">
                                        <label class="form-check-label" for="flexCheckDefault">
                                            Cupom Troca Disco Verde : R$ 339.50
                                        </label>
                                        <%--<a id="botCup" href="#" type="button" class="btn btn-outline-dark">APLICAR</a>--%>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-md-4">
                            <div class="card-deck">
                                <div class="card">
                                    <div class="card-body">
                                      <h5 id="sloganUm" class="card-title">Escolha o Cupom de Desconto</h5>
                                      <p>Você pode apenas um cupom de desconto por compra, caso disponível!</p>
                                        <span>Cupom Boas Vindas 30% || Codigo :<strong>9978</strong></span>
                                        <span>Cupom Sexta Discada 10% || Código : <strong>1366</strong></span>                                
                                        <%--<input id="ent" type="text" class="form-control" name="cupdescontoid" value="" placeholder="INSIRA O CÓDIGO AQUI"><a id="botCup" href="#" type="button" class="btn btn-outline-dark">APLICAR</a>--%>

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-12 col-md-4">
                            <div class="card-deck" id="blockProductDois">
                                <div class="card">
                                    <div class="card-body">
                                      <h5 id="sloganUm"> Escolha o Valor para o método de pagamento </h5>
                                      <p> Seu pedido foi no total de <strong>R$ 1.177.60</strong></p>
                                      <p> Valor a ser acertado é de <strong>R$ 1.177.60</strong></p>
                                      <hr>
                                      <p style="text-align: center;"><strong>Você pode usar mais de um cartão! Escolha um cartão acima e aplique o valor</strong></p>

                                      <input id="ent" type="text" class="form-control" name="cupdescontoid" value="" placeholder="INSIRA APENAS O VALOR">
                                      <a id="botCup" href="#" type="button" class="btn btn-outline-dark">APLICAR</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>            
        <hr>

        <div class="container">
            <a href="finalizaCompraDois.html" type="button" class="btn btn-OUTLINE-success">CONFIRMA</a>
            <p>O BOTÃO ACIMA SÓ ESTARÁ DISPONÍVEL ASSIM QUE O VALOR DO PAGAMENTO FOR IGUAL R$ 0.00 </p>
            <p>SE O VALOR DO CUPOM FOR SUPERIOR A COMPRA, GERA UM NOVO CUPOM COM A DIFERENÇA (SOBRA DO VALOR).</p>
        </div>

        
                  
    </section>
</body>    