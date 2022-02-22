package SocketProgramming.ChatApplicationClient;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 * Created by rahil on 8/12/21.
 */
public class ClientActivity implements Runnable
{
    Socket clientSideSocket;
    ClientActivity(Socket clientSideSocket)
    {
        this.clientSideSocket=clientSideSocket;
    }
    @Override
    public void run()
    {
        DataInputStream din=null;

        DataOutputStream dout=null;

        System.out.println("___"+clientSideSocket+"___");

        try
        {
            din = new DataInputStream(clientSideSocket.getInputStream());

            dout = new DataOutputStream(clientSideSocket.getOutputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str="", str2="";

        while(true)
        {
            try
            {
                str=br.readLine();

                if(dout!=null)
                {
                    dout.writeUTF(str);

                    dout.flush();
                }
                if(din!=null)
                {
                    str2 = din.readUTF();
                }

                System.out.println("another client says: "+str2);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
