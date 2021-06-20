package JM;

import java.util.*;
import java.lang.*;

import static java.lang.Integer.parseInt;

//Оставь надежду всяк сюда входящий.
public class StringCalc {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println(AllMessages.start);

        String intro = console.nextLine();

        //Делим строку на переменные
        String introHub[] = intro.split("");

        Boolean plus = intro.contains("+"),
                minus = intro.contains("-"),
                multiply = intro.contains("*"),
                divide = intro.contains("/");

        //Собираем список символов
        String[] symbolsHub = new String[] {"+","-","*","/"};
        List<String> symbols = new ArrayList<>();
        for (int i = 0; i < introHub.length; i++) {
            if (plus) {
                symbols.add("+");
            } else if (minus) {
                symbols.add("-");
            } else if (multiply) {
                symbols.add("*");
            } else if (divide) {
                symbols.add("/");
            }
            symbols.toArray(new String[0]);
        }

        //Проверка
        //System.out.println(SymbolsHub);
        /* ↑↑↑  На самом деле не работает как надо, но не мешает )
                Когда понадобится считать больше 2-х переменных, можно будет и починить.
         */

        String values[] = Split.split(intro, symbols.get(0));

        try {
            //Переводим в арабские, если в списке есть римские. Все строки собираем в список чисел.
            List<Integer> Nums = new ArrayList<>();
            List<Integer> checkConditions = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                int u = 0, wasRoman = 0;
                if (values[i].startsWith("I") || values[i].startsWith("V") || values[i].startsWith("X")) {
                    u = ToArabic.valueOf(values[i]).toInt();
                    wasRoman = 1;
                } else if (parseInt(values[i]) > 0 && parseInt(values[i]) <= 10) {
                    u = parseInt(values[i]);
                }
                Nums.add(u);
                checkConditions.add(wasRoman);
                Nums.toArray(new Integer[0]);
                checkConditions.toArray(new Integer[0]);
            }

            //Проверяем в одной ли системе счисления введены цифры
            if (checkConditions.get(0) + checkConditions.get(1) == 1) {
                System.out.println(AllMessages.alarm);
                System.exit(0);
            }

            //Квинтесенция алгебраичности
            if (plus) {
                BeAlgebraic operation = BeAlgebraic.PLUS;
                System.out.println(operation.action(Nums.get(0), Nums.get(1)) + AllMessages.success);
            } else if (minus) {
                BeAlgebraic operation = BeAlgebraic.MINUS;
                System.out.println(operation.action(Nums.get(0), Nums.get(1)) + AllMessages.success);
            } else if (multiply) {
                BeAlgebraic operation = BeAlgebraic.PROD;
                System.out.println(operation.action(Nums.get(0), Nums.get(1)) + AllMessages.success);
            } else if (divide) {
                BeAlgebraic operation = BeAlgebraic.QUOT;
                System.out.println(operation.action(Nums.get(0), Nums.get(1)) + AllMessages.success);
            }

        } catch (Exception condition) {
            System.out.println(AllMessages.alarm);
            System.exit(0);
        }

    }//main

}//StringCalc
