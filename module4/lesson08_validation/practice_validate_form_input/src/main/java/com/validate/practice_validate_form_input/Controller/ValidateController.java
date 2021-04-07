package com.validate.practice_validate_form_input.Controller;

import com.validate.practice_validate_form_input.models.Input;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ValidateController {
    @GetMapping("/")
    public ModelAndView getFormInput() {
        return new ModelAndView("html", "check", new Input());
    }

    @PostMapping("/check")
    public ModelAndView checkInput(@RequestParam String name, @RequestParam int age, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("html");
        } else {
            return new ModelAndView("result", "result", "Check success" + name + " ," + age);
        }
    }
}
