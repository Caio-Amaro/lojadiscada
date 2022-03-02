
package br.com.discada.model.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class DaoGenerico<TIPO> implements Serializable{
    
    private List<TIPO> listaObjetos;    
   @PersistenceContext(unitName = "DiscadaPU")
    protected EntityManager em;
    protected  Class classePersistence;
    protected String unidade;
    
    
    public DaoGenerico(){}

    public List<TIPO> getListaObjetos() {
        
        String jpql = "SELECT " + unidade + " FROM " + classePersistence.getSimpleName() + " " + unidade;
        return em.createQuery(jpql).getResultList();
    }
   
    
    public void persist(TIPO obj) throws Exception 
    {
        em.persist(obj);
    }
    
    public void merge(TIPO obj) throws Exception 
    {
        em.merge(obj);
    }
    
    public void remover(TIPO obj) throws Exception 
    {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public TIPO getObjectById(Object id) throws Exception
    {
        return(TIPO) em.find(classePersistence, id);
    }
    
   

    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassePersistence() {
        return classePersistence;
    }

    public void setClassePersistence(Class classePersistence) {
        this.classePersistence = classePersistence;
    }
    
    
    
}
