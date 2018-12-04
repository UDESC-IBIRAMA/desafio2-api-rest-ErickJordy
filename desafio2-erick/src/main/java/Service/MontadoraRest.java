package Service;

import MODEL.Montadora;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Erick
 */
@Stateless
@Path("model.montadora")
public class MontadoraRest extends Factr<Montadora> {

    @PersistenceContext(unitName = "PersistenceEric")
    private EntityManager em;

    public MontadoraRest() {
        super(Montadora.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Montadora entity) {
        super.create(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Montadora> procuraRangeFromTo(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Montadora> findAll() {
        return super.findAll();
    }   

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countR() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
