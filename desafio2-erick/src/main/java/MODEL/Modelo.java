/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Erick
 */
@Entity
@XmlRootElement
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_modelo")
    private Long id_modelo;
    private String nome;
    @OneToMany(mappedBy = "modelo")
    private List<Veiculo> veiculos = new ArrayList<>();

    public Long getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Long id_modelo) {
        this.id_modelo = id_modelo;
    }

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
    
    
    
    public Long getId() {
        return id_modelo;
    }

    public void setId(Long id) {
        this.id_modelo = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_modelo != null ? id_modelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {        
        if (object instanceof Modelo) {                    
            Modelo m = (Modelo) object;
            if ((this.id_modelo == null && m.id_modelo != null) || (this.id_modelo != null && !this.id_modelo.equals(m.id_modelo))) {
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
        return "id " + id_modelo;
    }
    
}
