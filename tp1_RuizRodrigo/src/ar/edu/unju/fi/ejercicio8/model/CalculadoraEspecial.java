package ar.edu.unju.fi.ejercicio8.model;

public class CalculadoraEspecial {
	 private int n;

	    public CalculadoraEspecial() {
	    }

	    public int getN() {
	        return n;
	    }

	    public void setN(int n) {
	        this.n = n;
	    }

	    public long calcularSumatoria() {
	        long sumatoria = 0;
	        for (int k = 1; k <= n; k++) {
	            long term = (k * (k + 1)) / 2;
	            sumatoria += term * term;
	        }
	        return sumatoria;
	    }

	    public long calcularProductoria() {
	        long productoria = 1;
	        for (int k = 1; k <= n; k++) {
	            productoria *= k * (k + 4);
	        }
	        return productoria;
	    }
}
