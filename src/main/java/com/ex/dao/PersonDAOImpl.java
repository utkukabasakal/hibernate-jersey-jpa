package com.ex.dao;

import com.ex.model.Person;
import com.ex.util.JPAUtil;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Log4j
public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public PersonDAOImpl() {
        entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityTransaction = entityManager.getTransaction();
    }

    @Override
    public Person findbyId(Integer id) {
        try {
            Person person = entityManager.find(Person.class, id);
            log.info(person.toString() + " veri bulundu.");
            return person;
        } catch (Exception e) {
            log.error(id + " idli person bulunamadı.  Hata: " + e);
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        try {
            log.info("Kayıtlar alındı.");
            return entityManager.createQuery("SELECT person FROM Person AS person")
                    .getResultList();
        } catch (Exception e) {
            log.error("Person kaydı alınırken hata oluştu.  Hata: " + e);
        }
        return null;
    }

    @Override
    public void insert(Person person) {
        try {
            entityTransaction.begin();
            entityManager.persist(person);
            entityTransaction.commit();
            log.info(person.toString() + " kaydı eklendi.");
        } catch (Exception e) {
            log.error(person.toString() + " kaydı eklenirken hata oluştu.  Hata: " + e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try {
            entityTransaction.begin();
            Person person = entityManager.find(Person.class, id);
            log.info(person.toString() + " kaydı silindi.");
            if (person != null) {
                entityManager.remove(person);
                entityTransaction.commit();
            }
        } catch (Exception e) {
            log.error(id + " idli kayıt silinirken hata oluştu.  Hata: " + e);
        }
    }

    @Override
    public void delete(Person person) {
        try {
            entityTransaction.begin();
            entityManager.remove(person);
            entityTransaction.commit();
            log.info(person.toString() + " kaydı silindi.");
        } catch (Exception e) {
            log.error(person.toString() + " kaydı silinirken hata oluştu.  Hata: " + e);
        }
    }

    @Override
    public void update(Person person) {
        try {
            entityTransaction.begin();
            entityManager.merge(person);
            entityTransaction.commit();
            log.info(person.toString() + " kaydı güncellendi.");
        } catch (Exception e) {
            log.error(person.toString() + " kaydı güncellenirken hata oluştu.  Hata: " + e);
        }
    }
}