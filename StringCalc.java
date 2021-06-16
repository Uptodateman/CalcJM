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
        System.out.println(Arrays.toString(introHub));

        Boolean plus = intro.contains("+"),
                minus = intro.contains("-"),
                multiply = intro.contains("*"),
                divide = intro.contains("/");

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
            }
            SymbolsHub.toArray(new String[0]);
        }

        System.out.println(SymbolsHub + "←Список мат. символов");

        String values[] = Split.split(intro, SymbolsHub.get(0));

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
        } else {System.out.println("Ой-ой, не могу осилить эту алгебраичность");}

        /*if (trimSymbols.size()>3) {
            System.out.println("Я не умею в больше двух переменных");
        }*/
    }
}
