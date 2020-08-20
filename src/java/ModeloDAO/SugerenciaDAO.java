package ModeloDAO;

import Config.bd.ConectaBd;
import Interfaces.CRUDSugerencia;
import Modelo.Area;
import Modelo.Persona;
import Modelo.Rol;
import Modelo.Sugerencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SugerenciaDAO implements CRUDSugerencia{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Sugerencia m = new Sugerencia();
    RolDAO rolDAO = new RolDAO();
    List<Rol> roles = rolDAO.listarrol();
    AreaDAO areaDAO = new AreaDAO();
    List<Area> areas = areaDAO.listararea();
    PersonaDAO personaDAO = new PersonaDAO();
    List<Persona> personas = personaDAO.listapersona();

    @Override
    public List listarsugerencia() {
        ArrayList<Sugerencia> sugerencias = new ArrayList<>();
        String consulta = "SELECT * FROM `sugerencia`";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Sugerencia sugerencia = new Sugerencia();
                sugerencia.setIdsugerencia(rs.getInt("idsugerencia")); 
                sugerencia.setFecha(rs.getString("fecha"));
                sugerencia.setDescripcion(rs.getString("descripcion")); 
                sugerencia.setIdpersona(rs.getInt("idpersona"));
                sugerencia.setIdrol(rs.getInt("idrol"));
                sugerencia.setIdarea(rs.getInt("idarea"));
                sugerencias.add(sugerencia);
            }
        } catch (Exception m) {
            
        }
        return sugerencias;
    }

    @Override
    public Sugerencia buscarsugerencia(int idsugerencia) {
        String consulta = " select *  "
                        + " from sugerencia  "
                        + " where idsugerencia= " + idsugerencia + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
               m.setIdsugerencia(rs.getInt("idsugerencia"));
                m.setFecha(rs.getString("fecha"));
                m.setDescripcion(rs.getString("descripcion"));
                
            }
        } catch (Exception m) {
        }
        
        return m;
    }

    @Override
    public boolean agregarsugerencia(Sugerencia sugerencia) {
        String consulta = " insert into sugerencia(fecha,descripcion)  "
                        + " values( "
                        + "'"+ sugerencia.getFecha() +"', "
                        + "'"+ sugerencia.getDescripcion() +"') ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception m) {
        }
        return false;
    }

    @Override
    public boolean editarsugerencia(Sugerencia sugerencia) {
        String consulta = " update sugerencia"
                        + " set "
                        + " fecha = '"+ sugerencia.getFecha() +"', "
                        + " descripcion= '"+ sugerencia.getDescripcion() +"', "
                        + " idpersona= '"+ sugerencia.getIdpersona() +"', "
                        + " idrol= '"+ sugerencia.getIdrol() +"', "
                        + " idarea = '"+ sugerencia.getIdarea() +"' "
                        + " where "
                        + " idsugerencia = " + sugerencia.getIdsugerencia() + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception m) {
        }
        return false;
    }

    @Override
    public boolean eliminarsugerencia(int idsugerencia) {
        String consulta = " delete from sugerencia"
                        + " where "
                        + " idsugerencia = " + idsugerencia + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception m) {
        }
        return false;
    }
    @Override
    public String getnombrepersona(int idpersona) {
        String nombre=null;
        for (Persona persona : personas) {
            if (persona.getIdpersona()==idpersona) {
                nombre = persona.getNombre();
            }    
        }
        return nombre;            
     }

    @Override
    public String getnombrerol(int idrol) {
        String nombre=null;
        for (Rol rol : roles) {
            if (rol.getIdrol()==idrol) {
                nombre = rol.getNombre();
            }    
        }
        return nombre;            
     }
      
    @Override
    public String getnombrearea(int idarea) {
    String nombre=null;
        for (Area area : areas) {
            if (area.getIdarea()==idarea) {
                nombre = area.getNombre();
            }    
        }
        return nombre;            
           
    }
}
