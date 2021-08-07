<html>
  <%@ page import="java.util.ArrayList" %>
  <%@ page import="java.util.Arrays" %>

  <%@ page import="java.util.List" %>
<%  List<String> list= new ArrayList<String>(Arrays.asList(request.getAttribute("data").toString().split(",")));
   String dob=list.get(0).toString().replaceAll("[\\[\\](){}]","");
   String name=list.get(2).toString().replaceAll("[\\[\\](){}]","");
  %>
 <p style="text-align: center">Date of Birth : <%out.println(dob);
  request.setAttribute("dob",dob); %></p>
 <p style="text-align: center">Id : <%out.println(list.get(1));
  request.setAttribute("id",list.get(1));%></p>
  <p style="text-align: center">Name: <%out.println(name);
    request.setAttribute("name",name);%></p>
</form>

<% 
HttpSession session1 = request.getSession(false); 
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if(session1==null || session1.getAttribute("name")==null)
response.sendRedirect("index.jsp");
%>
<form action="logoutPage">
<h3 style="text-align: center"> <input type="submit" value="LogOut"/></h3> 
</form>
</html>
