package Modelo.Auxiliares;

public class DatosPartida {
  private int codCia;
  private int codProyecto;
  private String ingegr;
  private int codPartida;
  private String desPartida;
  private double costoTot;
  private double igv;
  private String semilla;

  public DatosPartida() {
  }

  public DatosPartida(int codPartida, String desPartida, double costoTot, double igv, String semilla) {
    this.codPartida = codPartida;
    this.desPartida = desPartida;
    this.costoTot = costoTot;
    this.igv = igv;
    this.semilla = semilla;
  }

  public DatosPartida(int codCia, int codProyecto, String ingegr, int codPartida, String desPartida, double costoTot,
      double igv, String semilla) {
    this.codCia = codCia;
    this.codProyecto = codProyecto;
    this.ingegr = ingegr;
    this.codPartida = codPartida;
    this.desPartida = desPartida;
    this.costoTot = costoTot;
    this.igv = igv;
    this.semilla = semilla;
  }

  public int getCodCia() {
    return codCia;
  }

  public void setCodCia(int codCia) {
    this.codCia = codCia;
  }

  public int getCodProyecto() {
    return codProyecto;
  }

  public void setCodProyecto(int codProyecto) {
    this.codProyecto = codProyecto;
  }

  public String getIngegr() {
    return ingegr;
  }

  public void setIngegr(String ingegr) {
    this.ingegr = ingegr;
  }

  public int getCodPartida() {
    return codPartida;
  }

  public void setCodPartida(int codPartida) {
    this.codPartida = codPartida;
  }

  public String getDesPartida() {
    return desPartida;
  }

  public void setDesPartida(String desPartida) {
    this.desPartida = desPartida;
  }

  public double getCostoTot() {
    return costoTot;
  }

  public void setCostoTot(double costoTot) {
    this.costoTot = costoTot;
  }

  public double getIgv() {
    return igv;
  }

  public void setIgv(double igv) {
    this.igv = igv;
  }

  public String getSemilla() {
    return semilla;
  }

  public void setSemilla(String semilla) {
    this.semilla = semilla;
  }

  @Override
  public String toString() {
    return desPartida;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof DatosPartida) {
      return ((DatosPartida) obj).getCodPartida() == this.codPartida
          && ((DatosPartida) obj).getCodCia() == this.codCia && ((DatosPartida) obj).getSemilla().equals(this.semilla)
          && ((DatosPartida) obj).getIngegr().equals(this.ingegr)
          && ((DatosPartida) obj).getCodProyecto() == this.codProyecto;
    }
    return false;
  }

}
