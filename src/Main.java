import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<String> edges = new ArrayList<>();
    edges.add("12");
    edges.add("15");
    edges.add("13");
    edges.add("42");
    edges.add("52");
    edges.add("54");
    UndirectedGraph graph = new UndirectedGraph(5, edges);

    System.out.println("Список смежности: ");
    System.out.println(graph.getVertexMap());
    System.out.println("Матрица смежности: ");
    System.out.println(graph.getVertexList());
    System.out.println("Матрица инцидентности: ");
    System.out.println(graph.getEdgesArray());
  }
}
