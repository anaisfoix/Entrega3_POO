
package proyectopoo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Funciones {
    
    private ArrayList <Profesor> Profesores = new ArrayList <Profesor>();
    private ArrayList <Curso> Cursos = new ArrayList <Curso>();
    private ArrayList <Estudiante> Estudiantes = new ArrayList <Estudiante>();
    private ArrayList <OfertaLaboral> OfertasLaborales = new ArrayList <OfertaLaboral>();
    
    
    public void LeerProfesores() throws IOException {
        CSV acceso = new CSV("Profesor");

        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Profesor nuevoProfesor = new Profesor();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevoProfesor.setIdProfesor(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 1: {
                        nuevoProfesor.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 2: {
                        nuevoProfesor.setApellido(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoProfesor.setRut(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 4: {
                        nuevoProfesor.setEdad(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 5: {
                        nuevoProfesor.setMail(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 6: {
                        String [] CursosX=acceso.get_csvField(linea, i).split(" ");
                        for(int j=0; j<CursosX.length; j++){
                            nuevoProfesor.setCursos(CursosX[j]);
                        }                        
                        break;
                    }
                }
            }
            Profesores.add(nuevoProfesor);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
        }
    }
    public void mostrarProfesores(){
        System.out.println("PROFESORES :");
        System.out.println("");
        for(int i=0; i<this.Profesores.size(); i++){
            System.out.print(this.Profesores.get(i).getIdProfesor()+" ");
            System.out.print(this.Profesores.get(i).getNombre()+" ");
            System.out.print(this.Profesores.get(i).getApellido()+" ");
            System.out.print(this.Profesores.get(i).getRut()+" ");
            System.out.print(this.Profesores.get(i).getEdad()+" ");
            System.out.print(this.Profesores.get(i).getMail()+" ");
            for(int j=0; j<Profesores.get(i).getSize(); j++){
                System.out.print(this.Profesores.get(i).getCursos(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarProfesores(int i){
        if (i > Profesores.size()){
            System.out.println("NO EXISTE ESTE CURSO");
        }
        else{    
            System.out.println("Profesor buscado por lista: ");
            System.out.print(this.Profesores.get(i).getIdProfesor()+" ");
            System.out.print(this.Profesores.get(i).getNombre()+" ");
            System.out.print(this.Profesores.get(i).getApellido()+" ");
            System.out.print(this.Profesores.get(i).getRut()+" ");
            System.out.print(this.Profesores.get(i).getEdad()+" ");
            System.out.print(this.Profesores.get(i).getMail()+" ");
            for(int j=0; j<Profesores.get(i).getSize(); j++){
                System.out.print(this.Profesores.get(i).getCursos(j)+" ");
            }
            System.out.println("");
        }
    }
    
    public void mostrarProfesores(String RUT){
        int a = 0 ;
        for(int i=0; i<this.Profesores.size(); i++){    
            if (this.Profesores.get(i).getRut().equals(RUT)){
                System.out.println("Profesor buscado por rut: ");
                System.out.print(this.Profesores.get(i).getIdProfesor()+" ");
                System.out.print(this.Profesores.get(i).getNombre()+" ");
                System.out.print(this.Profesores.get(i).getApellido()+" ");
                System.out.print(this.Profesores.get(i).getRut()+" ");
                System.out.print(this.Profesores.get(i).getEdad()+" ");
                System.out.print(this.Profesores.get(i).getMail()+" ");
                for(int j=0; j<Profesores.get(i).getSize(); j++){
                    System.out.print(this.Profesores.get(i).getCursos(j)+" ");
                }
                System.out.println("");
                a = 1 ;
                break ;
            }
            if (a == 0){
                System.out.println("NO EXISTE EL PROFESOR EN LA LISTA");
            }
            System.out.println("");
        }
    }

    public void CrearProfesor(){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese RUT");
        String DATOSTRING = Entrada.next();
        Profesor nuevoProfesor = new Profesor();
        for(int i=0; i<this.Profesores.size(); i++){    
            if (this.Profesores.get(i).getRut().equals(DATOSTRING)){
                System.out.println("PROFESOR YA EXISTE");
                return ;
            }
        }
        nuevoProfesor.setRut(DATOSTRING);
        System.out.println("Ingrese el ID del nuevo Profesor");
        nuevoProfesor.setIdProfesor(Entrada.nextInt());
        System.out.println("Ingrese el Nombre del nuevo Profesor");
        nuevoProfesor.setNombre(Entrada.next());
        System.out.println("Ingrese el Apellido del nuevo Profesor");
        nuevoProfesor.setApellido(Entrada.next());
        System.out.println("Ingrese la Edad del nuevo Profesor");
        nuevoProfesor.setEdad(Entrada.nextInt());
        System.out.println("Ingrese el mail del nuevo Profesor");
        nuevoProfesor.setMail(Entrada.next());
        System.out.println("Ingrese el nombre del curso que imparte el profesor");
        nuevoProfesor.setCursos(Entrada.next());
        Profesores.add(nuevoProfesor);
    }
    
    public void LeerEstudiantes() throws IOException {
        CSV acceso = new CSV("Estudiante");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Estudiante nuevoEstudiante = new Estudiante();
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0: {
                        nuevoEstudiante.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevoEstudiante.setApellido(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 2: {
                        nuevoEstudiante.setRut(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoEstudiante.setMail(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 4: {                        
                        String [] ClaveCursos=acceso.get_csvField(linea, i).split(" ");
                        for (int j = 0; j < ClaveCursos.length; j++) {
                            for (int k = 0; k < Cursos.size(); k++) {
                                if (Cursos.get(k).getClaveCurso().equals(ClaveCursos[j])) {                                                                        
                                    nuevoEstudiante.setArrayListCursosMatriculados(Cursos.get(k));
                                    nuevoEstudiante.setCursoMapa(Cursos.get(k));
                                }
                            }
                        }
                    }
                }
            }
            Estudiantes.add(nuevoEstudiante);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
        }
    }
    
    public void mostrarEstudiantes(){
        System.out.println("ESTUDIANTES :");
        System.out.println("");
        for(int i=0; i<this.Estudiantes.size(); i++){
            System.out.print(this.Estudiantes.get(i).getNombre()+" ");
            System.out.print(this.Estudiantes.get(i).getApellido()+" ");
            System.out.print(this.Estudiantes.get(i).getRut()+" ");
            System.out.print(this.Estudiantes.get(i).getMail()+" ");
            for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarEstudianteDeterminado(int i){
        if (i > Estudiantes.size()){
            System.out.println("NO EXISTE ESTE ESTUDIANTE");
        }
        else{
            System.out.println("Estudiante solicitado por numero de la lista: ");
            System.out.print(this.Estudiantes.get(i).getNombre()+" ");
            System.out.print(this.Estudiantes.get(i).getApellido()+" ");
            System.out.print(this.Estudiantes.get(i).getRut()+" ");
            System.out.print(this.Estudiantes.get(i).getMail()+" ");
            for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j)+" ");
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
    public void mostrarEstudianteDeterminado(String Rut){
        int a = 0 ;
        for(int i=0; i<this.Estudiantes.size(); i++){
            if (this.Estudiantes.get(i).getRut().equals(Rut)){
                System.out.println("Estudiante solicitado por RUT: ");
                System.out.print(this.Estudiantes.get(i).getNombre()+" ");
                System.out.print(this.Estudiantes.get(i).getApellido()+" ");
                System.out.print(this.Estudiantes.get(i).getRut()+" ");
                System.out.print(this.Estudiantes.get(i).getMail()+" ");
                for(int j=0; j<Estudiantes.get(i).getSizeCursosMatriculados(); j++){
                    System.out.print(this.Estudiantes.get(i).getCursosMatriculados().get(j)+" ");
                }
                System.out.println("");
                a = 1 ;
            }
        }
        if(a == 0){
            System.out.println("NO EXISTE ESTE ESTUDIANTE");
        }
        System.out.println("");
    } 
    
    public void CrearEstudiante(){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese RUT");
        String DATOSTRING = Entrada.next();
        Estudiante nuevoEstudiante = new Estudiante();
        for(int i=0; i<this.Estudiantes.size(); i++){    
            if (this.Estudiantes.get(i).getRut().equals(DATOSTRING)){
                System.out.println("ESTUDIANTE YA EXISTE");
                return ;
            }
        }
        nuevoEstudiante.setRut(DATOSTRING);
        System.out.println("Ingrese el Nombre del nuevo Estudiante");
        nuevoEstudiante.setNombre(Entrada.next());
        System.out.println("Ingrese el Apellido del nuevo Estudiante");
        nuevoEstudiante.setApellido(Entrada.next());
        System.out.println("Ingrese el mail del nuevo Estudiante");
        nuevoEstudiante.setMail(Entrada.next());
        System.out.println("Ingrese el numero de cursos que asiste el Estudiante");
        int DATOINT = Entrada.nextInt();
        Curso CursosX = new Curso();
        for (int i = 0 ; i < DATOINT ; i++){
            System.out.println("Ingrese la Clave del curso nr"+i+ " que asiste el estudiante");
            DATOSTRING =(Entrada.next());
            for (int j = 0 ; j < Cursos.size();j++){
                if(Cursos.get(j).getClaveCurso().equals(DATOSTRING)){
                    nuevoEstudiante.setArrayListCursosMatriculados(Cursos.get(j));
                    nuevoEstudiante.setCursoMapa(Cursos.get(j));
                    break;
                }
                else{
                    CursosX.setClaveCurso(DATOSTRING);
                    System.out.println("Ingrese el nombre del curso nr" +i+ " que asiste el estudiante");
                    CursosX.setNombre(Entrada.next());
                    System.out.println("Ingrese la Fecha de Inicio del curso nr"+i+ " que asiste el estudiante");
                    CursosX.setFechaInicio(Entrada.next());
                    System.out.println("Ingrese la Fecha de Termino del curso nr"+i+ " que asiste el estudiante");
                    CursosX.setFechaTermino(Entrada.next());
                    System.out.println("Ingrese la categoria que pertenece el curso nr"+i+" que asiste el estudiante");
                    CursosX.setCategoria(Entrada.next());
                    System.out.println("Ingrese el ID del profesor que impartira el curso nr"+i+" que asiste el estudiante");
                    CursosX.setIdProfesor(Entrada.nextInt());
                    Cursos.add(CursosX);
                    nuevoEstudiante.setArrayListCursosMatriculados(CursosX);
                    nuevoEstudiante.setCursoMapa(CursosX);
                }
            }
        }
        Estudiantes.add(nuevoEstudiante);
    }
    
    public void leerCursos() throws FileNotFoundException, IOException{
        CSV acceso = new CSV("Curso");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            Curso nuevoCurso = new Curso();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevoCurso.setNombre(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevoCurso.setClaveCurso(acceso.get_csvField(linea, i));
                        break;
                    }                    
                    case 2: {
                        nuevoCurso.setFechaInicio(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 3: {
                        nuevoCurso.setFechaTermino(acceso.get_csvField(linea, i));
                        break;   
                    }
                    case 4: {
                        nuevoCurso.setCategoria(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 5: {
                        nuevoCurso.setIdProfesor(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                }
        }
            Cursos.add(nuevoCurso);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
    }
}
    public void mostrarCursos(){
        System.out.println("Cursos :");
        System.out.println("");
        for(int i=0; i<this.Cursos.size(); i++){
            System.out.print(this.Cursos.get(i).getNombre()+" ");
            System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
            System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
            System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
            System.out.print(this.Cursos.get(i).getCategoria()+" ");
            System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarCursoDeterminado(int i){
        if (i > Cursos.size()){
            System.out.println("NO EXISTE ESTE CURSO");
        }
        else{
            System.out.println("Curso solicitado por lista: ");
            System.out.println("");
            System.out.print(this.Cursos.get(i).getNombre()+" ");
            System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
            System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
            System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
            System.out.print(this.Cursos.get(i).getCategoria()+" ");
            System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
            System.out.println(""); 
        }
    }
    
    public void mostrarCursoDeterminado(String claveCurso){
        
        int a = 0 ;
        for(int i=0; i<this.Cursos.size(); i++){
            if (this.Cursos.get(i).getClaveCurso().equals(claveCurso)){
                System.out.println("Curso solicitado por clave del curso: ");
                System.out.println("");
                System.out.print(this.Cursos.get(i).getNombre()+" ");
                System.out.print(this.Cursos.get(i).getClaveCurso()+" ");            
                System.out.print(this.Cursos.get(i).getFechaInicio()+" ");
                System.out.print(this.Cursos.get(i).getFechaTermino()+" ");
                System.out.print(this.Cursos.get(i).getCategoria()+" ");
                System.out.print(this.Cursos.get(i).getIdProfesor()+" ");
                System.out.println("");
                a = 1 ;
                break ;
            }
        }
        if (a == 0){
            System.out.println("NO EXISTE ESTE CURSO");
        }
        System.out.println("");
    }
    
    public void CrearCurso(){
        Scanner Entrada= new Scanner(System.in);
        System.out.println("Ingrese Clave del Curso");
        String DATOSTRING = Entrada.next();
        Curso nuevoCurso = new Curso();
        for(int i=0; i<this.Cursos.size(); i++){    
            if (this.Cursos.get(i).getClaveCurso().equals(DATOSTRING)){
                System.out.println("CURSO YA EXISTE");
                return ;
            }
        }
        nuevoCurso.setClaveCurso(DATOSTRING);
        System.out.println("Ingrese el Nombre del nuevo Curso");
        nuevoCurso.setNombre(Entrada.next());
        System.out.println("Ingrese la Fecha de Inicio del nuevo Curso");
        nuevoCurso.setFechaInicio(Entrada.next());
        System.out.println("Ingrese la Fecha de Termino del nuevo Curso");
        nuevoCurso.setFechaTermino(Entrada.next());
        System.out.println("Ingrese el nombre del la Categoria del nuevo Curso");
        nuevoCurso.setCategoria(Entrada.next());
        System.out.println("Ingrese el numero del ID del profesor que imparte el curso");
        nuevoCurso.setIdProfesor(Entrada.nextInt());
        Cursos.add(nuevoCurso);
    }
    
    public void leerOfertaLaboral() throws FileNotFoundException, IOException{
        CSV acceso = new CSV("OfertasLaborales");
        String linea = acceso.firstLine();
        linea = acceso.nextLine();
        while (linea != null) {
            OfertaLaboral nuevaOferta = new OfertaLaboral();
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0: {
                        nuevaOferta.setNombreOferta(acceso.get_csvField(linea, i));
                        break;
                    }
                    case 1: {
                        nuevaOferta.setCategoria(acceso.get_csvField(linea, i));
                        break;
                    }                    
                    case 2: {
                        nuevaOferta.setSueldo(Integer.parseInt(acceso.get_csvField(linea, i)));
                        break;
                    }
                    case 3: {
                        String [] OfertasX=acceso.get_csvField(linea, i).split(" ");
                        for(int j=0; j<OfertasX.length; j++){
                            nuevaOferta.setRequerimientos(OfertasX[j]);
                        }
                        break;   
                    }                    
                }
        }
            OfertasLaborales.add(nuevaOferta);
            linea = acceso.nextLine();
            if (linea == null) {
                break;
            }
    }
}
    public void mostrarOfertasLaborales(){
        System.out.println("Ofertas Laborales Disponibles:");
        System.out.println("");
        for(int i=0; i<this.OfertasLaborales.size(); i++){
            System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
            System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");            
            System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
            for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void mostrarOfertaLaboralDeterminada(int i){
        if (i > OfertasLaborales.size()){
            System.out.println("NO EXISTE ESTA OFERTA LABORAL");
            System.out.println("");
        }
        else{
            System.out.println("Ofertas Laboral buscada por lista: " + i);
            System.out.println("");
            System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
            System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");
            System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
            for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
            }
            System.out.println("");
        }
    }
    
    public void mostrarOfertaLaboralDeterminada(String nombreOferta){
        int a = 0 ;
        for(int i=0; i<this.OfertasLaborales.size(); i++){
            if(this.OfertasLaborales.get(i).getNombreOferta().equals(nombreOferta)){
                System.out.println("Oferta Laboral solicitada por nombre: ");
                System.out.println("");
                System.out.print(this.OfertasLaborales.get(i).getNombreOferta()+" ");
                System.out.print(this.OfertasLaborales.get(i).getCategoria()+" ");
                System.out.print(this.OfertasLaborales.get(i).getSueldo()+" ");
                for(int j=0; j<OfertasLaborales.get(i).getSizeRequerimientos(); j++){
                    System.out.print(this.OfertasLaborales.get(i).getRequerimientos(j)+" ");
                }
                System.out.println("");
                a = 1 ;
                break ;
            }
        }
        if (a == 0){
            System.out.println("NO EXISTE ESTA OFERTA LABORAL");
        }
        System.out.println("");
    }
    
    public void CrearOfertaLaboral(){
        Scanner Entrada= new Scanner(System.in);
        OfertaLaboral nuevaOfertaLaboral = new OfertaLaboral();
        System.out.println("Ingrese Nombre de la nueva Oferta Laboral");
        String DATOSTRING = Entrada.next();
        for(int i=0; i<this.Cursos.size(); i++){    
            if (this.OfertasLaborales.get(i).getNombreOferta().equals(DATOSTRING)){
                System.out.println("OFERTA LABORAL YA EXISTE");
                return ;
            }
        }
        nuevaOfertaLaboral.setNombreOferta(DATOSTRING);
        System.out.println("Ingrese la Categoria de la nueva Oferta Laboral");
        nuevaOfertaLaboral.setCategoria(Entrada.next());
        System.out.println("Ingrese el Requerimiento necesario para la nueva Oferta Laboral");
        nuevaOfertaLaboral.setRequerimientos(Entrada.next());
        System.out.println("Ingrese el Sueldo propuesto de la nueva Oferta Laboral");
        nuevaOfertaLaboral.setSueldo(Entrada.nextInt());
        OfertasLaborales.add(nuevaOfertaLaboral);
    }
    
}
