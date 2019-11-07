/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BS.Clients;

/**
 *
 * @author sebasgamboa
 *///
import java.net.*; 
import java.io.*; 
import BS.Paquetes.PaqueteChat;

public class Client 
{ 
	// initialize socket and input output streams 
	private Socket socket = null; 
	private DataInputStream input = null; 
	private ObjectOutputStream out = null; 
        //ClientFrame frame=new ClientFrame();
        

	// constructor to put ip address and port 
	public Client(String address, int port){ 

            
		// establish a connection 
		try{ 
                    socket = new Socket(address, port); 
                    //frame.setVisible(true);
                   
                    System.out.println("Connected"); 

                    // takes input from terminal 
                    input = new DataInputStream(System.in); 

                    // sends output to the socket 
                    out = new ObjectOutputStream(socket.getOutputStream()); 
		} 
		catch(UnknownHostException u) { 
			System.out.println(u); 
		} 
		catch(IOException i) { 
			System.out.println(i); 
		} 

		// string to read message from input 
		String line = ""; 

		// keep reading until "Over" is input 
		while (!line.equals("Over")){ 
			try{ 
                            line = input.readLine();
                            PaqueteChat paq = new PaqueteChat(line);
                            out.writeObject(paq);
                            
                            // out.writeUTF(line); 
			} 
			catch(IOException i) { 
                            System.out.println(i); 
			} 
		} 

		// close the connection 
		try{ 
                    input.close(); 
                    out.close(); 
                    socket.close(); 
		} 
		catch(IOException i){ 
                    System.out.println(i); 
		} 
	} 

	public static void main(String args[]) { 
		Client client = new Client("127.0.0.1", 5000); 
	} 
} 

