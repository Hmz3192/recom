package example;

import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericUserPreferenceArray;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;

public class CreateGenericDataModel {
    private CreateGenericDataModel() {
    }

    public static void main(String[] args) {
        FastByIDMap<PreferenceArray> preferences = new FastByIDMap<PreferenceArray>();
        PreferenceArray User1Pref = new GenericUserPreferenceArray(2);
        User1Pref.setUserID(0, 1L);

        User1Pref.setItemID(0, 101L);
        User1Pref.setValue(0, 3.0f);

        User1Pref.setItemID(1, 102L);
        User1Pref.setValue(1, 4.0f);

        PreferenceArray User2Pref = new GenericUserPreferenceArray(2);
        User2Pref.setUserID(0, 2L);
        User2Pref.setItemID(0, 101L);
        User2Pref.setValue(0, 3.0f);
        User2Pref.setItemID(1, 102L);
        User2Pref.setValue(1, 4.0f);

        long[] ids = new long[]{1,2,3};
        float[] ratings = new float[]{1.0f,2.0f,3.0f};
        GenericUserPreferenceArray g = new GenericUserPreferenceArray(3);

        preferences.put(1L, User1Pref);
        preferences.put(2L, User2Pref);

        DataModel model = new GenericDataModel(preferences);
        System.out.println(model);
    }
}
