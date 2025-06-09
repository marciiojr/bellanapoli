package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerRedirectController {
    @GetMapping("/swagger-ui")
    public String redirectToSwaggerUI() {
        return "redirect:/webjars/swagger-ui/5.17.1/index.html?configUrl=/swagger-config.yaml";
    }
}
