package ru.itmo.spring.lesson6.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ExampleController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @GetMapping("/ex")
    public String example(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        ModelAndView result = new ModelAndView();
//        result.setViewName("example");
//        result.getModel().put("home", "Welcome to project!!");
//        return result;
        model.addAttribute("home", request.getParameter("home"));
        return "example"; // -> templates/index.html
    }
}
