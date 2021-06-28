package it.polito.tdp.food.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.model.Evento.EventType;

public class Simulatore {

	//coda degli eventi
	PriorityQueue<Evento> queue;
	
	//modello del mondo 
	Graph<Food,DefaultWeightedEdge> grafo;
	List<Food> adiacentiPartenza;
	Model model;
	LocalTime start= LocalTime.of(8, 0);
	
	//parametri di input
	int numeroStazioni;
	Food partenza;
	
	//parametri di output
	List<Food> giaPreparati;
	int numeroCibiPreparati;
	Duration tempoTotale;
	
	public Simulatore(SimpleWeightedGraph<Food,DefaultWeightedEdge> grafo, int K, Food partenza) {
		this.grafo=grafo;
		this.numeroStazioni=K;
		this.partenza=partenza;
		this.numeroCibiPreparati=0;
		this.model= new Model();
		this.queue=new PriorityQueue<>();
		this.adiacentiPartenza= new LinkedList<>();
		adiacentiPartenza.add(partenza);
		this.giaPreparati= new LinkedList<>();
		
		for(int i=0; adiacentiPartenza.size()<=K; i++) {
			Food f= model.adiacenti(partenza).get(i).getF();
			this.adiacentiPartenza.add(f);
			
		}
		
		for(int i=0; i<adiacentiPartenza.size(); i++) {
			queue.add(new Evento(start,i,EventType.arrivo, adiacentiPartenza.get(i)));
		}
		
		
		
	}
	public void run() {
		while(!queue.isEmpty()) {
			Evento ev= queue.poll();
			Food f= ev.food;
			LocalTime ora= ev.getTempo();
			System.out.println(ev);
			
			switch(ev.tipo) {
			case arrivo: 
				
			}
		}
	}
	public double getDurataPreparazione(Food f) {
		return model.adiacenti(f).get(0).getPeso();
		
	}

}
