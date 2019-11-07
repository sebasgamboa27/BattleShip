/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BS.Paquetes;

/**
 *
 * @author sebasgamboa
 */
public class PaqueteChat extends Paquete {
    
    public String mensaje;
    
    public PaqueteChat(String mensaje) {
        super("chat");
        this.mensaje = mensaje;
    }
    
}
