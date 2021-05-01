
package Question1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client 
{
     public static void main(String[] args)
    {
        try
        {
            Socket cs=new Socket("localhost",786);
            DataOutputStream dout=new DataOutputStream(cs.getOutputStream()); 
            //write message
            dout.writeUTF("end");
           
            //close connection
             dout.flush();
             dout.close();
             cs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
