import java.util.Scanner;

class PersonalityAnalyzer {
 
    private boolean[] answers = new boolean[10];

    public void recordAnswer(int index, boolean value) {
        if (index >= 0 && index < 10) {
            answers[index] = value;
        }
    }

    private int countRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (answers[i]) {
                count++;
            }
        }
        return count;
    }

    public String decideResult() {
        int extrovertScore = countRange(0, 4);
        int introvertScore = countRange(5, 9);

        if (extrovertScore > introvertScore) {
            return "You're Extrovert";
        } else if (introvertScore > extrovertScore) {
            return "You're Introvert";
        } else {
            return "Balanced (Ambivert)";
        }
    }
}

public class OOP {
    public static void main(String[] args) {
        String[] questions = {
            "I enjoy going to parties with lots of people.",
            "I find it easy to start conversations with strangers.",
            "I feel comfortable being the center of attention.",
            "I prefer working in a group rather than alone.",
            "I feel more energized after spending time with other people.",
            "I feel more energized after spending time alone.",
            "I prefer listening over talking in group discussions.",
            "I need quiet time to recharge after socializing.",
            "I prefer a quiet night in over a big social event.",
            "I think carefully before speaking in a group."
        };

        Scanner scanner = new Scanner(System.in);
        PersonalityAnalyzer analyzer = new PersonalityAnalyzer();

        for (int i = 0; i < 10; i++) {
            System.out.print("Q" + (i + 1) + ": " + questions[i] + " (T/F): ");
            String input = scanner.nextLine().trim();
            boolean val = input.equalsIgnoreCase("T") || input.equalsIgnoreCase("Y");
            analyzer.recordAnswer(i, val);
        }

        System.out.println("\n" + analyzer.decideResult());
        scanner.close();
    }
}