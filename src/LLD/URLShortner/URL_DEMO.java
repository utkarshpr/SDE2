package LLD.URLShortner;

import java.util.HashMap;
import java.util.HashSet;

public class URL_DEMO {
    private final HashMap<String,URL> shortUrlToMapping=new HashMap<>();
    public static void main(String[] args) {
        UrlSHortner shortener = new UrlSHortner();

        String[] longUrls = {
                "https://example.com/one",
                "https://example.com/two",
                "https://example.com/three",
                "https://example.com/one",  // duplicate
        };

        HashSet<String> generatedShorts = new HashSet<>();

        for (String longUrl : longUrls) {
            String shortUrl = shortener.makeUrlSHOrt(longUrl);
            System.out.println("Original: " + longUrl);
            System.out.println("Shortened: " + shortUrl);
            String code = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);

            if (generatedShorts.contains(code)) {
                System.out.println("⚠️ Collision Detected for short code: " + code);
            } else {
                generatedShorts.add(code);
            }
            System.out.println();
        }

        // Print the database entries
        System.out.println("== Stored Short URLs ==");
        for (String shortCode : Database.getAllKeys()) {
            URL url = new Database().findByShortUrl(shortCode);
            System.out.println(shortCode + " => " + url.getLongURL());
        }
    }
}