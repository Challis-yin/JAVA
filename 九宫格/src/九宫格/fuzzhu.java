package ¾Å¹¬¸ñ;

public class fuzzhu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[3][3];
        int a = 2;
        int b = 3 / 2;
        for (int i = 1; i <= 9; i++) {
            arr[a++][b++] = i;
            if (0 == i % 3) {
                a = a - 2;
                b = b - 1;
            }
            else {
                a = a % 3;
                b = b % 3;
            }
        }
        System.out.println("output:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

	}


