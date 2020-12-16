package com.example.proyectofinal_grupo7;

public class FacturaM {
    private String codigoControl;
    private int id, nitProveedor,nroFactura,nroAutizacion,importeTotal;

    public FacturaM() {
    }

    public FacturaM(String codigoControl, int nitProveedor, int nroFactura, int nroAutizacion, int importeTotal) {
        this.codigoControl = codigoControl;
        this.nitProveedor = nitProveedor;
        this.nroFactura = nroFactura;
        this.nroAutizacion = nroAutizacion;
        this.importeTotal = importeTotal;
    }

    public FacturaM(String codigoControl, int id, int nitProveedor, int nroFactura, int nroAutizacion, int importeTotal) {
        this.codigoControl = codigoControl;
        this.id = id;
        this.nitProveedor = nitProveedor;
        this.nroFactura = nroFactura;
        this.nroAutizacion = nroAutizacion;
        this.importeTotal = importeTotal;
    }

    public String getCodigoControl() {
        return codigoControl;
    }

    public void setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNitProveedor() {
        return nitProveedor;
    }

    public void setNitProveedor(int nitProveedor) {
        this.nitProveedor = nitProveedor;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getNroAutizacion() {
        return nroAutizacion;
    }

    public void setNroAutizacion(int nroAutizacion) {
        this.nroAutizacion = nroAutizacion;
    }

    public int getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(int importeTotal) {
        this.importeTotal = importeTotal;
    }
}
