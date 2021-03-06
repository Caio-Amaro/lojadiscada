
package br.com.discada.controller;

import br.com.discada.model.DAO.CartaocrediDao;
import br.com.discada.model.DAO.CategoriaDao;
import br.com.discada.model.DAO.ClienteDao;
import br.com.discada.model.DAO.CupomDao;
import br.com.discada.model.DAO.EnderecoDao;
import br.com.discada.model.DAO.ItemPedidoDao;
import br.com.discada.model.DAO.PedidoDao;
import br.com.discada.model.DAO.ProdutoDao;
import br.com.discada.model.DAO.SegredoDao;
import br.com.discada.model.jpa.Cartaocredi;
import br.com.discada.model.jpa.Clientes;
import br.com.discada.model.jpa.Cupom;
import br.com.discada.model.jpa.Endereco;
import br.com.discada.model.jpa.GraficoProdutos;
import br.com.discada.model.jpa.Itempedido;
import br.com.discada.model.jpa.Pedido;
import br.com.discada.model.jpa.Produto;
import br.com.discada.model.jpa.Segredo;
import br.com.discada.model.jpa.Statuspostagem;
import br.com.discada.model.jpa.Tipostatus;
import br.com.discada.services.GerarGraficoMontado;
import br.com.discada.services.ShoppingCart;
import br.com.discada.services.ShoppingCartItem;
import br.com.discada.services.controleCupom;
import br.com.discada.services.servicoValida;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.google.gson.Gson;
import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(name = "ControleServlet",
        loadOnStartup = 1, 
        urlPatterns = {"/update", "/enviarPedido", "/paginaCompraLista", "/excluirEndereco", "/cupomTroca", "/AnaliseChart",
            "/paginaFinaliza", "/addCart", "/addItem", "/paginaFormaPagamento", "/paginaProduto", "/paginaFinalizaDois",
            "/addAcesso", "/deslogar", "/paginaLogin", "/paginaHistoricopedido", "/editarEndereco", "/paginaAgradecimento",
            "/paginaEndereco", "/paginaDadosPessoais", "/cadastroCartao", "/paginaCupom", "/paginaDadosPessoaisSenha",
            "/paginaCartoes", "/gerenciaCliente", "/excluirCartao", "/cadastroP2", "/consultaProduto", "/detalheItemPedido",
            "/cadastroP1", "/detalhePedido", "/consultaCategoria", "/paginaHistoricoNome", "/chart"})

public class ControleServlet extends HttpServlet {
    
      
     @EJB
    private EnderecoDao endDao;

    @EJB
    private ProdutoDao prodDao;
    
    @EJB
    private ClienteDao clieDao;
    
    @EJB
    private SegredoDao segDao;
    
    @EJB
    private CartaocrediDao creDao;
    
    @EJB
    private PedidoDao pDao;
    
    @EJB
    private ItemPedidoDao itDao;
    
    @EJB
    private CupomDao cupDao;
    
    @EJB
    private CategoriaDao catDao;
    
    @EJB
    private ItemPedidoDao itemDao;
    
    
  
    
    @Override
    public void init () throws ServletException{
        
        // Listagem dos produtos no "Servlet Context" - Inicializando a vitrine
        getServletContext().setAttribute("produtos", prodDao.getListaObjetos());
    }

    
// ------------------------------------------------------------------------------------
// INICIO DO M??TODO GET
// ------------------------------------------------------------------------------------
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();        
        String userPath = request.getServletPath();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        Produto selecioneprod;
        Collection<Produto> selecioneProduto;
        
// ------------------------------------------------------------------------------------
// END POINTS M??TODO GET
// ------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------
            if (userPath.equals("/Discada")) {
            
        } 

// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos endere??os do cliente
            
            else if (userPath.equals("/paginaEndereco")){
                
                String idCliente = request.getParameter("idcl"); //pegando id do cliente para listar seu(s) endere??o(s)
            
                if(idCliente != null && !idCliente.equals("")){
                    List<Endereco> endereco;
                    endereco = (List<Endereco>) endDao.listarEndereco(Integer.parseInt(idCliente));
                    session.setAttribute("endereco", endereco);
                    session.getAttribute("endereco");
            
            }
            
            
            
            }

// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos cart??es cadastros ??pelo cliente
            
            else if (userPath.equals("/deslogar")) {   
                
                session.invalidate();
                userPath = "/cadastroP2";
            }
//-------------------------------------------------------------------------------------
       
        
// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos cart??es cadastros ??pelo cliente
            
            else if (userPath.equals("/paginaCartoes")){
                
                //session.getAttribute("cred");

                String cre = request.getParameter("idc");

                Cartaocredi cr = new Cartaocredi();
                List<Cartaocredi> cred;
                cred = (List<Cartaocredi>) creDao.ListarCartao(Integer.parseInt(cre));

                session.setAttribute("credito", cred);
                session.getAttribute("credito");
             
            }
  
// ------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
         
        else if (userPath.equals("/paginaProduto")) {
            
            
            String produtoidStr = request.getQueryString();
            if (produtoidStr != null && !produtoidStr.equals("")) {
                try {
                    Produto selecioneProd = (Produto) prodDao.getObjectById(Integer.parseInt(produtoidStr));
                    session.setAttribute("selecioneProd", selecioneProd);
                } catch (Exception e) {
                }

            }
            
        }
        
// --------------------------------------------------------------------------------------            
// end point para gerar a listagem dos endere??os do cliente            
            
