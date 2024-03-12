
package com.iplacex.restinsumo;

/**
 *
 * @author HP_435
 */
   public class Insumo {
   private String codigo;
   private String nombre;
   private int valor;

    public Insumo() {
    }
    public Insumo(String codigo, String nombre, int valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}

