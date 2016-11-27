package br.com.avmartins.bean;

import java.time.Duration;

/**
 * Classe Piloto
 * 
 * Representa o objeto bean Piloto
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public class Piloto {
	
	private Integer codigo;
    private String nome;
    private int qtdeVoltasCompletadas;	
	private Duration tempoTotalProva;
	private int melhorVolta;
	private Float velocidadeMediaDaVolta;
	private Float somaVelocidadeMediaDaVolta;
	
	public Piloto() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdeVoltasCompletadas() {
		return qtdeVoltasCompletadas;
	}

	public void setQtdeVoltasCompletadas(int qtdeVoltasCompletadas) {
		this.qtdeVoltasCompletadas = qtdeVoltasCompletadas;
	}

	public Duration getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(Duration tempoTotalProva) {
		this.tempoTotalProva = tempoTotalProva;
	}
	
	public int getMelhorVolta() {
		return melhorVolta;
	}

	public void setMelhorVolta(int melhorVolta) {
		this.melhorVolta = melhorVolta;
	}

	public Float getVelocidadeMediaDaVolta() {
		return velocidadeMediaDaVolta;
	}

	public void setVelocidadeMediaDaVolta(Float velocidadeMediaDaVolta) {
		this.velocidadeMediaDaVolta = velocidadeMediaDaVolta;
	}
	
	public Float getSomaVelocidadeMediaDaVolta() {
		return somaVelocidadeMediaDaVolta;
	}

	public void setSomaVelocidadeMediaDaVolta(Float somaVelocidadeMediaDaVolta) {
		this.somaVelocidadeMediaDaVolta = somaVelocidadeMediaDaVolta;
	}

}