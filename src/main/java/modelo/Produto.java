package modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotEmpty;

@Entity
public class Produto implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -160292155564248718L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome deve ser preenchido!")
    private String nome;
    
    @NotEmpty(message = "Valor deve ser preenchido!")
    private BigDecimal valor;
    
    public Produto() {
    	
    }

    @PrePersist
    @PreUpdate
    private void prePersist(){
    	
        //this.setDataCriacao(LocalDateTime.now());
        
    }

    @Override
    public boolean equals(Object o) {
    	
        if (this == o) return true;
        
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id != null ? id.equals(produto.id) : produto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
    
    

}
