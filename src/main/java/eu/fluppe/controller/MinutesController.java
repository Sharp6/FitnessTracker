package eu.fluppe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.fluppe.model.Exercise;

@Controller
public class MinutesController {
	
	@RequestMapping(value="/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		return "addMinutes";
	}

	// @RequestMapping(value="/addMoreMinutes")
	// public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
	// 	return "addMinutes";
	// }
}
