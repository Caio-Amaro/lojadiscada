
                <!-- Page content-->
                <div class="container-fluid">
                    <h1 class="mt-4">Relatório de Vendas</h1>
                        <nav id="menuVendas">
                            <ul>
                                <li><a style="text-decoration: none; color:black" href="/loja/relatorioVendasGeral">| Venda Geral | </a></li>
                                <li><a style="text-decoration: none; color:black;" href="/loja/relatorioVendaData">| Vendas Por Data | </a></li>
                                <li><a style="text-decoration: none; color:black;" href="/loja/relatorioVendaProduto">| Vendas por Produto | </a></li>
                                <li><a style="text-decoration: none; color:black;" href="/loja/relatorioVendaCategoria">| Vendas Por Categoria | </a></li>                                
                            </ul>
                        </nav>

                        <form class="form-inline">
                            <div class="container-fluid">
                              <div class="col-6">
                                <input type="search" id="form1" class="form-control" placeholder="Nome ou Id do Produto" />
                                <button type="button" class="btn btn-primary" style="margin-top: 1EM;">
                                <i class="bi bi-box-seam"> AVANÇAR NA PESQUISA</i>
                              </button>
                              </div>
                              
                            </div>
                        </form>
                        <h5 style="margin-top:2em;"> Saldo por Produto: </h5> <p> R$ 2.100,00 </p>
                 <hr>

                </div>
               

                <div class="">
                    <table class="table">
                        <thead  class="thead-dark">
                            <tr>
                              <th scope="col">Pedido #ID</th>
                              <th scope="col">Nome</th>
                              <th scope="col">Produto</th>
                              <th scope="col">Valor R$</th>
                              <th scope="col">Data</th>
                              <th scope="col">Pagamento</th>
                              <th scope="col"></th>

                            </tr>
                        </thead>
                    

                        <tbody>
                            <tr>
                                <th scope="row">17762</th>
                                  <td>Carlos Albuquerque</td>
                                  <td>Guitarra Fender</td>
                                  <td>3.990,00</td>
                                  <td>04/09/2021</td>
                                  <td>Cartão</td>
                                  <td><button type="button" class="btn btn-danger btn-sm">Excluir</button></td>
                            </tr>
                            
                        </tbody>
                    </table>
                </div>
 </body>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="../../js/scripts.js"></script>

</html>
