<%@page import="Modelo.Sugerencia"%>
<%@page import="ModeloDAO.SugerenciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Matricula</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%
                SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
                int s_idsugerencia = Integer.valueOf(request.getParameter("f_idsugerencia"));
                Sugerencia sugerencia = (Sugerencia)sugerenciaDAO.buscarsugerencia(s_idsugerencia);
            %>
            <form name="EditarSugerenciaForm" action="ControladorSugerencia" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Editar Sugerencia</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-right">Idsugerencia</td>
                            <td><input class="form-control" type="text" name="f_idsugerencia" value="<% out.println(sugerencia.getIdsugerencia()); %>" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Fecha</td>
                            <td><input class="form-control" type="text" name="f_fecha" value="<% out.println(sugerencia.getFecha()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Descripcion</td>
                            <td><input class="form-control" type="text" name="f_descripcion" value="<% out.println(sugerencia.getDescripcion()); %>" maxlength="40" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Idpersona</td>
                            <td><input class="form-control" type="text" name="f_idpersona" value="<% out.println(sugerencia.getIdpersona()); %>" maxlength="8" size="8" /></td>
                        </tr>
                         <tr>
                            <td class="text-right">Idrol</td>
                            <td><input class="form-control" type="text" name="f_idrol" value="<% out.println(sugerencia.getIdrol()); %>" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Idarea</td>
                            <td><input class="form-control" type="text" name="f_idarea" value="<% out.println(sugerencia.getIdarea()); %>" maxlength="12" size="12" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-success" type="submit" value="Editar Sugerencia" name="editar" />
                                <input type="hidden" value="editarsugerencia02" name="f_accion"/>
                                <input type="hidden" value="<% out.print(sugerencia.getIdsugerencia()); %>" name="f_idsugerencia">
                                <a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a>
                            </td>
                        </tr>

                    </tbody>
                </table>


            </form>
        </div>
    </body>
</html>
