package init.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

    @GetMapping("/set-session")
    public String setSession(HttpSession session) {
        session.setAttribute("username", "usuario123");
        return "Sesión creada con ID: " + session.getId();
    }

    @GetMapping("/get-session")
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username != null) {
            return "Usuario en sesión: " + username;
        } else {
            return "No hay sesión activa";
        }
    }
}