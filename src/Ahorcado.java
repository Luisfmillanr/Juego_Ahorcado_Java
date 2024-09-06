import java.util.Random;
import java.util.Scanner;

/**
 * Implementación del juego del ahorcado en Java. El usuario intenta adivinar una palabra secreta
 * ingresando letras una a una, con un total de 10 intentos para acertar la palabra completa.
 * Este juego es un ejercicio de práctica y aprendizaje de programación básica.
 */
public class Ahorcado {

    private static final Random random = new Random();  // Reutilización de la instancia de Random para mejorar la eficiencia

    /**
     * Punto de entrada principal del programa. Inicia el juego del ahorcado.
     * @param args argumentos de línea de comandos no utilizados en este programa.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Banco de palabras, se pueden agregar más para ofrecer más variedad y desafío
        String[] palabras = {
            "caramelo", "elefante", "computadora", "programar", "teclado",
            "biblioteca", "colegio", "universidad", "zapato", "botella",
            "murciélago", "guitarra", "ocelote", "pantalla", "ratón",
            "espacio", "planeta", "satélite", "sistema", "galaxia",
            "nebulosa", "constelación", "universo", "microscopio", "telescopio",
            "laboratorio", "experimento", "química", "física", "biología"
        };

        // Selección aleatoria de la palabra secreta y establecimiento del número máximo de intentos
        String palabraSecreta = palabras[random.nextInt(palabras.length)];
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglo para almacenar las letras adivinadas inicialmente con guiones bajos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Bucle principal del juego que continua mientras no se adivine la palabra y haya intentos disponibles
        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra por favor:");

            // Lectura y conversión a minúscula de la letra introducida por el usuario
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false;

            // Verificación de la letra en la palabra secreta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra && letrasAdivinadas[i] == '_') {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan: " + (intentosMaximos - intentos) + " intentos.");
            }

            // Verificar si la palabra ha sido completamente adivinada
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        // Mensaje final si se agotan los intentos sin adivinar la palabra
        if (!palabraAdivinada) {
            System.out.println("¡Lo siento, te has quedado sin intentos! La palabra era: " + palabraSecreta);
        }

        scanner.close();  // Cierre del scanner para liberar recursos
    }
}

