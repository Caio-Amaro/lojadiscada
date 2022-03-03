<%-- 
    Document   : paginaEndereco
    Created on : 02/03/2022, 16:38:01
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
<!-- Inciando o Body e a Section-->

<body>    
    <section class="py-5 bg-light">
        <div style="text-align: center; margin-top: -1em;">
            <h5 id="sloganUm"> GERENCIADOR DE ENDEREÇOS </h5>
            <p> Olá ${cliente.clinome}, aqui você insere seu(s) endereço(s) de envio(s) </p>               
        </div>
            

<hr>

<!-- Formulário para exibição e edição dos dados de endereço --- "form adress" -->

        <div style="text-align: left; margin-top: 3em; margin-left: 7.5em; margin-bottom: 1.5em;">
             <h5 id="sloganUm"> CADASTRAR NOVO ENDEREÇO </h5> 
        </div>

        <div  class="container">
            <form name="action" action="${pageContext.request.contextPath}/paginaEndereco" method="POST">
                <div class="row justify-content-md-center">
                    <div class="form-group col col-md-8" >
                        <label>Nome Completo - Destinatário</label>
                        <input type="text" name="nome" class="form-control">
                    </div>

                    <div class="form-group col col-md-4">
                        <label>Bairro</label>
                        <input type="text" class="form-control" name="bairro">  
                    </div>
                </div>

            <!-- segunda linha formulário -->
            
                <div class="row justify-content-md-center">                
                    <div class="form-group col col-md-6">
                        <label>Logradouro</label>
                        <input type="text" class="form-control" name="logra">
                    </div>
                    
                    <div class="form-group col col-md-4">
                        <label>Complemento</label>
                        <input type="text" class="form-control" id="compE" name="comp">
                    </div>

                    <div class="form-group col col-md-2">
                        <label>N°</label>                    
                        <input type="text" class="form-control" id="compE" name="num">
                    </div>
                </div>

            <!-- ++++ -->

                <div class="row justify-content-md-center">
                    <div class="form-group col col-md-5">
                        <label>Cidade</label>
                        <input type="text" class="form-control" id="cidadeE" name="cidade">
                    </div>

                    <div class="form-group col col-md-3">
                        <label>CEP</label>
                        <input type="text" class="form-control" id="cepE" name="cep">
                    </div>

                    <div class="form-group col col-md-4">
                        <label>Estado</label>
                        <input type="text" name="estado" id="estadoE" class="form-control">
                    </div>
                </div>

                <div class="form-group">                
                    <div class="form-check" style="margin-top: 1em;">
                        <input  type="hidden" VALUE="2" name="idli">
                    </div>
                </div>

                <input type="hidden" name="idcli" value="${cliente.cliid}">
                <button type="submit" class="btn btn-outline-dark">Adicionar Novo</button>

            </form>
        </div>
<hr>

        <div style="text-align: left; margin-top: 3em; margin-left: 7.5em; margin-bottom: 1.5em;">
            <h5 id="sloganUm"> ENDEREÇOS CADASTRADOS </h5>
        </div>

    <!-- insert cards / block one -->

        <div  class="container"> 
            <div class="row justify-content-md-center">
                <c:forEach var="ende" items="${endereco}">
                    <div class="col col-md-3">
                        <div class="card">
                            <div id="blockProductDois" class="card-body" style="text-align: center;">
                                <h6 id="sloganUm">Destinatário</h6>
                                <h5 class="card-title">${ende.endnomedestino}</h5>
                                <hr>
                                <h6 id="sloganUm">Dados do Endereço</h6>
                                <p class="card-text">${ende.endlogradouro}</p>
                                <p class="card-text">CEP ${ende.endcep}</p>
                                <p class="card-text">${ende.endcidade} || ${ende.endestado}</p>
                                <hr>
                                <div class="row">
                                    <div class="col-6">
                                        <form name="sen" action="${pageContext.request.contextPath}/editarEndereco" method="GET">
                                            <input name="idclieSt" type="hidden" value="${ende.endid}">
                                            <input name="idcliente" type="hidden" value="${cliente.cliid}">
                                            <button class="btn btn-warning" type="submit">Alterar</button>
                                        </form>
                                    </div>
                                    <div class="col-6">            
                                        <form action="${pageContext.request.contextPath}/excluirEndereco" method="POST">
                                            <input name="idclieSt" type="hidden" value="${ende.endid}">
                                            <input name="idcliente" type="hidden" value="${cliente.cliid}">                                
                                            <button class="btn btn-outline-danger" type="submit">Excluir</button>                                
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>                        
                <c:choose>
                   <c:when test="${msgEnd != null}">
                       <div style="margin-top: 1em;" class="alert alert-danger" role="alert">
                           <p>Olá ${cliente.clinome}, sentimos muito, mas  esse endereço ${msgEnd}</p>
                       </div>
                   </c:when>

               </c:choose>
            </div>
        </div>
    
  </section>
</body>