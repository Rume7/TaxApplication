package com.example.employee.boundary;

import com.example.employee.entity.EmployeeEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E238958
 */
@Stateless
public class EmployeeEntityFacade extends AbstractFacade<EmployeeEntity> {

    @PersistenceContext(unitName = "TaxApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeEntityFacade() {
        super(EmployeeEntity.class);
    }
    
}
