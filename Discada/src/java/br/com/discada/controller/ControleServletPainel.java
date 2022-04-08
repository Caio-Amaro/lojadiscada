
package br.com.discada.controller;


import br.com.discada.model.DAO.CategoriaDao;
import br.com.discada.model.DAO.ClienteDao;
import br.com.discada.model.DAO.CupomDao;
import br.com.discada.model.DAO.EnderecoDao;
import br.com.discada.model.DAO.ItemPedidoDao;
import br.com.discada.model.DAO.PedidoDao;
import br.com.discada.model.DAO.ProdutoDao;
import br.com.discada.model.jpa.Categoria;
import br.com.discada.model.jpa.Clientes;
import br.com.discada.model.jpa.Cupom;
import br.com.discada.model.jpa.Endereco;
import br.com.discada.model.jpa.Itempedido;
import br.com.discada.model.jpa.Pedido;
import br.com.discada.model.jpa.Produto;
import br.com.discada.model.jpa.Statuspostagem;
import br.com.discada.model.jpa.Tipostatus;
import br.com.discada.services.controleCupom;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet(name = "ControleServletPainel", 
                   loadOnStartup = 2,
                   urlPatterns = {"/relatorioVendasGeral", "/listarCupom", "/processaBusca",
                   "/relatorioVendaProduto", "/relatorioVendaData", "/editarCupom", "/consultaNomeCliente",
                   "/controlePedidos", "/editarCategoria", "/adicionarCupomProm", "/consultaNomeProduto",
                   "/detalheClientes", "/editarProduto", "/adicionarCupomTroca", "/pesquisaVendasMes",
                   "/relatorioVendaCategoria", "/adicionarCategoria", "/editarItemPedido",
                   "/controleClientes", "/controleEstoque", "/adicionarProduto",
                   "/Painel", "/loginAdm", "/addPostagem", "/pesquisaVendas"})

        
public class ControleServletPainel extends HttpServlet {

@EJB
private ProdutoDao proDao;

@EJB
private CategoriaDao caDao;

@EJB
private CupomDao cuDao;

@EJB
private PedidoDao peDao;

@EJB
private ClienteDao clDao;

@EJB
private ItemPedidoDao itemDao;

@EJB
private EnderecoDao endDao;

/*@EJB
private AcessoDao acDao;*/



// --------------------------------------------------------------------------//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException  {
         String userPath = request.getServletPath();
         HttpSession session = request.getSession();
         
        
        if(userPath.equals("/relatorioVendasGeral")){
            
            request.getAttribute("pedo");
            
          
        }
    
// ------------------------------------------------------------------------------------------------

