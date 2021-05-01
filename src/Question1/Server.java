package Question1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main(String[] args)
    {
        try 
        {
            ServerSocket ss = new ServerSocket(786);
            while (true) 
            {
                Socket s = ss.accept();
                //ss.setSoTimeout();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = (String) dis.readUTF();
                if (str.equals("end")) 
                {
                    System.out.println("Server Stopped");
                    break;
                } 
                else 
                {
                    System.out.println(str);
                }

            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
