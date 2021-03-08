package com.project.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * 
 *@author Eyüp Ilıkçı
 *@since 08/02/2021
 *@version 1.0.0 
 * 
 **/
public interface JpaSupport{
		EntityManager getManager();
		EntityTransaction getTransaction();
		void clear();
		
}
