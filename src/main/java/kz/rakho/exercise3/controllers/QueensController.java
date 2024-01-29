package kz.rakho.exercise3.controllers;

import kz.rakho.exercise3.services.QueensSolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queens")
public class QueensController {

    @GetMapping("/positions")
    public List<int[]> findAllSolutions(@RequestParam(name = "size", defaultValue = "8") int size) {
        return QueensSolver.findAllSolutions(size);
    }
}