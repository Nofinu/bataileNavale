package com.example.bataile_navale.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class JeuService {
    private List<Case> plateau = new ArrayList<>();
    private boolean boatPlaced;
    private Tirage _tirageCase;
    private int idCaseFind;
    private int boatPlayer1;
    private int boatPlayer2;

    public JeuService(Tirage tirage) {
        boatPlaced = false;
        _tirageCase = tirage;
        boatPlayer1 = 15;
        boatPlayer2 = 15;
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
                int rndValue = _tirageCase.tirageRnd();
                if(!plateau.get(rndValue).isBoat()){
                    plateau.get(rndValue).setBoat(true);
                }else{
                    i--;
                }
            }
            for (int i =0; i<15; i++){
                int rndValue = _tirageCase.tirageRnd()+49;
                if(!plateau.get(rndValue).isBoat()){
                    plateau.get(rndValue).setBoat(true);
                }else{
                    i--;
                }
            }
            boatPlaced = true;
        }
    }

    public boolean verifshoot (int x , int y){
        boolean result = false;
        Case caseTir = new Case(x,y);
        caseTir.setBoat(true);
        int idCase = plateau.indexOf(caseTir);
        if(idCase!= -1){
            idCaseFind = idCase;
            result = true;
        }
        return  result;
    }

    public void shoot (int x, int y,int playerTarget){
        if(verifshoot(x,y)){
            plateau.get(idCaseFind).setDiscover(true);
            plateau.get(idCaseFind).setSink(true);
            if(playerTarget == 1){
                boatPlayer1 --;
            }else{
                boatPlayer2--;
            }
        }else{
            Case caseTir = new Case(x,y);
            int idCase = plateau.indexOf(caseTir);
            plateau.get(idCase).setDiscover(true);
        }
    }

    public int verifWin(){
        int result =0;
        if(boatPlayer1 == 0){
            result = 2;
        }else if (boatPlayer2 == 0){
            result = 1;
        }
        return result;
    }
}
