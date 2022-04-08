<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- Page content-->

<body>
    <div class="container-fluid">
    <h3 id="sloganUm" class="mt-4" style="margin-bottom: 1em;">LISTAGEM DE CUPONS</h3>
        <form class="form-inline">
            <div class="row ">
                <div class="col-6 col-md-2">
                    <select class="custom-select mr-sm-1" id="inlineFormCustomSelect" style="padding: .5em; margin-right: 2em;">
                                <option selected>Tipo de Cupom</option>
                                <option value="1">Desconto</option>
                                <option value="1">Troca</option>                                              
                    </select>
                </div>

                <div class="col-12 col-md-5">
                    <input type="search" id="form1" class="form-control" placeholder="Busca pelo nome do cupom" />
                </div>
                <div class="col-6 col-md-2">
                    <button type="submit" class="btn btn-primary">
                        <i class="bi bi-box-seam"> PESQUISA</i>
                    </button>
                </div>
            </div>
        </form>
    <hr>
    </div>

    <div style="margin-left: .2em; margin-bottom: 2em;" class="row">
            <div class="col-6 col-md-3">
                <a href="/Discada/adicionarCupomPromo" name="promo" class="btn btn-warning">Adicionar Cupom DESCONTO</a>        
            </div>

            <div class="col-6 col-md-3">        
                <a href="/Discada/adicionarCupomTroca" name="troca" class="btn btn-success">Adicionar Cupom de Troca</a> 
            </div>
            <p style="font-size: 12px;">Atenção! Cupons de TROCA são normalmente adicionados automaticamente. Usar em casos especiais (exemplo: Extravio de mecadoria)</p>
    </div>
    
    <div class="">
        <table class="table" style="text-align: center;">
            <thead>
                <tr>
                  <th scope="col">Id do Cupom</th>
                  <th scope="col">Nome do Cupom</th>
                  <th scope="col">Cliente do Cupom</th>                          
                  <th scope="col">Valor do Cupom</th>

                  <th></th>
                  <th></th>
                </tr>
            </thead>

            <tbody style="text-align: center;">
                <c:forEach var="obj" items="${listacup}">
                    <tr>
                          <th>#${obj.idcupom}</th>
                          <td>${obj.nomecupom}</td>
                          <td>${obj.idclientecup.getClinome()}</td>
                          <td><c:choose>
                                  <c:when test="${obj.valorcupom != null && obj.valorcupom != 0 && obj.idtipo !=2}">
                                    <fmt:formatNumber value="${obj.valorcupom}" type="currency"/>
                                  </c:when>
                                  <c:otherwise>
                                      ${obj.valorcupom} %
                                  </c:otherwise>
                          </c:choose></td>                              
                          <td><a class="btn btn-outline-secondary" href="/Discada/editarCupom?${obj.idcupom}" role="button">Editar Cupom</a></td>              
                          <td> <a href="/Discada/listarCupom?${obj.idcupom}" name="idRemove" class="btn btn-danger">Excluir Cupom</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
 </body>
