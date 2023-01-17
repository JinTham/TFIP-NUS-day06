package tfip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    private String dirPath;
    private String fileName;
    private List<String> cookieItems = new ArrayList<>();
    //Constructors
    public Cookie(String dirPath, String fileName){
        this.dirPath = dirPath;
        this.fileName = fileName;
    }
    //Methods
    public void readCookieFile() throws FileNotFoundException, IOException {
        File file = new File(dirPath + File.separator + fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String readString;
        try {
            while ((readString = br.readLine()) != null){
                cookieItems.add(readString);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            br.close();
            fr.close();
        }
    }
    public String returnCookie(){
        Random rand = new Random();
        if (cookieItems != null){
            return cookieItems.get(rand.nextInt(cookieItems.size()));
        } else {
            return "There is no cookie found";  
        }
    }
    public void showCookies(){
        if (cookieItems != null){
            cookieItems.forEach(cookie->System.out.println(cookie));
        } else {
            System.out.println("No cookie to show");
        }
    }
}
