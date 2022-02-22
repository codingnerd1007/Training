package Polling;

/**
 * Created by rahil on 29/10/21.
 */
import java.util.*;
import java.net.*;
public class Polling{
    private String userInput;
    private String ipAddress;
    private int subnetMask;
    private int[] octet=new int[4];
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
    private void ping(){
        int hostBits=32-subnetMask;
        int copyOfSubnetMask=subnetMask;
        int octet1Offset,octet2Offset,octet3Offset,octet4Offset,octet1OffsetInDecimal=1,octet2OffsetInDecimal=1, octet3OffsetInDecimal=1,octet4OffsetInDecimal=1;
        if(subnetMask>=24&&subnetMask<32){
            octet1Offset=0;
            octet1OffsetInDecimal=0;
            octet2Offset=0;
            octet2OffsetInDecimal=0;
            octet3Offset=0;
            octet3OffsetInDecimal=0;
            octet4Offset=32-subnetMask;
            octet4OffsetInDecimal=octet4OffsetInDecimal<<octet4Offset;
        }
        else if(subnetMask>=16&&subnetMask<24){
            octet1Offset=0;
            octet1OffsetInDecimal=0;
            octet2Offset=0;
            octet2OffsetInDecimal=0;
            octet3Offset=32-subnetMask-8;
            octet3OffsetInDecimal=octet3OffsetInDecimal<<octet3Offset;
            octet4Offset=8;
            octet4OffsetInDecimal=octet4OffsetInDecimal<<octet4Offset;
        }
        else if(subnetMask>=8&&subnetMask<16){
            octet1Offset=0;
            octet1OffsetInDecimal=0;
            octet2Offset=32-subnetMask-16;
            octet2OffsetInDecimal=octet2OffsetInDecimal<<octet2Offset;
            octet3Offset=8;
            octet3OffsetInDecimal=octet3OffsetInDecimal<<octet3Offset;
            octet4Offset=8;
            octet4OffsetInDecimal=octet4OffsetInDecimal<<octet4Offset;
        }
        else if(subnetMask<8){
            octet1Offset=8-subnetMask;
            octet1OffsetInDecimal=octet1OffsetInDecimal<<octet1Offset;
            octet2Offset=8;
            octet2OffsetInDecimal=octet2OffsetInDecimal<<octet2Offset;
            octet3Offset=8;
            octet3OffsetInDecimal=octet3OffsetInDecimal<<octet3Offset;
            octet4Offset=8;
            octet4OffsetInDecimal=octet4OffsetInDecimal<<octet4Offset;
        }
        for(int octet1=octet[0];octet1<=octet1+octet1OffsetInDecimal;octet1++){
            for(int octet2=octet[1];octet2<=255;octet2++){
                for(int octet3=octet[2];octet3<=255;octet3++){
                    for(int octet4=octet[3];;){

                    }
                }
            }
        }
    }
    public static void main(String[] args){
        Polling pollingObj=new Polling();
        pollingObj.getUserInput();
        pollingObj.splitInput();
        pollingObj.splitIP();
        pollingObj.ping();
        System.out.println("UserInput:"+pollingObj.userInput);
        System.out.println("ipAddress:"+pollingObj.ipAddress);
        System.out.println("subnetMask:"+pollingObj.subnetMask);
        System.out.println("IP after split");
        for(int index=0;index<4;index++)
            System.out.println("octet"+(index+1)+":"+pollingObj.octet[index]);
    }
}
