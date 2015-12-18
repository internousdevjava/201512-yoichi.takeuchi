import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class KisoKadai2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("★数字当てゲーム！ランダムで出る\r\n　1～100の数字を当ててください。チャンスは10回!");
		int ans = new java.util.Random().nextInt(99) + 1;

		for (int i = 1; i <= 10; i++) {
			System.out.println("この下に数字(半角)をいれてENTER!");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String b = null;
			try {
				b = br.readLine();
			    } catch (IOException e) {
				e.printStackTrace();
			     }
			    if (chechStringNumber(b)) {
				int t = Integer.parseInt(b);
				if (ans == t) {
					System.out.println("正解！★おめでとうございます★");
					break;
				} else if (ans > t) {
					System.out.println("↑もっと上です。↑");
				} else {
					System.out.println("↓もっと下です。↓");
				}
			} else {
				System.out.println("半角数字にしてください！");i--;
				continue;
			}

		}
		System.out.println("ゲーム終了正解は " + ans + " でした。");

	}

	public static boolean chechStringNumber(String number) {
		Pattern p = Pattern.compile("^[0-9]*$");
		Matcher m = p.matcher(number);

		return m.find();
	}
}