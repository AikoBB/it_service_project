package com.itservice.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itservice.constant.URI;
import com.itservice.form.ProjectForm;
import com.itservice.model.CompanyProject;
import com.itservice.model.PersonProject;
import com.itservice.model.Project;
import com.itservice.service.CompanyService;
import com.itservice.service.PersonService;
import com.itservice.service.ProjectService;

@Controller
@ComponentScan("com.itservice")
@Transactional
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	CompanyService companyService;
	@Autowired
	PersonService personService;
	
	@RequestMapping(value = URI.PROJECT_LIST, method = RequestMethod.GET)
	public String showAllProjects(Model model) {
		model.addAttribute("projects", projectService.list());
		return "projects/list";
	}
	
	@RequestMapping(value = { URI.PROJECT_SHOW}, method = RequestMethod.GET)
	public String showPerson(@PathVariable("id") long id, Model model) {
		Project project = projectService.findById(id);
		System.out.println(project.getPerformers().size()+"show******");
		System.out.println(project.getCompanies().size()+"show******");
	
		model.addAttribute("project", project);
		model.addAttribute("companies", project.getCompanies());
		model.addAttribute("employees",project.getPerformers());
		return "projects/show";
	}
	
	@RequestMapping(value = URI.PROJECT_INSERT, method = RequestMethod.GET)
	public String showProjectInsertForm(Model model) {
		ProjectForm projectForm = new ProjectForm();
		projectForm.setCreated(1);
		model.addAttribute("projectForm", projectForm);
		model.addAttribute("companies",companyService.list());
		model.addAttribute("persons",personService.list());
		return "projects/new";

	}
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");// new SimpleDateFormat("MM-dd-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "project.startDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "project.endDate", new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = { URI.PROJECT_INSERT}, method = RequestMethod.POST)
	public String insertProject(@ModelAttribute("projectForm") ProjectForm form, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		System.out.println(form.getExecuter()+" executer");
		System.out.println(form.getCustomer()+" customer");
		System.out.println(form.getLeader()+" leader");
		System.out.println(form.getPerformers()+" emp");
		System.out.println(form.getCreated()+" created");
		if(form.getCreated()>=0){
			projectService.save(form);
			redirectAttributes.addFlashAttribute("msg", "Project added successfully!");
		}
		else{
			projectService.update(form);
			redirectAttributes.addFlashAttribute("msg", "Project updated successfully!");
		}
		return "redirect:"+URI.PROJECT_LIST;
	}
	
	@RequestMapping(value = URI.PROJECT_UPDATE, method = RequestMethod.GET)
	public String updatePerson(@PathVariable("id") long id, Model model) {
		Project project = projectService.findById(id);
		model.addAttribute("projectForm", getForm(project));
		model.addAttribute("companies",companyService.list());
		model.addAttribute("persons",personService.list());
		return "projects/new";
	}
	
	@RequestMapping(value = URI.PROJECT_DELETE, method = RequestMethod.POST)
	public String deletePerson(@PathVariable("id") long id, final RedirectAttributes redirectAttributes) {
		System.out.println("****** id");
		projectService.delete(id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:"+URI.PROJECT_LIST;

	}
	
	private ProjectForm getForm(Project project){
		ProjectForm form = new ProjectForm();
		form.setCreated(-1);
		form.setProject(project);
		for(CompanyProject cp : project.getCompanies()){
			switch (cp.getRole()) {
			case EXECUTER:
				System.out.println(cp.getPk().getCompany().getTitle()+" executer");
				form.setExecuter(cp.getPk().getCompany().getId());
				break;	
			case CUSTOMER:
				System.out.println(cp.getPk().getCompany().getTitle()+" customer");
				form.setCustomer(cp.getPk().getCompany().getId());
				break;
			default:
				break;
			}
		}
		
		for(PersonProject pp : project.getPerformers()){
			switch (pp.getRole()) {
			case LEADER:
				System.out.println(pp.getPk().getPerson().getName()+" leader");
				form.setLeader(pp.getPk().getPerson().getId());
				break;	
			case EMPLOYEE:
				System.out.println(pp.getPk().getPerson().getName()+" employee");
				form.getPerformers().add(pp.getPk().getPerson().getId());
				break;
			default:
				break;
			}
		}
		return form;
	}

}
