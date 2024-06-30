package ar.edu.unju.fi.ejercicio11;

public class Main {
	 public static void main(String[] args) {
	        int i = 2;
	        int j = 40;

	        StringBuilder secuencia = new StringBuilder();

	        for (int num = 80; j >= 0; i += 2, j -= 1) {
	            secuencia.append(num).append(" ");

	            num += i * j;
	        }

	        System.out.println(secuencia.toString().trim());
	    }
}
