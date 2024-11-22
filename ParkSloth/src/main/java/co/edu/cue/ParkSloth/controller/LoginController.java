package co.edu.cue.ParkSloth.controller;
import java.util.HashMap;

import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.mapping.mappers.UserMapper;
import co.edu.cue.ParkSloth.repositories.UserRespository;
import org.springframework.http.HttpStatus;

import co.edu.cue.ParkSloth.mapping.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.Map;

@RestController
@RequestMapping("/Login")
class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRespository userRespository;
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserDto userDtoRequested) {
        try {
            UserDto userDto = UserMapper.mapFrom(userRespository.findByUsernameAndPassword(userDtoRequested.username(),
                  userDtoRequested.password()));
            // Autenticar las credenciales del usuario
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.username(), userDto.password()));

            // Si la autenticación es exitosa, guarda la autenticación en el contexto de
            // seguridad
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Retornar respuesta de éxito
            Map<String, String> response = new HashMap<>();
            String rol = authentication.getAuthorities().stream().findFirst().orElse(null).getAuthority();
            response.put("rol", rol);

            // Retornar la respuesta como JSON
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            // Si las credenciales no son válidas, devuelve un estado 401 con un mensaje de
            // error en JSON
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Credenciales no validas");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    }
}