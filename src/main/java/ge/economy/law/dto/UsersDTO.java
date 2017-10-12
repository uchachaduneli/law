/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.abara.mobile.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.abara.mobile.misc.JsonDateSerializeSupport;
import ge.abara.mobile.model.UserTypes;
import ge.abara.mobile.model.Users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author uchachaduneli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDTO {

    private Integer userId;
    private String username;
    private String password;
    private Integer typeId;
    private UserTypes type;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String whatsapp;
    private String viber;
    private String skype;
    private Integer statusId;
    private Integer restaurantId;
    @JsonSerialize(using = JsonDateSerializeSupport.class)
    private Timestamp insertDate;

    public static int ACTIVE_USER = 1;
    public static int NOT_ACTIVE_USER = 2;

    public static int USER_ADMIN = 3;
    public static int USER_ADMIN_MANAGER = 4;
    public static int USER_RESTAURANT = 1;
    public static int USER_RESTAURANT_MANAGER = 2;

    public static UsersDTO parse(Users user, boolean sensitiveInfo) {

        UsersDTO userDTO = new UsersDTO();

        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setWhatsapp(user.getWhatsapp());
        userDTO.setStatusId(user.getStatusId());
        userDTO.setTypeId(user.getType().getTypeId());
        userDTO.setType(user.getType());
        userDTO.setEmail(user.getEmail());
        userDTO.setViber(user.getViber());
        userDTO.setSkype(user.getSkype());
        userDTO.setRestaurantId(user.getRestaurantId());
        userDTO.setInsertDate(user.getInsertDate());

        return userDTO;
    }

    public static List<UsersDTO> parseToList(List<Users> users, boolean sensitiveInfo) {

        List<UsersDTO> dTOs = new ArrayList<UsersDTO>();
        for (Users p : users) {
            dTOs.add(UsersDTO.parse(p, sensitiveInfo));
        }
        return dTOs;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public static int getActiveUser() {
        return ACTIVE_USER;
    }

    public static void setActiveUser(int activeUser) {
        ACTIVE_USER = activeUser;
    }

    public static int getNotActiveUser() {
        return NOT_ACTIVE_USER;
    }

    public static void setNotActiveUser(int notActiveUser) {
        NOT_ACTIVE_USER = notActiveUser;
    }

    public static int getUserAdmin() {
        return USER_ADMIN;
    }

    public static void setUserAdmin(int userAdmin) {
        USER_ADMIN = userAdmin;
    }

    public static int getUserRestaurant() {
        return USER_RESTAURANT;
    }

    public static void setUserRestaurant(int userRestaurant) {
        USER_RESTAURANT = userRestaurant;
    }

    public static int getUserRestaurantManager() {
        return USER_RESTAURANT_MANAGER;
    }

    public static void setUserRestaurantManager(int userRestaurantManager) {
        USER_RESTAURANT_MANAGER = userRestaurantManager;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getViber() {
        return viber;
    }

    public void setViber(String viber) {
        this.viber = viber;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public UserTypes getType() {
        return type;
    }

    public void setType(UserTypes type) {
        this.type = type;
    }
}
