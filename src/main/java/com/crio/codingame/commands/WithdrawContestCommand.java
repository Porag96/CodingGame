package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.services.IUserService;

public class WithdrawContestCommand implements ICommand{

    private final IUserService userService;
    
    public WithdrawContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // Execute withdrawContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["WITHDRAW_CONTEST","3","Joey"]

    @Override
    public void execute(List<String> tokens) {
        try {
            System.out.println(userService.withdrawContest(tokens.get(1), tokens.get(2)));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
