<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>LOJA SOUNDEVO - Instrumentos Musicais</title>
         <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
        
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
    </head>    

        <!-- Navigation-->
    
    <header>
        <nav  class="navbar navbar-expand-lg navbar-light bg-white">
        
            <div class="container col-md-9">
                
                <a class="navbar-brand" href="/loja/Painel"><p style="font-size: 38px; margin-bottom: -0.3em; margin-left: 10em;">SoundEVO </p><p style="font-size: 15px; margin-left: 25.4em;"> A música evolui com você</p></a>    
              
            </div>
        </nav>
        <hr>

    </header>
        

    <!-- Body and Section-->
<body>
  <div class="container" style="width:50%; height: auto;">    
   <section class="py-2 bg-light">

    <div style="text-align: center; margin-top: -1em; padding:.2em;" class="bg-primary text-white">
        <h5> GERENCIADOR ADMINISTRATIVO - PAINEL DE ACESSO </h5>
    </div>

    <form action="${pageContext.request.contextPath}/loginAdm" method="POST">
        <div class="form-group" style="width: 50%;" >
            <label>Login</label>
            <input type="text" name="login" class="form-control" required>
        </div>


        <div class="form-group" style="width: 50%;">
            <label>Senha</label>
            <input type="password" name="senha" class="form-control" required style="margin-bottom: 1em;">                                    
        </div>
        
        <button type="submit" class="btn btn-primary">Entrar</button>
    </form>
        <p>${msgadmerro}</p>
        <p>${testelog}</p>
  </section>
 </div>
</body>
    
