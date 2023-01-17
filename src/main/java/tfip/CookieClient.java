package tfip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CookieClient {
    public static void main(String[] args) throws UnknownHostException, IOException{
        String host = "localhost";
        int port = 3000;
        if (args.length>0){
            host = args[0].split(":")[0];
            port = Integer.parseInt(args[1].split(":")[1]);
        }
        //Connect to server
        Socket cConn = new Socket(host,port);
        System.out.printf("Connected to server %s on port:%d\n",host,port);
        //Output stream
        try {
            OutputStream os = cConn.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            Console cons = System.console();
            String readInput = "";
            String receivedMsg = "";
            try {
                InputStream is = cConn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(bis);
                while (!readInput.equalsIgnoreCase("close")){
                    readInput = cons.readLine("Enter a command: ");
                    dos.writeUTF(readInput);
                    dos.flush();
                    receivedMsg = dis.readUTF();
                    System.out.println(receivedMsg);
                }
                dis.close();
                bis.close();
                is.close();
            } catch (EOFException ex){
                cConn.close();
            }
            dos.close();
            bos.close();
            os.close();
        } catch (EOFException ex){
            cConn.close();
        }
    }
}
