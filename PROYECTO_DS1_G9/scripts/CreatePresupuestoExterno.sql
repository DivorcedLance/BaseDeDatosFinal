CREATE TABLE P_PARTIDA
(
    CodCia      NUMBER(6)    NOT NULL,
    IngEgr      VARCHAR2(1)  NOT NULL,
    CodPartida  NUMBER(6)    NOT NULL,
    CodPartidas VARCHAR2(12) NOT NULL,
    DesPartida  VARCHAR2(30) NOT NULL,
    FlgCC       VARCHAR2(1)  NOT NULL,
    Nivel       NUMBER(2)    NOT NULL,
    TUniMed     VARCHAR2(3)  NOT NULL,
    EUniMed     VARCHAR2(3)  NOT NULL,
    Semilla     NUMBER(5)    NOT NULL,
    Vigente     VARCHAR2(1)  NOT NULL,
    CONSTRAINT P_PARTIDA_PK PRIMARY KEY (CodCia, IngEgr, CodPartida)
);

CREATE TABLE P_PARTIDA_MEZCLA
(
    CodCia        NUMBER(6)    NOT NULL,
    IngEgr        VARCHAR2(1)  NOT NULL,
    CodPartida    NUMBER(6)    NOT NULL,
    Corr          NUMBER(6)    NOT NULL,
    PadCodPartida NUMBER(6)    NOT NULL,
    TUniMed       VARCHAR2(3)  NOT NULL,
    EUniMed       VARCHAR2(3)  NOT NULL,
    CostoUnit     NUMBER(9, 2) NOT NULL,
    Nivel         NUMBER(5)    NOT NULL,
    Orden         NUMBER(5)    NOT NULL,
    Vigente       VARCHAR2(1)  NOT NULL,
    CONSTRAINT P_PARTIDA_MEZCLA_PK PRIMARY KEY (CodCia, IngEgr, CodPartida, Corr)
);

CREATE TABLE P_PROY_PARTIDA_MEZCLA
(
    CodCia        NUMBER(6)     NOT NULL,
    CodPyto       NUMBER(6)     NOT NULL,
    IngEgr        VARCHAR2(1)   NOT NULL,
    NroVersion    NUMBER(1)     NOT NULL,
    CodPartida    NUMBER(6)     NOT NULL,
    Corr          NUMBER(6)     NOT NULL,
    PadCodPartida NUMBER(6)     NOT NULL, --Cambio de VARCHAR A NUMBER(6)
    TUniMed       VARCHAR2(3)   NOT NULL,
    EUniMed       VARCHAR2(3)   NOT NULL,
    Nivel         NUMBER(5)     NOT NULL,
    Orden         NUMBER(5)     NOT NULL,
    CostoUnit     NUMBER(9, 2)  NOT NULL,
    Cant          NUMBER(7, 3)  NOT NULL,
    CostoTot      NUMBER(10, 2) NOT NULL,
    CONSTRAINT P_PROY_PARTIDA_MEZCLA_PK PRIMARY KEY (CodCia, CodPyto, NroVersion,
                                                     IngEgr, CodPartida, Corr)
);

CREATE TABLE P_PROY_PARTIDA
(
    CodCia      NUMBER(6)    NOT NULL,
    CodPyto     NUMBER(6)    NOT NULL,
    NroVersion  NUMBER(1)    NOT NULL,
    IngEgr      VARCHAR2(1)  NOT NULL,
    CodPartida  NUMBER(6)    NOT NULL,
    CodPartidas VARCHAR2(12) NOT NULL,
    FlgCC       VARCHAR2(1)  NOT NULL,
    Nivel       NUMBER(2)    NOT NULL,
    UniMed      VARCHAR2(5)  NOT NULL,
    TabEstado   VARCHAR2(3)  NOT NULL,
    CodEstado   VARCHAR2(3)  NOT NULL,
    Vigente     VARCHAR2(1)  NOT NULL,
    CONSTRAINT P_PROY_PARTIDA_PK PRIMARY KEY (CodCia, CodPyto, NroVersion, IngEgr, CodPartida)
);

CREATE TABLE P_DPROY_PARTIDA_MEZCLA
(
    CodCia        NUMBER(6)    NOT NULL,
    CodPyto       NUMBER(6)    NOT NULL,
    IngEgr        VARCHAR2(1)  NOT NULL,
    NroVersion    NUMBER(1)    NOT NULL,
    CodPartida    NUMBER(6)    NOT NULL,
    Corr          NUMBER(6)    NOT NULL,
    Sec           NUMBER(4)    NOT NULL,
    TDesembolso   VARCHAR2(3)  NOT NULL,
    EDesembolso   VARCHAR2(3)  NOT NULL,
    NroPago       NUMBER(2)    NOT NULL,
    TCompPago     VARCHAR2(3)  NOT NULL,
    ECompPago     VARCHAR2(3)  NOT NULL,
    FecDesembolso DATE         NOT NULL,
    ImpDesembNeto NUMBER(9, 2) NOT NULL,
    ImpDesembIGV  NUMBER(8, 2) NOT NULL,
    ImpDesembTot  NUMBER(9, 2) NOT NULL,
    Semilla       NUMBER(5)    NOT NULL,
    CONSTRAINT P_DPROY_PARTIDA_MEZCLA_PK PRIMARY KEY (CodCia, CodPyto, IngEgr, NroVersion, CodPartida, Corr, Sec)
);

CREATE TABLE P_COMP_PAGOCAB
(
    CodCIA       NUMBER(6)      NOT NULL,
    CodProveedor NUMBER(6)      NOT NULL,
    NroCP        VARCHAR2(20)   NOT NULL,
    CodPyto      NUMBER(6)      NOT NULL,
    NroPago      NUMBER(3)      NOT NULL,
    TCompPago    VARCHAR2(3)    NOT NULL,
    ECompPago    VARCHAR2(3)    NOT NULL,
    FecCP        DATE           NOT NULL,
    TMoneda      VARCHAR2(3)    NOT NULL,
    EMoneda      VARCHAR2(3)    NOT NULL,
    TipCambio    NUMBER(7, 4)   NOT NULL,
    ImpMO        NUMBER(9, 2)   NOT NULL,
    ImpNetoMN    NUMBER(9, 2)   NOT NULL,
    ImpIGVMN     NUMBER(9, 2)   NOT NULL,
    ImpTotalMn   NUMBER(10, 2)  NOT NULL,
    FotoCP       VARCHAR2(60)   NOT NULL,
    FotoAbono    VARCHAR2(60)   NOT NULL,
    FecAbono     DATE           NOT NULL,
    DesAbono     VARCHAR2(1000) NOT NULL,
    Semilla      NUMBER(5)      NOT NULL,
    TabEstado    VARCHAR2(3)    NOT NULL,
    CodEstado    VARCHAR2(3)    NOT NULL,
    CONSTRAINT P_COMP_PAGOCAB_PK PRIMARY KEY (CodCIA, CodProveedor, NroCP)
);

CREATE TABLE P_COMP_PAGODET
(
    CodCIA       NUMBER(6)    NOT NULL,
    CodProveedor NUMBER(6)    NOT NULL,
    NroCP        VARCHAR2(20) NOT NULL,
    Sec          NUMBER(4)    NOT NULL,
    IngEgr       VARCHAR2(1)  NOT NULL,
    CodPartida   NUMBER(6)    NOT NULL,
    ImpNetoMN    NUMBER(9, 2) NOT NULL,
    ImpIGVMN     NUMBER(9, 2) NOT NULL,
    ImpTotalMn   NUMBER(9, 2) NOT NULL,
    Semilla      NUMBER(5)    NOT NULL,
    CONSTRAINT P_COMP_PAGODET_PK PRIMARY KEY (CodCIA, CodProveedor, NroCP, Sec)
);

