<%-- 
    Document   : ListarArea
    Created on : 17/08/2020, 04:14:34 PM
    Author     : Usuario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Area"%>
<%@page import="ModeloDAO.AreaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Area</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Areas</h1>
            <a class="btn btn-success" href="ControladorArea?f_accion=agregararea01">Agregar Nuevo Area</a>
           
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Estado</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        AreaDAO areaDAO = new AreaDAO();
                        List<Area> areas = areaDAO.listararea();
                        Iterator<Area> iterator = areas.iterator();
                        Area area = null;
                        while (iterator.hasNext()) {
                            area= iterator.next();


                    %>
                    <tr>
                        <td><% out.print(area.getIdarea()); %></td>
                        <td><% out.print(area.getNombre()); %></td>
                        <td><% out.print(area.getEstado()); %></td>
                        <td>
                            <a class="btn btn-warning" href="ControladorArea?f_accion=editararea01&f_idarea=<% out.print(area.getIdarea()); %>">
                                Editar
                            </a>
                            <a class="btn btn-danger" href="ControladorArea?f_accion=eliminararea&f_idarea=<% out.print(area.getIdarea()); %>">
                                Eliminar
                            </a>
                        </td>
                    </tr>
                    <%    }
                    %>                    
                </tbody>
                    
            </table>
            </table>
            <tr>
                        <td> </td>
                        <td colspan="2"><a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a></td>
                    </tr>
        </div>
    </body>
</html>