
package br.com.discada.model.DAO;

//import Cart.ShoppingCartItem;
import br.com.discada.model.jpa.Itempedido;
import br.com.discada.model.jpa.Pedido;
import br.com.discada.model.jpa.Produto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;

@Stateless
public class ItemPedidoDao<TIPO> extends DaoGenerico<Itempedido> implements Serializable {
    
    List<Itempedido> listaIte;
    List<Itempedido> listaGeralIte;
    public int somaquanty;
    public double valorFinal;
    public String elementoNome;
    public int somaquantyGeral;
    public double valorFinalGeral;
    int cont = 0;
    
    public ItemPedidoDao()
    {
        super();
        classePersistence = Itempedido.class;
        unidade = "i";
        
    }
    
     public List<Itempedido> listarItemPedido(int id)
    {
        String jpql = "Select i From " + classePersistence.getSimpleName() + 
                " i Where i.idped.idpedido = :itmid";
        
        listaGeralIte = em.createQuery(jpql).setParameter("itmid", id)
                .getResultList();
        
        return listaGeralIte;
        
    }
     
     // ----------------------------------------------------------------------------------------
     
      public List<Itempedido> listarPorDataCategoria(Date datainicio, Date datafim, int idpr)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT i FROM Itempedido i ");
        
        if(datainicio != null && datafim != null){
        
            sql.append("WHERE i.idped.data BETWEEN :dataInicio AND :dataFim ");
        
        }
        sql.append("AND i.idpro.proid = :idp");
        
        //sql.append("ORDER BY p.data");
        
            listaIte=  em.createQuery(sql.toString())
                .setParameter("dataInicio", datainicio)
                .setParameter("idp", idpr)
                .setParameter("dataFim", datafim)
                .getResultList();
            
            return listaIte;
  
    }
    
      // ----------------------------------------------------------------------------------
      
      public void ListaVer ()
      {
          Produto prod = new Produto();
          
          for (Itempedido lisa : listaGeralIte){
              
                            
         this.somaquanty = cont + 1;
         this.valorFinal = this.valorFinal + lisa.getValortotalitem();
      }
      }

    // ----------------------------------------------------------------------------------------------
      public void ListaGeralVer ()
      {
          Produto prod = new Produto();
          
          for (Itempedido lis : listaIte){
              
              if (cont <= 1 && Objects.equals(prod.getProid(), lis.getIdpro())) {
              
                  this.elementoNome = prod.getPronome();
              
              }
              
         this.somaquanty = cont + 1;
         this.valorFinal = this.valorFinal + lis.getValortotalitem();
      }
      }

    
}
