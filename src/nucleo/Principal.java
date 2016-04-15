package nucleo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Natalia
 */
public class Principal {
    private calculadoraBrain calculadora;
    private deInfijoAPostfijo hola;
    private EvaluarExpresion evalua;
    private String auxiliar;
    
    public Principal(){
        
        this.hola=new deInfijoAPostfijo(calculadora.getStack());
        //this.evalua=new EvaluarExpresion(hola.dameCadena());
        this.auxiliar=hola.dameCadena();
        
    }
    public void resolver(){
        
    }
    
}
