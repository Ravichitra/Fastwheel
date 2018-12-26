package com.fastwheel.fastwheelbackend.DALayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fastwheel.fastwheelbackend.model.Address;

@Repository("AddressDAO")
@Transactional

public class AddressDAOImpl implements AddressDAO {
	
	@Autowired
	SessionFactory sf;

	public boolean CreateAddress(Address address) {

		try {
			sf.getCurrentSession().save(address);

			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean UpdateAddress(Address address) {
		try {
			sf.getCurrentSession().update(address);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public boolean DeleteAddress(int id) {
		try {

			sf.getCurrentSession().delete(SelectoneAddress(id));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Address> SelectallAddress(int cartid) {
		try {
			return sf.getCurrentSession().createQuery("from Address where cartid=" + cartid).list();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;

		}
	}

	public Address SelectoneAddress(int addressid) {
		try {
			System.out.println("2");
			return (Address) sf.getCurrentSession().createQuery("from Address where addressid=" + addressid)
					.uniqueResult();
		}

		catch (Exception e) {
			return null;

		}
	}
}

	
	
	