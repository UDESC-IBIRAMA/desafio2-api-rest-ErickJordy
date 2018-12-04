package DAO;


import MODEL.Montadora;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import Exc.NonexistentEntityException;
import Exc.RollbackFailureException;

/**
 *
 * @author Erick
 */
public class MontadoraDAO implements Serializable {

    public MontadoraDAO(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Montadora montadora) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(montadora);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Montadora montadora) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            montadora = em.merge(montadora);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = montadora.getId_montadora();
                if (findMontadora(id) == null) {
                    throw new NonexistentEntityException(id + " no exists");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Montadora montadora;
            try {
                montadora = em.getReference(Montadora.class, id);
                montadora.getId_montadora();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException(id + "no longer", enfe);
            }
            em.remove(montadora);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
   
    public List<Montadora> findMontadoraEntities(int maxResults, int firstResult) {
        return findMontadoraEntities(false, maxResults, firstResult);
    }

    private List<Montadora> findMontadoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Montadora.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Montadora> findMontadoraEntities() {
        return findMontadoraEntities(true, -1, -1);
    }
    
    public int getMontadoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Montadora> rt = cq.from(Montadora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Montadora findMontadora(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Montadora.class, id);
        } finally {
            em.close();
        }
    }
    
}
