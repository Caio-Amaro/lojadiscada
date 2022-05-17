<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
   
<!-- Page content-->
<body>
    <h4 id="sloganUm" style="text-align: center;" class="mt-4">RELATÓRIOS DE MOVIMENTAÇÃO DE VENDAS</h4>

        <div class="container-fluid">
        <hr>
            <div class="row" style="margin-left: 1em;">
                
                <div class="col-12 col-md-6">                        
                    <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                        <div class="card-body">
                            <label id="sloganUm">ANÁLISE DE DOIS PRODUTOS POR DATA E QUANTIDADE</label>
                            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasBean" method="POST">                
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                </div>    
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Produto 1</label>
                                        <select name="produt1" class="form-select" aria-label="Default select example">                                    
                                            <c:forEach var="prd" items="${produtoscom}"> 
                                                <option value="${prd.proid}">${prd.pronome}</option>                    
                                            </c:forEach>                    
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Produto 2</label>
                                        <select name="produt2" class="form-select" aria-label="Default select example">                                    
                                            <c:forEach var="prd" items="${produtoscom}"> 
                                                <option value="${prd.proid}">${prd.pronome}</option>                    
                                            </c:forEach>                    
                                        </select>
                                    </div>
                                </div> 
                                <div style="margin-top: .5em;">
                                    <input id="defe" type="hidden" value="defe" name="defe" >
                                    <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                                </div>                                
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-12 col-md-6">                        
                    <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                        <div class="card-body">
                            <label id="sloganUm">ANÁLISE DE DOIS PRODUTOS POR DATA E VALOR</label>
                            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasBeanValor" method="POST">                
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Final</label>
                                        <input id="campoPesquisa" type="text" name="datafinal" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                </div>    
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Produto 1</label>
                                        <select name="produt1" class="form-select" aria-label="Default select example">                                    
                                            <c:forEach var="prd" items="${produtoscom}"> 
                                                <option value="${prd.proid}">${prd.pronome}</option>                    
                                            </c:forEach>                    
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Produto 2</label>
                                        <select name="produt2" class="form-select" aria-label="Default select example">                                    
                                            <c:forEach var="prd" items="${produtoscom}"> 
                                                <option value="${prd.proid}">${prd.pronome}</option>                    
                                            </c:forEach>                    
                                        </select>
                                    </div>
                                </div> 
                                <div style="margin-top: .5em;">
                                    <input id="defe" type="hidden" value="defe" name="defe" >
                                    <button style="margin-top:.5em; margin-left: .1em; width: 50%; height: auto;" type="submit" class="btn btn-outline-dark my-1">AVANÇAR NA PESQUISA</button>
                                </div>                                
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
                                
        <div class="container-fluid">
        <hr>
            <div class="row" style="margin-left: 1em;">
                <div class="col-12 col-md-6">                        
                    <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                        <div class="card-body">
                            <label id="sloganUm">TODOS OS PRODUTOS POR INTERVALO DE DATA E QUANTIDADE</label>
                            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasMes" method="POST">
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                    <div class="col-6">
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
                </div>

                <div class="col-12 col-md-6">                        
                    <div class="card" style="width: 100%; text-align: center;" id="blockProductDois">
                        <div class="card-body">
                            <label id="sloganUm">TODOS OS PRODUTOS POR INTERVALO DE DATA E VALOR</label>
                            <form class="form-inline"  action="${pageContext.request.contextPath}/pesquisaVendasMesValor" method="POST">
                                <div class="row">
                                    <div class="col-6">
                                        <label id="sloganUm" style="margin-top: 2em;">Data Inicial</label>
                                        <input id="campoPesquisa" type="text" name="datainicial" class="form-control" placeholder="dia/mês/ano">
                                    </div>
                                    <div class="col-6">
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
                </div>
            </div>
        </div>
        <p style="margin-bottom: 10em; text-align: center;"></p>

</body>

