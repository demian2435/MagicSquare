package it.magicSquare.Model;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		MagicSquare ms = new MagicSquare();
		List<Integer> s = ms.trova(4, true);
		System.out.println(s);
	}

}
