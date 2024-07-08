# Maestros

## Cliente
### DB

PERSONA
	CodCIA
	CodPersona: SEC_PERSONA
	TipPersona: 2
	DesPersona
	DesCorta
	DescAlterna
	DesCortaAlt
	Vigente
	
	PK (CodCIA, CodPersona)

CLIENTE
	CodCia
	CodCliente: SEC_PERSONA
	NroRuc
	Vigente
	
	PK (CodCia, CodCliente)  
### Input
Número de RUC: CLIENTE.NroRuc
Código de Campaña: PERSONA.CodCia
Descripción Persona: PERSONA.DesPersona
Descripción Alterna: PERSONA.DescAlterna
Descripción Corta: PERSONA.DesCorta
Descripción Corta Alterna: PERSONA.DescAlterna
Estado: Vigente/No Vigente: PERSONA.Vigente
### Operaciones
Registrar
Actualizar
Eliminar
### Mostrar
CodClient: CLIENTE.CodCliente
DescPersona: PERSONA.DesPersona
RUC: CLIENTE.NroRuc
Vigente: PERSONA.Vigente
## Empleado

PERSONA
	CodCIA
	CodPersona
	TipPersona: 1
	DesPersona
	DesCorta
	DescAlterna
	DesCortaAlt
	Vigente
	
	PK (CodCIA, CodPersona)

EMPLEADO
	CodCIA
	CodEmpleado
	Direcc
	Celular
	Hobby
	Foto
	FecNac
	DNI
	NroCIP
	FecCIPVig
	LicCond
	FlgEmplIEA: Empresa Consorcio/Cliente/Ambos
	Observac
	CodCargo
	Email
	Vigente
	
	PK (CodCIA, CodEmpleado)  
### Input
CodCia
Dirección
DNI
N° CIP
Celular
Email
Código del Cargo
Fecha de Nacimiento
Licencia de Conducir: Sí/No
Hobby
Fecha CIP Vigente
Imagen

Descripción Persona
Descripción Corta
Descripción Alterna
Descripción Corta Alterna
Observaciones
Tipo: Empresa Consorcio/Cliente/Ambos
Estado: Vigente/No Vigente
### Operaciones
Registrar
Actualizar
Eliminar
Buscar
	General
	Desc Persona
	DNI
	CIP
	Celular
### Mostrar
CodPer
Desc Persona
DNI
CIP
Fecha Nac
Lic Cond
Celular
Vigente
## Empresa Venta

PERSONA
	CodCIA
	CodPersona
	TipPersona
	DesPersona
	DesCorta
	DescAlterna
	DesCortaAlt
	Vigente
	
	PK (CodCIA, CodPersona)

EMPRESA_VTA
	CodCIA
	CiaContrata
	NroRuc
	FlgEmpConsorcio
	FecIni
	FecFin
	CodEmpresa
	Observac
	Vigente
	
	PK (CodCIA, CiaContrata)  
### Input
Número de RUC
Fecha Inicio
Fecha Fin
Descripción Persona
Descripción Alterna
Descripción Corta
Descripción Corta Alterna
Observaciones
Consorcio Empresarial: EMPRESA_VTA.FlgEmpConsorcio
### Operaciones
Registrar
Eliminar
Actualizar
### Mostrar
CiaContrata: PERSONA.CodPersona
Nombre: PERSONA.DesPersona
Ruc
Consorcio: EMPRESA_VTA.FlgEmpConsorcio
FecIni
FecFin
Vigente
## Proveedor

PERSONA
	CodCIA
	CodPersona
	TipPersona: 1
	DesPersona
	DesCorta
	DescAlterna
	DesCortaAlt
	Vigente
	
	PK (CodCIA, CodPersona)

PROVEEDOR
	CodCia
	CodProveedor
	NroRuc
	Vigente
	
	PK (CodCia, CodProveedor)  
### Input
Número de RUC
Descripción Persona
Descripción Alterna
Descripción Corta
Descripción Corta Alterna
Estado: Vigente/No Vigente
### Operaciones
Registrar
Eliminar
Actualizar
### Mostrar
CodProveedor
DescPersona
Ruc
Vigente

# Partidas
## Partidas [Ingreso/Egreso]

PARTIDA
	CodCia
	IngEgr
	CodPartida: SEC_COD_PARTIDA_(I/E)
	CodPartidas: SEC_COD_PARTIDAS
	DesPartida
	FlgCC: '1'
	Nivel: 1
	TUniMed
	EUniMed
	Semilla: 1
	Vigente
	
	PK (CodCia,IngEgr,CodPartida)  
