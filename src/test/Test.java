package test;

public class Test {

    static int fun(int A, int B){
        if(B == 0){
            return A;
        } else return fun(B, A % B);
    }

    static int fib(int n){
        if (n <= 1){
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    static int printTribRec(int n){
        if(n == 0 || n == 1 || n == 2) return 0;

        if(n == 3) return 1;
        else
            return  printTribRec(n - 1) + printTribRec(n - 2) + printTribRec(n - 3) ;
    }

    public static void main(String[] args) {
        int i = 0;
        int sum = 0;

        while(i < 100){
            sum = sum + i;
            sum = i + sum;
            i ++;
        }

        System.out.println(sum);

        int ans =  fun(100, 2000);
        System.out.println(ans);

        System.out.println(fib(6));

        for (int j = 1; j < 6; j++) {
            System.out.print(printTribRec(j) + " ");
        }
    }

}
