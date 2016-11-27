package br.com.avmartins.bean;

/**
 * Classe Volta
 * 
 * Representa o objeto bean volta
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public class Volta {
	
	private int id;
	private String hora;                   
	private Piloto piloto;         
	private int nVolta;  
	private String tempoVolta;     
	private Float velocidadeMediaDaVolta;
	
	public Volta() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	public int getnVolta() {
		return nVolta;
	}

	public void setnVolta(int nVolta) {
		this.nVolta = nVolta;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public Float getVelocidadeMediaDaVolta() {
		return velocidadeMediaDaVolta;
	}

	public void setVelocidadeMediaDaVolta(Float velocidadeMediaDaVolta) {
		this.velocidadeMediaDaVolta = velocidadeMediaDaVolta;
	}
}