package com.mx.udev.godinez.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mx.udev.godinez.dao.IGenericDAO;

/**
 * The Class GenericDAOImpl.
 *
 * @param <T> the generic type
 */
public abstract class GenericDAOImpl<T> implements IGenericDAO<T> {
    
	/** The Constant logger. */
	final static Logger logger = Logger.getLogger(GenericDAOImpl.class);
	
	/** The em. */
	@PersistenceContext(unitName="GodinezService")
    private EntityManager em;

    /**
     * Gets the entity manager.
     *
     * @return the entity manager
     */
    protected EntityManager getEntityManager(){
    	return em;
    }
    
    /** The type. */
    private Class<T> type;
	
    /**
     * Generic dao impl.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /* (non-Javadoc)
     * @see com.mx.udev.godinez.dao.IGenericDAO#countAll(java.util.Map)
     */
    @Override
    public long countAll(final Map<String, Object> params) {

        final StringBuffer queryString = new StringBuffer(
                "SELECT count(o) from ");

        queryString.append(type.getSimpleName()).append(" o ");

        final Query query = this.em.createQuery(queryString.toString());

        return (Long) query.getSingleResult();

    }

    /* (non-Javadoc)
     * @see com.mx.udev.godinez.dao.IGenericDAO#create(java.lang.Object)
     */
    @Override
    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    /* (non-Javadoc)
     * @see com.mx.udev.godinez.dao.IGenericDAO#delete(java.lang.Object)
     */
    @Override
    public void delete(final Object id) {
        this.em.remove(this.em.getReference(type, id));
    }

    /* (non-Javadoc)
     * @see com.mx.udev.godinez.dao.IGenericDAO#find(java.lang.Object)
     */
    @Override
    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

    /* (non-Javadoc)
     * @see com.mx.udev.godinez.dao.IGenericDAO#update(java.lang.Object)
     */
    @Override
    public T update(final T t) {
        return this.em.merge(t);    
    }
}
