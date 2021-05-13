package br.edu.univas.vo;

public class view {

	public void Start() {
		
		System.out.println("_________________________________");
		System.out.println("Dominó");
		System.out.println("_________________________________");

	}

	public void Playing() {

		System.out.println("\nSua vez **********************\n");
		System.out.println("Sua mão:");
		System.out.println("Digite o numero da peca que deseja jogar ou 15 para passar a vez ou 20 para comprar uma peca ");
		System.out.println("");
	}

	public void msgErro() {

		System.out.println("Numero de peca invalida, digite um numero valido");

	}

	public void msgVezDoComputador() {
		System.out.println("Vez do Computador\n");
	}

	public void msgPecasJogadas() {
		System.out.println("pecas na mesa:\n ");

	}
	public void msgGanhou() {
		
		System.out.println("Voce venceu :) ");
	}
	public void msgPerdeu() {
		System.out.println("Voce perdeu :( ");
		
	}
	
	public void msgComputadorPassouAVez() {
		
		System.out.println("Computador passou a vez ***************");	
		
	}
	public void msgComputadorComprouPeca() {
		
		System.out.println("Computador comprou uma peca ***************\n");
		
		
	}
}