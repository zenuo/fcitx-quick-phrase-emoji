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

> 截图所示Emoji为[Google Noto Color Emoji](https://www.google.com/get/noto/help/emoji/)字体；若您使用`ArchLinux`及其衍生发行版，执行`sudo pacman -Syy && sudo pacman -S noto-fonts-emoji`即可安装

![screenshot.png](./screenshot.png)

## 参考

- [Full Emoji List, v12.0](https://unicode.org/emoji/charts/full-emoji-list.html)
- [快速输入](https://fcitx-im.org/wiki/QuickPhrase/zh-hans)
- [Noto Color Emoji – Google Noto Fonts](https://www.google.com/get/noto/help/emoji/)