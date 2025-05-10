import java.util.*;

public class Tarea {
    //atributos
    private String id;
    private String nombre;
    private  int estado;
    //falta fecha iicio y fecha fin
    private Boolean esAlta;
    private String codigo;
    private String descripcion;

    //contructor
    public Tarea(String nombre, int estado, Boolean  esAlta, String codigo){

        //falta fecha inicio y fin

        this.nombre=nombre;
        this.estado=estado;
        this.esAlta=true;
        this.codigo = UUID.randomUUID().toString();

    }

    //get y set
    // GET Son métodos que sirven para leer los valores de los atributos privados.
    public String getId(){
        return this.id;
    }
    public String nombre(){
        return this.nombre;
    }
    public int getestado(){
        return this.estado;
    }
    //falta fecha y hora                                                        falta fecha y hora
    public Boolean getesAlta(){
        return this.esAlta;
    }
    public   String getcodigo(){
        return this.codigo;
    }
    public String descripcion(){
        return this.descripcion;
    }

    //set permite modificar el valor de los atributos privados.
    public String nombre(String nombre){
        return this.nombre=nombre;
    }
    public int getestado(int estado){
        return this.estado=estado;
    }
    //falta fecha y hora                                                       falta fecha y hora
    public Boolean getesAlta(Boolean esAlta){
        return this.esAlta=esAlta;
    }
    public   String getcodigo(String codigo){
        return this.codigo=codigo;
    }
    public String descripcion(String nombre){
        return this.descripcion=descripcion;
    }


    //texto como salió del docu de la consigna.
    @Override         //significa sobreescribir, modifica la manera en que se ve un texto
                      //"@Override: cambiar cómo funciona algo que ya existía, para que funcione como vos querés." -GPT
    public String toString() {
        //toString representa objetos como texto (pero feo)
        return "Tarea [" +
                "código=" + codigo +
                ", nombre='" + nombre + '\'' +                  //la barrita hace de escape para mostrar la comilla simple
                //", descripción='" + descripcion + '\'' +
                ", estado=" + estado +
                //", fechaInicio=" + fechaInicio +
                //", fechaFin=" + fechaFin +
                ", esAlta=" + esAlta +
                "]";
    }
}