CREATE TABLE P_VTACOMP_PAGOCAB
(
    CodCIA     NUMBER(6)      NOT NULL,
    NroCP      VARCHAR2(20)   NOT NULL,
    CodPyto    NUMBER(6)      NOT NULL,
    CodCliente NUMBER(6)      NOT NULL,
    NroPago    NUMBER(3)      NOT NULL,
    TCompPago  VARCHAR2(3)    NOT NULL,
    ECompPago  VARCHAR2(3)    NOT NULL,
    FecCP      DATE           NOT NULL,
    TMoneda    VARCHAR2(3)    NOT NULL,
    EMoneda    VARCHAR2(3)    NOT NULL,
    TipCambio  NUMBER(7, 4)   NOT NULL,
    ImpMO      NUMBER(9, 2)   NOT NULL,
    ImpNetoMN  NUMBER(9, 2)   NOT NULL,
    ImpIGVMN   NUMBER(9, 2)   NOT NULL,
    ImpTotalMN NUMBER(10, 2)  NOT NULL,
    FotoCP     VARCHAR2(60)   NOT NULL,
    FotoAbono  VARCHAR2(60)   NOT NULL,
    FecAbono   DATE           NOT NULL,
    DesAbono   VARCHAR2(1000) NOT NULL,
    Semilla    NUMBER(5)      NOT NULL,
    TabEstado  VARCHAR2(3)    NOT NULL,
    CodEstado  VARCHAR2(3)    NOT NULL,
    CONSTRAINT P_VTACOMP_PAGOCAB_PK PRIMARY KEY (CodCIA, NroCP)
);

CREATE TABLE P_VTACOMP_PAGODET
(
    CodCIA     NUMBER(6)    NOT NULL,
    NroCP      VARCHAR2(20) NOT NULL,
    Sec        NUMBER(4)    NOT NULL,
    IngEgr     VARCHAR2(1)  NOT NULL,
    CodPartida NUMBER(6)    NOT NULL,
    ImpNetoMN  NUMBER(9, 2) NOT NULL,
    ImpIGVMN   NUMBER(9, 2) NOT NULL,
    ImpTotalMn NUMBER(9, 2) NOT NULL,
    Semilla    NUMBER(5)    NOT NULL,
    CONSTRAINT P_VTACOMP_PAGODET_PK PRIMARY KEY (CodCIA, NroCP, Sec)
);

CREATE TABLE P_FLUJOCAJA
(
    CodCia           NUMBER(6)    NOT NULL,
    CodPyto          NUMBER(6)    NOT NULL,
    IngEgr           VARCHAR2(1)  NOT NULL,
    Tipo             VARCHAR2(1)  NOT NULL,
    CodPartida       NUMBER(6)    NOT NULL,
    Nivel            NUMBER(1)    NOT NULL,
    Orden            NUMBER(5)    NOT NULL,
    DesConcepto      VARCHAR2(30) NOT NULL,
    DesConceptoCorto VARCHAR2(10) NOT NULL,
    Semilla          NUMBER(5)    NOT NULL,
    Raiz             NUMBER(5)    NOT NULL,
    TabEstado        VARCHAR2(3)  NOT NULL,
    CodEstado        VARCHAR2(3)  NOT NULL,
    Vigente          VARCHAR2(1)  NOT NULL,
    CONSTRAINT P_FLUJOCAJA_PK PRIMARY KEY (CodCia, CodPyto, IngEgr, Tipo, CodPartida)
);

CREATE TABLE P_FLUJOCAJA_DET
(
    Anno        NUMBER(4)     NOT NULL,
    CodCia      NUMBER(6)     NOT NULL,
    CodPyto     NUMBER(6)     NOT NULL,
    IngEgr      VARCHAR2(1)   NOT NULL,
    Tipo        VARCHAR2(1)   NOT NULL,
    CodPartida  NUMBER(6)     NOT NULL,
    Orden       NUMBER(5)     NOT NULL,
    ImpIni      NUMBER(12, 2) NOT NULL,
    ImpRealIni  NUMBER(12, 2) NOT NULL,
    ImpEne      NUMBER(12, 2) NOT NULL,
    ImpRealEne  NUMBER(12, 2) NOT NULL,
    ImpFeb      NUMBER(12, 2) NOT NULL,
    ImpRealFeb  NUMBER(12, 2) NOT NULL,
    ImpMar      NUMBER(12, 2) NOT NULL,
    ImpRealMar  NUMBER(12, 2) NOT NULL,
    ImpAbr      NUMBER(12, 2) NOT NULL,
    ImpRealAbr  NUMBER(12, 2) NOT NULL,
    ImpMay      NUMBER(12, 2) NOT NULL,
    ImpRealMay  NUMBER(12, 2) NOT NULL,
    ImpJun      NUMBER(12, 2) NOT NULL,
    ImpRealJun  NUMBER(12, 2) NOT NULL,
    ImpJul      NUMBER(12, 2) NOT NULL,
    ImpRealJul  NUMBER(12, 2) NOT NULL,
    ImpAgo      NUMBER(12, 2) NOT NULL,
    ImpRealAgo  NUMBER(12, 2) NOT NULL,
    ImpSep      NUMBER(12, 2) NOT NULL,
    ImpRealSep  NUMBER(12, 2) NOT NULL,
    ImpOct      NUMBER(12, 2) NOT NULL,
    ImpRealOct  NUMBER(12, 2) NOT NULL,
    ImpNov      NUMBER(12, 2) NOT NULL,
    ImpRealNov  NUMBER(12, 2) NOT NULL,
    ImpDic      NUMBER(12, 2) NOT NULL,
    ImpRealDic  NUMBER(12, 2) NOT NULL,
    ImpAcum     NUMBER(12, 2) NOT NULL,
    ImpRealAcum NUMBER(12, 2) NOT NULL,
    CONSTRAINT P_FLUJOCAJA_DET_PK PRIMARY KEY (Anno, CodCia, CodPyto, IngEgr, Tipo, CodPartida)
);

ALTER TABLE P_PARTIDA
    ADD CONSTRAINT P_CIA_PARTIDAFK
        FOREIGN KEY (CodCia)
            REFERENCES CIA (CodCia);

ALTER TABLE P_PROY_PARTIDA
    ADD CONSTRAINT P_PROYECTO_PROY_PARTIDA_FK
        FOREIGN KEY (CodCia, CodPyto)
            REFERENCES PROYECTO (CodCia, CODPYTO);

ALTER TABLE P_PROY_PARTIDA
    ADD CONSTRAINT P_PARTIDA_PROY_PARTIDA_FK
        FOREIGN KEY (CodCia, IngEgr, CodPartida)
            REFERENCES P_PARTIDA (CodCia, IngEgr, CodPartida);

ALTER TABLE P_PARTIDA_MEZCLA
    ADD CONSTRAINT P_PARTIDA_PARTIDA_MEZCLA_FK
        FOREIGN KEY (CodCia, IngEgr, CodPartida)
            REFERENCES P_PARTIDA (CodCia, IngEgr, CodPartida);

ALTER TABLE P_PARTIDA_MEZCLA
    ADD CONSTRAINT P_ELEMENTOS_PARTIDA_MEZCLA_FK
        FOREIGN KEY (TUniMed, EUniMed)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_DPROY_PARTIDA_MEZCLA
    ADD CONSTRAINT P_PROY_PARTIDA_MEZCLA_DPROY_PARTIDA_MEZCLA_FK
        FOREIGN KEY (CodCia, CodPyto, IngEgr, NroVersion, CodPartida, Corr)
            REFERENCES P_PROY_PARTIDA_MEZCLA (CodCia, CodPyto, IngEgr, NroVersion, CodPartida, Corr);

