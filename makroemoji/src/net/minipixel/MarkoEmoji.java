package net.minipixel;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class MarkoEmoji {
	
	public static boolean activated = false, run = false;
	public static int lenght;
	public static String input;
	public static Robot robot;
	
	public static void main(String[] args) {
		
		while(true) {
			
			try {
				GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);
		        
				run = true;
				
		        keyboardHook.addKeyListener(new GlobalKeyAdapter() {
					@Override public void keyPressed(GlobalKeyEvent event) {
						System.out.println(event);
						
						if(event.getVirtualKeyCode() ==27) {
							keyboardHook.shutdownHook();
							System.exit(1);
						}
						
						logging(event.getVirtualKeyCode());
					}
					@Override public void keyReleased(GlobalKeyEvent event) {
					}
				});
		        
		        Thread.sleep(128);

		        /* Simulate a mouse click
		        robot.mousePress(InputEvent.BUTTON1_MASK);
		        robot.mouseRelease(InputEvent.BUTTON1_MASK);

		        // Simulate a key press
		        robot.keyPress(KeyEvent.VK_A);
		        robot.keyRelease(KeyEvent.VK_A);
		        
		        Thread.sleep(1000);
		        
		        robot.keyPress(KeyEvent.VK_BACK_SPACE);*/

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void logging(int event) {
		try {
			robot = new Robot();
			if(activated == true) {
				if(event == 190) {
					while(lenght > 0) {
						robot.keyPress(KeyEvent.VK_BACK_SPACE);
						robot.keyRelease(KeyEvent.VK_BACK_SPACE);
						lenght--;
					}
					compare(input);
					activated = false;
					System.out.println("OFF");
				} else {
					if(event != 8) {
						lenght++;
						input += String.valueOf(Character.toChars(event));
						System.out.println("input" + input);
						System.out.println("lenght" + lenght);
					}
				}
			} else {
				if(event == 190) {
					activated = true;
					lenght = 2;
					input = "";
					System.out.println("ON");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void compare(String input) {
		System.out.println(input);
		try {
			if(input.equalsIgnoreCase("a")) {
				System.out.println("WORKING");
		        robot.keyPress(KeyEvent.VK_H);
		        robot.keyRelease(KeyEvent.VK_H);
		        robot.keyPress(KeyEvent.VK_A);
		        robot.keyRelease(KeyEvent.VK_A);
		        robot.keyPress(KeyEvent.VK_L);
		        robot.keyRelease(KeyEvent.VK_L);
		        robot.keyPress(KeyEvent.VK_L);
		        robot.keyRelease(KeyEvent.VK_L);
		        robot.keyPress(KeyEvent.VK_O);
		        robot.keyRelease(KeyEvent.VK_O);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}