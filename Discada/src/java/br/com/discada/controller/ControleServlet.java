
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
import br.com.discada.model.jpa.Clientes;
import br.com.discada.model.jpa.Endereco;
import br.com.discada.model.jpa.Segredo;
import java.io.IOException;
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
    private ClienteDao cliDao;
    
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
            
             else if (userPath.equals("/gerenciaCliente")){
            
            
            }

// ------------------------------------------------------------------------------------
// end point para realizar a busca do login e senha do cliente 
          
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
          
          else if (userPath.equals("/cadastroP2")) {
              
          }
          
// ----------------------------------------------------------------------------------------------
// end point para validar a senha e login do cliente 
          
        else if (userPath.equals("/paginaLogin")) {
        // ATENÇÃO, Não esquecer de levar essa regra de negócio para um pacote controlador
          
            String log = request.getParameter("login");
            String sen = request.getParameter("senha");
            String idsegredo = request.getParameter("idsegredo"); 

            List <Segredo> segr; 
            segr = (List<Segredo>) segDao.buscaUsuario(log, sen);

            for ( Segredo vam : segr ){

                if(vam != null && vam.getSecsenha().equals(sen) && vam.getSeclogin().equals(log))
                {
                    int idse = vam.getSecid();
                    int idclit;
                    segDao.setAcesso(true);

                    List<Clientes> c; 
                    c = (List<Clientes>) cliDao.pegarClienteSegredo(idse);

                        if(c != null && !c.isEmpty() && !c.equals("")) {

                            for (Clientes vem : c){

                                idclit = vem.getCliid();
                                try {
                                    Clientes cli = (Clientes) cliDao.getObjectById(idclit); 
                                    session.setAttribute("cliente", cli);
                                    session.getAttribute("cliente");
                                }   catch (Exception ex) {
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

                } else {
                    userPath = "/cadastroP2";
                    request.setAttribute("msg", "Informe login e senha corretamente");
                  }
            }

            if (segDao.isAcesso() == false) {
                request.setAttribute("errologin", "o login e ou a senha não conferem. "
                + "Certifique-se dos dados e tente novamente");
                userPath = "/cadastroP2";
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
                    Clientes cli = (Clientes) cliDao.getObjectById(Integer.parseInt(idcl));
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
            
                    try {cliDao.merge(client);
                            try {
                                Clientes cli = (Clientes) cliDao.getObjectById(Integer.parseInt(idcl));
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
