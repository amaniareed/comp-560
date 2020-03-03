package ColorMapofUS;

import java.awt.Color;
import  java.awt.color.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	
	String state;
	String color;
	
	

	public Node(String state, String color) {
		this.state = state;
		this.color = color;
	}
	
	
     public String getState() {
		return state;
	}
	
	public String getColor() {
		return color;
	}
	
public String toString() {
		return state;
	}


}
