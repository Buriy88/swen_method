import java.util.function.Function;

public class Main
{
    public static double [] SvenMethod(Function<Double, Double> f, double x, double step){
        double x1= x-step;
        double x2=x+step;
        double f0= f.apply(x);
        double f1= f.apply(x1);
        double f2= f.apply(x2);
        if ((f1>f0)&&(f2>f1)){
            System.out.println(x1);
            System.out.println(x2);
            return new double[]{x1, x2};
        }
        else if(f1<f0 && f2<f0) {
            System.out.println("функція не є унімодальною");
            return null;
        }
        if (f1<=f2){
            step=-step;
        }
        else {
            x1=x2;
            f1=f2;
        }
        for (int i = 1; true ; i++) {
            System.out.print("iteration:"+i+"  ");
            step=step*2;
            x2=x1+step;
            f2=f.apply(x2);
            if (f2<=f1)
            {
                x=x1;
                x1=x2;
                f1=f2;
                System.out.print(x+"  ");
                System.out.println(x1);
            }
            else
            {
               double x3=x2-step/2;
               double f3=f.apply(x3);
               if(f1>f3){
                  // System.out.println("step"+step);

                   System.out.print(x1+"  ");
                   System.out.println(x2);
                   return new double[]{x1, x2};
               }
               else{
                  // System.out.println("step"+step);

                   System.out.print(x1+"  ");
                   System.out.println(x2);
                   return new double[]{x, x3};
               }
            }

        }


}
    public static void main(String[] args)
    {
        Function<Double, Double> f = x -> Math.pow((-5-x)/3-1.4,2);
        double x= 10;
        double step=0.1;
        System.out.println("Початковий крок:"+step);
        SvenMethod(f,x,step);




    }
}