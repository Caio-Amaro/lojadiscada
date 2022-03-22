<%-- 
    Document   : paginaCompraLista
    Created on : 21/03/2022, 12:29:37
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>    
    <section class="py-5 bg-light">

        <div style="text-align: center; margin-top: -1em;">            
            <h3 id="sloganUm"> CARRINHO DE COMPRAS </h3>
            <p> Veja os itens incluídos no seu carrinho</p>                
        </div>
        
        
        <div class="container">    
            <div class="col-sm-4">
                <form action="${pageContext.request.contextPath}/addAcesso" method="POST">
                    <input name="clear" value="true" type="hidden">
                    <button class="btn btn-outline-danger" type="submit" style="margin-right: 1.5em;">
                        Excluir Todos Itens do Carrinho</button>                        
                </form>
            </div>
        </div>

        <hr>


        <div class="container">
            <table class="table">
                <thead  class="thead-dark">                    
                    <tr>
                        <c:set var="produto" value="${obj.produto}"/>
                        <th></th>                        
                        <th>PRODUTO</th>
                        <th>TÍTULO</th>
                        <th>ESTOQUE</th>
                        <th>COMPRAR</th>
                        <th>UNIDADE</th>
                        <th>VALOR TOTAL DA COMPRA</th>
                        <th>AÇÃO</th>
                        <th>AÇÃO</th>                                                
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="obj" items="${cart.items}">
                        <c:set var="produto" value="${obj.produto}"/>                    
                        <tr>
                                <td></td>
                                <td><img style="width:25%; height: auto;" src="${initParam.produtosImagemPath}${produto.pronome}.jpg"></td>
                                <td> <p style="margin-top: .7em; text-transform: uppercase;">${produto.pronome}</p></td>
                                <td> <p style="margin-top: .7em; text-transform: uppercase;">${produto.proqtda}</p></td>
                            <form  action="${pageContext.request.contextPath}/paginaCompraLista" method="POST">
                                <td>        
                                    <input style="margin-top: .5em; width: 30%;" name="quantidade" value="${obj.quantity}" type="text" style="width: 2em; height: auto;">
                                </td>                            

                                <td style="font-size: 14px;"><fmt:formatNumber value="${produto.propreco}" type="currency" /></td>
                                <td style="font-size: 18px; color: green;"><fmt:formatNumber value="${obj.total}" type="currency" /></td>                            
                                <td>
                                    <input name="produtoid" value="${produto.proid}" type="hidden">
                                    <button type="submit" class="btn btn-warning">Atualizar</button>
                                </td>                            
                            </form>
                            
                            <td>
                                <form action="${pageContext.request.contextPath}/paginaCompraLista" method="POST">
                                    <input name="quantidade" value="0" type="hidden">
                                    <input name="produtoid" value="${produto.proid}" type="hidden">
                                    <button type="submit" class="btn btn-danger">Excluir</button>
                                </form>
                            </td>
                            <td></td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="text-align:center; margin-left: 45em;">
            
            <div id="blockProductDois" class="card" style="width: 30rem;">
                <div class="card-body">
                    <h5 id="sloganUm" class="card-title">VALOR TOTAL</h5>
                    <h3 class="card-subtitle mb-2 text-muted" style="color: #3C3D59"><fmt:formatNumber value="${cart.subtotal}" type="currency" /></h3>
                    <p class="card-text"> Avalie os itens e os valores antes de finalizar o seu pedido! Lembrando que os nossos envios são todos gratuitos. Aproveite! </p>
                    <form action="${pageContext.request.contextPath}/paginaFinaliza" method="GET">
                        <input type="hidden" value="${cliente.cliid}" name="client">
                        <button type="submit" class="btn btn-outline-info">Avançar o Pedido</button>
                        <a href="/Discada" type="button" class="btn btn-outline-dark mt-auto">Retornar a Loja</a>  
                    </form> 
                </div>
            </div>
        </div>

    </section>
</body>

