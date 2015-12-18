import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */

/**
 * @author internous
 *
 */
public class KisoKadai1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while(true){
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String a=null;
			System.out.println("xの値を入力して下さい。");
			try {
				a = br.readLine();//xの入力フォーム
			}
			catch (IOException e1){
				e1.printStackTrace();
			}
			if (chechStringNumber(a)){//判定がtrueならば下に進むここはture判定
				int x=Integer.parseInt(a);


				System.out.println("yの値を入力して下さい。");
				try {
					a = br.readLine();//yの入力フォーム
				}
				catch (IOException e1){
					e1.printStackTrace();
				}
				if (chechStringNumber(a)){//判定がtrueなら下に進むここはtrue判定
					int y=Integer.parseInt(a);
					for(int c=1;c<=x;c++){
						for(int b=1;b<=y;b++){
							System.out.printf(" %5d",c*b);
							System.out.println();
						}
					}
				}else {System.out.println("数字を入れてください");

				}continue;
			}else {System.out.println("数字を入れてください");

			}continue;
		}
	}



			public static boolean chechStringNumber(String number){
				Pattern p = Pattern.compile("^[0-9]*$");
				Matcher m = p.matcher(number);
					return m.find();
			}

}
