
package br.com.discada.model.jpa;

import br.com.discada.services.*;
import java.util.*;

public class GraficoProdutos {
    
    private List<GerarGraficoMontado> lista;
    
    public List<GerarGraficoMontado> findAll(){
    
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        /* if(lista != null) {
            for (GerarGraficoMontado lis : lista) {

                produtos.add(new GerarGraficoMontado(lis.getDias(), lis.getValor(), lis.getValor2()));
            }
        } else{ 
         produtos.add(new GerarGraficoMontado(1, 10, 17));
         produtos.add(new GerarGraficoMontado(2, 12, 16));
         produtos.add(new GerarGraficoMontado(3, 13, 9));
         }*/
        produtos.add(new GerarGraficoMontado("Produto", 17));
        produtos.add(new GerarGraficoMontado("Produto", 12));
        produtos.add(new GerarGraficoMontado("Produto", 13));
        
        
       
        return produtos;
    
    }
    
     public List<GerarGraficoMontado> findAllList(List<GerarGraficoMontado> lis){
         
        int n = lis.size();
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        for (GerarGraficoMontado li : lis) {
            produtos.add(new GerarGraficoMontado(li.getNome(), li.getValor()));
        }
        
        return produtos;
    
    }
     
    
    public List<GerarGraficoMontado> findAllListDois(int valor, int valor1, int valor2, int valor3, 
            int valor4, int valor5, int valor6, int valor7){
        List<GerarGraficoMontado> produtos = new ArrayList<GerarGraficoMontado>();
        
        produtos.add(new GerarGraficoMontado("Awaken, My Love!", valor));
        produtos.add(new GerarGraficoMontado("Black Pumas", valor1));
        produtos.add(new GerarGraficoMontado("Alucinação", valor2));
        produtos.add(new GerarGraficoMontado("Cartola 1976", valor3));
        produtos.add(new GerarGraficoMontado("To Pimp a Butterfly", valor4));
        produtos.add(new GerarGraficoMontado("Legend", valor5));
        produtos.add(new GerarGraficoMontado("Novos Baianos, Acabou Chorare", valor6));
        produtos.add(new GerarGraficoMontado("Kind of Blue - Miles Davis", valor7));
       
        return produtos;
       
       
        
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
   
    
}
