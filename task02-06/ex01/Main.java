import java.io.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int dec_number, quot, i=1, j;
    int bin_number[] = new int [100];
    Scanner scan = new Scanner(System.in);

    System.out.print("Введіть десятичне число : ");
    dec_number = scan.nextInt();

    quot = dec_number;

    while(quot != 0)
    {
      bin_number[i++] = quot%2;
      quot = quot/2;
    }

    System.out.print("Двоїчне число : ");
    for(j=i-1; i>0; i--)
    {
      System.out.print(bin_number[j]);
    }
    System.out.print("\n");
  }
}
