package LLD.URLShortner;

import java.time.LocalDateTime;

public class URL{
    private String LongURL;
    private String ShortURL;
    private LocalDateTime expiryDate;

    public String getLongURL() {
        return LongURL;
    }

    public void setLongURL(String longURL) {
        LongURL = longURL;
    }

    public String getShortURL() {
        return ShortURL;
    }

    public void setShortURL(String shortURL) {
        ShortURL = shortURL;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}

