<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html">
    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>

    <h:head>
        <title>HR APP</title>
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

            .panel:hover {
                box-shadow: 0px 0px 15px #000000;
                z-index: 2;
                -webkit-transition: all 200ms ease-in;
                -webkit-transform: scale(1.1);
                -ms-transition: all 200ms ease-in;
                -ms-transform: scale(1.1);   
                -moz-transition: all 200ms ease-in;
                -moz-transform: scale(1.1);
                transition: all 200ms ease-in;
                transform: scale(1.1);
            }
        </style>
    </h:head>
    <h:body>
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
            <div class="col-sm-2 ">

            </div>
            <div class="col-sm-8 text-left"> 
                <div class="row text-center h3">HR Mangement System</div><br><br><br>
                            <div class="row">
                                <a href="ShowAllEmployees.jsp">
                                    <div class="col-lg-4">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading text-center">Employees</div>
                                            <div class="panel-body">
                                                <img src="assets/img/team.png">

                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <a href="ShowAllTasks.jsp">
                                    <div class="col-lg-4">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading text-center">Tasks</div>
                                            <div class="panel-body">
                                                <img src="assets/img/tasks.png">

                                            </div>
                                        </div>
                                    </div>
                                </a>
                                <a href="ShowAllRoles.jsp">
                                    <div class="col-lg-4">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading text-center">Roles</div>
                                            <div class="panel-body">
                                                <img src="assets/img/roles.png">

                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            </div>
                            <div class="col-sm-2">

                            </div>
                            </div>
                            </h:body>
                            </html>

