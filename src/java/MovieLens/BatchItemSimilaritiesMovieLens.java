package MovieLens;


import MovieLens.MovieLensDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.precompute.FileSimilarItemsWriter;
import org.apache.mahout.cf.taste.impl.similarity.precompute.MultithreadedBatchItemSimilarities;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.BatchItemSimilarities;
import org.apache.mahout.cf.taste.similarity.precompute.SimilarItemsWriter;

import java.io.File;
import java.util.List;

public class BatchItemSimilaritiesMovieLens {
    private BatchItemSimilaritiesMovieLens(){
    }

    public static void main(String[] args) throws Exception{


        File resultFile = new File("E:\\WorkSpace\\Idea\\recom\\src\\resources\\rec.dat");

        DataModel dataModel = new MovieLensDataModel(new File("E:\\WorkSpace\\Idea\\recom\\src\\resources\\ratings.dat"));
        ItemSimilarity similarity = new LogLikelihoodSimilarity(dataModel);
        ItemBasedRecommender recommender = new GenericItemBasedRecommender(dataModel, similarity);
        BatchItemSimilarities batchItemSimilarities = new MultithreadedBatchItemSimilarities(recommender, 5);
        long[] a = new long[]{
            707, 708, 709,710,711};

        List<RecommendedItem> recommendedItems = recommender.mostSimilarItems(a, 30);
        for (RecommendedItem recommendedItem: recommendedItems){
            System.out.println(recommendedItem);
        }
//        SimilarItemsWriter writer = new FileSimilarItemsWriter(resultFile);

//        int numSimilarites = batchItemSimilarities.computeItemSimilarities(Runtime.getRuntime().availableProcessors(), 1, writer);

//        System.out.println("Computed "+ numSimilarites+ " for "+ dataModel.getNumItems()+" items and saved them to "+resultFile.getAbsolutePath());
    }
}
