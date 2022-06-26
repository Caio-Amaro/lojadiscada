<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <body>       
        <div class="col-12 col-md-12">                        
            <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                <div class="card-body">
                    <label id="sloganUm">TODOS OS PRODUTOS POR INTERVALO DE DATA E VALOR - MSG : ${datateste}</label>
                    <form class="form-inline" id="formuser"  action="${pageContext.request.contextPath}/AnaliseChart" method="post">
                        <div class="row">
                            <div class="col-6">
                                <label class="sr-only" for="dataInicial" id="sloganUm">Data Inicial</label>
                                <input id="dataInicial" type="text" name="dataInicial" class="form-control" placeholder="dia/mês/ano">
                            </div>
                            <div class="col-6">
                                <label class="sr-only" for="dataInicial" id="sloganUm">Data Final</label>
                                <input id="dataFinal" type="text" name="dataFinal" class="form-control" placeholder="dia/mês/ano">
                            </div>

                            <div style="margin-top: .5em;">                                
                                <button onclick="" id="btSalvar" type="submit" value="Salvar">Gerar Grafico</button>
                                
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
        
        <div class="col-12 col-md-12">                        
            <div class="card" style="width: 100%; text-align: center; margin-top: 2em;" id="blockProductDois">
                <div class="card-body">
                    <label id="sloganUm">Gráfico</label>                    
                    <div>
                        <canvas id="myChart"></canvas> 
                    </div>                    
                </div>
            </div>
         </div>
    
        
    </body>
    
    <%-- <jsp:include page="scripts.js"></jsp:include> --%>
    <script>
        function myFunctio(){
     
                
        var urlAction = document.getElementById('formuser').action;
        var dataInicial = document.getElementById('dataInicial').value;
        var dataFinal = document.getElementById('dataFinal').value;
      
        $.ajax({
            
            method: "get",
            url: urlAction,
            data: 'dataInicial=' + dataInicial + '&dataFinal=' + dataFinal + '&acao=Teste',  
            dataType: 'html',
            success: function(response) {
                alert(response);
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
        
    </script>
    
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
<%--<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>--%>
<script src="js/script.js"></script>
 