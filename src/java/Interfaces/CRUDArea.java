
package Interfaces;

import Modelo.Area;
import java.util.List;


public interface CRUDArea {
     public List listararea(); // listar
    public Area buscararea(int idarea); // buscar
    public boolean agregararea(Area area); // agregar
    public boolean editararea(Area area); // editar
    public boolean eliminararea(int idarea); // eliminar
    
}
