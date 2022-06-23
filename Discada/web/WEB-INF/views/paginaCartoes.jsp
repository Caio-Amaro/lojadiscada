<%-- 
    Document   : paginaCartoes
    Created on : 01/03/2022, 09:41:19
    Author     : Caio Costa Amaro
    Description: Página para o gerenciamento dos cartões cadastrados
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- ---------------------------------------------------------------- -->
<!-- Body and Section-->

<body>    
    <section class="py-5 bg-light">

        <div style="text-align: center; margin-top: -1em;">
            <h5 id="sloganUm"> GERENCIADOR DE CARTÕES DE CRÉDITO </h5>
            
        </div>

        <div class="container">    
            <div class="col-sm-4">               
                <button class="btn btn-outline-success" type="submit" style="margin-right: 1.5em;">
                <i class="bi bi-credit-card-2-front"></i><a style="text-decoration: none; color: inherit;" href="/Discada/cadastroCartao" > Cadastrar um Novo Cartão de Crédito </a></button>                        
            </div>
        </div>

        <div class="container">
            <table class="table">
                <thead  class="thead-dark">
                    <tr>
                        <th scope="col">Bandeira</th>
                        <th scope="col">Nome no Cartão</th>
                        <th scope="col">Número do Cartão</th>
                        <th scope="col">Data Expira</th>
                        <th scope="col">Código</th>
                        <th scope="col">Status</th>
                        <th scope="col"></th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="cre" items="${credito}">
                    <tr>
                       <th scope="row">${cre.bandeira}</th>
                            <td>${cre.crenome}</td>
                            <td>${cre.crenumero}</td>
                            <td>${cre.crevalidade}</td>
                            <td>${cre.crecvv}</td>
                            <td>Ativo</td>
                            <input type="hidden" value="${cre.creid}"/>
                            <td>
                                <form action="${pageContext.request.contextPath}/excluirCartao" method="POST">
                                    <button  type="submit" class="btn btn-danger">
                                        <input type="hidden" name="idcredito" value="${cre.creid}"/>
                                        <input type="hidden" name="idcli" value="${cliente.cliid}"/>
                                        Excluir
                                 </button>
                                </form>
                            </td>
                    </tr>
                   </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</body>
