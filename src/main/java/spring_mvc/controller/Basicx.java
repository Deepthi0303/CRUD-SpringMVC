package spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring_mvc.dao.To_Database;
import spring_mvc.dto.Student_credential;

@Controller
public class Basicx {
	
	@Autowired
	To_Database database;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insertData(@ModelAttribute Student_credential credential) {
		System.out.println(credential);
		String msg=database.insert(credential);
		return "Data Inserted";
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteData(@ModelAttribute Student_credential credential) {
		String msg=database.delete(credential.getEmail());
		return msg;
	}
	
	@RequestMapping("/fetch")
	public ModelAndView fetch(@ModelAttribute Student_credential credential) {
		System.out.println(credential.getEmail());
		Object o = database.fetch(credential.getEmail());
		ModelAndView modelAndView=new ModelAndView("display1.jsp");
		modelAndView.addObject("obj1",o);
		return modelAndView;
	}
	
	@RequestMapping("/fetchAll")
	public ModelAndView fetchAll() {
		Object o = database.findAll();
		ModelAndView modelAndView=new ModelAndView("display.jsp");
		modelAndView.addObject("obj",o);
		return modelAndView;
	}
	
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll() {
		String msg=database.deleteAll();
		return msg;
	}
	
	@RequestMapping("/update")
	public ModelAndView Update(@ModelAttribute Student_credential credential) {
		database.update(credential);
		Object o = database.findAll();
		ModelAndView modelAndView=new ModelAndView("display.jsp");
		modelAndView.addObject("obj",o);
		return modelAndView;
	}
	
	@RequestMapping("/deleteupdate")
	public ModelAndView deleteUpdate(@ModelAttribute Student_credential credential) {
		database.delete(credential.getEmail());
		Object o=database.findAll();
		ModelAndView modelAndView=new ModelAndView("display.jsp");
		modelAndView.addObject("obj",o);
		return modelAndView;
	}
}
