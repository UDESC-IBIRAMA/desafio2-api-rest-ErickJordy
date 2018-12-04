package MODEL;

import MODEL.Veiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T14:54:17")
@StaticMetamodel(Modelo.class)
public class Modelo_ { 

    public static volatile ListAttribute<Modelo, Veiculo> veiculos;
    public static volatile SingularAttribute<Modelo, Long> id_modelo;
    public static volatile SingularAttribute<Modelo, String> nome;

}