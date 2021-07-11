import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        List<int[]>[] arr= new ArrayList[n];
        for(int i=0;i< n;i++) arr[i]= new ArrayList<>();
        UnionFind dsu= new UnionFind(n);
        for(int i=0;i<m;i++) {
            st= new StringTokenizer(br.readLine());
            int u= Integer.parseInt(st.nextToken())-1;
            int v= Integer.parseInt(st.nextToken())-1;
            int cost= Integer.parseInt(st.nextToken());

            arr[u].add(new int[]{v, cost});
            arr[v].add(new int[]{u, cost});
            dsu.union(u, v);
        }

        long ans= Long.MAX_VALUE;
        for(int[] i: arr[n-1]) {
            if(dsu.isConnected(i[0], n-1)) ans= Math.min(ans, i[1]);
        }

        if(ans== Long.MAX_VALUE) out.println("NOT POSSIBLE");
        else out.println(ans);
        out.flush();
    }

    static class UnionFind {
        int[] rank;
        int[] par;

        public UnionFind(int n) {
            rank = new int[n];
            par = new int[n];

            for (int i = 0; i < n; i++)
                par[i] = i;
        }

        public void union(int a, int b) {
            while (par[a] != a) a = par[a];
            while (par[b] != b) b = par[b];

            if (rank[a] > rank[b]) par[b] = a;
            else if (rank[a] < rank[b]) par[a] = b;
            else {
                par[b] = a;
                rank[a]++;
            }
        }

        public Boolean isConnected(int a, int b) {
            int tempA = a, tempB = b;
            while (par[a] != a) a = par[a];

            while (par[tempA] != tempA) {
                int temp = tempA;
                tempA = par[tempA];
                par[temp] = a;
            }

            while (par[b] != b) b = par[b];

            while (par[tempB] != tempB) {
                int temp = tempB;
                tempB = par[tempB];
                par[temp] = b;
            }

            return b == a;
        }
    }

}