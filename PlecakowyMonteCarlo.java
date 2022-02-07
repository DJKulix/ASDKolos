package com.company;

import java.util.*;

class PlecakowyMonteCarlo
{

    static final int N = 6;                // liczba przedmiotow
    static final int MAX_V = 10;           // objetosc plecaka

    final static int[] V = {2,6,3,3,1,2};  // objetości przedmiotów
    final static int[] W = {4,6,5,10,2,7}; // wartości przedmiotów

    public static void main(String[] args)
    {        
        String optKonfig = new String();
        int optV = -1;
        int optW = 0;

        Random random = new Random();
        
        for (int i = 0; i < 10; i++) // 10 prob losowania (10 wygenerowanych rozwiazan)
        {
            int[] ustaw = new int[N]; // inicjujemy wstepne ustawienie przedmiotow (od 0 do 5)
            
            for (int j = 0; j < N; j++){// tasowanie przedmiotow
                int rndIndex = random.nextInt(N);
                if (rndIndex != j){
                    int pom = ustaw[j]; // zamiana elementow
                    ustaw[j] = ustaw[rndIndex];
                    ustaw[rndIndex] = pom;
                }
            }
			
            // parametry lokalnego rozwiazania
            String locKonfig = new String();
            int sumV = 0;
            int sumW = 0;
            int j = 0;

            // wkladamy do plecaka przedmioty rozpoczynajac od poczatku tablicy (przetasowanej) dopoki sie mieszcza
            while ((j < N) && (sumV + V[ustaw[j]] <= MAX_V))
            {
                sumV += V[ustaw[j]];
                sumW += W[ustaw[j]];
                locKonfig = locKonfig + " " + ustaw[j];
                j++;
            }

            // jesli dane rozwiazanie (lokalne) jest lepsze od dotychczas najlepszego rozwiazania (globalnego)
            if (sumW > optW) { // podmiana wartosci optymalnego rozwiazania
                optW = sumW;
                optV = sumV;
                optKonfig = locKonfig;
            }

        }

        System.out.println("Calkowita objetość: " + optV);
        System.out.println("Calkowita wartosc: " + optW);
        System.out.println("Konfiguracja: " + optKonfig);
        System.out.println("Niewykorzystana objętość: " + (MAX_V - optV));
    }
}
