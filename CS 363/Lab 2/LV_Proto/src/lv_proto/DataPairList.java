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

    public int getMax() {
        int hTemp = 0;
        int pTemp = 0;
        int hMax = 0;
        int pMax = 0;

        for (DataPair nextPair : this) {
            if (nextPair.h > hTemp) {
                hMax = nextPair.h;
            }

            if (nextPair.p > pTemp) {
                pMax = nextPair.p;
            }

            hTemp = nextPair.h;
            pTemp = nextPair.p;
        }

        if (hMax > pMax) {
            return hMax;
        } else {
            return pMax;
        }
    }

    public int getMin() {
        int hTemp = 0;
        int pTemp = 0;
        int hMin = 0;
        int pMin = 0;

        for (DataPair nextPair : this) {
            if (nextPair.h < hTemp) {
                hMin = nextPair.h;
            }

            if (nextPair.p < pTemp) {
                pMin = nextPair.p;
            }

            hTemp = nextPair.h;
            pTemp = nextPair.p;
        }

        if (hMin < pMin) {
            return hMin;
        } else {
            return pMin;
        }
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
