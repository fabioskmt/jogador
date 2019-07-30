package jogador;

import java.util.Random;

public class Dado {
	private static final Random random = new Random();
	private static final int lados = 6;
	
	public static int jogarDado() {
		return random.nextInt(lados)+1;
	}
}
