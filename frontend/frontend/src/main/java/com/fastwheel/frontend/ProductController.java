package com.fastwheel.frontend;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fastwheel.fastwheelbackend.DALayer.CategoryDAO;
import com.fastwheel.fastwheelbackend.DALayer.ProductDAO;
import com.fastwheel.fastwheelbackend.model.Product;



@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
    @Autowired
    CategoryDAO CategoryDAO;
    
    
    void addimage(MultipartFile f, int id) {
		try {
			String path = "E:\\Fastwheel\\frontend\\src\\main\\webapp\\resources\\productimages\\";//location that u copied
			path = path + String.valueOf(id) + ".jpg";
			if (!f.isEmpty()) {
				byte[] imagebytes = f.getBytes();
				File x = new File(path);
				if (x.exists()) {
					x.delete();
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				} else {
					BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
					bs.write(imagebytes);
					bs.close();
				}
			}
			Thread.sleep(5000);
		} catch (Exception e) {

		}	}	
    
	@RequestMapping("/admin/product")
	public String productpage(Model M) 
	{
		M.addAttribute("editmode",false);
		M.addAttribute("product",new Product());
		M.addAttribute("productpage",true);
		M.addAttribute("prodlist",productDAO.SelectAllProduct());
		M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
		M.addAttribute("haserror", false);
		M.addAttribute("error","");
		return "index";
	}
	
	@RequestMapping("/admin/CreateProduct")
	public String CreateProduct(@Valid @ModelAttribute("product")Product product,BindingResult br,Model M) 
	{
		if(br.hasErrors())
		{
		M.addAttribute("editmode",false);
		M.addAttribute("product",product);
		M.addAttribute("productpage", true);
		M.addAttribute("prodlist",productDAO.SelectAllProduct());
		M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
		M.addAttribute("haserror", true);
		M.addAttribute("error","Please check your data");
		System.out.println("fg");
		
		return "index";
		}
		else
		{
			try
			{
			productDAO.CreateProduct(product);
			System.out.println("fg2");
			addimage(product.getPimage(), product.getProduct_id());
			return "redirect:/admin/product";
			
			}
			catch(Exception e)
			{
				System.out.println("fg3");
				
				M.addAttribute("editmode",false);
				M.addAttribute("product",new Product());
				M.addAttribute("productpage", true);
				
				M.addAttribute("prodlist",productDAO.SelectAllProduct());
				M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
				M.addAttribute("haserror",true);
				M.addAttribute("error","Already data present");
				return "index";
			}
		}
		
	}
	
	@RequestMapping("/admin/deleteproduct")
	public String deleteproduct(@RequestParam("product_Name")String Product_Name,Model M)
	{
		Product c=productDAO.SelectProduct(Product_Name);
		productDAO.DeleteProduct(c);
		return "redirect:/admin/product";
		
		
	}
	
	@RequestMapping("/admin/editproduct")
	public String editproduct(@RequestParam("product_Name")String product_Name,Model M)
	{
		
		M.addAttribute("editmode",true);
		M.addAttribute("product", productDAO.SelectProduct(product_Name));
		M.addAttribute("productpage", true);
		M.addAttribute("prodlist",productDAO.SelectAllProduct());
		M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
		M.addAttribute("haserror",false);
		return "index";
	}
	
	
	@RequestMapping("/admin/updateproduct")
	public String updateproduct(@Valid @ModelAttribute("product")Product product,BindingResult br,Model M) 
	{
		if(br.hasErrors())
		{
		M.addAttribute("editmode",false);
		M.addAttribute("productpage", true);
		M.addAttribute("product",product);
		M.addAttribute("prodlist",productDAO.SelectAllProduct());
		M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
		M.addAttribute("haserror", true);
		M.addAttribute("error","Please check your data");
		return "index";
		}
		else
		{
			try
			{
			productDAO.UpdateProduct(product);
			addimage(product.getPimage(), product.getProduct_id());
			return "redirect:/admin/product";
			}
			catch(Exception e)
			{
				M.addAttribute("editmode",false);
				M.addAttribute("productpage", true);
				M.addAttribute("product",product);
				M.addAttribute("prodlist",productDAO.SelectAllProduct());
				M.addAttribute("catlist", CategoryDAO.ViewAllCategory());
				M.addAttribute("haserror",true);
				M.addAttribute("error","Already data present");
				return "index";
			}
		}
		
	}
	
	
	@RequestMapping("/viewproducts")
	public String viewallproduct(Model M)
	{
		
		M.addAttribute("prodlist", productDAO.SelectAllProduct());
		M.addAttribute("viewproductpage", true);
		return "index";
	}
	
	
	@RequestMapping("/oneproduct")
	public String oneproductpage(@RequestParam("product_Name")String product_Name, Model M) 
	{
		M.addAttribute("product", productDAO.SelectProduct(product_Name));
	    M.addAttribute("oneproductpage",true);
	    return "index";
	
}
	
	
}

	