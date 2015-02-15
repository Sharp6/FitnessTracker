package eu.fluppe.repository;

import java.util.List;

import eu.fluppe.model.Goal;
import eu.fluppe.model.GoalReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {
	
	@PersistenceContext
	private EntityManager em;

	public Goal save(Goal goal) {
		em.persist(goal);
		em.flush();
		return goal;
	}

	public List<Goal> loadAll() {
		Query query = em.createQuery("Select g from Goal g");
		List goals = query.getResultList();
		return goals;
	}

	public List<GoalReport> findAllGoalReports() {
		Query query = em.createQuery("Select new eu.fluppe.model.GoalReport(g.minutes,e.minutes,e.activity)" +
			"from Goal g, Exercise e where g.id = e.goal.id");
		return query.getResultList();
	}
}