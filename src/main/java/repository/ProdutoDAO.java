package repository;

import modelo.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class ProdutoDAO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2726288256854282707L;
	
	@PersistenceContext
    private EntityManager em;

    @Transactional
    public void salvar(Produto p){
    	
        em.persist(p);
        System.out.println("Salvando produto...");
       
    }

    public List<Produto> consultar(){
    	
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
        
    }

    @Transactional
    public void remover(Produto p){
    	
        //p = em.find(Produto.class,p.getId());
        //em.remove(p);
        em.remove(em.contains(p) ? p : em.merge(p));
        
    }

    @Transactional
    public void editar(Produto p){
    	
        //Produto p1 = em.find(Produto.class,p.getId());
        //p1 = p;
        em.merge(p);
        
    }
    
}
