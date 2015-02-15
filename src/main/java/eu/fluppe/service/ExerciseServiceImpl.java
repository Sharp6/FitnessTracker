package eu.fluppe.service;

import eu.fluppe.model.Activity;
import eu.fluppe.model.Exercise;

import eu.fluppe.repository.ExerciseRepository;

import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service("exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	public List<Activity> findAllActivities() {		

		List<Activity> activities = new ArrayList<Activity>();

		Activity run = new Activity();
		run.setDesc("Running");
		activities.add(run);

		Activity bike = new Activity();
		bike.setDesc("Biking");
		activities.add(bike);

		Activity swim = new Activity();
		swim.setDesc("Swimming");
		activities.add(swim);

		return activities;
	}

	@Transactional
	public Exercise save(Exercise exercise) {
		exerciseRepository.save(exercise);
		return exercise;
	}

}