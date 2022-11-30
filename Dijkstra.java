import java.util.*;

public class Dijkstra
{
    // driver code
    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);

        System.out.print("Enter number of node : ");
        int noNodes = sn.nextInt();

        int[][] graph = new int[noNodes][noNodes];
        System.out.println("Enter adjacency matrix :");
        for(int i=0; i<noNodes; i++)
        {
            for(int j=0; j<noNodes;j++)
                graph[i][j] = sn.nextInt();
        }

        System.out.print("Enter source node : ");
        int sourceNode = sn.nextInt();

        dijkstraAlgorithm(graph, sourceNode);
    }

    // function which find shortest distance to every node from source node
    public static void dijkstraAlgorithm(int[][] graph, int sourceNode)
    {
        int[] distance = new int[graph.length]; // array to store least distance to every node
        int[] visited = new int[graph.length];  // array to track visited nodes

        Arrays.fill(visited, 0);                  // initializing visited array
        Arrays.fill(distance, Integer.MAX_VALUE); // initializing distance array

        distance[sourceNode] = 0;
        visited[sourceNode] = 1;

        int r = sourceNode;             // temporary source node
        int n = 1;                      // n has number of nodes visited
        while(n != graph.length)
        {
            for(int i =0; i<graph.length; i++)
            {
                if(graph[r][i] != 0 && visited[i] != 1)
                {
                    if((distance[r] + graph[r][i]) < distance[i])
                        distance[i] = distance[r] + graph[r][i];   // updating distances
                }
            }

            r = leastDistance(distance, visited);     // finding next least distance
            n++;
        }

        // printing least distances
        System.out.println("Distance from source node '" + sourceNode + "' to node ");
        for(int i=0; i<graph.length; i++)
        {
            System.out.println(i + " is " + distance[i]);
        }
    }

    // utility function to find least distance to next node
    public static int leastDistance(int[] distance, int[] visited)
    {
        int leastNo = Integer.MAX_VALUE;
        int tem =0;
        for(int i=0; i < distance.length; i++)
        {
            if(distance[i] != 0 && visited[i] != 1 && leastNo > distance[i] )
            {
                leastNo = distance[i];
                tem = i;
            }
        }
        visited[tem] = 1;    // marking new node as visited
        return tem;
    }
}
