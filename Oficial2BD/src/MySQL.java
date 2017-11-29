import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class MySQL implements Persistible<List<TaxiTrajectory>>{

	private EntityManager em;
	private EntityTransaction tx;
	

	public MySQL() {
		Resultado r = new Resultado();
		em = PersistenceUtil.getEntityManager();
		tx = em.getTransaction();
		r.salvaResultado("MySQL");
	}
	
	@Override
	public void save(List<TaxiTrajectory> list) {

		tx.begin();

		for (TaxiTrajectory taxiTrajectory : list)
			em.persist(taxiTrajectory);
		tx.commit();

	}

	public void query(List<TaxiTrajectory> aleatoryList) {

		TypedQuery<TaxiTrajectory> query = em.createQuery(
				"select p from TaxiTrajectory p where p.longitude "
						+ "= :longitude and p.latitude = :latitude",
				TaxiTrajectory.class);
		
		for (TaxiTrajectory t : aleatoryList) {
					
			query.setParameter("longitude", t.getLongitude());
			query.setParameter("latitude", t.getLatitude());

			query.getSingleResult();
			
		}
	}
}
