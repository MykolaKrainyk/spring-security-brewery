package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class PasswordEncodingTest {

    static final String PASSWORD = "password";

    @Test
    void hashingExample() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        //simple algorithm - always generates same value all the times. Not recommended
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

        //might be salted, adding some string value. may harder to guess
        String salted = PASSWORD + "ThisIsMySaltValue";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));
    }
}
