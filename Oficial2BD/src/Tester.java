public class Tester {

	public static void main(String[] args) {
		
		Experimento eMySQL = new Experimento(new MySQL());
		eMySQL.write();
		eMySQL.read();
		
		Experimento eMongo = new Experimento(new MongoDAO());
		eMongo.write();
		eMongo.read();
		System.out.println("Concluído");
		
	}

}