package MODEL;

import MODEL.Modelo;
import MODEL.Montadora;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T14:54:17")
@StaticMetamodel(Veiculo.class)
public class Veiculo_ { 

    public static volatile SingularAttribute<Veiculo, Double> motor;
    public static volatile SingularAttribute<Veiculo, Long> id_veiculo;
    public static volatile SingularAttribute<Veiculo, String> tipo;
    public static volatile SingularAttribute<Veiculo, String> cor;
    public static volatile SingularAttribute<Veiculo, Montadora> montadora;
    public static volatile SingularAttribute<Veiculo, Integer> quilometragem;
    public static volatile SingularAttribute<Veiculo, Modelo> modelo;

}