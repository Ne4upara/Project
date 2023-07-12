package project.utilities;

//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//public class JsoupCitiesTxt  {
//    public void jsoupCitiesTxt () throws IOException {
//        String url = "https://uk.wikipedia.org/wiki/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%BC%D1%96%D1%81%D1%82_%D0%A3%D0%BA%D1%80%D0%B0%D1%97%D0%BD%D0%B8";
//            Document doc = Jsoup.connect(url).get();
//            Element table = doc.selectFirst(".wikitable.sortable");
//            Elements rows = table.select("tr");
//
//           try (BufferedWriter writer = new BufferedWriter(new FileWriter("Citi\\src\\main\\resources\\cities.txt", StandardCharsets.UTF_8))) {
//               for (Element row : rows) {
//                   Elements cells = row.select("td");
//                   if (!cells.isEmpty()) {
//                       String city = cells.get(1).text();
//                       writer.write(city + "\n");
//                   }
//               }
//            System.out.println("Список міст було оновлено у cities.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

