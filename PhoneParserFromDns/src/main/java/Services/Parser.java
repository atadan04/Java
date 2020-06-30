package Services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String url = "https://www.dns-shop.ru/catalog/17a8a01d16404e77/smartfony/?p=1&order=1&groupBy=none&stock=2";

    public static Document getPage() throws IOException {
        Document page = Jsoup.parse(new URL(url), 10000);
        return page;
    }

    public static Document getProductCard() {
        return null;
    }

    public static String getMaxPageToString() throws IOException {
        Document page = Parser.getPage();
        Element lastPageNumber = null;
        Elements elementsPages = page.select("ul[class=pagination-widget__pages]");
        int index = 0;
        Element valueLine = elementsPages.get(index);
        for (Element el : valueLine.select("li")) {
            index++;
            if (index == 12) {
                lastPageNumber = el;

                return el.toString();
            }
        }
        return null;
    }

    public static int getCountMaxPage() throws IOException {
        String max = Parser.getMaxPageToString();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(max);

        while (matcher.find()) {
            int maxPagesCount = Integer.parseInt(matcher.group());
            return maxPagesCount;
        }

        return 0;
    }

    public static void parse() throws IOException {
        Document page = getPage();
        Elements catalogItemsList = page.select("div[class=catalog-items-list view-simple]");

        Elements catalogItem = catalogItemsList.select("div[class=catalog-item]");

//        System.out.println(catalogItem);

//
                int index = 0;
                for(Element el: catalogItem) {
                    if (index == 0) {

                        System.out.println(catalogItem.get(index));
                    }
                        index++;


                }

    }
}

