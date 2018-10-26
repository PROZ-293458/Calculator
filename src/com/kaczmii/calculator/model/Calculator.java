package com.kaczmii.calculator.model;

import java.util.List;

import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

public class Calculator 
{
	public Calculator(String[] args) 
	{
			if (args.length != 1) 
			{
				System.out.printf("Calc <expression> eg. Calc (9/2)+1.5 \n");
				return;
			}
			JShell jshell = JShell.create();
			try (jshell) 
			{
				List<SnippetEvent> events = jshell.eval(args[0]);
				for (SnippetEvent e : events) 
				{
					if (e.causeSnippet() == null) 
					{
						switch (e.status()) 
						{
						case VALID:
							if (e.value() != null) 
							{
								System.out.printf("%s = %s\n", args[0], e.value());
							}
							break;
						default: 
							System.out.printf("Error\n"); break;
						} 
					} 
				} 
			} 
	} 
}
