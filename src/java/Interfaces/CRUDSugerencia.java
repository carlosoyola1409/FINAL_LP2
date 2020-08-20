package Interfaces;

import Modelo.Sugerencia;
import java.util.List;

public interface CRUDSugerencia {
    public List listarsugerencia(); // listar
    public Sugerencia buscarsugerencia(int idsugerencia); // buscar
    public boolean agregarsugerencia(Sugerencia sugerencia); // agregar
    public boolean editarsugerencia(Sugerencia sugerencia); // editar
    public boolean eliminarsugerencia(int idsugerencia); // eliminar
}
