package MODEL;

import MODEL.Veiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T14:54:17")
@StaticMetamodel(Montadora.class)
public class Montadora_ { 

    public static volatile SingularAttribute<Montadora, Long> id_montadora;
    public static volatile ListAttribute<Montadora, Veiculo> veiculos;
    public static volatile SingularAttribute<Montadora, String> nome;

}