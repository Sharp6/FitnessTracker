package eu.fluppe.service;

import java.util.List;
import eu.fluppe.model.Activity;
import eu.fluppe.model.Exercise;

public interface ExerciseService {
	public List<Activity> findAllActivities();
	public Exercise save(Exercise exercise);
}