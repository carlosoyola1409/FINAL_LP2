package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDRol;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements CRUDRol{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Rol cu = new Rol();
    
    @Override
    public List listarrol() {
        ArrayList<Rol> roles = new ArrayList<>();
        String consulta = "SELECT * FROM `rol`";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
                rol.setEstado(rs.getString("estado"));
                roles.add(rol);
            }
        } catch (Exception cu) {
           
        }
        return roles;
    }

    @Override
    public Rol buscarrol(int idrol) {
        String consulta = " select *  "
                        + " from rol  "
                        + " where idrol = " + idrol + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cu.setIdrol(rs.getInt("idrol"));
                cu.setNombre(rs.getString("nombre"));
                cu.setEstado(rs.getString("estado"));
            }
        } catch (Exception cu) {
        }
        
        return cu;
    }

    @Override
    public boolean agregarrol(Rol rol) {
        String consulta = " insert into rol(nombre,  estado)  "
                        + " values( "
                        + "'"+ rol.getNombre() +"', "
                        + "'"+ rol.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false;
    }

    @Override
    public boolean editarrol(Rol rol) {
        String consulta = " update rol "
                        + " set "
                        + " nombre = '"+ rol.getNombre() +"', "
                        + " estado = '"+ rol.getEstado() +"' "
                        + " where "
                        + " idrol= " + rol.getIdrol() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false;
    }

    @Override
    public boolean eliminarrol(int idrol) {
        String consulta = " delete from rol "
                        + " where "
                        + " idrol = " + idrol + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false;
    }
    
    
}
