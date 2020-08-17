<%-- 
    Document   : EditarArea
    Created on : 17/08/2020, 04:14:24 PM
    Author     : Usuario
--%>

<%@page import="Modelo.Area"%>
<%@page import="ModeloDAO.AreaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Area</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                AreaDAO areaDAO = new AreaDAO();
                int s_idarea = Integer.valueOf(request.getParameter("f_idarea"));
                Area area = (Area)areaDAO.buscararea(s_idarea);
            %>
            <form name="EditarAreaForm" action="ControladorArea" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar Area</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Nombre</td>
                            <td><input class="form-control" type="text" name="f_nombre" value="<% out.println(area.getNombre()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Estado</td>
                            <td><input class="form-control" type="text" name="f_estado" value="<% out.println(area.getEstado()); %>" maxlength="1" size="2" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-primary" type="submit" value="Editar Area" name="editar" />
                                <input type="hidden" value="editararea02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(area.getIdarea()); %>" name="f_idarea">

                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
