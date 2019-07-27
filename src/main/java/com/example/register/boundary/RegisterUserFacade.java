package com.example.register.boundary;

import com.example.employee.boundary.AbstractFacade;
import com.example.register.entity.RegisterUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E238958
 */
@Stateless
public class RegisterUserFacade extends AbstractFacade<RegisterUser> {

    @PersistenceContext(unitName = "TaxApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegisterUserFacade() {
        super(RegisterUser.class);
    }
    
}
