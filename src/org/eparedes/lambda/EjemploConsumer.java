package org.eparedes.lambda;

import org.eparedes.lambda.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
//        Consumidor es el que recibe parametros y no devuelve nada
        Consumer<Date> consumidor = fecha -> { // Cuando es un solo argumento se puede omitir los ()
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String, Integer> consumidorBi =
                (String nombre, Integer edad) -> System.out.println(nombre + ", tiene " + edad + " años!");
        // Es opcional definir el tipo de dato, ya que está especificado en el genérico
        consumidorBi.accept("pepe", 20);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
        nombres.forEach(consumidor2);

        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario = creaUsuario.get();

//        Forma 1
//        BiConsumer<Usuario, String> asignarNombre = (persona, nombre) -> {
//            persona.setNombre(nombre);
//        };

//        Forma 2
        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Edwar");
        System.out.println("Nombre usuario: " + usuario.getNombre());

//        Proveedor es el que no recibe nada y devuelve algo
        Supplier<String> proveedor = () -> "Hola mundo supplier";

        System.out.println(proveedor.get());
    }
}
