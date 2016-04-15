/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author Natalia
 */
public class Resta extends Operacion {

    @Override
    public double doOperacion(double anterior, double posterior) {
        return anterior-posterior;
    }

    @Override
    public String toString() {
        return "-";
    }
}    

