
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Statuspostagem;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class TipoPostagemDao<TIPO> extends DaoGenerico<Statuspostagem> implements Serializable {
    
    public TipoPostagemDao()
    {
        super();
        classePersistence = Statuspostagem.class;
        unidade = "s";
    
    }
}