### Input
Estado: PARTIDA.Vigente
Tabs Unidad Medida: PARTIDA.TUniMed
Elementos Unidad Medida: PARTIDA.EUniMed
Descripción Partida: PARTIDA.DesPartida
### Operaciones
Registrar
Actualizar
Eliminar
### Mostrar
CodPartida: PARTIDA.CodPartida
Codigo: PARTIDA.CodPartidas
Descripción: PARTIDA.DesPartida
TUniMed: PARTIDA.TUniMed
EUniMed: PARTIDA.EUniMed
Vigente: PARTIDA.Vigente
## Configuración Partidas [Ingreso/Egreso]

PARTIDA_MEZCL
	CodCia
	IngEgr
	CodPartida
	Corr: SEC_PARTIDA_MEZCLA_(I/E)
	PadCodPartida: (Codigo partida(I/E) del padre)
	TUniMed: (Obtenido de PARTIDA(CodPartida).TUniMed) //TODO: Procedimiento Almacenado
	EUniMed: (Obtenido de PARTIDA(CodPartida).EUniMed) //TODO: Procedimiento Almacenado
	CostoUnit
	Nivel
	Orden
	Vigente
	
	PK (CodCia,IngEgr,CodPartida,Corr)  
### Input
Partida: PARTIDA_MEZCL.CodPartida
PartidaPadre: PARTIDA_MEZCL.PadCodPartida
Estado: Vigente/No Vigente: PARTIDA_MEZCL.Vigente
Nivel: PARTIDA_MEZCL.Nivel
Orden: PARTIDA_MEZCL.Orden
Costo Unitario: PARTIDA_MEZCL.CostoUnit
### Operaciones
Registrar
Actualizar
Eliminar
### Mostrar
Corr: PARTIDA_MEZCL.Corr
Cod. Hoja: PARTIDA_MEZCL.CodPartida
Cod. Raiz: PARTIDA_MEZCL.PadCodPartida
Nivel: PARTIDA_MEZCL.Nivel
Orden: PARTIDA_MEZCL.Orden
TUniMed: PARTIDA_MEZCL.TUniMed
EUniMed: PARTIDA_MEZCL.EUniMed
Costo Unit: PARTIDA_MEZCL.CostoUnit
Vigente: PARTIDA_MEZCL.Vigente

# Proyectos

PROYECTO
	CodCIA
	CodPyto: SEC_PROYECTO
	NombPyto
	EmplJefeProy
	CodCia1: -999
	CiaContrata
	CodCC: -999
	CodCliente
	FlgEmpConsorcio: '-'
	CodSNIP: '-'
	FecReg
	CodFase: 0
	CodNivel: 0
	CodFuncion: '-'
	CodSituacion: 0
	NumInfor: 0
	NumInforEntrg: 0
	EstPyto
	FecEstado
	ValRefer
	CostoDirecto: -999
	CostoGGen: -999
	CostoFinan: -999
	ImpUtilidad: -999
	CostoTotSinIGV
	ImpIGV
	CostoTotal
	CostoPenalid: : -999
	CodDpto: '-'
	CodProv: '-'
	CodDist: '-'
	FecViab: '01-01-2022'
	RutaDoc: 'RUTA_DOC'
	AnnoIni
	AnnoFin
	CodObjC: 0
	LogoProy
	TabEstado: '-1'
	CodEstado: '1'
	Observac
	Vigente
	
	PK (CodCIA, CodPyto)  
## Consulta Proyectos
### Input
Nombre del Proyecto: PROYECTO.NombPyto
Empleado Jefe: PROYECTO.EmplJefeProy
Empresa Venta Contratada: PROYECTO.CiaContrata
Código Cliente: PROYECTO.CodCliente
Estado del Proyecto: PROYECTO.EstPyto (0/1/2/3)
Valor Referencial: PROYECTO.ValRefer
Año Inicio: PROYECTO.AnnoIni
Año Fin: PROYECTO.AnnoFin
Observaciones: PROYECTO.Observac
Costo Total sin IGV: PROYECTO.CostoTotSinIGV
Impuesto IGV: PROYECTO.ImpIGV
Costo Total: PROYECTO.CostoTotal
Imagen: PROYECTO.LogoProy
### Operaciones
Registrar
Actualizar
Eliminar
Buscar
### Mostrar
CodPyto: PROYECTO.CodPyto
NomPyto: PROYECTO.NombPyto
EmplJefe: PROYECTO.EmplJefeProy
CiaContrata: PROYECTO.CiaContrata
CodCliente: PROYECTO.CodCliente
FecReg: PROYECTO.FecReg
EstPyto: PROYECTO.EstPyto
FecEstado: PROYECTO.FecEstado
CostoTotal: PROYECTO.CostoTotal
Año Inicio: PROYECTO.AnnoIni
Año Fin: PROYECTO.AnnoFin
Vigente: PROYECTO.Vigente
## Partidas Proyectos [Ingreso/Egreso]

