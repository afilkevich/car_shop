package com.shop.dao.impl;

import com.shop.dao.BrandDAO;
import com.shop.model.Brand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger LOGGER = LogManager.getLogger();

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Brand> findAll() {
        LOGGER.debug("findAll()");
        String query="from Brand";
        TypedQuery<Brand> typedQuery=entityManager.createQuery(query, Brand.class);
        return typedQuery.getResultList();
    }

    @Override
    public Brand findByName(String name) {
        LOGGER.debug("findByName() name={}", name);
        TypedQuery<Brand> typedQuery = entityManager.createQuery("select b from Brand b where b.name= :name",Brand
                .class);
        typedQuery.setParameter("name", name);
        return typedQuery.getSingleResult();
    }
}
