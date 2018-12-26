package com.fastwheel.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastwheel.fastwheelbackend.DALayer.CategoryDAO;

@Controller
public class HomeController {
	@RequestMapping({"/","/index"})
	public String carouselpage(Model M)
	{
	M.addAttribute("carouselpage",true);
	return "index";
	}
	
	@RequestMapping("/aboutus")
	public String aboutuspage(Model M)
	{
		M.addAttribute("aboutuspage",true);
		return "index";
	}
	

	@RequestMapping("/contactus")
	public String contactuspage(Model M)
	{
		M.addAttribute("contactuspage",true);
		return "index";
	}
	
	@RequestMapping(value = { "/Login" })
	public String loginpage(Model m) {
		m.addAttribute("error", false);
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "fastwheel-login");
		return "index";

	}

}