ALTER TABLE P_DPROY_PARTIDA_MEZCLA
    ADD CONSTRAINT P_ELEMENTOS_DPROY_PARTIDA_MEZCLA_Desembolso_FK
        FOREIGN KEY (TDesembolso, EDesembolso)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_DPROY_PARTIDA_MEZCLA
    ADD CONSTRAINT P_ELEMENTOS_DPROY_PARTIDA_MEZCLA_Comprobante_FK
        FOREIGN KEY (TCompPago, ECompPago)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_COMP_PAGOCAB
    ADD CONSTRAINT P_COMP_PAGOCAB_PROVEEDOR_FK
        FOREIGN KEY (CodCIA, CodProveedor)
            REFERENCES PROVEEDOR (CodCIA, CodProveedor);

ALTER TABLE P_COMP_PAGOCAB
    ADD CONSTRAINT P_COMP_PAGOCAB_ELEMENTOS_FK
        FOREIGN KEY (TMoneda, EMoneda)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_COMP_PAGOCAB
    ADD CONSTRAINT P_COMP_PAGOCAB_ELEMENTOS_2_FK
        FOREIGN KEY (TCompPago, ECompPago)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_COMP_PAGOCAB
    ADD CONSTRAINT P_COMP_PAGOCAB_PROYECTO_FK
        FOREIGN KEY (CodCIA, CodPyto)
            REFERENCES PROYECTO (CodCIA, CodPyto);

ALTER TABLE P_COMP_PAGODET
    ADD CONSTRAINT P_COMP_PAGODET_COMP_PAGOCAB_FK
        FOREIGN KEY (CodCIA, CodProveedor, NroCP)
            REFERENCES P_COMP_PAGOCAB (CodCIA, CodProveedor, NroCP);

ALTER TABLE P_COMP_PAGODET
    ADD CONSTRAINT P_COMP_PAGODET_PARTIDA_FK
        FOREIGN KEY (CodCIA, IngEgr, CodPartida)
            REFERENCES P_PARTIDA (CodCIA, IngEgr, CodPartida);

ALTER TABLE P_VTACOMP_PAGOCAB
    ADD CONSTRAINT P_VTACOMP_PAGOCAB_CLIENTE_FK
        FOREIGN KEY (CodCIA, CodCliente)
            REFERENCES CLIENTE (CodCIA, CodCliente);

ALTER TABLE P_VTACOMP_PAGOCAB
    ADD CONSTRAINT P_VTACOMP_PAGOCAB_ELEMENTOS_FK
        FOREIGN KEY (TMoneda, EMoneda)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_VTACOMP_PAGOCAB
    ADD CONSTRAINT P_VTACOMP_PAGOCAB_ELEMENTOS_2_FK
        FOREIGN KEY (TCompPago, ECompPago)
            REFERENCES ELEMENTOS (CodTab, CodElem);

ALTER TABLE P_VTACOMP_PAGOCAB
    ADD CONSTRAINT P_VTACOMP_PAGOCAB_PROYECTO_FK
        FOREIGN KEY (CodCIA, CodPyto)
            REFERENCES PROYECTO (CodCIA, CodPyto);

ALTER TABLE P_VTACOMP_PAGODET
    ADD CONSTRAINT P_VTACOMP_PAGODET_VTACOMP_PAGOCAB_FK
        FOREIGN KEY (CodCIA, NroCP)
            REFERENCES P_VTACOMP_PAGOCAB (CodCIA, NroCP);

ALTER TABLE P_VTACOMP_PAGODET
    ADD CONSTRAINT P_VTACOMP_PAGODET_PARTIDA_FK
        FOREIGN KEY (CodCIA, IngEgr, CodPartida)
            REFERENCES P_PARTIDA (CodCIA, IngEgr, CodPartida);

ALTER TABLE P_FLUJOCAJA
    ADD CONSTRAINT P_PARTIDA_FLUJOCAJA_FK
        FOREIGN KEY (CodCia, IngEgr, CodPartida)
            REFERENCES P_PARTIDA (CodCia, IngEgr, CodPartida);

ALTER TABLE P_FLUJOCAJA
    ADD CONSTRAINT P_PROYECTO_FLUJOCAJA_FK
        FOREIGN KEY (CodCia, CodPyto)
            REFERENCES PROYECTO (CodCia, CodPyto);

ALTER TABLE P_FLUJOCAJA_DET
    ADD CONSTRAINT P_FLUJOCAJA_FLUJOCAJA_DET_FK
        FOREIGN KEY (CodCia, CodPyto, IngEgr, Tipo, CodPartida)
            REFERENCES P_FLUJOCAJA (CodCia, CodPyto, IngEgr, Tipo, CodPartida);

create sequence P_SEC_PARTIDA_E
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_PARTIDA_I
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_CODPARTIDAS
    start with 1
    increment by 1
    maxvalue 99999999
    minvalue 1;

create sequence P_SEC_PARTIDA_MEZCLA_E
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_PARTIDA_MEZCLA_I
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_PROY_PARTIDA_MEZCLA_E
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_PROY_PARTIDA_MEZCLA_I
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_E
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_I
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_PAGO
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_ADELANTO
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_I
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_E
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence P_SEC_NRO_PAGO_VTA
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;


create or replace TRIGGER P_INSERTAR_FLUJOCAJA_CABECERA
    BEFORE INSERT
    ON P_PROY_PARTIDA_MEZCLA
    FOR EACH ROW
DECLARE
    annoAuxiliar     NUMBER(10);
    numeroDeColumnas NUMBER(10);
    CURSOR CURSOR_ANNOS IS
        select n
        from (select distinct rownum n
              from dual
              connect by level <= (SELECT ANNOFIN FROM PROYECTO WHERE CODPYTO = :new.CODPYTO))
        where n >= (SELECT ANNOINI FROM PROYECTO WHERE CODPYTO = :new.CODPYTO)
        ORDER BY n;
