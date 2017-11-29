import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Dados{
	
	public List<TaxiTrajectory> readFile(String fileName) throws FileNotFoundException {
		List<TaxiTrajectory> taxis = new ArrayList<>();

		Scanner scanner = new Scanner(new FileReader(fileName)).useDelimiter("[,\n]");

		while (scanner.hasNext()) {
			Long id = scanner.nextLong();
			String dataStr = scanner.next();
			Date date = ConverteData.stringToDate(dataStr);
			String longitudeStr = scanner.next();
			Double longitude = Double.parseDouble(longitudeStr);
			String latitudeStr = scanner.next();
			Double latitude = Double.parseDouble(latitudeStr);
			taxis.add(new TaxiTrajectory(id, date, longitude, latitude));
			
		}
		scanner.close();
		return taxis;

	}
	
	public String[] getFileNames(){
		File diretorio = new File("files");
		
		File[] arquivos = diretorio.listFiles();
		String[] nomes = new String[arquivos.length];
		for (int i = 0; i<arquivos.length;i++) {
			nomes[i]=arquivos[i].getAbsolutePath();			
		}
		return nomes;
		
	}

}
