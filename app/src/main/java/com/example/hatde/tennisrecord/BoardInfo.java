package com.example.hatde.tennisrecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Saturn on 6/4/2015.
 */
public class BoardInfo {
    public int numSet = -5;
    public String Player1 = "Player A";
    public String Player2 = "Player B";
    public int currentPlayer = 1;
    public ArrayList<String> player1_score;
    public ArrayList<String> player2_score;
    public BoardInfo(){
        player1_score = new ArrayList<String>(Collections.nCopies(7, ""));
        player2_score = new ArrayList<String>(Collections.nCopies(7, ""));

    }
}