PROY_PARTID
	CodCia
	CodPyto
	NroVersion
	IngEgr
	CodPartida
	CodPartidas: PARTIDA(CodCia, CodPartida, IngEgr).CodPartidas
	FlgCC: '1'
	Nivel: 1
	UniMed: '1'
	TabEstado: -1
	CodEstado: 1
	Vigente: PARTIDA(CodCia, CodPartida, IngEgr).Vigente
	
	PK (CodCia,CodPyto,NroVersion,IngEgr,CodPartida)  
### Input
Proyecto: PROY_PARTID.CodPyto
Partida: PROY_PARTID.CodPartida
Número de Versión: PROY_PARTID.NroVersion
### Operaciones
Actualizar
Registrar
Eliminar
### Mostrar
Proyecto: PROY_PARTID.CodPyto
Version: PROY_PARTID.NroVersion
Código: PROY_PARTID.CodPartida
Estado: PROY_PARTID.CodEstado
Vigente: PROY_PARTID.Vigente
## Config. Part. Proy. [Ingreso/Egreso]

PROY_PARTIDA_MEZCL
	CodCia
	CodPyto
	IngEgr
	NroVersion
	CodPartida
	Corr: SEC_PROY_PARTIDA_MEZCLA_(I/E)
	PadCodPartida: 
	TUniMed: PARTIDA(CodCia, CodPartida; I/E).TUniMed
	EUniMed: PARTIDA(CodCia, CodPartida; I/E).EUniMed
	Nivel: PARTIDA(CodCia, CodPartida; I/E).Nivel
	Orden: PARTIDA(CodCia, CodPartida; I/E).Orden
	CostoUnit: PARTIDA(CodCia, CodPartida; I/E).CostoUnit
	Cant
	CostoTot: [Operacion compleja en INSERTAR_PROY_PARTIDA_MEZCLA]
	
	PK (CodCia,CodPyto,NroVersion,IngEgr,CodPartida,Corr)  
### Input
Proyecto: PROY_PARTIDA_MEZCL.CodPyto
Partida Padre: PROY_PARTIDA_MEZCL.PadCodPartida
Versión: PROY_PARTIDA_MEZCL.NroVersion
Cantidad: PROY_PARTIDA_MEZCL.Cant
### Operaciones
Actualizar
Registrar
Eliminar
### Mostrar
Proyecto: PROY_PARTIDA_MEZCL.CodPyto
Version: PROY_PARTIDA_MEZCL.NroVersion
Codigo: PROY_PARTIDA_MEZCL.Corr
Cod. Hoja: PROY_PARTIDA_MEZCL.CodPartida
Cod. Raiz: PROY_PARTIDA_MEZCL.PadCodPartida
Nivel: PROY_PARTIDA_MEZCL.Nivel
Orden: PROY_PARTIDA_MEZCL.Orden
TUniMed: PROY_PARTIDA_MEZCL.TUniMed
EUniMed: PROY_PARTIDA_MEZCL.EUniMed
Costo Unit: PROY_PARTIDA_MEZCL.CostoUnit
Cantidad: PROY_PARTIDA_MEZCL.Cant
Costo Total: PROY_PARTIDA_MEZCL.CostoTot
# Presupuesto
## Ingreso-Egreso [Ingreso/Egreso]

DPROY_PARTIDA_MEZCLA
	CodCia
	CodPyto
	IngEgr
	NroVersion: PROY_PARTIDA_MEZCLA(CodCia, I/E, CodPartida, CodPyto).NroVersion
	CodPartida
	Corr: PROY_PARTIDA_MEZCLA(CodCia, I/E, CodPartida, CodPyto).Corr
	Sec: SEC_DPROY_PARTIDA_MEZCLA_(I/E)
	TDesembolso: 3
	EDesembolso (Determina si es PAGO(2) o ADELANTO(1))
	NroPago: SEC_DPROY_PARTIDA_MEZCLA_(PAGO/ADELANTO)
	TCompPago: 4
	ECompPago
	FecDesembolso
	ImpDesembNeto
	ImpDesembIGV
	ImpDesembTot: ImpDesembNeto+ImpDesembIGV
	Semilla: [SEC_DPROY_PARTIDA_MEZCLA_SEMILLA_E si la partida no existía sino usa la misma semilla]
	
	PK (CodCia,CodPyto,IngEgr,NroVersion,CodPartida,Corr,Sec)  
### Input
Proyecto: DPROY_PARTIDA_MEZCLA.CodPyto
Partida: DPROY_PARTIDA_MEZCLA.CodPartida
Desembolso: Adelanto/Pago: DPROY_PARTIDA_MEZCLA.EDesembolso
Comprobante: DPROY_PARTIDA_MEZCLA.ECompPago
Fecha de Acción: DPROY_PARTIDA_MEZCLA.FecDesembolso
Importe Neto: DPROY_PARTIDA_MEZCLA.ImpDesembNeto
IGV: DPROY_PARTIDA_MEZCLA.ImpDesembIGV
### Operaciones
Actualizar
Registrar
Eliminar
### Mostrar

