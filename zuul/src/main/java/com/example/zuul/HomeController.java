package com.example.zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;

@Controller
public class HomeController {

//    @GetMapping("/")
//    public String index(Model model) {
//        return "index";
//    }

    @Value("${ssoServiceUrl:placeholder}")
    private String ssoServiceUrl;

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws MalformedURLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:" + ssoServiceUrl + "/logout.do";
    }
}
