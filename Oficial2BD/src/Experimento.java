import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Experimento {
	
	private List<TaxiTrajectory> lista = new ArrayList<TaxiTrajectory>();
	private Persistible<List<TaxiTrajectory>> tDAO;

	public Experimento(Persistible<List<TaxiTrajectory>> tDAO){
		this.tDAO = tDAO;
	}
	
	public void read(){
		Resultado r = new Resultado();
		List<TaxiTrajectory> aleatoryList = new ArrayList<TaxiTrajectory>();
		Random generator = new Random();
		for(int i=0; i < 10; i++){
			
			int index = generator.nextInt(lista.size());
			aleatoryList.add(lista.get(index));
			
		}
		Temporizador.start();
		tDAO.query(aleatoryList);		
		Temporizador.stop();
		r.salvaResultado(Temporizador.tempoMilissegundos()+ " ms - read.");
		r.salvaResultado("_________________");
	}
	
	public void write() {
		Resultado r = new Resultado();
		Dados fu = new Dados();
		String[] arquivos = fu.getFileNames();
		for (int i = 0; i < arquivos.length; i++) {
			try {
				lista.addAll(fu.readFile(arquivos[i]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		r.salvaResultado(lista.size()+" trajectories");
		Temporizador.start();
		tDAO.save(lista);
		Temporizador.stop();
		r.salvaResultado(Temporizador.tempoMilissegundos()+ " ms - write.\n");
	}

	
	
	

}
