package com.example.bataile_navale.control;

import com.example.bataile_navale.model.Case;
import com.example.bataile_navale.model.JeuService;
import com.example.bataile_navale.model.Tirage;
import com.example.bataile_navale.model.TirageRndm;
import com.example.bataile_navale.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "gameServlet",value = "/game")
public class JeuServlet extends HttpServlet {
    private JeuService jeuService;
    private boolean player1Turn;
    public void init (){
       jeuService = new JeuService(new TirageRndm());
       jeuService.initGrille();
       jeuService.initBoat();
       player1Turn = true;
    }
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("type")== null){
            List<Case> plateau = jeuService.getPlateau();
            request.setAttribute("plateau",plateau);
            request.setAttribute("turn",1);
            request.getRequestDispatcher(Definition.PATH_VIEW+"GameBoard.jsp").forward(request,response);
        }else {
            jeuService.setPlateau(new ArrayList<>());
            jeuService.initGrille();
            jeuService.initBoat();
            player1Turn = true;
            List<Case> plateau = jeuService.getPlateau();
            request.setAttribute("winner",false);
            request.setAttribute("plateau",plateau);
            request.setAttribute("turn",1);
            request.getRequestDispatcher(Definition.PATH_VIEW+"GameBoard.jsp").forward(request,response);
        }
    }

    public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getParameter("x")!= null && request.getParameter("y")!= null){
            int x = Integer.parseInt(request.getParameter("x"));
            int y = Integer.parseInt(request.getParameter("y"));
            int player;

            if(player1Turn && x>5 || !player1Turn && x<6){
                if(player1Turn){
                    player = 1;
                    player1Turn = false;
                }else {
                    player = 2;
                    player1Turn = true;
                }
                jeuService.shoot(x,y,player);
                if(jeuService.verifWin() != 0){
                    request.setAttribute("winner",jeuService.verifWin());
                    request.setAttribute("turn",player);
                }
            }
            List<Case> plateau = jeuService.getPlateau();
            request.setAttribute("plateau",plateau);
            request.getRequestDispatcher(Definition.PATH_VIEW+"GameBoard.jsp").forward(request,response);
        }
    }

    public void destroy (){

    }
}
