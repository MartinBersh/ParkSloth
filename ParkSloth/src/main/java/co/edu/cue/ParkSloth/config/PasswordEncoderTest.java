package co.edu.cue.ParkSloth.config;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "password123";  // Aquí la contraseña en
        // texto plano
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);  // Aquí verás la contraseña en formato BCrypt
    }
}
