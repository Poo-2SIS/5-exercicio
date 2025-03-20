public class SpreadOperator {
    public static void main(String[] args) {
        int number;
        number = somar(1,2);
        System.out.println(number);
        number = somar(1,2,3);
        System.out.println(number);
        number = somar(1,2,3,4,5,6);
        System.out.println(number);

    }

    public static int somar(int ...x){
        int s = 0;
        for (int n : x) {
            s += n;
        }
        return s;
    }
}
