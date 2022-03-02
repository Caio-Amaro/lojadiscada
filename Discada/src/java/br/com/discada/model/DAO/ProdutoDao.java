
package br.com.discada.model.DAO;

import br.com.discada.model.jpa.Itempedido;
import br.com.discada.model.jpa.Produto;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class ProdutoDao<TIPO> extends DaoGenerico<Produto> implements Serializable{
   
    public ProdutoDao() {
        super();
        classePersistence = Produto.class;
        unidade = "e";
    }
    
    public List<Produto> listarProdutoTeste(int id)
    {
        String jpql = "Select p From " + classePersistence.getSimpleName() + " p Where p.prolargura = :idproduto";
        return em.createQuery(jpql).setParameter("idproduto", id)              
                .getResultList();
    
    }
    
    
    public List<Produto> listarPorNomeProduto(String nome)
    {
         StringBuilder sql = new StringBuilder();
        sql.append("SELECT p FROM Produto p ");
        sql.append("WHERE p.pronome LIKE :nome ");
    
    return em.createQuery(sql.toString())
        .setParameter("nome", "%" + nome + "%").getResultList();
    
   
    }
    
     public List<Produto> listarPorNomeCategoria(int idcat)
    {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p FROM Produto p ");
        sql.append("WHERE p.proidcategoria.catid = :idcat");
    
    return em.createQuery(sql.toString())
        .setParameter("idcat", idcat).getResultList();
    
   
    }
     
    
    
}
