package com.rahul.practice.mdarray;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] twoDimentional = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int rows = twoDimentional.length;
		int columns = twoDimentional[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(twoDimentional[i][j] + " ");
			}
			System.out.println();
		}

		List<Integer> spiraledMatrix = spiralMatrix(twoDimentional);
	}

	private static List<Integer> spiralMatrix(int[][] twoDimentional) {
		List<Integer> sMatrix = new ArrayList<>();

		int rowStart = 0;
		int colStart = 0;
		int rowEnd = twoDimentional.length;
		int colEnd = twoDimentional[0].length;
		int k = 0;

		while (rowStart < rowEnd && colStart < colEnd) {

			for (k = colStart; k < colEnd; k++) {
				sMatrix.add(twoDimentional[rowStart][k]);
				rowStart++;
			}

			for (k = rowStart; k < rowEnd; k++) {
				sMatrix.add(twoDimentional[k][colEnd-1]);
				colEnd--;
			}

		}

		return null;
	}

}
