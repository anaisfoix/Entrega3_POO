package proyectopoo;

import java.util.ArrayList;

public class Profesor {

    //Atributos
    private int IdProfesor;    
    private String Nombre;
    private String Apellido;
    private String Rut;
    private int Edad;
    private String Mail;
    private ArrayList<String> Cursos;    
        
    static void add(Profesor ProfesorX) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    public Profesor() {
        this.Cursos = new ArrayList<String>();
    }
    
    //Accesores
    public String getRut(){
        return Rut;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String getApellido(){
        return Apellido;
    } 
    
    public int getEdad(){
        return Edad;
    }
    
    public String getMail(){
        return Mail;        
    }
    
    public String getCursos(int i){
        return Cursos.get(i);
    }
    
    public int getIdProfesor(){
        return IdProfesor;
    }
    
    //Mutadores
    public void setRut(String Rut1){
        Rut=Rut1;
    }
    
    public void setNombre(String Nombre1){
        Nombre=Nombre1;
    }
    
    public void setApellido(String Apellido1){
        Apellido=Apellido1;
    }
    
    public void setEdad(int Edad1){
        Edad=Edad1;
    }
    
    public void setMail(String Mail1){
        Mail=Mail1;
    }
    
    public void setCursos(String Cursos1){
        Cursos.add(Cursos1);
    }
    
    public void setIdProfesor(int IdProfesor1){
        IdProfesor=IdProfesor1;
    }
    
    public int getSize(){
        return Cursos.size();
    }
}
