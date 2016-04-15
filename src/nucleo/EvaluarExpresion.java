package nucleo;


import funciones.Division;
import funciones.Exponente;
import funciones.Multiplicacion;
import funciones.Porcentaje;
import funciones.Resta;
import funciones.Suma;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Natalia
 */
public class EvaluarExpresion {
    private Double resultado;
    private boolean anteriorNumero=false;
    private String auxiliar="";
    private Stack pila;
    private Suma suma = new Suma();
    private Resta resta = new Resta();
    private Division division = new Division();
    private Multiplicacion multiplicacion = new Multiplicacion();
    private Exponente exponente = new Exponente();
    private Porcentaje porcentaje =new Porcentaje();
    
    public EvaluarExpresion(String cadena)
    {
       pila=new Stack();
       Elemento elemento=new Elemento();
        for(int i=0; i< cadena.length(); i++){
            char caracter = cadena.charAt(i);
            if(elemento.esNumero(caracter)||elemento.esPunto(caracter)){
                auxiliar+=caracter;
                anteriorNumero=true;
                //pila.push((double)caracter);
            }
            else if(caracter==' '){
                if (anteriorNumero==true){
                    double numero=Double.parseDouble(auxiliar);
                    pila.push(numero); 
                    anteriorNumero=false;
                    auxiliar="";
                }
                
            }
            else{
                //se podria cambiar para usar la clase abstracta operacion
                double valor1=(double) pila.pop();
                double valor2=(double) pila.pop();
                if(elemento.esSuma(caracter)){
                    pila.push(suma.doOperacion(valor2, valor1));
                }
                if(elemento.esResta(caracter)){
                    pila.push(resta.doOperacion(valor2, valor1));
                }
                if(elemento.esCociente(caracter)){
                    pila.push(division.doOperacion(valor2, valor1));
                }
                if(elemento.esProducto(caracter)){
                    pila.push(multiplicacion.doOperacion(valor2, valor1));
                }
                if(elemento.esExponente(caracter)){
                    pila.push(exponente.doOperacion(valor2, valor1));
                }
                if(elemento.esPorcentaje(caracter)){
                    pila.push(porcentaje.doOperacion(valor2, valor1));
                }
                
            }
            
        }
        this.resultado= (double) pila.pop();
    }
public String dameResultado(){
    return resultado.toString();
}
}
