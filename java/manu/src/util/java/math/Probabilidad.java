package util.java.math;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigInteger;
import java.util.ArrayList;

public class Probabilidad {

    public void probabilidadn(int i) {

        ArrayList<BigFraction> result = new ArrayList<BigFraction>();
        result.add(BigFraction.ONE);
        BigInteger numb = new BigInteger("1");
        BigInteger denb = new BigInteger("3");
        result.add(new BigFraction(numb,denb));
        BigInteger numa = new BigInteger("1");
        BigInteger dena = new BigInteger("3");
        result.add(new BigFraction(numa,dena));
        //for (int n=4;n<i;n++){
        int n=100;
            BigInteger num1 = new BigInteger("1");
            BigInteger den1 = new BigInteger(n+"");
            BigFraction temp1 = new BigFraction(num1,den1);
            BigInteger num2 = new BigInteger(n-1+"");
            BigInteger den2 = new BigInteger(n+"");
            BigFraction temp2 = new BigFraction(num2,den2);
            BigInteger num3 = new BigInteger(n-2+"");
            BigInteger den3 = new BigInteger(n-1+"");
            BigFraction temp3 = new BigFraction(num3,den3);
            BigInteger num4 = new BigInteger("1");
            BigInteger den4 = new BigInteger(n-1+"");
            BigFraction temp4 = new BigFraction(num4,den4);
            BigFraction temp5 = temp4.multiply(result.get(1));
            BigFraction temp6 = temp3.multiply(result.get(1));
//            BigFraction temp5 = temp4.multiply(result.get(n-3));
//            BigFraction temp6 = temp3.multiply(result.get(n-3));
            BigFraction temp7 = temp5.add(temp6);
            BigFraction temp8 = temp7.multiply(temp2);
            BigFraction temp9 = temp8.add(temp1);
            result.add(temp9);
            System.out.println( " - " +n + " - "+temp1 + " - "+temp2 + " - "
                    +temp3 + " - "+temp4 + " - "+temp5 + " - "+temp6 + " - "
                    +temp7 + " - "+temp8 + " - "+temp9 + " - ");
            String t22  =temp9.getNumerator().toString();
            String t23  =temp9.getDenominator().toString();
            int t22a=1,t23a=1;
            if (t23.length()>3){
                t22a = Integer.parseInt(t22.substring(0,3));
            }
            else {
                t22a = Integer.parseInt(t22);
            }
            if (t22.length()>3){
                t23a = Integer.parseInt(t23.substring(0,3));
            }
            else{
                t23a = Integer.parseInt(t23);
            }
            float t24 = new Float(t22a)/new Float(t23a);

            //System.out.println( " - " +n + " - "+temp9 + " - "+temp9.bigDecimalValue());
            System.out.println( " - " +n + " - "+temp9 + " - "+t24);
            //System.out.println( " - " +n + " - "+temp9 + " - "+t22+ " - "+t22a+ " - "+t2+ " - "+t24);
        //}
    }
}
