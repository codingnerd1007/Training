package PollingLvl1;

/**
 * Created by rahil on 29/10/21.
 */

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;
public class PollingLvl1 extends Thread{
    private String userInput;
    private String ipAddress;
    private int subnetMask;
    private int[] octet=new int[4];
    volatile InetAddress ipAddressToPing;
    volatile String IPToPing;
    static PollingLvl1 pollingObj;
    int totalHostScanned=0;

    PollingLvl1(){

    }

    PollingLvl1(String IPToPing){
        this.IPToPing=IPToPing;
    }

    private void getUserInput(){
        Scanner scannerObj = new Scanner(System.in);
        userInput = scannerObj.next();
    }
    private void splitInput(){
        String[] inputAfterSplitting=userInput.split("/");
        ipAddress=inputAfterSplitting[0];
        subnetMask=Integer.parseInt(inputAfterSplitting[1]);
    }
    private void splitIP(){
        String[] ipAfterSplit=ipAddress.split("\\.");
        for(int index=0;index<4;index++){
            octet[index]=Integer.parseInt(ipAfterSplit[index]);
        }
    }

    @Override
    public void run(){
        //System.out.println(ipAddressToPing);
        try{

                if(InetAddress.getByName(IPToPing).isReachable(5000))
                    System.out.println(IPToPing + "is reachable");

            else
                System.out.println(IPToPing + "is not reachable");
            totalHostScanned++;
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void ping()throws Exception{
        Runnable newRunnableObj=new PollingLvl1();

        int hostBits=32-subnetMask;
        int copyOfSubnetMask=subnetMask;
        //int totalHostScanned=0;
        if(subnetMask==24)
        {
            for(int index=1;index<255;index++)
            {
                int[] formedIPAddress={octet[0],octet[1],octet[2],index};
                String IPToPing= Arrays.toString(formedIPAddress).replaceAll(", ",".").replace('[',' ').replace(']',' ').trim();
                //System.out.println(IPToPing);
                InetAddress ipAddressToPing=InetAddress.getByName(IPToPing);
                //System.out.println(pollingObj.ipAddressToPing);
                new PollingLvl1(IPToPing).start();
            }
        }
        else if(subnetMask==23)
        {
            int parsing=1,count=0,index=1;
            int octetValue=octet[2];
            while(parsing<=2){
                if(parsing==2 && octet[2]%2==0)
                    octetValue++;
                else if(parsing==2 && octet[2]%2!=0)
                    octetValue--;
                if(parsing==2)
                    index=0;
                for(;index<256;index++){
                    if(parsing==2 && index==255)
                        break;
                    int[] formedIPAddress={octet[0],octet[1],octetValue,index};
                    String IPToPing= Arrays.toString(formedIPAddress).replaceAll(", ",".").replace('[',' ').replace(']',' ').trim();
                    InetAddress ipAddr=InetAddress.getByName(IPToPing);
                    if(ipAddr.isReachable(1000))
                        System.out.println(ipAddr + "is reachable");
                    else
                        System.out.println(ipAddr + "is not reachable");
                    totalHostScanned++;
                }
                parsing++;
            }
        }
        //System.out.println("total host scanner: "+totalHostScanned);
    }
    public static void main(String[] args)throws Exception{
        pollingObj=new PollingLvl1();
        pollingObj.getUserInput();
        pollingObj.splitInput();
        pollingObj.splitIP();
        pollingObj.ping();
        /*
        System.out.println("UserInput:"+pollingObj.userInput);
        System.out.println("ipAddress:"+pollingObj.ipAddress);
        System.out.println("subnetMask:"+pollingObj.subnetMask);
        System.out.println("IP after split");
        for(int index=0;index<4;index++)
            System.out.println("octet"+(index+1)+":"+pollingObj.octet[index]);
            */
    }
}
