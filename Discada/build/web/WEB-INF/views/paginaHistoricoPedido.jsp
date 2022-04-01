<%-- 
    Document   : paginaHistoricoPedido
    Created on : 31/03/2022, 15:04:33
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
 <body>    
    <section class="py-5 bg-light">

        <div style="text-align: center; margin-top: -1em;">
            <h5 id="sloganUm"> Olá, ${cliente.clinome}. Seu Gereciador de Pedidos</h5>                
        </div>

        <div style="margin-left: 7em; margin-bottom: 5em;">
            <form action="${pageContext.request.contextPath}/paginaHistoricoNome" method="POST">    
              
                  <div class="row">
                      <div class="col-4">
                          <label style="margin-top: 2em;">Data Inicial</label>
                          <input type="text" name="datain" class="form-control" placeholder="dia/mês/ano">
                      </div>
                      <div class="col-4">
                          <label style="margin-top: 2em;">Data Final</label>
                          <input type="text" name="datafi" class="form-control" placeholder="dia/mês/ano">
                      </div>
                      <div class="col-4">                                 
                      </div>
                      <div style="margin-top: .5em;">
                          <input type="hidden" name="idcliente" value="${cliente.cliid}">
                          <button style="margin-top:.5em; margin-left: .1em; width: 20%; height: auto;" type="submit" class="btn btn-outline-secondary my-1">Pesquisar</button>
                      </div>
                  </div>              
            </form>
          </div>

    <!-- insert table / block one -->
    
    <div class="col-md-12">
        <table class="table">
            <thead class="thead-dark">
            
                <th></th>
                <th></th>
                <th></th>
                <th scope="col">Data Pedido</th>
                <th scope="col">Valor Total</th>          
                <th scope="col">CEP Envio</th>
                <th scope="col">N° Pedido</th>
                <th scope="col">Detalhes</th>
                <th></th>

            
            </thead>
  
            <tbody>        
                <c:forEach var="ped" items="${pedid}">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><fmt:formatDate value="${ped.data}" type="date"/></td>
                        <td>
                            <c:choose>
                                <c:when test="${ped.valortotal != null && ped.valortotal != 0}">
                                    <fmt:formatNumber value="${ped.valortotal}" type="currency"  />
                                </c:when>
                                <c:otherwise> 
                                    R$ 0.00 
                                </c:otherwise>
                            </c:choose>
                        </td>              
                        <td>${ped.idendereco.getEndcep()}</td>
                        <td>${ped.idpedido}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/detalhePedido" method="GET">
                                <input type="hidden" name="idpedi" value="${ped.idpedido}">
                                <button class="btn btn-outline-info" type="submit">ITENS DO PEDIDO</button>
                            </form>                      
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
         </tbody>
        </table>
    </section>
</body>