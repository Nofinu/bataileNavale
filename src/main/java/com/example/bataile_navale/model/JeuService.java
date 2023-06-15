package com.example.bataile_navale.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class JeuService {
    private List<Case> plateau = new ArrayList<>();
    private boolean boatPlaced;
    private Random random;
    private Tirage _tirageCase;

    public JeuService(Tirage tirage) {
        random = new Random();
        boatPlaced = false;
        _tirageCase = tirage;
    }



    public boolean initGrille (){
        for (int i =0;i<10;i++){
            for (int j =0;j<10;j++){
                plateau.add(new Case(i+1,j+1));
            }
        }
        return plateau.size() == 100;
    }

    public void initBoat (){
        if(!boatPlaced){
            for (int i =0; i<15;i++){
                int rndValue = _tirageCase.tirageRnd(0,50);
                plateau.get(rndValue).setBoat(true);
            }
            for (int i =0; i<15; i++){
                int rndValue = _tirageCase.tirageRnd(50,100);
                plateau.get(rndValue).setBoat(true);

            }
            boatPlaced = true;
        }
    }

    public boolean Verifshoot (int x , int y){
        if(plateau.get())
    }

}
