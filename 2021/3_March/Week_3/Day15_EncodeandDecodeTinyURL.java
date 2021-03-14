
//Day 15: 
//Problem Statement: Encode and Decode TinyURL

// Note: This is a companion problem to the System Design problem: Design TinyURL.
// TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

// Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

//Solution:
public class Codec {

    static final String possChars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Map<String, String> codes=new HashMap<>(), urls=new HashMap<>();

    private String getCode() {
        
        char []code=new char[6];
        
        for (int i=0; i<6; i++) 
            code[i]=possChars.charAt((int)Math.random()*62);
        
        return "http://tinyurl.com/"+String.valueOf(code);
    
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
     
        if(urls.containsKey(longUrl)) 
            return urls.get(longUrl);
        
        String code=getCode();
        
        while(codes.containsKey(code)) 
            code=getCode();
        
        codes.put(code, longUrl);
        urls.put(longUrl, code);
        
        return code;   
    
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codes.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

//Complexity: O(n)

