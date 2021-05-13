package br.edu.univas.vo;

public class List {
	public Node head;
	public Node last;

	public void insert(Peca peca) {

		Node novonode = new Node();

		if (head == null) {

			head = novonode;

		} else {

			last.next = novonode;
			novonode.previous = last;
		}

		last = novonode;
		novonode.info = peca;

	}

	public Peca remove(String name) {

		if (head == null) {
			return null;
		}

		Node current = head;
		Node previous = head.previous;
		Node next = head.next;

		while (current != null) {
			if (current.info.toString().equals(name)) {
				break;
			}
			previous = current;
			current = current.next;
			next = next.next;
		}

		if (current == null) {
			return null;
		}

		Peca removePeca = current.info;

		if (this.head == this.last) {
			this.head = null;
			this.last = null;
			return removePeca;
		}

		if (previous == null) {
			head = next;
			next.previous = null;
		} else {

			if (current.next != null) {
				previous.next = next;
				next.previous = previous;
			} else {

				this.last = previous;
				previous.next = null;
			}

		}

		return removePeca;
	}

	public String getAsString() {
		if (head == null) {
			return "Suas pecas acabaram!";
		}
		StringBuilder builder = new StringBuilder();

		Node aux = head;
		while (aux != null) {

			builder.append("|").append(aux.info.getNum1());
			builder.append("|");
			builder.append(aux.info.getNum2()).append("|");
			builder.append("  ");

			aux = aux.next;
		}
		return builder.toString();
	}

	private Node getNodeAt(int index) {
		if (index < 0) {
			return null;
		}

		int i = 0;
		Node aux = head;
		while (aux != null) {

			if (index == i) {
				return aux;
			}
			i++;
			aux = aux.next;
		}
		return null;
	}

	public Peca getElementAt(int idx) {
		Node node = getNodeAt(idx);
		if (node != null) {
			return node.info;
		}
		return null;
	}

	public boolean logicaJogo(List lista, Peca peca) {

		boolean auxiliar = false;

		if (peca != null) {

			if (lista.head == null) {
				lista.insert(peca);
				auxiliar = true;

			} else if (head.info.getNum1() == peca.getNum1() || head.info.getNum1() == peca.getNum2()) {

				auxiliar = true;

				if (head.info.getNum1() == peca.getNum1()) {
					int aux = peca.getNum1();
					int aux2 = peca.getNum2();
					peca.setNum2(aux);
					peca.setNum1(aux2);

				}
				Node novonode = new Node();
				head.previous = novonode;
				novonode.info = peca;
				novonode.next = head;
				head = novonode;

			} else if (last.info.getNum2() == peca.getNum1() || last.info.getNum2() == peca.getNum2()) {

				auxiliar = true;

				if (last.info.getNum2() == peca.getNum2()) {
					int aux = peca.getNum1();
					int aux2 = peca.getNum2();
					peca.setNum2(aux);
					peca.setNum1(aux2);

				}
				Node novonode = new Node();
				last.next = novonode;
				novonode.info = peca;
				novonode.previous = last;
				last = novonode;

			} else {

			}
		} else {

		}
		return auxiliar;
	}

	public void criaPecas() {

		int auxiliar = 0;

		for (int i = 0; i < 7; i++) {

			for (int j = 0; j + auxiliar < 7; j++) {

				Peca novaPeca = new Peca();
				novaPeca.setNum1(i);
				novaPeca.setNum2(j + auxiliar);
				insert(novaPeca);

			}
			auxiliar+=1;
		}

	}

	public void distribuiPecas(List lista, List tabuleiro) {

		Peca peca;

		int idx = listaAmount(tabuleiro);

		for (int i = 0; i < 7; i++) {
			int random = 1 + (int) (Math.random() * idx);
			peca = getElementAt(random);
			peca = remove(peca.toString());
			lista.insert(peca);
			idx-=1;
		}

	}

	public int listaAmount(PecaList list) {

		Node auxiliar = list.head;
		Node auxiliar2 = list.last;

		int aux = 0;

		while (!auxiliar.info.toString().equals(auxiliar2.info.toString())) {

			auxiliar = auxiliar.next;
			aux+=1;
			if (auxiliar == null) {
				break;
			}
		}
		return aux;
	}
	
}