package ge.abara.mobile.service;

import ge.abara.mobile.dao.AddUserRequest;
import ge.abara.mobile.dao.UserDao;
import ge.abara.mobile.dto.ErrorCodesDTO;
import ge.abara.mobile.dto.MobileUsersDTO;
import ge.abara.mobile.dto.UsersDTO;
import ge.abara.mobile.model.MobileUsers;
import ge.abara.mobile.model.Restaurants;
import ge.abara.mobile.model.UserTypes;
import ge.abara.mobile.model.Users;
import ge.abara.mobile.utils.GlobalUtils;
import ge.abara.mobile.utils.MD5Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @author ucha
 */
@Service
public class UsersService {

    @Autowired
    private UserDao userDao;

    public List<MobileUsersDTO> getMobileUsers() {
        return MobileUsersDTO.parseToList(userDao.getAll(MobileUsers.class));
    }

    @Transactional
    public MobileUsersDTO addUser(int loginType, String firstName, String lastName, String email, String password,
                                  String pushToken, String phoneNumber, String viber, String skype) throws Exception {

        MobileUsers user = new MobileUsers();

        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setUsername(email);
        user.setPassword(MD5Provider.doubleMd5(password));
        user.setPhoneNumber(phoneNumber);
        user.setViber(viber);
        user.setSkype(skype);
        user.setLoginType(loginType);
        user.setToken(pushToken);
        user = userDao.create(user);

//        if (user.getUserId() != null) {
//            user = userDao.update(user);
//        } else {
//            if (request.getTypeId() == UsersDTO.USER_RESTAURANT) {
//                Restaurants restaurants = new Restaurants();
//                restaurants.setIdentNumber(Integer.valueOf(user.getUsername()));
//                userDao.create(restaurants);
//                user.setRestaurantId(restaurants.getRestaurantId());
//            }
//            user = userDao.create(user);
//
//        }
        return MobileUsersDTO.parse(user);
    }

    public MobileUsersDTO login(String userName, String password, int loginType) {
        List<MobileUsers> users = userDao.login(userName, MD5Provider.doubleMd5(password), loginType);
        MobileUsers u = users != null && !users.isEmpty() ? users.get(0) : null;
        return u != null ? MobileUsersDTO.parse(u) : null;
    }

    @Transactional
    public UsersDTO changePassword(AddUserRequest request) throws IOException {

        Users user = userDao.getEntityManager().find(Users.class, request.getUserId());
        // ვამოწმებთ შეცვლისას მითითებულ ძველ პაროლს, ცვლილებამდე თუ ემთხვევა არსებულს
        if (user.getPassword().equals(MD5Provider.doubleMd5(request.getCurrentPassword()))) {

            if (user.getUserId() != null) {
                user.setPassword(MD5Provider.doubleMd5(request.getPassword()));
                user = userDao.update(user);
            }

            return UsersDTO.parse(user, false);

        } else {
            return null;
        }
    }

    @Transactional
    public MobileUsersDTO restorePassword(String username, String restoreCode, String newPassword) throws Exception {

        MobileUsers user = null;
        try {
            user = (MobileUsers) userDao.getEntityManager().
                    createQuery("SELECT e FROM " + MobileUsers.class.getSimpleName()
                            + " e where e.username = :email"
                            + " and e.restoreCode = :restCode")
                    .setParameter("email", username)
                    .setParameter("restCode", restoreCode)
                    .getSingleResult();

            user.setPassword(MD5Provider.doubleMd5(newPassword));
            user.setRestoreCode(null);
            user = userDao.update(user);
            return MobileUsersDTO.parse(user);
        } catch (javax.persistence.NoResultException e) {// მეილით და პაროლით დამთხვევა ვერ იპოვა
            try {
                userDao.getEntityManager().
                        createQuery("SELECT e FROM " + MobileUsers.class.getSimpleName()
                                + " e where e.username = :email")
                        .setParameter("email", username)
                        .getSingleResult();
                throw new AbaraException("აქტივაციის კოდი არასწორია", 6);// აქ თუ მოვიდა მეილით იპოვა ზნაჩიტ კოდი იყო სწორი
            } catch (javax.persistence.NoResultException ee) {// მეილი არ იყო სწორი
                throw new AbaraException("მომხმარებლის მეილი არასწორია", ErrorCodesDTO.INCORRECT_CLIENT_ID);
            }
        }
    }

    @Transactional
    public MobileUsersDTO resetPassword(String username) throws Exception {

        try {
            MobileUsers user = (MobileUsers) userDao.getEntityManager().
                    createQuery("SELECT e FROM " + MobileUsers.class.getSimpleName() + " e where e.username = :email")
                    .setParameter("email", username).getSingleResult();
            Random rand = new Random();
            String restoreCode = String.format("%04d", rand.nextInt(10000));
            boolean mailSent = GlobalUtils.sendEmail(user.getUsername(), "ABARA პაროლის აღდგენა",
                    "პაროლის აღდგენისთვის გიგზავნით დროებით კოდს: " + restoreCode);
            if (mailSent) {
                user.setRestoreCode(restoreCode);
                userDao.update(user);
                return MobileUsersDTO.parse(user);
            } else {
                throw new AbaraException("მეილის გაგზავნა ვერ მოხერხდა ", ErrorCodesDTO.UNDEFINED_ERRROR);
            }
        } catch (javax.persistence.NoResultException ee) {// მეილი არ იყო სწორი
            throw new AbaraException("მომხმარებლის მეილი არასწორია", ErrorCodesDTO.INCORRECT_CLIENT_ID);
        }
    }

    @Transactional
    public UsersDTO setUpUserRestaurant(int userId, int restaurantId) throws IOException {

        Users user = userDao.getEntityManager().find(Users.class, userId);
        if (user.getUserId() != null) {
            user.setRestaurantId(restaurantId);
            user = userDao.update(user);
        }
        return UsersDTO.parse(user, false);

    }

    @Transactional
    public void deleteUsers(int userId) {
        Users user = userDao.find(Users.class, userId);
        if (user != null) {
            userDao.delete(user);
        }
    }

}
