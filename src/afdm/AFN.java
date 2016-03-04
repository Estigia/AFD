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
public class AFN {
    Estructura estructura = new Estructura();

    public AFN(String[][] datos, int alto, int ancho) {
        String[][] matrizAFN = new String[alto][ancho];
        NodoAFN[][] matrizAFD = new NodoAFN[alto][1];
       
        
      
    }
    
    
    
    
    
    
    
    
    
    
    public void crearEstadoInicial(String[][] AFN, NodoAFN[][] AFDM, int ancho, char[] alfabeto)
    {
        AFDM[0][0].setNombre(AFN[0][0]+","+AFN[0][AFN.length-2]);
        if((AFN[0][AFN.length-1]=="si")|| (AFN[0][AFN.length-1]=="si"))
        {
            AFDM[0][AFN.length-1].setNombre("si");
        }
        else
            AFDM[0][AFN.length-1].setNombre("no");
        
        int[] estados = obtenerEstadosInicial(AFDM,ancho,AFN);
        obtenerEstadosDeTransicion(AFN,estados,alfabeto);
    }
    
    public int[] obtenerEstadosInicial(NodoAFN[][] AFN,int ancho,String[][] AFDM)
    {
        String[] estados = AFN[0][0].getNombre().split(",");
        int[] estadosInt = new int[estados.length];
        for(int x=0;x<estados.length;x++)
        {
            estadosInt[x]= Integer.parseInt(estados[x]);
        }
        return estadosInt;
    }
    
    public void obtenerEstadosDeTransicion(String[][] AFN,int[] estados,char[] alfabeto)
    {
        String cadena;
        int[][] matrizTransiciones = new int[alfabeto.length-2][estados.length];
        for(int x=0;x<estados.length;x++)
        {
            asignacion(AFN,estados[x],alfabeto,matrizTransiciones);
        }
        
        for(int x=0;x<estados.length;x++)
        {
            for(int y=0;y<matrizTransiciones.length-1;y++)
            {
                cadena = Integer.toString(matrizTransiciones[x][y]);
                if(estructura.comprobarSiExiste(cadena)==true)
                {
                    //llamar a funcion para saber donde insertar
                }
                
                else 
                {
                    
                }
                        
            }
        }
        
        
        
        
        
    }
    
    public void asignacion(String[][] AFN,int columna,char[] alfabeto,int[][] matrizTransiciones)
    {
        for(int x=0;x<alfabeto.length-1;x++)
        {
            matrizTransiciones[x][columna]=Integer.parseInt(AFN[x][columna]);
        }
    }
   
    }
    

