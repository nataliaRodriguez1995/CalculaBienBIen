package nucleo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Elemento {
    char elemento;
    public Elemento(char elemento){
        this.elemento=elemento;
    }
    public Elemento(){
        
    }
    public char getElemento(){
        return this.elemento;
    }
    public boolean esPunto(char elemento){
        return elemento=='.';
    }
    public boolean esNumero(char elemento)
        {
            return elemento>='0'&& elemento<='9';
        }
    public boolean esOperador(char elemento)
        {
           if(elemento=='+'||elemento=='-'||elemento=='*'||elemento=='/'||elemento=='^')
               return true;
           else
               return false;
        }
    public boolean esParentesis(char elemento){
        return elemento==')';
    }public boolean esDeApertura(char elemento){
        return elemento=='(';
    }
    public boolean esSuma(char elemento){
        return elemento=='+';
    }
    public boolean esResta(char elemento){
        return elemento=='-';
    }
    public boolean esCociente(char elemento){
        return elemento=='/';
    }
    public boolean esProducto(char elemento){
        return elemento=='*';
    }
    public boolean esExponente(char elemento){
        return elemento=='^';
    }
    
    //1 es la más baja prioridad
    
    public int damePrioridad(char elemento){
        
        if(elemento=='+'||elemento=='-'){
            return 1;
        }
        else if(elemento=='*'||elemento=='/'||elemento=='%'){
            return 2;
        }
        else if(elemento=='^'){
            return 3;
        }
        else{
            return 4;
        }
    }

    boolean esPorcentaje(char caracter) {
        return caracter=='%';
    }
    
}