            else if (userPath.equals("/editarEndereco")){
             
                String idEndStr = request.getParameter("idclieSt");
                
                if (idEndStr != null && !idEndStr.equals(" ")) {    
                    try {
                        Endereco selecioneEn = (Endereco) endDao.getObjectById(Integer.parseInt(idEndStr));
                        request.setAttribute("selecioneCliEnd", selecioneEn);
                    } catch (Exception ex) {
                            Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

// ------------------------------------------------------------------------------------
// end point para gerar os dados de login e senha na p??gina de altera????o de dados 
          
        else if (userPath.equals("/paginaDadosPessoais")) {
           
            String idsegr = request.getParameter("idsegr");
           
            if(idsegr!=null &&  !idsegr.equals("")){
               
                try {
                    Segredo segone = (Segredo) segDao.getObjectById(Integer.parseInt(idsegr));
                    request.setAttribute("trocaseg", segone);
                    request.getAttribute("trocaseg");
                }   catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
           }
        }           




// ------------------------------------------------------------------------------------
// Gera as listagens de endere??o, cart??o de cr??dito e cupons na p??gina de finaliza????o da compra
          
        else if (userPath.equals("/paginaFinaliza")) {
           
             
            String client = request.getParameter("client");
            
            
            List<Endereco> end;
            end = (List<Endereco>) endDao.listarEnderecoPorIdCliente(Integer.parseInt(client));
            session.setAttribute("end", end);
            session.getAttribute("end");
            
            
            List<Cartaocredi> cred;
            cred = (List<Cartaocredi>) creDao.listarCartaoPorIdCliente(Integer.parseInt(client));
            session.setAttribute("cred", cred);
            session.getAttribute("cred");
            
            List<Cupom> cup;
            cup = (List<Cupom>)cupDao.ListarCupom(Integer.parseInt(client));
            session.setAttribute("cupo", cup);
            session.getAttribute("cupo");
            
        }           


            //---------------------------------------------------------------------------------------------------------
        
        else if(userPath.equals("/paginaCupom")){
            
            String idcl = request.getParameter("idcl");
            List<Cupom> cup;
            cup = (List<Cupom>)cupDao.ListarCupom(Integer.parseInt(idcl));
            session.setAttribute("cupo", cup);
            session.getAttribute("cupo");        
        }
//---------------------------------------------------------------------------------------------------------
        
        
        
        else if(userPath.equals("/paginaHistoricoPedido"))
        {    
           
            String idcl = request.getParameter("idcl");
            List<Pedido> pedid;
            pedid = (List<Pedido>)pDao.ListarPedido(Integer.parseInt(idcl));
            session.setAttribute("pedid", pedid);
            session.getAttribute("pedid");          
               
          
        }
//---------------------------------------------------------------------------------------------------------
          /*else if(userPath.equals("/detalhePedido"))
         {
         
            String idpe = request.getParameter("idpedi");
            List<Itempedido> en;
            en = (List<Itempedido>) itDao.listarItemPedido(Integer.parseInt(idpe));
            request.setAttribute("item", en);
            request.getAttribute("item"); 
         
         }*/
         
//---------------------------------------------------------------------------------------------------------
        
         else if (userPath.equals("/detalheItemPedido")){
            
            String iditem = request.getParameter("idpediit");
            
            if(iditem != null && !iditem.equals(" ")){
                
                int idt = Integer.parseInt(iditem);
            
                try {
                    Itempedido it = (Itempedido) itDao.getObjectById(idt);
                    request.setAttribute("iditem", it);
                            
                            } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
           
        }
         
// ------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------

            
        String url = "/WEB-INF/views" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                    
         

    }

// ==========================================================================================
// FIM DOS CONTROLES DO M??TODO GET
// ==========================================================================================
    
    
// ----------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------
// INICIO DO M??TODO POST
// ----------------------------------------------------------------------------------------------    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
          
          
          if(userPath.equals("/Discada")) {}
          
// ----------------------------------------------------------------------------------------------
// end point para realizar a busca do login e senha do cliente 
          
        else if (userPath.equals("/paginaDadosPessoaisSenha")) {
            
            // recebendo dados do formul??rio
            String log = request.getParameter("login");
            String pas = request.getParameter("senha");
            String pasone = request.getParameter("senhaone");
            String idseg = request.getParameter("idsegr");
            
            // Valida existe dos dados e solicita altera????o no banco
            if (pas != null && !pas.equals(" ") && pasone != null && !pasone.equals(" ") && idseg != null && idseg.equals(" ")) {
            
                if(pas.equals(pasone)){
                
                    Segredo seg = new Segredo();
                    
                    int segid = Integer.parseInt(idseg);
                    seg.setSecid(segid);
                    seg.setSeclogin(log);
                    seg.setSecsenha(pas);
            
                    try {
                        segDao.merge(seg);
                        userPath="/paginaDadosPessoais";
                        request.setAttribute("msgseg", "senha alterada com sucesso!");
                   
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                }   else {
                            request.setAttribute("msgseg", "Senha n??o conferem! Tente Novamente");
                            userPath="/paginaDadosPessoais";
                    }
           
            }   else { 
                        userPath="/paginaDadosPessoais";
                        request.setAttribute("msgseg", "Algo saiu erro, verifique os dados e tente novamente!");
                }        
        }           



          
// ----------------------------------------------------------------------------------------------

// ----------------------------------------------------------------------------------------------
// end point para o inicio do cadastro do cliente 
          
          else if (userPath.equals("/paginaEndereco")) {
            
                String nomeDes = request.getParameter("nome");
                String cep = request.getParameter("cep");
                String logra = request.getParameter("logra");
                String complem = request.getParameter("comp");
                String casa = request.getParameter("num");
                String cidade = request.getParameter("cidade");
                String bairro = request.getParameter("bairro");
                String estado = request.getParameter("estado");                
                String idCliente = request.getParameter("idcli"); //idclientes
            
            if (idCliente != null && !idCliente.equals(" ")) {
            
                Endereco endereco = new Endereco();
                //session.setAttribute("selecioneCliEnd", endereco);
                //session.getAttribute("selecioneCliEnd");
            
                Clientes cliente = new Clientes();
                cliente.setCliid (Integer.parseInt(idCliente));
                
                
              
                endereco.setEndnomedestino(nomeDes);
                endereco.setEndcep(cep); 
                endereco.setEndlogradouro(logra);
                endereco.setEndcomplemento(complem);
                endereco.setEndnumero(casa);//(num);
                endereco.setEndcidade(cidade);
                endereco.setEndbairro(bairro);
                endereco.setEndestado(estado);
                endereco.setEndidcliente(cliente);
          
            try { 
                endDao.persist(endereco);
                List<Endereco> ende;
                ende = (List<Endereco>) endDao.listarEndereco(Integer.parseInt(idCliente));
                session.setAttribute("endereco", ende);
                session.getAttribute("endereco");
                
            } catch (Exception ex) {
                Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
              
              
          }
          
// ----------------------------------------------------------------------------------------------
// end point para validar a senha e login do cliente 
          
        else if (userPath.equals("/paginaLogin")) {
        // ATEN????O, N??o esquecer de levar essa regra de neg??cio para um pacote de servi??os

            String log = request.getParameter("login");
            String sen = request.getParameter("senha");
            String idsegredo = request.getParameter("idsegredo"); 

        
            List<Segredo> segr; 
            segr = (List<Segredo>) segDao.buscaUsuario(log, sen);
            
            for ( Segredo vam : segr ){
                if(vam != null && vam.getSecsenha().equals(sen) && vam.getSeclogin().equals(log))
                {
                
                    int idse = vam.getSecid();
                    int idclit;
                    segDao.setAcesso(true);

                    List<Clientes> c; 
                    c = (List<Clientes>) clieDao.pegarClienteSegredo(idse);

                        if(c != null && !c.isEmpty() && !c.equals("")) {

                        for (Clientes vem : c){

                        idclit = vem.getCliid();
                         try {
                        Clientes cli = (Clientes) clieDao.getObjectById(idclit); 
                        session.setAttribute("cliente", cli);
                        session.getAttribute("cliente");
                        } catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }


                        }

                    Segredo seg = new Segredo();                
                    request.getSession().setAttribute("usuario", seg);
                    session.setAttribute("se", seg);
                    session.getAttribute("cliente");                
                    request.setAttribute("msgbem", "Bem vindo!");
                    userPath = "/gerenciaCliente";


                    }

                } else  
                        {
                            userPath = "/cadastroP2";
                            request.setAttribute("msg", "Informe login e senha corretamente");
                        }
            }                   
                if (segDao.isAcesso() == false) {request.setAttribute("errologin", "o login e ou a senha n??o conferem. "
                    + "Certifique-se dos dados e tente novamente");
                    userPath = "/cadastroP2";
                }
                             
        }

// ------------------------------------------------------------------------------------
// end point para cadastrar um cart??o de cr??dito pelo cliente
            
            else if (userPath.equals("/cadastroCartao")){
                
                String num = request.getParameter("num");
                String idCli = request.getParameter("idcli");

                if (num != null && !num.equals(" ")) {
                    String nome = request.getParameter("nome");
                    String cvv = request.getParameter("cvv");
                    String datavali = request.getParameter("data");
                    String bandeira = request.getParameter("bandeira");

                    Cartaocredi credi = new Cartaocredi();
                    Clientes cliente = new Clientes();

                    credi.setCrenumero(num);
                    credi.setCrenome(nome);
                    credi.setCrecvv(Integer.parseInt(cvv));
                    credi.setCrevalidade(datavali);
                    credi.setCreidcliente(cliente);
                    cliente.setCliid(Integer.parseInt(idCli)); 
                    credi.setBandeira(bandeira);
                    try { 
                        creDao.persist(credi);
                        List<Cartaocredi> cred;
                        cred = (List<Cartaocredi>) creDao.ListarCartao(Integer.parseInt(idCli));
                        userPath = "/paginaCartoes";
                        request.setAttribute("credito", cred);
                        request.getAttribute("credito");

                    } catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);                
                      }
                }            
            }
                
// ----------------------------------------------------------------------------------------------
// end point para o inicio do cadastro do cliente 
          
        else if (userPath.equals("/editarEndereco")) { 
            
            //Clientes cli = new Clientes();  
            //session.getAttribute("cliente");
            
            String idCliente = request.getParameter("idclientes");
            
            if (idCliente != null && !idCliente.equals(" ")) {
                
                // Recebendo dados do formul??rio
                String nomeDes = request.getParameter("nome");
                String cep = request.getParameter("cep");
                String logra = request.getParameter("logra");
                String complem = request.getParameter("comp");
                String numCasa = request.getParameter("num");
                String cidade = request.getParameter("cidade");
                String bairro = request.getParameter("bairro");
                String estado = request.getParameter("estado");                
                String idcliente = request.getParameter("idclientes");
                String idend = request.getParameter("idend");
                
                // Criando objetos das classes associadas ao Crud
                Endereco endereco = new Endereco();
                Clientes cli = new Clientes();
                
                // Transformando o tipo string para int
                int idcli = Integer.parseInt(idcliente); 
                int iden = Integer.parseInt(idend);
                
                // "setando" o id do cliente para poder passar no objeto endere??o
                cli.setCliid (idcli);
                
                // "setando objeto endere??o
                endereco.setEndid(iden);
                endereco.setEndnomedestino(nomeDes);
                endereco.setEndcep(cep); 
                endereco.setEndlogradouro(logra);
                endereco.setEndcomplemento(complem);
                endereco.setEndnumero(numCasa);
                endereco.setEndcidade(cidade);
                endereco.setEndbairro(bairro);
                endereco.setEndestado(estado);
                endereco.setEndidcliente(cli); // aqui passamos objeto cliente que j?? est?? setado com o id do formul??rio
                
                try {
                    endDao.merge(endereco); // realizando opera????o no banco (solicita????o)
                    request.setAttribute("msgEditarEnd", "Endere??o editado com sucesso!");
                    Endereco selecioneEn = (Endereco) endDao.getObjectById(iden); // buscando o registro
                    request.setAttribute("selecioneCliEnd", selecioneEn); // criando um objeto na sess??o
                    userPath = "/editarEndereco"; // "setando a path de redirecionamento ap??s a resposta da requisi????o
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("msgEditarEnd", "Problema ao editar endere??o");
                    
                }
            }
        }
          
// ----------------------------------------------------------------------------------------------
// end point para realizar altera????o nos dados cadastrais do cliente 
          
        else if (userPath.equals("/paginaDadosPessoais")) {
        
            String idcl = request.getParameter("idcli");
            String idsegr = request.getParameter("idsegr");
            
            if( idcl != null && !idcl.equals(" ")) {                       
            
                Clientes client = new Clientes();
                try {
                    Clientes cli = (Clientes) clieDao.getObjectById(Integer.parseInt(idcl));
                    session.setAttribute("cliente", cli);
                    userPath = "/paginaDadosPessoais";
                    
                }   catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
                // Recebendo os dados do formulario 
                String nome = request.getParameter("nome");
                String sobrenome = request.getParameter("sobrenome");
                String cpf = request.getParameter("cpf");
                String email = request.getParameter("email");
                String genero = request.getParameter("genero");
                String ddd = request.getParameter("ddd");
                String telefone = request.getParameter("tel");
                                 
                
                // Se n??o for null ou vazio alterar no banco de dados
                if (idcl != null && !idcl.equals("")) {
             
                    Segredo seg = new Segredo();
                    seg.setSecid(Integer.parseInt(idsegr));
                    
                    // povoar o objeto cliente
                    client.setIdsegredo(seg);
                    client.setCliid(Integer.parseInt(idcl));
                    client.setClinome(nome);
                    client.setClisobrenome(sobrenome);
                    client.setClicpf(cpf);
                    client.setCliemail(email);
                    client.setCligenero(genero); 
                    client.setCliddd(ddd);
                    client.setClitelefone(telefone);
                    client.setCliativo(1);
            
                    try {clieDao.merge(client);
                            try {
                                Clientes cli = (Clientes) clieDao.getObjectById(Integer.parseInt(idcl));
                                session.setAttribute("cliente", cli);
                                request.setAttribute("msgEditaCli", "Dados pessoais alterados com sucesso! ");
                                userPath = "/paginaDadosPessoais";
                            } catch (Exception ex) {
                                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              userPath = "/paginaDadosPessoais";
                
                    } catch (Exception ex) {                
                            Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                      } 
                }
            }
        }
// ------------------------------------------------------------------------------------
// end point para realizar a exclus??o de um endere??o no banco de dados 
          
        else if (userPath.equals("/excluirEndereco")) {
        
            String endidStr = request.getParameter("idclieSt"); // ID do endere??o cadastrado
            String idcliente = request.getParameter("idcliente"); // ID do cliente
             
             
            if (endidStr != null && !endidStr.equals("")) {
                try {
                    Endereco selecioneEnd = (Endereco) endDao.getObjectById(Integer.parseInt(endidStr));
                    endDao.remover(selecioneEnd);
                    List<Endereco> en;
                    en = (List<Endereco>) endDao.listarEndereco(Integer.parseInt(idcliente));
                    session.setAttribute("endereco", en);
                    session.getAttribute("endereco");
                    userPath = "/paginaEndereco";
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    userPath = "/paginaEndereco";
                    request.setAttribute("msgEnd", " n??o pode ser "
                            + "exclu??do porque est?? associado a uma compra em sua conta! Obrigado pela compreens??o.");
                    }
            }
        }
// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos endere??os do cliente
            
            else if (userPath.equals("/excluirCartao")){
            
                String idcredito = request.getParameter("idcredito");
                String idCli = request.getParameter("idcli");
             
                if(idcredito != null && !idcredito.equals("")){
                
                    try {
                        Cartaocredi credito = (Cartaocredi) creDao.getObjectById(Integer.parseInt(idcredito));
                        creDao.remover(credito);
                        List<Cartaocredi> cred;
                        cred = (List<Cartaocredi>) creDao.ListarCartao(Integer.parseInt(idCli));
                        userPath = "/paginaCartoes";
                        request.setAttribute("credito", cred);
                        request.getAttribute("credito");
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }                
            }
//---------------------------------------------------------------------------------------------------------
        
         else if(userPath.equals("/cadastroP2")){
            
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            String passwordone = request.getParameter("passwordteste");
            boolean recebe;
            
            // cria objeto para validar senha forte no pacote de servi??os
            servicoValida valida = new servicoValida();
            
            recebe = valida.validaSenha(login, password, passwordone);
            
            if (recebe == true) {
            
                Segredo seg = new Segredo();

                seg.setSeclogin(login);
                seg.setSecsenha(password);

                    try {
                         segDao.persist(seg);
                         session.setAttribute("se", seg);
                         seg = (Segredo) session.getAttribute("se");
                         userPath = "/cadastroP1";
                         request.setAttribute("mensagemValida", valida.getMensagemValida());

                     } catch (Exception ex) {
                         Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                         request.setAttribute("msgErrofinal", "Erro ao cadastrar sua senha");
                     }
            
            } else { request.setAttribute("mensagemValida", valida.getMensagemValida()); }
           
        }
 // ----------------------------------------------------------------------------------------------- 

        else if(userPath.equals("/cadastroP1")){
            
            Segredo seg = new Segredo();
            
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String genero = request.getParameter("genero");
            String ddd = request.getParameter("ddd");
            String telefone = request.getParameter("tel");
            String idsegredo = request.getParameter("idsegredo");
            
           
            
            Clientes client = new Clientes();
           
            
            seg.setSecid(Integer.parseInt(idsegredo));
            
            client.setClinome(nome);
            client.setClisobrenome(sobrenome);
            client.setClicpf(cpf);
            client.setCliemail(email);
            client.setCligenero(genero); 
            client.setCliddd(ddd);
            client.setClitelefone(telefone);
            client.setIdsegredo(seg);
            client.setCliativo(1);
            
           
            try { 
                clieDao.persist(client);
                userPath="/gerenciaCliente";
                 
                
            } catch (Exception ex) {
                Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                userPath="/cadastroP2";
                
            }
            
            //****---------------------------
            // Chamando o cliente da sess??o login
                
                int idclit;
                List<Clientes> c; 
                c = (List<Clientes>) clieDao.pegarClienteSegredo(Integer.parseInt(idsegredo));
                
                if(c != null && !c.isEmpty() && !c.equals(" ")) {
                    
                    for (Clientes vem : c){
                    
                    idclit = vem.getCliid();
                     try {
                    Clientes cli = (Clientes) clieDao.getObjectById(idclit);
                    session.setAttribute("cliente", cli);
                    session.getAttribute("cliente");
                    } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                     
                    }                
                }             
        }

// ----------------------------------------------------------------------------------------------- 

        else if(userPath.equals("/addCart")){
            
             if(cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
           
            }
            
            String produtoid = request.getParameter("produtoId");
            if(!produtoid.isEmpty()){
            
                try {
                    Produto produto = (Produto) prodDao.getObjectById(Integer.parseInt(produtoid));
                    cart.addItem(produto);
                    
                    
                            } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
                userPath = "/paginaProduto";
            
        }
          

// ----------------------------------------------------------------------------------------------- 

        else if(userPath.equals("/addAcesso")){
            
            String clear = request.getParameter("clear");
            if ((clear != null) && clear.equals("true")){
                
                ShoppingCart carta = (ShoppingCart) session.getAttribute("cart");
                carta.clear();
            }
            userPath = "/paginaCompraLista";
        
        }
        
//---------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/paginaCompraLista"))
        {
            
            String qtd = request.getParameter("quantidade");
            String produtoid = request.getParameter("produtoid");
            
            int idpro = Integer.parseInt(produtoid);
            
           
                if (produtoid != null) {
                
                try {
                    Produto produto = (Produto) prodDao.getObjectById(idpro);                    
                    cart.update(produto, qtd);
                    userPath = "/paginaCompraLista";
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                                           
                }
        }

//---------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/cupomTroca"))
        {
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            formatter.setMaximumFractionDigits(2);
            
            String idcliente = request.getParameter("idcl");
            String idendereco = request.getParameter("envio");
            String idpagamento = request.getParameter("cartao");
            String vlrtotal = request.getParameter("vlrtotal");
            String vlrtotalpedido = request.getParameter("vlrtotalpedido");
            String idcupom = request.getParameter("idcupom");
            String vlraplicado = request.getParameter("valoraplicado");
            String enviacupom = request.getParameter("enviacupom");
            
           
            double vltotal = Double.parseDouble(vlrtotalpedido);
            double vltot = Double.parseDouble(vlrtotal);
            double vlapl = Double.parseDouble(vlraplicado);

            if (vltot >= 0) {

                vltot = vltot - vlapl;
                formatter.format(vltot);                
                request.setAttribute("vlrFinalCupom", vltot);
                request.setAttribute("msgpagamento", "Ainda falta R$ " + vltot + " para pagar");
                request.setAttribute("enviacupom", enviacupom);
                request.setAttribute("MSG10", "Voc?? inciou o pagamento, seus cupons foram desativados! Obrigado.");
                
                if (vltot <= 0) {

                    vltot = 0.0;
                    request.setAttribute("vlrFinalCupom", vltot);
                    request.setAttribute("msgpagamento", " parab??ns! Voc?? efetuou o pagamento");
                    request.setAttribute("enviacupom", enviacupom);
                    
                    // Iniciar o processo de incluir pedido ni banco de dados
                    // Invoicando as classes associadas a classe de pedido
                    Pedido pedid = new Pedido();
                    Clientes cl = new Clientes();
                    Endereco en = new Endereco();
                    Tipostatus ti = new Tipostatus();
                    Cartaocredi cr = new Cartaocredi();
                    
                    // data atual
                    Calendar cal = new GregorianCalendar();
                    
                    // -----
                    int idc = Integer.parseInt(idcliente);
                    int idstatus = 1;
                    // injetando o id das classes associadas
                    cl.setCliid(idc);
                    en.setEndid(Integer.parseInt(idendereco));
                    ti.setIdtipostatus(idstatus);
                    cr.setCreid(Integer.parseInt(idpagamento));
                    
                    pedid.setIdcliente(cl);
                    pedid.setIdendereco(en);
                    pedid.setIdtipostatus(ti);
                    pedid.setValortotal(vltotal);
                    pedid.setData(cal.getTime());
                    pedid.setFormapag(1);
                    
                    try {
                    pDao.persist(pedid);
                    //request.setAttribute("msgped", "Pedido Solicitado com Sucesso");                
                    session.getAttribute("pedido");
                    session.setAttribute("pedido", pedid);
                    
                    }   catch (Exception ex) {                        
                            Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }                        
                }

            /*else if (vltot == 0) {
                vltot = 0.0;
                request.setAttribute("vlrFinalCupom", vltot);
                request.setAttribute("msgpagamento", " parab??ns! Voc?? efetuou o pagamento");
                request.setAttribute("enviacupom", enviacupom);
            }

            else {
                vltot = 0.0;
                request.setAttribute("vlrFinalCupom", vltot);
                request.setAttribute("msgpagamento", "Seu pagamento foi maior que valor devido, ajustamos o seu pagamento");
                request.setAttribute("enviacupom", enviacupom);

            }*/
            
            
            userPath = "/paginaFinaliza";
            
            }
        }  
//---------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/paginaFinaliza")){
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            formatter.setMaximumFractionDigits(2);
            // Recebendo os dados do formul??rio cupom de troca, desconto e o id do cliente
            String valorcup[];
            valorcup = request.getParameterValues("valorescup"); // array com os valor dos cupons de troca
            String cuponsid[] = request.getParameterValues("idcupomtroca"); // array com os id??s dos cupons de troca
            
            String idcliente = request.getParameter("idcl");
            
            String cupondesid = request.getParameter("cupdescontoid"); // id do cupom de desconto
            String valordesconto = request.getParameter("valordocupom"); // valor do cupom de desconto
            
            String enviacupom = request.getParameter("enviacupom"); // controle para cionar a pausa nos cupons
            
            // Recebendo valor da compra
            String valorcompra = request.getParameter("valorcompra");
            
            String idendereco = request.getParameter("envio");
            String idpagamento = request.getParameter("cartao");            
            String vlrtotalpedido = request.getParameter("vlrtotalpedido");
            
            double vltotal = Double.parseDouble(vlrtotalpedido);
            
            if (enviacupom != null || !enviacupom.equals(" ")){
            
            //Chamando o m??todo para somar os valores dos cupons de troca
            double somaTroca = 0;
            controleCupom cuptoca = new controleCupom();
             
                if (cuponsid != null) {

                    request.setAttribute("soma", somaTroca); // armazena o valor somado                
                   
                    if(cuponsid != null){
                        int idcupy = 0;
                        
                        for(String cupt : cuponsid){
                            idcupy = Integer.parseInt(cupt);
                            try {
                                Cupom cul = (Cupom) cupDao.getObjectById(idcupy);
                                double aux = cul.getValorcupom();
                                somaTroca = aux + somaTroca; 
                                
                                cupDao.remover(cul);
                            }   catch (Exception ex) {
                                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                                }
                        }
                    
                    }
                    
                    request.setAttribute("soma", somaTroca);
                }
            
               
                // Calcular o valor do d??bito com uso dos cupons
                double vlrcompra = 0;
                double vlrdesconto = 0;

                if (valorcompra != null){ // consistindo compra total
                    vlrcompra = Double.parseDouble(valorcompra);
                } 

                if (valordesconto != null) { // consiste para valor do desconto 
                     vlrdesconto = Double.parseDouble(valordesconto);
                     try {
                        Cupom cupomde = (Cupom) cupDao.getObjectById(Integer.parseInt(cupondesid));                        
                        cupDao.remover(cupomde);
                    }   catch (Exception ex) {
                            Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                
                // somaTroca s??o os cupons de troca somados
                // vlrdesconto ?? o valor do desconto aplicado
                // vlrcompra ?? o valor da compra. Total do pedido realizado
                double vlrFinalCupom = cuptoca.valorTotalCupom(somaTroca, vlrdesconto, vlrcompra);
                
                // Gerar um novo cupom caso
                formatter.format(vlrFinalCupom);
                request.setAttribute("vlrFinalCupom", vlrFinalCupom);
                
                if (vlrFinalCupom < 0) {
                
                    Clientes cl = new Clientes();
                    Cupom cup = new Cupom();
                    int idclien = Integer.parseInt(idcliente);
                    cl.setCliid(idclien);
                    
                    double novovalorcupom = ((vlrFinalCupom < 0) ? -vlrFinalCupom : vlrFinalCupom);
                    
                    String nomeCupom = "DIF_Troca : " + idclien;
                    
                    
                    
                    formatter.format(vlrcompra);
                    formatter.format(novovalorcupom);
                    
                    cup.setIdclientecup(cl);
                    cup.setIdtipo(1);
                    cup.setNomecupom(nomeCupom);
                    cup.setValorcupom(novovalorcupom);
                    
                    request.setAttribute("vlrFinalCupom", 0);
                    request.setAttribute("msgpagamento", "O valor do seu cupom foi maior que a compra. "
                            + "Geramos um novo cupom da diferen??a. Pagamento efetuado com sucesso!");
                    
                    try {
                        cupDao.persist(cup);
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    Pedido pedid = new Pedido();
                    Clientes cli = new Clientes();
                    Endereco en = new Endereco();
                    Tipostatus ti = new Tipostatus();
                    //Cartaocredi cr = new Cartaocredi();
                    
                    // data atual
                    Calendar cal = new GregorianCalendar();
                    
                    // -----
                    int idc = Integer.parseInt(idcliente);
                    int idstatus = 1;
                    // injetando o id das classes associadas
                    cli.setCliid(idc);
                    en.setEndid(Integer.parseInt(idendereco));
                    ti.setIdtipostatus(idstatus);
                    //cr.setCreid(Integer.parseInt(idpagamento));
                   
                    
                    pedid.setIdcliente(cli);
                    pedid.setIdendereco(en);
                    pedid.setIdtipostatus(ti);
                    pedid.setValortotal(vltotal);
                    pedid.setData(cal.getTime());
                    pedid.setFormapag(2);
                    
                    try {
                    pDao.persist(pedid);
                    //request.setAttribute("msgped", "Pedido Solicitado com Sucesso");                
                    session.getAttribute("pedido");
                    session.setAttribute("pedido", pedid);
                    
                    }   catch (Exception ex) {                        
                            Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
                }
                
                
                request.setAttribute("vlrCum", cuptoca.getValorApenasCupom());
                request.setAttribute("enviacupom", 1);

        }  
           
            userPath = "/paginaFinaliza";            
        }

//---------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/paginaFinalizaDois"))
        {
            
            String idpe = request.getParameter("idpedido");
            String clid = request.getParameter("clid");
            String valorcum = request.getParameter("valorsomacupi");
            
            /*double vlrcum = Double.parseDouble(valorcum);
            request.setAttribute("vlrcum", vlrcum);*/
            
            int idstatus = 1;
         
            
            if (idpe != null && !idpe.equals("")) {
            
                      
                ShoppingCartItem in = new ShoppingCartItem();
                Itempedido pedido = new Itempedido();
                Produto produto = new Produto();

                Pedido pedid = new Pedido();
                Clientes cl = new Clientes();
                Endereco en = new Endereco();
                Tipostatus ti = new Tipostatus();
                Cartaocredi cr = new Cartaocredi();
                Statuspostagem pos = new Statuspostagem();
           
           
          
                for(ShoppingCartItem i : cart.items){
            
                
                int idpedido = Integer.parseInt(idpe);                
                pedid.setIdpedido(idpedido);
                int idproduto = i.getProduto().getProid();
                produto.setProid(idproduto);
                ti.setIdtipostatus(idstatus);
                double preco = i.getProduto().getPropreco();
                int quant = i.getQuantity();
                Double vlrt = i.getTotal();            
                pos.setIdpostagem(1);
            
            
                pedido.setIdped(pedid);
                pedido.setIdpro(produto);
                pedido.setIdstatus(ti);
                pedido.setValoritem(preco);
                pedido.setQuantidade(quant);
                pedido.setValortotalitem(vlrt);
                pedido.setIdstatusposta(pos);
            
                try {
                    itDao.persist(pedido);
                    //userPath="/paginaHistoricoPedido";
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //---------------------
                
                Produto proli = null;
                try {
                    proli = (Produto) prodDao.getObjectById(idproduto);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                int aux = proli.getProqtda() - quant;
                proli.setProid(idproduto);
                proli.setPronome(proli.getPronome());
                proli.setProaltura(proli.getProaltura());
                proli.setProcompri(proli.getProcompri());
                proli.setProdescr(proli.getProdescr());
                proli.setProidcategoria(proli.getProidcategoria());
                proli.setProlargura(proli.getProlargura());
                proli.setPropeso(proli.getPropeso());
                proli.setPropreco(proli.getPropreco());
                proli.setProqtda(aux);

                try {
                    prodDao.merge(proli);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                //---------------------
            
            } // fechamento for
            
            } // fechamento if condi????o id pedido
            else {
                request.setAttribute("msgerrop", "N??o foi poss??vel adicionar seu pedido");
            
            }
           
            String clear = request.getParameter("idpedido");
            
            /*if (clear != null){
                ShoppingCart carta = (ShoppingCart) session.getAttribute("cart");
                carta.clear();
            }*/
            
            request.setAttribute("idpedido", clear);
            userPath = "/paginaFinalizaDois";
            //response.sendRedirect("/loja/paginaHistoricoPedido?idcl=" + clid);
            
        }
          
 //---------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/addItem"))
        {
            
            String clear = request.getParameter("idpedido");
            
            
            if (clear != null){
                ShoppingCart carta = (ShoppingCart) session.getAttribute("cart");
                carta.clear();
            }
            userPath = "/paginaAgradecimento";
        }
//---------------------------------------------------------------------------------------------------------
        
         else if (userPath.equals("/detalheItemPedido")){
            
           String iditempedido = request.getParameter("itempedidoid");
            String idproduto = request.getParameter("idpro");
            String idpedido = request.getParameter("idped");
            String idstatus = request.getParameter("tipostatus");
            String idpostagem = request.getParameter("idpostagem");
            String valoritem = request.getParameter("valoritem");
            String quantidade = request.getParameter("quantidade");
            String valortotal = request.getParameter("valortotalitem");
            String justifica = request.getParameter("justifica");
            String qtdtroca = request.getParameter("observatroca");
            
            Itempedido itemped = new Itempedido();
            
            
            
            session.setAttribute("qtdtroca", qtdtroca);
            session.getAttribute("qtdtroca");
            
            
           
            
            if(iditempedido != null && !iditempedido.equals(" ")) 
            {
                
                int idped = Integer.parseInt(iditempedido);
                double valitem = Double.parseDouble(valoritem);
                int qtda = Integer.parseInt(quantidade);
                double valtot = Double.parseDouble(valortotal);
                int idpro = Integer.parseInt(idproduto);
                int idpe = Integer.parseInt(idpedido);
                int idsta = Integer.parseInt(idstatus);
                
                
                int qtdtro = Integer.parseInt(qtdtroca);               
                
                
                Produto pro = new Produto();
                pro.setProid(idpro);
                Pedido ped = new Pedido();
                ped.setIdpedido(idpe);
                Tipostatus sta = new Tipostatus();
                sta.setIdtipostatus(idsta);
                Statuspostagem pos = new Statuspostagem();
                pos.setIdpostagem(Integer.parseInt(idpostagem));
                
                
                itemped.setItempedidoid(idped);
                itemped.setValoritem(valitem);
                itemped.setQuantidade(qtda);
                itemped.setValortotalitem(valtot);
                itemped.setIdpro(pro);
                itemped.setIdped(ped);
                itemped.setIdstatus(sta);
                itemped.setIdstatusposta(pos);
                itemped.setObservatroca(justifica);
                itemped.setQtdtroca(qtdtro);
                
                
                
                try {
                    itDao.merge(itemped);
                    //userPath = "/detalheItemPedido";
                    //int idped = Integer.parseInt(iditempedido);
                    response.sendRedirect("/Discada/gerenciaCliente");
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
            
            //userPath = "/detalhePedido";
           
        }
//---------------------------------------------------------------------------------------------------------
          
    else if(userPath.equals("/detalhePedido"))
         {
         
            String idpe = request.getParameter("idpedi");
            List<Itempedido> pedit;
            pedit = (List<Itempedido>) itDao.listarItemPedido(Integer.parseInt(idpe));
            request.setAttribute("pedit", pedit);
            request.getAttribute("pedit"); 
         
         }
          
//-------------------------------------------------------------------------------------

             else if (userPath.equals("/AnaliseChart")) {  
               
        String dataInicial = request.getParameter("dataInicial");
        String dataFinal = request.getParameter("dataFinal");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        int dife = 0;
        List testelista = new ArrayList();
        List testelista1 = new ArrayList();                
        List testelista2 = new ArrayList();
        List testelista3 = new ArrayList();
        List testelista4 = new ArrayList();
        List testelista5 = new ArrayList();
        List testelista6 = new ArrayList();
        List testelista7 = new ArrayList();
        List testelista8 = new ArrayList();
                
        int soma = 0, som1 = 0, soma2=0, 
                soma3=0, soma4=0, soma5=0, soma6=0, soma7=0; 
        
        int so = 0, so1 = 0, so2=0, 
                so3=0, so4=0, so5=0, so6=0, so7=0; 
                
        List listaProdutosGrafico = new ArrayList();
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        if (dataInicial != null && dataFinal != null) {

        
        String dataInicio = request.getParameter("dataInicial");
        String dataFim = request.getParameter("dataFinal");
        String nome1 = "";
        String nome2 = "";
        String nome3 = "";
        String nome4 = "";
        String nome5 = "";
        String nome6 = "";
        String nome7 = "";
        String nome8 = "";
        

            try {
                
                Date firstDt = formato.parse(dataInicio);
                Date finalDt = formato.parse(dataFim);
                
                long difer  = Math.abs(finalDt.getTime() - firstDt.getTime());
                
                
                long differTw = TimeUnit.DAYS.convert(difer, TimeUnit.MILLISECONDS);
                dife = (int)differTw;
                request.setAttribute("dtini", dife);
                request.getAttribute("dtini");
                
                
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            try {
                Date firstD;
                Date finalD2;
                firstD = formato.parse(dataInicio);
                finalD2 = formato.parse(dataFim);
                
                
                Calendar cal = Calendar.getInstance();
                Calendar calFinal = Calendar.getInstance();
                
                for (int i = 0; i <= dife; i++ ) {
                    
                                                
                        finalD2 = firstD;
                        
                        cal.setTime(firstD);
                        //String datafor = formato.format(calFinal.getTime());
                         
                        
                        cal.add(Calendar.DAY_OF_MONTH, i);
                        
                        
                        calFinal.setTime(finalD2);
                        calFinal.add(Calendar.DAY_OF_MONTH, i+1);
                        String datafor = formato.format(cal.getTime());
                        testelista2.add(datafor);
                        
                        List<Itempedido> produto1 = null;
                        List<Itempedido> produto2 = null;
                        List<Itempedido> produto3 = null;
                        List<Itempedido> produto4 = null;
                        List<Itempedido> produto5 = null;
                        List<Itempedido> produto6 = null;
                        List<Itempedido> produto7 = null;
                        List<Itempedido> produto8 = null;
                        
                        
                        
                        produto1 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 1);
                        produto2 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 2);
                        produto3 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 3);
                        produto4 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 4);
                        produto5 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 5);
                        produto6 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 6);
                        produto7 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 7);
                        produto8 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), 8);
                        
                            for(Itempedido tet : produto1) { 
                                soma = (int) (soma + tet.getValortotalitem());
                                so = so + soma;
                                nome1 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = (int) (som1 + tet.getValortotalitem());                                
                                so1 = so1 + som1;
                                nome2 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto3) { 
                                soma2 = (int) (soma2 + tet.getValortotalitem());
                                so2 = so2 + soma2;
                                nome3 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto4) { 
                                soma3 = (int) (soma3 + tet.getValortotalitem());                                
                                so3 = so3 + soma3;
                                nome4 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto5) { 
                                soma4 = (int) (soma4 + tet.getValortotalitem());                                
                                so4 = so4 + soma4;
                                nome5 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto6) { 
                                soma5 = (int) (soma5 + tet.getValortotalitem());                                
                                so5 = so5 + soma5;
                                nome6 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto7) { 
                                soma6 = (int) (soma6 + tet.getValortotalitem()); 
                                so6 = so6 + soma6;
                                nome7 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto8) { 
                                soma7 = (int) (soma7 + tet.getValortotalitem());                                
                                so7 = so7 + soma7;
                                nome8 = tet.getIdpro().getPronome();
                            }
                          
                        
                            
                        String datafor2 = formato.format(calFinal.getTime());
                        
                        testelista.add(soma);
                        testelista1.add(som1);
                        testelista8.add(soma2);
                        testelista3.add(soma3);
                        testelista4.add(soma4);
                        testelista5.add(soma5);
                        testelista6.add(soma6);
                        testelista7.add(soma7);
                        
                        firstD = finalD2;
                        soma = 0; som1 = 0; soma2= 0; soma3 = 0; soma4 = 0; 
                        soma5 = 0; soma6 = 0; soma7 = 0;
                  
                }
                produtos.add(new GerarGraficoMontado("Awaken, My Love!", so));
                produtos.add(new GerarGraficoMontado("Black Pumas", so1));
                produtos.add(new GerarGraficoMontado("Alucina????o", so2));
                produtos.add(new GerarGraficoMontado("Cartola 1976", so3));
                produtos.add(new GerarGraficoMontado("To Pimp a Butterfly", so4));
                produtos.add(new GerarGraficoMontado("Legend", so5));
                produtos.add(new GerarGraficoMontado("Novos Baianos, Acabou Chorare", so6));
                produtos.add(new GerarGraficoMontado("Kind of Blue - Miles Davis", so7));
                
                GraficoProdutos prod = new GraficoProdutos();
                /*prod.findAllListDois(nome1, so);
                prod.findAllListDois(nome2, so1);
                prod.findAllListDois(nome3, so2);
                prod.findAllListDois(nome4, so3);
                prod.findAllListDois(nome5, so4);
                prod.findAllListDois(nome6, so5);
                prod.findAllListDois(nome7, so6);
                prod.findAllListDois(nome8, so7);
                //prod.setLista(produtos);*/
                
               Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAllListDois(soma, som1, soma2, soma3, soma4, soma5, soma6, soma7)));
                
                userPath = "/chart"; 
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        }else{ 
        
            GraficoProdutos prod = new GraficoProdutos();
            
             Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAllListDois(soma, som1, soma2, soma3, soma4, soma5, soma6, soma7)));
            userPath = "/chart"; 
        }
           
             
           
        }
        
// ------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------            
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
           String url = "/WEB-INF/views" + userPath + ".jsp";
           try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
          
    } // encerra do verbo POST

    
} // encerra do Servlet
