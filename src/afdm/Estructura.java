/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

import java.util.ArrayList;

/**
 *
 * @author carlosgarciar
 */
public class Estructura {
    ArrayList <NodoAFN> nodos = new ArrayList<>();

    public boolean comprobarSiExiste(String nombreNodo){
        boolean bandera = false;
        for (int i = 0; i < nodos.size(); i++) {
            if (nodos.get(i).getNombre().equals(nombreNodo)){
                bandera = true;
            }
        }
        return bandera;
    }
    
    
    public void agregarNodo(NodoAFN nodo)
    {
        nodos.add(nodo);
    }
    
    
}
