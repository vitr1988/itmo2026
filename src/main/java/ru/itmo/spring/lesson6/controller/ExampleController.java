package ru.itmo.spring.lesson6.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class ExampleController {

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @GetMapping("/ex")
    public ModelAndView example(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        ModelAndView result = new ModelAndView();
        result.setViewName("example");
        final String text = request.getParameter("text");
        if (StringUtils.isNotEmpty(text)) {
            result.getModel().put("welcomeText", text);
        }
        return result;
    }
}
