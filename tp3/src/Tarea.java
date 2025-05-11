import java.util.*;
import java.time.LocalDate;


public class Tarea {
    //atributos
    private String id;
    private String nombre;
    private  int estado;
    private Boolean esAlta;
    private String codigo;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    //contructor
    public Tarea(String nombre, int estado, LocalDate fechaInicio, LocalDate fechaFin){

        //falta fecha inicio y fin

        this.nombre=nombre;
        this.estado=estado;
        this.esAlta=true;
        this.codigo = UUID.randomUUID().toString();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    //get y set
    // GET Son métodos que sirven para leer los valores de los atributos privados.
    public String getId(){
        return this.id;
    }
    public String getnombre(){
        return this.nombre;
    }
    public int getestado(){
        return this.estado;
    }
    public Boolean getesAlta(){
        return this.esAlta;
    }
    public  String getcodigo(){
        return this.codigo;
    }
    public String descripcion(){
        return this.descripcion;
    }
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public LocalDate getFechaFin() {
        return fechaFin;
    }

    //set permite modificar el valor de los atributos privados.
    public void setnombre(String nombre){
        nombre=nombre;
    }
    public void setestado(int estado){
        this.estado=estado;
    }
    //falta fecha y hora                                                       falta fecha y hora
    public void setesAlta(Boolean esAlta){
        this.esAlta=esAlta;
    }
    public   void setcodigo(String codigo){
        this.codigo=codigo;
    }
    public void setdescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    public void setFechaInicio() {
        this.fechaInicio=fechaInicio;
    }

    public  void setFechaFin() {
        this.fechaFin=fechaFin;
    }

    //texto como salió del docu de la consigna.
    @Override         //significa sobreescribir, modifica la manera en que se ve un texto
                      //"@Override: cambiar cómo funciona algo que ya existía, para que funcione como vos querés." -GPT
    public String toString() {
        //toString representa objetos como texto (pero feo)
        return "Tarea [" +
                "código=" + codigo +
                ", nombre='" + nombre + '\'' +                  //la barrita hace de escape para mostrar la comilla simple
                ", descripción='" + descripcion + '\'' +
                ", estado=" + estado +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", esAlta=" + esAlta +
                "]";
    }
}


