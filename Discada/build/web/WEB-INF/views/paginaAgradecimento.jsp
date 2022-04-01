<%-- 
    Document   : paginaAgradecimento
    Created on : 31/03/2022, 14:13:10
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
    <section class="py-5">
        <div class="container">
            <div class="card border-info mb-3" style="max-width: 118rem;">
                <div class="card-header">OBRIGADO PELA COMPRA</div>
                    <div class="card-body text-dark">
                        <h5 class="card-title">Olá, ${cliente.clinome}</h5>
                        <p class="card-text">Nós, da DISCADA, gostaríamos de agradecer imensamente pela confiança em nossos produtos! Esperamos que você esteja super feliz com a sua compra, assim como nós estamos.</p>
                        <p>Não só isso, esperamos que você faça um bom uso do seu que ele supere as suas expectativas! </p>
                        <p>Se puder, compartilhe também um feedback sobre o produto, viu? Ele vai nos ajudar muito a entender como você está aproveitando ele de melhor e, se tiver algum ponto de melhoria, será ótimo para tornarmos ele ainda melhor. 🙂</p>
                        <p>E, claro, se precisar de ajuda, é só falar! Estamos sempre à disposição!</p>
                        <p>Um grande abraço!</p>
                        <br>
                        <p>Att. Discada, sua loja de discos raros</p>
                         
                        <a href="/Discada/gerenciaCliente" type="submit" class="btn btn-outline-success">VOLTAR - Minha Conta</a>
                        
                </div>
            </div>
        </div>

    </section>
</body>