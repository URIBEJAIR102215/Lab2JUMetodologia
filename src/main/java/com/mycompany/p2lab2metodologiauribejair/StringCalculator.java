package com.mycompany.p2lab2metodologiauribejair;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
public class StringCalculator {
    
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        String delimiters = ",|\n";
        String input = numbers;
        if (numbers.startsWith("//")) {
            int salto = numbers.indexOf("\n");
            String cabecera = numbers.substring(2, salto);
            delimiters = Pattern.quote(cabecera) + "|\n";
            input = numbers.substring(salto + 1);
        }
        String[] partes = input.split(delimiters);
        List<Integer> negativos = new ArrayList<>();
        int suma = 0;
        for (String parte : partes) {
            if (parte.isBlank()) {
                continue;
            }
            int valor = Integer.parseInt(parte.trim());
            if (valor < 0) {
                negativos.add(valor);
            } else {
                suma += valor;
            }
        }
        if (!negativos.isEmpty()) {
            throw new IllegalArgumentException(
                "NO SE PERMITEN NUMEROS NEGATIVOS: " + negativos
            );
        }
        return suma;
    }
}
