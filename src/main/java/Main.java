public class Main {
    public static void main(String[] args) {
        int x;
        String a;
        String b;
        String c,d;
        a = ",riK";
        b = " ";
        c = " et ner";
        d = "h v";
        String k;
        String h;
        h = " ohu ";
        k = a + b + c + d + h;
        String str3 = k;
        String[] words = new StringBuilder(str3).reverse().toString().split(" ");
        StringBuilder newStr = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) newStr.append(words[i]).append(" ");
        System.out.println(newStr);
    }

}
