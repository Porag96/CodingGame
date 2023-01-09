package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.services.IUserService;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    
    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        try {
            System.out.println(userService.attendContest(tokens.get(1), tokens.get(2)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
