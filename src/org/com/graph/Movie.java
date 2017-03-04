package org.com.graph;


import java.util.ArrayList;
import java.util.HashSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Movie {

	private int id;
	private float rating;
	private List<Movie> similarMovies;
	
	public Movie(int id, float rating){
		this.id=id;
		this.rating=rating;
		similarMovies=new ArrayList<Movie>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public List<Movie> getSimilarMovies() {
		return similarMovies;
	}
	public void setSimilarMovies(List<Movie> similarMovies) {
		this.similarMovies = similarMovies;
	}
	
	public void addSimilarMovie(Movie movie) {
		similarMovies.add(movie);
		similarMovies.add(this);
	}
	
	
	private static Movie[] getMovieRecommendations(Movie movie, int i)  {
		Set<Movie> nodes=BFS(movie);
		
		Movie[] allnodes=new Movie[nodes.size()];
		nodes.toArray(allnodes);
		Movie[] sorted=new Movie[i];
		HeapSort sort=new HeapSort();
		for(int j=(allnodes.length/2)-1;j>0;j--){
			sort.trickleDown(allnodes,j);
		}
		for(int k=0;k<i;k++){
			sorted[k]=sort.extractMax(allnodes);
		}
		
		return sorted;
	}
	public static Set<Movie> BFS(Movie startNode){
		Set<Movie> visited=new HashSet<Movie>();
		Queue<Movie> queue = new LinkedList<>();
		queue.add(startNode);
		while(!queue.isEmpty()){
			Movie nextNode=(Movie) queue.poll();
			if(!visited.contains(nextNode)){
				visited.add(nextNode);
				queue.addAll(nextNode.similarMovies);
			}	
		}
		return visited;
	}
	 public static void main(String[] args) {
	        Movie movieA = new Movie(1, 1.2f);
	        Movie movieB = new Movie(2, 2.4f);
	        Movie movieC = new Movie(3, 3.6f);
	        Movie movieD = new Movie(4, 4.8f);
	        movieA.addSimilarMovie(movieB);
	        movieA.addSimilarMovie(movieC);
	        movieB.addSimilarMovie(movieA);
	        movieB.addSimilarMovie(movieD);
	        movieC.addSimilarMovie(movieA);
	        movieC.addSimilarMovie(movieD);
	        movieD.addSimilarMovie(movieB);
	        movieD.addSimilarMovie(movieC);

	        for (Movie m : getMovieRecommendations(movieA, 2)) {
	            System.out.println("Movie id=" + m.getId() + " Rating=" + m.getRating());
	        }
	    }
	
	
}
