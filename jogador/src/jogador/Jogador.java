package jogador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jogador {
	private static int rodadas = 24;
	
	private int qtdAnalistas = 2;
	private int qtdImplem = 2;
	private int qtdQA = 2;	
	
	private static int[] diasAnalise = {3,3,5,4,3,7,5,4,6,8,10,8,8,10,6,8,8,10,12,5,10,20,15,15};
	private static int[] diasImplem = {2,3,3,4,5,3,5,6,7,8,5,8,5,10,15,10,12,12,12,10,15,10,15,15};
	private static int[] diasQA = {2,5,3,4,5,3,5,6,6,5,8,8,12,8,8,12,10,10,10,20,12,10,15,20};
	
	public static void main(String[] args) {
		Jogador j = new Jogador();
		
		List<Card> listaCards = j.gerarListaCards(diasAnalise, diasImplem, diasQA);
		
		
	}
	
	
	public List<Card> jogarAnalise(List<Card> listaCards, int qtdAnalistas) {
		
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
		for (int i = 0; i < qtdAnalistas; i++) {
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
