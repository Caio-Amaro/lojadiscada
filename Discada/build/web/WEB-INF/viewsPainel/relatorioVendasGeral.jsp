
                <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->
<body>
    <div class="container-fluid">
        <h3 id="sloganUm" class="mt-4">Relatório de Vendas - Pesquise Por Datas</h3>
        <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendas" method="POST">
            <div class="row">
                <div class="col-4">
                <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                </div>
                <div class="col-4">
                <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                </div>
                <div class="col-4">                                 
                </div>
                <div style="margin-top: .5em;">
                <button style="margin-top:.5em; margin-left: .1em; width: 20%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                </div>
            </div>
        </form>
    </div>


    <div class="">
        <table class="table" style="text-align: center;">
            <thead  class="thead-dark">
                <tr>
                  <th scope="col">PEDIDO #ID</th>
                  <th scope="col">NOME</th>                              
                  <th scope="col">VALOR R$</th>
                  <th scope="col">DATA</th>
                  <th scope="col">DETALHE PEDIDO</th>
                </tr>
            </thead>
                            
    <%--<fmt:formatNumber value="${obj.valortotal}" type="currency"  /> Valor substituído para tratar erro--%>
            <c:set var="valortotal" value="${0}"/>
            <tbody style="font-family: sans-serif;">
                    <c:set var="total" value="${0}" />
                    <c:forEach var="obj" items="${pedo}">                              
                        <c:set var="total" value="${total + obj.valortotal}" />
                     <tr>
                         <th scope="row">#${obj.idpedido}</th>
                           <td>${obj.idcliente.getClinome()}</td>                                  
                           <td>
                               <c:choose>
                                   <c:when test="${obj.valortotal != null && obj.valortotal != 0}">
                                       <fmt:formatNumber value="${obj.valortotal}" type="currency"  />
                                   </c:when>
                                   <c:otherwise> R$ 0.00 </c:otherwise>
                                </c:choose>
                           </td>
                           <td>
                             <fmt:formatDate value="${obj.data}" type="date"/> 
                           </td>
                           <td>
                               <form action="${pageContext.request.contextPath}/controlePedidos" method="GET">
                                   <input type="hidden" value="${obj.idpedido}" name="idpedi">
                                 <button style="margin-top:.5em; margin-left: .1em; width: 60%; height: auto;" type="submit" class="btn btn-outline-dark my-1">ITENS DOS PEDIDO</button>                                
                                </form>
                           </td>

                     </tr>

                     </c:forEach>
                    <hr>
                    <div >
                        <h5 id="sloganUm" style="margin-top:2em; margin-left: 1em;"> VENDA NO PERÍODO:  
                        <span style="margin-left: 1em; color: black;">
                            <c:choose>
                                <c:when test="${total != null && total != 0}">
                                    <fmt:formatNumber value="${total}" type="currency"  />
                                </c:when>
                                <c:otherwise> 
                                    R$ 0.00 
                                </c:otherwise>
                            </c:choose>
                        </span> 
                        </h5>
                    </div>
                    <hr>
                </tbody>
        </table>
    </div>
</body>


