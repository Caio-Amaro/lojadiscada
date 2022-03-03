<%-- 
    Document   : editarEndereco
    Created on : 01/03/2022, 08:05:29
    Author     : Caio Costa Amaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-----------------------------------------------------------------%>
<!-- Body and Section-->

<body>    
    <section class="py-5 bg-light">
        <div style="text-align: center; margin-top: -1em;">
            <h5 id="sloganUm"> GERENCIADOR DE ENDEREÇOS </h5>
            <p>Olá<strong> ${cliente.clinome}</strong>, edite seus dados de endereço</p>
        </div>

        <hr>

<!-- form adress -->

        <div style="text-align: left; margin-top: 3em; margin-left: 7.5em; margin-bottom: 1.5em;">
             <h5 id="sloganUm"> EDITAR DADOS DO ENDERECO </h5> 
        </div>

        <div  class="container">
            <form action="${pageContext.request.contextPath}/editarEndereco" method="POST">
                <div class="row justify-content-md-center">
                    <input type="hidden" value="${selecioneCliEnd.endid}" name="idend">
                    <div class="form-group col col-md-8" >
                        <label>Nome Completo - Destinatário</label>
                        <input type="text" name="nome" class="form-control" value="${selecioneCliEnd.endnomedestino}">
                         <input type="hidden" name="idclientes" value="${cliente.cliid}">
                    </div>

                    <div class="form-group col col-md-4">
                      <label>Bairro</label>
                      <input type="text" value="${selecioneCliEnd.endbairro}" class="form-control" name="bairro">  
                    </div>
                </div>

                <!-- ++++ -->

                <div class="row justify-content-md-center">

                    <div class="form-group col col-md-6">
                        <label>Logradouro</label>
                        <input type="text" value="${selecioneCliEnd.endlogradouro}" class="form-control" name="logra">
                    </div>

                    <div class="form-group col col-md-5">
                        <label>Complemento</label>
                        <input type="text" value="${selecioneCliEnd.endcomplemento}" class="form-control" name="comp">
                    </div>

                    <div class="form-group col col-md-1">
                        <label>N°</label>
                        <input type="text" value="${selecioneCliEnd.endnumero}" class="form-control" name="num">
                    </div>
                </div>

                <!-- ++++ -->

                <div class="row justify-content-md-center">
                    <div class="form-group col col-md-5">
                        <label>Cidade</label>
                        <input type="text" value="${selecioneCliEnd.endcidade}" class="form-control" name="cidade">
                    </div>

                    <div class="form-group col col-md-3">
                        <label>CEP</label>
                        <input type="text" value="${selecioneCliEnd.endcep}" class="form-control" name="cep">
                    </div>

                   <div class="form-group col col-md-4">
                    <label>Estado</label>
                    <input type="text" value="${selecioneCliEnd.endestado}" name="estado" class="form-control">
                    </div>

                </div>
                <div id="ent">
                    <button type="submit" class="btn btn-outline-primary">Alterar Dados</button>                    
                </div>
            </form>
            
            <form action="${pageContext.request.contextPath}/paginaEndereco" method="GET">
                <div id="ent">
                    <input type="hidden" value="${cliente.cliid}" name="idcl">
                    <button type="submit" class="btn btn-outline-dark">Retornar</button>
                </div>
            </form>
            <c:choose>
                <c:when test="${msgEditarEnd != null}">
                    <div style="margin-top: 1em;" class="alert alert-info" role="alert">
                        <p>Olá ${cliente.clinome}, ${msgEditarEnd}</p>
                    </div>
                </c:when>
            </c:choose>            
    </div>
                    
    <hr>

  </section>
</body>
