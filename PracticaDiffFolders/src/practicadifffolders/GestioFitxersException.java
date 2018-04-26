/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadifffolders;

import java.io.File;

/**
 *
 * @author mati
 */
class GestioFitxersException extends Exception {
    File folder1;
    File folder2;

    public GestioFitxersException(File folder1, File folder2) {
        this.folder1 = folder1;
        this.folder2 = folder2;
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

    @Override
    public String toString() {
        return "La carpeta"+folder1.getAbsolutePath()+folder2.getAbsolutePath()+"no existen o no son carpetas";
    }
    
    
}
