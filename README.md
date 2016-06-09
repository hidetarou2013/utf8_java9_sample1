# utf8_java9_sample1

- このプロジェクトは、文字コード：UTF8
- 使用しているIDE：eclipse 4.6 Neon
- JDKのヴァージョン：JDK 9

## プロジェクトの作成
プロジェクト名：utf8_java9_sample1
JavaSE-9（Neonにて java 9 supportのプラグインを導入すれば使用可能）

## 新規ソース・フォルダの作成
src/com.example
src/com.greetings

## module-info.javaの作成

ここが、新しくJDK9 で採用された機能、及び概念
ソースの親フォルダ：src
の下にモジュールフォルダを作成する必要があるのだが、eclipseにはモジュールの仕様がまだ浸透していないので、とりあえず
ソースフォルダとして「src/com.example」を作成する必要がある。
この作り方は２つあって、

プロジェクトの作成初期段階で「新規ソース・フォルダの作成」するか、
普通のフォルダとして「src/com.example」を作成したあと、ソースフォルダー扱いに変更する方法がある。
もしくは、「新規」→「ソースフォルダー」でもできる。

プロジェクトのフォルダの構成に関しては、以下の情報を参考にしました。
リンク１）
http://d.hatena.ne.jp/torutk/20120602/p1


この中に、「module-info.java」というモジュール定義のファイルを作成する必要がある。

先ほどのリンク１の情報は、かなり初期段階の草案であり、一部記述が古くキーワード等も間違っていましたが、
eclipseにて補完がききますので、大丈夫でしょう。

## ソースの作成

このプロジェクトの構成は元ネタとして以下のものをベースに使っています。
リンク２）
http://openjdk.java.net/projects/jigsaw/quick-start

また、この方の日本語解説も参考にしました。
リンク３）
http://qiita.com/hashiwa/items/9ae1f8ad8d2e8f916664


org.astro
を
com.example
として読み替えて作成しました。

また、このリンク２は、通常の JDK9を使ったCUIプログラムでの例あり、eclipseでのプロジェクト構成に関しては一切助言がありません。
そのためここでは、eclipseを使ったJDK9のプロジェクトの作成方法をここで調査するのが最初の目的になります。

## Git

まず、GitHubで対象のリポジトリを作成するところから始める。

page
https://github.com/hidetarou2013/utf8_java9_sample1

git clone path
git@github.com:hidetarou2013/utf8_java9_sample1.git


コマンドでローカルリポジトリを作成するならば、

```
git init
```

edit .git/config

```
git remote add origin git@github.com:hidetarou2013/utf8_java9_sample1.git
```


今回は、eclipseにてやってしまうので、

subversion管理を切断し
Git管理スタートし、
まずは、ローカルリポジトリをeclipseのworkspaceとは別に作成しておき
そこに自動で移動されるので、
edit .git/config　し
PUSHする

