package com.shop.dao.impl;

import com.shop.dao.BrandDAO;
import com.shop.model.Brand;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by master on 16.4.18.
 */
@Repository
public class BrandDAOImpl implements BrandDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Brand> findAll() {
        System.out.println("find ALL brands");
        String query="from Brand";
        TypedQuery<Brand> typedQuery=entityManager.createQuery(query, Brand.class);
        return typedQuery.getResultList();
    }
}
