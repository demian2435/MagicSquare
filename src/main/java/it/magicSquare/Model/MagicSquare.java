package it.magicSquare.Model;

import java.util.ArrayList;
import java.util.List;

public class MagicSquare {
	private int n;
	private int n2;
	private int m;
	private static int test;
	private List<Integer> qm;

	private int magicConstant(int n) {
		return (int) ((n * (Math.pow(n, 2) + 1)) / 2);
	}

	public List<Integer> trova(int n, boolean potatura) {
		this.n = n;
		n2 = n * n;
		m = magicConstant(n);
		test = 0;
		trovaRicorsiva(new ArrayList<Integer>(), 0, potatura);
		System.out.println("Totale ricerche: " + test);
		return qm;
	}

	public void trovaRicorsiva(List<Integer> parziale, int livello, boolean potatura) {
		if (livello == n2) {
			test++;
			if (quadratoPerfetto(parziale)) {
				qm = new ArrayList<Integer>(parziale);
				System.out.println(test + "-- " + qm);
			}
		}

		if (potatura) {
//			if (qm != null) {
//				return;
//			}

			// POTATURA
			if (livello % n == 0 && livello > 0) {
				if (!controlloRiga(parziale, livello / n - 1)) {
					return;
				}
			}
		}

		for (int i = 1; i <= n2; i++) {
			if (!parziale.contains(i)) {
				parziale.add(i);
				trovaRicorsiva(parziale, livello + 1, potatura);
				parziale.remove(parziale.size() - 1);
			}
		}
	}

	private boolean controlloRiga(List<Integer> s, int riga) {
		int somma = 0;

		// SOMMA RIGHE
		for (int colonna = 0; colonna < n; colonna++) {
			somma += s.get(riga * n + colonna);
		}

		return somma == m;

	}

	public boolean quadratoPerfetto(List<Integer> s) {
		int somma = 0;

		// SOMMA RIGHE
		for (int riga = 0; riga < n; riga++) {
			somma = 0;
			for (int colonna = 0; colonna < n; colonna++) {
				somma += s.get(riga * n + colonna);
			}
			if (somma != m) {
				return false;
			}
		}

		// SOMMA COLOn2E
		for (int colonna = 0; colonna < n; colonna++) {
			somma = 0;
			for (int riga = 0; riga < n; riga++) {
				somma += s.get(riga * n + colonna);
			}
			if (somma != m) {
				return false;
			}
		}

		// DIAGONALE SX
		somma = 0;
		for (int riga = 0; riga < n; riga++) {
			somma += s.get(riga * n + riga);
		}
		if (somma != m) {
			return false;
		}

		// DIAGONALE SX
		somma = 0;
		for (int riga = 0; riga < n; riga++) {
			somma += s.get(riga * n + (n - 1 - riga));
		}
		if (somma != m) {
			return false;
		}

		// COMPLETATA RICERCA
		return true;
	}

}
