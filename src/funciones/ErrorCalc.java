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
public class ErrorCalc {
    private String descripcion;
    public ErrorCalc(String descripcion){
        this.descripcion=descripcion;
    }

    @Override
    public String toString() {
        return "Error(" +descripcion + ')';
    }
    
    
}
