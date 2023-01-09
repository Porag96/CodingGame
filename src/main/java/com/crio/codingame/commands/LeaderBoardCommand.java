package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.ScoreOrder;
import com.crio.codingame.services.IUserService;

public class LeaderBoardCommand implements ICommand{

    private final IUserService userService;
    
    public LeaderBoardCommand(IUserService userService) {
        this.userService = userService;
    }

    // Execute getAllUserScoreOrderWise method of IUserService and print the result.

    @Override
    public void execute(List<String> tokens) {
        System.out.println(userService.getAllUserScoreOrderWise(ScoreOrder.valueOf(tokens.get(1))));
    }
    
}
