package com.packtpub.springsecurity.authentication.encoding;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.packtpub.springsecurity.crypto.password.CryptoSha256PasswordEncoderMain;

/**
 * A utility class that can be used to convert passwords to use Sha256 without any salt. This uses Spring Security's old
 * {@link PasswordEncoder} interface. Typically applications should prefer the new crypto module's PasswordEncoder as
 * demonstrated in {@link CryptoSha256PasswordEncoderMain}.
 *
 * @author Rob Winch
 * @see CryptoSha256PasswordEncoderMain
 */
public class Sha256PasswordEncoderMain {

    public static String encode(String password) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        String encodedPassword = encoder.encodePassword(password, null);
        return encodedPassword;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String password = "user1";
        if (args.length > 1) {
            password = args[0];
        }
        System.out.println(encode(password));
    }

}
