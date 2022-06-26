/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        
     /*  
        String dataInicial = request.getParameter("dataInicial");
        String dataFinal = request.getParameter("dataFinal");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
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


                List testelista = new ArrayList();
                List testelista1 = new ArrayList();                
                List testelista2 = new ArrayList();
                List listaProdutosGrafico = new ArrayList();


                int soma = 0, som1 = 0;                

            try {
                Date firstD;
                Date finalD2;
                firstD = formato.parse(dataInicio);
                finalD2 = formato.parse(dataFim);

                GraficoProdutos produtosGera = new GraficoProdutos();

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

                        listaProdutosGrafico.add(i+1);
                        listaProdutosGrafico.add(soma);
                        listaProdutosGrafico.add(som1);



                        firstD = finalD2;
                        soma = 0; som1 = 0; 

                }

                //produtosGera.setLista(listaProdutosGrafico);
                GraficoProdutos prod = new GraficoProdutos();
                Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAllList(listaProdutosGrafico)));
                

            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
        
        GraficoProdutos prod = new GraficoProdutos();
        Gson gson = new Gson();
        
        
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(prod.findAll()));
        
       }*/
    }

// ----------------------------------------------------------------------------------------------
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
       
        String dataInicial = request.getParameter("dataInicial");
        String dataFinal = request.getParameter("dataFinal");
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
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


                List testelista = new ArrayList();
                List testelista1 = new ArrayList();                
                List testelista2 = new ArrayList();
                List listaProdutosGrafico = new ArrayList();


                int soma = 0, som1 = 0;                

            try {
                Date firstD;
                Date finalD2;
                firstD = formato.parse(dataInicio);
                finalD2 = formato.parse(dataFim);

                GraficoProdutos produtosGera = new GraficoProdutos();

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

                        listaProdutosGrafico.add(i+1);
                        listaProdutosGrafico.add(soma);
                        listaProdutosGrafico.add(som1);



                        firstD = finalD2;
                        soma = 0; som1 = 0; 

                }

                //produtosGera.setLista(listaProdutosGrafico);
                GraficoProdutos prod = new GraficoProdutos();
                Gson gson = new Gson();
                response.setContentType("application/json");
                PrintWriter out = response.getWriter();
                out.println(gson.toJson(prod.findAllList(listaProdutosGrafico)));
                

            } catch (ParseException ex) {
                Logger.getLogger(ControleServletPainel.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
        
        GraficoProdutos prod = new GraficoProdutos();
        Gson gson = new Gson();
        
        
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(prod.findAll()));
        
       }
       
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
