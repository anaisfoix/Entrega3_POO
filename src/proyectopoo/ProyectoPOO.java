package proyectopoo;

import java.io.IOException;

/*
    Integrantes:
    
    Francisco Andres Muñoz Alarcon 20.242.456-2
    Anais Monserrat Foix Monardes  20.834.761-6
    Sofia Carolina Menzel Madrid   20.478.743-3
*/

public class ProyectoPOO {
    public static void main(String[] args)throws IOException { 
        Funciones prueba = new Funciones();
        Menu pruebaMenu = new Menu();
        int Opcion = 0 ;
        prueba.leerCursos();
        prueba.LeerProfesores();     
        prueba.LeerEstudiantes();     
        prueba.leerOfertaLaboral();
        while (Opcion != 9){
            Opcion = pruebaMenu.Menu(); 
            switch(Opcion)
            {    
                case 1 : prueba.CrearEstudiante();
                         break;
                case 2 : prueba.CrearProfesor();
                         break;
                case 3 : prueba.CrearCurso();
                         break;
                case 4 : prueba.CrearOfertaLaboral();
                         break;
                case 5 : prueba.mostrarEstudiantes();
                         break;
                case 6 : prueba.mostrarProfesores();
                         break;
                case 7 : prueba.mostrarCursos();
                         break;
                case 8 : prueba.mostrarOfertasLaborales(); 
                         break;
            }
        }
    }    
}
