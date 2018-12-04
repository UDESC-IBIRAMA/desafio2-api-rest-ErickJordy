package Service;

import MODEL.Montadora;
import MODEL.Modelo;
import MODEL.Veiculo;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Erick
 */
@Stateless
@Path("model.veiculo")
public class VeiculoRest extends Factr<Veiculo> {

    @PersistenceContext(unitName = "PersistenceEric")
    private EntityManager em;

    public VeiculoRest() {
        super(Veiculo.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Veiculo entity) {
        super.create(entity);
    }


    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Veiculo find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Path("buscaTipoCor/{tipo}/{cor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraTipoCor(@PathParam("tipo")String tipo,@PathParam("cor") String cor){
        return super.procuraTipoCor(tipo, cor);
    }

    @GET
    @Path("buscaTipoQuilometragem/{tipo}/{quilometragem}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraTipoQuilometragem(@PathParam("tipo")String tipo,@PathParam("quilometragem")int quilometragem){
        return super.procuraTipoQuilometragem(tipo, quilometragem);
    }

    
    @GET
    @Path("buscaTipoMotor/{tipo}/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraTipoMotor(@PathParam("tipo")String tipo,@PathParam("motor")double motor){
        return super.procuraTipoMotor(tipo,motor);
    }

    
    @GET
    @Path("buscaTipoMontadora/{tipo}/{montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraTipoMontadora(@PathParam("tipo")String tipo,@PathParam("montadora")String nome_montadora){
        return super.procuraTipoMontadora(tipo, nome_montadora);
    }
    

    @GET
    @Path("quilometragem/valormm")
    public List<Veiculo> veiculosKMMaior(@QueryParam("minimo") int minValue) {
        return super.veiculosKMMaior(minValue);
    }
    

    @GET
    @Path("quilometragem/valorma")
    public List<Veiculo> veiculosKMMenor(@QueryParam("maximo") int maxValue){
        return super.veiculosKMMenor(maxValue);
    }
    

    @GET
    @Path("motor/valorminveiculo")
    public List<Veiculo> veiculoMotorMinimo(@QueryParam("minimo")double minValue){
        return super.veiculoMotorMinimo(minValue);
    }

    
    @GET
    @Path("motor/valormaxveiculo")
    public List<Veiculo> veiculoMotorMaximo(@QueryParam("maximo")double maxValue){
        return super.veiculoMotorMaximo(maxValue);
    }

    
    @GET
    @Path("motor/{motor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraMotor(@PathParam("motor") double motor) {
        return super.procuraMotor(motor);
    }
    
    @GET
    @Path("modelo/{nome_modelo}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraModelo(@PathParam("nome_modelo")String nome_modelo){
        return super.procuraModelo(nome_modelo);
    }
    
    @GET
    @Path("quilometragem/{quilometragem}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraQuilometragem(@PathParam("quilometragem")int quilometragem){
        return super.procuraQuilometragem(quilometragem);
    }
    
        
    @GET
    @Path("cor/{cor}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraCor(@PathParam("cor") String cor){  
        return super.procuraCor(cor);
    }
    
    @GET
    @Path("montadora/{nome_montadora}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> procuraMontadora(@PathParam("nome_montadora")String nome_montadora){
        return super.procuraMontadora(nome_montadora);
    }
        
  
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Veiculo> findAll() {
        return super.findAll();
    }  
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
