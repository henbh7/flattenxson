package flattenxson.test.utils;

import flattenxson.exceptions.FlattenXsonException;
import flattenxson.utils.BsonFlattenUtil;
import org.bson.Document;
import org.junit.Assert;
import org.junit.Test;


public class BsonFlattenUtilIntegrationTest {
    @Test
    public void test1() {
        String bsonString = "{\n" +
                "  \"address\": {\n" +
                "     \"building\": \"1007\",\n" +
                "     \"coord\": [ -73.856077, 40.848447 ],\n" +
                "     \"street\": \"Morris Park Ave\",\n" +
                "     \"zipcode\": \"10462\"\n" +
                "  },\n" +
                "  \"borough\": \"Bronx\",\n" +
                "  \"cuisine\": \"Bakery\",\n" +
                "  \"grades\": [\n" +
                "     { \"date\": { \"$date\": 1393804800000 }, \"grade\": \"A\", \"score\": 2 },\n" +
                "     { \"date\": { \"$date\": 1378857600000 }, \"grade\": \"A\", \"score\": 6 },\n" +
                "     { \"date\": { \"$date\": 1358985600000 }, \"grade\": \"A\", \"score\": 10 },\n" +
                "     { \"date\": { \"$date\": 1322006400000 }, \"grade\": \"A\", \"score\": 9 },\n" +
                "     { \"date\": { \"$date\": 1299715200000 }, \"grade\": \"B\", \"score\": 14 }\n" +
                "  ],\n" +
                "  \"name\": \"Morris Park Bake Shop\",\n" +
                "  \"restaurant_id\": \"30075445\"\n" +
                "}";

        try {
            Document bson = Document.parse(bsonString);
            Document flattenDoc = BsonFlattenUtil.flattenDoc(bson);

            System.out.println("Flatten Doc :::: " + flattenDoc);

            Document unflattenDoc = BsonFlattenUtil.unFlatten(flattenDoc.toJson());
            System.out.println("UnFlatten Doc :::: " + unflattenDoc);

            Assert.assertFalse(!flattenDoc.toJson().contains("__"));
            Assert.assertFalse(unflattenDoc.toJson().contains("__"));
        } catch (FlattenXsonException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        String bsonString = "{\n" +
                "  \"address\": {\n" +
                "     \"building\": \"1007\",\n" +
                "     \"coord\": [ -73.856077, 40.848447 ],\n" +
                "     \"street\": \"Morris Park Ave\",\n" +
                "     \"zipcode\": \"10462\"\n" +
                "  },\n" +
                "  \"borough\": \"Bronx\",\n" +
                "  \"cuisine\": \"Bakery\",\n" +
                "  \"grades\": [\n";

        try {
            BsonFlattenUtil.unFlatten(bsonString);
        } catch (FlattenXsonException e) {
            e.printStackTrace();
            Assert.assertTrue(true);
        }
    }
}
