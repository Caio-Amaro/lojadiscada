<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
   
<!-- Page content-->

<h4 style="text-align: center;" class="mt-4">PESQUISA ANUAL DE MOVIMENTAÇÃO</h4>

<div class="container-fluid">
    <hr>
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            <label>ANÁLISE GERAL DE TODOS OS PTODUTOS POR INTERVALO DE DATA</label>
            
            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasMes" method="POST">
                <div class="row">
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                    </div>
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                    </div>

                    <div style="margin-top: .5em;">
                        <input id="defe" type="hidden" value="defe" name="defe" >
                        <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-6" style="margin-top: .5em; margin-bottom: 1em;">
            <label>ESCOLHA DOIS PRODUTOS PARA COMPARAÇÃO DE DESEMPENHO</label>
            
            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasMes" method="POST">
                
                <div class="row">
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                    </div>
                    <div class="col-4">
                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                    </div>

                    <div style="margin-top: .5em;">
                        <input id="defe" type="hidden" value="defe" name="defe" >
                        <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                    </div>
                </div>
            </form>
        </div>
</div>
        <hr>
        <hr>  <%-- transform: rotateX(180deg); --%>

</body>

