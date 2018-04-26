/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadifffolders;

import excepciones.CarpetaNoExiste;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author mati
 */
public class DiffFolder {

    private File folder1;
    private File folder2;

    DiffFolder() {
    }

    public void setFolders(File folder1, File folder2) throws CarpetaNoExiste, GestioFitxersException {
        if (folder1.exists() && folder2.exists()) {
            if (folder1.isDirectory() && folder2.isDirectory()) {
                this.folder1 = folder1;
                this.folder2 = folder2;
            } else {
                throw new GestioFitxersException(folder1, folder2);
            }
        } else {
            throw new CarpetaNoExiste(folder1, folder2);
        }
    }

    public File getFolder1() {
        return folder1;
    }

    public void setFolder1(File folder1) {
        this.folder1 = folder1;
    }

    public File getFolder2() {
        return folder2;
    }

    public void setFolder2(File folder2) {
        this.folder2 = folder2;
    }

    public Iterator<ResultatComparacio> compare() {
        //ResultatComparacio result=new ResultatComparacio("pepe.txt",ValorComparacio.FALTA_EN_1);
        ResultatComparacio result;
        ArrayList<ResultatComparacio> llista = new ArrayList<>();
        //Cogemos los ficheros de las carpetas y nos disponemos a compararlos
        File[] listaFold1 = folder1.listFiles();
        File[] listaFold2 = folder2.listFiles();
        boolean encontrado=false;
        for (int i = 0; i < listaFold1.length; i++) {
            encontrado=false;
            for (int j = 0; j < listaFold2.length && encontrado==false; j++) {  
                if (listaFold1[i].getName().equalsIgnoreCase(listaFold2[j].getName())) {
                    if (listaFold1[i].lastModified() == listaFold2[j].lastModified()) {
                        result = new ResultatComparacio(listaFold1[i].getName(), ValorComparacio.IGUALS);
                        llista.add(result);
                        encontrado=true;         
                    }else if(listaFold1[i].lastModified()>listaFold2[j].lastModified()){
                        result=new ResultatComparacio(listaFold1[i].getName(),ValorComparacio.MES_NOU_EN_1);
                        llista.add(result);
                    }else{
                        result=new ResultatComparacio(listaFold1[i].getName(),ValorComparacio.MES_NOU_EN_2);
                        llista.add(result);
                    }
                }
            }
            if(encontrado==false){
                result=new ResultatComparacio(listaFold1[i].getName(),ValorComparacio.FALTA_EN_2);
                llista.add(result);
            }
        }
        boolean encontrado2=false;
        for (int i = 0; i < listaFold2.length; i++) {
            encontrado2=false;
            for (int j = 0; j < listaFold1.length; j++) {
                if(listaFold2[i].getName().equalsIgnoreCase(listaFold1[j].getName())){
                    encontrado2=true; 
                }
                
                
            }
            if(encontrado2==false){
                result=new ResultatComparacio(listaFold2[i].getName(),ValorComparacio.FALTA_EN_1);
                llista.add(result);
            }
        }

        return llista.iterator();
    }

    public boolean contieneEn2(File file1, File[] listaFold2) { //comparo si un fichero de la carpeta 1 esta en la carpeta 2, recorriendo esta...

        for (int i = 0; i < listaFold2.length; i++) {
            if (listaFold2[i].getName().compareTo(file1.getName()) == 0) {
                return true;

            }
        }
        return false;

    }

    public boolean contieneEn1(File file2, File[] listaFold1) { //comparo si un fichero de la carpeta 2 esta en la carpeta 1, recorriendo esta...

        for (int i = 0; i < listaFold1.length; i++) {
            if (listaFold1[i].getName().compareTo(file2.getName()) == 0) {
                return true;

            }
        }
        return false;

    }

}
