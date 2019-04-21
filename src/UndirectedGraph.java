import java.util.*;

public class UndirectedGraph {

  private int vertexAmount;
  private ArrayList<String> edgesList;
  private HashMap<String, List<String>> vertexMap = new HashMap<>();
  private HashMap<String, List<Integer>> vertexList = new HashMap<>();
  private HashMap<String, List<Integer>> edgesArray = new HashMap<>();

  public UndirectedGraph(int vertexAmount, ArrayList<String> edgesList) {
    this.vertexAmount = vertexAmount;
    this.edgesList = edgesList;
    System.out.println(edgesList);
    for (String edge: this.edgesList) {
      this.addEdge(edge.substring(0, 1), edge.substring(1));
    }
  }

  public void addVertex(String vertexName) {
    if (!hasVertex(vertexName)) {
      vertexMap.put(vertexName, new ArrayList<String>());

      Integer[] bytes = new Integer[vertexAmount];
      Arrays.fill(bytes, 0);
      List<Integer> list = Arrays.asList(bytes);
      vertexList.put(vertexName, list);

      Integer[] edgeBytes = new Integer[edgesList.size()];
      Arrays.fill(edgeBytes, 0);
      List<Integer> edgeList = Arrays.asList(edgeBytes);
      edgesArray.put(vertexName, edgeList);
    }
  }

  public boolean hasVertex(String vertexName) {
    return vertexMap.containsKey(vertexName);
  }

  public boolean hasEdge(String vertexName1, String vertexName2) {
    if (!hasVertex(vertexName1)) return false;
    List<String> edges = vertexMap.get(vertexName1);
    return Collections.binarySearch(edges, vertexName2) != -1;
  }

  public void addEdge(String vertexName1, String vertexName2) {
    if (!hasVertex(vertexName1)) addVertex(vertexName1);
    if (!hasVertex(vertexName2)) addVertex(vertexName2);
    List<String> edges1 = vertexMap.get(vertexName1);
    List<String> edges2 = vertexMap.get(vertexName2);
    edges1.add(vertexName2);
    edges2.add(vertexName1);
    Collections.sort(edges1);
    Collections.sort(edges2);

    List<Integer> line1 = vertexList.get(vertexName1);
    List<Integer> line2 = vertexList.get(vertexName2);
    line1.set(Integer.parseInt(vertexName2) - 1, 1);
    line2.set(Integer.parseInt(vertexName1) - 1, 1);


    List<Integer> line11 = edgesArray.get(vertexName1);
    List<Integer> line22 = edgesArray.get(vertexName2);
    line11.set(edgesList.indexOf(vertexName1 + vertexName2), 1);
    line22.set(edgesList.indexOf(vertexName1 + vertexName2), 1);
  }

  public Map<String, List<String>> getVertexMap() {
    return vertexMap;
  }

  public HashMap<String, List<Integer>> getVertexList() {
    return vertexList;
  }

  public HashMap<String, List<Integer>> getEdgesArray() {
    return edgesArray;
  }
}
