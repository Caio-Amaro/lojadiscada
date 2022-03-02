
package br.com.discada.model.DAO;


import br.com.discada.model.jpa.Cartaocredi;
import br.com.discada.model.jpa.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class CartaocrediDao<TIPO> extends DaoGenerico<Cartaocredi> implements Serializable {
    
    public CartaocrediDao()
    {
        super();
        classePersistence = Cartaocredi.class;
        unidade = "c"; 
    }
    
     public List<TIPO> ListarCartao(int id)
    {
        String jpql = "Select c From " + classePersistence.getSimpleName() + 
                " c Where c.creidcliente.cliid = :creid";
        return em.createQuery(jpql).setParameter("creid", id)
                .getResultList();
        
    }
     
      public List<Cartaocredi>listarCartaoPorIdCliente(int idclie)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT c FROM Cartaocredi c ");
        sql.append("WHERE c.creidcliente.cliid = :idclie");
        
        return em.createQuery(sql.toString())                
                .setParameter("idclie", idclie)
                .getResultList();
            
  
    }
    
    
    
    
}