BEGIN
    select count(n)
    into numeroDeColumnas
    from (select distinct rownum n
          from dual
          connect by level <= (SELECT ANNOFIN FROM PROYECTO WHERE CODPYTO = :new.CODPYTO))
    where n >= (SELECT ANNOINI FROM PROYECTO WHERE CODPYTO = :new.CODPYTO)
    ORDER BY n;

    INSERT INTO P_FLUJOCAJA
    VALUES (:new.CODCIA, :new.CODPYTO, :new.INGEGR, '-', :new.CODPARTIDA, :new.NIVEL, :new.ORDEN, 'DESCONCEPTO',
            'D_CORTO', 0, 0, '-1', '1', '1');
    OPEN CURSOR_ANNOS;
    LOOP
        FETCH CURSOR_ANNOS INTO annoAuxiliar;
        INSERT INTO P_FLUJOCAJA_DET
        VALUES (annoAuxiliar, :new.CODCIA, :new.CODPYTO, :new.INGEGR, '-', :new.CODPARTIDA, :new.ORDEN, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        numeroDeColumnas := numeroDeColumnas - 1;
        EXIT WHEN numeroDeColumnas = 0;
    END LOOP;
    CLOSE CURSOR_ANNOS;
END;
/

create or replace FUNCTION P_getPadre(NROHIJO IN P_FLUJOCAJA.CODCIA%TYPE,
                                      ING_EGR IN P_FLUJOCAJA.INGEGR%TYPE,
                                      COD_PYTO IN PROYECTO.CODPYTO%TYPE)
    return NUMBER
    IS
    NROPADRE NUMBER;
BEGIN
    SELECT PADCODPARTIDA
    INTO NROPADRE
    FROM P_PROY_PARTIDA_MEZCLA
    WHERE CODPARTIDA = NROHIJO
      AND INGEGR = ING_EGR
      AND CODPYTO = COD_PYTO;
    RETURN NROPADRE;
END P_getPadre;
/


CREATE OR REPLACE PROCEDURE P_UPDATE_FLUJOCAJA_DET_UNALINEA_Y_GLOBAL(COD_CIA IN P_FLUJOCAJA.CODCIA%TYPE,
                                                                     COD_PYTO IN P_FLUJOCAJA.CODPYTO%TYPE,
                                                                     ING_EGR IN P_FLUJOCAJA.INGEGR%TYPE,
                                                                     COD_PARTIDA IN P_FLUJOCAJA.CODPARTIDA%TYPE,
                                                                     COSTO_TOTAL IN P_COMP_PAGOCAB.IMPTOTALMN%TYPE,
                                                                     FECHA IN P_VTACOMP_PAGOCAB.FECCP%TYPE,
                                                                     PROYECTADO_REAL IN CLIENTE.VIGENTE%TYPE)
    IS
    contador            number(20);
    nroDeMes            number(2);
    nroDeAnio           number(4);
    valorAuxiliarActual number(10);
    valorAuxiliarPadre  number(10);
    codHijo             number(10);
BEGIN
    nroDeMes := to_char(FECHA, 'MM');
    nroDeAnio := to_char(FECHA, 'YYYY');

    IF (PROYECTADO_REAL = 'P') THEN
        IF (nroDeMes = 1) THEN
            SELECT IMPENE
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPENE=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPENE
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPENE=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPACUM = IMPINI + IMPENE + IMPFEB + IMPMAR + IMPABR + IMPMAY + IMPJUN + IMPJUL + IMPAGO +
                                  IMPSEP + IMPOCT + IMPNOV + IMPDIC;
                    UPDATE P_FLUJOCAJA_DET F1
                    SET F1.IMPINI =
                            NVL((SELECT F2.IMPACUM
                                 FROM P_FLUJOCAJA_DET F2
                                 WHERE F2.ANNO = (F1.ANNO - 1)
                                   AND F2.CODPARTIDA = F1.CODPARTIDA
                                   AND F2.INGEGR = F1.INGEGR
                                   AND F2.CODPYTO = F1.CODPYTO
                                   AND F2.CODCIA = F1.CODCIA), 0);
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 2) THEN
            SELECT IMPFEB
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPFEB=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPFEB
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPFEB=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 3) THEN
            SELECT IMPMAR
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPMAR=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPMAR
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPMAR=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 4) THEN
            SELECT IMPABR
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPABR=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPABR
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPABR=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 5) THEN
            SELECT IMPMAY
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPMAY=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPMAY
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPMAY=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 6) THEN
            SELECT IMPJUN
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPJUN=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPJUN
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPJUN=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 7) THEN
            SELECT IMPJUL
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPJUL=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPJUL
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPJUL=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 8) THEN
            SELECT IMPAGO
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPAGO=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPAGO
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPAGO=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 9) THEN
            SELECT IMPSEP
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPSEP=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPSEP
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPSEP=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 10) THEN
            SELECT IMPOCT
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPOCT=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPOCT
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPOCT=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 11) THEN
            SELECT IMPNOV
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPNOV=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPNOV
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPNOV=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 12) THEN
            SELECT IMPDIC
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPDIC=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPDIC
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPDIC=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        END IF;
    END IF;

    IF (PROYECTADO_REAL = 'R') THEN
        IF (nroDeMes = 1) THEN
            SELECT IMPREALENE
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALENE=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALENE
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALENE=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 2) THEN
            SELECT IMPREALFEB
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALFEB=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALFEB
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALFEB=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 3) THEN
            SELECT IMPREALMAR
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALMAR=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALMAR
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALMAR=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 4) THEN
            SELECT IMPREALABR
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALABR=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALABR
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALABR=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 5) THEN
            SELECT IMPREALMAY
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALMAY=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALMAY
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALMAY=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 6) THEN
            SELECT IMPREALJUN
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALJUN=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALJUN
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALJUN=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 7) THEN
            SELECT IMPREALJUL
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALJUL=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALJUL
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALJUL=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 8) THEN
            SELECT IMPREALAGO
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALAGO=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALAGO
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALAGO=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 9) THEN
            SELECT IMPREALSEP
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALSEP=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALSEP
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALSEP=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 10) THEN
            SELECT IMPREALOCT
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALOCT=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALOCT
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALOCT=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 11) THEN
            SELECT IMPREALNOV
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALNOV=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALNOV
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALNOV=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        ELSIF (nroDeMes = 12) THEN
            SELECT IMPREALDIC
            INTO valorAuxiliarActual
            FROM P_FLUJOCAJA_DET
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALDIC=valorAuxiliarActual + COSTO_TOTAL
            WHERE CODCIA = COD_CIA
              AND CODPYTO = COD_PYTO
              AND INGEGR = ING_EGR
              AND CODPARTIDA = COD_PARTIDA
              AND ANNO = nroDeAnio;
            codHijo := COD_PARTIDA;
            WHILE (P_getPadre(codHijo, ING_EGR, COD_PYTO) <> 0)
                LOOP
                    SELECT IMPREALDIC
                    INTO valorAuxiliarPadre
                    FROM P_FLUJOCAJA_DET
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    UPDATE P_FLUJOCAJA_DET
                    SET IMPREALDIC=valorAuxiliarPadre + COSTO_TOTAL
                    WHERE CODCIA = COD_CIA
                      AND CODPYTO = COD_PYTO
                      AND INGEGR = ING_EGR
                      AND CODPARTIDA = P_getPadre(codHijo, ING_EGR, COD_PYTO)
                      AND ANNO = nroDeAnio;
                    codHijo := P_getPadre(codHijo, ING_EGR, COD_PYTO);
                END LOOP;
        END IF;
    END IF;

    --UPDATE P_FLUJOCAJA_DET SET IMPACUM = IMPINI+IMPENE+IMPFEB+IMPMAR+IMPABR+IMPMAY+IMPJUN+IMPJUL+IMPAGO+IMPSEP+IMPOCT+IMPNOV+IMPDIC;
    --UPDATE P_FLUJOCAJA_DET SET IMPREALACUM = IMPREALINI+IMPREALENE+IMPREALFEB+IMPREALMAR+IMPREALABR+IMPREALMAY+IMPREALJUN+IMPREALJUL+IMPREALAGO+IMPREALSEP+IMPREALOCT+IMPREALNOV+IMPREALDIC;

    contador := duracionProyecto(COD_PYTO);
    WHILE (contador > 0)
        LOOP
            contador := contador - 1;
            UPDATE P_FLUJOCAJA_DET F1
            SET F1.IMPINI =
                    NVL((SELECT F2.IMPACUM
                         FROM P_FLUJOCAJA_DET F2
                         WHERE F2.ANNO = (F1.ANNO - 1)
                           AND F2.CODPARTIDA = F1.CODPARTIDA
                           AND F2.INGEGR = F1.INGEGR
                           AND F2.CODPYTO = F1.CODPYTO
                           AND F2.CODCIA = F1.CODCIA), 0);

            UPDATE P_FLUJOCAJA_DET F1
            SET F1.IMPREALINI =
                    NVL((SELECT F2.IMPREALACUM
                         FROM P_FLUJOCAJA_DET F2
                         WHERE F2.ANNO = (F1.ANNO - 1)
                           AND F2.CODPARTIDA = F1.CODPARTIDA
                           AND F2.INGEGR = F1.INGEGR
                           AND F2.CODPYTO = F1.CODPYTO
                           AND F2.CODCIA = F1.CODCIA), 0);

            UPDATE P_FLUJOCAJA_DET
            SET IMPACUM = IMPINI + IMPENE + IMPFEB + IMPMAR + IMPABR + IMPMAY + IMPJUN + IMPJUL + IMPAGO + IMPSEP +
                          IMPOCT + IMPNOV + IMPDIC;
            UPDATE P_FLUJOCAJA_DET
            SET IMPREALACUM = IMPREALINI + IMPREALENE + IMPREALFEB + IMPREALMAR + IMPREALABR + IMPREALMAY + IMPREALJUN +
                              IMPREALJUL + IMPREALAGO + IMPREALSEP + IMPREALOCT + IMPREALNOV + IMPREALDIC;
        END LOOP;

