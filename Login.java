package com.exam;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
        
   public void doPost(HttpServletRequest request, 
     HttpServletResponse response) 
       throws ServletException, IOException {
       response.setStatus(400);      
       response.setContentType("text/html");                      
       String name=request.getParameter("uname");      
       String passWord= request.getParameter("upass");
       PrintWriter out= response.getWriter();
       HashMap <String,String> map= User.users;
       System.out.println(map);
       request.getSession().setAttribute("name", name);

    if(map.containsKey(name)){
        System.out.println(map.get(name));

        if(map.get(name).equals(passWord))
      {
      
        List<String> list=User.userdata.get(name);    
    
            request.setAttribute("data", list);
            request.getRequestDispatcher("out.jsp").forward(request, response);
           
        }
        else{
            out.println("Password not found");
            request.getRequestDispatcher("index.jsp").include(request, response);
        }
    }
    else{
        out.println("Password and Name not found");
        request.getRequestDispatcher("index.jsp").include(request, response);
        }
       
  }

   public void doGet(HttpServletRequest request, 
   HttpServletResponse response) 
     throws ServletException, IOException{
       request.getRequestDispatcher("index.jsp").forward(request, response);

     }    
}
