public class UKG {
    public static void main(String[] args) {

        String str1 = "abcd";
        String str2 = "axyd";
        // if first and last letters are same then output should true

        String str3 = "abZcd";
        String str4 = "axZyd";
        // true: a-Z-d SHOULD SAME

        System.out.println( compareStrings( str1, str2));       // true
        System.out.println( compareStrings( str3, str4));       // true
        System.out.println( compareStrings( str1, str4));       // false
    }

    static boolean compareStrings(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int last = s.length()-1;
        if(s.length()%2==0){
            if(s.charAt(0)==t.charAt(0) && s.charAt(last)==t.charAt(last) ){
                return true;
            }
        }else{
            if(s.charAt(0)==t.charAt(0) && s.charAt(last)==t.charAt(last) && s.charAt(s.length()/2)==t.charAt(t.length()/2)){
                return true;
            }
        }

        return false;
    }
}