END P_UPDATE_FLUJOCAJA_DET_UNALINEA_Y_GLOBAL;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_PARTIDA(
    CODCIA IN P_PARTIDA.CODCia%TYPE,
    INGEGRE IN P_PARTIDA.IngEgr%TYPE,
    DESPARTIDA IN P_PARTIDA.DESPARTIDA%TYPE,
    tUniMed IN P_PARTIDA.TUNIMED%TYPE,
    eUniMed IN P_PARTIDA.EUNIMED%TYPE,
    VIG IN P_PARTIDA.VIGENTE%TYPE)
    IS
BEGIN
    IF (INGEGRE = 'E') THEN
        INSERT INTO P_PARTIDA
        VALUES (CODCIA, INGEGRE, P_SEC_PARTIDA_E.NEXTVAL,
                TO_CHAR(P_SEC_CODPARTIDAS.NEXTVAL, '99,999,999'), DESPARTIDA, '1', 1, tUniMed, eUniMed, 1, VIG);
    END IF;
    IF (INGEGRE = 'I') THEN
        INSERT INTO P_PARTIDA
        VALUES (CODCIA, INGEGRE, P_SEC_PARTIDA_I.NEXTVAL,
                TO_CHAR(P_SEC_CODPARTIDAS.NEXTVAL, '99,999,999'), DESPARTIDA, '1', 1, tUniMed, eUniMed, 1, VIG);
    END IF;
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_PARTIDA_MEZCLA(
    CODCIA IN P_PARTIDA_MEZCLA.CODCIA%TYPE,
    INGEGRE IN P_PARTIDA_MEZCLA.IngEgr%TYPE,
    CODPAR IN P_PARTIDA_MEZCLA.CODPARTIDA%TYPE,
    PADCOD IN P_PARTIDA_MEZCLA.PADCODPARTIDA%TYPE,
    tUniMed IN P_PARTIDA_MEZCLA.TUNIMED%TYPE,
    eUniMed IN P_PARTIDA_MEZCLA.EUNIMED%TYPE,
    COSTO IN P_PARTIDA_MEZCLA.COSTOUNIT%TYPE,
    NIVEL IN P_PARTIDA_MEZCLA.NIVEL%TYPE,
    ORDEN IN P_PARTIDA_MEZCLA.ORDEN%TYPE,
    VIG IN P_PARTIDA_MEZCLA.VIGENTE%TYPE)
    IS
BEGIN
    IF (INGEGRE = 'E') THEN
        INSERT INTO P_PARTIDA_MEZCLA
        VALUES (CODCIA, INGEGRE, CODPAR, P_SEC_PARTIDA_MEZCLA_E.NEXTVAL,
                PADCOD, tUniMed, eUniMed, COSTO, NIVEL, ORDEN, VIG);
    END IF;
    IF (INGEGRE = 'I') THEN
        INSERT INTO P_PARTIDA_MEZCLA
        VALUES (CODCIA, INGEGRE, CODPAR, P_SEC_PARTIDA_MEZCLA_I.NEXTVAL,
                PADCOD, tUniMed, eUniMed, COSTO, NIVEL, ORDEN, VIG);
    END IF;
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_PROY_PARTIDA(
    CODPYTO IN P_PROY_PARTIDA.CODPYTO%TYPE,
    NROVERSION IN P_PROY_PARTIDA.NROVERSION%TYPE,
    CODCIA IN P_PROY_PARTIDA.CODCIA%TYPE,
    INGEGRE IN P_PROY_PARTIDA.IngEgr%TYPE,
    CODP IN P_PROY_PARTIDA.CODPARTIDA%TYPE,
    CODPAR IN P_PROY_PARTIDA.CODPARTIDAS%TYPE,
    TABE IN P_PROY_PARTIDA.TABESTADO%TYPE,
    CODE IN P_PROY_PARTIDA.CODESTADO%TYPE,
    VIG IN P_PROY_PARTIDA.VIGENTE%TYPE)
    IS
BEGIN
    INSERT INTO P_PROY_PARTIDA
    VALUES (CODCIA, CODPYTO, NROVERSION, INGEGRE, CODP, CODPAR, '1', 1, '1', TABE, CODE, VIG);
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_PROY_PARTIDA_MEZCLA(
    CODC IN P_PROY_PARTIDA_MEZCLA.CODCIA%TYPE,
    CODPYTO IN P_PROY_PARTIDA_MEZCLA.CODPYTO%TYPE,
    NROVERSION IN P_PROY_PARTIDA_MEZCLA.NROVERSION%TYPE,
    PADCOD IN P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA%TYPE,
    INEG IN P_PROY_PARTIDA_MEZCLA.IngEgr%TYPE,
    CAN IN P_PROY_PARTIDA_MEZCLA.CANT%TYPE)
AS
    CURSOR cpm IS
        SELECT CODPARTIDA, PADCODPARTIDA, TUNIMED, EUNIMED, COSTOUNIT, NIVEL, ORDEN
        FROM P_PARTIDA_MEZCLA
        WHERE CODCIA = CODC
          AND PADCODPARTIDA = PADCOD
          AND INGEGR = INEG;
    CURSOR cpm2 IS
        SELECT CODPARTIDA, PADCODPARTIDA, TUNIMED, EUNIMED, COSTOUNIT, NIVEL, ORDEN
        FROM P_PARTIDA_MEZCLA
        WHERE CODCIA = CODC
          AND CODPARTIDA = PADCOD
          AND PADCODPARTIDA = 0
          AND INGEGR = INEG;
    V_total P_PROY_PARTIDA_MEZCLA.COSTOTOT%TYPE;
BEGIN
    IF (INEG = 'E') THEN
        FOR R1 IN CPM2
            LOOP
                V_total := CAN * R1.COSTOUNIT;
                INSERT INTO P_PROY_PARTIDA_MEZCLA
                VALUES (CODC, CODPYTO, INEG, NROVERSION, R1.CODPARTIDA,
                        P_SEC_PROY_PARTIDA_MEZCLA_E.nextval, R1.PADCODPARTIDA, R1.TUNIMED, R1.EUNIMED,
                        R1.NIVEL, R1.ORDEN, R1.COSTOUNIT, CAN, V_total);
            END LOOP;

        FOR R2 IN CPM
            LOOP
                V_total := CAN * R2.COSTOUNIT;
                INSERT INTO P_PROY_PARTIDA_MEZCLA
                VALUES (CODC, CODPYTO, INEG, NROVERSION, R2.CODPARTIDA,
                        P_SEC_PROY_PARTIDA_MEZCLA_E.nextval, R2.PADCODPARTIDA, R2.TUNIMED, R2.EUNIMED,
                        R2.NIVEL, R2.ORDEN, R2.COSTOUNIT, CAN, V_total);
            END LOOP;
    END IF;
    IF (INEG = 'I') THEN
        FOR R3 IN CPM2
            LOOP
                V_total := CAN * R3.COSTOUNIT;
                INSERT INTO P_PROY_PARTIDA_MEZCLA
                VALUES (CODC, CODPYTO, INEG, NROVERSION, R3.CODPARTIDA,
                        P_SEC_PROY_PARTIDA_MEZCLA_I.nextval, R3.PADCODPARTIDA, R3.TUNIMED, R3.EUNIMED,
                        R3.NIVEL, R3.ORDEN, R3.COSTOUNIT, CAN, V_total);
            END LOOP;

        FOR R4 IN CPM
            LOOP
                V_total := CAN * R4.COSTOUNIT;
                INSERT INTO P_PROY_PARTIDA_MEZCLA
                VALUES (CODC, CODPYTO, INEG, NROVERSION, R4.CODPARTIDA,
                        P_SEC_PROY_PARTIDA_MEZCLA_I.nextval, R4.PADCODPARTIDA, R4.TUNIMED, R4.EUNIMED,
                        R4.NIVEL, R4.ORDEN, R4.COSTOUNIT, CAN, V_total);
            END LOOP;
    END IF;
