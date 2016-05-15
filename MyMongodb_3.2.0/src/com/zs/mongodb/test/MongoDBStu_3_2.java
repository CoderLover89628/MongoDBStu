package com.zs.mongodb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class MongoDBStu_3_2 {

	/**
	 * mongo��ַ����Ϊlocalhost��127.0.0.1ʱ��ʹ�ñ���Mongo��
	 * ����Ϊ����IPʱ���ʾԶ������
	 */
	private static String URL = "localhost";
	
	/**
	 * �˿ڣ�Ĭ��27017
	 */
	private static int PORT = 27017;
	
	/**
	 * Mongo�����ݿ�����
	 * ͬOracle��MySQL������һ��
	 * 
	 */
	private static MongoClient mongoClient = null;
	
	/**
	 * ���ӵ����ݿ�
	 */
	private static MongoDatabase database = null;
	
	/**
	 * ���ӵļ���������������
	 */
	private static MongoCollection<Document> collection = null; 
	
	/**
	 * �α�
	 */
	private MongoCursor<Document> cur = null; 
	
	// ���ݿ�����
	private static String DATABASE_NAME = "mydb";
	
	// ����
	private static String COLLECTION_NAME = "test";
	
	
	/**
	 * ��ʼ������mongoDB��������
	 * 
	 */
	public void init() {
		mongoClient = new MongoClient(URL,PORT);
		
		database = mongoClient.getDatabase(DATABASE_NAME);
		
		collection = database.getCollection(COLLECTION_NAME);
	}
	
	/**
	 * ɾ��ȫ����������������ɾ��
	 */
	public void deleteAll() {
		collection.drop();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MongoDBStu_3_2 md = new MongoDBStu_3_2();
		md.init();
		md.test();
	}

	private void test() {  
  
        /********************** ���ݲ��� ****************************/  
//         // �������ĵ�  
//         Document doc = new Document("name", "MongoDB")  
//         .append("type", "database").append("count", 1)  
//         .append("info", new Document("x", 203).append("y", 102));  
//         // ���ĵ������ĵ�����  
//         collection.insertOne(doc);  
//          
//         // ����һ����������ĵ����б�  
//         List<Document> documents = new ArrayList<Document>();  
//         for (int i = 0; i < 100; i++) {  
//         documents.add(new Document("i", i));  
//         }  
//         // ���ĵ��в����б�  
//         collection.insertMany(documents);  
  
        /***************** ���ݶ�ȡ ****************************************/  
          // 001��ʾ�����е��ĵ�������  
//        System.out.println(collection.count());  
        
          // 002��ѯ�����еĵ�һ���ĵ�  
//        Document myDoc = collection.find().first();  
//        System.out.println(myDoc.toJson());  
          
           // 003��ȡ�����е�ȫ���ĵ�  
//         MongoCursor<Document> cursor = collection.find().iterator();  
//         try {  
//         while (cursor.hasNext()) {  
//         System.out.println(cursor.next().toJson());  
//         }  
//         } finally {  
//         cursor.close();  
//         }  
  
           // 004��ȡȫ���ĵ�����һ�ַ���  
//         for (Document cur : collection.find()) {  
//         System.out.println(cur.toJson());  
//         }  
  
           // 005����������ȡĳ���ĵ� eq:==  
//         Document myDoc = collection.find(Filters.eq("i", 71)).first();  
//         System.out.println(myDoc.toJson());  
  
           // 006ͨ����ѯ���һ���Ի�ȡ�������  
//         Block<Document> printBlock = new Block<Document>() {  
//         public void apply(final Document document) {  
//         System.out.println(document.toJson());  
//         }  
//         };  
          // ������д���50��  
//        collection.find(Filters.gt("i", 50)).forEach(printBlock);  
          // ����50 С�� 100  
//        collection.find(Filters.and(Filters.gt("i", 50), Filters.lte("i", 100))).forEach(printBlock);  
  
          // 007������ĵ���������,-1Ϊ�ݼ���1Ϊ����  
          // �ٷ��ĵ�����������http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/#sorting-documents  
//        Document myDoc = collection.find(Filters.exists("i"))  
//         .sort(new BasicDBObject("i", -1)).first();  
//         System.out.println(myDoc.toJson());  
  
//         MongoCursor<Document> cursor = collection.find(Filters.exists("i")).
//        		 sort(new BasicDBObject("i", -1)).iterator();
//         try {  
//           while (cursor.hasNext()) {  
//           System.out.println(cursor.next().toJson());  
//           }  
//          } finally {  
//           cursor.close();  
//          }  
        
        // 008ѡ�����������е�Ԫ�أ�0Ϊ����ʾ��1Ϊ��ʾ  
        // �ٷ��ĵ��е������ֲ����ã�http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/#projecting-fields  
//         BasicDBObject exclude = new BasicDBObject();  
//         exclude.append("_id", 0);  
//         exclude.append("count", 1);  // ���ֶε�ֵΪ����ʱ���˴�������ʱ�ᱨ17287 error Code�Ĵ���
//         exclude.append("name", 1);  
//         exclude.append("info", 1); 
//         exclude.append("type", 1);
//         Document myDoc = collection.find().projection(exclude).first();
//         System.out.println(myDoc.toJson());
         
//         exclude.append("i", 1);
//         Document myDocSkip = collection.find().projection(exclude).skip(1).first(); 
//         System.out.println(myDocSkip.toJson());

         // exclude���ų�������������֮�෴��Ϊ��include
         // ����ķ���Ϊ��Ҫ���ų�����������Ŀ�����Ҳ���Բ���
         // �ٲ���ʾ_id
//         Document myDocFir = collection.find().projection(Projections.excludeId()).first(); 
//         System.out.println(myDocFir.toJson());  
         
         // �ڲ���ʾ����
//         Document myDocSec = collection.find().projection(Projections.exclude("name")).first();
//         System.out.println(myDocSec.toJson());
         
         // �۲���ʾ���
//         List<String> fieldNames = new ArrayList<String>();
//         fieldNames.add("_id");
//         fieldNames.add("count");
//         fieldNames.add("type");
//         Document myDocThi = collection.find().projection(Projections.exclude(fieldNames)).first();
//         System.out.println(myDocThi.toJson());
         
  
        /************************* �޸����ݿ������� *************************************/  
  
        // �޸�ʱ�Ĳ�����  
        // $inc ��ָ����Ԫ�ؼ�  
        // $mul ��  
        // $rename �޸�Ԫ������  
        // $setOnInsert �����ǰû�����Ԫ�����������Ԫ�أ��������κθ���  
        // $set �޸��ƶ�Ԫ�ص�ֵ  
        // $unset �Ƴ��ض���Ԫ��  
        // $min ���ԭʼ���ݸ������޸ģ������޸�Ϊָ����ֵ  
        // $max ��$min�෴  
        // $currentDate �޸�ΪĿǰ��ʱ��  
  
        // //�޸ĵ�һ����������������  
        // $set Ϊ�޸�   ����Ϊ���ַ�ʽ
		// ��
//         collection.updateOne(Filters.eq("i", 10), new Document("$set", new  
//         Document("i", 110)));  
//         // ���Ƽ�ʹ��
//         collection.updateOne(Filters.eq("i", 1), Updates.set("i", 11));
  
        // �����޸����ݲ��ҷ����޸ĵĽ����������С��100�Ľ������100  
//         UpdateResult updateResult = collection.updateMany(Filters.lt("i", 100),  
//         new Document("$inc", new Document("i", 100)));  
//         // ��ʾ�����仯������  
//         System.out.println(updateResult.getModifiedCount()); 
		
         // �ڶ��� �����޸������ҷ����޸Ľ��������С��200�Ľ������100(�Ƽ�)
//         UpdateResult updateResults = collection.updateMany(Filters.lt("i", 200), Updates.inc("i", 100));
//         System.out.println(updateResults.getModifiedCount());
		
        /************************** ɾ������ *****************************/  
        // ɾ����һ����������������  
//         collection.deleteOne(Filters.eq("i", 211));  
  
        // ɾ�����з������������ݣ����ҷ��ؽ��  
//        DeleteResult deleteResult = collection.deleteMany(Filters.gte("i", 200)); 
		
        // ���ɾ��������  
//        System.out.println(deleteResult.getDeletedCount());  
        
        /*************************** ����飬һ��ִ�ж������ ********************************/  
        // ��������Ⱥ�˳��ִ��  
		// �������������ӣ�http://mongodb.github.io/mongo-java-driver/3.2/driver/getting-started/quick-tour/#bulk-operations
		// �����Եش��󣬼���new InsertOneModel<Document>��û��Document������ͣ����������к�ֻ������4��5��6
//         collection.bulkWrite(
//        		 Arrays.asList(
//        				 new InsertOneModel<Document>(new Document("_id", 4)), 
//        				 new InsertOneModel<Document>(new Document("_id", 5)),
//        				 new InsertOneModel<Document>(new Document("_id", 6)),
//        				 new UpdateOneModel<Document>(new Document("_id", 1),
//        				 new Document("$set", new Document("x", 2))), 
//        				 new DeleteOneModel<Document>(new Document("_id", 2)), 
//        				 new ReplaceOneModel<>(new Document("_id", 3), 
//        				 new Document("_id", 3).append("x", 4)))); 
  
        // ����������Ⱥ�˳��ִ��  
//         collection.bulkWrite(
//        		 Arrays.asList(
//        				 new InsertOneModel<Document>(new Document("_id", 4)), 
//        				 new InsertOneModel<Document>(new Document("_id", 5)),
//        				 new InsertOneModel<Document>(new Document("_id", 6)),
//        				 new UpdateOneModel<Document>(new Document("_id", 1), new Document("$set", new Document("x", 2))), 
//        				 new DeleteOneModel<Document>(new Document("_id", 2)),  
//         new ReplaceOneModel<>(new Document("_id", 3), new Document(  
//         "_id", 3).append("x", 4))), new BulkWriteOptions()  
//         .ordered(false));  
          
		
//		List<String> li = new ArrayList<String>();
//
//	    li.add("Sims");
//	    li.add("User2");
//
//	    List<WriteModel<Document>> updates = new ArrayList<WriteModel<Document>>();
//
//	    ListIterator<String> listIterator = li.listIterator();
//
//	    while (listIterator.hasNext()) {
//	        updates.add(
//	            new UpdateOneModel<Document>(
//	                new Document("_id",listIterator.next()),
//	                new Document("$inc",new Document("count",1)),
//	                new UpdateOptions().upsert(true)
//	            )
//	        );
//	    }
//
//	    collection.bulkWrite(updates);
	    
		/***************************  Aggregates�ۺ� ********************************/  
        
	  // ��_id����4�ļ�¼��ÿ��_id��ֵ����10��
      Block<Document> printBlock = new Block<Document>() {  
      public void apply(final Document document) {  
      System.out.println(document.toJson());  
      }  
      };  
	  collection.aggregate(
        		Arrays.asList(
        				Aggregates.match(
        						Filters.gt("_id", 4)),
        						Aggregates.project(Document.parse("{ITimes10: {$multiply: ['$_id', 10]}}"))
        		)).forEach(printBlock);
	  
	   // ��ȡȫ���ĵ�
	   printAll();
	    
	}


	/**
	 * ��ӡ
	 */
	private void printAll() {
		for (Document cur : collection.find()) {  
	         System.out.println(cur.toJson());  
	    }
	}
}
