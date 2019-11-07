/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BS.Server;

/**
 *
 * @author sebasgamboa
 */// 

import java.net.*; 
import java.io.*; 
import BS.Paquetes.Paquete;
import BS.Paquetes.PaqueteChat;

public class Server 
{ 
	//initialize socket and input stream 
	private Socket	socket = null;	
        //private Socket	socket2 = null; 
	private ServerSocket server = null; 
	private ObjectInputStream in= null; 
        public ServerFrame frame=new ServerFrame();

	// constructor with port 
	public Server(int port)
	{ 
		// starts server and waits for a connection 
		try{ 
                    server = new ServerSocket(port); 
                    frame.setVisible(true);
                    frame.getTextArea().append("Server started");
                    
                    System.out.println("Server started"); 

                    System.out.println("Waiting for a client ..."); 
                    frame.getTextArea().append("\nWaiting for a client ...");

                    socket = server.accept(); 
                    System.out.println("Client accepted");
                    frame.getTextArea().append("\nClient accepted");
                    

                    // takes input from the client socket 
//                    in = new DataInputStream( 
//                            new BufferedInputStream(socket.getInputStream())); 
                    in = new ObjectInputStream(socket.getInputStream());

                    String line = ""; 

                    // reads message from client until "Over" is sent 
                    while (!line.equals("Over")) 
                    { 
                            try
                            {
                                Paquete paq = (Paquete) in.readObject();
                                
                                switch (paq.tipo) {
                                    case "chat": {
                                        PaqueteChat chat = (PaqueteChat) paq;
                                        
                                        line = chat.mensaje;
                                        System.out.println(line);
                                        frame.getTextArea().append("\n"+line);
                                    } break;
                                    
                                    default: {
                                        System.out.println("No se reconoce ese tipo de paquete");
                                        frame.getTextArea().append("\nNo se reconoce ese tipo de paquete");
                                    }
                                }
                                
                                
                            }
                            catch(IOException | ClassNotFoundException e) 
                            { 
                                 System.out.println(e); 
                            }
                    } 
                    System.out.println("Closing connection"); 
                    frame.getTextArea().append("\nClosing connection");

                    // close connection 
                    socket.close(); 
                    in.close(); 
		} 
		catch(IOException i) { 
                    System.out.println(i); 
		} 
	} 

	/*public static void main(String args[]) { 
            Server server = new Server(5000); 
	} */
} 

