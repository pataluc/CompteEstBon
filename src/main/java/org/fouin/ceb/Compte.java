package org.fouin.ceb;

import java.util.ArrayList;

public class Compte {

	private ArrayList<Integer> chiffres;

	private Integer but;
	
	private boolean resolu = false;

	private boolean search() {
		for (int i = 0; i < chiffres.size(); i++) {
			for (int j = i + 1; j < chiffres.size(); j++) {
				for (int o = 0; o < 6; o++) {

					ArrayList<Integer> newChiffres = (ArrayList<Integer>) chiffres
							.clone();

					Integer c2 = newChiffres.remove(j);
					Integer c1 = newChiffres.remove(i);

					int c;

					if ((o == 0) && (c1 != 1) && (c2 != 1)) {
						if (c1 * c2 == but) {
							System.out.println("Gagné " + c1 + "*" + c2 + "=" + (c1 * c2));
							return true;
						}
						newChiffres.add(c1 * c2);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c1 + "*" + c2 + "=" + (c1 * c2));
							return true;
						}
						
						
						
					} else if (o == 1) {
						if (c1 + c2 == but) {
							System.out.println("Gagné " + c1 + "+" + c2 + "=" + (c1 + c2));
							return true;
						}
						newChiffres.add(c1 + c2);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c1 + "+" + c2 + "=" + (c1 + c2));
							return true;
						}
						
						
						
					} else if ((o == 2) && (c1 > c2)) {
						if (c1 - c2 == but) {
							System.out.println("Gagné " + c1 + "-" + c2 + "=" + (c1 - c2));
							return true;
						}
						newChiffres.add(c1 - c2);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c1 + "-" + c2 + "=" + (c1 - c2));
							return true;
						}
						
						
						
					} else if ((o == 3) && (c1 < c2)) {
						if (c2 - c1 == but) {
							System.out.println("Gagné " + c2 + "-" + c1 + "=" + (c2 - c1));
							return true;
						}
						newChiffres.add(c2 - c1);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c2 + "-" + c1 + "=" + (c2 - c1));
							return true;
						}
						
						
						
					} else if ((o == 4) && (c1 != c2) && (c1 % c2 == 0)) {
						if (c1 / c2 == but) {
							System.out.println("Gagné " + c1 + "/" + c2 + "=" + (c1 / c2));
							return true;
						}
						newChiffres.add(c1 / c2);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c1 + "/" + c2 + "=" + (c1 / c2));
							return true;
						}
						
						
						
					} else if ((o == 5) && (c1 != c2) && (c2 % c1 == 0)) {
						if (c2 / c1 == but) {
							System.out.println("Gagn� " + c2 + "/" + c1 + "=" + (c2 / c1));
							return true;
						}
						newChiffres.add(c2 / c1);
						if(new Compte(newChiffres, but).estResolu()){
							System.out.println(c2 + "/" + c1 + "=" + (c2 / c1));
							return true;
						}
					}

					// System.out.println(c1 + " " + c2 + " " + o);
				}
			}
		}

		// pour chaque couple, enchainer les 6 ope possible, + * - - / /
		return false;
	}

	public Compte(ArrayList chiffres, Integer but) {
		this.chiffres = (ArrayList<Integer>) chiffres.clone();
		this.but = but;

		// System.out.println(chiffres);

		
		resolu = this.search();			
		
	}
	
	public boolean estResolu() {
		return resolu;
	}

	public static void main(String[] args) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		if (args.length == 7) {
			for (int i = 0; i < 6; i++) {
				l.add(Integer.parseInt(args[i]));
			}

			System.out.println("But = " + args[6]);
			System.out.println("Chiffres = " + l);
			System.out.println("=============================");
			new Compte(l, Integer.parseInt(args[6]));
		} else {
			System.out.println("Nombre d'arguments incorrect.");
		}
	}

}