END;
/

create or replace PROCEDURE P_INSERTAR_DPROY_PARTIDA_MEZCLA(
    CODCIA IN P_DPROY_PARTIDA_MEZCLA.CODCIA%TYPE,
    CODPYTO IN P_DPROY_PARTIDA_MEZCLA.CODPYTO%TYPE,
    INGEGR IN P_DPROY_PARTIDA_MEZCLA.INGEGR%TYPE,
    NROVERSION IN P_DPROY_PARTIDA_MEZCLA.NROVERSION%TYPE,
    CODPART IN P_DPROY_PARTIDA_MEZCLA.CODPARTIDA%TYPE,
    CORR IN P_DPROY_PARTIDA_MEZCLA.CORR%TYPE,
    EDESEMB IN P_DPROY_PARTIDA_MEZCLA.EDESEMBOLSO%TYPE,
    ECPAGO IN P_DPROY_PARTIDA_MEZCLA.ECOMPPAGO%TYPE,
    FECDESEMB IN P_DPROY_PARTIDA_MEZCLA.FECDESEMBOLSO%TYPE,
    IMPDESEMNETO IN P_DPROY_PARTIDA_MEZCLA.IMPDESEMBNETO%TYPE,
    IMPDESEMIGV IN P_DPROY_PARTIDA_MEZCLA.IMPDESEMBIGV%TYPE,
    IMPDESEMTOT IN P_DPROY_PARTIDA_MEZCLA.IMPDESEMBTOT%TYPE,
    SEMI IN P_DPROY_PARTIDA_MEZCLA.SEMILLA%TYPE,
    REPETICION IN P_DPROY_PARTIDA_MEZCLA.CODCIA%TYPE)
    IS
BEGIN

    IF (INGEGR = 'E') THEN
        IF (REPETICION = 0) THEN
            IF (EDESEMB = 1) THEN
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_E.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_ADELANTO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT,
                        P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_E.NEXTVAL);
            ELSE
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_E.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_PAGO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT,
                        P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_E.NEXTVAL);
            END IF;
        ELSE
            IF (EDESEMB = 1) THEN
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_E.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_ADELANTO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT, SEMI);
            ELSE
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_E.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_PAGO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT, SEMI);
            END IF;
        END IF;
    END IF;

    IF (INGEGR = 'I') THEN
        IF (REPETICION = 0) THEN
            IF (EDESEMB = 1) THEN
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_I.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_ADELANTO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT,
                        P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_I.NEXTVAL);
            ELSE
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_I.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_PAGO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT,
                        P_SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_I.NEXTVAL);
            END IF;
        ELSE
            IF (EDESEMB = 1) THEN
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_I.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_ADELANTO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT, SEMI);
            ELSE
                INSERT INTO P_DPROY_PARTIDA_MEZCLA
                VALUES (CODCIA, CODPYTO, INGEGR, NROVERSION, CODPART, CORR,
                        P_SEC_DPROY_PARTIDA_MEZCLA_I.NEXTVAL, 3, EDESEMB, P_SEC_DPROY_PARTIDA_MEZCLA_PAGO.NEXTVAL, 4,
                        ECPAGO, FECDESEMB, IMPDESEMNETO, IMPDESEMIGV, IMPDESEMTOT, SEMI);
            END IF;
        END IF;
    END IF;

    P_UPDATE_FLUJOCAJA_DET_UNALINEA_Y_GLOBAL(CODCIA, CODPYTO, INGEGR, CODPART, IMPDESEMTOT, FECDESEMB, 'P');

END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_COMP_PAGOCAB(
    CODCIA IN P_comp_pagocab.codcia%TYPE,
    CODPROVEEDOR IN P_comp_pagocab.codproveedor%TYPE,
    NROCP IN P_comp_pagocab.nrocp%TYPE,
    CODPYTO IN P_comp_pagocab.codpyto%TYPE,
    NROPAGO IN P_comp_pagocab.nropago%TYPE,
    TCOMPPAGO IN P_comp_pagocab.tcomppago%TYPE,
    ECOMPPAGO IN P_comp_pagocab.ecomppago%TYPE,
    FECCP IN P_comp_pagocab.feccp%TYPE,
    TMONEDA IN P_comp_pagocab.tmoneda%TYPE,
    EMONEDA IN P_comp_pagocab.emoneda%TYPE,
    TIPCAMBIO IN P_comp_pagocab.tipcambio%TYPE,
    IMPMO IN P_comp_pagocab.impmo%TYPE,
    IMPNETOMN IN P_comp_pagocab.impnetomn%TYPE,
    IMPIGVMN IN P_comp_pagocab.impigvmn%TYPE,
    IMPTOTALMN IN P_comp_pagocab.imptotalmn%TYPE,
    FOTOCP IN P_comp_pagocab.fotocp%TYPE,
    FOTOABONO IN P_comp_pagocab.fotoabono%TYPE,
    FECABONO IN P_comp_pagocab.fecabono%TYPE,
    DESABONO IN P_comp_pagocab.desabono%TYPE,
    SEMILLA IN P_comp_pagocab.semilla%TYPE,
    TABESTADO IN P_comp_pagocab.tabestado%TYPE,
    CODESTADO IN P_comp_pagocab.codestado%TYPE)
    IS
BEGIN
    INSERT INTO P_COMP_PAGOCAB VALUES(CODCIA,CODPROVEEDOR,NROCP,CODPYTO,NROPAGO,TCOMPPAGO,ECOMPPAGO,FECCP,TMONEDA,EMONEDA,TIPCAMBIO,IMPMO,IMPNETOMN,IMPIGVMN,IMPTOTALMN,FOTOCP,FOTOABONO,FECABONO,DESABONO,
                                      SEMILLA,TABESTADO,CODESTADO);
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_VTACOMP_PAGODET(
    COD_CIA IN P_VTACOMP_PAGODET.codcia%TYPE,
    NRO_CP IN P_VTACOMP_PAGODET.nrocp%TYPE,
    SEC IN P_VTACOMP_PAGODET.sec%TYPE,
    INGEGR IN P_VTACOMP_PAGODET.ingegr%TYPE,
    CODPARTIDA IN P_VTACOMP_PAGODET.codpartida%TYPE,
    IMPNETOMN IN P_VTACOMP_PAGODET.impnetomn%TYPE,
    IMPIGVMN IN P_VTACOMP_PAGODET.impigvmn%TYPE,
    IMPTOTALMN IN P_VTACOMP_PAGODET.imptotalmn%TYPE,
    SEMILL IN P_VTACOMP_PAGODET.semilla%TYPE,
    COD_PYTO_AUXILIAR IN PROYECTO.codpyto%type)
    IS
    FECHA_DE_CP DATE;
