package com.twistezo.services;

/**
 * 
 * @author twistezo
 *
 */

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}