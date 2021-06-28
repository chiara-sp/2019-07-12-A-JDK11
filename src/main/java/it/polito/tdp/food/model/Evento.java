package it.polito.tdp.food.model;

import java.time.LocalTime;

public class Evento implements Comparable<Evento>{

	enum EventType{
		arrivo,
		termine,
	}
	LocalTime tempo;
	int numStazione;
	EventType tipo;
	Food food;
	public Evento(LocalTime tempo, int numStazione, EventType tipo, Food food) {
		super();
		this.tempo = tempo;
		this.numStazione = numStazione;
		this.tipo = tipo;
		this.food=food;
	}
	@Override
	public String toString() {
		return "Evento [tempo=" + tempo + ", numStazione=" + numStazione + ", tipo=" + tipo + ", food=" + food + "]";
	}
	public LocalTime getTempo() {
		return tempo;
	}
	public void setTempo(LocalTime tempo) {
		this.tempo = tempo;
	}
	public int getNumStazione() {
		return numStazione;
	}
	public void setNumStazione(int numStazione) {
		this.numStazione = numStazione;
	}
	public EventType getTipo() {
		return tipo;
	}
	public void setTipo(EventType tipo) {
		this.tipo = tipo;
	}
	@Override
	public int compareTo(Evento o) {
		// TODO Auto-generated method stub
		return this.tempo.compareTo(o.tempo);
	}
	
	
}
