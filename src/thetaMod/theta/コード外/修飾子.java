修飾子書き順

	クラス		: アクセス abstract static final strictfp
	メソッド		: アクセス abstract static final synchronized native strictfp
	フィールド	: アクセス static final transient volatile

修飾子一覧

アクセス修飾子
	１、public		: 全てのクラスからでも
	２、private		: 同じクラス内からのみ
	３、protected	: 同じパッケージ内、またはサブクラス
	４、(指定なし)		: 同じパッケージ内のみ


非アクセス修飾子
クラス修飾子

	１、final		: サブクラスを作れない
	２、abstract		: インスタンス化できず、１つ以上の抽象メソッドを持たなければいけない
	３、strictfp		: そのクラス内のすべてのメソッドと内部クラスで、浮動小数点の精度が一定であることを証明する
	
	
メソッド修飾子

	１、final		: オーバーライドを禁止する
	２、static		: インスタンスではなく、ヒープ
	３、abstract		: サブクラスでオーバーライドする必要がある
	４、synchronized	: 同時に複数のスレッドがアクセスできないようにする
	５、native		: Java以外の言語で書かれたコードを使用する
	６、strictfp		: メソッド内で浮動小数点の精度が一定であることを証明する


フィールド修飾子

	１、final		: 値を1度だけ設定できるが、変更できない
	２、static		: インスタンスではなく、ヒープ
	３、transient	: オブジェクトのシリアル化時に、このフィールドは無視される
	４、volatile		: このフィールドは常にメインメモリから読まれ、スレッド間での同期が保証される


