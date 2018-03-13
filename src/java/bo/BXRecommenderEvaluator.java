package bo;

import BookCrossing.BXDataModel;
import BookCrossing.BXRecommenderBuilder;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;

import java.io.File;
import java.io.IOException;

public class BXRecommenderEvaluator {
    private BXRecommenderEvaluator(){
    }

    public static void main(String[] args) throws IOException, TasteException {
        DataModel dataModel = new BXDataModel(new File(args[0]), false);
        RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
        double score = evaluator.evaluate(new BXRecommenderBuilder(), null, dataModel, 0.6, 0.9);

        System.out.println("MAE score is "+score);
    }
}
