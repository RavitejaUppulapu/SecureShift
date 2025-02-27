import java.util.Scanner;

class Encrypt{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        char[] s = new char[10000];
        System.out.println("Enter Message:::");
        String input = scanner.nextLine();
        s = input.toCharArray();
        int l = input.length();

        String dolph = "";
        String kang = "";
        String bird = "";

        for (int i = 0; i < l; i += 3) {
            dolph += s[i];
            s[i] = (char) 231;
        }

        int k = l - 1;
        if (s[k] == (char) 231) k--;
        for (int i = k; i >= 0; i -= 3) {
            kang += s[i];
            s[i] = (char) 231;
        }

        for (int i = 0; i < l; i++) {
            if (s[i] != (char) 231) {
                bird += s[i];
                s[i] = (char) 231;
            }
        }

        int bir, dol, kan;
        bir = scanner.nextInt();
        dol = scanner.nextInt();
        kan = scanner.nextInt();

        String BDK = "";
        if (bir == dol && dol == kan) {
            BDK = bird + dolph + kang;
        } else if (bir > dol && dol > kan) {
            BDK = bird + dolph + kang;
        } else if (bir > kan && kan > dol) {
            BDK = bird + kang + dolph;
        } else if (dol > bir && bir > kan) {
            BDK = dolph + bird + kang;
        } else if (dol > kan && kan > bir) {
            BDK = dolph + kang + bird;
        } else if (kan > bir && bir > dol) {
            BDK = kang + bird + dolph;
        } else if (kan > dol && dol > bir) {
            BDK = kang + dolph + bird;
        } else {
            // no specific condition matched
        }

        System.out.println("YOUR CIPHER:\t\t\t" + BDK);
        scanner.close();
    }
}
