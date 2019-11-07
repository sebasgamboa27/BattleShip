/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BS.Paquetes;

import java.io.Serializable;

/**
 *
 * @author sebasgamboa
 */
public abstract class Paquete implements Serializable {
    
    public String tipo;
    
    public Paquete(String tipo) {
        this.tipo = tipo;
    }
    
}
