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
                    //type: "get",
                    success: function(response) {
                        
                        alert(response);
                        var data_arr = [
                            ['nome', 'valor'],                            
                        ];
                        
                        $.each(response, function(i, value){
                            data_arr.push([value.nome, value.valor]);
                        })
                        
                        var options = {
                            title: 'Gráfico de Vendas - 6 MESES DE ANÁLISE'
                          };

                        var figure = google.visualization.arrayToDataTable(data_arr);
                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                        chart.draw(figure, options);                       
                    }
                    
                });} 
               
        </script>
    </head>
    <body>
        <table class="columns">
            <tr>                
                <div id="piechart" style="width: 900px; height: 500px;"></div>
            </tr>            
        </table>
        <div class="col-4" style="margin-left: 6em;">
            <a href="${pageContext.request.contextPath}/AnaliseChart"><button type="button" class="btn btn1 btn-primary btn-lg">GERAR GRÁFICO</button></a>
        </div>    
    </body>
</html>
