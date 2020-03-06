package com.baufest.ingreso.sorting;




import java.util.Collections;
import java.util.Comparator;
import  java.util.List;
import java.util.stream.Collectors; 


public class Sorting {
	/**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	
	public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores){
    
			// PRIMERO ORDENO POR ORDEN ALFABETICO
			Collections.sort(jugadores, new Comparator<Jugador>() {
				   public int compare(Jugador obj1, Jugador obj2) {
				      return obj1.getNombre().compareTo(obj2.getNombre());
				   }
				});

			//ACÁ ORDENO POR PUNTUACIÓN 
			List<Jugador> order= jugadores.stream()
					.sorted(Comparator.comparingInt(Jugador::getPuntuacion)
					.reversed())
					.collect(Collectors.toList());

            //LIMPIO DE CONTENIDO LISTA jugadores
            jugadores.clear();
            // TRANSFIERO DATOS DE order A jugadores
            jugadores.addAll(order);

            return jugadores;        

	
	}    
	
    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se seguirá usando el
     * nombre de manera ascendente.
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
	public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores){
		

		    // PRIMERO ORDENO POR ORDEN ALFABETICO
		    Collections.sort(jugadores, new Comparator<Jugador>() {
			      public int compare(Jugador obj1, Jugador obj2) {
			      return obj1.getNombre().compareTo(obj2.getNombre());
			   }
			 });
		
		    //ACÁ ORDENO POR PÉRDIDAS 
		    List<Jugador> orderPerdidas = jugadores.stream()
				 .sorted(Comparator.comparingInt(Jugador::getPerdidas))
				 .collect(Collectors.toList());

		    //ACÁ ORDENO POR PUNTUACIÓN 
		    List<Jugador> order= orderPerdidas.stream()
				 .sorted(Comparator.comparingInt(Jugador::getPuntuacion)
				 .reversed())
				 .collect(Collectors.toList());

            //LIMPIO DE CONTENIDO LISTA jugadores
            jugadores.clear();
            
            // TRANSFIERO DATOS DE order A jugadores
            jugadores.addAll(order);

            return jugadores;        



	}
}
