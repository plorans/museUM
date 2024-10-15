package com.um.museo.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderStandaloneExample {
    public static void main(String[] args) {
        // Crear un BCryptPasswordEncoder con un factor de fuerza de 10
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        // Contraseña en texto plano
        String rawPassword = "123456";

        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Imprimir la contraseña codificada
        System.out.println("Contraseña codificada: " + encodedPassword);

        // Verificar si una contraseña en texto plano coincide con una contraseña codificada
        String inputPassword = "123456";
        boolean matches = passwordEncoder.matches(inputPassword, encodedPassword);
        System.out.println("La contraseña coincide: " + matches);
        
    }
}
