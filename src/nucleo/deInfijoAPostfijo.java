package nucleo;


import java.util.Stack;
import java.lang.Character;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia
 */
public class deInfijoAPostfijo {

    private String cadena;
    private Stack pila;
    private Elemento elemento;
    private String cadenaFinal;
    private boolean anteriorNumero = false;

    public deInfijoAPostfijo(String cadena) {
        this.cadena = cadena;
        pila = new Stack();
        String cadenaSalida = "";
        elemento = new Elemento();
        
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (elemento.esNumero(caracter)||elemento.esPunto(caracter)) {
                
                if (anteriorNumero == true) {
                    cadenaSalida += Character.toString(caracter);
                }
                else if(elemento.esPunto(caracter)){
                    cadenaSalida+='.';
                }
                else if (anteriorNumero == false && !elemento.esPunto(caracter)) {
                    cadenaSalida+=" " + Character.toString(caracter);
                    
                }
                anteriorNumero = true;
                
            } 
                //Si las prioridades son iguales.
            else if (caracter!='(' && caracter!=')' && !elemento.esNumero(caracter) && !elemento.esPunto(caracter)) {
                //Si las prioridades son iguales.
                    if(pila.empty()|| (Character)pila.peek()=='('){
                        pila.push(caracter);
                    }
                    else if (elemento.damePrioridad(caracter) == elemento.damePrioridad((Character) pila.peek())) {
                        cadenaSalida += " " + pila.pop();
                        pila.push(caracter);
                        if (i == (cadena.length())) {
                            while (!pila.empty()) {
                                cadenaSalida += " " + pila.pop();
                            }
                        }
                        //Si las prioridades son distintas pero... 1<2
                    } else if (elemento.damePrioridad(caracter) < elemento.damePrioridad((Character) pila.peek())) {

                        cadenaSalida += " " + pila.pop();
                        pila.push(caracter);
                        if (i == (cadena.length())) {
                            while (!pila.empty()) {
                                cadenaSalida += " " + pila.pop();
                            }
                        }
                        //Si las prioridades son 2>1
                    } else if (elemento.damePrioridad(caracter) > elemento.damePrioridad((Character) pila.peek())) {
                        pila.push(caracter);
                        if (i == (cadena.length())) {
                            while (!pila.empty()) {
                                cadenaSalida += " " + pila.pop();
                            }
                        }
                        }
                    anteriorNumero = false;
                } 
                else if (caracter=='(') {
                    pila.push(caracter);
                    anteriorNumero = false;
                } 
                else if (caracter==')') {
                    
                    while (!pila.peek().equals('(') && !pila.empty()) {
                        cadenaSalida += " " + pila.pop();
                    }
                pila.pop();   
                anteriorNumero = false;    
                }
                else if(caracter!='(') {
                    cadenaSalida += " " + Character.toString(caracter);
                    if (i == (cadena.length())) {
                        while (!pila.empty()) {
                            cadenaSalida += " " + pila.pop();
                        }
                    }
                    anteriorNumero = false;
                }
                
             
        }
        this.cadenaFinal = cadenaSalida;
    while (!pila.empty()){
        this.cadenaFinal=this.cadenaFinal+" "+(Character)pila.pop();
    }
    }

    public String dameCadena() {
        return this.cadenaFinal;
    }

}
