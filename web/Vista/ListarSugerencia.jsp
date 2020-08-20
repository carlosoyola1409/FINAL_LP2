<%-- 
    Document   : ListarSugerencia
    Created on : 19-ago-2020, 20:39:20
    Author     : Estrella
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="Modelo.Area"%>
<%@page import="ModeloDAO.AreaDAO"%>
<%@page import="Modelo.Rol"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Sugerencia"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.SugerenciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%!
         String ide;
         String consulta;
         PreparedStatement pst;
         ResultSet rs;
         Connection cn;
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Sugerencia</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Sugerencias</h1>
            <a class="btn btn-success" href="ControladorSugerencia?f_accion=agregarsugerencia01">Agregar Nueva Sugerencia</a>
              
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Fecha</th> 
                        <th class="text-center">Descripcion</th>
                        <th class="text-center">Idpersona</th>
                        <th class="text-center">Idrol</th>
                        <th class="text-center">Idarea</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
                        List<Sugerencia> sugerencias =  sugerenciaDAO.listarsugerencia();
                        Iterator<Sugerencia> iterator = sugerencias.iterator();
                        RolDAO rolDAO = new RolDAO();
                        List<Rol> roles = rolDAO.listarrol();
                        
                        AreaDAO areaDAO = new AreaDAO();
                        List<Area> areas = areaDAO.listararea();
                                               
                        
                        PersonaDAO personaDAO = new PersonaDAO();
                        List<Persona> personas = personaDAO.listapersona();
                        Sugerencia sugerencia = null;
                        int num=1;
                        while (iterator.hasNext()) {
                            sugerencia = iterator.next();
                

                    %>
                    <tr>
                        <td><% out.print(sugerencia.getIdsugerencia()); %></td>
                        <td><% out.print(sugerencia.getFecha()); %></td>
                        <td><% out.print(sugerencia.getDescripcion()); %></td>
                        <%
                        for (Persona x : personas) {
                               if (x.getIdpersona()==(sugerencia.getIdpersona())) {
                                   %>
                                   <td><% out.print(x.getNombre()); %></td>
                                    <%
                                   }
                             }
                        for (Rol x : roles) {
                               if (x.getIdrol()==(sugerencia.getIdrol())) {
                                   %>
                                   <td><% out.print(x.getNombre()); %></td>
                                    <%
                                   }
                             }   
                         for (Area x : areas) {
                               if (x.getIdarea()==(sugerencia.getIdarea())) {
                                   %>
                                   <td><% out.print(x.getNombre()); %></td>
                                    <%
                                   }
                             }
                        
                         %>                         
                        
                       
                        <%


                        %>
                        <td>
                            <a class="btn btn-warning" href="ControladorSugerencia?f_accion=editarsugerencia01&f_idsugerencia=<% out.print(sugerencia.getIdsugerencia()); %>">
                                Editar 
                            </a>
                            <a class="btn btn-danger" href="ControladorSugerencia?f_accion=eliminarsugerencia&f_idsugerencia=<% out.print(sugerencia.getIdsugerencia()); %>">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                    <%    }
                    %>                    
                </tbody>
            </table>
                <table border="0" cellspacing="0" cellpagging="0" align="center">

                
                    <tr>
                        <td> </td>
                        <td colspan="2"><a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a></td>
                    </tr>
                    
            </table>
        </div>
    </body>
</html>