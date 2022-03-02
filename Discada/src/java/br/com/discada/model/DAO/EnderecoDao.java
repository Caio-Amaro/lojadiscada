
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Endereco;
import br.com.discada.model.jpa.Itempedido;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class EnderecoDao<TIPO> extends DaoGenerico<Endereco> implements Serializable{

    public EnderecoDao() {
        super();
        classePersistence = Endereco.class;
        unidade = "e";
    }
    
    public List<TIPO> listarEndereco(int id)
    {
        String jpql = "Select e From " + classePersistence.getSimpleName() + 
                " e Where e.endidcliente.cliid = :endid";
        return em.createQuery(jpql).setParameter("endid", id)
                .getResultList();
        
    }
    
    
     public List<Endereco>listarEnderecoPorIdCliente(int idclie)
    {            
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT e FROM Endereco e ");
        sql.append("WHERE e.endidcliente.cliid = :idclie");
        
        return em.createQuery(sql.toString())                
                .setParameter("idclie", idclie)
                .getResultList();
            
  
    }
    
    
}
