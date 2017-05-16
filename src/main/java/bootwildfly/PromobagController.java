package bootwildfly;

import dao.UserDaoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromobagController {


    @RequestMapping("hello")
    public String sayHello(){
        return ("Hello, SpringBoot on Wildfly");
    }

    @RequestMapping("/health/check")
    public String healthCheck(){
        return "Status OK - Promobag server";
    }

    @RequestMapping("/user")
    public String getuser(){
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.getUserByName("vincenzo");
    }
}