/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicadifffolders;

/**
 *
 * @author mati
 */
public class ResultatComparacio {
    private String nom;
    private ValorComparacio valor;

    public ResultatComparacio(String nom, ValorComparacio valor) {
        this.nom = nom;
        this.valor = valor;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ValorComparacio getValor() {
        return valor;
    }

    public void setValor(ValorComparacio valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "El nombre es "+nom+" y el valor es "+valor;
    }

    
    
    
}
