import java.util.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        TablaDispersa tabla= new TablaDispersa();
        
        System.out.println("Lista de tareas:");
        Tarea tempTarea = null;
        Tarea tempTarea2 = null;

        for (int i = 0; i < 11; i++) {
            tempTarea = new Tarea("tarea "+i, 1, LocalDate.now(), LocalDate.now().plusDays(i));
            tabla.insertar(tempTarea);
            
        }
        
        tabla.mostrarTabla();

        System.out.println("buscaremos la ultima tarea ingresada:");
        tempTarea2=tabla.buscar(tempTarea.getcodigo());
        System.out.println(tempTarea2);

        System.out.println("eliminaremos la ultima tarea ingresada, la tabla queda de la siguiente manera:");
        tabla.eliminar(tempTarea.getcodigo());
        tabla.mostrarTabla();
    }
}



//preguntar por qué si hay menos de 11 elementos aparecen ordenados (claves aleatorias diferentes pero mismas posiciones en el arreglo
