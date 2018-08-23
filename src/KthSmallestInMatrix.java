import java.util.*;

public class KthSmallestInMatrix{
  class Node{
    int y;
    int x;
    int value;
    Node(int y, int x, int value){
      this.y = y;
      this.x = x;
      this.value = value;
    }
  }
/* Wrong Answer

  public int kthSmallestInMatrix(int[][] matrix, int k){
    if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
      return -1;
    }
    PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>(){
      @Override
      public int compare(Node n1, Node n2){
        if(n1.value == n2.value) return 0;
        return n1.value < n2.value ? -1 : 1;
      }
    });
    Set<Integer> set = new HashSet<>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    minHeap.offer(new Node(0, 0, matrix[0][0]));
    set.add(matrix[0][0]);
    visited[0][0] = true;
    while(set.size() < k && !minHeap.isEmpty()){
      Node cur = minHeap.poll();
      if(isLegal(cur.y, cur.x + 1, visited) && isLegal(cur.y + 1, cur.x, visited)){
        if(matrix[cur.y][cur.x + 1] <= matrix[cur.y + 1][cur.x]){
          minHeap.offer(new Node(cur.y, cur.x + 1, matrix[cur.y][cur.x + 1]));
          set.add(matrix[cur.y][cur.x + 1]);
          if(set.size() >= k) return matrix[cur.y][cur.x + 1];
          minHeap.offer(new Node(cur.y + 1, cur.x, matrix[cur.y + 1][cur.x]));
          set.add(matrix[cur.y + 1][cur.x]);
        } else {
          minHeap.offer(new Node(cur.y + 1, cur.x, matrix[cur.y + 1][cur.x]));
          set.add(matrix[cur.y + 1][cur.x]);
          if(set.size() >= k) return matrix[cur.y + 1][cur.x];
          minHeap.offer(new Node(cur.y, cur.x + 1, matrix[cur.y][cur.x + 1]));
          set.add(matrix[cur.y][cur.x + 1]);
        }
      } else if(isLegal(cur.y, cur.x + 1, visited)){
          minHeap.offer(new Node(cur.y, cur.x + 1, matrix[cur.y][cur.x + 1]));
          set.add(matrix[cur.y][cur.x + 1]);
      } else if(isLegal(cur.y + 1, cur.x, visited)){
          minHeap.offer(new Node(cur.y + 1, cur.x, matrix[cur.y + 1][cur.x]));
          set.add(matrix[cur.y + 1][cur.x]);
      }
    }
    System.out.println("Cannot find the kth smallest");
    return minHeap.peek().value;
  }
*/

  public int KthSmallestInMatrix(int[][] matrix, int k){
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        return -1;
      }
      PriorityQueue<Node> pq = new PriorityQueue<>(k, new Comparator<Node>(){
        public int compare(Node n1, Node n2){
          if(n1.value == n2.value) return 0;
          return n1.value < n2.value ? -1 : 1;
        }
      });
      boolean[][] visited = new boolean[matrix.length][matrix[0].length];
      pq.offer(new Node(0, 0, matrix[0][0]));
      visited[0][0] = true;
      for(int i = 0; i < k - 1; ++i){
        Node cur = pq.poll();
        if(isLegal(cur.y, cur.x + 1, visited)){
          pq.offer(new Node(cur.y, cur.x + 1, matrix[cur.y][cur.x + 1]));
          visited[cur.y][cur.x + 1] = true;
        }
        if(isLegal(cur.y + 1, cur.x, visited)){
          pq.offer(new Node(cur.y + 1, cur.x, matrix[cur.y + 1][cur.x]));
          visited[cur.y + 1][cur.x] = true;
        }
      }
      return pq.peek().value;
  }

  private boolean isLegal(int y, int x, boolean[][] visited){
    return y >=0 && y < visited.length && x >= 0 && x < visited[0].length && !visited[y][x];
  }

}
