/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.abara.mobile.security.auth;

/**
 *
 * @author ucha
 */
public class UserAccessDeniedException extends Exception {

    public UserAccessDeniedException() {
    }

    public UserAccessDeniedException(String message) {
        super(message);
    }
}
