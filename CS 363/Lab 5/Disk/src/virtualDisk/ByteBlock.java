/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualDisk;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class ByteBlock {

    private byte[] data_array;
    
    public ByteBlock() {
        
    }
    
    public byte[] getDataArray() {
        return data_array;
    }
    
    public void setDataArray(ArrayList<Byte> byteList) {
        for (int i = 0; i < byteList.size(); i++) {
            data_array[i] = byteList.get(i);
        }
    }
    
}
