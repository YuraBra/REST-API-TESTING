package scooter.util;

public class SubStringSearcher {

    public static String getSubString(String str,String firstSubStr,String secondSubStr){

        int first = str.indexOf(firstSubStr);
        int second = str.indexOf(secondSubStr);
        String subStr = str.substring(first + firstSubStr.length(), second);
        return subStr;
    }
}
