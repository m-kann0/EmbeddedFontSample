# 組み込みフォントサンプル

アプリに組み込んだフォントで表示するサンプルです。

## ネイティブ

~~参考：[InflationX/Calligraphy](https://github.com/InflationX/Calligraphy)~~

参考：[Fonts in XML  |  Android Developers](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml)

## WebView

~~参考：[ハイブリッドアプリでWebフォントをダウンロードせずアプリに梱包して使う方法](https://qiita.com/alt_yamamoto/items/4c95175c529f4a6174e8)~~

`app/src/main/res/font`配下にttfファイルを配置し、

cssで

```css
@font-face {
    font-family: 'Rounded M plus';
    src: url('file:///android_res/font/rounded_mplus_1c_regular.ttf');
    font-weight: normal;
}
```

とするだけで、`font-family: 'Rounded M plus'`で組み込みフォントを使用できた。

