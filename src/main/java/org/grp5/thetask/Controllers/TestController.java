package org.grp5.thetask.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {


    @GetMapping("/test1")
    public String getTest1(){
        return "test1";
    }

    @GetMapping("/test2")
    public String getTest2(){
        return "test2";
    }
}
