<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teste Gráfico Google Chart Com JSP-Servlet </title>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"> </script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/script.js"></script>


    
    <%-- <jsp:include page="scripts.js"></jsp:include> --%>
    <script>
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);
            
            function drawChart(){
                 
                $.ajax({
            
                    url: "AnaliseChart",
                    dataType: "JSON",
                    //type: "get",
                    success: function(response) {
                        
                        alert(response);
                        var data_arr = [
                            ['nome', 'valor'],                            
                        ];
                        
                        $.each(response, function(i, value){
                            data_arr.push(["produto" + i, (value.valor)]);
                        })
                        
                        var options = {
                            title: 'My Daily Activities'
                          };

                        var figure = google.visualization.arrayToDataTable(data_arr);
                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                        chart.draw(figure, options);                       
                    }
                    
                });} 
               
// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   </script>
   

    <body>       
        <div class="col-12 col-md-12">                        
            <div class="card" style="width: 50%; text-align: center; margin-left: 25%;" id="blockProductDois">
                <div class="card-body">
                    <label id="sloganUm">TODOS OS PRODUTOS POR INTERVALO DE DATA E VALOR - MSG : ${datateste}</label>
                    <form class="form-inline" id="formuser"  action="${pageContext.request.contextPath}/AnaliseChart" method="post">
                        <div class="row">
                            <div class="col-6">
                                <label class="sr-only" for="dataInicial" id="sloganUm">Data Inicial</label>
                                <input value="${dataInicial}" id="dataInicial" type="text" name="dataInicial" class="form-control" placeholder="dia/mês/ano">
                            </div>
                            <div class="col-6">
                                <label class="sr-only" for="dataFinal" id="sloganUm">Data Final</label>
                                <input value="${dataFinal}" id="dataFinal" type="text" name="dataFinal" class="form-control" placeholder="dia/mês/ano">
                            </div>

                            <div style="margin-top: .5em;">                                
                                <button onclick="drawChart()" type="submit">Gerar Grafico</button>                                
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
        
 </body>
    
 