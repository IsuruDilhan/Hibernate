<%-- 
    Document   : ShowAll
    Created on : Oct 12, 2017, 7:48:48 AM
    Author     : Sarathchandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.entity.Task"%>
<%@page import="com.entity.Employee"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.controller.TaskController"%>
<%@page import="com.controller.EmployeeController"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tasks</title>
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#updateDiv").hide();
            });

            function showDiv(id, description) {
                $("#updateDiv").hide();
                $("#updateDiv").fadeIn("slow", function () {
                });

                $("#id").val(id);
                $("#descriptionupdate").val(description);
            }

        </script>
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
                <div class="col-lg-1"></div>
                <div class="col-lg-10">
                    <h4>All Tasks</h4> <br> 
                    <a class="btn btn-sm btn-info" href="TaskAdd.jsp"> 
                        <i class="fa fa-plus" aria-hidden="true"> Add New Task</i>
                    </a><br><br>

                    <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Task Description</th>
                                <th class="text-center">Employee</th>
                                <th class="text-center">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List tasks = TaskController.showAllTasks();
                                for (Iterator iter = tasks.iterator(); iter.hasNext();) {

                                    Task element = (Task) iter.next();
                            %>

                            <tr>
                                <td>
                                    <% out.println(element.getTaskID()); %>
                                </td>
                                <td>
                                    <% out.println(element.getDescription()); %>
                                </td>
                                <td class="text-center">
                                    <% if (element.getEmployee() == null) { %> 
                                    - Task is Unassigned -

                                    <% } else { %>
                                    <% out.println(element.getEmployee().getName()); %>
                                    <% } %>
                                </td>
                                <td class="text-center">
                                    <button class="btn btn-sm btn-success" title="Edit" onclick="showDiv(<% out.println(element.getTaskID()); %>, '<% out.print(element.getDescription()); %>')">
                                        <i class="fa fa-pencil-square-o" aria-hidden="true"> Edit</i>
                                    </button>
                                </td>
                            </tr>

                            <% }%>

                        </tbody>
                    </table>

                    <div class="row col-lg-6" id="updateDiv">
                        <h4>Edit Details</h4>
                        <form action="TaskController" method="POST">

                            <table class="table col-lg-6">
                                <tbody>
                                    <tr>
                                        <td><label>ID</label></td>
                                        <td><input name="id" id="id" type="text" readonly="" class="form-control form-group"></td>
                                    </tr>

                                    <tr>
                                        <td><label>Update Description</label></td>
                                        <td><input id="descriptionupdate" type="text" name="descriptionupdate" 
                                                   class="form-control form-group"></td>
                                    </tr>

                                    <tr>
                                        <td><label>Assign Employee</label></td>
                                        <td>
                                            <select name="empid" class="form-control form-group">
                                                <%
                                                    List emp = EmployeeController.showAllEmployees();
                                                    for (Iterator iter = emp.iterator(); iter.hasNext();) {

                                                        Employee element = (Employee) iter.next();
                                                %>

                                                <option value="<% out.println(element.getEmployeeID()); %>"><% out.println(element.getName()); %></option>

                                                <% }%>
                                            </select>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>

                            <button type="submit" id="updateTask" name="updateTask" class="btn btn-sm btn-warning"> Update</button> <br> <br>

                        </form>
                    </div>
                    <div class="col-lg-1"></div>

                </div>
            </div>
            <div class="col-sm-2">

            </div>
        </div>
    </body>
</html>