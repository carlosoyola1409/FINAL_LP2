
package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDArea;
import Modelo.Area;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AreaDAO implements CRUDArea {
ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Area cu = new Area();
    @Override
    public List listararea() {
       ArrayList<Area> areas = new ArrayList<>();
        String consulta = "SELECT * FROM `area`";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Area area = new Area();
                area.setIdarea(rs.getInt("idarea"));
                area.setNombre(rs.getString("nombre"));
                area.setEstado(rs.getString("estado"));
                areas.add(area);
            }
        } catch (Exception cu) {
           
        }
        return areas; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Area buscararea(int idarea) {
         String consulta = " select *  "
                        + " from area  "
                        + " where idarea = " + idarea + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                cu.setIdarea(rs.getInt("idarea"));
                cu.setNombre(rs.getString("nombre"));
                cu.setEstado(rs.getString("estado"));
            }
        } catch (Exception cu) {
        }
        
        return cu;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregararea(Area area) {
        String consulta = " insert into area(nombre,  estado)  "
                        + " values( "
                        + "'"+ area.getNombre() +"', "
                        + "'"+ area.getEstado() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editararea(Area area) {
     String consulta = " update area "
                        + " set "
                        + " nombre = '"+ area.getNombre() +"', "
                        + " estado = '"+ area.getEstado() +"' "
                        + " where "
                        + " idarea= " + area.getIdarea() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminararea(int idarea) {
         String consulta = " delete from area "
                        + " where "
                        + " idarea = " + idarea + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception cu) {
        }
        return false;//To change body of generated methods, choose Tools | Templates.
    }
    
}
