package my;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Converter{
    
    private static final Pattern PAT = Pattern.compile(
            "\\-?[0-9]+\\.?[0-9]*");
    private static Matcher mat;
                              
    public static boolean isNumber(String number){
        // returns true if the inserted string can be interpreted as number
        mat = PAT.matcher(number);
        return mat.matches();
    }
    
    private static long wholePart(String number){
        // returns whole part of the inputted string 
        // the part in front of the decimal point
        int dotIndex = number.indexOf(".");
        if (dotIndex == -1){
            return Long.parseLong(number);
        } else{
        return Long.parseLong(number.substring(0, dotIndex));
        }
    }
    
    private static double fractionPart(String number){
        // returns fractional part of the inputted string
        // the part behind the decimal point
        int dotIndex = number.indexOf(".");
        if (dotIndex == -1){
            return 0.0;
        } else {
        String helpString = "0." + number.substring(dotIndex + 1);
        return Double.parseDouble(helpString);
        }
    }
    
    public static String convertToBinary(String number) {
        // converts the base 2 representation of number given in string format
        
        // split the input into integer part and decimal part
        long intPtDecimal = wholePart(number);
        double fracPtDecimal = fractionPart(number);
        
        // convert the integer part
        String intPtBinaryString = "";
        boolean isNegative = (intPtDecimal < 0);
        if (isNegative) intPtDecimal = -intPtDecimal;
        while (intPtDecimal != 0 ){
            intPtBinaryString = Long.toString(intPtDecimal % 2) + 
            intPtBinaryString ;
            intPtDecimal = intPtDecimal / 2;
        }
        if (isNegative) intPtBinaryString = "-" + intPtBinaryString;
            
        // convert the fractional part
        String fracPtString = "";
        for (int j=0; j<20; j++){
            fracPtDecimal *= 2;
            fracPtString = fracPtString + 
                Long.toString(wholePart(Double.toString(fracPtDecimal)));   
            fracPtDecimal = fractionPart(Double.toString(fracPtDecimal));
        }
        return intPtBinaryString + "." + fracPtString;
                                   
    }
    
}

