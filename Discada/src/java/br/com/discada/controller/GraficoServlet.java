
package br.com.discada.controller;

import br.com.discada.model.DAO.ItemPedidoDao;
import br.com.discada.services.MontaGrafico;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "GraficoServlet", 
        loadOnStartup = 3,
        urlPatterns = {"/PainelGrafico", "/PaginaGrafico"})



public class GraficoServlet extends HttpServlet {

    
@EJB
private ItemPedidoDao itemDao;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        //processRequest(request, response);
        
        if(userPath.equals("/PainelGrafico")){
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            
            String dataInicio = "31/03/2022";//request.getParameter("datainicial");
            String dataFim = "04/05/2022";//request.getParameter("datafinal");
            
            //request.setAttribute("prodOne", dataInicio);
            //request.getAttribute("prodOne");
            
            
            if(dataInicio != null && !dataInicio.isEmpty()){

                try {
                    //int dias = Days.daysBetween(dataInicio, dataFim).getDays();
                    Date firstDt = formato.parse(dataInicio);
                    Date finalDt = formato.parse(dataFim);

                    MontaGrafico tett = new MontaGrafico();


                    tett = (MontaGrafico) itemDao.listarPorDataProduto(firstDt, finalDt, 1);                                               

                    /*ObjectMapper mapper = new ObjectMapper();                    
                    String json = mapper.writeValueAsString(tett);                    
                    response.getWriter().write(json);*/
                    
                    Gson gson = new Gson();
                    response.setContentType("application/json");
                    PrintWriter out = response.getWriter();
                    out.println(gson.toJson(tett));
                    
                    
                    
                    
                    
                    /*request.setAttribute("testeUm", gson);
                    request.getAttribute("testeUm");
                    */
                    
                    
                    
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
                
        
    }
//-----------------------------------------------------------------------------------------------------------------

 if(userPath.equals("/PaginaGrafico")){
     
     String url = "/WEB-INF/viewsPainel" + userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
     
 }

}

// =================================================================================================================
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
