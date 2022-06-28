
package br.com.discada.controller;

import br.com.discada.model.DAO.ItemPedidoDao;
import br.com.discada.model.jpa.GraficoProdutos;
import br.com.discada.model.jpa.Itempedido;
import br.com.discada.services.GerarGraficoMontado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;


public class ChartServlet extends HttpServlet {

    @EJB
    private ItemPedidoDao itemDao;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {  
        
        String userPath = request.getServletPath();      
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
                        /*soma = 0; som1 = 0; soma2= 0; soma3 = 0; soma4 = 0; 
                        soma5 = 0; soma6 = 0; soma7 = 0;*/
                  
                }
                produtos.add(new GerarGraficoMontado("Awaken, My Love!", so));
                produtos.add(new GerarGraficoMontado("Black Pumas", so1));
                produtos.add(new GerarGraficoMontado("Alucinação", so2));
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
                out.println(gson.toJson(prod.findAllList(produtos)));
                
                userPath = "/chart"; 
            
            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        }else{ 
        
            GraficoProdutos prod = new GraficoProdutos();
            
             Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAllList(produtos)));
            userPath = "/chart"; 
        }
           
        
        //response.sendRedirect(request.getContextPath() + "/AnaliseChart");
           
        }
        

// ----------------------------------------------------------------------------------------------
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
         
       
        String dataInicial = request.getParameter("dataInicial");
        String dataFinal = request.getParameter("dataFinal");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        List testelista = new ArrayList();
        List testelista1 = new ArrayList();                
        List testelista2 = new ArrayList();
        List listaProdutosGrafico = new ArrayList();
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        if (dataInicial != null && dataFinal != null) {

        String produt1 = "1";//request.getParameter("produt1");
        String produt2 = "2";//request.getParameter("produt2");
        String dataInicio = request.getParameter("dataInicial");
        String dataFim = request.getParameter("dataFinal");
        String nome1 = "";
        String nome2 = "";
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


               


                int soma = 0, som1 = 0;                

            try {
                Date firstD;
                Date finalD2;
                firstD = formato.parse(dataInicio);
                finalD2 = formato.parse(dataFim);

                GraficoProdutos produtosGera = new GraficoProdutos();
                GerarGraficoMontado gera = new GerarGraficoMontado();

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
                                nome1 = tet.getIdpro().getPronome();
                            }
                            for(Itempedido tet : produto2) { 
                                som1 = som1 + tet.getQuantidade(); 
                                nome2 = tet.getIdpro().getPronome();
                            }


                        String datafor2 = formato.format(calFinal.getTime());

                        testelista.add(soma);
                        testelista1.add(som1);
                        
                                
                        produtos.add(new GerarGraficoMontado(nome1, soma));
                                                
                        
                        firstD = finalD2;
                        soma = 0; som1 = 0; 

                }
                GraficoProdutos prod = new GraficoProdutos();
            
                Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAll()));
                //out.println(gson.toJson(produtos));
                
                
                

            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }
                

        } 
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
