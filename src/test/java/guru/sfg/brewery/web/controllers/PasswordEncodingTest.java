package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncodingTest {

    static final String PASSWORD = "password";

    @Test
    void testLdap() {
        //deprecated
        PasswordEncoder ldap = new LdapShaPasswordEncoder();

        //random salt is used each time different result will be produced
        //ex - {SSHA}ovAmodOyCqZ0Rtx+ubLbve+mnnc7LthIjMJimQ==
        System.out.println(ldap.encode(PASSWORD));
        System.out.println(ldap.encode(PASSWORD));

        String encodedPassword = ldap.encode(PASSWORD);

        assertTrue(ldap.matches(PASSWORD, encodedPassword));
    }

    @Test
    void testNoOp() {
        //deprecated
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();

        //output - "password"
        System.out.println(noOp.encode(PASSWORD));
    }

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
