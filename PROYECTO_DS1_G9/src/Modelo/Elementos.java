package Modelo;

public class Elementos {
    
    private String codTab;
    private String codElemento;
    private String denElemento;
    private String denCorta;
    private char vigente;

    public Elementos() {
    }

    public Elementos(String codTab, String codElemento, String denElemento, String denCorta, char vigente) {
        this.codTab = codTab;
        this.codElemento = codElemento;
        this.denElemento = denElemento;
        this.denCorta = denCorta;
        this.vigente = vigente;
    }

    public String getCodTab() {
        return codTab;
    }

    public void setCodTab(String codTab) {
        this.codTab = codTab;
    }

    public String getCodElemento() {
        return codElemento;
    }

    public void setCodElemento(String codElemento) {
        this.codElemento = codElemento;
    }

    public String getDenElemento() {
        return denElemento;
    }

    public void setDenElemento(String denElemento) {
        this.denElemento = denElemento;
    }

    public String getDenCorta() {
        return denCorta;
    }

    public void setDenCorta(String denCorta) {
        this.denCorta = denCorta;
    }

    public char getVigente() {
        return vigente;
    }

    public void setVigente(char vigente) {
        this.vigente = vigente;
    }

    @Override
    public String toString() {
        return denElemento;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Elementos){
            Elementos t = (Elementos)obj;
            if(t.getCodElemento().equals(this.getCodElemento()) && t.getCodTab().equals(this.getCodTab())){
                return true;
            }
        }
        return false;
    }
}
