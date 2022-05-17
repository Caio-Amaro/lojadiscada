
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
import br.com.discada.services.MontaGrafico;
import br.com.discada.services.controleCupom;
import com.keypoint.PngEncoder;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@WebServlet(name = "ControleServletPainel", 
                   loadOnStartup = 2,
                   urlPatterns = {"/relatorioVendasGeral", "/listarCupom", "/processaBusca",
                   "/relatorioVendaProduto", "/relatorioVendaData", "/editarCupom", "/consultaNomeCliente",
                   "/controlePedidos", "/editarCategoria", "/adicionarCupomProm", "/consultaNomeProduto",
                   "/detalheClientes", "/editarProduto", "/adicionarCupomTroca", "/pesquisaVendasMes",
                   "/relatorioVendaCategoria", "/adicionarCategoria", "/editarItemPedido", "/pesquisaVendasMesValor",
                   "/controleClientes", "/controleEstoque", "/adicionarProduto", "/pesquisaVendasBean",
                   "/Painel", "/loginAdm", "/addPostagem", "/pesquisaVendas", "/pesquisaVendasBeanValor"})

        
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
         
        
        if(userPath.equals("/pesquisaVendasMes")){
            
          List<Produto> product = (List<Produto>) proDao.getListaObjetos();
          request.setAttribute("produtoscom", product);
          request.getAttribute("produtoscom");
            
          
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
    
    // ------------------------------------------------------------------
        
        else if (userPath.equals ("/Painel")){
            
            List<Produto> product = (List<Produto>) proDao.getListaObjetos();
            request.setAttribute("produtoscom", product);
            request.getAttribute("produtoscom");
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
        
// ------------------------------------------------------------------
        
        else if (userPath.equals("/pesquisaVendasMes")){
            
          
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                     
           String dataInicio = request.getParameter("datainicial");
           String dataFim = request.getParameter("datafinal");
           int dife = 0;
           
           
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
                                soma = soma + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = som1 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto3) { 
                                soma2 = soma2 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto4) { 
                                soma3 = soma3 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto5) { 
                                soma4 = soma4 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto6) { 
                                soma5 = soma5 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto7) { 
                                soma6 = soma6 + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto8) { 
                                soma7 = soma7 + tet.getQuantidade();                                
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
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String defe = request.getParameter("defe");            
            
            if (defe != null && !defe.equals("")){
            int j = 1;    
            response.setContentType("image/PNG");
            OutputStream out = response.getOutputStream();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           
            for (int i = 0; i < testelista.size(); i++) {
                
                int dadosentrada = (int) testelista.get(i);
                dataset.addValue(dadosentrada, "Awaken", "" + testelista2.get(i)); 
                
                int dadosentrada1 = (int) testelista1.get(i);
                dataset.addValue(dadosentrada1, "Black Pumas","" + testelista2.get(i));
                
                int dadosentrada2 = (int) testelista8.get(i);
                dataset.addValue(dadosentrada2, "Alucinação", "" + testelista2.get(i)); 
                
                int dadosentrad = (int) testelista3.get(i);
                dataset.addValue(dadosentrad, "Cartola 1976","" + testelista2.get(i));
                
                int dadosentra = (int) testelista4.get(i);
                dataset.addValue(dadosentra, "Butterfly", "" + testelista2.get(i)); 
                
                int dadosentrada5 = (int) testelista5.get(i);
                dataset.addValue(dadosentrada5, "Legend","" + testelista2.get(i));
                
                int dadosentrada6 = (int) testelista6.get(i);
                dataset.addValue(dadosentrada6, "Novos Baianos", "" + testelista2.get(i)); 
                
                int dadosentrada7 = (int) testelista7.get(i);
                dataset.addValue(dadosentrada7, "Miles Davis","" + testelista2.get(i));
                
                j = j + 1;
            }
           
            JFreeChart cha1 = ChartFactory.createLineChart("Grafico de Vendas à partir de " + dataInicio + " até o dia " + dataFim, "PRODUTOS ANALISADOS ABAIXO || Para Retornar use : Alt + <- ", "Quantidade de Produtos Vendidos", dataset, PlotOrientation.VERTICAL, true, true, true);
            
            
            int baixo = 800;
            int alto = 1250;
            
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            
            
            }  
        }

// -------------------------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/pesquisaVendasMesValor")){
            
          
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                     
           String dataInicio = request.getParameter("datainicial");
           String dataFim = request.getParameter("datafinal");
           int dife = 0;
           
           
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
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = (int) (som1 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto3) { 
                                soma2 = (int) (soma2 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto4) { 
                                soma3 = (int) (soma3 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto5) { 
                                soma4 = (int) (soma4 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto6) { 
                                soma5 = (int) (soma5 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto7) { 
                                soma6 = (int) (soma6 + tet.getValortotalitem());                                
                            }
                            for(Itempedido tet : produto8) { 
                                soma7 = (int) (soma7 + tet.getValortotalitem());                                
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
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String defe = request.getParameter("defe");            
            
            if (defe != null && !defe.equals("")){
            int j = 1;    
            response.setContentType("image/PNG");
            OutputStream out = response.getOutputStream();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           
            for (int i = 0; i < testelista.size(); i++) {
                
                int dadosentrada = (int) testelista.get(i);
                dataset.addValue(dadosentrada, "Awaken", "" + testelista2.get(i)); 
                
                int dadosentrada1 = (int) testelista1.get(i);
                dataset.addValue(dadosentrada1, "Black Pumas","" + testelista2.get(i));
                
                int dadosentrada2 = (int) testelista8.get(i);
                dataset.addValue(dadosentrada2, "Alucinação", "" + testelista2.get(i)); 
                
                int dadosentrad = (int) testelista3.get(i);
                dataset.addValue(dadosentrad, "Cartola 1976","" + testelista2.get(i));
                
                int dadosentra = (int) testelista4.get(i);
                dataset.addValue(dadosentra, "Butterfly", "" + testelista2.get(i)); 
                
                int dadosentrada5 = (int) testelista5.get(i);
                dataset.addValue(dadosentrada5, "Legend","" + testelista2.get(i));
                
                int dadosentrada6 = (int) testelista6.get(i);
                dataset.addValue(dadosentrada6, "Novos Baianos", "" + testelista2.get(i)); 
                
                int dadosentrada7 = (int) testelista7.get(i);
                dataset.addValue(dadosentrada7, "Miles Davis","" + testelista2.get(i));
                
                j = j + 1;
            }
           
            JFreeChart cha1 = ChartFactory.createLineChart("Grafico de Vendas à partir de " + dataInicio + " até o dia " + dataFim, "PRODUTOS ANALISADOS ABAIXO || Para Retornar use : Alt + <- ", "Volume em R$ de Produtos Vendidos", dataset, PlotOrientation.VERTICAL, true, true, true);
            
            
            int baixo = 800;
            int alto = 1250;
            
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            
            
            }  
        }

// --------------------------------------------------------------------------------------------------------------------
// --------------------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/pesquisaVendasBean")){
            
            
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
           
           String produt1 = request.getParameter("produt1");
           String produt2 = request.getParameter("produt2");
           String dataInicio = request.getParameter("datainicial");
           String dataFim = request.getParameter("datafinal");
           int dife = 0;
           
           
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
                
                
                List testelista = new ArrayList();
                List testelista1 = new ArrayList();                
                List testelista2 = new ArrayList();
                
                
                int soma = 0, som1 = 0;                
                
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
                        
                       int produ1 = Integer.parseInt(produt1);
                       int produ2 = Integer.parseInt(produt2);
                        
                        produto1 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), produ1);
                        produto2 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), produ2);
                        
                        
                            for(Itempedido tet : produto1) { 
                                soma = soma + tet.getQuantidade();                                
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = som1 + tet.getQuantidade();                                
                            }
                            
                           
                        
                            
                        String datafor2 = formato.format(calFinal.getTime());
                        
                        testelista.add(soma);
                        testelista1.add(som1);
                        
                        
                        firstD = finalD2;
                        soma = 0; som1 = 0; 
                  
                }
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String defe = request.getParameter("defe");            
            
            if (defe != null && !defe.equals("")){
            int j = 1;    
            response.setContentType("image/PNG");
            OutputStream out = response.getOutputStream();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           
            for (int i = 0; i < testelista.size(); i++) {
                
                int dadosentrada = (int) testelista.get(i);
                dataset.addValue(dadosentrada, "Awaken", "" + testelista2.get(i)); 
                
                int dadosentrada1 = (int) testelista1.get(i);
                dataset.addValue(dadosentrada1, "Black Pumas","" + testelista2.get(i));
                
                                
                j = j + 1;
            }
           
            JFreeChart cha1 = ChartFactory.createLineChart("Grafico de Vendas à partir de " + dataInicio + " até o dia " + dataFim, "PRODUTOS ANALISADOS ABAIXO || Para Retornar use : Alt + <- ", "Quantidade de Produtos Vendidos", dataset, PlotOrientation.VERTICAL, true, true, true);
            
            
            int baixo = 800;
            int alto = 1250;
            
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            
            
            }  
            
            
        }
        
  // --------------------------------------------------------------------------------------------------------------------
        
        else if (userPath.equals("/pesquisaVendasBeanValor")){
            
            
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
           
           String produt1 = request.getParameter("produt1");
           String produt2 = request.getParameter("produt2");
           String dataInicio = request.getParameter("datainicial");
           String dataFim = request.getParameter("datafinal");
           int dife = 0;
           
           
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
                
                
                List testelista = new ArrayList();
                List testelista1 = new ArrayList();                
                List testelista2 = new ArrayList();
                
                
                int soma = 0, som1 = 0;                
                
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
                        
                       int produ1 = Integer.parseInt(produt1);
                       int produ2 = Integer.parseInt(produt2);
                        
                        produto1 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), produ1);
                        produto2 = (List<Itempedido>) itemDao.listarPorDataCategoria(cal.getTime(), calFinal.getTime(), produ2);
                        
                        
                            for(Itempedido tet : produto1) { 
                                soma = (int) (soma + tet.getValoritem());                                
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = (int) (soma + tet.getValoritem());                                  
                            }
                            
                           
                        
                            
                        String datafor2 = formato.format(calFinal.getTime());
                        
                        testelista.add(soma);
                        testelista1.add(som1);
                        
                        
                        firstD = finalD2;
                        soma = 0; som1 = 0; 
                  
                }
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            String defe = request.getParameter("defe");            
            
            if (defe != null && !defe.equals("")){
            int j = 1;    
            response.setContentType("image/PNG");
            OutputStream out = response.getOutputStream();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
           
            for (int i = 0; i < testelista.size(); i++) {
                
                int dadosentrada = (int) testelista.get(i);
                dataset.addValue(dadosentrada, "Awaken", "" + testelista2.get(i)); 
                
                int dadosentrada1 = (int) testelista1.get(i);
                dataset.addValue(dadosentrada1, "Black Pumas","" + testelista2.get(i));
                
                                
                j = j + 1;
            }
           
            JFreeChart cha1 = ChartFactory.createLineChart("Grafico de Vendas à partir de " + dataInicio + " até o dia " + dataFim, "PRODUTOS ANALISADOS ABAIXO || Para Retornar use : Alt + <- ", "Volume em R$ de Produtos Vendidos", dataset, PlotOrientation.VERTICAL, true, true, true);
            
            
            int baixo = 800;
            int alto = 1250;
            
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            
            
            }  
            
            
        }
        
 // -----------------------------------------------------------------------------------------------------------------       
        else if (userPath.equals ("/Painel")){
            
            
             // Parte de baixo é a consulta no banco que utilizaremos depois que o gráfico funcionar
    
    
           SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                     
            String prod = request.getParameter("produt1");
            String prod2 = request.getParameter("produt2");
            String dataInicio = request.getParameter("datainicial");
            String dataFim = request.getParameter("datafinal");
            
            
            if(dataInicio != null && !dataInicio.isEmpty()){

                try {
                    //int dias = Days.daysBetween(dataInicio, dataFim).getDays();
                    Date firstDt = formato.parse(dataInicio);
                    Date finalDt = formato.parse(dataFim);
                    
                    int pro = Integer.parseInt(prod);
                    int pro2 = Integer.parseInt(prod2);

                    MontaGrafico novoGrafico = new MontaGrafico();
                    MontaGrafico novoGrafico2 = new MontaGrafico();


                    novoGrafico = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, pro);                                               
                    novoGrafico2 = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, pro2);                                               
                    
                    
                    request.setAttribute("npro1", novoGrafico.getNomepr());
                    request.getAttribute("npro1");
                    
                    request.setAttribute("spro1", novoGrafico.getSomqtd());
                    request.getAttribute("spro1");
                    
                    request.setAttribute("vpro1", novoGrafico.getSomvlr());
                    request.getAttribute("vpro1");
                    
                    request.setAttribute("npro2", novoGrafico2.getNomepr());
                    request.getAttribute("npro2");
                    
                    request.setAttribute("spro2", novoGrafico2.getSomqtd());
                    request.getAttribute("spro2");
                    
                    request.setAttribute("vpro2", novoGrafico2.getSomvlr());
                    request.getAttribute("vpro2");
                
                  
                
                /*request.setAttribute("prodOne", json2);
                request.getAttribute("prodOne");
                /*request.setAttribute("prodOneUm", tett.getNomepr());
                request.getAttribute("prodOneUm");
                request.setAttribute("prodOneDois", tett.getSomvlr());
                request.getAttribute("prodOneDois");
                
                tett = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, 3);                                               
                request.setAttribute("prodTw", tett.getSomqtd());
                request.getAttribute("prodTw");
                request.setAttribute("prodTwOne", tett.getNomepr());
                request.getAttribute("prodTwOne");
                request.setAttribute("prodTwDois", tett.getSomvlr());
                request.getAttribute("prodTwDois");*/
                
         
                
                
                
               
                
                } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
            }       
                userPath = "/Painel";  
            
            
         /*             
            
            String defe = request.getParameter("defe");
            
            
            if (defe != null && !defe.equals("")){
                
            response.setContentType("image/PNG");
            OutputStream out = response.getOutputStream();
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            
            
            dataset.addValue(3, "Produto 1", "Dia 1");             
            dataset.addValue(10, "Produto 1",  "Dia 2");
            dataset.addValue(8, "Produto 1", "Dia 3");
            
            dataset.addValue(6, "Produto 2", "Dia 1");
            dataset.addValue(1, "Produto 2",  "Dia 2");
            dataset.addValue(4, "Produto 2", "Dia 3");
            
            dataset.addValue(9, "Produto 3", "Dia 1");
            dataset.addValue(9, "Produto 3",  "Dia 2");
            dataset.addValue(2, "Produto 3", "Dia 3");
            
            JFreeChart cha = ChartFactory.createBarChart("Grafico Teste", "Dias Contados", "Quantidad del Productos", dataset, PlotOrientation.VERTICAL, true, true, false);
            JFreeChart cha1 = ChartFactory.createLineChart("Título", "Produtos", "Quantidad", dataset, PlotOrientation.VERTICAL, true, true, true);
            
            
            int baixo = 600;
            int alto = 750;
            
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            ChartUtilities.writeChartAsPNG(out, cha1, alto, baixo);
            
            
            }
            
    // Parte de baixo é a consulta no banco que utilizaremos depois que o gráfico funcionar
    
    
           /* SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                     
             
            String dataInicio = request.getParameter("datainicial");
            String dataFim = request.getParameter("datafinal");
            
            request.setAttribute("prodOne", dataInicio);
            request.getAttribute("prodOne");
            
            
            if(dataInicio != null && !dataInicio.isEmpty()){

                try {
                    //int dias = Days.daysBetween(dataInicio, dataFim).getDays();
                    Date firstDt = formato.parse(dataInicio);
                    Date finalDt = formato.parse(dataFim);

                    MontaGrafico novoGrafico = new MontaGrafico();
                    MontaGrafico novoGrafico2 = new MontaGrafico();


                    novoGrafico = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, 1);                                               
                    novoGrafico2 = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, 2);                                               
                    //ObjectMapper mapper = new ObjectMapper();
                    
                   //String json = mapper.writeValueAsString(novoGrafico);                    
                    //response.getWriter().write(json);
                    
                    //request.setAttribute("testeUm", json);
                    request.getAttribute("testeUm");
                    
                
                novoGrafico.getSomqtd();
                
                
                
                /*request.setAttribute("prodOne", json2);
                request.getAttribute("prodOne");
                /*request.setAttribute("prodOneUm", tett.getNomepr());
                request.getAttribute("prodOneUm");
                request.setAttribute("prodOneDois", tett.getSomvlr());
                request.getAttribute("prodOneDois");
                
                tett = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, 3);                                               
                request.setAttribute("prodTw", tett.getSomqtd());
                request.getAttribute("prodTw");
                request.setAttribute("prodTwOne", tett.getNomepr());
                request.getAttribute("prodTwOne");
                request.setAttribute("prodTwDois", tett.getSomvlr());
                request.getAttribute("prodTwDois");
                
         
                
                
                
               
                
                } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
                    }
              
            }       
                userPath = "/Painel";  */ 
            
            
           
               
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
