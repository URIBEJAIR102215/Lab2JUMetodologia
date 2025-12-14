// ARCHIVO: src/main/java/com/mycompany/p2lab2metodologiauribejair/P2Lab2MetodologiaUribeJair.java
package com.mycompany.p2lab2metodologiauribejair;

/**
 *
 * @author espe
 */
public class P2Lab2MetodologiaUribeJair {

    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();

        System.out.println("KATA STRING CALCULATOR TDD DEMO\n");

        System.out.println("ADD(\"\") = " + calc.add(""));
        System.out.println("ADD(\"1\") = " + calc.add("1"));
        System.out.println("ADD(\"1,2\") = " + calc.add("1,2"));
        System.out.println("ADD(\"1,2,3\") = " + calc.add("1,2,3"));
        System.out.println("ADD(\"1\\n2,3\") = " + calc.add("1\n2,3"));
        System.out.println("ADD(\"//;\\n1;2\") = " + calc.add("//;\n1;2"));
    }
}
