package LLD.URLShortner;

import java.util.HashMap;
import java.util.HashSet;

public class Database {
    private static HashMap<String, URL> shortUrlToMapping = new HashMap<>();
    private static final HashMap<String, URL> longUrlToMapping = new HashMap<>();

    public URL findByShortUrl(String shortUrl) {
       // System.out.println(shortUrlToMapping);
        return shortUrlToMapping.get(shortUrl);
    }

    public void save(URL urlMapping) {
        shortUrlToMapping.put(urlMapping.getShortURL(), urlMapping);
        longUrlToMapping.put(urlMapping.getLongURL(), urlMapping);
       // System.out.println(shortUrlToMapping);
    }
    public static HashSet<String> getAllKeys() {
        return new HashSet<>(shortUrlToMapping.keySet());
    }
    public URL findByLongUrl(String longUrl) {
        return longUrlToMapping.get(longUrl);
    }

}
