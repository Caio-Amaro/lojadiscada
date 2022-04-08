<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page content-->

<body>
    <div class="container-fluid">
        <h3 id="sloganUm" class="mt-4">DADOS DO CLIENTE: ${selecioneCl.clinome} ${selecioneCl.clisobrenome}</h3>        
    <hr>
    <form action="#" method="POST">
        <input type="hidden" name="idclie" value="${selecioneCl.cliid}">
        <button type="button" class="btn btn-outline-warning">
            <i class="bi bi-stop-circle"> PAUSAR O CLIENTE</i>
        </button>
        <a class="btn btn-outline-dark" href="/Discada/controleClientes" role="button">Voltar ao Controle Geral</a>
    </form> 
        

    </div>
    <hr>
    <hr>


    <div class="container-fluid">
        <div class="row">
            <div class="col-12 col-md-3 text-inline">
                <p>Nome Cliente : <strong>${selecioneCl.clinome}</strong></p>                        
            </div>
            <div class="col-12 col-md-3">
                <p>Sobrenome : <strong>${selecioneCl.clisobrenome}</strong></p>
            </div>
            <div class="col-12 col-md-3">
                <p>CPF : <strong>${selecioneCl.clicpf}</strong></p>                        
            </div>
            <div class="col-12 col-md-3">
                <p>E-mail : <strong>${selecioneCl.cliemail}</strong></p>                        
            </div>
            
        </div>
    </div>
    <hr>

    <div class="container-fluid">                    
        <div class="row">
            <h5 id="sloganUm" class="mt-4">ENDEREÇOS CADASTRADOS</h5>
            <h6 style="text-align: center;"></h6>
            
            <c:forEach var="end" items="${ender}">
                <div class="col-12 col-sm-5">
                    <p>Nome : <strong>${end.endnomedestino}</strong></p>                        
                </div>

                <div class="col-12 col-sm-3">
                    <p>Cidade : <strong>${end.endcidade}</strong></p>                        
                </div>
                <div class="col-12 col-sm-2">
                    <p>Estado : <strong>${end.endestado}</strong></p>
                </div>

                <div class="col-12 col-sm-2">
                    <p>CEP : <strong>${end.endcep}</strong></p>                        
                </div>
                <p style="background-color: #7B68EE; width: 100%; height: 1px;"></p>
            </c:forEach>
        </div>
                   
    </div>
    <hr>
    
    
    <div style="margin-top: 2em;" class="container-fluid">
        <div class="row">                            
            <c:set var="total" value="${0}" />
            <c:set var="cont" value="${0}" />
            <h5 id="sloganUm">DATAS DAS COMPRAS</h5>                                                
            
            <div class="col-12 col-sm-4"  >
            <c:forEach var="ite" items="${pedidoCliente}">
                <c:set var="total" value="${total + ite.valortotal}" />
                <c:set var="cont" value="${cont + 1}"/>
                <span style="margin-right: .5em;"><strong>
                    <c:choose>
                        <c:when test="${ite.data != null}">
                            <fmt:formatDate value="${ite.data}" type="date"/>
                        </c:when>
                        <c:otherwise>sem registro de data</c:otherwise>
                    </c:choose>
                    </strong> | ID da COMPRA : ${ite.idpedido} ---</span>
            </c:forEach>
            
            <c:choose>
                <c:when test="${cont != null && cont != 0}">
                    <div style="margin-top: 1em;" class="col-12 col-md-12">
                        <span>N° PEDIDOS : <strong>${cont}</strong></span>                        
                    </div>
                </c:when>
                <c:otherwise>
                    <p>
                        Nenhum Pedido!
                    </p>
                </c:otherwise>
            </c:choose> 
            </div>
         </div>
    </div>                
    <hr>

    <div style="margin-bottom: 6em;" class="container-fluid">
        <div class="row">
            <div class="col-12 col-md-12 text-inline">
                <h6 style="text-transform: uppercase;">Volume total negociado pelo cliente ${selecioneCl.clinome} foi dE : R$                                 

                    <strong style="background-color: #87CEEB; border-radius: 10px 5%; font-size: 25px; font-family: cursive; color:black; width: 50%; text-align: center;">
                        <c:choose>
                            <c:when test="${total != null && total != 0 }">
                        <fmt:formatNumber value="${total}" type="currency"  />
                            </c:when>
                        <c:otherwise>
                            R$ 0,00
                        </c:otherwise>

                        </c:choose>

                    </strong></h6>                      
            </div>
        </div>
    </div>

 </body>
