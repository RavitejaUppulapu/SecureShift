import java.util.Scanner;

public class Decrypt{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cipher:::");
        
        String C = scanner.nextLine();
        int len = C.length();
        
        int bl = 0;
        int dl = 0;
        int kl = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum = dl + kl + bl;
            if (sum == len) break;
            dl++;
            
            sum = dl + kl + bl;
            if (sum == len) break;
            kl++;
            
            sum = dl + kl + bl;
            if (sum == len) break;
            bl++;
        }

        String ed = "";
        String ek = "";
        String eb = "";

        int bc, dc, kc;
        System.out.println("Enter B-D-K costs:");
        bc = scanner.nextInt();
        dc = scanner.nextInt();
        kc = scanner.nextInt();

        if ((bc > dc && dc > kc) || (bc == kc && kc == dc)) {
            for (int i = 0; i < bl; i++)
            eb += C.charAt(i);
            for (int j = bl; j < bl + dl; j++) 
            ed += C.charAt(j);
            for (int k = bl + dl; k < bl + dl + kl; k++) 
            ek += C.charAt(k);
        } else if (bc > kc && kc > dc) {
            for (int i = 0; i < bl; i++) 
            eb += C.charAt(i);
            for (int j = bl; j < bl + kl; j++) 
            ek += C.charAt(j);
            for (int k = bl + kl; k < bl + dl + kl; k++) 
            ed += C.charAt(k);
        } else if (dc > bc && bc > kc) {
            for (int i = 0; i < dl; i++) 
            ed += C.charAt(i);
            for (int j = dl; j < bl + dl; j++) 
            eb += C.charAt(j);
            for (int k = bl + dl; k < bl + dl + kl; k++) 
            ek += C.charAt(k);
        } else if (dc > kc && kc > bc) {
            for (int i = 0; i < dl; i++) 
            ed += C.charAt(i);
            for (int j = dl; j < dl + kl; j++) 
            ek += C.charAt(j);
            for (int k = dl + kl; k < bl + dl + kl; k++) 
            eb += C.charAt(k);
        } else if (kc > bc && bc > dc) {
            for (int i = 0; i < kl; i++) 
            ek += C.charAt(i);
            for (int j = kl; j < bl + kl; j++) 
            eb += C.charAt(j);
            for (int k = bl + kl; k < bl + dl + kl; k++) 
            ed += C.charAt(k);
        } else if (kc > dc && dc > bc) {
            for (int i = 0; i < kl; i++) 
            ek += C.charAt(i);
            for (int j = kl; j < kl + dl; j++) 
            ed += C.charAt(j);
            for (int k = kl + dl; k < bl + dl + kl; k++) 
            eb += C.charAt(k);
        } else {
            System.out.println("none");
        }

        int clen = eb.length() + ed.length() + ek.length();
        char[] CIP = new char[clen];

        for (int i = 0; i < clen; i++) {
            CIP[i] = (char) 231;
        }

        int dbigin = 0;
        int kbigin = clen - 1;

        for (int i = 0; i < clen; i += 3) {
            CIP[i] = ed.charAt(dbigin++);
        }
        
        if (CIP[kbigin] != (char) 231) kbigin--;
        
        int ks = 0;
        for (int i = kbigin; i >= 0; i -= 3) {
            CIP[i] = ek.charAt(ks++);
        }
        
        int bbigin = 0;
        for (int i = 0; i < clen; i++) {
            if (CIP[i] == (char) 231) {
                CIP[i] = eb.charAt(bbigin++);
            }
        }

        StringBuilder cstr = new StringBuilder();
        for (char ch : CIP) {
            cstr.append(ch);
        }

        System.out.println("YOUR PLAIN TEXT: " + cstr.toString());
        scanner.close();
    }
}

