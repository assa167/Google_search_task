package company.random.word;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public final class RandomWordExtractor {

    private RandomWordExtractor() {}

    public static String extract(String url, String id) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Element element = doc.getElementById(id);
        return element.text();
    }
}
