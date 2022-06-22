/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Controladora;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author William
 */
public class Modelo {
    private Controladora control;
    
    //Array list donde guardaremos los alumnos a registrar
    
    ArrayList<Alumno> ListaAlumnos = new ArrayList<Alumno>();
    
    
    public Modelo(){
        
    }

    public void LlenarArrayList(String nombre, String matricula, String carrera, int edad){
        Alumno objAlumno = new Alumno(nombre, matricula, carrera, edad);
        ListaAlumnos.add(objAlumno);
    }
    
    public ArrayList<Alumno> getListaAlumnos() {
        return ListaAlumnos;
    }

    public void setObjetoControlador(Controladora control) {
        this.control = control;
    }

    public void RegistraInformacion(String nombre, String matricula, String carrera, String edad) throws Exception {
        
        int intEdad = Integer.parseInt(edad);
        EvaluarEdad(intEdad);
        //Vuelvo a lanzar la excepcion
        EvaluarMatricula(matricula);
        Alumno objAlumno = new Alumno(nombre, matricula, carrera, intEdad);
        ListaAlumnos.add(objAlumno);   
        //ListaAlumnos.remove(objAlumno);
        //ListaAlumnos.removeAll(ListaAlumnos)
    }

    public Alumno BuscaAlumno(String matricula) {
        Iterator<Alumno> itr = ListaAlumnos.iterator();
        
        System.out.println("Values");
        for(int i = 0; i < ListaAlumnos.size(); i++) {
            System.out.println(ListaAlumnos.get(i).getNombre());
        }
        System.out.println("End values");
        
        while(itr.hasNext()){
            //System.out.println("Impresion 1: "+ (Alumno)itr.next());
            //System.out.println("Impresion 2: "+ itr);
            Alumno obj=(Alumno)itr.next();
            System.out.println("datos de arraylist");
            System.out.println(obj);
            if(obj.getMatricula().equals(matricula)){
                System.out.println(obj.getMatricula());
                System.out.println(obj.getNombre());
                System.out.println(obj.getCarrera());
                System.out.println(obj.getEdad());
                return obj;
            }
            
        }
        return null;
    }
    
    //Seccion para capturar excepciones

    private void EvaluarMatricula(String matricula) throws Exception {
        Iterator<Alumno> itr = ListaAlumnos.iterator();
              
        while(itr.hasNext()){
            //System.out.println("Impresion 1: "+ (Alumno)itr.next());
            //System.out.println("Impresion 2: "+ itr);
            Alumno obj=(Alumno)itr.next();
            
            if(obj.getMatricula().equals(matricula)){
                throw new Exception("Alumno existente");
            }
            
        }
    }


    private void EvaluarEdad(int intEdad) throws Exception{
        if(intEdad < 1 || intEdad > 100){
            throw new ExceptionRango("Edad erronea");
        }else{
            
        }
        
    }

    public void ModificaInformacion(String matricula, String nombre, String carrera, String edad) throws Exception {
        int intEdad = Integer.parseInt(edad);
        EvaluarEdad(intEdad);
        //Vuelvo a lanzar la excepcion
        //EvaluarMatricula(matricula);
        //Alumno objAlumno = new Alumno(nombre, matricula , carrera, intEdad);
        //ListaAlumnos.add(objAlumno);  
        
        
        Iterator<Alumno> itr = ListaAlumnos.iterator();
        
        while(itr.hasNext()){
            Alumno obj=(Alumno)itr.next();
            if(obj.getMatricula().equals(matricula)){
                
                obj.setNombre(nombre);
                obj.setMatricula(matricula);
                obj.setCarrera(carrera);
                obj.setEdad(intEdad);
            }    
        }
    }

    public void EliminaInformacion(String matricula, String nombre, String carrera, String edad) {
        int intEdad = Integer.parseInt(edad);
        Alumno objAlumno = new Alumno(nombre, matricula, carrera, intEdad);
        //ListaAlumnos.remove(objAlumno);   
        //ListaAlumnos.remove(objAlumno);
        //ListaAlumnos.removeAll(ListaAlumnos)
        Iterator<Alumno> itr = ListaAlumnos.iterator();
        
        int contador = 0;
        while(itr.hasNext()){
            Alumno obj=(Alumno)itr.next();
            if(obj.getMatricula().equals(matricula)){
                ListaAlumnos.remove(contador);
                System.out.println("Eliminacion exitosa");
                break;
            }
            
            contador++;
        }
    }

    
   
    
    
    
}
