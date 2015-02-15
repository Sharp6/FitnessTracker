package eu.fluppe.repository;

import java.util.List;
import eu.fluppe.model.Goal;
import eu.fluppe.model.GoalReport;

public interface GoalRepository {
	
	public Goal save(Goal goal);
	public List<Goal> loadAll();
	public List<GoalReport> findAllGoalReports();
}