import java.util.ArrayList;
import java.util.HashMap;

public class DepthFirstSearch2 {
    public static void main(String[] args) {
        System.out.println("Welcome to Online IDE!! Happy Coding :)");

        HashMap<String, String[]> graph = new HashMap<String, String[]>();
        ArrayList<String> visted = new ArrayList<String>();
        String start = "a";
        graph.put("a", new String[] {"c","b"});
        graph.put("b", new String[] {"d"});
        graph.put("c", new String[] {"e"});
        graph.put("d", new String[] {"f"});
        graph.put("e", new String[] {});
        graph.put("f", new String[] {});

        System.out.println(graph);

        dfs(graph, start, visted);
    }


    public static void dfs(HashMap<String, String[]> graph, String start, ArrayList<String> visted){
        System.out.println(start);
        for(String neighbor:graph.get(start)){
            dfs(graph, neighbor, visted);
        }

    }
}

