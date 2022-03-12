package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LectureService;

import javax.annotation.Resource;
import java.sql.SQLException;

@Controller
public class HelloController {

    @Resource(name = "lectureServiceImpl")
    LectureService lectureService;

    @RequestMapping(value = "/helloBody", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello Body";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloBody() throws SQLException, ClassNotFoundException {
        lectureService.getLectures();
        return "hello";
    }
}
