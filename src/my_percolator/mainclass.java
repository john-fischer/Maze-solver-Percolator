package my_percolator;

import java.util.Scanner;

public class mainclass {

	public static void main(String[] args) {
		maze mz = new maze(20);
		mz.initialize();
		mz.show_board();
		Scanner sc = new Scanner(System.in);
		while (true) {
			int x_1 = sc.nextInt();
			int y_1 = sc.nextInt();
			int x_2 = sc.nextInt();
			int y_2 = sc.nextInt();
			System.out.println(mz.path(x_1, y_1, x_2, y_2));
			break;
		}
		mz.show_board();
		sc.close();
	}
}