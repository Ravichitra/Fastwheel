package com.fastwheel.frontend;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastwheel.fastwheelbackend.DALayer.CategoryDAO;
import com.fastwheel.fastwheelbackend.model.MyCategory;

@Controller
public class CategoryController {
	@Autowired
	CategoryDAO CategoryDAO;

	@RequestMapping("/admin/categoryform")
	public String categorypage(Model M) {
		M.addAttribute("editmode",false);
		MyCategory c = new MyCategory();
		M.addAttribute("category", c);
		M.addAttribute("categorypage", true);
		M.addAttribute("haserror", false);
		M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
		return "index";
	}

	@RequestMapping("/admin/CreateCategory")
	public String CreateCategory(@Valid @ModelAttribute("category") MyCategory category, BindingResult br, Model M) {
		if (br.hasErrors()) {
			M.addAttribute("category", category);
			M.addAttribute("categorypage", true);
			M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
			M.addAttribute("haserror", true);
			M.addAttribute("error", "please check your data");
			return "index";

		} else {
			try {
				CategoryDAO.CreateCategory(category);
				return "redirect:/admin/categoryform";
			} catch (Exception e) {
				M.addAttribute("category", category);
				M.addAttribute("categorypage", true);

				M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}


	@RequestMapping("/admin/deletecategory")
	public String deletecategory(@RequestParam("catname")String catname,Model m)
	{
		m.addAttribute("editmode",false);
		CategoryDAO.DeleteCategory(catname);
		return "redirect:/admin/categoryform";
	}
	@RequestMapping("/admin/editcategory")
	public String editCategory(@RequestParam("catname")String catname,Model m)
	{
		
		m.addAttribute("editmode", true);
		
		m.addAttribute("category",CategoryDAO.ViewOneCategory(catname));
		m.addAttribute("catlist",CategoryDAO.ViewAllCategory());
		m.addAttribute("categorypage", true);
		m.addAttribute("haserror", false);
		m.addAttribute("error", "");
		return "index";
	}
	
	@RequestMapping("/admin/updatecategory")
	public String updateCategory(@Valid @ModelAttribute("category") MyCategory category, BindingResult br, Model M) {
		if (br.hasErrors()) {
			M.addAttribute("category", category);
			M.addAttribute("editmode",false);

			M.addAttribute("categorypage", true);
			M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
			M.addAttribute("haserror", true);
			M.addAttribute("error", "please check your data");
			return "index";

		} else {
			try {
				CategoryDAO.UpdateCategory(category);
				return "redirect:/admin/categoryform";
			} catch (Exception e) {
				M.addAttribute("category", category);
				M.addAttribute("categorypage", true);
				M.addAttribute("editmode",false);

				M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";

			}
		}
	}

	
	
}

