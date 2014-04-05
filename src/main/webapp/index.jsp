<%@page import="a.DatabaseClases.Director"%>
<%@page import="a.DatabaseClases.Movie"%>
<%@page import="a.DatabaseClases.User"%>
<%@page import="a.DatabaseClases.Type"%>
<%@page import="java.util.List"%>
<%@page import="a.DatabaseServices.DatabaseCrudOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo application</title>
    </head>
    <body>
 
    
        <h7> <% 
        if(session.getAttribute("logedIn")==null){
        	if(request.getParameter("login")==null)
        	{
        		out.println("<form action=index.jsp> Login:<input type=text name=login /> Password :<input type=text  name=password/> <input type=submit value=Log In></form>");
				
        	}
        	else{
        		//logike logowania
        		session.setAttribute("logedIn", request.getParameter("login"));
        		out.print("Zalogowano jako "+session.getAttribute("logedIn"));
        	}
        }else{
        	out.print("Zalogowano jako "+session.getAttribute("logedIn"));
        	out.print("</br><a href='logout.jsp' >Wyloguj</a>");
        }
         %>
        
</h7>

<p>
<table border="1">
<tr><td>Film</td><td>Rezyser</td><td>Data Wydania</td></tr>
<%
List<Movie> movies = DatabaseCrudOperations.loadMoviesFromDatabase();


for(Movie mov : movies )
{
	
out.println("<tr><td>"+mov.getName()+"</td><td>"+mov.getDirector().getName()+" "+mov.getDirector().getSurname()+"</td><td>"+mov.getYearOfProduction()+"</td></tr>");	
} 
%> 
</table>
</p>
<%

String zalogowany = (String)session.getAttribute("logedIn");
if(zalogowany !=null)
{
	if(zalogowany.equals("Kuba"))
	{
	out.println("<a href='AddMovie.jsp' >Dodaj Film</a>");
	}
}

%>

       
    </body>
</html>
