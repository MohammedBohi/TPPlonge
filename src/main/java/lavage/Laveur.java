package lavage;

class Laveur extends Thread {
	private final PileDAssiettes myStack;

	Laveur(PileDAssiettes s) {
		myStack = s;
	}

	@Override
	public void run() {
		while (true) {
			try {
				// Laver une assiette
				Assiette assiette = new Assiette();
				sleep(600);
				// La mettre sur la pile
				System.out.println("J'empile : " + assiette);
				myStack.push(assiette);
			} catch (InterruptedException ex) {
				break; // Sort du while, termine le Thread;
			}
		}
		System.out.println("Laveur terminé");
	}
}