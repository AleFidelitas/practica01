package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    //se define la firma del metodo para obtener los registros de arbol
    public List<Arbol> getArbol(boolean activo);
    
    
    
    //trae registro por id 
    public Arbol getArbol(Arbol arbol);
    
    //si id arbol tiene un valor, se modifica ese registro
    //si idarbol no tiene un valor se inserta un nuevo registro
    public void save(Arbol arbol);
    
    //se eimina el registro que tenga el valor del idarbol que trae
    public void delete (Arbol arbol);
    
    
}
