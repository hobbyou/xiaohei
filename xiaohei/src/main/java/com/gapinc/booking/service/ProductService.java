package com.gapinc.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gapinc.booking.domain.XhProduct;
import com.gapinc.booking.repository.ProductRepository;

@Service
public class ProductService extends BaseService<XhProduct, String> {

	@Autowired
	private ProductRepository productRepository;
	
    public List<XhProduct> findProductList(){
    	String hql="select new com.gapinc.booking.vo.ProductVO(p) from XhProduct p where isDelete=0";
    	return em.createQuery(hql).getResultList();
    }
	 
}
