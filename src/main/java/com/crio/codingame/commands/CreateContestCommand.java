package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.entities.Contest;
import com.crio.codingame.entities.Level;
import com.crio.codingame.services.IContestService;

public class CreateContestCommand implements ICommand{

    private final IContestService contestService;

    public CreateContestCommand(IContestService contestService) {
        this.contestService = contestService;
    }


    @Override
    public void execute(List<String> tokens) {
        try {
            Contest contest;
            if(tokens.size() > 4){
                contest = contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)), tokens.get(3), Integer.parseInt(tokens.get(4)));
            }   
            else{
                contest = contestService.create(tokens.get(1), Level.valueOf(tokens.get(2)), tokens.get(3), null);
            }
            System.out.println(contest);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
