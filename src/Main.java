import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        String eingabe = new String(Files.readAllBytes(Paths.get("file.txt")));

        String[] eingaben = eingabe.split("\n");

        for(int i = 0; i < eingaben.length; i++) {
            if(eingaben[i].contains("oneight")){
                eingaben[i] = eingaben[i].replace("oneight", "oneeight");
            }
            if(eingaben[i].contains("twone")){
                eingaben[i] = eingaben[i].replace("twone", "twoone");
            }
            if(eingaben[i].contains("eightwo")){
                eingaben[i] = eingaben[i].replace("eightwo", "eighttwo");
            }
        }
        System.out.println(eingaben[0]);

        Integer Ergebnis = 0;

        Pattern pattern = Pattern.compile("[0-9]|one|two|three|four|five|six|seven|eight|nine");
        ArrayList<String> liste = new ArrayList<>();

        for(String e : eingaben) {
            Matcher matcher = pattern.matcher(e);
            while(matcher.find()){
                liste.add(matcher.group());
                System.out.println(matcher.group());
            }

            for(String s : liste) {
                System.out.println("Liste: " + s);
            }

            buchstabenSuchen(liste, 0);
            buchstabenSuchen(liste, liste.size()-1);
            System.out.println(liste.get(0));

            Integer temp = Integer.parseInt(liste.get(0) + liste.get(liste.size()-1));
            System.out.println(temp);
            Ergebnis = Ergebnis + temp;
            liste.clear();

        }
        System.out.println(Ergebnis);
    }

    private static void buchstabenSuchen(ArrayList<String> liste, int position) {
        if(liste.get(position).equals("one")){
            liste.set(position, "1");
        }
        if(liste.get(position).equals("two")){
            liste.set(position, "2");
        }
        if(liste.get(position).equals("three")){
            liste.set(position, "3");
        }
        if(liste.get(position).equals("four")){
            liste.set(position, "4");
        }
        if(liste.get(position).equals("five")){
            liste.set(position, "5");
        }
        if(liste.get(position).equals("six")){
            liste.set(position, "6");
        }
        if(liste.get(position).equals("seven")){
            liste.set(position, "7");
        }
        if(liste.get(position).equals("eight")){
            liste.set(position, "8");
        }
        if(liste.get(position).equals("nine")){
            liste.set(position, "9");
        }
    }
}