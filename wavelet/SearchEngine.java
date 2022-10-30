import java.io.IOException;
import java.net.URI;

class SearchHandler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    String[] words = new String[0];

    public String handleRequest(URI url) {
        if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                String[] wordss = new String[words.length+1];
                for (int i = 0; i < words.length; i++) {
                    wordss[i] = words[i];
                }
                wordss[words.length] = parameters[1];
                words = wordss;
            }
            return "Word added";
        }
        else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            String list = "";
            if (parameters[0].equals("s")) {
                String substring = parameters[1];
                for (int i = 0; i < words.length; i++) {
                    if (words[i].contains(substring)) {
                        list = list + words[i] + " ";
                    }
                }
            }
            return list;
        }
        else {
            return "404 Not Found!";
        }
    }
}

// Largely left unchanged as this method works
class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new SearchHandler());
    }
}
