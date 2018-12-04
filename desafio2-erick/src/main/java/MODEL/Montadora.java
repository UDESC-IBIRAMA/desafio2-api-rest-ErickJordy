package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erick
 */
@Entity
@XmlRootElement
public class Montadora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id_montadora")
    private Long id_montadora;
    private String nome;

    @OneToMany(mappedBy = "montadora")
    private List<Veiculo> veiculos = new ArrayList<>();

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    public Long getId_montadora() {
        return id_montadora;
    }

    public void setId_montadora(Long id_montadora) {
        this.id_montadora = id_montadora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_montadora != null ? id_montadora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Montadora) {        
            Montadora m = (Montadora) object;
            if ((this.id_montadora == null && m.id_montadora != null) || (this.id_montadora != null && !this.id_montadora.equals(m.id_montadora))) {
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "id " + id_montadora;
    }
    
}
