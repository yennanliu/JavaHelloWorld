package com.yen.repository;

// https://www.javachinna.com/jersey-rest-crud-api/

import com.yen.bean.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    // attr
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaScratchDB");
    private EntityManager em;

    // constructor
    public ProductRepository(){

        // create entity manager
        em = emf.createEntityManager();
    }

    // method
    public Product save(Product product){

        // begin transaction
        em.getTransaction().begin();
        // save to DB
        em.persist(product);
        // commit
        em.getTransaction().commit();
        return product;
    }

    public Optional<Product> findById(Long id){

        // begin transaction
        em.getTransaction().begin();
        // find by id
        Product product = em.find(Product.class, id);
        // commit
        em.getTransaction().commit(); // TODO : check if necessary
        // if product != null, return Optional.of(product)
        // else, return Optional.empty()
        return product != null ? Optional.of(product) : Optional.empty();
    }


    // TODO : check below syntax
    @SuppressWarnings("unchecked")
    public List<Product> findAll(){

        // TODO : check below syntax
        return em.createQuery("from product").getResultList();
    }

    public Product update(Product product){

        // begin transaction
        em.getTransaction().begin();
        // merge // TODO : double check
        product = em.merge(product);
        em.getTransaction().commit();
        return product;
    }

    public void deleteById(Long id){

        em.getTransaction().begin();
        // NOTE : find record by em.find(Product.class, id)
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
    }


    public void close(){

        // close entity manager
        em.close();
    }
}
