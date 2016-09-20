package pgcon;

import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble(); //変更前の消費税率(%)
        double y = scan.nextDouble(); //変更後の消費税率(%)
        double s = scan.nextDouble(); //消費税率変更前の 2 商品の税込合計価格

        double xTaxedItem1, xTaxedItem2, yTaxedItem1, yTaxedItem2; //商品の税込価格
        double NoTaxItem1 = 0, NoTaxItem2 = 0; //商品の税抜価格
        double maxTaxedValue = 0; //新消費税率での最大税込合計価格

        for(int i = 0; i < s / 2 + 1; i++) {
            xTaxedItem1 = (double)i;
            xTaxedItem2 = (double)s - (double)i;

            NoTaxItem1 = Math.ceil(xTaxedItem1 / ((double)1 + x / (double)100));
            NoTaxItem2 = Math.ceil(xTaxedItem2 / ((double)1 + x / (double)100));

            yTaxedItem1 = Math.floor(NoTaxItem1 * ((double)1 + y / (double)100));
            yTaxedItem2 = Math.floor(NoTaxItem2 * ((double)1 + y / (double)100));

            if(maxTaxedValue < (yTaxedItem1 + yTaxedItem2)) {
                maxTaxedValue = yTaxedItem1 + yTaxedItem2;
            }
        }

        System.out.println((int)maxTaxedValue);

        scan.close();
    }
}
