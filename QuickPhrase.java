import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.TreeMap;

/**
 * Fcitx输入法的Emoji的快速短语
 * <p>
 * 网址：https://unicode.org/emoji/charts/full-emoji-list.html
 *
 * @author zenuo
 * @date 2019/05/28
 */
public class QuickPhrase {

    public static void main(String[] args) throws IOException {
        // 获取映射
        final Map<String, String> emojiMap = getEmojiMap();
        // 构建内容
        final String content = buildContent(emojiMap);
        // 写入文件
        Files.write(Paths.get("./QuickPhrase.mb"), content.getBytes(),
                StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE);
    }

    private static String buildContent(Map<String, String> emojiMap) {
        // 字符串构建器
        final StringBuilder stringBuilder = new StringBuilder();
        // 遍历映射
        emojiMap.forEach((chars, name) -> stringBuilder.append(name.replaceAll(" ", "."))
                .append("\t\t")
                .append(chars)
                .append("\r\n"));
        // 构建
        return stringBuilder.toString();
    }

    private static Map<String, String> getEmojiMap() throws IOException {
        //创建映射
        final Map<String, String> map = new TreeMap<>();
        // 从文件加载，您也可以从URL加载
        final Document document = Jsoup.parse(new File("./full-emoji-list.html"), "UTF-8");
        // emoji char
        final Elements rows = document.getElementsByTag("tr");
        rows.forEach(e -> {
            final Elements charsElement = e.getElementsByClass("chars");
            // 若存在chars类
            if (!charsElement.isEmpty()) {
                // 获取文字
                final String chars = charsElement.text();
                // 获取CLDR Short Name
                final String name = e.getElementsByClass("name").text();
                //置入映射
                map.put(chars, name);
            }
        });
        //返回
        return map;
    }
}
