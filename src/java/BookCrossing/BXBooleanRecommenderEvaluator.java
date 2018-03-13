package BookCrossing;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BXBooleanRecommenderEvaluator {
    private BXBooleanRecommenderEvaluator(){
    }

    public static void main(String[] args) throws IOException, TasteException {
/*
        DataModel dataModel = new BXDataModel(new File(args[0]), true);
        RecommenderIRStatsEvaluator evaluator = new GenericRecommenderIRStatsEvaluator();
        IRStatistics stats = evaluator.evaluate(new BXBooleanRecommenderBuilder(), new BXDataModelBuilder(), dataModel, null, 3, Double.NEGATIVE_INFINITY, 1.0);

        System.out.println("Precision is "+stats.getPrecision()+"; Recall is "+stats.getRecall()+"; F1 is"+stats.getF1Measure());
*/
        String path = "F:\\vedio\\推荐系统\\课件文档代码\\课件文档代码\\数据包\\Book-Crossing\\BX-Book-Ratings.csv";
        DataModel dataModel = new BookCrossing.BXDataModel(new File(path), true);
        //推荐评估，使用平均值
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        //推荐评估，使用均方差
        //RecommenderEvaluator evaluator = new RMSRecommenderEvaluator();
        double score = evaluator.evaluate(new BXBooleanRecommenderBuilder(), null, dataModel, 0.8, 0.1);

        System.out.println("MAE score is "+score);


        Recommender recommender = new BXBooleanRecommender(dataModel);

       /* File resultFile = new File("E:\\WorkSpace\\Idea\\recom\\src\\resources\\MysqlMovieRcomed.txt");

        try (PrintWriter writer = new PrintWriter(resultFile)) {
            for (int userID = 1; userID <= dataModel.getNumUsers(); userID++) {
                System.out.println(userID);
                List<RecommendedItem> recommendedItems = recommender.recommend(userID, 3);
                String line = userID + " : ";
                for (RecommendedItem recommendedItem : recommendedItems) {
                    line += recommendedItem.getItemID() + ":" + recommendedItem.getValue() + ",";
                }
                if (line.endsWith(",")) {
                    line = line.substring(0, line.length() - 1);
                }
                writer.write(line);
                writer.write('\n');
            }
        } catch (IOException ioe) {
            resultFile.delete();
            throw ioe;
        }
        System.out.println("Recommended for " + dataModel.getNumUsers() + " users and saved them to " + resultFile.getAbsolutePath());*/
    }
}
