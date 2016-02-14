package com.mx.udev.godinez.dao;

import java.util.Map;

/**
 * The Class GenericDao.
 *
 * @param <T> the generic type
 */
public interface IGenericDAO <T>{
    
	/**
	 * Method that returns the number of entries from a table that meet some
	 * criteria (where clause params).
	 *
	 * @param params            sql parameters
	 * @return the number of records meeting the criteria
	 */
    long countAll(Map<String, Object> params);

    /**
     * Creates the.
     *
     * @param t the t
     * @return the t
     */
    T create(T t);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Object id);

    /**
     * Find.
     *
     * @param id the id
     * @return the t
     */
    T find(Object id);

    /**
     * Update.
     *
     * @param t the t
     * @return the t
     */
    T update(T t);  
}
