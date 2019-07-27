package com.example.login.boundary;

import com.example.employee.boundary.AbstractFacade;
import com.example.login.entity.LoginUser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author E238958
 */
@Stateless
public class LoginUserFacade extends AbstractFacade<LoginUser> {

    @PersistenceContext(unitName = "TaxApplication_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginUserFacade() {
        super(LoginUser.class);
    }
    
}
