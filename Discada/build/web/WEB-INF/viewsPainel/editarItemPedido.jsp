<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<body>               
    <!-- Page content-->
    <div class="container-fluid">        
        <div style="margin-left:2.5em; margin-top: 3em;">
            <h4 id="sloganUm"> Dados Gerais do Item Pedido </h4>
            <a style="margin-bottom: 1.5em;" href="#" class="btn btn-outline-info" type="button">Voltar aos Itens</a> 

            <p class="mt-4" style="margin-bottom: 1.5em; font-family: arial; font-size: 17px;">Pedido número <strong>${iditem.idped.getIdpedido()}</strong> criado em <strong><fmt:formatDate value="${iditem.idped.getData()}" type="date"/></strong></p>
        </div>
        
        <div style="margin-left:2.5em;">
            <p style="font-family: arial; font-size: 17px;"><strong>Produto</strong>: ${iditem.idpro.getPronome()} | ${iditem.idpro.getProdescr()}</p>        
            <p style="font-family: arial; font-size: 17px;"><strong>Preço:</strong> <fmt:formatNumber value="${iditem.valoritem}" type="currency"  /> | <strong>Quantidade:</strong> ${iditem.quantidade} unid. | <strong>Valor Total:</strong> <fmt:formatNumber value="${iditem.valortotalitem}" type="currency"  /></p>                
        </div>        
    </div>
    <hr>

    <div class="container-fluid">
        <div class="row">            
            
            <div  class="col-sm-5">
                    
                    <div class="justify-content-md-center">
                        <img style="width:60%; margin-left: 2.5em; margin-bottom: 2em;" class="card-img-top mb-5 mb-md-0" src="${initParam.produtosImagemPath}${iditem.idpro.getPronome()}.jpg">
                    </div>
                    <div class="justify-content-md-center" style="margin-left: 2.5em;">
                        <p>Negociação em <strong style="text-transform: uppercase; color: #0c63e4">${iditem.idstatus.getNomestatus()}</strong></p>
                        <h6>Justificativa do Comprador ${iditem.idped.idcliente.getClinome()} ${iditem.idped.idcliente.getClisobrenome()}</h6>
                        <h6>CPF n° ${iditem.idped.idcliente.getClicpf()}</h6>
                        <p>${iditem.observatroca}</p>
                        <p>quantidade solicitada : ${iditem.qtdtroca}</p>
                    </div>
                        
            </div>  
            
            <div class="col-sm-7">
                  <div class="justify-content-md-center">        
                    
                        <h5> GERENCIADOR DO STATUS DA POSTAGEM</h5>
                        
                        <div>
                            <p style="font-size: 13px;">1° AGUARDANDO PAGAMENTO > 2° EM SEPARAÇÃO >> 3° EM ROTA >>> 4° ENTREGUE </p>
                        </div>          
                            <c:choose>
                                <c:when test="${iditem.idstatusposta.getIdpostagem() == 1}">
                                    <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO</p>
                                    
                                    
                                </c:when>
                                
                                <c:when test="${iditem.idstatusposta.getIdpostagem() == 2}">
                                    <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO</p>
                                    <p style="background-color: #6959CD; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:whitesmoke; width: 50%; text-align: center;">EM SEPARAÇÃO </p>
                                </c:when>
                                
                                <c:when test="${iditem.idstatusposta.getIdpostagem() == 3}">
                                    <p style="background-color: #E6E6FA; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:black; width: 40%; text-align: center;">AGUARDANDO PAGAMENTO </p>
                                    <p style="background-color: #6959CD; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:whitesmoke; width: 50%; text-align: center;">EM SEPARAÇÃO </p>
                                    <p style="background-color: #483D8B; border-radius: 10px 5%; font-size: 15px; font-family: cursive; color:whitesmoke; width: 60%; text-align: center;">EM ROTA </p>
                                </c:when>
                                
                                <c:when test="${iditem.idstatusposta.getIdpostagem() == 4}">
                                    <p style="background-color: #E6E6FA; border-radius: 10px 5%; color:black; width: 40%; font-size: 15px; font-family: cursive; text-align: center;">Aguardando Pagamento </p>
                                    <p style="background-color: #6959CD; border-radius: 10px 5%; color:whitesmoke; width: 50%; font-size: 15px; font-family: cursive; text-align: center;">Em Separação</p>
                                    <p style="background-color: #483D8B; border-radius: 10px 5%; color:whitesmoke;; width: 60%; font-size: 15px; font-family: cursive; text-align: center;">Em Rota </p>
                                    <p style="background-color: #191970; border-radius: 10px 5%; color:whitesmoke; width: 70%; font-size: 15px; font-family: cursive; text-align: center;">Entregue! </p>
                                </c:when>                                                            
                            </c:choose>
                        
                        <form action="${pageContext.request.contextPath}/addPostagem" method="POST">
                            
                            <input value="${iditem.itempedidoid}" name="itempedidoid" type="hidden" >
                            <input type="hidden" value="${iditem.idpro.getProid()}" name="idpro">
                            <input type="hidden" value="${iditem.idped.getIdpedido()}" name="idped">                                        
                            <input type="hidden" value="${iditem.idstatus.getIdtipostatus()}" name="tipostatus">
                            <input type="hidden" value="${iditem.valoritem}" name="valoritem">
                            <input type="hidden" value="${iditem.quantidade}" name="quantidade">
                            <input type="hidden" value="${iditem.valortotalitem}" name="valortotalitem">
                            
                            <select name="tipopostagem" class="form-control">
                                <option value="${iditem.idstatusposta.getIdpostagem()}" selected>ESCOLHA ESTADO DO ENVIO</option>
                                <option value="1">AGUARDANDO PAGAMENTO</option>
                                <option value="2">PREPARANDO PRODUTO</option>                                            
                                <option value="3">PRODUTO ENVIADO</option>
                                <option value="4">PRODUTO ENTREGUE</option>                                            
                            </select>
                            <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 1em; margin-top: 2em;">
                                <i class="bi bi-plus-circle-dotted"> ATUALIZAR POSTAGEM </i>
                            </button>

                        </form>
                    
                                <hr>
                           <h5> VERIFICAÇÃO DE STATUS PARA O ITEM</h5>
                        
                                <form action="${pageContext.request.contextPath}/editarItemPedido" method="POST">
                                    
                                    <div class="justify-content-md-center">
                                        <input value="${iditem.itempedidoid}" name="itempedidoid" type="hidden" >
                                        <input type="hidden" value="${iditem.idpro.getProid()}" name="idpro">
                                        <input type="hidden" value="${iditem.idped.getIdpedido()}" name="idped">                                        
                                        <input type="hidden" value="${iditem.idstatusposta.getIdpostagem()}" name="idpostagem">
                                        <input type="hidden" value="${iditem.valoritem}" name="valoritem">
                                        <input type="hidden" value="${iditem.quantidade}" name="quantidade">
                                        <input type="hidden" value="${iditem.valortotalitem}" name="valortotalitem">
                                        <input type="hidden" value="${iditem.observatroca}" name="observatroca">
                                        <input type="hidden" value="${iditem.qtdtroca}" name="qtdatroca">
                                        
                                        
                                        <input type="hidden" name="nomecupom" value="${iditem.idpro.getPronome()} ${iditem.idped.idcliente.getClisobrenome()}">
                                        <input type="hidden" name="idcliente" value="${iditem.idped.idcliente.getCliid()}">
                                        
                                        <select name="tipostatus" class="form-control">
                                            <option value="1">ESCOLHA UM NOVO STATUS*</option>
                                            <option value="1">ANDAMENTO</option>                                            
                                            <option value="3">CANCELAMENTO NEGADO</option>
                                            <option value="4">CANCELAMENTO ACEITO</option>                                            
                                            <option value="6">TROCA NEGADA</option>
                                            <option value="7">TROCA ACEITA</option>
                                            <option value="8">TROCA CONCLUÍDA</option>
                                            <option value="9">FINALIZADO</option>
                                        </select>
                                            <button type="submit" class="btn btn-outline-dark" style="margin-bottom: 5em; margin-top: 2em;">
                                                <i class="bi bi-plus-circle-dotted"> ATUALIZAR NEGOCIAÇÃO </i>
                                            </button>
                                    </div>
                                </form>   
                        </div>
            </div>
      <hr>
      <div class="col-12" style="margin-bottom: 3em; align: justify;">
      <h5>* Legenda de Orientação para Manejo do Status</h5>
      <hr>
      <li><strong>ANDAMENTO:</strong> Fluxo normal da negociação</li>
      <hr>
      <p><span style="color:#ff0000;">ATENÇÃO!!!</span> Opção geralmente utilizada apenas antes do despacho ou em caso de extravio</p>
      <li><strong>CANCELAMENTO NEGADO:</strong> Em caso de solicitação do CANCELAMENTO por parte do cliente
          SEM justificativa satisfatória, opção para recusa da requisição</li>
      <li><strong>CANCELAMENTO ACEITO:</strong> Em caso de solicitação do CANCELAMENTO por parte do cliente
          COM justificativa satisfatória, opção para o aceite da requisição</li>
      <hr>
      <p><span style="color:#ff0000;">ATENÇÃO!!!</span> Opção utilizada apenas com a confirmação da entrega do produto ao cliente</p>
      <li><strong>TROCA NEGADA</strong> Em caso de solicitação da TROCA por parte do cliente
          sem justificativa satisfatória, opção para recusa da requisição</li>
      <li><strong>TROCA ACEITA:</strong> Em caso de solicitação da TROCA por parte do cliente
          COM justificativa satisfatória, opção para o aceite da requisição</li>
      </div>  
      </div>
    </div> 
</body>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../../js/scripts.js"></script>
