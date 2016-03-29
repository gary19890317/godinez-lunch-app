package com.mx.udev.godinez.services.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.mx.udev.godinez.dao.ICategoriaDAO;
import com.mx.udev.godinez.services.ICategoriaService;
import com.mx.udev.godinez.vo.CategoriaVO;

/**
 * The Class FondaServiceEJBImpl.
 */
@Stateless
public class CategoriaServiceEJBImpl implements ICategoriaService{

	/** The i categoria dao. */
	@EJB
	private ICategoriaDAO iCategoriaDAO;

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.services.ICategoriaService#getAllCategories()
	 */
	public List<CategoriaVO> getAllCategories() {
		return iCategoriaDAO.getAllCategories();
	}

}
