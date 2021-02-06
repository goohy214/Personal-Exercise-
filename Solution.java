class Solution {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    public static String multiply(String num1, String num2) {
        if(num1.length() >= num2.length())
            return calculation(num1, num2);
        else 
            return calculation(num2, num1);
    }
    
    private static String calculation(String longer, String shorter) {
        char[] longerCharArr = longer.toCharArray();
        char[] shorterCharArr = shorter.toCharArray();
        
        int outer = shorterCharArr.length, inner = longerCharArr.length;
        StringBuilder res = new StringBuilder();
        
        for(int i = outer-1; i >= 0; i--) {
            int operand1 = shorterCharArr[i] - '0';
            int carrier = 0;
            StringBuilder mediateRes = new StringBuilder(); 
            
            for(int j = inner-1; j >= 0; j--) {
                int operand2 = longerCharArr[j] - '0';
                int remainder = (operand1 * operand2 + carrier) % 10;
                int divider = (operand1 * operand2 + carrier) / 10;
                mediateRes.append(remainder);
                carrier = divider;
            }
            
            if(carrier != 0)
               mediateRes.append(carrier);
            
            if(res.length() == 0) 
                res = mediateRes.reverse();
            else
                res = add(res.reverse(), mediateRes);
        }
        
        return res.toString();
    }
    
    private static StringBuilder add(StringBuilder str1, StringBuilder str2) {
        
        int remainder=0, divider = 0, carrier = 0, operand1 = 0, operand2 = 0;
        StringBuilder res = new StringBuilder();
        int i = 0;
        while(i < str1.length()) {
            if(i == 0)
                remainder = str1.charAt(0) - '0';
            else{
                operand1 = str1.charAt(i) - '0';
                
                if(i > str2.length())
                    operand2 = 0;
                else
                    operand2 = str2.charAt(i-1) - '0';
                
                remainder = (operand1 + operand2 + carrier) % 10;
                divider = (operand1 + operand2 + carrier) / 10;
                carrier = divider;
            }
            res.append(remainder);
           
            i++;
        }
        
        while(i <= str2.length()) {
            operand2 = str2.charAt(i-1) - '0';
            remainder = (carrier + operand2) % 10;
            divider = (carrier + operand2) / 10;
            carrier = divider;
            res.append(remainder);
        }
        
        if(carrier != 0)
            res.append(carrier);
        
        return res.reverse();
    }
}