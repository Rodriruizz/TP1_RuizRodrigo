package ar.edu.unju.fi.ejercicio10.model;

public class Pizza {
	private int diametro;
    private double precio;
    private double area;
    private boolean ingredientesEspeciales;

    private static final double ADICIONAL_INGREDIENTES_20 = 500.0;
    private static final double ADICIONAL_INGREDIENTES_30 = 750.0;
    private static final double ADICIONAL_INGREDIENTES_40 = 1000.0;

    public Pizza() {
    }

    public int getDiametro() {
        return diametro;
    }

    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isIngredientesEspeciales() {
        return ingredientesEspeciales;
    }

    public void setIngredientesEspeciales(boolean ingredientesEspeciales) {
        this.ingredientesEspeciales = ingredientesEspeciales;
    }

    public void calcularPrecio() {
        switch (diametro) {
            case 20:
                precio = 4500.0;
                if (ingredientesEspeciales) {
                    precio += ADICIONAL_INGREDIENTES_20;
                }
                break;
            case 30:
                precio = 4800.0;
                if (ingredientesEspeciales) {
                    precio += ADICIONAL_INGREDIENTES_30;
                }
                break;
            case 40:
                precio = 5500.0;
                if (ingredientesEspeciales) {
                    precio += ADICIONAL_INGREDIENTES_40;
                }
                break;
            default:
                throw new IllegalArgumentException("Diámetro no válido. Solo se permiten valores de 20, 30 o 40 cm.");
        }
    }

    public void calcularArea() {
        double radio = diametro / 2.0;
        area = Math.PI * radio * radio;
    }
}
