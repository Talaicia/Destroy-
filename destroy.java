
/* 
Programming Assignment 3: Destory Connectivity 
Written By: Talaicia Isaacs
Professor Guha
COP 3503C
Feb 22, 2022
*/

import java.io.File;
import java.util.*;


public class destroy {

    public static int n; //computers in the network
	public static int m; //connectivities between those computers
    public static int d; //connectivities being destroyed
	public static int [][] con; //connects
	public static int [] destroycon; // destroy connects
	public static long [] value; // output values
	public static long k = 0; //index for values

    public static void main(String[] args) throws Exception  
    {
        //Scanner stdin = new Scanner(System.in);
		Scanner stdin = new Scanner(new File("destroy_sample_01.in"));

		//read in info
        n = stdin.nextInt();
		m = stdin.nextInt();
        d = stdin.nextInt();

		//read n & m
		disjointset set = new disjointset(n);
		con = new int[m + 1][2];
		value = new long[d + 1];

		for(int i = 1; i < m + 1; i++)
		{
			for(int j = 0; j < 2; j++)
			{
				con[i][j] = stdin.nextInt();
			}
		}

		//read d
		destroycon = new int[d];
		for(int i = 0; i < d; i++)
		{
			destroycon[i] = stdin.nextInt();
		}

	    //assemble sets
		for(long i = 1; i < m + 1; i++) {	
			if ( search(i) ) 
			{
				continue;
			}
			set.union(con[(int) i][0], con[(int) i][1]);

		}

		
		value[(int)k++] =(int)set.sum;

		
	    // skip connections
		for(long i = d - 1; i >= 0; i--)
		{
			int j = destroycon[(int) i];
			
			set.union(con[(int)j][0], con[(int)j][1]);

			value[(int)k++] =(int)set.sum;
			
		}	    

		//print output holding numbers 
		for(int i = value.length - 1; i >= 0; i--) {
			System.out.println(value[i]);
		}


        
    }//end of main
	


	public static boolean search(long id) {
		
		for(long i=0; i < d; i++) {
			if(id == destroycon[(int) i])
				return true;
		}
		return false;
	}

    
}//end of class

class disjointset {
	public int num;
	public int [] parent;
	public long [] size;
	public long sum;

	
	// Makes an initial disjoint set of n different sets.
	public disjointset(int n) {
		num = n;

		size = new long[num + 1];
		parent = new int[num + 1];
		for (int i = 1; i <= num; i++)
		{
			parent[i] = i;
			size[i] = 1;

		}
		sum = num;
			
    
	}
	
	// Returns the root of the tree storing v.
	public int find(int v) {
	
	
		if (parent[v] == v) return v;
		
		// Otherwise recursively find and update my parent to be the root!
		return parent[v] = find(parent[v]);
	}
	

	public boolean union(int u, int v) {

	
		// Get roots.
		u = find(u);
		v = find(v);
		
		// Together already.
		if (u == v) return false;
		
		// Attach v to u and return.
		parent[v] = u;

		sum -= size[u] * size[u];
		sum -= size[v] * size[v];
		sum += (size[u] + size[v]) * (size[u] + size[v]);

		size[u] += size[v];

		size[v] = 0;

		return true;
	}


}