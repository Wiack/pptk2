import java.util.Scanner;
import java.util.InputMismatchException;

class kalkulacka {
    static char operation;
    static int num1, num2;

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    public static int KnumIs(String nadd) {
        if (isNumeric(nadd)) {
            return Integer.valueOf(nadd);
        } else {
            return romanToNumber(nadd);
        }
    }

    public static String ArabTR(int o) {
        int tens = ((o % 100) / 10) - 1;
        int units = (o % 10) - 1;


        String[] ten = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] uni = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        if (tens >= 0) {
            if(units>=0){return ten[tens] + uni[units];}
            else{return ten[tens];}


        } else {
            return uni[units];
        }

    }


    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("throws Exception");
        }
        return -1;
    }

    public static int calculated(int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':

                result = num1 / num2;

                break;


        }
        return result;
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        userInput = userInput.replaceAll("\\s", "");
        userInput = userInput.toUpperCase();

        for(int ii = 0; ii < userInput.length(); ii++){
            if(userInput.charAt(ii)=='.'){
                System.out.println("throws Exception //т. к. калькулятор работает только с целыми числами");
                System.exit(0);
            }
        }

        for (int i = 0; i < userInput.length(); i++) {
//          under_char[i] = userInput.charAt(i);
            if (userInput.charAt(i) == '+') {
                operation = '+';
            }
            if (userInput.charAt(i) == '-') {
                operation = '-';
            }
            if (userInput.charAt(i) == '*') {
                operation = '*';
            }
            if (userInput.charAt(i) == '/') {
                operation = '/';
            }

        }









        String[] blacks = userInput.split("[+-/*]");
        if (blacks.length > 2 ) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }
        if (blacks.length < 2) {
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }


        int count = 0;
        for(int i = 0; i < userInput.length(); i++){
            if(userInput.charAt(i)=='-'){
                count ++;
            }
        }
        if(count>1 && operation=='-'){
            System.out.println("throws Exception //т.к. числа меньше 1 не принимаются");
            System.exit(0);
        }
        if(count>0 && operation!='-'){
            System.out.println("throws Exception //т.к. числа меньше 1 не принимаются");
            System.exit(0);
        }
        if(userInput.charAt(0)=='-' && operation=='-'){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
            System.exit(0);
        }





        String stable00 = blacks[0];
        String stable01 = blacks[1];


        if (isNumeric(stable00) != isNumeric(stable01)) {
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
            System.exit(0);
        }

        int num1 = KnumIs(stable00);
        int num2 = KnumIs(stable01);

        if (num2==0 || num1>10 || num2==0 || num2>10){
            System.out.println("throws Exception // т.к. числа меньше 1 и больше 10 не принимаются");
            System.exit(0);

        }

        int r = calculated(num1, num2, operation);

        if (isNumeric(stable00) == false && isNumeric(stable01) == false  && r<0) {
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
            System.exit(0);

        }
        if(num1%num2!=0 && operation=='/'){
            System.out.println("throws Exception //т. к. калькулятор работает только с целыми числами ");
            System.exit(0);
        }


        if (isNumeric(stable00) == false) {
            System.out.println(ArabTR(r));
        } else {
            System.out.println(r);
        }

    }
}