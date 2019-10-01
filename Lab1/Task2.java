import java.security.SecureRandom;

public final class Task2 implements TaskContract.Task2 {
    @Override
    public String[] splitAndReplace(String s) {
        String[] res = new String[s.length() / 3];
        for (int i = 0; i < s.length() / 3; ++i) {
            char symbol = getRandomChar();
            while ((symbol == s.charAt(i * 3)) || (symbol == s.charAt(i * 3 + 2))) {
                symbol = getRandomChar();
            }
            String temp = "" + s.charAt(i * 3) + symbol + s.charAt(i * 3 + 2);
            res[i] = temp;

        }
        return res;
    }

    @Override
    public void printArray(String[] strings) {
        for (String r : strings) {
            System.out.println(r);
        }
    }

    private char getRandomChar() {
        SecureRandom random = new SecureRandom();
        return (char) random.nextInt(127);
    }
}
