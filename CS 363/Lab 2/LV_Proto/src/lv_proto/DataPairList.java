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
    private int pMax, pMin, hMax, hMin;

    public int getMax() {
        pMax = 0;
        hMax = 0; 
        for (DataPair nextPair : this) {
            if (nextPair.h > hMax) {
                hMax = nextPair.h;
            }

            if (nextPair.p > pMax) {
                pMax = nextPair.p;
            }
        }

        if (hMax > pMax) {
            return hMax;
        } else {
            return pMax;
        }
    }

    public int getMin() {
        hMin = hMax; 
        pMin = pMax; 
        for (DataPair nextPair : this) {
            if (nextPair.h < hMin) {
                hMin = nextPair.h;
            }

            if (nextPair.p < pMin) {
                pMin = nextPair.p;
            }
        }

        if (hMin < pMin) {
            return hMin;
        } else {
            return pMin;
        }
    }

    public int getpMax() {
        
        return pMax;
    }

    public int getpMin() {
        return pMin;
    }

    public int gethMax() {
        return hMax;
    }

    public int gethMin() {
        return hMin;
    }
    

    @Override
    public String toString() {
        String returnMe = "DPLIST:";

        for (DataPair nextPair : this) {
            returnMe += "\n\t" + nextPair.toString();
        }

        return returnMe;
    }
}
