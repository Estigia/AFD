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
    String [][] nuevoAutomata;
    NodoAFN [][] nAutomata;
    private int alto;
    private int ancho;

    public Estructura() {
        nAutomata = new NodoAFN[alto][1];
    }
    
    

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
    
    public void agregarMatriz(String nombre)
    {
        if (comprobarSiExiste(nombre) == false)
        {
            NodoAFN nuevaMatriz[][] = new NodoAFN[alto][ancho+1];
            ancho++;
            nuevaMatriz = rellenarNuevaMatriz(nuevaMatriz);
            nAutomata = nuevaMatriz;
            NodoAFN nuevoNodo = new NodoAFN(nombre);
            nodos.add(nuevoNodo);
            
        } 
        
    }
    
    public  NodoAFN[][] rellenarNuevaMatriz (NodoAFN [][] matriz)
    {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matriz[i][j] = nAutomata[i][j];
            }
        }
        return matriz;
    }
    
    

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    
    
    
    public void nada(){
        System.out.println("Nada, entrando");
    }
}
