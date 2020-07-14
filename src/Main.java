
public class Main {
	public static void main(String[] args) {
		System.out.println("異常終了します");
		// exitメソッドを呼ぶとその場でプログラムが終了する
		// exitにはint型の引数を与えることができ、この数値がプログラムの終了コードとしてOSに報告される
		// 多くのOSでは、0は正常終了、0以外は異常終了を意味する
		System.exit(1);
		System.out.println("ここは表示されません");
	}
}
