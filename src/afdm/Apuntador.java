/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

/**
 *
 * @author justo
 */
public class Apuntador {
    
    private String transicion;
    private NodoAFN apuntador;

    public Apuntador(String transicion, NodoAFN apuntador) {
        this.transicion = transicion;
        this.apuntador = apuntador;
        
    }

    

    public String getTransicion() {
        return transicion;
    }

    public void setTransicion(String transicion) {
        this.transicion = transicion;
    }

    public NodoAFN getApuntador() {
        return apuntador;
    }

    public void setApuntador(NodoAFN apuntador) {
        this.apuntador = apuntador;
    }
    
    
    
}
