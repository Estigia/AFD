/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author carlosgarciar
 */
public class DevMatriz {
    private int ancho = 0;
    private int alto;
    private String [][] automata;
    ArrayList<String> estados = new ArrayList<String>();

    public DevMatriz() {
    }

    /*
    Esta función es el constructor. Lo único que se le tiene que mandar como parámetro
    es la cantidad de filas. Crea por defecto el ancho como 1, ya que es el ancho inicial
    para el estado Q0, y en las funciones siguientes aumenta su tamaño cada que no encuentra
    un estado coincidente.    
    */
    public DevMatriz(int alto) {
        this.alto = alto;
        this.ancho = 1;
        automata = new String[this.alto][1];
    }
    
    
    /*
    Esta función es la encargada de agregar un estado en la Clase padre, ya que se manda 
    el nombre del estado a agregar y devuelve la matriz del autómata. Si existe el estado 
    envíado como parámetro, devolverá el autómata ya conocido. Y si no existe el estado,
    devolverá una matriz con una columna más.
    */
    public String [][] agregarEstado (String nombreEstado)
    {
        
        if (comprobarSiExiste(nombreEstado) == true)
        {
            return automata;
        }
        else
        {
            String [][] nuevaMatriz = new String [alto][ancho+1];
            nuevaMatriz = copiar(nuevaMatriz);
            actualizarAutomataAncho(nuevaMatriz, ancho);
            agregarADiccionario(nombreEstado);
            return nuevaMatriz;
        }
    }
    
    /*
    Función que comprueba si el estado envíado existe.
    */
    public boolean comprobarSiExiste(String nombreEstado){
        boolean bandera = false;
        nombreEstado = ordenarNombre(nombreEstado);
        for (int i = 0; i < estados.size(); i++) {
            if (estados.get(i).equals(nombreEstado))
            {
                bandera = true;
            }
        }
        return bandera;
    }
    
    /*
    Función que mantiene un diccionario de estados agregados al autómata.
    */
    public void agregarADiccionario(String nombreEstado)
    {
        nombreEstado = ordenarNombre(nombreEstado);
        estados.add(nombreEstado);
    }
    
    /*
    Función que ordena el nombre del estado para que se mantenga la equivalencia.
    Por ejemplo 3,2,1 = 1,2,3.
    */
    public String ordenarNombre(String nombreDes)
    {
        String [] nodos = nombreDes.split("-");
        Vector<String> est = new Vector<>();
        for (int i = 0; i < nodos.length; i++) {
            if (comprobarNodoAgregado(nodos[i], est) == false)
            {
                est.add(nodos[i]);
            }           
        }
        Collections.sort(est);
        String nombreEstado = "";
        for (int i = 0; i < est.size(); i++) {
            nombreEstado = nombreEstado + est.get(i);
        }
        return nombreEstado;
    }
    
    /*
    Función encargada de trasladar la información de una matriz a la matriz
    creada con una columna más.
    */
    public String [][] copiar(String [][] matrizALlenar)
    {
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                matrizALlenar[i][j] = automata[i][j];
            }
        }
        return matrizALlenar;
    }
    
    
    /*
    Actualiza el autómata y el ancho, y los iguala al autómata mismo con una columa de más
    que sirve para el nuevo estado.
    */
    public void actualizarAutomataAncho(String [][] nuevaMatriz, int ancho)
    {
        automata = nuevaMatriz;
        this.ancho = ancho +1;
    }

    /*
    Comprueba si el nodo 1 ya se ha agregado en la concatenacion de un conjunto
    para la creacion de un Nodo n. 
    */
    public boolean comprobarNodoAgregado (String nombreNodo, Vector <String> nodosAgregados)
    {
        boolean bandera = false;
        for (int i = 0; i < nodosAgregados.size(); i++) {
            if (nodosAgregados.get(i).equals(nombreNodo))
            {
                bandera = true;
            }
        }
        return bandera;
    }
    
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    
    
    
}
