package ColorMapofUS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {
	
	private static final Iterable<Node> EMPTY_SET = null;
	HashMap<Node, List<Node>> adjNodes;

	
	public UndirectedGraph() {
		adjNodes = new HashMap<Node, List<Node>>();
	}
	
	

	
	
//	void addNode(String state) {
//		adjNodes.putIfAbsent(new Node(state), new ArrayList<>());
//	}
//	
//	void addEdge(String state1, String state2) {
//		Node n1 = new Node(state1);
//		Node n2 = new Node(state2);
//			adjNodes.get(n1).add(n2);
//			adjNodes.get(n2).add(n1);
//		
//		
//	}
	
//	List<Node> getadjNodes(String state) {
//		return adjNodes.get(new Node(state));
//	}
	
	void printGraph() {
		System.out.println();
		
	}
}
