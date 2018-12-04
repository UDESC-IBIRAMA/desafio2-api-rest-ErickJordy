package Service;

import MODEL.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Erick
 */
public abstract class Factr<T> {

    private Class<T> entityClass;

    public Factr(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    public List<Veiculo> procuraCor(String cor) {
        Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  WHERE veic.cor = :cor");
        query.setParameter("cor",cor); 
        return query.getResultList();
    }
    
    public List<Veiculo> procuraMotor(double motor) {
        Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  WHERE veic.motor = :motor");
        query.setParameter("motor",motor); 
        return query.getResultList();
    }
    
     public List<Veiculo> procuraQuilometragem(int quilometragem) {
        Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  WHERE veic.quilometragem = :quilometragem");
        query.setParameter("quilometragem",quilometragem); 
        return query.getResultList();
    }
    
     public List<Veiculo> findTipo(String tipo) {
        Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  WHERE veic.tipo = :tipo");
        query.setParameter("tipo",tipo); 
        return query.getResultList();
    } 
      public List<Veiculo> procuraTipoCor(String tipo,String cor) {
        Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  WHERE veic.tipo = :tipo  and veic.cor=:cor");
        query.setParameter("tipo",tipo);
        query.setParameter("cor",cor);
        return query.getResultList();
    }
    
      public List<Veiculo> procuraTipoQuilometragem(String tipo, int quilometragem){
         Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.tipo =:tipo and veic.quilometragem=:quilometragem");
         query.setParameter("tipo", tipo);
         query.setParameter("quilometragem",quilometragem);
         return query.getResultList();
      }
      
      public List<Veiculo> procuraTipoMotor(String tipo, double motor){
         Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.tipo =:tipo and veic.motor=:motor");
         query.setParameter("tipo", tipo);
         query.setParameter("motor",motor);
         return query.getResultList();
      }
      
      public List<Veiculo> veiculoMotorMaximo(double valorMaximo){
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.motor< :valorMaximo");
          query.setParameter("valorMaximo", valorMaximo);
          return query.getResultList();
      }
      
      public List<Veiculo> veiculoMotorMinimo(double valorMinimo){
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.motor> :valorMinimo");
          query.setParameter("valorMinimo", valorMinimo);
          return query.getResultList();
      }
      
      
      public List<Veiculo> veiculosKMMenor(int valorMaximo){
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.quilometragem < :valorMaximo");
          query.setParameter("valorMaximo", valorMaximo);
          return query.getResultList();
      }
      
      public List<Veiculo> veiculosKMMaior(int valorMinimo){
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  where veic.quilometragem > :valorMinimo");
          query.setParameter("valorMinimo", valorMinimo);
          return query.getResultList();
      }                  
      
      public List<Veiculo> procuraTipoMontadora(String tipo,String nome){
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  LEFT JOIN veic.montadora m WHERE veic.tipo=:tipo and m.nome =:nome");
          query.setParameter("tipo",tipo);
          query.setParameter("nome",nome);
          return query.getResultList();
      }
      
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        
        return ((Long) q.getSingleResult()).intValue();
    }

   
   public List<Veiculo> procuraMontadora(String nome) {
          Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  LEFT JOIN veic.montadora m WHERE  m.nome =:nome");
          query.setParameter("nome",nome);
          return query.getResultList();
    
    }
   
    public List<Veiculo> procuraModelo(String nome) {
         Query query = getEntityManager().createQuery("SELECT veic  FROM Veiculo veic  LEFT JOIN veic.modelo m WHERE m.nome =:nome");
          query.setParameter("nome",nome);
          return query.getResultList();
    }
    
}
