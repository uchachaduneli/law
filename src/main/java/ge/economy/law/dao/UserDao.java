/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.abara.mobile.dao;

import ge.abara.mobile.dto.MobileUsersDTO;
import ge.abara.mobile.model.MobileUsers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author ucha
 */
@Repository
public class UserDao extends AbstractDao<MobileUsers> {

    @PersistenceContext(unitName = "restaurant")
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    public List<MobileUsers> login(String username, String password, int loginType) {
        StringBuilder q = new StringBuilder();
        q.append("Select e From ").append(MobileUsers.class.getSimpleName()).
                append(" e Where e.username ='").append(username).append("'");
        if (loginType == MobileUsersDTO.LOGIN_TYPE_USER_PASS) {
            q.append(" and e.password ='").append(password).append("'");
        }

        TypedQuery<MobileUsers> query = entityManager.createQuery(q.toString(), MobileUsers.class);
        return query.getResultList();
    }

}
