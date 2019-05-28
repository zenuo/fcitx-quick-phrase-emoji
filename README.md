# fcitx-quick-phrase-emoji

Fcitx的Emoji快速短语

```bash
# 下载HTML文件
$ curl -O -L https://unicode.org/emoji/charts/full-emoji-list.html
# 下载Jsoup
$ curl -O -L http://central.maven.org/maven2/org/jsoup/jsoup/1.12.1/jsoup-1.12.1.jar
# 编译
$ javac -classpath ./jsoup-1.12.1.jar QuickPhrase.java
# 运行
$ java -classpath ./jsoup-1.12.1.jar:. QuickPhrase
```

## 使用

```bash
# 追加文件
$ cat QuickPhrase.mb >> ~/.config/fcitx/data/QuickPhrase.mb
# 重启fcitx
$ fcitx -r
```

## 截图

![screenshot.png](./screenshot.png)