package SocketProgramming.ChatApplicationServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * Created by rahil on 8/12/21.
 */
public class ChatApplicationClientActivity implements Runnable
{
    Socket targetSocket;
    Socket otherSocket;
    ChatApplicationClientActivity(Socket targetSocket,Socket otherSocket)
    {
        this.targetSocket=targetSocket;
        this.otherSocket=otherSocket;
    }
    @Override
    public void run()
    {
        DataInputStream dinTarget=null;

        DataOutputStream doutOther=null;

        try
        {
            dinTarget = new DataInputStream(targetSocket.getInputStream());
            doutOther = new DataOutputStream(otherSocket.getOutputStream());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        String str="",str2="";
        while(true)
        {
            try
            {
                if(dinTarget != null)
                {
                    str=dinTarget.readUTF();
                }
                if(doutOther!=null)
                {
                    doutOther.writeUTF(str);
                    doutOther.flush();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
