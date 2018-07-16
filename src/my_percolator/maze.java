package my_percolator;

import java.util.*;

public class maze {
	int[][] board;
	int size;

	maze(int n) {
		size = n;
		board = new int[size][size];

	}

	void show_board() {
		for (int i = 0; i < size; ++i) {
			System.out.print("|| ");
			for (int j = 0; j < size; ++j) {
				System.out.print(board[i][j] + " ");
			}
			System.out.print("||\n");
		}
	}

	void initialize() {
		Random rand = new Random();
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				board[i][j] = rand.nextInt(2);
			}
		}
	}

	boolean contains(LinkedList<int[]> list, int[] to_check) {
		boolean found = false;
		for (int[] item : list) {
			if (item[0] == to_check[0] && item[1] == to_check[1]) {
				found = true;
				return found;
			}
		}
		return found;

	}

	boolean path(int x_1, int y_1, int x_2, int y_2) {
		boolean union = false;
		LinkedList<int[]> visited = new LinkedList<int[]>();
		LinkedList<int[]> toVisit = new LinkedList<int[]>();
		int[] start = { x_1, y_1 };
		int[] end = { x_2, y_2 };
		toVisit.addFirst(start);
		while (!toVisit.isEmpty()) {
			int[] curr = toVisit.poll();
			if (curr[0] == end[0] && curr[1] == end[1]) {
				union = true;
				return union;
			}
			board[curr[0]][curr[1]] = 2;
			visited.addFirst(new int[] { curr[0], curr[1] });
			// below
			if(curr[1] + 1 < size) {
			int[] below = new int[] { curr[0], curr[1] + 1 };
			if (!contains(visited, below) && board[curr[0]][curr[1]+1] !=1) {
				toVisit.addFirst(below);
			}}
			// left
			if(curr[0] - 1 >= 0 ) {
			int[] left = new int[] { curr[0] - 1, curr[1] };
			if (curr[0] - 1 >= 0 && !contains(visited, left) && board[curr[0] - 1][curr[1]] !=1) {
				toVisit.addFirst(left);
			}}
			// right
			if(curr[0] + 1 < size) {
			int[] right = new int[] { curr[0] + 1, curr[1] };
			if (curr[0] + 1 < size && !contains(visited, right) && board[curr[0] + 1][curr[1]] !=1) {
				toVisit.addFirst(right);
			}}
			// top
			if(curr[1] - 1 >= 0) {
			int[] top = new int[] { curr[0], curr[1] - 1 };
			if (!contains(visited, top) && board[curr[0]][curr[1]-1] !=1) {
				toVisit.addFirst(top);
				}
			}}
		return union;
	}
}
