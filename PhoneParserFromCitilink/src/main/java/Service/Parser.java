package Service;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static  String url = "https://www.citilink.ru/catalog/mobile/smartfony/?&p=";
    public static int numPage = 1;
    public static Document getPage(int numPage) throws IOException {


            Document page = Jsoup.parse(new URL(url+String.valueOf(numPage)), 10000);

            return page;


    }

    public static int getLastPage() throws IOException {
        Document page = Parser.getPage(1);
        String lastPage = page.select("div[class=page_listing]").select("li[class=last]").select("a[class=other-page]").last().text();
        Integer lastPageInt = Integer.parseInt(lastPage);

        return lastPageInt;
    }

    public static void parse() throws IOException {
        while(numPage<=getLastPage()){
        Document page = Parser.getPage(numPage++);
//        Elements itemsList = page.select("div[class=block_data__gtm-js block_data__pageevents-js listing_block_data__pageevents-js]");
        Elements itemsList = page.select("div[class=js--subcategory-product-item subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product]");
        int index = 0;
        for (Element el : itemsList) {
//            if (index ==0) {
            Element itemByIndex = itemsList.get(index);
//                Elements phone = itemByIndex.select("div.subcategory-product-item ");
//                Elements a = itemByIndex.select("div[class=js--subcategory-product-item subcategory-product-item product_data__gtm-js  product_data__pageevents-js ddl_product]");
            Elements productNameAndInfoBlock = itemByIndex.select("div[class=product_name cms_item_panel subcategory-product-item__info]");
            Elements productNameBlock = productNameAndInfoBlock.select("span[class=h3]");
            String productName = productNameBlock.text();  //получение строкового значения названия продукта


            Elements priceBlock = itemByIndex.select("span[class=subcategory-product-item__price subcategory-product-item__price_standart]").select("ins[class=subcategory-product-item__price-num]");//price
            String price = priceBlock.text();//получение строкового значения цены продукта
            Elements urlsOnImageAndPagePhone = itemByIndex.select("div[class=image subcategory-product-item__image]");

            Elements urlOnImageBlock = urlsOnImageAndPagePhone.select("div[class=wrap-img]").select("img[class=lazyloaded]");
            Elements urlOnItemBlock = urlsOnImageAndPagePhone.select("a[class=link_no-border]");
            Pattern patternHrefOnItem = Pattern.compile("\"https?://www\\.citilink\\.ru/.+/\"");//ссылка на страницу со смартфоном
            Matcher matcher = patternHrefOnItem.matcher(urlOnItemBlock.toString());
            String urlOnItem = null;
            while (matcher.find()) {
                urlOnItem = matcher.group();
            }
            Pattern patternUrlOnImage = Pattern.compile("\"https?://items\\.s1\\.citilink\\.ru/.+(\\.jpg|\\.jpeg|\\.png)\"");//https://items.s1.citilink.ru/1134243_v01_s.jpg
            Matcher matcherUrlOnImage = patternUrlOnImage.matcher(urlOnItemBlock.toString());
            String urlOnImage = null;
            while (matcherUrlOnImage.find()) {

                urlOnImage = matcherUrlOnImage.group();
            }

            System.out.println(productName + " Цена: " + price + " Ссылка на товар: " + urlOnItem + " Ссылка на изображение: " + urlOnImage);


//                System.out.println(productNameBlock);
//            }
            index++;
            }
        }
    }

}
