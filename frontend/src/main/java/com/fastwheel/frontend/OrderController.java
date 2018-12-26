package com.fastwheel.frontend;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fastwheel.fastwheelbackend.DALayer.AddressDAO;
import com.fastwheel.fastwheelbackend.DALayer.CartDAO;
import com.fastwheel.fastwheelbackend.DALayer.OrderDAO;
import com.fastwheel.fastwheelbackend.DALayer.ProductDAO;
import com.fastwheel.fastwheelbackend.model.Cart;
import com.fastwheel.fastwheelbackend.model.OrderDetails;
import com.fastwheel.fastwheelbackend.model.Product;

@Controller
public class OrderController {

	

		@Autowired
		CartDAO cartdao;
		
		@Autowired
		OrderDAO orderdao;
		
		@Autowired
		AddressDAO addressdao;
		
		@Autowired
		ProductDAO productdao;
		
		@RequestMapping("/user/placeorder")
		String placeOrder(@RequestParam("addid")int id,HttpSession session)
		{
			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartdao
					.ViewAllProduct(Integer.parseInt(session.getAttribute("usercartid").toString()));
			Iterator<Cart> cartiterator = cartlist.listIterator();
			while (cartiterator.hasNext())
			{
				Cart cart2 = (Cart) cartiterator.next();
				Long uuid=UUID.randomUUID().getMostSignificantBits();
				String oid="OD"+uuid.toString().replace('-', '2');
				OrderDetails order=new OrderDetails();
				Product p=productdao.SelectProduct(cart2.getProduct_Name());
				int qty=p.getQuantity()-cart2.getQuantity();
				System.out.println(qty);
				p.setQuantity(qty);
				productdao.UpdateProduct(p);
				order.setOrderid(oid);
				order.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
				order.setAddid(id);
				order.setOdate(new Date(2018, 12, 22));
				order.setPid(cart2.getPid());
				order.setProduct_Name(cart2.getProduct_Name());
				order.setQuantity(cart2.getQuantity());
				order.setPrice(cart2.getSubtotal());
				orderdao.Placeorder(order);
				cartdao.DeleteCart(cart2.getNoid()); 
			}
			return "redirect:/user/viewOrders";
		}
		
		@RequestMapping("/user/viewOrders")
		String viewOrders(Model m,HttpSession session)
		{
			m.addAttribute("orderlist",orderdao.ViewOrder(Integer.parseInt(session.getAttribute("usercartid").toString())));
			m.addAttribute("orderpage",true);
			return"index";
			
		}
		
		@RequestMapping("/user/viewbill")
		String viewBills(Model m,HttpSession session,@RequestParam("orderid")String id)
		{
			OrderDetails o=orderdao.Showorder(id);
			m.addAttribute("order",o);
			m.addAttribute("address",addressdao.SelectoneAddress(o.getAddid()));
			m.addAttribute("billpage",true);
			return"index";
			
		}
		
		
	}
	
	

