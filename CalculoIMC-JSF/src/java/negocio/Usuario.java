/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author mayor
 */
public class Usuario {

    private double peso;
    private double altura;

    public Usuario() {

    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public String calculateIMCTradicional() {

        return "O seu IMC pela formula tradicional é: " + String.format("%.2f", this.getIMCTradicional())+ " e " + this.getAvaliação(this.getIMCTradicional());

    }

    public String calculateIMCOxford() {

        return "O seu IMC pela formula Oxford é: " + String.format("%.2f", this.getIMCOxford()) + " e " + this.getAvaliação(this.getIMCOxford());
    }

    public String calculateIMCHilderburg() {

        return "O seu IMC pela formula Hildenburg é: " + String.format("%.2f", this.getIMCHilderburg()) + " e " + this.getAvaliação(this.getIMCHilderburg());
    }

    public double getIMCTradicional() {
        return this.getPeso() / Math.pow(this.altura, 2);
    }

    public double getIMCOxford() {
        return this.getPeso() * 1.3 / Math.pow(this.getAltura(), 2.5);
    }

    public double getIMCHilderburg() {
        return (this.getPeso() * 1.72 / Math.pow(this.getAltura(), 3.06));

    }
    
    public String getAvaliação (double imc){
        if (imc<=25)
            return "seu peso está normal";
        else if (imc>=30)
            return "você está obeso";
        else 
            return "você está com sobrepeso";
    }

}
