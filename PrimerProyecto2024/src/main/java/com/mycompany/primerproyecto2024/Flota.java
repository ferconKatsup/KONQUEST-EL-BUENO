/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.naves.Nave;
import com.mycompany.primerproyecto2024.planetasYguerrero.Guerrero;

/**
 *
 * @author fer
 */
public class Flota {
    private int cantidadGuerreros;
    private Nave nave;
    private int turnoSalida;
    private int turnoLlegada;
    private Planeta destino;
    private Planeta origen;  // Se añade origen
    private Jugador jugador;  // Se añade referencia al jugador

    public Flota(int cantidadGuerreros, Nave nave, int turnoSalida, Planeta origen, Planeta destino, int turnosParaLlegada, Jugador jugador) {
        this.cantidadGuerreros = cantidadGuerreros;
        this.nave = nave;
        this.turnoSalida = turnoSalida;
        this.turnoLlegada = turnoSalida + turnosParaLlegada;
        this.origen = origen;
        this.destino = destino;
        this.jugador = jugador;
    }

    public int getTurnoLlegada() {
        return turnoLlegada;
    }

    public Planeta getDestino() {
        return destino;
    }

    public Planeta getOrigen() {
        return origen;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public Guerrero[] getGuerreros() {
        // lógica para gestionar la tripulación.
        return new Guerrero[cantidadGuerreros];  // Lógica simplificada
    }

    public void mostrarFlota() {
        System.out.println("Flota con " + cantidadGuerreros + " guerreros en la nave " + nave.getNombre());
        System.out.println("Turno de salida: " + turnoSalida);
        System.out.println("Turno de llegada: " + turnoLlegada + " al planeta " + destino.getNombre());
    }
    
    
    public boolean batalla(Guerrero[] guerrerosAtacantes) {
        System.out.println("Enviando flota con la nave " + nave.getNombre() + " y " + cantidadGuerreros + " guerreros.");
        
        if (destino.getDueño().equals("Neutral") || !destino.getDueño().equals(jugador.getNombre())) {
            // Si es un planeta neutral o enemigo, inicia la batalla
            boolean conquista = destino.batalla(guerrerosAtacantes, origen);
            if (conquista) {
                System.out.println("El planeta " + destino.getNombre() + " ha sido conquistado por " + jugador.getNombre() + "!");
                destino.setDueño(jugador.getNombre());
                return true; // Retorna verdadero si la conquista fue exitosa
            } else {
                System.out.println("Los defensores han repelido el ataque en " + destino.getNombre() + ".");
                return false; // Retorna falso si no se conquista
            }
        } else {
            // Si es un planeta aliado, simplemente se refuerzan los guerreros
            destino.reforzarGuerreros(guerrerosAtacantes);
            System.out.println("Los guerreros han sido enviados para reforzar el planeta " + destino.getNombre() + ".");
            return false; // Retorna falso, no hay conquista
        }
    }
    
}
