<%-- 
    Document   : EditarRol
    Created on : 17-ago-2020, 17:00:45
    Author     : Estrella
--%>

<%@page import="Modelo.Rol"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Rol</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                RolDAO rolDAO = new RolDAO();
                int s_idrol = Integer.valueOf(request.getParameter("f_idrol"));
                Rol rol = (Rol)rolDAO.buscarrol(s_idrol);
            %>
            <form name="EditarRolForm" action="ControladorRol" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar Rol</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombre</td>
                            <td><input class="form-control" type="text" name="f_nombre" value="<% out.println(rol.getNombre()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="<% out.println(rol.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-primary" type="submit" value="Editar Rol" name="editar" />
                                <input type="hidden" value="editarrol02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(rol.getIdrol()); %>" name="f_idrol">
                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
