package br.com.avmartins.controller;

import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.avmartins.bean.Piloto;
import br.com.avmartins.bean.Volta;
import br.com.avmartins.controller.impl.CorridaImpl;
import br.com.avmartins.exception.PopulaException;
import br.com.avmartins.exception.RankingException;
import br.com.avmartins.util.FormataUtil;

/**
 * Implementação da Classe Controller Corrida
 * 
 * Responsavel por implementar o negócio da aplicação 
 *
 * @author Andeson Virginio Martins
 * @since 28/11/2016
 * @version 1.0.0
 *
 */
public class Corrida implements CorridaImpl {

	private static Corrida corridaController = null;

	private Collection<Volta> corrida = new ArrayList<Volta>();
	private Volta melhorVolta = null;

	private Map<Integer, Piloto> pilotos = new HashMap<>();

	/**
	 * Construtor privado da classe (Singleton)
	 */
	private Corrida() {
	}

	/**
	 * Obtém a única instância da classe (Singleton)
	 *
	 * @return Uma instância da classe
	 */
	public static Corrida getInstance() {
		if (corridaController == null)
			corridaController = new Corrida();
		return corridaController;
	}

	/**
	 * Retorna a coleção de voltas buscadas a partir de um arquivo de log
	 * 
	 * @return Collection<Volta>
	 * @throws PopulaException
	 */
	@SuppressWarnings("resource")
	public Collection<Volta> populaCorrida() throws PopulaException {

		Collection<Volta> corrida = new ArrayList<Volta>();

		try {

			InputStream inputStream = ClassLoader.getSystemResourceAsStream("./corrida.txt");
			Scanner scanner = new Scanner(inputStream);

			int i = 1;

			while (scanner.hasNext()) {
				Volta volta = new Volta();
				volta.setId(i);

				Piloto piloto = new Piloto();

				volta.setHora(scanner.next());

				/*
				 * Aqui vou pegar o codigo e nome do pilo e popular no bean
				 */

				piloto.setCodigo(scanner.nextInt());
				scanner.next();
				piloto.setNome(scanner.next());
				volta.setPiloto(piloto);

				volta.setnVolta(Integer.parseInt(scanner.next()));
				volta.setTempoVolta(scanner.next());
				volta.setVelocidadeMediaDaVolta(Float.parseFloat(scanner.next().replace(",", ".")));

				corrida.add(volta);
				i++;

			}

		} catch (Exception e) {
			throw new PopulaException(e.getMessage(), e.fillInStackTrace());

		}

		return corrida;

	}