BEGIN
    INSERT INTO P_VTACOMP_PAGODET VALUES(COD_CIA,NRO_CP,SEC,INGEGR,CODPARTIDA,IMPNETOMN,IMPIGVMN,IMPTOTALMN,SEMILL);
    SELECT FECCP INTO FECHA_DE_CP FROM P_VTACOMP_PAGOCAB WHERE NROCP=NRO_CP
                                                           AND CODCIA=COD_CIA;
    P_UPDATE_FLUJOCAJA_DET_UNALINEA_Y_GLOBAL(COD_CIA,COD_PYTO_AUXILIAR,INGEGR,CODPARTIDA,IMPTOTALMN,FECHA_DE_CP,'R');
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_VTACOMP_PAGOCAB(
    CODCIA IN P_VTACOMP_PAGOCAB.codcia%TYPE,
    NROCP IN P_VTACOMP_PAGOCAB.nrocp%TYPE,
    CODPYTO IN P_VTACOMP_PAGOCAB.codpyto%TYPE,
    CODCLIENTE IN P_VTACOMP_PAGOCAB.codcliente%TYPE,
    --NROPAGO IN P_VTACOMP_PAGOCAB.nropago%TYPE,
    TCOMPPAGO IN P_VTACOMP_PAGOCAB.tcomppago%TYPE,
    ECOMPPAGO IN P_VTACOMP_PAGOCAB.ecomppago%TYPE,
    FECCP IN P_VTACOMP_PAGOCAB.feccp%TYPE,
    TMONEDA IN P_VTACOMP_PAGOCAB.tmoneda%TYPE,
    EMONEDA IN P_VTACOMP_PAGOCAB.emoneda%TYPE,
    TIPCAMBIO IN P_VTACOMP_PAGOCAB.tipcambio%TYPE,
    IMPMO IN P_VTACOMP_PAGOCAB.impmo%TYPE,
    IMPNETOMN IN P_VTACOMP_PAGOCAB.impnetomn%TYPE,
    IMPIGVMN IN P_VTACOMP_PAGOCAB.impigvmn%TYPE,
    IMPTOTALMN IN P_VTACOMP_PAGOCAB.imptotalmn%TYPE,
    FOTOCP IN P_VTACOMP_PAGOCAB.fotocp%TYPE,
    FOTOABONO IN P_VTACOMP_PAGOCAB.fotoabono%TYPE,
    FECABONO IN P_VTACOMP_PAGOCAB.fecabono%TYPE,
    DESABONO IN P_VTACOMP_PAGOCAB.desabono%TYPE,
    SEMILLA IN P_VTACOMP_PAGOCAB.semilla%TYPE,
    TABESTADO IN P_VTACOMP_PAGOCAB.tabestado%TYPE,
    CODESTADO IN P_VTACOMP_PAGOCAB.codestado%TYPE)
    IS
BEGIN
    INSERT INTO P_VTACOMP_PAGOCAB VALUES(CODCIA,NROCP,CODPYTO,CODCLIENTE,SEC_NRO_PAGO_VTA.nextval,TCOMPPAGO,ECOMPPAGO,FECCP,TMONEDA,EMONEDA,TIPCAMBIO,IMPMO,IMPNETOMN,IMPIGVMN,IMPTOTALMN,FOTOCP,FOTOABONO,FECABONO,DESABONO,SEMILLA,TABESTADO,CODESTADO);
END;
/

create or replace NONEDITIONABLE PROCEDURE P_INSERTAR_COMP_PAGODET(
    CODCIA IN P_comp_pagodet.codcia%TYPE,
    CODPROVEEDOR IN P_comp_pagodet.codproveedor%TYPE,
    NRO_CP IN P_comp_pagodet.nrocp%TYPE,
    SEC IN P_comp_pagodet.sec%TYPE,
    INGEGR IN P_comp_pagodet.ingegr%TYPE,
    CODPARTIDA IN P_comp_pagodet.codpartida%TYPE,
    IMPNETOMN IN P_comp_pagodet.impnetomn%TYPE,
    IMPIGVMN IN P_comp_pagodet.impigvmn%TYPE,
    IMPTOTALMN IN P_comp_pagodet.imptotalmn%TYPE,
    SEMILL IN P_comp_pagocab.semilla%TYPE,
    COD_PYTO_AUXILIAR IN PROYECTO.codpyto%type)
    IS
    FECHA_DE_CP DATE;
BEGIN
    INSERT INTO P_COMP_PAGODET VALUES(CODCIA,CODPROVEEDOR,NRO_CP,SEC,INGEGR,CODPARTIDA,IMPNETOMN,IMPIGVMN,IMPTOTALMN,SEMILL);
    SELECT FECCP INTO FECHA_DE_CP FROM P_COMP_PAGOCAB WHERE NROCP=NRO_CP;
    P_UPDATE_FLUJOCAJA_DET_UNALINEA_Y_GLOBAL(CODCIA,COD_PYTO_AUXILIAR,INGEGR,CODPARTIDA,IMPTOTALMN,FECHA_DE_CP,'R');
END;
/

