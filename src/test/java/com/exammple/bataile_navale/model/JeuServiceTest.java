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
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        Case cases = new Case(1,2);
        cases.setBoat(true);
        List<Case> plateu = jeuService.getPlateau();
        Assertions.assertTrue(jeuService.getPlateau().contains(cases));

    }

    @Test
    void verifShootHitABoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        Assertions.assertTrue(jeuService.verifshoot(1,2));
    }

    @Test
    void verifShootNotHitABoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        Assertions.assertFalse(jeuService.verifshoot(1,3));
    }

    @Test
    void ShoothitABoatAndSink (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,2,1);
        Assertions.assertTrue(jeuService.getPlateau().get(1).isSink());
    }
    @Test
    void ShoothitABoatAndIsDiscoverd(){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,2,1);
        Assertions.assertTrue(jeuService.getPlateau().get(1).isDiscover());
    }

    @Test
    void ShootNotHitABoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,3,1);
        Assertions.assertFalse(jeuService.getPlateau().get(1).isSink());
    }

    @Test
    void ShootNotHitABoatAndIsDiscoverd (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,3,1);
        Assertions.assertFalse(jeuService.getPlateau().get(1).isDiscover());
    }

    @Test
    void ShootOnPlayer1BoatAndDecreaseThisBoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,2,1);
        Assertions.assertEquals(14,jeuService.getBoatPlayer1());
    }

    @Test
    void ShootOnPlayer2BoatAndDecreaseThisBoat (){
        JeuService jeuService = new JeuService(tirage);
        Mockito.when(tirage.tirageRnd()).thenReturn(1);

        jeuService.initGrille();
        jeuService.initBoat();
        jeuService.shoot(1,2,2);
        Assertions.assertEquals(14,jeuService.getBoatPlayer2());
    }

    @Test
    void WinPlayer2 (){
        JeuService jeuService = new JeuService(tirage);

        jeuService.initGrille();
        jeuService.setBoatPlayer1(0);
        Assertions.assertEquals(2,jeuService.verifWin());
    }

    @Test
    void WinPlayer1 (){
        JeuService jeuService = new JeuService(tirage);

        jeuService.initGrille();
        jeuService.setBoatPlayer2(0);
        Assertions.assertEquals(1,jeuService.verifWin());
    }

    @Test
    void testWinnerNoWinner (){
        JeuService jeuService = new JeuService(tirage);

        jeuService.initGrille();
        Assertions.assertEquals(0,jeuService.verifWin());
    }
}
