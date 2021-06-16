package JM;

import java.util.*;
import java.lang.*;

import static com.sun.javafx.util.Utils.split;

//Оставь надежду всяк сюда входящий.
public class StringCalc {
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        String intro = console.nextLine();

        //Делим строку на переменные
        String[] symbolsHub = new String[] {"+","-","*","/"};
        String introHub[] = intro.split("");

        //Проверка
        System.out.println(Arrays.toString(introHub) + "← Все введенные символы");

        Boolean plus = intro.contains("+"),
                minus = intro.contains("-"),
                multiply = intro.contains("*"),
                divide = intro.contains("/");

        //Собираем список символов
        List<String> SymbolsHub = new ArrayList<>();
        for (int i = 0; i < introHub.length; i++) {

            if (plus) {
                SymbolsHub.add("+");
            } else if (minus) {
                SymbolsHub.add("-");
            } else if (multiply) {
                SymbolsHub.add("*");
            } else if (divide) {
                SymbolsHub.add("/");
            } else {
                System.out.println("!");
            }
            SymbolsHub.toArray(new String[0]);
        }

        //Проверка
        System.out.println(SymbolsHub + "←Список мат. символов");

        String values[] = Split.split(intro, SymbolsHub.get(0));

        //Проверка
        System.out.println(Arrays.toString(values) + "← Список переменных после деления");

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
        System.out.println(Nums + "← Все стало арабским и цифрами");

        //Квинтесенция алгебраичности
        if (SymbolsHub.get(0).equals("+")) {
            BeAlgebraic o = BeAlgebraic.PLUS;
            System.out.println(o.action(Nums.get(0), Nums.get(1)));
        } else if (SymbolsHub.get(0).equals("-")){
            BeAlgebraic o = BeAlgebraic.MINUS;
            System.out.println(o.action(Nums.get(0), Nums.get(1)));
        } else if (SymbolsHub.get(0).equals("*")) {
            BeAlgebraic o = BeAlgebraic.PROD;
            System.out.println(o.action(Nums.get(0), Nums.get(1)));
        } else if (SymbolsHub.get(0).equals("/")) {
            BeAlgebraic o = BeAlgebraic.QUOT;
            System.out.println(o.action(Nums.get(0), Nums.get(1)));
        } else {System.out.println("Ой-ой, не могу осилить эту алгебраичность (");}

    }
}
