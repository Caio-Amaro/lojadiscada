<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <div class="container-fluid" >
        <h3 id="sloganUm" style="margin-bottom: 1em; margin-top: 2em;">EDITAR CUPONS</h3>
        <hr>
    </div>

    <div class="container-fluid" style="font-family: sans-serif;">
        <div class="row">
            <div class="col-10">
                <h4 style="text-align: center; font-family:monospace; ">NOME DO CLIENTE : <strong>${cup.idclientecup.getClinome()} ${cup.idclientecup.getClisobrenome()}</strong></h4>
               <hr>
               <form action="${pageContext.request.contextPath}/editarCupom" method="POST" class="list-group-item">

                    <h6 id="sloganUm">TÍTULO DO CUPOM</h6>
                    <input id="blockProductDois" class="form-control form-control-lg" value="${cup.nomecupom}" name="nomecupom" type="text" >

                    <h6 style="margin-top:2em;" id="sloganUm">ID do Cliente</h6>
                    <input id="blockProductDois" class="form-control" type="text" value="${cup.idclientecup.getCliid()}" name="idcliente">
                    <c:choose>
                        <c:when test="${cup.idtipo !=2}">
                            <hr>
                            <div style="margin-top:4em; text-align: center;">
                               <h6 id="sloganUm">Valor do Cupom de Troca</h6>
                               <p style="text-align: center; font-family:monospace;"> | IMPORTANTE! Adicione um valor em reais | </p>
                            </div>
                            <hr>
                               <input id="blockProductDois" style="margin-bottom: 1.5em; margin-left: 23em; width:15%; text-align: center" type="text" name="valorcupom" class="form-control" value="${cup.valorcupom}">
                               <input name="desconto" type="hidden" value="1">
                               <input name="id" type="hidden" value="${cup.idcupom}" >
                            <div class="form-group">
                                <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 5em; margin-left: 18em;">
                                      <i class="bi bi-plus-circle-dotted"> EDITAR CUPOM DE TROCA</i>
                                </button>
                            </div>
                        </c:when>
                       
                        <c:otherwise>
                            <hr>
                            <div style="margin-top:4em; text-align: center;">
                               <h5 id="sloganUm">Valor do Cupom de Desconto</h5>
                               <p style="text-align: center; font-family:monospace;"> | IMPORTANTE! Adicione um valor em percentual | </p>
                            </div>
                            
                               <input id="blockProductDois" style="margin-bottom: 1.5em; margin-left: 23em; width:15%; text-align: center;" type="text" name="valorcupom" class="form-control" value="${cup.valorcupom}">
                               <input name="desconto" type="hidden" value="2">
                               <input name="id" type="hidden" value="${cup.idcupom}" >
                            <div class="form-group">
                                <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 5em; margin-left: 18em;">
                                      <i class="bi bi-plus-circle-dotted"> EDITAR CUPOM DE DESCONTO</i>
                                </button>
                            </div>

                        </c:otherwise>
                    </c:choose>
                </form>
            </div>
        </div>
    </div>
</body>
