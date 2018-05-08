package flattenxson.utils;

import flattenxson.exceptions.FlattenXsonException;
import flattenxson.iml.BsonImpl;
import flattenxson.iml.BaseFlatten;
import org.bson.Document;

import java.util.List;

public class BsonFlattenUtil {
    public static Document flattenDoc(Object doc, String separatorChar, int maxDocLevelsSupported, List<Class<?>> unSupportedTypes) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, separatorChar, maxDocLevelsSupported, unSupportedTypes);
    }

    public static Document flattenDoc(Object doc, String separatorChar, int maxDocLevelsSupported) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, separatorChar, maxDocLevelsSupported, null);
    }

    public static Document flattenDoc(Object doc, String separatorChar) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, separatorChar, 0, null);
    }

    public static Document flattenDoc(Object doc) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, "__", 0, null);
    }

    public static Document flattenDoc(Object doc, int maxDocLevelsSupported) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, "__", maxDocLevelsSupported, null);
    }

    public static Document flattenDoc(Object doc, int maxDocLevelsSupported, List<Class<?>> unSupportedTypes) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.flatten(doc, "__", maxDocLevelsSupported, unSupportedTypes);
    }

    public static Document unFlatten(String doc, String separatorChar) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.unFlatten(doc,separatorChar);
    }

    public static Document unFlatten(String doc) throws FlattenXsonException {
        BaseFlatten baseFlatten = new BsonImpl();
        return (Document) baseFlatten.unFlatten(doc,"__");
    }


}