package it.polito.tdp.food.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private FoodDao dao;
	SimpleWeightedGraph<Food, DefaultEdge>grafo;
	List<Food> vertici;
	Map<Integer,Food> cibi;
	
	public Model() {
		dao= new FoodDao();
		vertici=new LinkedList<>();
		
	}
	
	public void creaGrafo(int porzioni) {
		cibi= new HashMap<>();
		grafo= new SimpleWeightedGraph<>(DefaultEdge.class);
		vertici=dao.getFoodByPortion(porzioni);
		for(Food f: vertici) {
			cibi.put(f.getFood_code(), f);
		}
		Graphs.addAllVertices(grafo, vertici);
		for(Adiacenza a: dao.getAdiacenze(cibi)) {
			Graphs.addEdge(grafo, a.getF1(), a.getF2(), a.getPeso());
		}
	}
	public List<Food> getVertici(){
		return vertici;
	}

	public int numVertici() {
		// TODO Auto-generated method stub
		return this.grafo.vertexSet().size();
	}

	public int numArchi() {
		// TODO Auto-generated method stub
		return this.grafo.edgeSet().size();
	}
	public List<Vicino> adiacenti(Food food){
		List<Vicino> lista = new LinkedList<>();
		if(Graphs.neighborListOf(grafo, food).size()>0) {
		for(Food f: Graphs.neighborListOf(grafo, food)) {
			lista.add(new Vicino (f, grafo.getEdgeWeight(grafo.getEdge(f, food))));
		}
		Collections.sort(lista);
		
		return lista;
		}
		return null;
	}

}
