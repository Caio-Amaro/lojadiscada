<%-- 
    Document   : detalheItemPedido
    Created on : 31/03/2022, 15:37:21
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<body>               
    <!-- Page content-->
    <div class="container-fluid" >        
        <div style="margin-left:5em;">
            <h6 id="sloganUm"> Dados Gerais do Item Pedido </h6>
            <a style="margin-bottom: 1.5em;" href="#" class="btn btn-outline-info" type="button">Voltar aos Itens</a> 

            <p class="mt-4" style="margin-bottom: 1.5em; font-family: arial; font-size: 17px;">Pedido número <strong>${iditem.idped.getIdpedido()}</strong> criado em <strong>${iditem.idped.getData()}</strong
        </div>
        
        <div>
            <p style="font-family: arial; font-size: 17px;"><strong>Produto</strong>: ${iditem.idpro.getPronome()} | ${iditem.idpro.getProdescr()}</p>        
            <p style="font-family: arial; font-size: 17px;"><strong>Preço:</strong> ${iditem.valoritem} | <strong>Quantidade:</strong> ${iditem.quantidade} unid. | <strong>Valor Total:</strong> R$${iditem.valortotalitem}</p>                
        </div>        
    </div>
    <hr>

    <div class="container-fluid">
        <div class="row">            
            
            <div  class="col-sm-5">
                    
                    <div class="justify-content-md-center">
                        <img style="width:60%; margin-left: 3em; margin-bottom: 2em;" class="card-img-top mb-5 mb-md-0" src="${initParam.produtosImagemPath}${iditem.idpro.getPronome()}.jpg">
                    </div>
                  
            </div>  
            
            <div class="col-sm-7">
                <div class="justify-content-md-center">        
                    
                    <h6 id="sloganUm"> VERIFICAÇÃO DE STATUS TRANSAÇÃO DO ITEM</h6>
                    <p style="font-size: 12px;">||ETAPAS|| : 1° AGUARDANDO PAGAMENTO | 2° EM SEPARAÇÃO | 3° EM ROTA | 4° ENTREGUE | </p>
                    <div>   
                        <c:choose>
                            <c:when test="${iditem.idstatusposta.getIdpostagem() == 1}">
                                <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO</p>
                            </c:when>

                            <c:when test="${iditem.idstatusposta.getIdpostagem() == 2}">
                                <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO</p>
                                <p style="background-color: #87CEEB; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 50%; text-align: center;">EM SEPARAÇÃO </p>
                            </c:when>

                            <c:when test="${iditem.idstatusposta.getIdpostagem() == 3}">
                                <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO </p>
                                <p style="background-color: #87CEEB; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 50%; text-align: center;">EM SEPARAÇÃO </p>
                                <p style="background-color: #EEE8AA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 60%; text-align: center;">EM ROTA </p>
                            </c:when>

                            <c:when test="${iditem.idstatusposta.getIdpostagem() == 4}">
                                <p style="background-color: #E6E6FA; border-radius: 10px 5%; color:black; width: 40%; font-size: 15px; font-family: cursive; text-align: center;">Aguardando Pagamento </p>
                                <p style="background-color: #87CEEB; border-radius: 10px 5%; color:black; width: 50%; font-size: 15px; font-family: cursive; text-align: center;">Em Separação</p>
                                <p style="background-color: #EEE8AA; border-radius: 10px 5%; color:black; width: 60%; font-size: 15px; font-family: cursive; text-align: center;">Em Rota </p>
                                <p style="background-color: #FFDAB9; border-radius: 10px 5%; color:black; width: 70%; font-size: 15px; font-family: cursive; text-align: center;">Entregue! </p>
                            </c:when>                                                            
                        </c:choose>
                    </div>
                    <div class="justify-content-md-center">
                        <p>Negociação em <strong style="text-transform: uppercase; color: #0c63e4">${iditem.idstatus.getNomestatus()}</strong></p>                                        
                    </div>
                    <hr>
                    <form action="${pageContext.request.contextPath}/detalheItemPedido" method="POST">
                        
                        <input value="${iditem.itempedidoid}" name="itempedidoid" type="hidden" >
                        <input type="hidden" value="${iditem.idpro.getProid()}" name="idpro">
                        <input type="hidden" value="${iditem.idped.getIdpedido()}" name="idped">                                        
                        <input type="hidden" value="${iditem.idstatusposta.getIdpostagem()}" name="idpostagem">
                        <input type="hidden" value="${iditem.valoritem}" name="valoritem">
                        <input type="hidden" value="${iditem.quantidade}" name="quantidade">
                        <input type="hidden" value="${iditem.valortotalitem}" name="valortotalitem">
                        
                        <c:if test="${iditem.idstatus.getIdtipostatus()== 1}">
                            <c:choose>
                                <c:when test= "${iditem.idstatusposta.getIdpostagem() == 2}">  
                                    <div class="form-group">
                                        <div>
                                            <h6 id="sloganUm">JUSTIFIQUE O CANCELAMENTO</h6>
                                            <textarea  style="width:99%;" rows="4" name="justifica"></textarea>
                                        </div>
                                        <input type="hidden" value="2" name="tipostatus">  

                                        <button type="submit" class="btn btn-warning" style="margin-bottom: 1.5em; margin-top: .5em">
                                            <i class="bi bi-plus-circle-dotted"> Solicitar Cancelamento</i>
                                        </button>
                                    </div>
                                 </c:when>
                                                                           
                                <c:when test="${iditem.idstatusposta.getIdpostagem() == 4}"> 
                                    <div class="form-group">
                                        <div>
                                            <h6 id="sloganUm">JUSTIFIQUE A TROCA</h6>
                                            <textarea  style="width:60%;" rows="4" name="justifica"></textarea>
                                        </div>
                                        <input type="hidden" value="5" name="tipostatus">   
                                        <button type="submit" class="btn btn-warning" style="margin-bottom: 1.5em; margin-top: 0.5em">
                                            <i class="bi bi-arrow-left-right"> Solicitar a Troca </i>
                                        </button>
                                    </div>                                                   
                                </c:when>
                                <c:otherwise><p><span style="color:red;">ATENCÃO!</span> Esse item não está apto para solicitar troca ou cancelamento</p></c:otherwise>
                            </c:choose>
                        </c:if>
                        <c:if test="${iditem.idstatus.getIdtipostatus() != 1}">
                            <p>Esse item não está apto para solicitar troca ou cancelamento</p>  
                        </c:if> 
                    </form>                
                </div>  
            </div>
        </div>
    <hr>
    </div>   
</body>

