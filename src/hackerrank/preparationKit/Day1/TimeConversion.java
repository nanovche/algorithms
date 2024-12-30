package hackerrank.preparationKit.Day1;


public class TimeConversion {

    public static void main(String[] args) {
        System.out.println(timeConversion("12:01:00PM")); // ->
        System.out.println(timeConversion("12:01:00AM")); // ->
        System.out.println(timeConversion("07:05:45PM")); // -> 19:05:45
    }

    public static String timeConversion(String s) {
        String twelve = "12";
        int exclusive = s.length() - 2;
        String value = s.substring(0, exclusive);
        String format = s.substring(exclusive);

        String[] tokens = value.split(":");
        if(format.equals("AM")){
            if(tokens[0].equals(twelve)){
                tokens[0] = "00";
            }
        } else if (format.equals("PM")) {
            if(!tokens[0].equals(twelve)){
                tokens[0] = String.valueOf(Integer.valueOf(tokens[0]) + 12);
            }
        }
        return String.join(":", tokens[0], tokens[1], tokens[2]);
    }
}