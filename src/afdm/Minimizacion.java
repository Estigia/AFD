/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afdm;

import java.util.Arrays;

/**
 *
 * @author chofo2003
 */
public class Minimizacion {
    private int mat[][];
    private int matret[][];
    private int tamalf;
    String union="",pat="",aux="";

    public Minimizacion(int mat[][], int tamalf) {
        this.mat = mat;
        this.tamalf = tamalf;
        //matret = new int[mat.length][this.tamalf+1];        
    }
    
    public int[][] minimizar(){
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat.length;j++){
                for(int k=0;k<tamalf;k++){
                    if(recua(i,j,k,pat) == 0){
                        if(k==(tamalf-1)){
                            union = union + i +"," + j + " ";
                            System.out.println("hola");
                        }
                    }
                    else
                        k = tamalf;
                    
                }               
            }
        }
        return mod_mat();
        
        
        //return mat;
    }
    
    public int recua(int i, int j,int k, String pt){
        if(mat[i][tamalf] == mat[j][tamalf]){
            aux= i + "," + j + "-";
           
                aux = i + "," + j;
               if(pt.contains(aux))
                    return 0;        
                
                
            
            else{    
            //pt = pt + mat[i][tamalf] + "," +mat[j][tamalf] +" ";
            pt = pt + i + "," +j +"-" + mat[i][k] + "," + mat[j][k] + " ";
            return recua(mat[i][k],mat[j][k],k,pt);
            }
            
        }
        else
            return 1;
    }
    
    public int[][] mod_mat(){
        String auxi ="";
        String[] split1,split2;
        System.out.println(union);
        split1 = this.union.split(" ");
        for (String spl : split1) {
            split2 = spl.split(",");
            if (!auxi.contains(split2[1])) {
                auxi = auxi + split2[1] + " ";
                for (int i = 0; i < mat.length; i++) {
                    for (int j = 0; j < tamalf; j++) {
                        if (mat[i][j] == Integer.parseInt(split2[1])) {
                            mat[i][j] = Integer.parseInt(split2[0]);
                        }
                    }
                }
            }
        }
        for(int i=0; i<mat.length; i++){
                for(int j=0;j<=tamalf;j++){
                    System.out.print(mat[i][j] + "\t");
                }
                System.out.println();
            }
        
        String[] qwe = auxi.split(" ");
        int cont=0;
        System.out.println(Arrays.toString(qwe));
        System.out.println(Integer.parseInt(qwe[cont]));
        System.out.println(qwe.length);
        
        matret = new int[mat.length-qwe.length][tamalf+1];       
            for(int i=0;i<mat.length;i++){
                if(cont<qwe.length && Integer.parseInt(qwe[cont]) == i) {
                    
                        mat[i][0] = -1;
                        cont++;
                   
                }
              //  for(int j=0;j<=tamalf;j++){                   
                        //mat = removeRowFrom2dArray(mat, Integer.parseInt(qwe[cont]));
                        //cont++;
                        //for(int k=cont; k < qwe.length ; k++){
                         //   qwe[k] = Integer.toString(Integer.parseInt(qwe[k])-1);
                            
                        //}                            
                    //}                     
                //}
            }            
        
        for(int i=0; i<mat.length; i++){
                for(int j=0;j<=tamalf;j++){
                    System.out.print(mat[i][j] + "\t");
                }
                System.out.println();
            }
        return mat;
    }
    
    public int[][] removeRowFrom2dArray(int[][] array, int row) {
        int rows = array.length;
        int[][] arrayToReturn = new int[rows - 1][tamalf+1];
        
        for (int i = 0; i < row; i++) {            
                arrayToReturn[i] = array[i];                            
        }
        
        for (int i = row; i < arrayToReturn.length; i++) {            
                arrayToReturn[i++] = array[i];           
        }
        return arrayToReturn;
    }
    
    public void eliminarFila(int fila, int matriz[][])
    {
        int [][] matrizAux = new int[mat.length-1][tamalf +1];
        
        if (fila == 0)
        {
            for (int i = 1; i < mat.length -1; i++) {
                for (int j = 0; j < tamalf +1; j++) {
                    matrizAux[i-1][j] = matriz[i][j];
                }
            }
        } 
    }
}
