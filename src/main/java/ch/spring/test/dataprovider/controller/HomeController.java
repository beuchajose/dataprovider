package ch.spring.test.dataprovider.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/")
@Controller
public class HomeController {

    @RequestMapping
    @ResponseBody
    private String home() {
        return "Home sweet home!";
    }

}