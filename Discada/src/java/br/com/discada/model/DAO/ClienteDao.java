
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Clientes;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class ClienteDao<TIPO> extends DaoGenerico<Clientes> implements Serializable {
 
   
    
    public ClienteDao()
    {
        super();
        classePersistence = Clientes.class;
        unidade = "c";
   
    }
    
    
    public List<Clientes> pegarClienteSegredo (int id) {
    
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT c FROM Clientes c ");
    sql.append("WHERE c.idsegredo.secid = :id");
    
    return em.createQuery(sql.toString())
        .setParameter("id", id).getResultList();
  
    }
    
     public List<Clientes> listarPorNomeCliente(String nome)
    {
         StringBuilder sql = new StringBuilder();
        sql.append("SELECT c FROM Clientes c ");
        sql.append("WHERE c.clinome LIKE :nome ");
    
    return em.createQuery(sql.toString())
        .setParameter("nome", "%" + nome + "%").getResultList();
    
   
    }
    

   
    
}
