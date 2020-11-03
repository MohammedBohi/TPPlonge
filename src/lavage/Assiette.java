package lavage;

public class Assiette {
	private static final String verrou = "verrou";
        // On compte le nombre total  d'assiettes
	private static Integer nombreAssiette = 0;
        // Chaque assiette a un numéro
	private final int numeroAssiette;

	Assiette() {
                // Pour que la classe soit "thread safe"
		synchronized(verrou) {
			numeroAssiette = ++nombreAssiette;
		}
	}

	@Override
	public String toString() {
		return "Assiette{" + "numeroAssiette=" + numeroAssiette + '}';
	}

}
