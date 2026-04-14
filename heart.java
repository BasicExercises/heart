import java.util.Scanner;

public class heart {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入愛心大小(以20為標準,如輸入20則heart放大1倍):");
        double size = scanner.nextDouble();

        scanner.close();

        // 這裡將 20 作為標準大小 (S=1.0)
        double S = size / 20;

        //設定誤差值
        double error = 0.0001;

        //Y軸，從上往下繪製
        for (double y = 1.3; y >= -1.2; y -= 0.05) {

            //X軸，從左往右繪製
            for (double x = -1.5; x <= 1.5; x += 0.025) {

                // 座標縮放回標準愛心空間
                double X = x / S;
                double Y = y / S;

                //愛心方程式：(x² + y² - 1)³ - x²y³ = 0
                double e1=Math.pow(Math.pow(X,2)+Math.pow(Y,2)-1,3);
                double e2=Math.pow(X,2)*Math.pow(Y,3);

                //判斷是否為愛心內部或邊緣
                if (e1-e2 < error) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            
            //每畫完一行X軸，就換行
            System.out.println();
        }
    }
}
