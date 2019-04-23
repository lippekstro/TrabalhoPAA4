import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int qtd = Integer.parseInt(scan.nextLine());
		int cont = 0;
		
		int[][] memo = new int[1001][1001];
		
		for (int[] row : memo) { 
            Arrays.fill(row, -1); 
        } 
		
		while(cont < qtd) {
			String itemDeEntada = scan.nextLine().toUpperCase();
			char[] array = itemDeEntada.toCharArray();
			StringBuffer sb = new StringBuffer(itemDeEntada).reverse();
			char[] inverso = sb.toString().toCharArray();
			
			int resultado = lcsmemo(array, inverso, array.length, inverso.length, memo);
			System.out.println(resultado);
			cont++;
		}
		scan.close();
	}
	
	public static int lcsmemo(char[] x, char[] y, int m, int n, int[][] mem) {
		
		if(m == 0 || n == 0) {
			return 0;
		}
		if(mem[m][n] != -1) {
			return mem[m][n];
		}
		if(x[m-1] == y[n-1]) {
			mem[m][n] = 1 + lcsmemo(x, y, m-1, n-1, mem);
			return mem[m][n];
		}else {
			mem[m][n] = Math.max(lcsmemo(x, y, m, n-1, mem), lcsmemo(x, y, m-1, n, mem));
			return mem[m][n];
		}
	} 
}
