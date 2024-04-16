package org.eparedes.lambda;

import org.eparedes.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> t1 = num -> num > 10;
        boolean r = t1.test(11);
        System.out.println("t1 = " + r);

        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println("t2 = " + t2.test("ROLE_USER"));

        BiPredicate<String, String> t3 = String::equals;
        System.out.println("t3 = " + t3.test("Edwar", "Edwar"));

        BiPredicate<Integer, Integer> t4 = (i, j) -> j > i;
        boolean r2 = t4.test(5, 10);
        System.out.println("t4 = " + r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("cata");
        b.setNombre("maria");
        BiPredicate<Usuario, Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println("t5 = " + t5.test(a, b));
    }
}
