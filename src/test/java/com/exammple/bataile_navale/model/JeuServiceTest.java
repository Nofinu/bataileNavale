package com.exammple.bataile_navale.model;

import com.example.bataile_navale.model.Case;
import com.example.bataile_navale.model.JeuService;
import com.example.bataile_navale.model.Tirage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
@ExtendWith(MockitoExtension.class)
public class JeuServiceTest {

    @Mock
    private Tirage tirage;

    @Test
    void generationGrille10x10 (){
        JeuService jeuService = new JeuService(tirage);
        jeuService.initGrille();
        Assertions.assertEquals(100,jeuService.getPlateau().size());
    }

    @Test
    void generationBoatOnGrille (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd(0,50)).thenReturn(1);

        Mockito.when(tirage.tirageRnd(50,100)).thenReturn(51);

        jeuService.initGrille();
        jeuService.initBoat();
        Case cases = new Case(0,0);
        cases.setBoat(true);
        List<Case> plateu = jeuService.getPlateau();
        Assertions.assertTrue(jeuService.getPlateau().contains(cases));

    }

    @Test
    void verifShootHitABoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd(0,50)).thenReturn(1);

        Mockito.when(tirage.tirageRnd(50,100)).thenReturn(51);

        jeuService.initGrille();
        jeuService.initBoat();
        Assertions.assertTrue(jeuService.Verifshoot(1,2));
    }

    @Test
    void verifShootNotHitABoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd(0,50)).thenReturn(1);

        Mockito.when(tirage.tirageRnd(50,100)).thenReturn(51);

        jeuService.initGrille();
        jeuService.initBoat();
        Assertions.assertFalse(jeuService.Verifshoot(1,3));
    }
}
