public final class Temporizador {

	private static long startValue;
	private static long stopValue;
	private static long diferencaTempo;

	public static void start() {
		startValue = System.currentTimeMillis();
		stopValue = 0;
		diferencaTempo = 0;
	}

	public static void stop() {
		stopValue = System.currentTimeMillis();
		diferencaTempo = stopValue - startValue;
	}

	public static long tempoMilissegundos() {
		return diferencaTempo;
	}
	
	public static double tempoSegundos() {
		return diferencaTempo/1000;
	}
}