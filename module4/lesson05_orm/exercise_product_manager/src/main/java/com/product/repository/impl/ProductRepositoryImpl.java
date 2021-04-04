package com.product.repository.impl;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
//        if (product.getId() != null) {
//            entityManager.merge(product);
//        } else {
//            entityManager.persist(product);
//        }
        entityManager.merge(product);
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p WHERE p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public void delete(int id) {
        Product product = findById(id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
