<%-- 
    Document   : chart
    Created on : 25/06/2022, 09:02:41
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Gráfico Google Chart Com JSP-Servlet </title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"> </script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            //$(document).ready(function(){
            google.charts.load('current', {'packages':['corechart']});
            google.charts.setOnLoadCallback(drawChart);
            
            function drawChart(){
                 
                $.ajax({
            
                    url: "ChartServ",
                    dataType: "JSON",
                    type: "get",
                    success: function(data) {
                        var data_arr = [
                            ['nome', 'valor'],                            
                        ];
                        
                        $.each(data, function(i, value){
                            data_arr.push([value.nome, (value.valor)]);
                        })
                        
                        var options = {
                            title: 'My Daily Activities'
                          };

                        var figure = google.visualization.arrayToDataTable(data_arr);
                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                        chart.draw(figure, options);                       
                    }
                    
                });} 
               
        </script>
    </head>
    <body>
        
            <div class="col-12 col-md-12">                        
            <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                <div class="card-body">
                    <label id="sloganUm">TODOS OS PRODUTOS POR INTERVALO DE DATA E VALOR - MSG : ${datateste}</label>
                    <form class="form-inline" id="formuser"  action="${pageContext.request.contextPath}/ChartServ" method="post">
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
        <table class="columns">
            <tr>
                <div id="piechart" style="width: 900px; height: 500px;"></div>
            </tr>
        </table>
    </body>
</html>
