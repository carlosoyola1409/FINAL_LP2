<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Sugerencia</title>
        <link href="CSS/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form name="AgregarSugerenciaForm" action="ControladorSugerencia" method="get">
                <table  class="table">
                    <thead>
                        <tr>
                            <th class="text-center" colspan="2">Agregar Sugerencia</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <tbody>
                            <tr>
                            <td class="text-right">Idsugerencia</td>
                            <td><input class="form-control" type="text" name="f_idsugerencia" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Fecha</td>
                            <td><input class="form-control" type="text" name="f_fecha" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">descripcion</td>
                            <td><input class="form-control" type="text" name="f_descripcion" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Idpersona</td>
                            <td><input class="form-control" type="text" name="f_idpersona" value="" maxlength="30" size="20" /></td>
                        </tr>
                        
                         <tr>
                            <td class="text-right">Idrol</td>
                            <td><input class="form-control" type="text" name="f_idrol" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td class="text-right">Idarea</td>
                            <td><input class="form-control" type="text" name="f_idarea" value="" maxlength="30" size="20" /></td>
                        </tr>
                        <tr>
                            <td colspan="2" class="text-center">
                                <input class="btn btn-success" type="submit" value="Agregar Sugerencia" name="agregar" />
                                <input type="hidden" value="agregarsugerencia02" name="f_accion"/>
                                <a class="btn btn-success"href="index.html"><FONT COLOR="white">REGRESAR</a>
                                    
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
                
            </form>
        </div>
    </body>
</html>
