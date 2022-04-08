
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Page content-->

<body>
    <div class="container-fluid">
        <h1 id="sloganUm" class="mt-4" style="margin-bottom: 1em;">Controle de Pedidos</h1>
    </div>
    
        <table class="table" style="font-family:sans-serif; text-align: center; ">
            <thead  class="thead-dark">

                <tr>
                    <th scope="col">#ID ITEM</th>
                    <th scope="col">Produtos</th>
                    <th scope="col">Unitário</th>
                    <th scope="col">Qtda</th>
                    <th scope="col">Data Pedido</th>
                    <th scope="col">Total</th>
                    <th scope="col">Status Atual</th>
                    <th scope="col">Gerenciar Item</th>
                    
           
                </tr>
            
            <c:forEach var="obj" items="${item}">                
                <tr>
                    <th scope="row">${obj.itempedidoid}</th>
                    <td>${obj.idpro.getPronome()}</td>
                    <td>
                        <fmt:formatNumber value="${obj.valoritem}" type="currency"  />
                    </td>
                    <td>${obj.quantidade}</td>
                    <td>
                        <fmt:formatDate value="${obj.idped.getData()}" type="date"/> 
                    </td>
                    <td>
                        <fmt:formatNumber value="${obj.valortotalitem}" type="currency"/>
                    </td>
                    <td> <c:choose>
                            <c:when test="${obj.idstatus.getNomestatus() == 1}">
                                PROCESSAMENTO
                            </c:when> 
                            <c:when test="${obj.idstatus.getNomestatus() != 1}">
                                ${obj.idstatus.getNomestatus()}
                            </c:when> 
                        
                        </c:choose>
                    </td>                    
                    <td>
                        <a href="/Discada/editarItemPedido?${obj.itempedidoid}" type="submit" name="iditem" class="btn btn-warning">Editar Aqui</a>
                    </td>                        
                </tr>
                          </c:forEach>
            </thead>
       </table>
</body>


