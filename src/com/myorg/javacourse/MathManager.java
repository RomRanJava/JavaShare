package com.myorg.javacourse;

public class MathManager {
	
	static int radius, base, exp, hypotenuse, angleB;
		
		public MathManager (int radiusSource, int baseSource, int expSource, int angleSource, int hypotenuseSource){
			
			radius = radiusSource;
			base = baseSource;
			exp = expSource;
			hypotenuse = hypotenuseSource; 
			angleB = angleSource;
		}
		
		
		private static double calcCircleArea(){
			return Math.pow(radius, 2)*Math.PI;
		}
		
		private static double lengthOfOppositeTriangle(){
			return Math.sin(Math.toRadians(angleB))*hypotenuse;
		}
		
		private static double calcPower(){
			return Math.pow(base, exp);
		}
		
		public static String getResults(){
			
			String line1 = new String("calculation 1: Area of circle with radius " + radius + " is: " + MathManager.calcCircleArea() + " square­cm.");
			String line2 = new String("calculation 2: Length of opposite where angle B is " + angleB + " degrees and Hypotenuse length is " + hypotenuse + " cm is: " + MathManager.lengthOfOppositeTriangle() + " cm.");
			String line3 = new String("calculation 3:: Power of " + base + " with exp of " + exp + " is " + MathManager.calcPower() + ".");
			
			String resultStr = line1 + "<br><br>" + line2 + "<br><br>" + line3;			
			
			return resultStr;
		}
}