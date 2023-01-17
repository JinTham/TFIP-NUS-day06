package tfip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CookieServer {
    public static void main(String[] args) throws IOException{
        //Setup directory
        String dirPath = ".";
        String fileName = "cookie.txt";
        if (args.length>1){
            fileName = args[0];
        }
        File directory = new File(dirPath);
        if (directory.exists()){
            System.out.println("Directory already created");
        } else {
            directory.mkdir();
            System.out.println(fileName+" is now created");
        }
        //Create cookie
        Cookie cookie = new Cookie(dirPath,fileName);
        cookie.readCookieFile();
        //cookie.showCookies();
        //Setup port
        int port = 3000;
        if (args.length>0){
            port = Integer.parseInt(args[0]);
        }
        System.out.printf("Starting server on port %d\n",port);
        ServerSocket server = new ServerSocket(port);
        while (true){
            //Wait for a connection
            System.out.println("Waiting for incoming connection");
            Socket sConn = server.accept();
            System.out.println("Got a connection");
            //Get the input stream from the client
            try {
                InputStream is = sConn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                DataInputStream dis = new DataInputStream(bis);
                String msgReceived = "";
                try {
                    OutputStream os = sConn.getOutputStream();
                    BufferedOutputStream bos = new BufferedOutputStream(os);
                    DataOutputStream dos = new DataOutputStream(bos);
                    while (!msgReceived.equals("close")){
                        msgReceived = dis.readUTF();
                        if (msgReceived.equalsIgnoreCase("get-cookie")){
                            String cookieValue = cookie.returnCookie();
                            System.out.println(cookieValue);
                            dos.writeUTF(cookieValue);
                            dos.flush();
                        }
                    }
                    dos.close();
                    bos.close();
                    os.close();
                } catch (EOFException ex){
                    ex.printStackTrace();
                }
                dis.close();
                bis.close();
                is.close();
            } catch (EOFException ex) {
                sConn.close();
                server.close();
            }
            sConn.close();
            server.close();
        }
    }
}
