package cl.bci.api.controller;

import cl.bci.api.util.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"token"})
public class TokenController {
    @GetMapping
    public String getToken() {
        JwtUtil jwt = new JwtUtil();
        return jwt.getJWTToken("admin@nisum.ec");
    }

}
