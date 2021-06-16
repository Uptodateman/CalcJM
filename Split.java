package JM;

import java.util.*;

public class Split {

    public static String[] split (String text, String delimiter){

        List<String> variables = new ArrayList<>();

        text += delimiter;
        for (int i = text.indexOf(delimiter), j = 0; i != -1; ) {
            String  variable = text.substring(j, i);

            if (variable.trim().length() != 0) {
                variables.add(variable.trim());
            }
            j = i + delimiter.length();
            i = text.indexOf(delimiter, j);
        }
        return variables.toArray(new String[0]);
    }

}
