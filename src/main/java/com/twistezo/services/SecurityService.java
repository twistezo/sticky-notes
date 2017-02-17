package com.twistezo.services;

/**
 * 
 * @author twistezo
 *
 */

public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String username, String password);
}