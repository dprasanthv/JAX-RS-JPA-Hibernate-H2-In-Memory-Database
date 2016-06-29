package com.menu.rest.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.menu.rest.model.Item;

@Singleton
public class ItemDaoImpl implements ItemDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("menuItems");

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> findAll() {
		List<Item> list = new ArrayList<Item>();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			list = em.createQuery("from Item").getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	@Override
	public Boolean save(Item item) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(item);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

}
