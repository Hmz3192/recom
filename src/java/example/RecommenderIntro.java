package example;

import org.apache.mahout.cf.taste.impl.model.file.*;
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.impl.neighborhood.*;
import org.apache.mahout.cf.taste.impl.recommender.*;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.*;
import org.apache.mahout.cf.taste.neighborhood.*;
import org.apache.mahout.cf.taste.recommender.*;

import java.io.File;
import java.util.List;

public class RecommenderIntro {
    private RecommenderIntro() {
    }

    public static void main(String[] args) throws Exception{
        DataModel model = new FileDataModel(new File("F:\\vedio\\推荐系统\\课件文档代码\\课件文档代码\\数据包\\MovieLens\\ua.base"));
        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model);
//        UserNeighborhood neighborhood = new NearestNUserNeighborhood(100, similarity, model);
//        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        Recommender recommender = new GenericBooleanPrefItemBasedRecommender(model, similarity);


        List<RecommendedItem> recommendedItems = recommender.recommend(2, 20);

        for (RecommendedItem recommendedItem: recommendedItems){
            System.out.println(recommendedItem);
        }
    }

    /*RecommendedItem[item:286, value:30.550676]
RecommendedItem[item:748, value:29.470533]
RecommendedItem[item:294, value:27.991129]
RecommendedItem[item:300, value:24.036028]
RecommendedItem[item:302, value:23.605932]
RecommendedItem[item:288, value:23.375998]
RecommendedItem[item:307, value:20.31056]
RecommendedItem[item:328, value:19.668104]
RecommendedItem[item:313, value:18.23146]
RecommendedItem[item:323, value:17.5407]
RecommendedItem[item:333, value:17.048645]
RecommendedItem[item:751, value:16.910505]
RecommendedItem[item:301, value:16.05409]
RecommendedItem[item:326, value:15.56685]
RecommendedItem[item:289, value:14.806566]
RecommendedItem[item:322, value:14.587736]
RecommendedItem[item:327, value:14.17566]
RecommendedItem[item:340, value:13.887481]
RecommendedItem[item:358, value:13.420033]
RecommendedItem[item:310, value:12.881943]*/
}
