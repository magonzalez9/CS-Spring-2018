/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv_proto;

/**
 *
 * @author marco
 */
public class LV_Proto {
static DataPairList list = new DataPairList();
    public static void main(String[] args) {
        
        new GraphControls();
        
 
        
    }
//        int h = 10000;
//        int h2 = h;
//        int p = 10;
//        int p2 = p;
//        double a = 0.05, b=0.1, α =0.00001, β =0.00001; 
//        // Î² = beta Î± =
//           
//        int t=0;
//        while (h>0 && p >0  ) {
//            int hp =h*p;
//            int hp2 =h2*p2;
//            h += a*h - α*hp;
//            p += β*hp - b*p;
//            int dh = (int) (a*h2 - α*hp2);
//            int dp = (int) (β*hp2 - b*p2);
//            h2 += dh;
//            p2 += dp;
////            System.out.print("h = " + h);
////            System.out.print("  p = " + p);
////            System.out.print("  h2 = " + h2);
////            System.out.println("  p2 = " + p2);
//            list.add(new DataPair(h,p));
//            
//        }
//            System.out.println( list.get(0).h);
//
//   }

}
