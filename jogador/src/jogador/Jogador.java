package jogador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogador {
	private static int rodadas = 24;
	
	private static int qtdAnalistas = 3;
	private static int qtdImplem = 3;
	private static int qtdQA = 2;	
	
	private static boolean fimAnalise = false;
	private static boolean fimImplem = false;
	private static boolean fimQA = false;
	
	private static int[] diasAnalise = {3,3,5,4,3,7,5,4,6,8,10,8,8,10,6,8,8,10,12,5,10,20,15,15};
	private static int[] diasImplem = {2,3,3,4,5,3,5,6,7,8,5,8,5,10,15,10,12,12,12,10,15,10,15,15};
	private static int[] diasQA = {2,5,3,4,5,3,5,6,6,5,8,8,12,8,8,12,10,10,10,20,12,10,15,20};
	
	public static void main(String[] args) {
		Jogador j = new Jogador();
		
		List<Card> listaCards = j.gerarListaCards(diasAnalise, diasImplem, diasQA);
		
		for (int i = 0; i < rodadas; i++) {
			System.out.println(" ");
			System.out.println("    JOGADA #" + (i+1));
			
			int ajuda = 0;			
			if (!fimAnalise) {
				listaCards = j.jogarAnalise(listaCards, qtdAnalistas);
			} else {
				ajuda += qtdAnalistas/2;
				System.out.println("!!!!!! AJUDA ANALISE !!!!!! ==> " + ajuda);
			}
			if (!fimImplem) {
				listaCards = j.jogarImplem(listaCards, qtdImplem + ajuda);
				ajuda = 0;
			} else {
				ajuda += qtdImplem/2;
				System.out.println("!!!!!! AJUDA IMPLEM !!!!!! ==> " + ajuda);
			}
			if (!fimQA) {
				listaCards = j.jogarQA(listaCards, qtdQA + ajuda);
			}
		}
	}
	
	
	/**
	 * Realiza jogada de analista para a rodada
	 * 
	 * @param listaCards
	 * @param qtdPessoas
	 * @return lista de cards atualizada com jogada de análise
	 */
	public List<Card> jogarAnalise(List<Card> listaCards, int qtdPessoas) {
		int totalJogada = jogarDados(qtdPessoas);
		System.out.println("TOTAL JOGADA ANALISTA = " + totalJogada);
		
		for (Card card : listaCards) {
			if (card.getDiasAnaliseRestantes() > 0) {
				totalJogada -= card.getDiasAnaliseRestantes();

				if (totalJogada > 0) {
					card.setDiasAnaliseRestantes(0);
					System.out.println(card);
				} else {
					card.setDiasAnaliseRestantes(-(totalJogada));
					System.out.println(card);
					break;
				}
			}
		}
		
		if (listaCards.get(listaCards.size()-1).getDiasAnaliseRestantes() == 0) {
			fimAnalise = true;
			System.out.println("--- FIM ANALISE ---");
		}
		
		return listaCards;
	}
	
	/**
	 * Realiza jogada de implementador para a rodada
	 * 
	 * @param listaCards
	 * @param qtdImplem
	 * @return lista de cards atualizada com jogada de implem
	 */
	public List<Card> jogarImplem(List<Card> listaCards, int qtdPessoas) {
		int totalJogada = jogarDados(qtdPessoas);
		
		System.out.println("TOTAL JOGADA IMPLEM = " + totalJogada);
		
		for (Card card : listaCards) {
			if (card.getDiasAnaliseRestantes() == 0 && card.getDiasImplemRestantes() > 0) {
				totalJogada -= card.getDiasImplemRestantes();

				if (totalJogada > 0) {
					card.setDiasImplemRestantes(0);
					System.out.println(card);
				} else {
					card.setDiasImplemRestantes(-(totalJogada));
					System.out.println(card);
					break;
				}
			}
		}
		
		if (listaCards.get(listaCards.size()-1).getDiasImplemRestantes() == 0) {
			fimImplem = true;
			System.out.println("--- FIM IMPLEM ---");
		}
		
		return listaCards;
	}
	
	/**
	 * Realiza jogada de QA para a rodada
	 * 
	 * @param listaCards
	 * @param qtdQA
	 * @return lista de cards atualizada com jogada de QA
	 */
	public List<Card> jogarQA(List<Card> listaCards, int qtdPessoas) {
		int totalJogada = jogarDados(qtdPessoas);
		
		System.out.println("TOTAL JOGADA QA = " + totalJogada);
		
		for (Card card : listaCards) {
			if (card.getDiasImplemRestantes() == 0 && card.getDiasQARestantes() > 0) {
				totalJogada -= card.getDiasQARestantes();

				if (totalJogada > 0) {
					card.setDiasQARestantes(0);
					System.out.println(card);
				} else {
					card.setDiasQARestantes(-(totalJogada));
					System.out.println(card);
					break;
				}
			}
		}
		
		if (listaCards.get(listaCards.size()-1).getDiasQARestantes() == 0) {
			fimQA = true;
			System.out.println("--- FIM QA ---");
		}
		
		return listaCards;
	}
	
	
	/**
	 * Simulação de jogar dados por uma quantidade de vezes
	 * 
	 * @param qtdVezes
	 * @return soma total
	 */
	public int jogarDados(int qtdVezes) {
		int totalJogada = 0;
		for (int i = 0; i < qtdVezes; i++) {
			totalJogada += Dado.jogarDado();
		}
		return totalJogada;
	}
		
	/**
	 * Gerar cards de forma aleatória
	 * @param diasAnalise
	 * @param diasImplem
	 * @param diasQA
	 * @return lista cards
	 */
	public List<Card> gerarListaCards(int[] diasAnalise, int[] diasImplem, int[] diasQA) {
		List<Card> listaCards = new ArrayList<Card>();
		
		// gera os cards
		for (int i = 0; i < diasAnalise.length; i++) {
			Card card = new Card(diasAnalise[i], diasImplem[i], diasQA[i]);
			listaCards.add(card);
		}
		
		Collections.shuffle(listaCards);
		
		// atribui o processo
		for (int i = 0; i < diasAnalise.length; i++) {
			listaCards.get(i).setProcesso(i+1);
			System.out.println(listaCards.get(i));
		}
		
		return listaCards;
	}
}
