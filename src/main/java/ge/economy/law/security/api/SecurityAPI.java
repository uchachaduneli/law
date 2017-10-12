/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.abara.mobile.security.api;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ucha
 */
public interface SecurityAPI {

    public User getUser(Map<String, Object> map);

    public List<String> getLoginParameters();

    public String getLoginPage();
    
    public String getHomePage();

}
