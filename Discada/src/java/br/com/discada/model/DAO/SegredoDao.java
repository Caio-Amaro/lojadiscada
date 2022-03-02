
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Segredo;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateful;


@Stateful
public class SegredoDao<TIPO> extends DaoGenerico<Segredo> implements Serializable{
    
    private boolean acesso;
    
    public SegredoDao() 
    {
        super();
        classePersistence = Segredo.class;
        unidade = "s";
        acesso = false;
    
    }
    
    public List<Segredo> buscaUsuario (String login, String senha)
    {
      StringBuilder sql = new StringBuilder();
      sql.append("SELECT s FROM Segredo s ");
      sql.append("WHERE s.seclogin = :login AND s.secsenha = :senha ");
        
        return em.createQuery(sql.toString())
                .setParameter("login", login)
                .setParameter("senha", senha).getResultList();
    
    }

    public boolean isAcesso() {
        return acesso;
    }

    public void setAcesso(boolean acesso) {
        this.acesso = acesso;
    }
    
    public boolean chaveAcesso () {
    
        return this.acesso;    
    }
   
}
