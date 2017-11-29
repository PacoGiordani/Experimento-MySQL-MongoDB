
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Resultado {
	void salvaResultado(String resultado) {
		PrintWriter arquivo;
		try {
			arquivo = new PrintWriter(new FileWriter("resultado.txt", true), true);
			arquivo.println(resultado);
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
