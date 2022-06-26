
package br.com.discada.model.jpa;

import br.com.discada.services.*;
import java.util.*;

public class GraficoProdutos {
    
    private List<GerarGraficoMontado> lista;
    
    public List<GerarGraficoMontado> findAll(){
    
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        produtos.add(new GerarGraficoMontado(10, 10, 10));
        
        
        
        
        
        return produtos;
    
    }
    
     public List<GerarGraficoMontado> findAllList(List lista){
    
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        
        
        for (Iterator it = lista.iterator(); it.hasNext();) {
            
            int j = 0;
            int entra = (int) lista.get(j);
            int entra1 = (int) lista.get(+1);
            int entra2 = (int) lista.get(+2);
            produtos.add(new GerarGraficoMontado(entra, entra1, entra2));
        }    
            
        
        
        return produtos;
    
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
   
    
}
