package JM;

import java.util.*;
import java.lang.*;

//Оставь надежду всяк сюда входящий.
public class StringCalc {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        String intro = console.nextLine();

        //Разбираем строку.
        String[] symbols = intro.split("");
        List<String> trimSymbols = new ArrayList<>();
        for (int i = 0; i < symbols.length; i++) {
            String s = symbols[i].trim();
            if (s!=null && !s.equals("")) {
                trimSymbols.add(s);
            }
            trimSymbols.toArray(new String[0]);
        }
        System.out.println(trimSymbols + "← все символы строки");

        //Собираем список переменных без знаков.
        List<String> nums = new ArrayList<>();
        for (int i = 0; i < trimSymbols.size(); i++) {
            String z = trimSymbols.get(i);
            if (!z.equals("+") && !z.equals("-") && !z.equals("*") && !z.equals("/")) {
                nums.add(z);
            } else z = null;
            nums.toArray(new String[0]);
        }
        System.out.println(nums + "← только цифры строки, без знаков");

        //Переводим в арабские, если в списке есть римские. Все строки собираем в список чисел.
        List<Integer> cNums = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).contains("I") || nums.get(i).contains("V") || nums.get(i).contains("X")) {
                int u = Roman.valueOf(nums.get(0)).toInt();
                cNums.add(u);
            } else {
                int u = Integer.parseInt(nums.get(i));
                cNums.add(u);
            }
            cNums.toArray(new Integer[0]);
        }
        System.out.println(cNums + "← Все стало арабским и цифрами");

        //Квинтесенция алгебраичности
        if (trimSymbols.get(1).equals("+")) {
            BeAlgebraic o = BeAlgebraic.PLUS;
            System.out.println(o.action(cNums.get(0), cNums.get(1)));
        } else if (trimSymbols.get(1).equals("-")){
            BeAlgebraic o = BeAlgebraic.MINUS;
            System.out.println(o.action(cNums.get(0), cNums.get(1)));
        } else if (trimSymbols.get(1).equals("*")) {
            BeAlgebraic o = BeAlgebraic.PROD;
            System.out.println(o.action(cNums.get(0), cNums.get(1)));
        } else if (trimSymbols.get(1).equals("/")) {
            BeAlgebraic o = BeAlgebraic.PROD;
            System.out.println(o.action(cNums.get(0), cNums.get(1)));
        } else {System.out.println("Ой-ой");}

        if (trimSymbols.size()>3) {
            System.out.println("Я не умею в больше двух переменных");
        }
    }
}
