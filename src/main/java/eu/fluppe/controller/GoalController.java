package eu.fluppe.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;

import eu.fluppe.service.GoalService;
import eu.fluppe.model.Goal;
import eu.fluppe.model.GoalReport;

@Controller
@SessionAttributes("goal")
public class GoalController {

	@Autowired
	private GoalService goalService;

	@RequestMapping(value="addGoal", method=RequestMethod.GET)
	public String addGoal(Model model) {
		Goal goal = new Goal();
		goal.setMinutes(10);
		model.addAttribute("goal", goal);

		return "addGoal";
	}

	@RequestMapping(value="addGoal", method=RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {

		if(result.hasErrors()) {
			return "addGoal";
		} else {
			goalService.save(goal);
			return "redirect:addMinutes.html";	
		}
	}

	@RequestMapping(value="getGoals", method=RequestMethod.GET) 
	public String getGoals(Model model) {
		List<Goal> goals = goalService.findAllGoals();
		model.addAttribute("goals", goals);
		return "getGoals";
	}

	@RequestMapping(value="getGoalReports", method=RequestMethod.GET) 
	public String getGoalReports(Model model) {
		List<GoalReport> goalReports = goalService.findAllGoalReports();
		model.addAttribute("goalReports", goalReports);
		return "getGoalReports";
	}
}