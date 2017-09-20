package com.packtpub.springsecurity.crypto.password;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.packtpub.springsecurity.authentication.encoding.Sha256PasswordEncoderMain;

/**
 * A utility class that can be used to convert passwords to use Sha256 with salt using Spring Security's crypto module.
 *
 * @author Rob Winch
 * @see Sha256PasswordEncoderMain
 */
public class CryptoSha256PasswordEncoderMain {

    public static String encode(String password) {
        StandardPasswordEncoder encoder = new StandardPasswordEncoder();
        String encodedPassword = encoder.encode(password);
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
