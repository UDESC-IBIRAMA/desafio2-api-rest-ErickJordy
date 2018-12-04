package MODEL;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erick
 */
@Entity
@XmlRootElement
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_veiculo")
    private Long id_veiculo;
    
    @ManyToOne
    @JoinColumn(name="id_montadora")
    private Montadora montadora;
    
    @ManyToOne
    @JoinColumn(name="id_modelo")
    private Modelo modelo;
 
    private String cor;
    private int quilometragem;
    private double motor;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
            
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }
            
    public Montadora getMontadora() {
        return montadora;
    }

    public void setMontadora(Montadora montadora) {
        this.montadora = montadora;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_veiculo != null ? id_veiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Veiculo) {
            Veiculo v = (Veiculo) object;
            if ((this.id_veiculo == null && v.id_veiculo != null) || (this.id_veiculo != null && !this.id_veiculo.equals(v.id_veiculo))) {
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
        return "id " + id_veiculo;
    }
    
}
