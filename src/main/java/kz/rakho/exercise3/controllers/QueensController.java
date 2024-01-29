package kz.rakho.exercise3.controllers;


import java.util.ArrayList;
import java.util.Random;

import kz.rakho.exercise3.models.QueenPosition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/queens")
class QueensController {

    @PostMapping("/place")
    public QueenPosition[] placeQueens(@RequestBody QueenPosition queenPosition) {
        int n = 8;
        QueenPosition[] queens = new QueenPosition[8];
        queens[0] = queenPosition;
        setOtherQueensPosition(queens);
        return queens;
    }

    private void setOtherQueensPosition(QueenPosition[] queens){
        Random random = new Random();
        for (int i = 1; i < queens.length;){
            queens[i] = new QueenPosition(random.nextInt(8), random.nextInt(8));
            boolean isDupExist = false;
            for (int j = 0; j < i; j ++){
                if (queens[j].getCol() == queens[i].getCol() && queens[j].getRow() == queens[i].getRow() ){
                    isDupExist = true;
                    break;
                }
            }
            if (!isDupExist)
                i++;
        }
    }

}
