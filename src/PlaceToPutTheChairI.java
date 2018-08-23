import java.util.*;
public class PlaceToPutTheChairI {
  public static final char EQ = 'E';
  public static final char OB = 'O';
  class Node {
    int x;
    int y;
    List<Node> neighbors;
    Node(int x, int y){
      this.x = x;
      this.y = y;
      this.neighbors = new ArrayList<Node>();
    }
    void getNe(){
      int[] a = {0, 0, -1, 1};
      int[] b = {-1, 1, 0, 0};
      for(int i = 0; i < 4; ++i){
        neighbors.add(new Node(x + a[i], y + b[i]));
      }
    }
  }
  public List<Integer> putChair(char[][] gym) {
  // Write your solution here
    int M = gym.length, N = gym[0].length;
    int[][] cost = new int[M][N];
    List<Node> EQList = new ArrayList<>();
    for(int i = 0; i < M; ++i){
      for(int j = 0; j < N; ++j){
        if(gym[i][j] == EQ){
          EQList.add(new Node(j, i));
        }
      }
    }
    for(Node n: EQList){
      if(!addCost(EQList, gym, cost, new Node(n.x, n.y))){
        return Arrays.asList(-1, -1);
      }
    }
    // new GraphTestCasesMain().print2DMatrix(cost);
    Node min = new Node(-1, -1);
    boolean first = true;
    for(int i = 0; i < M; ++i){
      for(int j = 0; j < N; ++j){
        if(gym[i][j] == 'C'){
          if(first || cost[min.y][min.x] > cost[i][j]){
            min.y = i;
            min.x = j;
            first = false;
          }
        }
      }
    }
    return Arrays.asList(min.y, min.x);
  }

  public boolean addCost(List<Node> EQList, char[][] gym, int[][] cost, Node n){
    boolean[][] visited = new boolean[gym.length][gym[0].length];
    Queue<Node> queue = new LinkedList<>();
    queue.offer(n);
    visited[n.y][n.x] = true;
    int sum = 1;
    while(!queue.isEmpty()){
      int size = queue.size();
      for(int l = 0; l < size; ++l) {
        Node cur = queue.poll();
        cur.getNe();
        for (Node ne : cur.neighbors) {
          if (isLegal(ne, visited) && gym[ne.y][ne.x] != OB) {
            visited[ne.y][ne.x] = true;
            cost[ne.y][ne.x] += sum;
            queue.offer(ne);
          }
        }
      }
      sum++;
    }
    for(Node eq : EQList){
      // new GraphTestCasesMain().print2DMatrix(visited);
      if(!visited[eq.y][eq.x]) return false;
    }
    return true;
  }

  public boolean isLegal(Node n, boolean[][] visited){
    return n.y > -1 && n.y < visited.length && n.x > -1 && n.x < visited[0].length && !visited[n.y][n.x];
  }
}