create or replace procedure p_getv_partidas_mezcla(
    pm_cod_cia in P_PARTIDA_MEZCLA.CODCIA%type,
    pm_ie in P_PARTIDA_MEZCLA.INGEGR%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select P_PARTIDA_MEZCLA.corr,
               P_PARTIDA_MEZCLA.CODPARTIDA,
               P_PARTIDA.DESPARTIDA                             as DESPARTIDA,
               P_PARTIDA_MEZCLA.PADCODPARTIDA,
               (SELECT P_PARTIDA.DESPARTIDA
                FROM P_PARTIDA
                WHERE P_PARTIDA.CODPARTIDA = P_PARTIDA_MEZCLA.PADCODPARTIDA
                  AND P_PARTIDA.CODCIA = P_PARTIDA_MEZCLA.CODCIA
                  and P_PARTIDA.INGEGR = P_PARTIDA_MEZCLA.INGEGR) AS DESCPADCODPARTIDA,
               P_PARTIDA_MEZCLA.NIVEL,
               P_PARTIDA_MEZCLA.ORDEN,
               P_PARTIDA_MEZCLA.TUNIMED,
               TABS.DENTAB,
               P_PARTIDA_MEZCLA.EUNIMED,
               ELEMENTOS.DENELE,
               P_PARTIDA_MEZCLA.COSTOUNIT
        from P_PARTIDA_MEZCLA
                 join P_PARTIDA on P_PARTIDA_MEZCLA.CODCIA = P_PARTIDA.CODCIA
            and P_PARTIDA_MEZCLA.CODPARTIDA = P_PARTIDA.CODPARTIDA
            and P_PARTIDA_MEZCLA.INGEGR = P_PARTIDA.INGEGR
                 join TABS on TABS.CODTAB = P_PARTIDA_MEZCLA.TUNIMED
                 join ELEMENTOS on ELEMENTOS.CODELEM = P_PARTIDA_MEZCLA.EUNIMED and
                                   ELEMENTOS.CODTAB = P_PARTIDA_MEZCLA.TUNIMED
        where P_PARTIDA_MEZCLA.INGEGR = pm_ie
          and P_PARTIDA_MEZCLA.CODCIA = pm_cod_cia
        order by P_PARTIDA_MEZCLA.PADCODPARTIDA, P_PARTIDA_MEZCLA.NIVEL,
                 P_PARTIDA_MEZCLA.ORDEN;
end;
/

create or replace procedure p_getv_proy_partida(
    pp_cod_cia in P_PROY_PARTIDA.CODCIA%type,
    pp_ie in P_PROY_PARTIDA.INGEGR%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select P_PROY_PARTIDA.CODPYTO,
               PROYECTO.NOMBPYTO,
               P_PROY_PARTIDA.CODPARTIDA,
               P_PARTIDA.DESPARTIDA,
               P_PROY_PARTIDA.CODPARTIDAS,
               P_PROY_PARTIDA.VIGENTE
        from P_PROY_PARTIDA
                 join PROYECTO on P_PROY_PARTIDA.CODCIA = PROYECTO.CODCIA
            and P_PROY_PARTIDA.CODPYTO = PROYECTO.CODPYTO
                 join P_PARTIDA on P_PROY_PARTIDA.CODCIA = P_PARTIDA.CODCIA
            and P_PROY_PARTIDA.CODPARTIDA = P_PARTIDA.CODPARTIDA
            and P_PROY_PARTIDA.INGEGR = P_PARTIDA.INGEGR
        where P_PROY_PARTIDA.INGEGR = pp_ie
          and P_PROY_PARTIDA.CODCIA = pp_cod_cia;
end;
/

create or replace procedure p_getv_proy_partida_mezcla(
    ppm_cod_cia in P_PROY_PARTIDA_MEZCLA.CODCIA%type,
    ppm_ie in P_PROY_PARTIDA_MEZCLA.INGEGR%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select P_PROY_PARTIDA_MEZCLA.corr,
               P_PROY_PARTIDA_MEZCLA.CODPYTO,
               PROYECTO.NOMBPYTO,
               P_PROY_PARTIDA_MEZCLA.CODPARTIDA,
               P_PARTIDA.DESPARTIDA                                  as DESPARTIDA,
               P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA,
               (select P_PARTIDA.DESPARTIDA
                from P_PARTIDA
                where P_PARTIDA.CODPARTIDA = P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA
                  and P_PARTIDA.CODCIA = P_PROY_PARTIDA_MEZCLA.CODCIA
                  and P_PARTIDA.INGEGR = P_PROY_PARTIDA_MEZCLA.INGEGR) AS DESCPADCODPARTIDA,
               P_PROY_PARTIDA_MEZCLA.NIVEL,
               P_PROY_PARTIDA_MEZCLA.ORDEN,
               P_PROY_PARTIDA_MEZCLA.TUNIMED,
               TABS.DENTAB,
               P_PROY_PARTIDA_MEZCLA.EUNIMED,
               ELEMENTOS.DENELE,
               P_PROY_PARTIDA_MEZCLA.COSTOUNIT,
               P_PROY_PARTIDA_MEZCLA.CANT,
               P_PROY_PARTIDA_MEZCLA.COSTOTOT
        from P_PROY_PARTIDA_MEZCLA
                 join PROYECTO on P_PROY_PARTIDA_MEZCLA.CODCIA = PROYECTO.CODCIA
            and P_PROY_PARTIDA_MEZCLA.CODPYTO = PROYECTO.CODPYTO
                 join P_PARTIDA on P_PROY_PARTIDA_MEZCLA.CODCIA = P_PARTIDA.CODCIA
            and P_PROY_PARTIDA_MEZCLA.CODPARTIDA = P_PARTIDA.CODPARTIDA
            and P_PROY_PARTIDA_MEZCLA.INGEGR = P_PARTIDA.INGEGR
                 join TABS on TABS.CODTAB = P_PROY_PARTIDA_MEZCLA.TUNIMED
                 join ELEMENTOS on ELEMENTOS.CODELEM = P_PROY_PARTIDA_MEZCLA.EUNIMED and
                                   ELEMENTOS.CODTAB = P_PROY_PARTIDA_MEZCLA.TUNIMED
        where P_PROY_PARTIDA_MEZCLA.INGEGR = ppm_ie
          and P_PROY_PARTIDA_MEZCLA.CODCIA = ppm_cod_cia
        order by P_PROY_PARTIDA_MEZCLA.CODPYTO, P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA, P_PROY_PARTIDA_MEZCLA.NIVEL,
                 P_PROY_PARTIDA_MEZCLA.ORDEN;

end;
/

create or replace procedure p_getv_datos_partida(
    pv_cod_cia in P_PARTIDA.CODCIA%type,
    pv_cod_proy in P_PROY_PARTIDA.CODPYTO%type,
    pv_ie in P_PARTIDA.INGEGR%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select distinct P_PROY_PARTIDA_MEZCLA.CODPARTIDA,
                        P_PARTIDA.DESPARTIDA,
                        P_PROY_PARTIDA_MEZCLA.COSTOTOT,
                        (0.18 * P_PROY_PARTIDA_MEZCLA.COSTOTOT) as IGV,
                        P_PARTIDA.SEMILLA
        from P_PROY_PARTIDA_MEZCLA
                 join P_PARTIDA on P_PROY_PARTIDA_MEZCLA.CODCIA = P_PARTIDA.CODCIA
            and P_PROY_PARTIDA_MEZCLA.CODPARTIDA = P_PARTIDA.CODPARTIDA
            and P_PROY_PARTIDA_MEZCLA.INGEGR = P_PARTIDA.INGEGR
        where P_PROY_PARTIDA_MEZCLA.CODCIA = pv_cod_cia
          and P_PROY_PARTIDA_MEZCLA.CODPYTO = pv_cod_proy
          and P_PROY_PARTIDA_MEZCLA.INGEGR = pv_ie
          and P_PROY_PARTIDA_MEZCLA.CODPARTIDA not in (select PADCODPARTIDA
                                                       from P_PROY_PARTIDA_MEZCLA
                                                       where CODCIA = pv_cod_cia
                                                         and INGEGR = pv_ie
                                                         and CODPYTO = pv_cod_proy);
end;
/



create or replace procedure p_getv_datos_partidas_padre(
    pv_cod_cia in P_PARTIDA.CODCIA%type,
    pv_ingegr in P_PARTIDA.INGEGR%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select distinct PADCODPARTIDA,
                        (select DESPARTIDA
                         from P_PARTIDA
                         where CODPARTIDA = P_PARTIDA_MEZCLA.PADCODPARTIDA
                           AND CODCIA = P_PARTIDA_MEZCLA.CODCIA
                           AND INGEGR = P_PARTIDA_MEZCLA.INGEGR) as DESPARTIDA,
                        (select INGEGR
                         from P_PARTIDA
                         where CODPARTIDA = P_PARTIDA_MEZCLA.PADCODPARTIDA
                           AND CODCIA = P_PARTIDA_MEZCLA.CODCIA
                           AND INGEGR = P_PARTIDA_MEZCLA.INGEGR) as INGEGR
        from P_PARTIDA_MEZCLA
        where INGEGR = pv_ingegr
          and CODCIA = pv_cod_cia;
end;
/

create or replace procedure p_getv_datos_proyecto_partidas_padre(
    pv_cod_cia in P_PROY_PARTIDA.CODCIA%type,
    pv_ingegr in P_PROY_PARTIDA.INGEGR%type,
    pv_cod_proy in P_PROY_PARTIDA.CODPYTO%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select distinct PADCODPARTIDA,
                        (select DESPARTIDA
                         from P_PARTIDA
                         where CODPARTIDA = P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA) as DESPARTIDA,
                        (select INGEGR
                         from P_PARTIDA
                         where CODPARTIDA = P_PROY_PARTIDA_MEZCLA.PADCODPARTIDA) as INGEGR
        from P_PROY_PARTIDA_MEZCLA
        where INGEGR = pv_ingegr
          and CODCIA = pv_cod_cia
          and CODPYTO = pv_cod_proy;
end;
/

create or replace procedure p_retornarTotalFlujoCaja(
    anno_ in P_FLUJOCAJA_DET.anno%type,
    codpartida_ in P_FLUJOCAJA_DET.codpartida%type,
    codpyto_ in P_FLUJOCAJA_DET.codpyto%type,
    codcia_ in P_FLUJOCAJA_DET.codcia%type,
    ingegr_ in P_FLUJOCAJA_DET.ingegr%type,
    v_cursor out sys_refcursor
) as
begin
    open v_cursor for
        select imprealini, imprealene, imprealfeb, imprealmar, imprealabr, imprealmay, imprealjun, imprealjul, imprealago, imprealsep, imprealoct, imprealnov, imprealdic, imprealacum
        from P_FLUJOCAJA_DET
        where anno=anno_
          and codpartida=P_GETPADRE(codpartida_,ingegr_,codcia_)
          and codpyto=codpyto_
          and codcia=codcia_
          and ingegr=ingegr_;
end;