package LLD.URLShortner;

import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;


class UrlSHortner{
    private final String  BASE_URL="https://short_ly/";

    public String makeUrlSHOrt(String LongUrl){
        String generateSHORT=getShortURL(LongUrl);
        Database db=new Database();
        // Check if already shortened
        URL existing = db.findByLongUrl(LongUrl);
        if (existing != null) {
            return BASE_URL + existing.getShortURL();
        }

        String shortCode;
        do {
            shortCode = getShortURL(LongUrl);
        } while (db.findByShortUrl(shortCode) != null); // avoid collision

        URL newUrl=new URL();
        newUrl.setLongURL(LongUrl);
        newUrl.setShortURL(generateSHORT);
        newUrl.setExpiryDate(LocalDateTime.now().plusMinutes(30));

        db.save(newUrl);

        return BASE_URL+generateSHORT;


    }

    private String getShortURL(String input) {
        int hashcode = input.hashCode();
        String random= UUID.randomUUID().toString();
        String localTime= String.valueOf(System.nanoTime());
        String combined = random+localTime+hashcode;
        String base64Encoded = Base64.getUrlEncoder().encodeToString(combined.getBytes());
        return  base64Encoded.substring(0,6);

    }

    public String returnOriginalURL(String shortURL){
        Database db=new Database();
        URL url=db.findByShortUrl(shortURL);
        if(url==null || url.getExpiryDate().isBefore(LocalDateTime.now())){
            return "URL is Expired...";
        }
        return  url.getLongURL();
    }

}

