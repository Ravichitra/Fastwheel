package com.fastwheel.frontend;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.Iterator;

	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastwheel.fastwheelbackend.DALayer.CartDAO;
import com.fastwheel.fastwheelbackend.DALayer.ProductDAO;
import com.fastwheel.fastwheelbackend.model.Cart;
import com.fastwheel.fastwheelbackend.model.Product;

	
	@Controller
	public class CartController {
		@Autowired
		CartDAO cartdao;

		@Autowired
		ProductDAO productdao;

		@RequestMapping("/addToCart")
		String addToCart(@RequestParam("product_Name") String product_Name, HttpSession session, Model m) {
			if (session.getAttribute("usercartid") != null) {
				Product p = productdao.SelectProduct(product_Name);
				ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
						.ViewAllProduct(Integer.parseInt(session.getAttribute("usercartid").toString()));
				Iterator<Cart> cartiterator = cartlist.listIterator();
				while (cartiterator.hasNext()) {
					Cart cart2 = (Cart) cartiterator.next();
					if (cart2.getProduct_Name().equals(product_Name)) {
						int qty = cart2.getQuantity() + 1;
						if (qty > p.getQuantity()) {
							m.addAttribute("cartpage", true);
							m.addAttribute("title", "fastwheel");
							m.addAttribute("cartlist", cartdao.ViewAllProduct(cart2.getCart_id()));
							m.addAttribute("error1", true);
							m.addAttribute("error", false);
							m.addAttribute("stock", p.getQuantity());
							m.addAttribute("pid", cart2.getPid());
							return "index";

						} else {
							if (qty > 3) {
								m.addAttribute("cartpage", true);
								m.addAttribute("title", "GiftGalore-MyCart");
								m.addAttribute("cartlist", cartdao.ViewAllProduct(cart2.getCart_id()));
								m.addAttribute("error", true);
								m.addAttribute("error1", false);
								m.addAttribute("pid", cart2.getPid());
								return "index";
							}
							else
							cart2.setQuantity(qty);
							cart2.setSubtotal(qty * p.getPrice());
							cartdao.UpdateCart(cart2);
							m.addAttribute("cartpage", true);
							m.addAttribute("title", "GiftGalore-MyCart");
							m.addAttribute("cartlist", cartdao.ViewAllProduct(cart2.getCart_id()));
							m.addAttribute("error", false);
							m.addAttribute("error1", false);
							return "index";
						}

					}
				}
				Cart c = new Cart();
				c.setCart_id(Integer.parseInt(session.getAttribute("usercartid").toString()));
				c.setProduct_Name(p.getProduct_Name());
				int x=1;
				c.setQuantity(x);
				c.setPid(p.getProduct_id());
				c.setPrice(p.getPrice());
				c.setSubtotal(p.getPrice());
				cartdao.CreateCart(c);
				c.setQuantity(1);
				m.addAttribute("title", "Fastwheel cart");
				m.addAttribute("cartpage", true);
				m.addAttribute("cartlist", cartdao.ViewAllProduct(c.getCart_id()));
				m.addAttribute("error", false);
				m.addAttribute("error1", false);
				return "index";

			} else {
				session.setAttribute("proid", product_Name);
				return "redirect:/Login";
			}

		}

		@RequestMapping("/user/viewCart")
		String viewCart(Model m, HttpSession session) {
			int cartid = Integer.parseInt(session.getAttribute("usercartid").toString());
			m.addAttribute("cartpage", true);
			m.addAttribute("title", "fastwheel-Cart");
			m.addAttribute("cartlist", cartdao.ViewAllProduct(cartid));
			m.addAttribute("error", false);
			m.addAttribute("error1", false);
			return "index";
		}

		@RequestMapping("/user/deleteitem")
		public String deleteCart(@RequestParam("itemid") int id) {
			cartdao.DeleteCart(id);
			return "redirect:/user/viewCart";
		}

		@RequestMapping("/user/incqty")
		public String incqty(@RequestParam("itemid") int id, Model m) {
			Cart c = cartdao.ShowOneProduct(id);
			int qty = c.getQuantity() + 1;
			int pqty = productdao.SelectProduct(c.getProduct_Name()).getQuantity();
			if (qty > pqty) {
				m.addAttribute("cartpage", true);
				m.addAttribute("title", "fastwheel-cart");
				m.addAttribute("cartlist", cartdao.ViewAllProduct(c.getCart_id()));
				m.addAttribute("error1", true);
				m.addAttribute("error", false);
				m.addAttribute("stock", pqty);
				m.addAttribute("pid", c.getPid());

				return "index";

			} else {
				if (qty > 3) {
					m.addAttribute("cartpage", true);
					m.addAttribute("title", "fastwheel-cart");
					m.addAttribute("cartlist", cartdao.ViewAllProduct(c.getCart_id()));
					m.addAttribute("error", true);
					m.addAttribute("error1", false);
					m.addAttribute("pid", c.getPid());
					return "index";
				} else {
					c.setQuantity(qty);
					c.setSubtotal(c.getPrice() * qty);
					
					cartdao.UpdateCart(c);
					return "redirect:/user/viewCart";
					
					
				}
			}

		}

		@RequestMapping("/user/decqty")
		public String decqty(@RequestParam("itemid") int id, Model m) {
			Cart c = cartdao.ShowOneProduct(id);
			int qty = c.getQuantity() - 1;
			if (qty == 0) {
				m.addAttribute("cartpage", true);
				m.addAttribute("title", "fastwheel-cart");
				m.addAttribute("cartlist", cartdao.ViewAllProduct(c.getCart_id()));
				m.addAttribute("error", true);
				m.addAttribute("pid", c.getPid());
				m.addAttribute("error1", false);
				return "index";
			} else {
				c.setQuantity(qty);
				c.setSubtotal(c.getPrice() * qty);
				cartdao.UpdateCart(c);
				return "redirect:/user/viewCart";
			}
		}

	}

	
	

