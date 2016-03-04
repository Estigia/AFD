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
        crearEstadoInicial(matrizAFN,matrizAFD,ancho);
        
      
    }
    
    public void crearEstadoInicial(String[][] AFN, NodoAFN[][] AFDM, int ancho)
    {
        AFDM[0][0].setNombre(AFN[0][0]+","+AFN[0][AFN.length-2]);
        if((AFN[0][AFN.length-1]=="si")|| (AFN[0][AFN.length-1]=="si"))
        {
            AFDM[0][AFN.length-1].setNombre("si");
        }
        else
            AFDM[0][AFN.length-1].setNombre("no");
    }
    
    public void llenarMatriz(NodoAFN[][] AFDM,int ancho)
    {
        for(int i=0;i<AFDM.length-2;i++)
        {
            
        }
    }
   
    }
    

