package Modelo.Auxiliares;

public class PartidaAux {
  private String ingEgr;
  private int CodPartida;
  private String DesPartida;
  private String CodPartidas;
  private String tUniMed;
  private String tUniMedDes;
  private String eUniMed;
  private String eUniMedDes;

  public PartidaAux(int CodPartida, String ingEgr, String DesPartida, String tUniMed, String tUniMedDes, String eUniMed, String eUniMedDes) {
    this.CodPartida = CodPartida;
    this.ingEgr = ingEgr;
    this.DesPartida = DesPartida;
    this.tUniMed = tUniMed;
    this.eUniMed = eUniMed;
    this.tUniMedDes = tUniMedDes;
    this.eUniMedDes = eUniMedDes;
  }

  public PartidaAux (int CodPartida, String ingEgr, String DesPartida, String tUniMed, String eUniMed) {
    this.CodPartida = CodPartida;
    this.ingEgr = ingEgr;
    this.DesPartida = DesPartida;
    this.tUniMed = tUniMed;
    this.eUniMed = eUniMed;
  }

  public PartidaAux (int CodPartida, String ingEgr, String DesPartida) {
    this.CodPartida = CodPartida;
    this.ingEgr = ingEgr;
    this.DesPartida = DesPartida;
  }

  public PartidaAux() {
  }
  
  public int getCodPartida() {
    return CodPartida;
  }

  public void setCodPartida(int CodPartida) {
    this.CodPartida = CodPartida;
  }

  public String getIngEgr() {
    return ingEgr;
  }

  public void setIngEgr(String ingEgr) {
    this.ingEgr = ingEgr;
  }

  public String getDesPartida() {
    return DesPartida;
  }

  public void setDesPartida(String DesPartida) {
    this.DesPartida = DesPartida;
  }

  public String getCodPartidas() {
    return CodPartidas;
  }

  public void setCodPartidas(String CodPartidas) {
    this.CodPartidas = CodPartidas;
  }

  public String gettUniMed() {
    return tUniMed;
  }

  public void settUniMed(String tUniMed) {
    this.tUniMed = tUniMed;
  }

  public String gettUniMedDes() {
    return tUniMedDes;
  }

  public void settUniMedDes(String tUniMedDes) {
    this.tUniMedDes = tUniMedDes;
  }

  public String geteUniMed() {
    return eUniMed;
  }

  public void seteUniMed(String eUniMed) {
    this.eUniMed = eUniMed;
  }

  public String geteUniMedDes() {
    return eUniMedDes;
  }

  public void seteUniMedDes(String eUniMedDes) {
    this.eUniMedDes = eUniMedDes;
  }

  @Override
  public String toString() {
    return DesPartida;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PartidaAux) {
      PartidaAux p = (PartidaAux) obj;
      return p.CodPartida == this.CodPartida && p.ingEgr.equals(this.ingEgr);
    }
    return false;
  }

}
