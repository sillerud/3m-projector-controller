package net.theunnameddude.remote;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

import java.util.Arrays;

public class ProjectorRemote {

    public static void main(String[] args) {
        new ProjectorRemote().init( args );
    }

    public static void init(String... args) {
        String[] serialPortNames = SerialPortList.getPortNames();
        if ( args.length > 0 || true ) {
            // No gui, however just testing now
            if ( serialPortNames.length == 1 ) {
                SerialPort serialPort = new SerialPort( serialPortNames[ 0 ] );
                try {
                    serialPort.openPort();
                    serialPort.setParams( SerialPort.BAUDRATE_19200, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE );
                    serialPort.writeBytes( PacketConstants.POWER_ON );
                    serialPort.closePort();
                } catch ( SerialPortException e ) {
                    e.printStackTrace();
                }
            } else {
                if ( serialPortNames.length > 0 ) {
                    System.out.println( "Multiple serial devices found, I was not prepared for that." );
                    System.out.println( Arrays.asList( serialPortNames ) );
                } else {
                    System.out.println( "Found no serial devices." );
                }
                return;
            }
        }
    }
}
