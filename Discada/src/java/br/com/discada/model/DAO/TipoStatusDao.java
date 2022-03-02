
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Tipostatus;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class TipoStatusDao<TIPO> extends DaoGenerico<Tipostatus> implements Serializable {
    
    public TipoStatusDao()
    {
        super();
        classePersistence = Tipostatus.class;
        unidade ="t";
    
    }
    
    
}
