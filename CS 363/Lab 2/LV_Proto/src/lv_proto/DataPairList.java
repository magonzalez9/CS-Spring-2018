/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv_proto;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
class DataPairList extends ArrayList<DataPair> {

    @Override
    public String toString() {
        String returnMe="DPLIST:";
        
        for (DataPair nextPair : this) {
            returnMe += "\n\t" + nextPair.toString();
        }
        
        return returnMe;
    }
}
