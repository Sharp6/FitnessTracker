package eu.fluppe.model;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.OneToMany;


import javax.persistence.ManyToOne;


@Entity
@Table(name="exercises")
public class Exercise {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercises_seq_gen")
	@SequenceGenerator(name = "exercises_seq_gen", sequenceName = "exercises_id_gen")
	private Long id;

	@Range(min=1,max=120)
	private int minutes;

	@NotNull
	private String activity;

	@ManyToOne
	private Goal goal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	
}
