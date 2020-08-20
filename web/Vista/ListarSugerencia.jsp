<%-- 
    Document   : ListarSugerencia
    Created on : 19-ago-2020, 20:39:20
    Author     : Estrella
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Sugerencia"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.SugerenciaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                        <th class="text-center">Estado</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        SugerenciaDAO sugerenciaDAO = new SugerenciaDAO();
                        List<Sugerencia> sugerencias =  sugerenciaDAO.listarsugerencia();
                        Iterator<Sugerencia> iterator = sugerencias.iterator();
                        Sugerencia sugerencia = null;
                        while (iterator.hasNext()) {
                            sugerencia = iterator.next();


                    %>
                    <tr>
                        <td><% out.print(sugerencia.getIdsugerencia()); %></td>
                        <td><% out.print(sugerencia.getFecha()); %></td>
                        <td><% out.print(sugerencia.getDescripcion()); %></td>
                        <td><% out.print(sugerencia.getIdpersona()); %></td>
                        <td><% out.print(sugerencia.getIdrol()); %></td>
                        <td><% out.print(sugerencia.getIdarea()); %></td>
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