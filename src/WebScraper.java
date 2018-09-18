import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int totalWordCount (String websiteText) {
        int totalNumWords = 0;
        String arrayOfWords[] = websiteText.split(" ");
        totalNumWords = arrayOfWords.length;
        return totalNumWords;

    }

    public static int countOneWord (String websiteText, String inputWord) {
        int numWord = 0;
        String arrayOfWords[] = websiteText.split(" ");
        for (int currentWord = 0; currentWord < arrayOfWords.length; currentWord++) {
            if (arrayOfWords[currentWord].equalsIgnoreCase(inputWord)) {
                numWord++;
            }
        }
        return numWord;
    }

    public static void main(String[] unused) {
        System.out.println(totalWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt")));
        System.out.println(countOneWord(urlToString("http://erdani.com/tdpl/hamlet.txt"), "Prince"));
    }



}
