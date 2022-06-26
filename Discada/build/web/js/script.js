  
 function myFunction(){
     
                
        var urlAction = document.getElementById('formuser').action;
        var dataInicial = document.getElementById('dataInicial').value;
        var dataFinal = document.getElementById('dataFinal').value;
      
        $.ajax({
            
            method: "POST",
            url: urlAction,
            data: 'dataInicial=' + dataInicial + '&dataFinal=' + dataFinal,            
            success: function( ) {
                alert();
                alert("OK" + dataInicial + "Ok2" + dataFinal + " - " + urlAction);
            } 
        /*}).fail(function(xhr, status, errorThrown){
            alert('Erro ao buscar dados paras o gráfico' + xhr.responseText);*/
        });
        
        const myChart = new Chart(
            document.getElementById('myChart'),
            {
                type: 'line',
                data: {
                    labels: [
                      'January',
                      'February',
                      'March',
                      'April',
                      'May',
                      'June',
                            ],
                    datasets: [
                        {
                            label: 'Exemplo 1',
                            backgroundColor: 'rgb(255, 99, 132)',
                            borderColor: 'rgb(255, 99, 132)',
                            data: [0, 10, 5, 2, 20, 30, 45],                    
                        },
                        {
                            label: 'Exemplo 2',
                            backgroundColor: 'rgb(55, 9, 132)',
                            borderColor: 'rgb(55, 9, 132)',
                            data: [20, 1, 25, 12, 2, 3, 35],                    
                        }
                    ]
                    
                },
                options: {}
            }
        );
    }
 
 // CAMADA DE PROGRAMAÇÃO FRONTEND JAVASCRIPT


 // FUNÇÃO PARA VALIDAÇÃO GERAL DO FORMULÁRIO DA PÁGINA DADOS PESSOAIS


    function valida()
    {
        var nome = document.getElementById('nomeD').value;
        var sobrenome = document.getElementById('sobreno').value;
        var cpf = document.getElementById('cpf').value;
        var senha = document.getElementById('senha').value;
        var senha1 = document.getElementById('senha1').value;
        var email = document.getElementById('email').value;

        

   
        // consistindo nome 
        if(nome == "" || nome == null) {

        alert("Por favor, indique o seu nome.");
        
        
        return false;

        } else {
            document.getElementById('erro-nome').innerHTML = "Legal, é isso aí. Nome OK.";            
        }

        // -------------------------------------------------------------------------------

        // consistindo sobrenome

         if(sobrenome == "" || sobrenome == null) {

        alert("Por favor, seu sobrenome completo.");
        //Foi definido um focus no campo.
        
        return false;

        } else {
            document.getElementById('erro-sobrenome').innerHTML = "Legal é isso aí! Sobrenome OK.";            
        }

        //------------------------------------------------------------------------------------

        //consistindo CPF

        if (validaCPF(cpf) == true ) {document.getElementById('erro-cpf').innerHTML = "Legal é isso aí! cpf OK.";};

        // -----------------------------------------------------------------------------------

        // consistindo senhas

        if(senha == "" || senha == null) {

            alert("Por favor, verifique se a preencheu o campo está vazio e tente novamente.");           
            return false;

        } else if (senha.length < 5) {
            alert("Por favor, verifique se sua senha tem 6 ou mais dígitos e tente novamente.");           
            return false;
        
        } else if (senha != senha1) 
        {
             alert("Por favor, verifique se suas senhas estão iguais e tente novamente.");           
            return false;

        } else {document.getElementById('erro-senha1').innerHTML = "Legal é isso aí! Senhas OK";
         alert("Preencimento conluído com sucesso!"); }
        
        
        //-----------------------------------------------------------------------------------------

        if(email == "" || email == null) {

            alert("Por favor, campo e-mail não pode ficar vazio.");  

            return false; 

         } else if (email.indexOf('@') == -1 || email.indexOf('.') == -1) {
            alert("Por favor, verifique se e-mail foi escrito da forma correta");           
            return false;
        
        } else {document.getElementById('erro-senha1').innerHTML = "Legal é isso aí! Senhas OK";}

        //-------------------------------------------------------------------------------------------

    } // fim da função de validação dos campos!!

        
    // -------------------------------------------------------------------------------------------------//
    // -------------------------------------------------------------------------------------------------//

    // FUNÇÃO PARA VALIDAR O CPF //

    function validaCPF(cpf) {
    var Soma;
    var Resto;
    Soma = 0;
    
     if (cpf == " " || cpf == null)  
     {
        alert("Por favor, indique um cpf válido.");
        return false;
        }

     for (i=1; i<=9; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (11 - i);
          Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        
        if (Resto != parseInt(cpf.substring(9, 10)) ) {

          alert("Por favor, indique um cpf válido.");
          cpf.focus();
          return false;
        }

        Soma = 0;
        for (i = 1; i <= 10; i++) Soma = Soma + parseInt(cpf.substring(i-1, i)) * (12 - i);
          Resto = (Soma * 10) % 11;

        if ((Resto == 10) || (Resto == 11))  Resto = 0;
        
        if (Resto != parseInt(cpf.substring(10, 11) ) ) 
          {
            alert("Por favor, indique um cpf válido.");
            cpf.focus();
            return false;
          }
        

        return true;

    }

    //-----------------------------------------------------------------------------------------------------

    //=========================================================================

    // FUNÇÃO PARA VALIDAÇÃO GERAL DO FORMULÁRIO DA PÁGINA DADOS PESSOAIS


    //=========================================================================

    function validaEndereco ()
    {

      var nome = document.getElementById('nomeE').value;
      var sobrenome = document.getElementById('sobrenomeE').value;
      var telefone = document.getElementById('tel').value;
      var endereco = document.getElementById('endereco').value;
      var comp = document.getElementById('comp').value;
      var numRes = document.getElementById('numRes').value;
      var cidade = document.getElementById('cidade').value;
      var estado = document.getElementById('estado').value;
      var cep = document.getElementById('cep').value;
      var check = document.getElementById('gridCheck').value;

     

      // valida o nome
      
      if(nome == "" || nome == null) {

        alert("Por favor, indique o seu nome.");
        
        return false;

        } else {


            document.getElementById('erro-nom').innerHTML = "Legal é isso aí! Nome OK";           
        }

        // fim do valida nome -----------------------------------------------------------------

        // valida o sobrenome

        if(sobrenome == "" || sobrenome == null) {

        alert("Por favor, indique o seu Sobrenome completo.");
        return false;

        } else {
            document.getElementById('erro-sobrenome').innerHTML = "Legal é isso aí! Sobrenome OK";           
        }

        // fim do valida nome -----------------------------------------------------------------

        // valida o telefone



        if(telefone == "" || telefone == null ) {

        alert("Por favor, o campo não pode estar vazio.");
        return false;

        } else if (telefone.length != 11) 
        
        {
          alert("Por favor, verifique seu telefone, quantidade errada de dígitos.");
        return false;

        } else {document.getElementById('erro-tel').innerHTML = "Legal é isso aí! telefone OK";}

      // fim do valida telefone -----------------------------------------------------------------

      // valida o endereço

       if(endereco == "" || endereco == null) {

        alert("Por favor, indique o seu endereço corretamente");
        return false;

        } else {
            document.getElementById('erro-endereco').innerHTML = "Legal é isso aí! Endereço está OK";           
        }

        // fim do valida endereco -----------------------------------------------------------------

        // valida o numero da casa

        
        if(numRes == "" || numRes == null) {

        alert("Por favor, indique apenas número. O campo nmão estar vazio");
        return false;

        } else {
            document.getElementById('erro-res').innerHTML = "Legal é isso aí! Número OK";           
        }

        // fim do valida número da casa -----------------------------------------------------------------
        // Valida número da cidade

        if(cidade == "" || cidade == null) {

        alert("Por favor, indique sua cidade. Campo não pdoe estar vazio");
        return false;

        } else {
            document.getElementById('erro-cidade').innerHTML = "Legal é isso aí! Cidade OK";           
        }

        // fim do valida cidade -----------------------------------------------------------------

        // valida o numero da estado

        if(estado == "" || estado == null) {

        alert("Por favor, indique o seu Sobrenome completo.");
        return false;

        } else {
            document.getElementById('erro-sobrenome').innerHTML = "Legal é isso aí! Estado OK";           
        }

        // fim do valida estado -----------------------------------------------------------------


        // valida o numero do CEP
        
        if(cep == "" || cep == null) {

        alert("Por favor, indique o seu CEP");
        return false;

        } else if (cep.length != 8) 
        
          { alert("Por favor, verifique seu CEP, quantidade errada de dígitos.");
            return false; 
        } else {
            document.getElementById('erro-cep').innerHTML = "Legal é isso aí! CEP OK";           
        }
       }
        // fim do valida CEP -----------------------------------------------------------------

        //-----------------------------------------------------------------------------------------------------

       //=========================================================================

      // FUNÇÃO PARA VALIDAÇÃO GERAL DO FORMULÁRIO DA PÁGINA DADOS PESSOAIS


      //=========================================================================

      function validaCartao()
    {

      var numeroCar = document.getElementById('numCar').value;
      var nomeC = document.getElementById('nomeC').value;
      var mes = document.getElementById('mes').value;
      var ano = document.getElementById('ano').value;

  // Inicio do valida Cartão -----------------------------------------------------------------

      if(numeroCar == "" || numeroCar == null) 
      {

         alert("Por favor, o campo não pode ficar vazio");
        return false;

      } else if (numeroCar.length != 16) 
        
          { alert("Por favor, verifique seu número do cartão, quantidade errada de dígitos.");
            return false; 
        } else {
            document.getElementById('erro-numCar').innerHTML = "Legal é isso aí! Cartão OK";           
        }
  // fim do valida Cartão ---------------------------------------------------------------------

  //-------------------------------------------------------------------------------------------

  // Inicio do valida Nome no Cartão -----------------------------------------------------------------

       if(nomeC == "") {

        alert("Por favor, indique seu nome como está no cartão. O Campo não pode estar vazio");
        return false;

        } else {
            document.getElementById('erro-nomeCar').innerHTML = "Legal é isso aí! Nome OK";           
        } 

  // fim do valida Nome no Cartão ---------------------------------------------------------------------

  //---------------------------------------------------------------------------------------------------

  // Inicio do valida Mês do cartão -------------------------------------------------------------------

      if(mes == "0" || mes == null) {

        alert("Por favor, indique seu nome como está no cartão. O Campo não pode estar vazio");
        return false;

        } else {
            document.getElementById('erro-mes').innerHTML = "Legal é isso aí! Mês OK";           
        } 
  // fim do valida Mês no Cartão ---------------------------------------------------------------------

  //---------------------------------------------------------------------------------------------------

  // Inicio do valida Ano do cartão -------------------------------------------------------------------

      if(ano == "00" || ano == null) {

        alert("Por favor, o Campo não pode estar vazio. Indique o ano");
        return false;

        } else {
            document.getElementById('erro-ano').innerHTML = "Legal é isso aí! Ano OK";           
        } 
    }
    // fim do valida Ano no Cartão ---------------------------------------------------------------------

  //=========================================================================

    // FUNÇÃO PARA VALIDAÇÃO DO FORMULÁRIO DA PÁGINA DE LOGIN E CADASTRO


  //=========================================================================

    function validaLogin()
    {

      var login = document.getElementById('login').value;
      var senhaL = document.getElementById('senhaL').value;

    // Começo do valida Login --------------------------------------------------------------------

    if(login == "" || login == null) {

            alert("Por favor, campo e-mail não pode ficar vazio.");  

            return false; 

         } else if (email.indexOf('@') == -1 || email.indexOf('.') == -1) {
            alert("Por favor, verifique se e-mail foi escrito da forma correta");           
            return false;
        
        } else {document.getElementById('erro-senha1').innerHTML = "Legal é isso aí! Login OK";}

  // fim do valida Login ------------------------------------------------------------------------------

  //---------------------------------------------------------------------------------------------------

  // Inicio do valida senha do login-------------------------------------------------------------------


    if(senhaL == "" || senhaL == null) {

            alert("Por favor, verifique se a preencheu o campo está vazio e tente novamente.");           
            return false;

        } else if (senhaL.length < 5) {
            alert("Por favor, verifique se sua senha tem 6 ou mais dígitos e tente novamente.");           
            return false;
       
        } else {document.getElementById('erro-senha1').innerHTML = "Legal é isso aí! Senhas OK";
         alert("Preencimento conluído com sucesso!"); }

   } // fim do valida Login ------------------------------------------------------------------------------

 

  //=========================================================================

  // FUNÇÃO PARA VALIDAÇÃO GERAL DO FORMULÁRIO DA PÁGINA DADOS PESSOAIS


    function validaCad()
    {
        var nomeCad = document.getElementById('nomeCad').value;
        var sobreCad = document.getElementById('sobrenoCad').value;
        var cpf = document.getElementById('cpfCad').value;
        var ddd = document.getElementById('dddCad').value;
        var telefone = document.getElementById('telCad').value;
        var emailCad = document.getElementById('emailCad').value;

        

   
        // consistindo nome 
        if(nomeCad == "" || nomeCad == null) {

        alert("Por favor, indique o seu nome.");
        
        
        return false;

        } 

        // -------------------------------------------------------------------------------

        // consistindo sobrenome

         if(sobreCad == "" || sobreCad == null) {

        alert("Por favor, seu sobrenome completo.");
        //Foi definido um focus no campo.
        
        return false;

        }
        //------------------------------------------------------------------------------------

        //consistindo ddd

        if(ddd == "" || ddd == null) {

        alert("Por favor, indique o um ddd válido!");
        
        
        return false;

        } 

         //------------------------------------------------------------------------------------

        //consistindo telefone

        if(telefone == "" || telefone == null) {

        alert("Por favor, indique o um telefone válido!");
        
        
        return false;

        } else if (telefone.length < 8) {

            alert("Por favor, verifique novamente seu telefone. Número de dígitos abaixo do mínimo!");
        }

           
        //------------------------------------------------------------------------------------

        //consistindo CPF

        
         if (validaCPF(cpf) == true ) {document.getElementById('erro-cpf').innerHTML = "Legal é isso aí! cpf OK.";}

                
        //-----------------------------------------------------------------------------------------

        if(emailCad == "" || emailCad == null) {

            alert("Por favor, campo e-mail não pode ficar vazio.");  

            return false; 

            } else if (emailCad.indexOf('@') == -1 || emailCad.indexOf('.') == -1) {
            alert("Por favor, verifique se e-mail foi escrito da forma correta");           
            return false;
        
            } else {document.getElementById('erro-senha1Cad').innerHTML = "Legal é isso aí! Senhas OK";} 

        } //-------------------------------------------------------------------------------------------

        //=========================================================================

  // FUNÇÃO PARA VALIDAÇÃO GERAL DO FORMULÁRIO DA PÁGINA DADOS PESSOAIS


    function vali()
    {
        var login = document.getElementById('loginCad').value;
        var senha = document.getElementById('senhaCad').value;
        var senha2 = document.getElementById('senhaCad2').value;
        

          // consistindo senhas

        if(senha == "" || senha == null) {

            alert("Por favor, verifique se a preencheu o campo está vazio e tente novamente.");           
            return false;

        } else if (senha.length < 5) {
            alert("Por favor, verifique se sua senha tem 6 ou mais dígitos e tente novamente.");           
            return false;
        
        } else if (senha != senha2) 
        {
             alert("Por favor, verifique se suas senhas estão iguais e tente novamente.");           
            return false;

        } else {document.getElementById('erro-senha1Cad').innerHTML = "Legal é isso aí! Senhas OK";
         alert("Preencimento conluído com sucesso!"); 

        // fim do valida Login ------------------------------------------------------------------------------

   }
     
     }  

    //=========================================================================

    // fim da função de validação dos campos!!
