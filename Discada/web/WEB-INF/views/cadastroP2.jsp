<body>
    <section>
        <div class="row">
            <div class="col-sm-6">
                <h5 id="sloganUm" style="margin-left: 3em;"> AINDA NÃO TEM UMA CONTA? INICIE SEU CADASTRO AQUI!</h5>
                <h5>${login}</h5>
                <form name="senha" action="${pageContext.request.contextPath}/cadastroP2" method="POST">
                    
                    <div style="background-color:#FFF0F5; padding: 1em; border-radius: 15px;">
                        <div class="justify-content-md-center" style="width: 80%; margin-left: 3em;">
                            <input type="text" id="loginCad" name="login" class="form-control" placeholder="Login" required>                  
                        </div>

                        <div class="justify-content-md-center" style="width: 80%; margin-left: 3em; margin-top: 1em; margin-bottom: 1em;">
                            <input type="password" name="password" class="form-control" placeholder="Senha" required>                  
                        </div>

                        <div class="justify-content-md-center" style="width: 80%; margin-left: 3em;">
                            <input type="password" name="passwordteste" class="form-control" placeholder="Senha Novamente" required>                  
                        </div>

                        <button style="margin-top: 1.5em; margin-left: 3em; width:80%; margin-bottom: 3em;" type="submit" class="btn btn-outline-dark" onclick="vali()">
                            CONFIRMAR E AVANCE
                        </button> 
                        <p style="margin-left: 4em; margin-top: -3em; font-family: cursive; font-size: 13px;"> Senha forte: "MAIÚSCULO" "minúsculo" "1,2 3..." "@,%,$..." "min. 6 dígitos"</p>

                    </div>
                </form>
                <c:choose>
                    <c:when test="${msgSenhaIgual != null}">
                        <div style="margin-top: 1em;" class="alert alert-danger" role="alert">
                            <p>Olá! Sentimos muito, mas  ${msgSenhaIgual}</p>
                        </div>
                    </c:when>
                    <c:when test="${msgerrotam != null}">
                        <div style="margin-top: 1em;" class="alert alert-danger" role="alert">
                            <p>Olá! Sentimos muito, mas ${msgerrotam}</p>
                        </div>
                    </c:when>
                    <c:when test="${msgerromaior != null}">
                        <div style="margin-top: 1em;" class="alert alert-danger" role="alert">
                            <p>Olá! Sentimos muito, mas ${msgerromaior}</p>
                        </div>
                    </c:when>
                </c:choose>
            </div>

            <div class="col-sm-6">
                 <h5 id="sloganUm" style="margin-left: 3em; color:#483D8B;"> JÁ POSSUI UMA CONTA? ENTÃO ACESSE AQUI!</h5>
                 <form action="${pageContext.request.contextPath}/paginaLogin" method="POST">                     
                     <div style="background-color: #E6E6FA; padding: 1EM; padding-bottom: 2.2em; border-radius: 15px;"> 
                         <div class="justify-content-md-center" style="width: 80%; margin-left: 3em; margin-top: 1em; margin-bottom: 1em;"  >
                            <input type="text" name="login" class="form-control" required placeholder="Insira o Login">            
                         </div>

                         <div class="justify-content-md-center" style="width: 80%; margin-left: 3em;">
                             <input type="password" class="form-control" name="senha" required style="margin-bottom: 1em;" placeholder="Insira a Senha">                                    
                             <input type="hidden" name="idsegredo" value="${se.secid}}"
                         </div>
                              
                         <button style="margin-top: 1.5em; margin-left: 3em; width:80%; margin-bottom: 3em;" type="submit" class="btn btn-outline-primary" onclick="vali()">
                            ENTRE EM SUA CONTA
                        </button> 
                     </div>
                 </form> 
                 
             <c:choose>
                <c:when test="${errologin != null}">
                    <div style="margin-top: 1em;" class="alert alert-danger" role="alert">
                        <p>Olá ${cliente.clinome}, sentimos muito, mas  ${errologin}</p>
                    </div>
                </c:when>
            </c:choose>
                     
            </div>
        </div>
    </section>
</body>

