package lavage;

import java.util.LinkedList;
import java.util.List;

class PileDAssiettes {

	private final static int MAX = 10;
	private final List<Assiette> myList = new LinkedList<>();

	private boolean isEmpty() {
		return myList.isEmpty();
	}

	private boolean isFull() {
		return (myList.size() >= MAX);
	}

	synchronized public void push(Assiette assiette) throws InterruptedException {
		// Attendre que la pile ne soit pas pleine
		while (isFull()) {
			wait(); // Peut lever InterruptedException
		}
		// assert (!isFull());
		// Ajouter à la fin de la liste
		myList.add(assiette);
		System.out.printf("La pile contient %d assiettes%n", myList.size());
		notifyAll(); // Notifier que la pile n'est plus vide
	}

	synchronized public Assiette pop() throws InterruptedException {
		// Attendre que la pile ne soit pas vide
		while (isEmpty()) {
			wait(); // Peut lever InterruptedException
		}		// Dépiler
		// assert !isEmpty(); // On est sur que la pile n'est pas vide
		Assiette result = myList.remove(myList.size() - 1);
		System.out.printf("La pile contient %d assiettes%n", myList.size());
		notifyAll(); // Notifier que la pile n'est plus pleine
		return result;
	}
}