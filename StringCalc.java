package JM;

import java.util.*;
import java.lang.*;

//Оставь надежду всяк сюда входящий.
public class StringCalc {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Здравствуй, дружок." +
                "\nКак у тебя с алгебраичностью сегодня?" +
                "\nПопробуй ввести две цифры в строке ниже. Можно римскими." +
                "\n(Только от 1 до 10, ок?)");

        String intro = console.nextLine();

        //Делим строку на переменные
        String introHub[] = intro.split("");

        //Проверка
        //System.out.println(Arrays.toString(introHub) + "← Все введенные символы");

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
            } else {
                System.out.println("Хозяин, все сломалось!");
            }
            symbols.toArray(new String[0]);
        }

        //Проверка
        //System.out.println(SymbolsHub); ← На самом деле не работает как надо. Не знаю как это починить.

        String values[] = Split.split(intro, symbols.get(0));

        //Проверка
        //System.out.println(Arrays.toString(values) + "← Список переменных после деления");

        //Переводим в арабские, если в списке есть римские. Все строки собираем в список чисел.
        List<Integer> Nums = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i].startsWith("I") || values[i].startsWith("V") || values[i].startsWith("X")) {
                int u = ToArabic.valueOf(values[i]).toInt();
                Nums.add(u);
            } else {
                int u = Integer.parseInt(values[i]);
                Nums.add(u);
            }
            Nums.toArray(new Integer[0]);
        }

        //Проверка
        //System.out.println(Nums + "← Все стало арабским и цифрами");

        //Квинтесенция алгебраичности
        if (plus) {
            BeAlgebraic o = BeAlgebraic.PLUS;
            System.out.println(o.action(Nums.get(0), Nums.get(1)) + " ←- Кажется, это число, которое ты загадал )");
        } else if (minus){
            BeAlgebraic o = BeAlgebraic.MINUS;
            System.out.println(o.action(Nums.get(0), Nums.get(1)) + " ←- Кажется, это число, которое ты загадал )");
        } else if (multiply) {
            BeAlgebraic o = BeAlgebraic.PROD;
            System.out.println(o.action(Nums.get(0), Nums.get(1)) + " ←- Кажется, это число, которое ты загадал )");
        } else if (divide) {
            BeAlgebraic o = BeAlgebraic.QUOT;
            System.out.println(o.action(Nums.get(0), Nums.get(1)) + " ←- Кажется, это число, которое ты загадал )");
        } else {System.out.println("Ой-ой, не могу осилить эту алгебраичность (");}

    }//main
}//StringCalc
