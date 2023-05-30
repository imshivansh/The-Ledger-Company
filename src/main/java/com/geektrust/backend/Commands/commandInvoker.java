package com.geektrust.backend.Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class commandInvoker {
    private Map<String,Icommand>commandMap = new HashMap<>();

    public void registerCommand(String commandName,Icommand command){
        commandMap.put(commandName,command);
    }

    public Icommand getCommand(String commandName){
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName,List<String>tokens){
        Icommand command = commandMap.get(commandName);
        if(command ==null) throw new RuntimeException("Not a Valid Command,Please Try again ");
        command.execute(tokens);
        
    }


    
}
