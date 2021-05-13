package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.Peca;
import br.edu.univas.vo.List;
import br.edu.univas.vo.Node;
import br.edu.univas.vo.view;

public class Jogo {

	public static Scanner sc = new Scanner(System.in);
	public static view vw = new view();

	public static void main(String[] args) throws InterruptedException {

		List pecas = new List();
		List pecasComputador = new List();
		List pecasPlayer1 = new List();
		List pecasJogadas = new List();

		pecas.criaPecas();

		pecas.distribuiPecas(pecasPlayer1, pecas);
		pecas.distribuiPecas(pecasComputador, pecas);
		vw.Start();
		int escolha = 0;

		boolean fim = false;

		do {

			fim = jogoPlayer1(pecasPlayer1, pecasJogadas, pecas);
			if (fim == true) {
				vw.msgGanhou();
				break;
			}

			fim = jogoComputador(pecasComputador, pecasJogadas, pecas);
			if (fim == true) {
				vw.msgPerdeu();
				break;
			}

		} while (fim == false);

	}

	private static boolean jogoComputador(List pecasComputador, List pecasJogadas, List pecas)
			throws InterruptedException {

		Thread.currentThread();
		Thread.sleep(1000);

		String valida = "Suas pecas acabaram!";

		vw.msgVezDoComputador();

		boolean jogoAcabou = false;
		boolean aux = false;

		Peca peca;

		int number = 0;
		int contador = 0;
		while (true) {

			int isValid = pecasComputador.listaAmount(pecasComputador);

			if (number <= isValid) {

				peca = pecasComputador.getElementAt(number);

				aux = pecasJogadas.logicaJogo(pecasJogadas, peca);

				if (aux == true) {

					peca = pecasComputador.remove(peca.toString());
					contador = 0;
					break;

				} else {

					number += 1;
				}

			} else {

				if (contador == 0) {
					comprarPecasComputador(pecasComputador, pecas);
					vw.msgComputadorComprouPeca();
					contador += 1;
					continue;
				} else {
					contador = 0;
				}

				vw.msgComputadorPassouAVez();

				break;

			}

		}
		vw.msgPecasJogadas();
		System.out.println(pecasJogadas.getAsString());
		if (valida.equals(pecasComputador.getAsString())) {

			jogoAcabou = true;
		}
		return jogoAcabou;
	}

	public static int readInt() {

		int leitura = sc.nextInt();
		sc.nextLine();
		return leitura;
	}

	public static boolean jogoPlayer1(List pecasPlayer1, List pecasJogadas, List pecas) {

		String valida = "Suas pe�as acabaram!";

		Peca peca;

		vw.Playing();

		boolean jogoAcabou = false;
		int number;
		while (true) {

			System.out.println(pecasPlayer1.getAsString());
			number = readInt();

			if (number == 10) {
				break;
			}

			else if (number == 5) {

				comprarPecasPlayer1(pecasPlayer1, pecas);
				continue;
			}
			number -= 1;

			int isValid = pecasPlayer1.listaAmount(pecasPlayer1);

			if (number <= isValid && number >= 0) {
				break;
			}

			vw.msgErro();

		}

		peca = pecasPlayer1.getElementAt(number);
		boolean aux = pecasJogadas.logicaJogo(pecasJogadas, peca);
		if (aux == true) {
			peca = pecasPlayer1.remove(peca.toString());
		}

		if (valida.equals(pecasPlayer1.getAsString())) {

			jogoAcabou = true;

		}

		return jogoAcabou;
	}

	public static void comprarPecasPlayer1(List pecasPlayer1, List pecas) {

		Peca peca;
		peca = pecas.getElementAt(0);
		peca = pecas.remove(peca.toString());
		pecasPlayer1.insert(peca);

	}

	public static void comprarPecasComputador(List pecasComputador, List pecas) {

		Peca peca;
		peca = pecas.getElementAt(0);
		peca = pecas.remove(peca.toString());
		pecasComputador.insert(peca);

	}

}