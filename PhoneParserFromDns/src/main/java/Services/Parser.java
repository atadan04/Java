package Services;

import com.github.igorsuhorukov.phantomjs.PhantomJsDowloader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final String url = "https://www.dns-shop.ru/catalog/17a8a01d16404e77/smartfony/?p=1&order=1&groupBy=none&stock=2";
    private static final String urlOnDns = "https://www.dns-shop.ru";

    public static Document getPage() throws Exception {
//        D
        Document page = Jsoup.parse(new URL(url), 10000);


        return page;
    }

    public static Document getProductCard() {
        return null;
    }

    public static String getMaxPageToString() throws Exception {
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

    public static int getCountMaxPage() throws Exception {
        String max = Parser.getMaxPageToString();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(max);

        while (matcher.find()) {
            int maxPagesCount = Integer.parseInt(matcher.group());
            return maxPagesCount;
        }

        return 0;
    }
    public static void getPrice()
    {

    }
    public static void getName()
    {

    }

    public static void parse() throws Exception {
        Document page = getPage();
        Elements catalogItemsList = page.select("div[class=catalog-items-list view-simple]");

        Elements catalogItem = catalogItemsList.select("div[class=catalog-item]");

//        System.out.println(catalogItem);

//
                int index = 0;
                for(Element el: catalogItem) {
//                    if (index == 1) {

                        Element itemByIndex = catalogItem.get(index);

                        Elements itemName =itemByIndex.select("div[class=product-info__title-link]");//название продукта
                        String itemName1 =itemName.select("a[class=ui-link]").text();


                        Elements price = itemByIndex.select("div[class=product-price__benefits]");//цена продукта
                        Elements hrefOnItemPageHtml = itemByIndex.select("a[class=show-popover ec-price-item-link]");
                        Pattern patternHrefOnItemPage = Pattern.compile("/product/.+/.+/");
                        Matcher matcherHref = patternHrefOnItemPage.matcher(hrefOnItemPageHtml.toString());
                        String hrefOnItemPage = null;
                        while(matcherHref.find())
                        {
                            hrefOnItemPage = matcherHref.group();
                        }
                        Document pageItem = Jsoup.parse(new URL(urlOnDns),10000);
                       Elements priceOfItem =  pageItem.select("div[class=container]").select("div[class=price-item ec-price-item]");


//                        System.out.println(hrefOnItemPage);


                        //получение рейтинга
                        Elements rate = itemByIndex.select("div[class=product-info__social]").select("div[class=product-info__stat]");
                        Pattern patternRate = Pattern.compile("data-rating=\".+\"");
                        Matcher matcher = patternRate.matcher(rate.toString());
                        String dataRating = null;
                        while(matcher.find())
                        {
                             dataRating = matcher.group();
                        }
                        Pattern patternRateByNum = Pattern.compile("\\d+\\.\\d+");
                        Matcher matcher1 = patternRateByNum.matcher(dataRating);
                        String itemRating = null;
                        while (matcher1.find())
                        {
                            itemRating=matcher1.group();

                        }

//
                        System.out.println(itemName1 +" "+  itemRating + " " + priceOfItem);
//                        System.out.println(catalogItem.get(index));
//                    }
                        index++;


                }

    }
}

