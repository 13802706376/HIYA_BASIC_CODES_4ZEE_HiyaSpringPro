package com.hiya.ee.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller
{
    
    
    @RequestMapping(value = "/hello1")
    public void hello1(HttpServletRequest request) throws Exception {}

    @RequestMapping(value = "/hello2")
    public void hello2(HttpServletRequest request) throws Exception {}

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
