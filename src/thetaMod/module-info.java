module thetaMod {
	exports theta;
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	//exports pack.name;//公開するパッケージ。明示する。他のモジュールで使える様になる。
						//javaFxを使うときに指定するのは(javacの--add-modules)、javafx.controlsモジュールだけなのは、
						//このモジュールが窓口になっているから。
	//requires atherModule;//公開された他のモジュールを使用。インポートみたい
	//requires transitive transModule;//当該モジュールを使用する他のモジュールも、transModuleを使える。
}