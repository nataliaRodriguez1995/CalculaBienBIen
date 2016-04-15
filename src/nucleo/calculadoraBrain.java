package nucleo;

import funciones.Division;
import funciones.Suma;
import funciones.ErrorCalc;
import funciones.Exponente;
import funciones.Multiplicacion;
import funciones.Porcentaje;
import funciones.Resta;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;


/**
 *
 * @author Andi
 */
public class calculadoraBrain {
    Stack valores;
    String lastNumber = "";
    
    public calculadoraBrain(){
        valores = new Stack();
    }
    public void introducirNumero(String numero){
        lastNumber += numero;
    }
    public void delete(){
        if(!lastNumber.equals("")){
            lastNumber="";
        }
        else{
            try{
                valores.pop();
            }
            catch(EmptyStackException e){
                //No hace nada, porque intenta quitar un valor cuando no hay ninguno
            }
        }
    }
    
    public void clear(){
        lastNumber="";
        valores.clear();
    }
    
    public void introducirOperacion(char op){
        if(!lastNumber.equals("")){
            try{
                valores.add(Double.valueOf(lastNumber));
            }
            catch(NumberFormatException e){
                valores.add(new ErrorCalc("Formato Erróneo"));
            }
            lastNumber = "";
        }
        
        switch (op){
            case '+': valores.add(new Suma()); break;
            case '-': valores.add(new Resta()); break;
            case '*': valores.add(new Multiplicacion());break;
            case '/': valores.add(new Division());break;
            case '^': valores.add(new Exponente());break;
            case '%': valores.add(new Porcentaje());break;

            //case '=': break; //Realiza el solve en el código del JFrame (pero quiero seguir considerándolo una operación para no repetir el código de formato
            default: 
        }
    }
    public void introducirParentesis(char par){
        if(!lastNumber.equals("")){
            try{
                valores.add(Double.valueOf(lastNumber));
            }
            catch(NumberFormatException e){
                valores.add(new ErrorCalc("Formato Erróneo"));
            }
            lastNumber = "";
        }
        if( par =='('){
            valores.add("(");
        }
        else{
            valores.add(")");
        }
    }
    public String getStack(){
        String stack = "";
        Iterator valIter=valores.iterator();
        while(valIter.hasNext()){
            stack +=valIter.next();
        }
        return stack;
    }

    @Override
    public String toString() {
        return getStack() +lastNumber;
    }
    
    public void solve(){
        deInfijoAPostfijo meh = new deInfijoAPostfijo(toString());
        String formulas = meh.dameCadena();
        EvaluarExpresion evaluador = new EvaluarExpresion(formulas);
        String solucion = evaluador.dameResultado();
        lastNumber="";
        valores.clear();
        System.out.println(solucion);
        introducirNumero(solucion);
    }
}