	/**
	 * Mostra o resultado da corrida a partie do arquivo de log lido
	 * 
	 * @param Collection<Volta>
	 * @throws RankingException
	 */
	public void ranking(Collection<Volta> corrida) throws RankingException {

		melhorVolta = new Volta();
		melhorVolta.setVelocidadeMediaDaVolta(new Float(0));

		try {

			for (Volta volta : corrida) {

				Piloto piloto = null;

				String[] sTempoVolta = volta.getTempoVolta().split(":"); // Separa
																			// o
																			// minuto[0]
																			// dos
																			// segundos[1]
				String[] sTempoVoltaSegundos = sTempoVolta[1].split("\\.");

				Duration tempoTotalProva = Duration.ofMinutes(Long.parseLong(sTempoVolta[0]))
						.plusSeconds(Long.parseLong(sTempoVoltaSegundos[0]))
						.plusMillis(Long.parseLong(sTempoVoltaSegundos[1]));

				if (pilotos.containsKey(volta.getPiloto().getCodigo())) {
					piloto = pilotos.get(volta.getPiloto().getCodigo());
					piloto.setQtdeVoltasCompletadas(volta.getnVolta());
					piloto.setTempoTotalProva(piloto.getTempoTotalProva().plus(tempoTotalProva));
					if (volta.getVelocidadeMediaDaVolta() > piloto.getVelocidadeMediaDaVolta()) {
						piloto.setVelocidadeMediaDaVolta(volta.getVelocidadeMediaDaVolta());
						piloto.setMelhorVolta(volta.getnVolta());
					}
					piloto.setSomaVelocidadeMediaDaVolta(
							piloto.getSomaVelocidadeMediaDaVolta() + volta.getVelocidadeMediaDaVolta());
				} else {
					piloto = volta.getPiloto();
					piloto.setQtdeVoltasCompletadas(volta.getPiloto().getQtdeVoltasCompletadas());
					piloto.setTempoTotalProva(tempoTotalProva);
					piloto.setMelhorVolta(volta.getnVolta());
					piloto.setVelocidadeMediaDaVolta(volta.getVelocidadeMediaDaVolta());
					piloto.setSomaVelocidadeMediaDaVolta(volta.getVelocidadeMediaDaVolta());
					pilotos.put(volta.getPiloto().getCodigo(), piloto);
				}

				if (volta.getVelocidadeMediaDaVolta() > melhorVolta.getVelocidadeMediaDaVolta()) {
					melhorVolta = volta;
				}

			}

			Map<Integer, Piloto> sortedMap = sortByValue(pilotos);

			System.out.println("");

			System.out.println(
					"------------------------------------- resultado da corrida -------------------------------------");
			printMap(sortedMap);
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Melhor volta da corrida : Volta " + melhorVolta.getnVolta() + " - "
					+ melhorVolta.getPiloto().getCodigo() + " - " + melhorVolta.getPiloto().getNome() + " - "
					+ melhorVolta.getVelocidadeMediaDaVolta());

			System.out.println("");
			System.out.println("");

		} catch (Exception e) {
			throw new RankingException(e.getMessage(), e.fillInStackTrace());

		}

	}

	/**
	 * Ordena o resultado utilizando Comparator
	 * 
	 * @param Map<Integer, Piloto>
	 */
	private static Map<Integer, Piloto> sortByValue(Map<Integer, Piloto> unsortMap) {

		// 1. Converter Mapa para Lista de Mapa
		List<Map.Entry<Integer, Piloto>> list = new LinkedList<Map.Entry<Integer, Piloto>>(unsortMap.entrySet());

		// 2. Lista de ordenação com Collections.sort (), forneça um comparador
		// personalizado
		// Tente mudar a posição o1 o2 para uma ordem diferente
		Collections.sort(list, new Comparator<Map.Entry<Integer, Piloto>>() {
			public int compare(Map.Entry<Integer, Piloto> o1, Map.Entry<Integer, Piloto> o2) {

				int retorno = o1.getValue().getTempoTotalProva().compareTo(o2.getValue().getTempoTotalProva());

				return retorno;
			}

		});

		// 3. Loop a lista ordenada e colocá-lo em um novo pedido de inserção
		// Mapa LinkedHashMap
		Map<Integer, Piloto> sortedMap = new LinkedHashMap<Integer, Piloto>();
		for (Map.Entry<Integer, Piloto> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}
	
	/**
	 * Imprime o resultado formatado
	 * 
	 * @param Map<K, V> 
	 */
	public static <K, V> void printMap(Map<K, V> map) {
		int posicao = 0;

		System.out.println(
				"Posição Chegada | Código Piloto | Nome Piloto   | Qtde Voltas Completadas | Tempo Total de Prova");

		for (Map.Entry<K, V> entry : map.entrySet()) {

			posicao++;

			Piloto piloto = (Piloto) entry.getValue();

			System.out.printf("%-15s | %-13s | %-13s | %-23s | %-20s%n", posicao, piloto.getCodigo(), piloto.getNome(),
					piloto.getQtdeVoltasCompletadas(), FormataUtil.formata(piloto.getTempoTotalProva().toMillis()));
		}

		System.out.println("");

		System.out.println(
				"------------------------------------------------------------- Bônus -------------------------------------------------------------");

		System.out.println(
				"Posição Chegada | Código Piloto | Nome Piloto   | Melhor volta | Velocidade média | Tempo Chegada | Tempo chegada após o vencedor");

		posicao = 0;

		Duration tempoPilotoVencedor = null;

		for (Map.Entry<K, V> entry : map.entrySet()) {

			posicao++;

			Piloto piloto = (Piloto) entry.getValue();

			if (posicao == 1) {
				tempoPilotoVencedor = piloto.getTempoTotalProva();
			}

			System.out.printf("%-15s | %-13s | %-13s | %-12s | %-16s | %-13s | %-20s%n", posicao, piloto.getCodigo(),
					piloto.getNome(), piloto.getMelhorVolta(),
					piloto.getSomaVelocidadeMediaDaVolta() / piloto.getQtdeVoltasCompletadas(),
					FormataUtil.formata(piloto.getTempoTotalProva().toMillis()),
					FormataUtil.formata(piloto.getTempoTotalProva().minus(tempoPilotoVencedor).toMillis()));
		}

	}

	public Collection<Volta> getCorrida() {
		return corrida;
	}

	public void setCorrida(Collection<Volta> corrida) {
		this.corrida = corrida;
	}

}
