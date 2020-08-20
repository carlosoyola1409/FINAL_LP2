<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page import="Modelo.Area"%>
<%@page import="Modelo.Rol"%>
<%@page import="ModeloDAO.AreaDAO"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.RolDAO"%>
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
                RolDAO rolDAO = new RolDAO();
                List<Rol> roles = rolDAO.listarrol();
                AreaDAO areaDAO = new AreaDAO();
                List<Area> areas = areaDAO.listararea();
                PersonaDAO personaDAO = new PersonaDAO();
                List<Persona> personas = personaDAO.listapersona();
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
                            <td class="text-right">Fecha</td>
                            <td><input class="form-control" type="text" name="f_fecha" value="<% out.println(sugerencia.getFecha()); %>" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Descripcion</td>
                            <td><input class="form-control" type="text" name="f_descripcion" value="<% out.println(sugerencia.getDescripcion()); %>" maxlength="40" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Persona</td>
                            <td><select name="f_idpersona">                                
                                               <% 
                             for (Persona persona : personas) {
                                    %>
                                    <option><% persona.getNombre(); %></option>
                                               <%
                                  }
                             %>         
                             
                             </select></td>
                        </tr>
                         <tr>
                            <td class="text-right">Rol</td>
                            <td><select name="f_idrol">                                
                                               <% 
                             for (Rol rol : roles) {
                                    %>
                                    <option><% rol.getNombre(); %></option>
                                               <%
                                  }
                             %>
                        </select></td>
                        </tr>
                        <tr>
                            <td class="text-right">Idarea</td>
                            <td><select name="f_idarea">                                
                                               <% 
                             for (Area area : areas) {
                                    %>
                                    <option><% area.getNombre(); %></option>
                                               <%
                                  }
                             %>
                        </select></td>
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
