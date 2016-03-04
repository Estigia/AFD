/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

import java.util.ArrayList;

/**
 *
 * @author justo
 */
public class NodoAFN {
    private String Nombre;
    private ArrayList<Apuntador> apuntador = new ArrayList<Apuntador>();
    

    public NodoAFN(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Apuntador> getApuntador() {
        return apuntador;
    }

    public void setApuntador(ArrayList<Apuntador> apuntador) {
        this.apuntador = apuntador;
    }
    
    public void agregarElemento(NodoAFN nodo, String transicion)
    {
        Apuntador nuevoElemento = new Apuntador(transicion,nodo);
        apuntador.add(nuevoElemento);
    }
    
    
    
}
