package ge.economy.law.dao;

import ge.economy.law.model.Tables;
import ge.economy.law.model.tables.records.UserRecord;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nino on 7/10/16.
 */

@Repository
public class UserDAO extends AbstractDAO {

    public List<Record> getUsers() {
        return dslContext.
                select().
                from(Tables.USER).
                fetch();
    }

    public UserRecord getUserObjectById(int id) {
        return dslContext.fetchOne(Tables.USER, Tables.USER.USER_ID.eq(id));
    }

    public Record getUserById(int id) {
        return dslContext.select().
                from(Tables.USER).
                where(Tables.USER.USER_ID.eq(id)).fetchAny();
    }


    public List<UserRecord> search(String userName) {

        SelectConditionStep<Record> selectConditionStep =
                dslContext.
                        select().
                        from(Tables.USER).where(Tables.USER.USER_ID.eq(Tables.USER.USER_ID));

        if (userName != null) {
            selectConditionStep.and(Tables.USER.USERNAME.eq(userName));
        }
        return selectConditionStep.fetch().into(UserRecord.class);
    }

    public Record getUser(String username, String password) {
        return dslContext
                .select()
                .from(Tables.USER)
                .where(Tables.USER.USERNAME.eq(username))
                .and(Tables.USER.PASSWORD.eq(password))
                .fetchOne();

    }


    public void deleteUser(int itemId) {
        dslContext.deleteFrom(Tables.USER).where(Tables.USER.USER_ID.eq(itemId)).execute();
    }


    public void updateUserPassword(String password, int userId) {
        dslContext.update(Tables.USER).set(Tables.USER.PASSWORD, password).where(Tables.USER.USER_ID.eq(userId)).execute();
    }

}
