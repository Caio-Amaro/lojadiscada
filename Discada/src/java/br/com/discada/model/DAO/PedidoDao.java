
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Pedido;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PedidoDao<TIPO> extends DaoGenerico<Pedido> implements Serializable {
    
    List<TIPO> suporte;
    
    public PedidoDao(){
        
        super();
        classePersistence = Pedido.class;
        unidade = "p";
    
    }
    
      public List<TIPO> ListarPedido(int id)
    {
        String jpql = "Select p From " + classePersistence.getSimpleName() + 
                " p Where p.idcliente.cliid = :pedid ORDER BY p.data DESC";
        return em.createQuery(jpql).setParameter("pedid", id)
                .getResultList();        
    }
      
    public List<Pedido> listarPorData(Date datainicio, Date datafim)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p FROM Pedido p ");
        
        if(datainicio != null && datafim != null){
        
            sql.append("WHERE p.data BETWEEN :dataInicio AND :dataFim ");
        
        }
        
        sql.append("ORDER BY p.data DESC");
        
            return em.createQuery(sql.toString())
                .setParameter("dataInicio", datainicio)
                .setParameter("dataFim", datafim)
                .getResultList();
  
    }
    
     public List<Pedido> listarPorDataIdCliente(int idcliente)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p FROM Pedido p ");
        sql.append("WHERE p.idcliente.cliid = :idcliente ORDER BY p.data DESC");
        
            return em.createQuery(sql.toString())
                .setParameter("idcliente", idcliente)
                .getResultList();
  
    }
     
     public List<Pedido> listarPorDataId(Date datainicio, Date datafim, int idcliente)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p FROM Pedido p ");
        sql.append("WHERE p.idcliente.cliid = :idcliente AND ");
        
        if(datainicio != null && datafim != null){
        
            sql.append("p.data BETWEEN :dataInicio AND :dataFim ");
        
        }
        
        sql.append("ORDER BY p.data DESC");
        
            return em.createQuery(sql.toString())
                .setParameter("dataInicio", datainicio)
                .setParameter("dataFim", datafim)
                .setParameter("idcliente", idcliente)
                .getResultList();
  
    } 
     
    
   
}
