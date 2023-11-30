/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ethan Leiva 004D 07/09/2023
 */
import java.util.Date;

public class Mascota {
    private int codigo;
    private String nombre;
    private Date fecNac;
    private char sexo;
    private boolean vigente;
    private TipoMascota tipo;
    private Cliente dueño;

    // Constructor
    public Mascota(){
    }
    
    public Mascota(int codigo, String nombre, Date fecNac, char sexo, boolean vigente, TipoMascota tipo, Cliente dueño) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecNac = fecNac;
        this.sexo = sexo;
        this.vigente = vigente;
        this.tipo = tipo;
        this.dueño = dueño;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    public TipoMascota getTipo() {
        return tipo;
    }

    public void setTipo(TipoMascota tipo) {
        this.tipo = tipo;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    
}
