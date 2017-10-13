package com.itservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itservice.constant.URI;
import com.itservice.model.Person;
import com.itservice.service.PersonService;


@Controller
@ComponentScan("com.itservice")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping(value = URI.PERSON_LIST, method = RequestMethod.GET)
	public String showAllPersons(Model model) {
		model.addAttribute("persons", personService.list());
		return "persons/list";
	}
	
	@RequestMapping(value = URI.PERSON_INSERT, method = RequestMethod.GET)
	public String showPersonInsertForm(Model model) {
		Person person = new Person();
		person.setId(-1l);
		model.addAttribute("personForm", person);
		return "persons/new";

	}
	
	@RequestMapping(value = { URI.PERSON_INSERT}, method = RequestMethod.POST)
	public String insertPerson(@ModelAttribute("person") Person p, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if(p.getId() == -1){
			p.setId(0);
			personService.save(p);
			redirectAttributes.addFlashAttribute("msg", "User added successfully!");
		}
		else{
			personService.update(p);
			redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
		}
		return "redirect:"+URI.PERSON_LIST;
	}
	
	@RequestMapping(value = URI.PERSON_UPDATE, method = RequestMethod.GET)
	public String updatePerson(@PathVariable("id") long id, Model model) {
		Person person = personService.findById(id);
		model.addAttribute("personForm", person);
		return "persons/new";
	}

	
	@RequestMapping(value = { URI.PERSON_SHOW}, method = RequestMethod.GET)
	public String showPerson(@PathVariable("id") long id, Model model) {
		Person person = personService.findById(id);
		if (person == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("person", person);

		return "persons/show";
	}
	
	@RequestMapping(value = URI.PERSON_DELETE, method = RequestMethod.POST)
	public String deletePerson(@PathVariable("id") long id, final RedirectAttributes redirectAttributes) {
		System.out.println("****** id");
		personService.delete(id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:"+URI.PERSON_LIST;

	}

}
