import java.util.*;

public class TablaDispersa {
    //atributos
    private Tarea[] tabla = new Tarea [101];
    private int numElementos;
    private double factorCarga;

    //contructor
    public TablaDispersa(){
        this.numElementos=0;
        this.factorCarga=0;             //supuestamente hay que ponerle 0.0(?
        this.tabla = new Tarea[101];  // "Crea un arreglo con 101 posiciones, inicialmente todas en null" -GPT
    }

    //metodo para verificar que el factor de carga sea <= 0,8, lo vamos a llamar solo desde adentro del ingreso de tareas.
    //calcularFactorCarga(): double - Actualiza y devuelve el factor de carga
    private double factorDeCargaCalculo(){
        factorCarga=(double) this.numElementos/101;              //IMPORTANTE TESTEAR BIEN ACA
        return factorCarga;
    }

    //este solo lo llamamos desde calcularPosicion para pasar todas las claves a numeros.
    private double obtenerValorNumerico(String codigo) {
        long valor = 0;
        for (int i = 0; i < codigo.length(); i++) {
            char c = codigo.charAt(i);
            valor += c * Math.pow(31, i);  // 31 es una base común en hashing (puede cambiarse)
        }
        return (double) valor;
    }           //(lo hizo gpt)

    //metodo calcularPosicion(String codigo): int - Implementa el metodo de la multiplicación
    private int calcularPosicion(String codigo) {
        //codigo=clave
        double A = 0.6180339887; // Constante para el metodo de multiplicación
        double valor = obtenerValorNumerico(codigo);
        double producto = valor * A;
        double decimal = producto - Math.floor(producto);
        return (int)(decimal * 101);
    }

    //resolverColision(int posicion, int i): int - Implementa la exploración cuadrática
    private int resolverColision(int posicionInicial, int i) {
        //return (posicionInicial + i * i) % 101;
        return Math.floorMod(posicionInicial + i * i, 101);     //liea adulterada por gpt :)
    }


    //insertar(Tarea t): boolean - Devuelve true si se insertó correctamente
    public boolean insertar(Tarea t){
        if (factorDeCargaCalculo()>0.8) {
            System.out.println("El factor de carga es: " + factorDeCargaCalculo()+" por lo que ya no pueden ingresarse mas elementos.");
            return false;
        /*} else if (tabla[calcularPosicion(t.getcodigo())] == null) {
            tabla[calcularPosicion(t.getcodigo())]=t;
                                                                                    //CONTROLAR SINTAXIS
            return true;*/
        }else{
            System.out.println("la primera posicion está ocupada, aplica resolverColision");
            int i=0;
            while(tabla[(resolverColision(calcularPosicion(t.getcodigo()) ,i))]!=null){
               i++;
            }
            //System.out.println("posicion: "+resolverColision(calcularPosicion(t.getcodigo()) ,i);
            tabla[(resolverColision(calcularPosicion(t.getcodigo()) ,i))]=t;
        }
        numElementos++;

        return true;

    }


    //buscar(String codigo): Tarea - Devuelve la tarea o null si no existe
    public Tarea buscar (String codigo){
        int i=0;
        if (tabla[calcularPosicion(codigo)] == null) {
            System.out.println("el codigo brindado no corresponde a ningun elemento");
            return null;
        }else{
            System.out.println("existe elemento en la posicion correspondiente a la clave");

            while(tabla[(calcularPosicion(codigo))+(resolverColision(calcularPosicion(codigo) ,i))].getcodigo()!=codigo){
                i++;
            }
           return tabla[(calcularPosicion(codigo))+(resolverColision(calcularPosicion(codigo) ,i))];
        }
    }

    //eliminar(String codigo): boolean - Marca la tarea como baja (esAlta = false)
    public boolean eliminar (String codigo){                        //devuelve true si pudo eliminar
        int i=0;
        if (tabla[calcularPosicion(codigo)] == null) {
            System.out.println("el codigo brindado no corresponde a ningun elemento");
            return false;
        }else{
            System.out.println("existe elemento en la posicion correspondiente a la clave");

            while(tabla[(calcularPosicion(codigo))+(resolverColision(calcularPosicion(codigo) ,i))].getcodigo()!=codigo){
                i++;
            }
        }
        tabla[(calcularPosicion(codigo))+(resolverColision(calcularPosicion(codigo) ,i))].setesAlta(false);

        return true;
    }


    //mostrarTabla(): void - Muestra el estado actual de la tabla (solo para grupos)
    //bloque original
    /*public  void mostrarTabla(){
        int contador=0;     //este es para saber cuanto mostramos.
        for (int i = 0; i < tabla.length; i++) {
            if(tabla[i].getesAlta() &&tabla[i]!=null){
                tabla[i].toString();
            }
        }
        if(contador==0){
            System.out.println("La tabla esta vacia");
        }
    }*/
    public void mostrarTabla() {            //bloque editado por gpt
        int contador = 0;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] != null && tabla[i].getesAlta()) {
                System.out.println(tabla[i]);  // esto invoca automáticamente toString()
                System.out.println(i);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("La tabla está vacía");
        }
    }
}
