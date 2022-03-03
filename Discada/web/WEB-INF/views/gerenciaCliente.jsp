<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : gerenciaCliente
    Created on : 20/02/2022, 19:47:55
    Author     : Caio Costa Amaro
    Descrição  : Página de gerenciamento da conta dos usuários da loja
--%>

<body>
    <section class="py-5 bg-light">

        <div style="text-align: center; margin-top: -1em;">
            <p>${se.secid}</p>
            <h5>Olá<h4 style="color: #D9115A ; text-decoration: overline;">${cliente.clinome} ${cliente.clisobrenome}</h4></h5>
            <h5> ADMINISTRE SUA CONTA AQUI </h5>
            <p style="margin-bottom: 1em;">Abaixo seguem as opções disponÍveis para edição, inclusão e consulta dos itens da sua conta</p>
        </div>

        <!-- blocos de funções da página de gerenciamento -->

        <div  class="container">
            <div class="row justify-content-md-center">
                
                <div class="col col-lg-4">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <i style="font-size: 2.5em; margin-left: 45%;" class="bi bi-file-person"></i>
                            <h5 class="card-title" style="text-align: center; margin-top: .5em;"> DADOS PESSOAIS</h5>
                            <p class="card-text" style="text-align: center;">Aqui você edita seus dados pessoais de acesso como login e ou senha</p>
                            <a href="/Discada/paginaDadosPessoais?${cliente.cliid}" class="btn btn-outline-info">Visitar</a>
                        </div>
                    </div>
                </div>

                <div class="col col-lg-4">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <i style="font-size: 2.5em; margin-left: 45%;" class="bi bi-house-fill"></i>
                            <h5 class="card-title" style="text-align: center; margin-top: .5em;">  CADASTRO DE ENDEREÇOS</h5>
                            <p class="card-text" style="text-align: center;">Aqui você adiciona, exclui ou edita seus endereços de envio e pagamento</p>
                            <form action="${pageContext.request.contextPath}/paginaEndereco" method="GET">                        
                                <input type="hidden" value="${cliente.cliid}" name="idcl">
                                <button style="margin-bottom: -1em;" type="submit" class="btn btn-outline-info">Visitar</button>
                            </form>
                        </div>
                    </div>
                </div>


                <div class="col col-lg-4">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <i style="font-size: 2.5em; margin-left: 45%;" class="bi bi-receipt"></i> 
                            <h5 class="card-title" style="text-align: center; margin-top: .5em;">HISTÓRICO DE PEDIDOS</h5>
                            <p class="card-text" style="text-align: center;">Aqui você acompanha o histórico completo das suas compras</p>
                            <a href="/Discada/paginaHistoricoPedido" class="btn btn-outline-info">Visitar</a>                        
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <br>
        <div  class="container">
            <div class="row justify-content-md-center">
                
                <div class="col col-lg-4">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <i style="font-size: 2.5em; margin-left: 45%;" class="bi bi-credit-card-2-front"></i>  
                            <h5 class="card-title" style="text-align: center; margin-top: .5em;">CADASTRO DE CARTÕES</h5>
                            <p class="card-text" style="text-align: center;">Aqui você inclui e ou exclui seus cartões de crédito</p>
                            <form action="${pageContext.request.contextPath}/paginaCartoes" method="GET">                        
                                <input type="hidden" value="${cliente.cliid}" name="idc">
                                <button type="submit" class="btn btn-outline-info">Visitar</button>
                            </form> 
                        </div>
                    </div>
                  </div>

                    <div class="col col-lg-4">
                        <div class="card" style="border-radius: 15px;">
                            <div class="card-body">
                                <i style="font-size: 2.5em; margin-left: 45%;" class="bi bi-cash-coin"></i>  
                                <h5 class="card-title" style="text-align: center; margin-top: .5em;">CUPONS E TROCAS</h5>
                                <p class="card-text" style="text-align: center;">Aqui você cunsulta seus cupos promocionais e ou reembolsos</p>
                                <a href="/Discada/paginaCupom" class="btn btn-outline-info">Visitar</a>                        
                          </div>
                        </div>
                    </div>

            </div>
        </div>

    </section>
</body>
