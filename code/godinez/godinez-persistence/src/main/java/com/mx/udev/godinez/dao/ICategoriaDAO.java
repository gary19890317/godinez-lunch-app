package com.mx.udev.godinez.dao;

import java.util.List;

import javax.ejb.Local;

import com.mx.udev.godinez.model.CategoriaDTO;
import com.mx.udev.godinez.vo.CategoriaVO;

/**
 * The Interface ICategoriaDAO.
 */
@Local
public interface ICategoriaDAO extends IGenericDAO<CategoriaDTO>{
	
	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	List<CategoriaVO> getAllCategories();
	
}
