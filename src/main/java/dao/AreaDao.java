/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.AreaEntity;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import utils.GenericDao;

/**
 *
 * @author Dallagnol
 */
@RequestScoped
public class AreaDao extends GenericDao<AreaEntity, Long>{
    
    
    public AreaEntity findById(Long id){
        AreaEntity a = null;
        
        @SuppressWarnings("unchecked")
		List<AreaEntity> areas = (List<AreaEntity>) this.executeQuery("select a from AreaEntity a where a.codigo = ?0", id);   
        
        for (AreaEntity area : areas) {
            a = area;
            System.out.println(area);
        }
        return a;
    }
}
