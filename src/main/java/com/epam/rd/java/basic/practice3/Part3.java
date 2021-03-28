package com.epam.rd.java.basic.practice3;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String input = Util.getInput("part3.txt");
        System.out.print("\tTest method convert:\n" + convert(input));
    }

    public static String convert(String input) {
        Pattern p = Pattern.compile("(?U)\\w{3,}");
        Matcher m = p.matcher(input);
        StringBuffer sb = new StringBuffer(input.length());
        while(m.find()) {
            String text = m.group();
            Character firstC = text.charAt(0);
            if(Character.isUpperCase(firstC)) {
                m.appendReplacement(sb, text.replaceFirst(".", (firstC.toString().toLowerCase(Locale.getDefault()))));
            } else {
                m.appendReplacement(sb, text.replaceFirst(".", (firstC.toString().toUpperCase(Locale.getDefault()))));
            }
        }
        return sb.toString();
    }
}