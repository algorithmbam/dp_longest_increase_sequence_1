import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lis {

	private static int N = 0;
	private static int[] max;
	private static int[] seq;
	private static String[] seqString;
	private static int maxResult = 0;
	private static int testCaseLength = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		testCaseLength = Integer.parseInt(br.readLine());
		String read = "";

		read = br.readLine();
		seqString = read.split(" ");
		seq = new int[testCaseLength];

		for (int z = 0; z < testCaseLength; z++) {
			seq[z] = Integer.parseInt(seqString[z]);
		}

		maxResult = dp(seq);

		System.out.println(maxResult);
	}

	public static int dp(int[] seq) {
		N = seq.length;
		max = new int[N];

		for (int x = 0; x < N; x++) {
			max[x] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					if (max[j] >= max[i]) {
						max[i] = max[j] + 1;
					}
				}
			}
			
			maxResult= Math.max(maxResult, max[i]);
			
		}
		
		return maxResult;
		
		/* Wrong
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					if (max[j] >= max[i]) {
						max[i] = max[j] + 1;
						maxResult= Math.max(maxResult, max[i]); // 이부분에서 max 체크하면 틀림, 이유확인 필요
					}
				}
			}
		}
		
		return maxResult;
		*/
		
		/* Correct
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					if (max[j] >= max[i]) {
						max[i] = max[j] + 1;
					}
				}
			}
		}
		
		for (int i = 0; i < max.length; ++i) {
			maxResult = Math.max(maxResult, max[i]);
		}
		
		return maxResult;
		*/
		
		/* Wrong
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					if (max[j] >= max[i]) {
						max[i] = max[j] + 1;
						if (max[i] > maxResult) { // 이부분이 틀린듯, for 안돌리려고 여기서 최대값 구한건데 틀린 이유가 뭘까
							maxResult = max[i];
						}
					}
				}
			}
		}
		
		return maxResult;
		*/
		
		/* Correct
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					max[i] = Math.max(max[j] + 1, max[i]);
				}
			}
		}

		for (int i = 0; i < max.length; ++i) {
			maxResult = Math.max(maxResult, max[i]);
		}
		
		return maxResult;
		*/
	}

}