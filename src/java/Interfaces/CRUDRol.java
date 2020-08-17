package Interfaces;

import Modelo.Rol;
import java.util.List;

public interface CRUDRol {
    public List listarrol(); // listar
    public Rol buscarrol(int idrol); // buscar
    public boolean agregarrol(Rol rol); // agregar
    public boolean editarrol(Rol rol); // editar
    public boolean eliminarrol(int idrol); // eliminar
}
