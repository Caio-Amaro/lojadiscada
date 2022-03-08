<%-- 
    Document   : cadastroP1
    Created on : 03/03/2022, 14:11:53
    Author     : Caio Costa Amaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <!-- Body and Section-->

<body>
    <section >
        <div class="container" style="background-color: #FFF0F5; border-radius: 15px; ">
            <div  class="row justify-content-md-center">                      
                <div style="text-align: center; margin-top: 3em; margin-bottom: 2em; padding: 1em; width:70%; background-color: #FDFEFE; border-radius: 20px;">
                    <h4 id="sloganUm"> Falta Pouco! Insira seus Dados Pessoais </h4>
                </div>

                <form action="${pageContext.request.contextPath}/cadastroP1" method="POST">
                    <div class="row">            
                        <div class="col-12 col-md-4">
                          <label>Nome</label>  
                          <input type="text" class="form-control" id="nomeCad" name="nome" required>                  
                        </div>

                        <div class="col-12 col-md-6" style="margin-bottom: 1em;">
                          <label>Sobrenome</label>  
                          <input type="text" name="sobrenome" class="form-control" required>                  
                        </div>

                        <div class="col-12 col-md-2">
                          <label>CPF</label>
                          <input type="text" class="form-control" name="cpf" required>                  
                        </div>
                    </div>

                    <div class="row">

                        <div class="col-12 col-md-4" style="margin-bottom: 1em;">
                          <label>Email</label>
                          <input type="text" class="form-control" name="email" required>                 
                        </div>

                        <div class="col-12 col-md-3">
                          <label>Gênero</label>
                          <input type="text" class="form-control" name="genero">                  
                        </div>

                        <div class="col-8 col-md-2">
                          <label>DDD</label>
                          <input type="text" class="form-control" name="ddd" required>                  
                        </div>

                        <div class="col-8 col-md-3" style="margin-bottom: 1em;">
                          <label>Telefone</label>
                          <input type="text" class="form-control" name="tel" required>                  
                        </div>

                        <input type="hidden" name="idsegredo" value="${se.secid}">
                        <button href="/loja/gerenciaCliente" style="margin-top: 1.5em; margin-left: 25em; width:30%; margin-bottom: 3em;" type="submit" class="btn btn-warning">Confirmar e Continuar</button> 
                    </div>
                </form>
            </div>
        </div>
    </section>
</body>
    


