package it.betalent.springTopBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="attori")
public class Attore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column
    private String nome;
    @Column
    private int anno_nascita;
    @Column
    private String nazionalita;
    
   
    public Attore() {
    }
	

	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getAnno_nascita() {
		return anno_nascita;
	}


	public void setAnno_nascita(int anno_nascita) {
		this.anno_nascita = anno_nascita;
	}


	public String getNazionalita() {
		return nazionalita;
	}


	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}


	public Attore(String nome, int anno_nascita, String nazionalita) {
		super();
		this.nome = nome;
		this.anno_nascita = anno_nascita;
		this.nazionalita = nazionalita;
	}


	@Override
	public String toString() {
		return "Attore [id=" + id + ", nome=" + nome + ", anno_nascita=" + anno_nascita + ", nazionalita=" + nazionalita
				+ "]";
	}
}