package ar.edu.unju.fi.ejercicio12.model;
import java.util.Calendar;

public class Persona {
	private String nombre;
    private Calendar fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, Calendar fechaNacimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int calcularEdad() {
        Calendar hoy = Calendar.getInstance();
        int edad = hoy.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

        if (hoy.get(Calendar.DAY_OF_YEAR) < fechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad;
    }

    public String obtenerSignoZodiaco() {
        int mes = fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        switch (mes) {
            case 0: return (dia < 20) ? "Capricornio" : "Acuario";
            case 1: return (dia < 19) ? "Acuario" : "Piscis";
            case 2: return (dia < 21) ? "Piscis" : "Aries";
            case 3: return (dia < 20) ? "Aries" : "Tauro";
            case 4: return (dia < 21) ? "Tauro" : "Géminis";
            case 5: return (dia < 21) ? "Géminis" : "Cáncer";
            case 6: return (dia < 23) ? "Cáncer" : "Leo";
            case 7: return (dia < 23) ? "Leo" : "Virgo";
            case 8: return (dia < 23) ? "Virgo" : "Libra";
            case 9: return (dia < 23) ? "Libra" : "Escorpio";
            case 10: return (dia < 22) ? "Escorpio" : "Sagitario";
            case 11: return (dia < 22) ? "Sagitario" : "Capricornio";
            default: return "";
        }
    }

    public String obtenerEstacion() {
        int mes = fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaNacimiento.get(Calendar.DAY_OF_MONTH);

        if ((mes == 11 && dia >= 21) || (mes <= 1) || (mes == 2 && dia < 21)) {
            return "Verano";
        } else if ((mes == 2 && dia >= 21) || (mes <= 4) || (mes == 5 && dia < 21)) {
            return "Otoño";
        } else if ((mes == 5 && dia >= 21) || (mes <= 7) || (mes == 8 && dia < 21)) {
            return "Invierno";
        } else {
            return "Primavera";
        }
    }

}
