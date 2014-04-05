<%@page import="a.DatabaseClases.Director"%>
<%@page import="a.DatabaseClases.Movie"%>
<%@page import="a.DatabaseClases.User"%>
<%@page import="a.DatabaseClases.Type"%>
<%@page import="a.DatabaseServices.DatabaseCrudOperations"%><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

String rok=request.getParameter("year");
Director dir = new Director(request.getParameter("name"),request.getParameter("surname"));
DatabaseCrudOperations.saveToDatabase(dir);
Movie mov = new Movie(request.getParameter("title"),Integer.parseInt(rok) , dir);
DatabaseCrudOperations.saveToDatabase(mov);
out.println("Dodano :<table> </br><tr><td>"+mov.getName()+"</td><td>"+mov.getDirector().getName()+" "+mov.getDirector().getSurname()+"</td><td>"+mov.getYearOfProduction()+"</td></tr>");	

%>
</table>
<a href='index.jsp' >Wróć do Listy</a>


</body>
</html>