<%-- 
    Document   : EmployeeAdd
    Created on : Oct 12, 2017, 7:47:11 AM
    Author     : VSARAIS
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entity.Role"%>
<%@page import="com.controller.RoleController"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            /* Set gray background color and 100% height */
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }
            .containers{
                height: 85vh;
            }

            .navbar{

            }
        </style>
        <script>
            function required()
            {
                alert('her')
                if ($("#title").val().trim() = '')
                {
                    alert("Title name should be provided");
                    return false;
                }
                return true;
            }
        </script>
        <title>Role</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="/WebApp">HR</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/WebApp">Home</a></li>
                        <li><a href="ShowAllEmployees.jsp">Employees</a></li>
                        <li><a href="ShowAllTasks.jsp">Tasks</a></li>
                        <li><a href="ShowAllRoles.jsp">Roles</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="containers">
            <div class="col-sm-2 sidenav">

            </div>
            <div class="col-sm-8 text-left">
                <div class="col-sm-2"></div>
                <div id="add" class="col-lg-6">
                    <h4> Add Employee </h4> <br>
                    <form action="EmployeeController" method="GET">
                        <table class="table">
                            <tr>
                                <td> Employee Name</td>
                                <td><input type="text" name="name" id="name" class="form-control form-group"></td>
                            </tr>
                            <tr>
                                <td> Employee Role</td>
                                <td>
                                    <select name="roleid" class="form-control form-group">
                                        <%
                                            List role = RoleController.showAllRoles();
                                            for (Iterator iter = role.iterator(); iter.hasNext();) {

                                                Role element = (Role) iter.next();
                                        %>

                                        <option value="<% out.println(element.getId()); %>"> <% out.println(element.getTitle()); %> </option>

                                        <% }%>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><input type="submit" name="addEmployee" value="Add" class="btn btn-primary" onsubmit="required()"></td>
                                <td>
                                    <a class="btn btn-info" href="ShowAllEmployees.jsp"> 
                                        Show All Employees
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>

            </div>
            <div class="col-sm-2">

            </div>
        </div>
    </body>
</html>
