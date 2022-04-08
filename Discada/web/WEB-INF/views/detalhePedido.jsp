<%-- 
    Document   : detalhePedido
    Created on : 31/03/2022, 15:26:45
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<body>
    <div class="col col-md-12" style="margin-left: 3em;">
        <h5 id="sloganUm" style="margin-bottom: .3em; text-align: center;">ITENS DO PEDIDO</h5>
        <a style="margin-bottom: 1.5em;" href="/Discada/paginaHistoricoPedido" class="btn btn-outline-info" type="button">Voltar a Listagem Geral</a>        
    </div>

    <hr>
    
        <table class="table">
            <thead  class="thead-dark">

                <tr>
                    <th scope="col">#ID ITEM</th>
                    <th scope="col">Produtos</th>
                    <th scope="col">Valor na Loja</th>
                    <th scope="col">Qtda</th>
                    <th scope="col">Data Pedido</th>
                    <th scope="col">Total Sem Desconto</th>
                    <th scope="col">Status Negociação</th>
                    <th scope="col">Item PEPEPE</th>
                    
           
                </tr>
            
                <c:forEach var="obj" items="${pedit}">
                    <tr>
                        <th scope="row">${obj.itempedidoid}</th>
                        <td>${obj.idpro.getPronome()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${obj.valoritem != null && obj.valoritem != 0}">
                                    <fmt:formatNumber value="${obj.valoritem}" type="currency"  />
                                </c:when>
                                <c:otherwise> 
                                    R$ 0.00 
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${obj.quantidade}</td>
                        <td><fmt:formatDate value="${obj.idped.getData()}" type="date"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${obj.valortotalitem != null && obj.valortotalitem != 0}">
                                    <fmt:formatNumber value="${obj.valortotalitem}" type="currency"  />
                                </c:when>
                                <c:otherwise> 
                                    R$ 0.00 
                                </c:otherwise>
                         </c:choose> 
                        </td>
                        <td>${obj.idstatus.getNomestatus()}</td>                    
                        <td>
                            <form action="${pageContext.request.contextPath}/detalheItemPedido" method="GET">
                                <input type="hidden" name="idpediit" value="${obj.itempedidoid}">
                                <button class="btn btn-outline-info" type="submit">DETALHES DO ITEM</button>
                            </form>                            
                        </td>                        
                    </tr>
                </c:forEach>
            </thead>
       </table>
</body>
