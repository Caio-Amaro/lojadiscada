<%-- 
    Document   : paginaDadosPessoais
    Created on : 20/02/2022, 09:52:16
    Author     : Caio Costa Amaro
    Description: Página para editar os dados pessoais dos usuários
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <body>    
        <section class="py-5 bg-light">
            <div style="text-align: center; margin-top: -1em;">
                <h5 id="sloganUm"> DADOS PESSOAIS </h5>                
            </div>
       
            <div  class="container">                           
                <form action="${pageContext.request.contextPath}/paginaDadosPessoais" method="POST">
                    <div class="row" style="margin-bottom: 2em;">

                        <div for="frmCadastro" class="col-4">
                          <label>Nome</label>  
                          <input type="text"  name="nome" class="form-control" value="${cliente.clinome}">
                        </div>

                        <div class="col-6">
                          <label>Sobrenome</label>  
                          <input type="text"  name="sobrenome" class="form-control" value="${cliente.clisobrenome}">
                        </div>

                        <div class="col-2">
                          <label>CPF</label>
                          <input type="text"  name="cpf" class="form-control" value="${cliente.clicpf}">
                        </div>

                        <div class="col-4">
                          <label>Email</label>
                          <input type="text" name="email" class="form-control" value="${cliente.cliemail}">
                        </div>

                        <div class="col-3">
                          <label>Genero</label>
                          <input type="text"  name="genero" class="form-control" value="${cliente.cligenero}">
                        </div>

                        <div class="col-2">
                          <label>DDD</label>
                          <input type="text" name="ddd" class="form-control" value="${cliente.cliddd}">
                        </div>

                        <div class="col-3">
                          <label>Telefone</label>
                          <input type="text" name="tel" class="form-control" value="${cliente.clitelefone}">
                        </div>
                        
                        <input type="hidden" name="idcli" value="${cliente.cliid}">
                        <input type="hidden" name="idsegr" value="${cliente.idsegredo.secid}">

                        <button style="margin-top: .5em; width:20%; margin-left: .8em;" type="submit" class="btn btn-outline-secondary">Confirme Alteração</button> 
                    </div>
                </form>
                <h5>${msgEditaCli}</h5>
                <p>teste: ${cliente.idsegredo.secid} </p>
                <p>teste1: ${trocaseg.seclogin} </p>
                <p>teste2: ${trocaseg.secsenha} </p>
                <hr>
                
                <form action="${pageContext.request.contextPath}/paginaDadosPessoaisSenha" method="POST">
                    <div class="row">

                        <div style="text-align: center; margin-top: 1em;">
                            <h5 id="sloganUm"> ALTERAR SENHA </h5>                
                        </div>

                        <div class="col-6">
                          <label>Senha</label>
                          <input type="password" name="senha" class="form-control" value="${trocaseg.secsenha}" placeholder="***********">
                          <small id="erro-senha" class="alertaOK"></small>
                        </div>

                        <div class="col-6">
                          <label>Repita senha para alterar</label>
                          <input type="password" name="senhaone" class="form-control" value="${trocaseg.secsenha}" placeholder="***********">
                          <small id="erro-senha1" class="alertaOK"></small>

                          <input type="hidden" name="idsegr" value="${cliente.idsegredo.secid}">
                          <input type="hidden" name="login" value="${trocaseg.seclogin}">
                        </div>

                        <button style="margin-top: .5em; margin-left: .8em; width:20%;" type="submit" class="btn btn-outline-secondary">Confirme Alteração</button> 
                        <h5>${msgseg}</h5>
                    </div>
                </form>                        
            </div>
        </section>
    </body>
</html>
