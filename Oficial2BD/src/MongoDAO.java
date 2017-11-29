import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO implements
		Persistible<List<TaxiTrajectory>> {

	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection<Document> colecao;

	public MongoDAO() {
		Resultado r = new Resultado();
		mongo = new MongoClient("localhost", 27017);
		mongo.dropDatabase("research");
		db = mongo.getDatabase("research");

		colecao = db.getCollection("TaxiTrajectory");
		r.salvaResultado("Mongo");
	}

	@Override
	public void save(List<TaxiTrajectory> list) {
		for (TaxiTrajectory t : list) {
			colecao.insertOne(new Document().append("taxiID", t.getTaxiID())
					.append("DateTime", t.getDateTime())
					.append("longitude", t.getLongitude())
					.append("latitude", t.getLatitude()));
		}
	}

	public void query(List<TaxiTrajectory> list) {
		FindIterable<Document> iterable = null;
		MongoCollection<Document> colecao = db.getCollection("TaxiTrajectory");
		

		for (TaxiTrajectory t : list) {
			iterable = colecao.find(new Document().append("longitude",
					t.getLongitude()).append("latitude", t.getLatitude()));
			
			}
		}

}