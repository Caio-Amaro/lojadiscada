
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Cupom;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;

@Stateful
public class CupomDao<TIPO> extends DaoGenerico<Cupom> implements Serializable {
    
    public CupomDao(){
    
        super();
        classePersistence = Cupom.class;
        unidade = "c";
        
    }
    
      public List<TIPO> ListarCupom(int id)
    {
        String jpql = "Select c From " + classePersistence.getSimpleName() + 
                " c Where c.idclientecup.cliid = :cupid";
        return em.createQuery(jpql).setParameter("cupid", id)
                .getResultList();
        
    }
    
    
}
