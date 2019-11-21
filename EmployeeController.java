package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	public EmployeeController() {
		System.out.println("inside EmployeeController CTOR");
	}

	@GetMapping("/register")
	public String showRegister(@RequestParam int deptId ,Employee e)
	{
		System.out.println("inside ShowRegister"+deptId+" "+e);
		return "/employee/register";
	}
	
	@PostMapping("/register")
	public String processRegister(@RequestParam int deptId, Employee e, RedirectAttributes flashMap,Model map)
	{
		System.out.println("inside processRegister"+deptId+" "+e+" "+flashMap);
		if(e.getSalary()>=20000&&e.getSalary()<=30000) 
		{
		flashMap.addFlashAttribute("dept_id", deptId);
		flashMap.addFlashAttribute("emp", e);
				return "redirect:/department/addEmployee";
		}
		else 
		{
			map.addAttribute("msg","Invalid salary....Salary range must be 20000 to 30000 ");
			return "/employee/register";
		}
	}
}
	

