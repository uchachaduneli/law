<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="${pageContext.request.contextPath}/"/>
    <title>LAW</title>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/font-awesome.css">
    <link rel="stylesheet" href="resources/css/AdminLTE.css">
    <link rel="stylesheet" href="resources/css/dataTables.bootstrap.css">
    <link rel="stylesheet" href="resources/css/skin-blue-light.css">
    <link rel="stylesheet" href="resources/css/global.css">
    <link rel="shortcut icon" type="image/png" href="resources/imgs/favicon.png"/>

    <script src="resources/js/jquery.js"></script>
    <script src="resources/js/jquery-ui.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/adminlte.js"></script>
    <script src="resources/js/angular.js"></script>
    <script src="resources/js/global_util.js"></script>
    <script>
        $(document).ready(function () {
            var url = window.location;
            $('.menuItem').filter(function () {
                return this.href.indexOf(url.pathname) > -1;
            }).addClass('active');
            if (url.pathname.indexOf("cases") > -1) {
                $('#selected_item').text("საქმე");
            } else if (url.pathname.indexOf("courts") > -1) {
                $('#selected_item').text("სასამართლოები");
            } else if (url.pathname.indexOf("instaces") > -1) {
                $('#selected_item').text("სასამართლო ინსტანციები");
            } else if (url.pathname.indexOf("caseresults") > -1) {
                $('#selected_item').text("საქმის დამთავრების შედეგები");
            } else if (url.pathname.indexOf("iligsubject") > -1) {
                $('#selected_item').text("დავის საგნები");
            } else if (url.pathname.indexOf("judges") > -1) {
                $('#selected_item').text("მოსამართლეები");
            } else if (url.pathname.indexOf("users") > -1) {
                $('#selected_item').text("მომხმარებლები");
            }
        });
        //        var myapp = angular.module('app', []);
    </script>
</head>
<body ng-app="app" class="hold-transition skin-blue-light sidebar-mini">
<div class="wrapper">
    <header class="main-header">
        <a href="#" class="logo">
            <span class="logo-lg"><b>LAW</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">მენიუს შეკეცვა</span>
            </a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-user"></i>
                            <span class="hidden-xs">User Desc</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="user-header">
                                <p>
                                    saxeli gvari
                                    <small>Member since Nov. 2012</small>
                                </p>
                            </li>
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">Profile</a>
                                </div>
                                <div class="pull-right">
                                    <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-sign-out"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="row" class="main-sidebar">
        <aside class="main-sidebar">
            <section class="sidebar">
                <ul class="sidebar-menu" data-widget="tree">
                    <li>
                        <a class="menuItem" href="cases">
                            <i class="fa fa-briefcase"></i>
                            <span>საქმე</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a class="menuItem" href="courts">
                            <i class="fa fa-bank"></i>
                            <span>სასამართლოები</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="instaces">
                            <i class="fa fa-sitemap"></i>
                            <span>სასამართლო ინსტანცია</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="caseresults">
                            <i class="fa fa-folder-open"></i>
                            <span>საქმის დამთ. შედეგები</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="iligsubject">
                            <i class="fa fa-balance-scale"></i>
                            <span>დავის საგანი</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="judges">
                            <i class="fa fa-graduation-cap"></i>
                            <span>მოსამართლეები</span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="users">
                            <i class="fa fa-users"></i>
                            <span>მომხმარებლები</span>
                            </span>
                        </a>
                    </li>
                </ul>
            </section>
        </aside>
    </div>

    <div class="content-wrapper" ng-controller="angController">
        <section class="content-header">
            <h4 id="selected_item"></h4>
        </section>
        <section class="content">


