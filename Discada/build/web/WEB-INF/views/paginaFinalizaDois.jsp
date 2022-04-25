<%-- 
    Document   : paginaFinalizaDois
    Created on : 31/03/2022, 13:11:00
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<body>    
    <section class="py-5 bg-light">
        <div style="text-align: center; margin-top: -1em;">            
            <h2 id="sloganUm"> FINALIZAR O PEDIDO 2 / 2</h2>                        
        </div>        
        <hr>
        <div class="col-12 col-md-8" style="margin-left: 20%;">
            <div class="card-deck" id="blockProductDois">
                <div class="card">
                    <div class="card-body">
                        <h3 style="text-align: center;" id="sloganUm"> EXTRATO DO PEDIDO </h3>
                        
                        <c:forEach var="obl" items="${cart.items}">
                                <c:set var="produto" value="${obl.produto}"/>
                                <input type="hidden" name="idproduto" value="${produto.proid}">
                                <h6 style="font-family:monospace;">${produto.pronome}</h6>
                                <img style="width:10%; height: auto;" src="${initParam.produtosImagemPath}${produto.pronome}.jpg">
                                <p style="font-family:monospace; font-size: 16px;">VALOR: <strong><fmt:formatNumber value="${produto.propreco}" type="currency"  /></strong></p>
                                <p style="font-family:monospace; font-size: 16px;">QUANTIDADE: ${obl.quantity} (unid.)</p>
                                <p style="font-family:monospace; font-size: 16px;">SUBTOTAL: <strong><fmt:formatNumber value="${obl.quantity * produto.propreco}" type="currency"  /></strong> </p>
                                <hr>
                        </c:forEach>                            
                            <h5 id="sloganUm">VALOR FINAL PAGO <strong><fmt:formatNumber value="${cart.subtotal}" type="currency"  /></strong></h5>

                    </div>
                </div>
            </div>
        </div>
        <hr>

        <div class="container" style="margin-left: 20%;">
            <form action="${pageContext.request.contextPath}/addItem" method="POST">
                <input type="hidden" name="idpedido" value="${idpedido}">
                <button type="submit" class="btn btn-outline-success">FINALIZAR O PEDIDO</button>
            </form>
        </div>
                  
    </section>
</body>    
