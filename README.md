# DBTools

SpringBoot,Hibernate,JPAを用いたMavenプロジェクト専用ツールです。

第一版はPostgreSQLのみの対応になります。

テーブルが作成の上、Entity,Object,Repository層のJavaコードを作成する機能を実装しました。

## 画面紹介

####　Main画面

<img src="img\mainView.png" alt="mainView" style="zoom:100%;" />

#### DB情報編集

DBアイコンを押してから、この画面が出ます

<img src="img\dbInfoEdit.png" alt="dbInfoEdit" style="zoom:120%;" />

保存して、入力した項目をローカル保存し、Main画面に戻ります

#### 保存先

Path選択ボタンを押して、プロジェクトのPathを選択する

<img src="img\fileChoose.png" alt="fileChoose" style="zoom:100%;" />

Path保存ボタンを押したらPathをローカルに保存する

<img src="img\reflesh.jpg" alt="reflesh" style="zoom:100%;" />このボタンを押してたらローカルデータをDBに接続するテストを行います。

Message欄に結果を表示する

操作欄にコード作成する。

#### 作成したコード

Entity層のコードの一覧

<img src="img\showCode.png" alt="showCode" style="zoom:100%;" />

開いてみたら

<img src="img\javaCode.png" alt="javaCode" style="zoom:100%;" />

## 後ろ書き

個人専用のツールですので、ご参考になれればと思います。

Apache velocityのテンプレートエンジンを使用しましたので、間違いがあったらぜひ遠慮なくご指摘ください。

ここまでお読み頂いてありがとうございます。