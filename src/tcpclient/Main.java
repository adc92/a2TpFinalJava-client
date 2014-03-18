package tcpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 4444);
        //Socket socket = new Socket("127.0.0.1", 4444);
        //to get the ip address
        System.out.println((java.net.InetAddress.getLocalHost()).toString());

        //true: it will flush the output buffer
        PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       // Thread.sleep(1000);

        System.out.println("Asking server for a new game");
        outSocket.println("new game");
        System.out.println("Waiting answer from server");
        if ("ready".equals(inSocket.readLine())) {
            System.out.println("Guess a number between 0 and 5");
            // scanner -> lire le numéro
            Scanner Sc = new Scanner(System.in);
            String numero = Sc.nextLine();
            // envoyer le numéro au serveur (out socket)
            outSocket.println(numero);
            String i = inSocket.readLine();
            int j = Integer.parseInt(i); 
            if(j==0){
                System.out.println("C'est gagné !");
            }
            else if(j==1){
                System.out.println("perdu, c'est + ! ");
            }
            else{
                System.out.println("perdu, c'est - ! ");
            }
            // attendre la réponse (plus ou moins), in socket readline
        }
        System.out.println("End.");
    }
}

