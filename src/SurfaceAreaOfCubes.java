public class SurfaceAreaOfCubes {
  public int surfaceArea(int[][] grid) {
      int[] verMax = new int[grid.length];
      int[] verMin = new int[grid.length];
      int[] horMax = new int[grid[0].length];
      int[] horMin = new int[grid[0].length];
      int r = grid.length, c = grid[0].length;
      int count = 0;
      for(int y = 0; y < r; y++){
        verMin[y] = Integer.MAX_VALUE;
        horMin[y] = Integer.MAX_VALUE;
      }
      for(int y = 0; y < r; y++){
        for(int x = 0; x < c; x++){
          horMax[x] = Math.max(horMax[x], grid[y][x]);
          horMin[x] = Math.min(horMin[x], grid[y][x]);
          if(grid[y][x] == 0) count++;
        }
      }
      for(int x = 0; x < c; x++){
        for(int y = 0; y < r; y++){
          verMax[y] = Math.max(verMax[y], grid[y][x]);
          verMin[y] = Math.min(verMin[y], grid[y][x]);
        }
      }
      int sum = 2 * (r * c - count);
      for(int x = 0; x < c; x++){
        sum += 2 * horMax[x];
        sum += (2 * horMax[x] - 2 * horMin[x]);
      }
      for(int y = 0; y < c; y++){
        sum += 2 * verMax[y];
        sum += (2 * verMax[y] - 2 * verMin[y]);
      }
      return sum;
  }
}
