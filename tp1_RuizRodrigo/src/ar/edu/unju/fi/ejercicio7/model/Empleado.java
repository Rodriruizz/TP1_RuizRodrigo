package ar.edu.unju.fi.ejercicio7.model;

public class Empleado {
	private String nombre;
    private String legajo;
    private double salario;
    
    public static final double SALARIO_MINIMO = 210000.00;
    public static final double AUMENTO_POR_MERITOS = 20000.00;
    
    public Empleado(String nombre, String legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.println("Salario: " + salario);
    }

    public void darAumento() {
        this.salario += AUMENTO_POR_MERITOS;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getLegajo() {
        return legajo;
    }
    
    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }
}
