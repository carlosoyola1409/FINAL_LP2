<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Rol"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Rol</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Listado de Rol</h1>
            <a class="btn btn-success" href="ControladorRol?f_accion=agregarrol01">Agregar Nuevo Rol</a>
           
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
                        RolDAO rolDAO = new RolDAO();
                        List<Rol> roles = rolDAO.listarrol();
                        Iterator<Rol> iterator = roles.iterator();
                        Rol rol = null;
                        while (iterator.hasNext()) {
                            rol= iterator.next();


                    %>
                    <tr>
                        <td><% out.print(rol.getIdrol()); %></td>
                        <td><% out.print(rol.getNombre()); %></td>
                        <td><% out.print(rol.getEstado()); %></td>
                        <td>
                            <a class="btn btn-warning" href="ControladorRol?f_accion=editarrol01&f_idrol=<% out.print(rol.getIdrol()); %>">
                                Editar
                            </a>
                            <a class="btn btn-danger" href="ControladorRol?f_accion=eliminarrol&f_idrol=<% out.print(rol.getIdrol()); %>">
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
