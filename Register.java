package com.exam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;      
public class Register extends HttpServlet 

{public void doGet(HttpServletRequest request, 
  HttpServletResponse response) 
    throws ServletException, IOException{

      request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }     
   public void doPost(HttpServletRequest request, 
     HttpServletResponse response) 
       throws ServletException, IOException 
   {    
       response.setContentType("text/html");                      
       String name=request.getParameter("name");      
       String passWord= request.getParameter("pass");  
      String dob= request.getParameter("dob");
      String id=request.getParameter("id");
            List<String> lis= new ArrayList<String>();
      lis.add(dob);
      lis.add(id);
      lis.add(name);  
      User.users.put(name, passWord);
      User.userdata.put(name,lis);
      System.out.println(name+" "+passWord);
       HashMap<String, String> map= User.users;
       System.out.println(map);
       User.userdata.get(name);

       //request.setAttribute("data", list);
       request.getRequestDispatcher("index.jsp").forward(request, response);
   }    
}
