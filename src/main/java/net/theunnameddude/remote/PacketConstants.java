package net.theunnameddude.remote;

public class PacketConstants {

    public static final byte[] POWER_ON = toBytes(
            0xBE, 0xEF, 0x03, 0x06, 0x00, // header
            0xBA, 0xD2, // crc
            0x01, 0x00, // action
            0x00, 0x60, // type
            0x01, 0x00  // setting code
    );

    public static final byte[] POWER_OFF = toBytes(
            0xBE, 0xEF, 0x03, 0x06, 0x00, // header
            0x2A, 0xD3, // crc
            0x01, 0x00, // action
            0x00, 0x60, // type
            0x00, 0x00  // setting code
    );
    public static final byte[] GET_POWER_STATE = toBytes(
            0xBE, 0xEF, 0x03, 0x06, 0x00, // header
            0x19, 0xD3, // crc
            0x02, 0x00, // action
            0x00, 0x60, // type
            0x00, 0x00  // setting code
    );

    private static byte[] toBytes(int... ints) {
        byte[] result = new byte[ ints.length ];
        for ( int i = 0; i < result.length; i++ ) {
            result[ i ] = (byte) ints[ i ];
        }
        return result;
    }
}
