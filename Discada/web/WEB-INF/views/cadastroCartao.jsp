<%-- 
    Document   : cadastroCartao
    Created on : 03/03/2022, 10:06:43
    Author     : user
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<c:choose>
    <c:when test="${cliente.cliid == null}">
        <c:redirect url="cadastroP2"/>        
    </c:when>
</c:choose> --%>


<!-- Body and Section-->
<body>
    <section class="py-2 bg-light">
        <div class="container" style="width:40%; height: auto;">    
            <div style="text-align: center; margin-top: -1em; padding:.2em;" class="bg-dark text-white">
                <h5> Olá, ${cliente.clinome}. Adicione um Cartão de Crédito </h5>
            </div>

            <form action="${pageContext.request.contextPath}/cadastroCartao" method="POST">
        
                <div class="form-group" style="width: 50%;">
                    <label>Número do cartão</label>
                    <input type="text" name="num" required class="form-control" placeholder="XXXX XXXX XXXX XXXX">                                    
                </div>

                <div class="form-group" >
                    <label>Nome</label>
                    <input type="text" name="nome" required class="form-control" placeholder="Como está no cartão">

                </div>

                <div class="form-group" style="width:50%;">
                    <label>CVV</label>
                    <input type="text" name="cvv" required class="form-control" placeholder="999">            
                </div>
                <div>
                    <label>Bandeira</label>
                    <select name="bandeira" class="form-control">
                        <option value="VISA" selected>BANDEIRA DO CARTÃO</option>
                        <option value="VISA">VISA</option>
                        <option value="MASTERCARD">MASTERCARD</option>                                            
                        <option value="AMERICAN EXPRESS">AMERICAN EXPRESS</option>
                        <option value="DINNERS">DINNERS</option>
                        <option value="HIPERCARD">HIPERCARD</option>
                        <option value="HIPERCARD">ELO</option>
                    </select>

                </div>

                <label style="margin-top: 2em;">Data de Expiração</label>
                <input type="date" name="data" required class="form-control">
                <input type="hidden" value="${cliente.cliid}" name="idcli">
                <button style="margin-top: 1.3em;" type="submit" class="btn btn-outline-success">Cadastrar</button>
                <a style="margin-top: 1.3em;" type="button" href="/loja/paginaCartoes?idc=${cliente.cliid}" class="btn btn-outline-dark">Cancelar</a>
            </form>                            
            <img style="width: 70%;" src="img/cartao.png">
        </div>
    </section>
</body>