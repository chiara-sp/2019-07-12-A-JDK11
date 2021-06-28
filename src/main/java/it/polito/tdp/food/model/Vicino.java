package it.polito.tdp.food.model;

public class Vicino implements Comparable<Vicino>{

	private Food f;
	private Double peso;
	public Vicino(Food f, double peso) {
		super();
		this.f = f;
		this.peso = peso;
	}
	public Food getF() {
		return f;
	}
	public void setF(Food f) {
		this.f = f;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(Vicino o) {
		// TODO Auto-generated method stub
		return -this.peso.compareTo(o.peso);
	}
	
	
}
