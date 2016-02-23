package com.mx.udev.godinez.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.dozer.DozerBeanMapper;

import com.mx.udev.godinez.dao.ICategoriaDAO;
import com.mx.udev.godinez.model.CategoriaDTO;
import com.mx.udev.godinez.vo.CategoriaVO;

/**
 * The Class CategoriaDAOImpl.
 */
@Stateless
public class CategoriaDAOImpl extends GenericDAOImpl<CategoriaDTO> implements ICategoriaDAO{
	
	/** The mapper. */
	private DozerBeanMapper mapper = new DozerBeanMapper(Arrays.asList(new String[]{"META-INF/dozer-global-config.xml"}));

	/* (non-Javadoc)
	 * @see com.mx.udev.godinez.dao.ICategoriaDAO#getAllCategories()
	 */
	public List<CategoriaVO> getAllCategories() {
		List<CategoriaVO> categories = new ArrayList<CategoriaVO>();
		try{
			logger.info("Entity Manager -> " + getEntityManager());
			TypedQuery<CategoriaDTO> query = getEntityManager().createQuery("from CategoriaDTO f", CategoriaDTO.class);
			List<CategoriaDTO> categoriesTmp = query.getResultList();
			if(logger.isDebugEnabled()){
				logger.debug("Restaurant size-> " + categoriesTmp.size());
			}
			if(!categoriesTmp.isEmpty()){
				for(CategoriaDTO cat : categoriesTmp){
					logger.info("Categoría -> " + cat.getId() + " - " + cat.getDescripcion());
					categories.add(mapper.map(cat, CategoriaVO.class, "mapping2_DTO_TO_VO"));
				}
			}
		} catch (NoResultException e) {
			logger.error(e);
		}
		return categories;
	}
	

}