        else if (userPath.equals("/editarCupom")){
            
            String idcu = request.getQueryString();
            try {
                Cupom cup = (Cupom) cuDao.getObjectById(Integer.parseInt(idcu));
                request.setAttribute("cup", cup);
            } catch (Exception ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            }        
// ------------------------------------------------------------------------------------------------        
// ------------------------------------------------------------------
        
        else if (userPath.equals("/editarItemPedido")){
            
            session.getAttribute("iditem");
            String iditem = request.getQueryString();
            
            controleCupom crtcup = new controleCupom();
            
            int qtdtr = crtcup.getEnderecoNum();
            
            request.setAttribute("qtdtroca", qtdtr);
            session.getAttribute("qtdtroca");
            
            
            if(iditem != null && !iditem.equals(" ")){
                
                int idt = Integer.parseInt(iditem);
            
                try {
                    Itempedido it = (Itempedido) itemDao.getObjectById(idt);
                    session.getAttribute("idtem");
                    session.setAttribute("iditem", it);
                            
                            } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
          
        }
        
        
        // ------------------------------------------------------------------
        
       
        
        else if (userPath.equals("/editarCategoria")){
            
            String catui = request.getQueryString();
            
            try {
                Categoria selecioca = (Categoria) caDao.getObjectById(Integer.parseInt(catui));
                request.setAttribute("selecioca", selecioca);
            } catch (Exception ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
          
        }
        
        
        // ------------------------------------------------------------------
        
        
        
        else if (userPath.equals("/adicionarCategoria")){
            
            String catexclui = request.getQueryString();
           
            if (catexclui != null && !catexclui.equals(" ")) 
            {
            
             try {
                 Categoria cat = (Categoria) caDao.getObjectById(Integer.parseInt(catexclui));
                 caDao.remover(cat);
             } catch (Exception ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
                
          
        }
        
        // ------------------------------------------------------------------
        
        else if (userPath.equals("/detalheClientes")){
            
            String cliStr = request.getParameter("idcliente");
            
            if (cliStr != null && !cliStr.equals("")) {
                try {
                    Clientes selecioneCl = (Clientes) clDao.getObjectById(Integer.parseInt(cliStr));
                     session.setAttribute("selecioneCl", selecioneCl);
                     session.getAttribute("selecioneCl");
                } catch (Exception e) {
                }
              
            }
                List<Endereco> ende;
                ende = (List<Endereco>) endDao.listarEnderecoPorIdCliente(Integer.parseInt(cliStr));
                request.setAttribute("ender", ende);
                request.getAttribute("ender");
            
                
                List<Pedido> cli;
                cli = (List<Pedido>) peDao.listarPorDataIdCliente(Integer.parseInt(cliStr));
                session.setAttribute("pedidoCliente", cli);
                session.getAttribute("pedidoCliente"); 
            
                userPath = "/detalheClientes";
        
        }
  
// ---------------------------------------------------------------------------
        
        else if (userPath.equals("/editarProduto")){
            
        String edProd = request.getQueryString();
        
        if (edProd != null && !edProd.equals(" ")) {
        
            Produto selecionaProd;
            try {
                selecionaProd = (Produto) proDao.getObjectById(Integer.parseInt(edProd));
                request.setAttribute("selecionaProd", selecionaProd);
            } catch (Exception ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            List<Categoria> categ;
            categ = (List<Categoria>) caDao.getListaObjetos() ;
                session.setAttribute("categ", categ);
                session.getAttribute("categ"); 
            
        
        }
            
        
        }
        
// ---------------------------------------------------------------------------
        else if (userPath.equals("/controlePedidos")){
            session.getAttribute("item"); 
            
            String idpe = request.getParameter("idpedi");
            List<Itempedido> en;
            en = (List<Itempedido>) itemDao.listarItemPedido(Integer.parseInt(idpe));
            session.setAttribute("item", en);
            session.getAttribute("item"); 
           
        }

// ---------------------------------------------------------------------------
        
        else if (userPath.equals("/listarCupom")){
           
            String cuexclui = request.getQueryString();
            
            List <Cupom> listacup = (List<Cupom>) cuDao.getListaObjetos();
            session.setAttribute("listacup", listacup);
            session.getAttribute("listacup");
            
            
            
            if (cuexclui != null && !cuexclui.equals(" ")) 
            {
            
             try {
                 Cupom selecu = (Cupom) cuDao.getObjectById(Integer.parseInt(cuexclui));
                 cuDao.remover(selecu);
             } catch (Exception ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            
            
        
        }
    // ----------------------------------------------------------------------
        
        else if (userPath.equals("/controleEstoque")){
            
            String proexclui = request.getQueryString();
            
            List<Produto> pro = (List<Produto>) proDao.getListaObjetos();
            session.setAttribute("prody", pro);
            session.getAttribute("prody");
           
            if (proexclui != null && !proexclui.equals(" ")) 
            {
            
             try {
                 Produto prod = (Produto) proDao.getObjectById(Integer.parseInt(proexclui));
                 proDao.remover(prod);
             } catch (Exception ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
              
            
        }
    // ----------------------------------------------------------------------
        else if (userPath.equals("/adicionarProduto")){
            
            List<Categoria> categ;
            categ = (List<Categoria>) caDao.getListaObjetos() ;
                session.setAttribute("categ", categ);
                session.getAttribute("categ"); ;
        
        }
    
    // ----------------------------------------------------------------------
        
        else if (userPath.equals("/Painel")){
            
           /* String datinicio = request.getParameter("datainicial");
            String datfim = request.getParameter("datafinal");*/            
            //if(datinicio == null  && datinicio.equals(" ") && datfim == null && datfim.equals(" ")) {*/
            
           
            /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
           
            
            String datinicio = "03/11/2021";
            String datfim = "04/11/2021";
            
            List<Pedido> pedid;
             try {
                 pedid = (List<Pedido>) peDao.listarPorData(formato.parse(datinicio), formato.parse(datfim));
                 session.getAttribute("pedo");
                 session.setAttribute("pedo", pedid); 
                 userPath = "/Painel";
             } catch (ParseException ex) {
                 Logger.getLogger(ControllerServAdmin.class.getName()).log(Level.SEVERE, null, ex);
             }
            //}*/
            
             
            
        }
    
 // ----------------------------------------------------------------------
        else if (userPath.equals("/adicionarCupomPromo")){
            
            List<Clientes> clientg;
            clientg = (List<Clientes>) clDao.getListaObjetos() ;
                session.setAttribute("clientg", clientg);
                session.getAttribute("clientg"); ;
        
        }
    
// -----------------------------------------------------------------------------
        else if (userPath.equals("/adicionarCupomTroca")){
            
            List<Clientes> clientg;
            clientg = (List<Clientes>) clDao.getListaObjetos() ;
                session.setAttribute("clientg", clientg);
                session.getAttribute("clientg"); ;
        
        }
    
// -----------------------------------------------------------------------------
// -----------------------------------------------------------------------------
        else if (userPath.equals("/controleClientes")){
            //session.getAttribute("item"); 
            
            //String idpe = request.getParameter("idpedi");
            List<Clientes> clienten;
            clienten = (List<Clientes>) clDao.getListaObjetos();
            session.setAttribute("cliet", clienten);
            session.getAttribute("cliet"); 
           
        }
// ------------------------------------------------------------------
        
        else if (userPath.equals("/detalhePedido")){
           
            String itemvenda = request.getParameter("idpediit");
           
            if (itemvenda != null && !itemvenda.equals(" ")) 
            {
                        
            List<Itempedido> ittem;
            ittem = (List<Itempedido>) itemDao.listarItemPedido(Integer.parseInt(itemvenda));
            request.setAttribute("item", ittem);
            request.getAttribute("item");
            } 
        }
        
  
 // ----------------------------------------------------------------------
    
        String url = "/WEB-INF/viewsPainel" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    // ----------------------------------------------------------------------
    // ----------------------------------------------------------------------
    // ----------------------------------------------------------------------
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        session.getAttribute("acesso");
        
        if(userPath.equals("/adicionarProduto")){
            
                String titulo = request.getParameter("titulo");
                String descricao = request.getParameter("descricao");
                String peso = request.getParameter("peso");
                String alt = request.getParameter("altura");
                String largura = request.getParameter("largura");
                String compri = request.getParameter("compri");
                String preco = request.getParameter("preco");
                String qtd = request.getParameter("qtd");                
                String categoria = request.getParameter("categoria");
                
                        
            if (titulo != null && !titulo.equals("")) {
            
                Produto prodi = new Produto();
                Categoria category = new Categoria();
                category.setCatid(Integer.parseInt(categoria));

                double altura = Double.parseDouble(alt);
                prodi.setPronome(titulo);
                prodi.setProdescr(descricao);
                prodi.setProcompri(Double.parseDouble(compri));
                prodi.setPropeso(Double.parseDouble(peso));
                prodi.setProaltura(altura);//Double.parseDouble(altura));
                prodi.setProlargura(Double.parseDouble(largura));
                prodi.setPropreco(Double.parseDouble(preco));
                prodi.setProqtda(Integer.parseInt(qtd));
                prodi.setProidcategoria(category);
                
                    try {
                        proDao.persist(prodi);
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
        userPath = "/controleEstoque";        
        String url = "/WEB-INF/viewsPainel" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        }
        }
        
// ---------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------
        
        else if (userPath.equals("/processaBusca")) 
        {
                     
            String datinicio = request.getParameter("datainicial");
            String datfim = request.getParameter("datafinal");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
           
            
            
            Pedido pe = new Pedido();
            
            if(datinicio != null && !datinicio.equals("") && datfim != null && !datfim.equals("")  ){
            
            List<Pedido> pedid;
             try {
                 pedid = (List<Pedido>) peDao.listarPorData(formato.parse(datinicio), formato.parse(datfim));
                 session.getAttribute("pedo");
                 session.setAttribute("pedo", pedid); 
                 userPath = "/Painel";
             } catch (ParseException ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            
             String produt = request.getParameter("prod");
             if(produt != null && !produt.equals("")){
             int categoria = Integer.parseInt(produt);          
             Itempedido peit = new Itempedido();
             
             List<Itempedido> pedit;
             try{
                pedit = (List<Itempedido>) itemDao.listarPorDataCategoria(formato.parse(datinicio), (formato.parse(datfim)), categoria);
                session.getAttribute("pedit");
                session.setAttribute("pedit", pedit);    
                userPath = "/Painel";
             } catch(ParseException ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
             }
            } else {
            
                String daini = "04-10-2021";
                String dafim = "04-10-2021";
                
            List<Pedido> pedid;
             try {
                 pedid = (List<Pedido>) peDao.listarPorData(formato.parse(daini), formato.parse(dafim));
                 session.getAttribute("pedo");
                 session.setAttribute("pedo", pedid); 
                 userPath = "/Painel";
             } catch (ParseException ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
          userPath = "/Painel";
        
        }

// ---------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------

        else if(userPath.equals("/adicionarCupomTroca")){
        
            String nome = request.getParameter("nomecupom");
            String iden = request.getParameter("idcliente");
            String val = request.getParameter("valorcupom");
            String tip = request.getParameter("troca");
            
            if(nome != null && !nome.equals(" ")) 
            {
                            
               Cupom cu = new Cupom();
               
               int identifica = Integer.parseInt(iden);
               double valor = Double.parseDouble(val);
               int tipo = Integer.parseInt(tip);
               
               
               Clientes cl = new Clientes();
               cl.setCliid(identifica);
               
               cu.setNomecupom(nome);
               cu.setIdclientecup(cl);
               cu.setValorcupom(valor);
               cu.setIdtipo(tipo);
               
                try {
                    cuDao.persist(cu);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            userPath = "/listarCupom";        
        
            }
        
        }
        
               
    // ------------------------------------------------------------------
        
        else if (userPath.equals("/adicionarCupomPromo")){
            
            String nome = request.getParameter("nomecupom");
            String iden = request.getParameter("idcliente");
            String val = request.getParameter("valorcupom");
            String tip = request.getParameter("desconto");
            
            if(nome != null && !nome.equals(" ")) 
            {
                            
               Cupom cu = new Cupom();
               
               int identifica = Integer.parseInt(iden);
               double valor = Double.parseDouble(val);
               int tipo = Integer.parseInt(tip);
               
               
               Clientes cl = new Clientes();
               cl.setCliid(identifica);
               
               cu.setNomecupom(nome);
               cu.setIdclientecup(cl);
               cu.setValorcupom(valor);
               cu.setIdtipo(tipo);
               
                try {
                    cuDao.persist(cu);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            userPath = "/listarCupom";        
        
            }
        }
        
    // --------------------------------------------------------------------------//
        
        
        else if (userPath.equals("/editarCupom"))
        {
            String id = request.getParameter("id");
            String nome = request.getParameter("nomecupom");
            String iden = request.getParameter("idcliente");
            String val = request.getParameter("valorcupom");
            String tip = request.getParameter("desconto");
            
            if(nome != null && !nome.equals(" ")) 
            {
                            
               Cupom cu = new Cupom();
               
               int identifica = Integer.parseInt(iden);
               double valor = Double.parseDouble(val);
               int tipo = Integer.parseInt(tip);
               int idc = Integer.parseInt(id);
               
               Clientes cl = new Clientes();
               cl.setCliid(identifica);
               
               cu.setIdcupom(idc);
               cu.setNomecupom(nome);
               cu.setIdclientecup(cl);
               cu.setValorcupom(valor);
               cu.setIdtipo(tipo);
               
                try {
                    cuDao.merge(cu);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        }
            userPath = "/listarCupom";
      
        }    
    // --------------------------------------------------------------------------//
        
        
        else if (userPath.equals("/adicionarCategoria")){
         String nome = request.getParameter("nomecat");
            
            if(nome != null && !nome.equals(""))
            {
            
                Categoria cat = new Categoria();
                cat.setCatnome(nome);
                
                try {
                    caDao.persist(cat);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            
                           
               
                userPath = "/adicionarCategoria";        
                String url = "/WEB-INF/viewsPainel" + userPath + ".jsp";

                try {
                     request.getRequestDispatcher(url).forward(request, response);
                } catch (Exception ex) {
                     ex.printStackTrace();
                     } 
               
            
                
        }
    
    // --------------------------------------------------------------------------//
        
        else if (userPath.equals("/editarProduto")){
        
            String nomep = request.getParameter("nome");
            String descricao = request.getParameter("descr");
            String peso = request.getParameter("peso");
            String altura = request.getParameter("altura");
            String largura = request.getParameter("largura");
            String compri = request.getParameter("compri");
            String preco = request.getParameter("preco");
            String quantidade = request.getParameter("qtd");
            String idproduto = request.getParameter("idproduto");
            String categoria = request.getParameter("categoria");
            String desativar = request.getParameter("desativar");
            
            
            int desativa = 0;
            
            if (desativar != null && !desativar.equals(""))
            {
            
                desativa = Integer.parseInt(desativar);
            
            }
            else { desativa = 0;}
            
            
            //if(nomep != null && !nomep.equals(" ")){
                
                
                
                int categ = Integer.parseInt(categoria);
                Categoria idcat = new Categoria();
                idcat.setCatid(categ);
                
                double pesop = Double.parseDouble(peso);
                double alturap = Double.parseDouble(altura);
                double largurap = Double.parseDouble(largura);
                double comprip = Double.parseDouble(compri);
                double precop = Double.parseDouble(preco);
                int qtda = Integer.parseInt(quantidade);                
                int idprod = Integer.parseInt(idproduto);
                
                Produto prod = new Produto();
                
                prod.setProid(idprod);
                prod.setPronome(nomep);
                prod.setProdescr(descricao);
                prod.setPropeso(pesop);
                prod.setProaltura(alturap);
                prod.setProlargura(largurap);
                prod.setProcompri(comprip);
                prod.setPropreco(precop);
                prod.setProqtda(qtda);
                prod.setProidcategoria(idcat);
                prod.setProativo(desativa);
                
                try {
                    proDao.merge(prod);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            //}
            //userPath = ("/editarProduto?" + idproduto);
            response.sendRedirect("/Discada/editarProduto?" + idproduto);
        }
        
    // --------------------------------------------------------------------------//
        
        else if (userPath.equals("/editarItemPedido"))
        {
            String iditempedido = request.getParameter("itempedidoid");
            String idproduto = request.getParameter("idpro");
            String idpedido = request.getParameter("idped");
            String idstatus = request.getParameter("tipostatus");
            String idpostagem = request.getParameter("idpostagem");
            String valoritem = request.getParameter("valoritem");
            String quantidade = request.getParameter("quantidade");
            String valortotal = request.getParameter("valortotalitem");
            String observatroca = request.getParameter("observatroca");
            String qtdatroca = request.getParameter("qtdatroca");
            
            if(qtdatroca.equals("")) {
            
                qtdatroca = "0";
            
            }
            
            String nomecupom = request.getParameter("nomecupom");
            String idcliente = request.getParameter("idcliente");
            
            double vlritem = Double.parseDouble(valoritem);
            
           int qtdtrc = Integer.parseInt(qtdatroca);
            
            if (idstatus.equals("4") || idstatus.equals("8")){
                Cupom cupom = new Cupom();
                Clientes cl = new Clientes();
                cl.setCliid(Integer.parseInt(idcliente));
                
                Double vlrfinal = vlritem * qtdtrc;
                
                cupom.setNomecupom(nomecupom);
                cupom.setIdclientecup(cl);
                cupom.setValorcupom(vlrfinal);
                cupom.setIdtipo(1);
                
                try {
                    cuDao.persist(cupom);
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }            
           
            
                Itempedido itemped = new Itempedido();
           
            
                if(iditempedido != null && !iditempedido.equals(" ")) 
                {

                    int idped = Integer.parseInt(iditempedido);
                    double valitem = Double.parseDouble(valoritem);
                    int qtda = Integer.parseInt(quantidade);
                    double valtot = Double.parseDouble(valortotal);
                    int idpro = Integer.parseInt(idproduto);
                    int idpe = Integer.parseInt(idpedido);
                    int idsta = Integer.parseInt(idstatus);

                    qtda = qtda - qtdtrc;

                    Produto pro = new Produto();
                    pro.setProid(idpro);
                    Pedido ped = new Pedido();
                    ped.setIdpedido(idpe);
                    Tipostatus sta = new Tipostatus();
                    sta.setIdtipostatus(idsta);
                    Statuspostagem pos = new Statuspostagem();
                    pos.setIdpostagem(Integer.parseInt(idpostagem));

                    valtot = valitem * qtda;

                    itemped.setItempedidoid(idped);
                    itemped.setValoritem(valitem);
                    itemped.setQuantidade(qtda);
                    itemped.setValortotalitem(valtot);
                    itemped.setIdpro(pro);
                    itemped.setIdped(ped);
                    itemped.setIdstatus(sta);
                    itemped.setIdstatusposta(pos);
                    itemped.setObservatroca(observatroca);



                    try {
                        itemDao.merge(itemped);
                        userPath = "/relatorioVendasGeral";                   
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            
            } else{
                 
                if(iditempedido != null && !iditempedido.equals(" ")) 
                {

                    int idped = Integer.parseInt(iditempedido);
                    double valitem = Double.parseDouble(valoritem);
                    int qtda = Integer.parseInt(quantidade);
                    double valtot = Double.parseDouble(valortotal);
                    int idpro = Integer.parseInt(idproduto);
                    int idpe = Integer.parseInt(idpedido);
                    int idsta = Integer.parseInt(idstatus);
                    
                    Itempedido itemped = new Itempedido();
                    

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
                    itemped.setObservatroca(observatroca);



                    try {
                        itemDao.merge(itemped);
                        userPath = "/relatorioVendasGeral";                   
                    } catch (Exception ex) {
                        Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                }

            
        }
     
        
    // --------------------------------------------------------------------------//
        
        else if (userPath.equals("/editarCategoria"))
        {
            String idcat = request.getParameter("idcat");
            String nomecat = request.getParameter("catnome");
            
            if (idcat != null && !idcat.equals(" "))
            {
                int idca = Integer.parseInt(idcat);
                
                Categoria cate = new Categoria();
                
                cate.setCatid(idca);
                cate.setCatnome(nomecat);
                
                try {
                    caDao.merge(cate);
                    userPath = "/adicionarCategoria";
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        }
    
    // --------------------------------------------------------------------------//
    
        else if (userPath.equals("/addPostagem"))
        {
         
            String iditempedido = request.getParameter("itempedidoid");
            String idproduto = request.getParameter("idpro");
            String idpedido = request.getParameter("idped");
            String idstatus = request.getParameter("tipostatus");
            String idpostagem = request.getParameter("tipopostagem");
            String valoritem = request.getParameter("valoritem");
            String quantidade = request.getParameter("quantidade");
            String valortotal = request.getParameter("valortotalitem");
            
            
            Itempedido itemped = new Itempedido();
           
            
            if(iditempedido != null && !iditempedido.equals(" ")) 
            {
                
                int idped = Integer.parseInt(iditempedido);
                double valitem = Double.parseDouble(valoritem);
                int qtda = Integer.parseInt(quantidade);
                double valtot = Double.parseDouble(valortotal);
                int idpro = Integer.parseInt(idproduto);
                int idpe = Integer.parseInt(idpedido);
                int idsta = Integer.parseInt(idstatus);
                
                
                
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
                
                
                
                try {
                    itemDao.merge(itemped);
                    userPath = "/controlePedidos";
                } catch (Exception ex) {
                    Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            
            }
           
        
        }
// ----------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------        
        
        else if (userPath.equals("/pesquisaVendas")) {  
            
            String datinicio = request.getParameter("datainicial");
            String datfim = request.getParameter("datafinal");
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            
            Pedido pe = new Pedido();
            
            List<Pedido> pedid;
             try {
                 pedid = (List<Pedido>) peDao.listarPorData(formato.parse(datinicio), formato.parse(datfim));
                 session.getAttribute("pedo");
                 session.setAttribute("pedo", pedid);                 
             } catch (ParseException ex) {
                 Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
             }
            
                       
        
            
            
        }
 
// ----------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------        
        
        else if (userPath.equals("/consultaNomeProduto")){
        
            String nomeproduto = request.getParameter("srch");
       
       List<Produto> pro;
       pro = (List<Produto>) proDao.listarPorNomeProduto(nomeproduto);
       request.setAttribute("prodcon", pro);
       request.getAttribute("prodcon");
       userPath = "/consultaNomeProduto";
        
        
        }

// ----------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------        
        
        else if (userPath.equals("/consultaNomeCliente")){
        
            String nomeproduto = request.getParameter("nomecliente");
       
       List<Clientes> clit;
       clit = (List<Clientes>) clDao.listarPorNomeCliente(nomeproduto);
       request.setAttribute("clienome", clit);
       request.getAttribute("clienome");
       userPath = "/consultaNomeCliente";
        
        
        }
// ------------------------------------------------------------------
        
        else if (userPath.equals("/detalhePedido")){
            
            
            String itemvenda = request.getParameter("idpi");
           
            if (itemvenda != null && !itemvenda.equals(" ")) 
            {
                        
            List<Itempedido> novoit;
            novoit = (List<Itempedido>) itemDao.listarItemPedido(Integer.parseInt(itemvenda));
            request.setAttribute("novoitem", novoit);
            request.getAttribute("novoitem");
            } 
        }
        
        
 // --------------------------------------------------------------------------//
        
 // --------------------------------------------------------------------------//
        
        String url = "/WEB-INF/viewsPainel" + userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
            

    }
 }
