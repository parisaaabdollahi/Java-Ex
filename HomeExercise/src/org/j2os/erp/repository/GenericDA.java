package org.j2os.erp.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public  class GenericDA<T, ID> {
    @PersistenceContext
    private EntityManager entityManager;


    public void insert(T t) {
        entityManager.persist(t);
    }


    public void update(T t) {
        entityManager.merge(t);
    }


    public void remove(T t) {
        entityManager.remove(entityManager.merge(t));
    }

    public List<T> selectAll(Class<T> tClass) {
        Entity entity = tClass.getAnnotation(Entity.class);
        String entityName = entity.name();
        Query query = entityManager.createQuery("select o from " + entityName + " o");
        return query.getResultList();
    }

    //WARNING: SQL INJECTION
    public List<T> selectAll(Class<T> tClass, String where) {
        Entity entity = tClass.getAnnotation(Entity.class);
        String entityName = entity.name();
        Query query = entityManager.createQuery("select o from " + entityName + " o " + where);
        return query.getResultList();
    }

    public List<T> selectAll(Class<T> tClass, String afterWhere, Map<String, Object> map) {
        Entity entity = tClass.getAnnotation(Entity.class);
        String entityName = entity.name();
        Query query = entityManager.createQuery("select o from " + entityName + " o where " + afterWhere);
        for (String paramName : map.keySet()) {
            query.setParameter(paramName, map.get(paramName));
        }
        return query.getResultList();
    }
    public List<T> selectAllByNamedQuery(String namedQuery, Map<String, Object> map) {

        Query query = entityManager.createNamedQuery(namedQuery);
        for (String paramName : map.keySet()) {
            query.setParameter(paramName, map.get(paramName));
        }
        return query.getResultList();
    }
    public T selectOne(Class<T> tClass, ID id) {
        return entityManager.find(tClass, id);
    }

}
