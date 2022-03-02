
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Categoria;
import java.io.Serializable;
import javax.ejb.Stateful;


@Stateful
public class CategoriaDao<TIPO> extends DaoGenerico<Categoria> implements Serializable {
    
    public CategoriaDao(){
        
    super();
    classePersistence = Categoria.class;
    unidade = "c";
    
    }
}
