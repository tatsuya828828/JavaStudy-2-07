public class Main {
	public static void main(String[] args) {
		// getRuntimeメソッドを呼び出しRuntimeインスタンスを取得することでJVMの現在のメモリ状態を取得するメソッドが使える
		// freeMemoryメソッドは残りのメモリ容量を返す
		// /1024/1024でMB単位で表示ができる
		long f = Runtime.getRuntime().freeMemory()/1024/1024;
		System.out.println("残りのメモリ:"+ f +"MB");
		// totalMemoryメソッドは、現在の総容量を表す
		long f2 = Runtime.getRuntime().totalMemory()/1024/1024;
		System.out.println("メモリの総容量:"+ f2 +"MB");
		// maxMemoryメソッドは、メモリ総容量の限界値を表す
		// 限界値とは、JVMのメモリが不足しそうな場合に、OSから追加のメモリ割り当てを受けた場合の総容量
		// OSからの追加メモリ割り当ては、必要に応じて自動的に行われる
		// しかし際限なく許すとOSや他のアプリケーションがメモリ不足に陥ってしまうため、
		// JVMには追加割り当ての限界が設定されることが一般的である
		long f3 = Runtime.getRuntime().maxMemory()/1024/1024;
		System.out.println("メモリの限界値:"+ f3 +"MB");
	}
}
