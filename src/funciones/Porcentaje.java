/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author Andi
 */
public class Porcentaje extends Operacion {

    @Override
    public double doOperacion(double anterior, double posterior) {
        return (anterior*posterior)/100;
    }

    @Override
    public String toString() {
        return "%";
    }
    
    
    
}
