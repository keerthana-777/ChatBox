package com.rms.rms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rms.rms.model.User;
import com.rms.rms.service.UserService;

@Controller
public class UserController {
 @Autowired
 private UserService service;

 @GetMapping("/")
 public ModelAndView home(Model m) {
  User user = new User();
  m.addAttribute("user", user);
  ModelAndView modelAndView = new ModelAndView("register");  
  return modelAndView;  
 }
 @PostMapping("/register")
 public String register(@ModelAttribute ("user") User user, Model model) {
  service.registerUser(user);
  model.addAttribute("success","Registered Successfully");
  return "register";
 }
 @GetMapping("/login")
 public String loginDisplay(Model m,HttpSession session) {
  
  User user = new User();
  
  if (session.getAttribute("user") != null) {
   session.invalidate();
   System.out.println("here");
   m.addAttribute("success", "You have logout Successfully!!!");
  }
  m.addAttribute("user", user); 
  return "login";  
 }
 @PostMapping("/login")
 public String login(@ModelAttribute ("user") User user, Model model, HttpSession session) {
  User user2 = service.loginUser(user);
  System.out.println("user2"+user2);
  if(user2 != null) {
   System.out.println("hello");
   model.addAttribute("user",user2);
   session.setAttribute("user", user2);
   return "welcome";
  }
  if(user2 ==null) {
  System.out.println("on");
  model.addAttribute("error", "Invalid Credentials");}
  return "login";
  
 }
}