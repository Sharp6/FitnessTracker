package eu.fluppe.service;

import eu.fluppe.model.Goal;
import eu.fluppe.model.GoalReport;

import java.util.List;

public interface GoalService {
	public Goal save(Goal goal);	
	public List<Goal> findAllGoals();
	public List<GoalReport> findAllGoalReports();
}