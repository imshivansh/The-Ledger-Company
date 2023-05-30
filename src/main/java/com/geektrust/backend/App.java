package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.geektrust.backend.Commands.commandInvoker;
import com.geektrust.backend.Constants.Constants;

public class App {

	public static void main(String[] args) {
		//from command Line
		//args[0] = sample_input/input.txt
	
		AppConfiguration appConfiguration = new AppConfiguration();
		commandInvoker CommandInvoker = appConfiguration.getCommandInvoker();
		String inputFile =args[Constants.ZERO];
		BufferedReader reader;
		try{
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while(line!=null){
				List<String>token =Arrays.asList(line.split(" "));
                List<String>tokens = new ArrayList<>(token);
				CommandInvoker.executeCommand(tokens.get(Constants.ZERO), tokens);
				line = reader.readLine();

			}
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		
	}


