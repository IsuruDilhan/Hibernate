<%-- 
    Document   : TaskAdd
    Created on : Oct 12, 2017, 7:47:11 AM
    Author     : Sarathchandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
                if ($("#title").val().trim()= '')
                {
                    alert("Title name should be provided");
                    return false;
                }
                return true;
            }
        </script>
        <title>Task</title>
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
                    <h4> Add Task </h4>
                    <form action="TaskController" method="GET">
                        <table class="table">
                            <tr>
                                <td> Task Description</td>
                                <td><input type="text" name="description" id="description" class="form-control form-group"></td>
                            </tr>
                            <tr>
                                <td><input type="submit" name="addTask" value="Add" class="btn btn-primary" onsubmit="required()" ></td>
                                <td>
                                    <a class="btn btn-info" href="ShowAllTasks.jsp"> 
                                        Show All Tasks
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
