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

    public AFN(String[][] datos, int alto, int ancho,int tam_alfabeto) {
        String[][] matrizAFN = new String[alto][ancho];
        String[][] matrizAFD = new String[alto-1][1];
       matrizAFD = crearInicial(matrizAFN,ancho,tam_alfabeto,matrizAFD);
        
      
    }
    
    
    public String[][] crearInicial(String[][] AFN,int ancho,int tam_alfabeto, String[][] AFD)
    {   if(AFN[0][AFN.length-2].compareTo("/")==0)
        {
            String nombre=AFN[0][0];
            if(AFN[AFN.length-1][0].compareTo("si")==0)
            {
                AFD[0][AFD.length-1]="si";
                
            }
            for(int i=0;i<AFD.length-2;i++)
                {
                    AFD[i][0]= AFN[i][0];
                }
        }
        else
         {
            
            String nombre = AFN[0][0]+","+AFN[AFN.length-2][0];
            String[] vecNombre = nombre.split(",");
            String[][] matriz_temporal= new String[tam_alfabeto+1][vecNombre.length];
            for(int x=0;x<vecNombre.length;x++)
            {
                matriz_temporal = encontrar_Transiciones(Integer.parseInt(vecNombre[x]), tam_alfabeto,matriz_temporal,x,AFN); 
                
            }
            return unirTransiciones(matriz_temporal,ancho,AFD);
        }
        return null;
    }
        
    
    
    public String[][] encontrar_Transiciones(int columna,int tam_alfabeto,String[][] matriz_temporal,int x,String[][] AFN)
    {
        for(int y=0;y<tam_alfabeto;y++)
        {
            matriz_temporal[y][x]=(AFN[y][columna]);
               if(AFN[AFN.length-1][x].compareTo("si")==0)
            {
                matriz_temporal[matriz_temporal.length-1][x]="si";
            }
        }
        return matriz_temporal;
    }
    
    public String[][] unirTransiciones(String[][] matriz_temporal,int ancho,String[][] AFD)
    {
        String fila="";
        for(int i=0;i<matriz_temporal.length;i++)
        {
            for(int j=0;j<ancho;j++)
            {
                 fila = matriz_temporal[i][j];
            }
            AFD[i][0]=fila;
        }
        return AFD;
    }
    
    public String[][] recorrerAFD(String[][] AFD,int ancho,int tam_alfabeto,int columna)
    {
        for(int x=0;x<tam_alfabeto;x++)
        {
            String transicion = AFD[x][columna];
            transicion = separarTransiciones(transicion);
            if(estructura.comprobarSiExiste(transicion)==true)
            {
                AFD[x][columna]=transicion;
            }
            else
            {
                //estructura.
               // AFD[x][columna]= transicion;
                
                
            }
        }
        return AFD;
    }
    
    public String separarTransiciones(String cadena)
    {
        String transiciones="";
        int cont=0;
        String[] separador = cadena.split(",");
        for(int i=0;i<separador.length;i++)
        {
            if(separador[i].compareTo("/")==0)
            {
                cont++;
            }
            else
            {
                transiciones=transiciones+separador[i]+",";
            }
        }
        if(cont==separador.length)
            return "/";
        else
        return transiciones;
    }
    
    
    
    
    
    
    
   
    
    
    

   
    }
    

