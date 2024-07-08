package Modelo.Auxiliares;

public class ProyectoAux {
  private int codPyto;
  private String nomPyto;

  
  public ProyectoAux(int codPyto, String nomPyto) {
    this.codPyto = codPyto;
    this.nomPyto = nomPyto;
  }

  public ProyectoAux() {
  }

  public int getCodPyto() {
    return codPyto;
  }

  public void setCodPyto(int codPyto) {
    this.codPyto = codPyto;
  }

  public String getNomPyto() {
    return nomPyto;
  }

  public void setNomPyto(String nomPyto) {
    this.nomPyto = nomPyto;
  }

  @Override
  public String toString() {
    return nomPyto;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ProyectoAux) {
      ProyectoAux p = (ProyectoAux) obj;
      return p.getCodPyto() == this.getCodPyto();
    }
    return false;
  }
}
