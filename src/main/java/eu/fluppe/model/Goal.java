package eu.fluppe.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import java.util.List;
import java.util.ArrayList;

import eu.fluppe.model.Exercise;

@Entity
@Table(name="goals")
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goals_seq_gen")
	@SequenceGenerator(name = "goals_seq_gen", sequenceName = "goals_id_seq")
	private Long id;


	@Range(min=1,max=120)
	@Column(name="MINUTES")
	private int minutes;

	@OneToMany(mappedBy="goal", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Exercise> exercises = new ArrayList<Exercise>();


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExcercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
}