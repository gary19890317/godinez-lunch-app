package com.mx.udev.godinez.services;

import java.util.List;

import javax.ejb.Local;

import com.mx.udev.godinez.vo.CategoriaVO;

/**
 * The Interface IFondaService.
 */
@Local
public interface ICategoriaService {
	
	/**
	 * Gets the all categories.
	 *
	 * @return the all categories
	 */
	List<CategoriaVO> getAllCategories();
}
