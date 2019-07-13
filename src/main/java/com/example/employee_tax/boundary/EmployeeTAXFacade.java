package com.example.employee_tax.boundary;

import com.example.employee_tax.entity.EmployeeTAX;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E238958
 */
@Stateless
public class EmployeeTAXFacade extends AbstractFacade<EmployeeTAX> {

    @PersistenceContext(unitName = "TaxApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeTAXFacade() {
        super(EmployeeTAX.class);
    }
    
}
