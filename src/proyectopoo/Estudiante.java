package proyectopoo;

import java.util.ArrayList;
import java.util.HashMap;

public class Estudiante {


    /*public Estudiante() {
        this.CursosMatriculados = new ArrayList<String>();
    }*/
    
    //Atributos
    private String Nombre;
    private String Apellido;
    private String Rut;
    private String Mail;
    private ArrayList<Curso> ArrayListCursosMatriculados;
    HashMap<String, Curso>CursosMatriculados;

    public Estudiante() {
        CursosMatriculados=new HashMap<String, Curso>();
        ArrayListCursosMatriculados= new ArrayList<Curso>();
    }
    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public Curso getCursoMatriculado(String Clave){
        return CursosMatriculados.get(Clave);
    }
    
    public ArrayList <Curso> getCursosMatriculados(){
        return ArrayListCursosMatriculados;
    }

    public void setArrayListCursosMatriculados(Curso Cursos1){
        ArrayListCursosMatriculados.add(Cursos1);
    }
    
    public void setCursoMapa(Curso Curso){
        CursosMatriculados.put(Curso.getClaveCurso(), Curso);
    }
    
    public int getSizeCursosMatriculados(){
        return ArrayListCursosMatriculados.size();
    }
    
    public Curso buscarCursoPorClave(String Clave){
        return CursosMatriculados.get(Clave);
    }
}