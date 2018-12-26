package com.fastwheel.frontend;

import java.util.Collection;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fastwheel.fastwheelbackend.DALayer.UserDetailsDAO;
import com.fastwheel.fastwheelbackend.model.UserDetails;

@Controller
public class LoginController {
	@Autowired
	UserDetailsDAO userdao;

	@RequestMapping("/register")
	public String registerpage(Model M) {
		System.out.println("hello");
		M.addAttribute("registerpage", true);
		UserDetails c = new UserDetails();
		M.addAttribute("myuser", c);
		M.addAttribute("haserror", false);
		M.addAttribute("error", "");

		return "index";

	}
	
	@RequestMapping("/login")
	public String loginpage(Model m)
	{
		m.addAttribute("error", false);
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "fastwheel-Login");
		return "index";

	}
	
	
	@RequestMapping("/loginsuccess")
	public String isLoggedin(HttpSession session) 
	{
		
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			if (authority.getAuthority().equals("ROLE_USER")) 
			{
				UserDetails customer = userdao.SelectUser(email);
				session.setAttribute("useremail", customer.getEmailId());
				session.setAttribute("usercartid", customer.getCart_id());
				session.setAttribute("username",customer.getUser_Name());
				session.setAttribute("userlogin", true);
				if(session.getAttribute("proid")!=null)
				{
					return "redirect:/addToCart?product_Name="+(session.getAttribute("proid").toString());
				}
				else
				{
					return "redirect:/";
				}
			} 
			else 
			{
				session.setAttribute("username","Administrator");
				session.setAttribute("userlogin", false);
				return "redirect:/";
			}
		}
		return "redirect:/";
		
	}
	
	
	
	

	@RequestMapping("/flogin")
	public String errorloginpage(Model m) {
		m.addAttribute("error", true);
		m.addAttribute("loginpage", true);
		m.addAttribute("title", "fastwheel-Login");
		return "index";
	}


	
	
	

	@RequestMapping(value = "adduser", method=RequestMethod.POST)
	public String adduser(@Valid @ModelAttribute("myuser") UserDetails myuser, BindingResult br, Model M) {
		if (br.hasErrors()) {
			M.addAttribute("registerpage", true);
			M.addAttribute("myuser", myuser);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "Plese check your data");
			return "redirect:/login";

		} else {

			try {
				System.out.println("im in try block");
				userdao.CreateUserDetails(myuser);
				return "redirect:/register";

			}

			catch (Exception e) {

				M.addAttribute("registerpage", true);

				M.addAttribute("myuser", myuser);

				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data already present");
				return "index";

			}

		}

	}

}
