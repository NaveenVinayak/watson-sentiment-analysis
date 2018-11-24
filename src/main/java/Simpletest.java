import com.ibm.watson.developer_cloud.natural_language_understanding.v1.*;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.*;


public class Simpletest {

    //static int Count=0;
    public NaturalLanguageUnderstanding getServices(){
        NaturalLanguageUnderstanding service = new NaturalLanguageUnderstanding(
                "2018-03-19",
                "6d629e74-a5c3-4cc1-8484-963bf16e34c7",
                "MH8nuwwmHPn0"
        );
        return service;
    }

    NaturalLanguageUnderstanding service = getServices();

    public String analyze(int Count, String texts){



        SentimentOptions sentimentOptions = new SentimentOptions.Builder().build();

        EntitiesOptions entitiesOptions = new EntitiesOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();

        KeywordsOptions keywordsOptions = new KeywordsOptions.Builder()
                .emotion(true)
                .sentiment(true)
                .limit(2)
                .build();


        Features features = new Features.Builder()
                .sentiment(sentimentOptions)
                .entities(entitiesOptions)
                .keywords(keywordsOptions)
                .build();

        AnalyzeOptions parameters = new AnalyzeOptions.Builder()
                .text(texts)
                .features(features)
                .build();

        AnalysisResults response = service
                .analyze(parameters)
                .execute();

        System.out.println("Count : "+(Count) + "     Sentiment : "+response.getSentiment().getDocument().getLabel());

        return response.getSentiment().getDocument().getLabel();

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        String text = "I hate that thing man!";
        Simpletest st = new Simpletest();



    }

}