Proyecto: DPROY_PARTIDA_MEZCLA.CodPyto
Version: DPROY_PARTIDA_MEZCLA.NroVersion
Codigo: DPROY_PARTIDA_MEZCLA.CodPartida
Desembolso: DPROY_PARTIDA_MEZCLA.EDesembolso
NroPago: DPROY_PARTIDA_MEZCLA.NroPago
Comprobante: DPROY_PARTIDA_MEZCLA.ECompPago
Importe: DPROY_PARTIDA_MEZCLA.ImpDesembNeto
IGV: DPROY_PARTIDA_MEZCLA.ImpDesembIGV
Total: DPROY_PARTIDA_MEZCLA.ImpDesembTot
Semilla: DPROY_PARTIDA_MEZCLA.Semilla
# Ventas
## Ingreso
### Input
Datos del Cliente
	Código Cliente
	(M) Nombre Cliente
Datos Proyecto
	(M) Proyecto
Datos Partida
	Partida
	(M) Desc. Partida
	(M) ImpNeto
	(M) IGV
	(M) Semilla
Datos Generales
	CompPago: Factura/Recibo por Honorarios/Voucher
	Estado: Disponible/No Disp./Reservado
	Nro CP
	Nro Pago
	Desc. Abono
Fechas
	Fecha Compra
	Fecha Abono
NoName
	Monto
	Tipo Cambio
	Sub Total
	IGV
	Total
	Moneda: () Soles/Dolares
### Operaciones
AGREGAR
Generar
Borrar
Limpiar
### Mostrar
Sec
Cod. Partida
Nombre Part.
Semilla
SubTotal
IGV
Total

# Egreso
## Pagos
### Input
Datos Proveedor
	Cod Proveedor
	Nombre Proveedor
Datos Proyecto
	Proyecto
	Nombre Proyecto
Datos Partida
	Partida
	Desc. Partida
	ImpNeto
	IGV
	Semilla
Datos Generales
	CompPago: Factura/Recibo por Honorarios/Voucher
	Estado: Disponible/No Disp./Reservado
	Nro CP
	Nro Pago
	Desc. Abono
Fechas
	Fecha Compra
	Fecha Abono
NoName
	Monto
	Tipo Cambio
	Sub Total
	IGV
	Total
	Moneda: () Soles/Dolares
### Operaciones
Generar
Borrar
Limpiar
### Mostrar
Sec
Cod. Partida
Nombre Part.
Semilla
SubTotal
IGV
Total

# Flujo de Caja
## Flujo de Caja
### Input
Cod. Proyecto
Año
### Operaciones
General
Real
Supuesto
Buscar
### Mostrar
Title1
Title2
Title3
Title4

# Administrador
## Compañía

CIA
	CodCIA
	DesCia
	DesCorta
	Vigente
	
	PK (CodCIA)
### Input
Descripción Compañía: CIA.DesCia
Descripción Corta: CIA.DesCorta
Estado: CIA.Vigente
### Operaciones
Buscar
Registrar
Eliminar
Actualizar
### Mostrar
CodCia: CIA.CodCIA
Descripción: CIA.DesCia
DescripciónCorta: CIA.DesCorta
Vigente: CIA.Vigente
# Configuración
## General
### Tabs

TABS
	CodTab
	DenTab
	DenCorta
	Vigente
	
	PK (CodTab)  
#### Input
Descripción Tab: TABS.DenTab
Descripción Corta: TABS.DenCorta
Estado: Vigente/No Vigente: TABS.Vigente
#### Operaciones
Actualizar
Registrar
Eliminar
#### Mostrar
Codigo: TABS.CodTab
Desc.Tab: TABS.DenTab
Desc. Corta: TABS.DenCorta
Vigente: TABS.Vigente
### Elementos

ELEMENTOS
	CodTab
	CodElem
	DenEle
	DenCorta
	Vigente
	
	PK (CodTab, CodElem)  

#### Input
Cod Tab: ELEMENTOS.CodTab
den Tab: TABS(ELEMENTOS.CodTab).DenTab
codElem: ELEMENTOS.CodElem
Descripción Elemento: ELEMENTOS.DenEle
Descripción Corta: ELEMENTOS.DenCorta
Estado: Vigente/No Vigente: ELEMENTOS.Vigente
#### Operaciones
Actualizar
Registrar
Eliminar
#### Mostrar
Cod Tab: TABS.CodTab
Cod. Elemento: TABS.CodElem
Desc. Elemento: TABS.DenEle
Desc. Corta: TABS.DenCorta
Vigente: TABS.Vigente