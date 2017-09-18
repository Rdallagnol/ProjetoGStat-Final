<%-- 
    Document   : index
    Created on : 19/03/2016, 14:42:37
    Author     : Dallagnol
--%>

<%@page import="java.io.IOException"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta http-equiv="Content-Style-Type" content="text/css">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">    

        <title>SAG - Sistema de Análise Geoestatística</title>  

      
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet"/>
        <link href="${pageContext.request.contextPath}/css/loader.css" rel="stylesheet"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    </head>

    <body style="background-color: #fafafa;">

        <div id="container-fluid">
            <div class="row-fluid" >
                <div id="header">
                    <div class="navbar navbar-fixed-top">
                        <div class="navbar-inner row-fluid" >                                    
                            <ul class="nav" >
                                <li>
                                    <div style="padding: 4px;"> <img src="${pageContext.request.contextPath}/img/logoMenu.png">  </div> </li>
                                <li class="active">
                                    <a href="${linkTo[PrincipalController].index()}">Início</a>

                                </li>
                            </ul>

                        </div>
                    </div>
                    <br>
                </div>
            </div>      

            <div class="row-fluid" style="padding-top: 1.56%">
                <div class="nav ">
                    <div class="menu-fundo ">
                        <div id="menu"  class="span2">

                            <button type="button" class="btn btn-block" data-toggle="collapse" style="border: 1px solid silver" data-target="#menuG">
                                <li class="nav-header">Geoestatística / Krigagem Ordinária</li>
                            </button>
                            <div class="menu-fundo" style="padding-top: 15px;">

                                <ul class="nav nav-pills ">
                                    <div id="menuG"  class="collapse in ">                                       
                                        <li class="nav-header"  style="border-bottom: 1px solid silver; border-right: 1px solid silver">
                                            <a href="<c:url value="/funcaoGeo"/>">Gerar Análise Geoestatística</a>
                                        </li>
                                   
                                        <li class="nav-header"  style="border-bottom: 1px solid silver; border-right: 1px solid silver">
                                            <a href="<c:url value="/visualizaGeo"/>">Visualizar Análises Geoestatísticas </a>
                                        </li>
                                   
                                       
                                    </div>
                                </ul>
                            </div>   
                             <button type="button" class="btn btn-block" data-toggle="collapse" style="border: 1px solid silver" data-target="#menuIDW">
                                <li class="nav-header">Estatística / Inverso da distância</li>
                            </button>
                            <div class="menu-fundo" style="padding-top: 15px;">

                                <ul class="nav nav-pills ">
                                    <div id="menuIDW"  class="collapse in ">                                       
                                      
                                        <li class="nav-header"  style="border-bottom: 1px solid silver; border-right: 1px solid silver">
                                            <a href="<c:url value="/funcaoIdw"/>">Gerar Análises IDW</a>
                                        </li>                                        
                                        
                                        <li class="nav-header"  style="border-bottom: 1px solid silver; border-right: 1px solid silver">
                                            <a href="<c:url value="/visualizaIdw"/>">Visualizar Análises IDW </a>
                                        </li>
                                       
                                    </div>
                                </ul>
                            </div> 
                        </div>
                    </div>

                    <div id="content" class="span10 clearfix">



