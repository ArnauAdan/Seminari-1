/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanager;

/**
 *
 * @author Arnau Adan
 */
//És la classe pare que forma part de la classe principal del programa
//L'hem hagut de fer abstracta per a poder posar l'útlim mètode a les 
// classes que hereden d'aquesta.
public abstract class Person {
        //Els dos atributs propis de la classe
        public int id;
	public String name;
	//El constructor que també ens servirà en les següents classes
	public Person( int id, String name ){
            this.id=id;
            this.name=name;
	}
	//Getters i Setters que formen part de la classe 
	public int getID(){
            return id;
	}
	public String getName(){
            return name;
	}
	public void setID( int id ){
            this.id=id;
	}
	public void setName( String name ){
            this.name=name;
	}
        
        //Mètode marcat com a abstracta ja que s'implementa en les classes que 
        // heredin d'aquesta
        @Override
	public abstract String toString();
}
