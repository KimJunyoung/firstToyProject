package toyproject.buyandlogin.validation;

public class RegexUtils {
    public static boolean hasSpecialChar(String str){
        return str.matches ("[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힝]*");
    }

    public static boolean onlyNumericWithAlphabet(String str){
        return str.matches("^[a-zA-Z0-9]*");
    }

    public static boolean isNumeric(String str){
        return str.matches("^[0-9]*$");
    }

    public static boolean isEmpty(String str){
        return str.isEmpty();
    }

    public static boolean isAlphabet(String str){
        return str.matches("^[a-zA-Z]*$");
    }

    public static boolean isKorean(String str){
        return str.matches("[가-힣]*$");
    }

    public static boolean isUpper(String str){
        return str.matches("^[A-Z]*$");
    }

    public static boolean isDowner(String str){
        return str.matches("^[a-z]*$");
    }

    public static boolean isUrl(String str){
        return str.matches("(http[s]?:\\/\\/)([a-zA-Z0-9]+)\\.[a-z]+([a-zA-Z0-9.?#]+)?");
    }

    public static boolean isUrlPath(String str){
        return str.matches("(http[s]?:\\/\\/)([^\\/\\s]+\\/)(.*)");
    }

    public static boolean isIp(String str){
        return str.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})");
    }

    public static boolean isDate(String str){
        return str.matches("^\\d{4}.\\d{2}.\\d{2}$");
    }

    public static boolean isUUID(String str){
        return str.matches("[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}");
    }
}
