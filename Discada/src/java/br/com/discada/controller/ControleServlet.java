
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
import br.com.discada.model.jpa.Produto;
import br.com.discada.model.jpa.Segredo;
import br.com.discada.services.ShoppingCart;
import br.com.discada.services.servicoValida;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
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
        urlPatterns = {"/update", "/enviarPedido", "/paginaCompraLista", "/excluirEndereco",
            "/paginaFinaliza", "/addCart", "/addItem", "/paginaFormaPagamento", "/paginaProduto", 
            "/addAcesso", "/deslogar", "/paginaLogin", "/paginaHistoricopedido", "/editarEndereco",
            "/paginaEndereco", "/paginaDadosPessoais", "/cadastroCartao", "/paginaCupom", "/paginaDadosPessoaisSenha",
            "/paginaCartoes", "/gerenciaCliente", "/excluirCartao", "/cadastroP2", "/consultaProduto", 
            "/cadastroP1", "/detalhePedido", "/detalheItemPedido", "/consultaCategoria", "/paginaHistoricoNome"})

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
    
    
  
    
    @Override
    public void init () throws ServletException{
        
        // Listagem dos produtos no "Servlet Context" - Inicializando a vitrine
        getServletContext().setAttribute("produtos", prodDao.getListaObjetos());
    }

    
// ------------------------------------------------------------------------------------
// INICIO DO MÉTODO GET
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
// END POINTS MÉTODO GET
// ------------------------------------------------------------------------------------

// ------------------------------------------------------------------------------------
            if (userPath.equals("/Discada")) {
            
        } 

// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos endereços do cliente
            
            else if (userPath.equals("/paginaEndereco")){
                
                String idCliente = request.getParameter("idcl"); //pegando id do cliente para listar seu(s) endereço(s)
            
                if(idCliente != null && !idCliente.equals("")){
                    List<Endereco> endereco;
                    endereco = (List<Endereco>) endDao.listarEndereco(Integer.parseInt(idCliente));
                    session.setAttribute("endereco", endereco);
                    session.getAttribute("endereco");
            
            }
            
            
            
            }

// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos cartões cadastros ´pelo cliente
            
            else if (userPath.equals("/deslogar")) {   
                
                session.invalidate();
                userPath = "/cadastroP2";
            
            }
// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos cartões cadastros ´pelo cliente
            
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
// end point para gerar a listagem dos endereços do cliente            
            
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
// end point para gerar os dados de login e senha na página de alteração de dados 
          
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
// Encaminhar os dados da compra para finalizar o pedido 
          
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
// FIM DOS CONTROLES DO MÉTODO GET
// ==========================================================================================
    
    
// ----------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------
// INICIO DO MÉTODO POST
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
            
            // recebendo dados do formulário
            String log = request.getParameter("login");
            String pas = request.getParameter("senha");
            String pasone = request.getParameter("senhaone");
            String idseg = request.getParameter("idsegr");
            
            // Valida existe dos dados e solicita alteração no banco
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
                            request.setAttribute("msgseg", "Senha não conferem! Tente Novamente");
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
        // ATENÇÃO, Não esquecer de levar essa regra de negócio para um pacote de serviços

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
                if (segDao.isAcesso() == false) {request.setAttribute("errologin", "o login e ou a senha não conferem. "
                    + "Certifique-se dos dados e tente novamente");
                    userPath = "/cadastroP2";
                }
                
               
            /*servicoValida recebe = new servicoValida();
        
            String log = request.getParameter("login");
            String sen = request.getParameter("senha");
            String idsegredo = request.getParameter("idsegredo"); 

            List <Segredo> segr; 
            segr = (List<Segredo>) segDao.buscaUsuario(log, sen);
            
            int idcliente = recebe.validaAcesso(log, sen, segr);
            
            if (idcliente != 0) {
                try {
                    Clientes cli = (Clientes) clieDao.getObjectById(idcliente); 
                    session.setAttribute("cliente", cli);
                    session.getAttribute("cliente");
                    segDao.setAcesso(true); 
                }   catch (Exception ex) {
                        Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                Segredo seg = new Segredo();                
                request.getSession().setAttribute("usuario", seg);
                session.setAttribute("se", seg);
                session.getAttribute("cliente");                
                request.setAttribute("msgbem", "Bem vindo!");
                userPath = "/gerenciaCliente";
                
            } else {userPath = "/cadastroP2";
                    request.setAttribute("msg", "Informe login e senha corretamente");}
           
            if (segDao.isAcesso() == false) {
                request.setAttribute("errologin", "o login e ou a senha não conferem. "
                + "Certifique-se dos dados e tente novamente");
                userPath = "/cadastroP2";
            }  */             
        }

// ------------------------------------------------------------------------------------
// end point para cadastrar um cartão de crédito pelo cliente
            
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
                
                // Recebendo dados do formulário
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
                
                // "setando" o id do cliente para poder passar no objeto endereço
                cli.setCliid (idcli);
                
                // "setando objeto endereço
                endereco.setEndid(iden);
                endereco.setEndnomedestino(nomeDes);
                endereco.setEndcep(cep); 
                endereco.setEndlogradouro(logra);
                endereco.setEndcomplemento(complem);
                endereco.setEndnumero(numCasa);
                endereco.setEndcidade(cidade);
                endereco.setEndbairro(bairro);
                endereco.setEndestado(estado);
                endereco.setEndidcliente(cli); // aqui passamos objeto cliente que já está setado com o id do formulário
                
                try {
                    endDao.merge(endereco); // realizando operação no banco (solicitação)
                    request.setAttribute("msgEditarEnd", "Endereço editado com sucesso!");
                    Endereco selecioneEn = (Endereco) endDao.getObjectById(iden); // buscando o registro
                    request.setAttribute("selecioneCliEnd", selecioneEn); // criando um objeto na sessão
                    userPath = "/editarEndereco"; // "setando a path de redirecionamento após a resposta da requisição
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("msgEditarEnd", "Problema ao editar endereço");
                    
                }
            }
        }
          
// ----------------------------------------------------------------------------------------------
// end point para realizar alteração nos dados cadastrais do cliente 
          
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
                                 
                
                // Se não for null ou vazio alterar no banco de dados
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
// end point para realizar a exclusão de um endereço no banco de dados 
          
        else if (userPath.equals("/excluirEndereco")) {
        
            String endidStr = request.getParameter("idclieSt"); // ID do endereço cadastrado
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
                    request.setAttribute("msgEnd", " não pode ser "
                            + "excluído porque está associado a uma compra em sua conta! Obrigado pela compreensão.");
                    }
            }
        }
// ------------------------------------------------------------------------------------
// end point para gerar a listagem dos endereços do cliente
            
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
            
            // cria objeto para validar senha forte no pacote de serviços
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
            // Chamando o cliente da sessão login
                
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
