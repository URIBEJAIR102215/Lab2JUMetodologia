package com.mycompany.p2lab2metodologiauribejair;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\n";
        String cadena = numbers;

        // Soportar delimitador personalizado: //;\n1;2
        if (numbers.startsWith("//")) {
            int salto = numbers.indexOf("\n");
            String cabecera = numbers.substring(2, salto);
            delimiter = java.util.regex.Pattern.quote(cabecera) + "|\n";
            cadena = numbers.substring(salto + 1);
        }

        String[] partes = cadena.split(delimiter);
        java.util.List<Integer> negativos = new java.util.ArrayList<>();

        int suma = 0;
        for (String p : partes) {
            if (p.isBlank()) {
                continue;
            }
            int valor = Integer.parseInt(p.trim());
            if (valor < 0) {
                negativos.add(valor);
            } else {
                suma += valor;
            }
        }

        if (!negativos.isEmpty()) {
            throw new IllegalArgumentException(
                    "No se permiten numeros negativos: " + negativos
            );
        }

        return suma;
    }
}
