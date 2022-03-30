import twitter4j.*;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import twitter4j.conf.ConfigurationBuilder;



public class TwitterAPI {
    public static void main(String[] args) throws Exception {
        

        




    }
    public static String tweetsAbout(){


//Initializng Keys, values were genertated through twitters developer platform

        ConfigurationBuilder cf = new ConfigurationBuilder();
        cf.setDebugEnabled(true)
            .setOAuthConsumerKey("3VH745SuhcvIM7VoUoEBc40wv")
            .setOAuthConsumerSecret("OO9qR2LEteEUWj6KGWXrwTWdxtIBh25aO2USTn4eF6gZDnvgqe")
            .setOAuthAccessToken("1102759501-h0uiGtYf9WaRxD8cq7tKsxbUxbojt5aD3wfdLah")
            .setOAuthAccessTokenSecret("gq08VNMyKfIcmIN9RnIDaAYYhJx7seaYwMCODd4cWAzOW");
        TwitterFactory tf = new TwitterFactory(cf.build());
        Twitter twitter =tf.getInstance();
        
    //creates an array list of the latest tweet with #RyanReynolds
        List<Status> tweets = new ArrayList<>();
        Query query = new Query("#RyanReynolds");
        query.setCount(1);
        try {
          QueryResult result = twitter.search(query);
        
            tweets.addAll(result.getTweets());
          //System.out.println("Gathered " + tweets.size() + " tweets");
      } catch (TwitterException te) {
          //System.out.println("Couldn't connect: " + te.toString());
      }


      

//converts tweet to string

String tstring = tweets.toString();
String good = "";

for(int i = 0; i < 400; i++){
good = good + tstring.charAt(i);
}

//parses out relevant information
good = StringUtils.substringBetween(good, "text=", "source=");
return good;

    }


        }
    