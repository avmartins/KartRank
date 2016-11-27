package br.com.avmartins.controller.impl;

import java.util.Collection;

import br.com.avmartins.bean.Volta;
import br.com.avmartins.exception.RankingException;
import br.com.avmartins.exception.PopulaException;

/**
 * Interface para a classe Corrida
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public interface CorridaImpl {
	
	/**
	 * Retorna a coleção de voltas buscadas a partir de um arquivo de log
	 * 
	 * @return Collection<Volta>
	 * @throws PopulaException
	 */
	public Collection<Volta> populaCorrida() throws PopulaException;
	
	/**
	 * Mostra o resultado da corrida a partie do arquivo de log lido
	 * 
	 * @param Collection<Volta>
	 * @throws RankingException
	 */
	public void ranking(Collection<Volta> corrida) throws RankingException;

}
