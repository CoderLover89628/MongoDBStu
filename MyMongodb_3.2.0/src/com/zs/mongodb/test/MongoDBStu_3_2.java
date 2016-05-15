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
	 * mongo地址，当为localhost或127.0.0.1时，使用本地Mongo，
	 * 配置为其他IP时则表示远程连接
	 */
	private static String URL = "localhost";
	
	/**
	 * 端口，默认27017
	 */
	private static int PORT = 27017;
	
	/**
	 * Mongo的数据库驱动
	 * 同Oracle和MySQL的驱动一样
	 * 
	 */
	private static MongoClient mongoClient = null;
	
	/**
	 * 连接的数据库
	 */
	private static MongoDatabase database = null;
	
	/**
	 * 连接的集合名，即，表名
	 */
	private static MongoCollection<Document> collection = null; 
	
	/**
	 * 游标
	 */
	private MongoCursor<Document> cur = null; 
	
	// 数据库名字
	private static String DATABASE_NAME = "mydb";
	
	// 表名
	private static String COLLECTION_NAME = "test";
	
	
	/**
	 * 初始化，对mongoDB服务连接
	 * 
	 */
	public void init() {
		mongoClient = new MongoClient(URL,PORT);
		
		database = mongoClient.getDatabase(DATABASE_NAME);
		
		collection = database.getCollection(COLLECTION_NAME);
	}
	
	/**
	 * 删除全部，即，将整个表删除
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
  
        /********************** 数据插入 ****************************/  
//         // 创建新文档  
//         Document doc = new Document("name", "MongoDB")  
//         .append("type", "database").append("count", 1)  
//         .append("info", new Document("x", 203).append("y", 102));  
//         // 将文档插入文档集合  
//         collection.insertOne(doc);  
//          
//         // 创建一个包含多个文档的列表  
//         List<Document> documents = new ArrayList<Document>();  
//         for (int i = 0; i < 100; i++) {  
//         documents.add(new Document("i", i));  
//         }  
//         // 向文档中插入列表  
//         collection.insertMany(documents);  
  
        /***************** 数据读取 ****************************************/  
          // 001显示集合中的文档的数量  
//        System.out.println(collection.count());  
        
          // 002查询集合中的第一个文档  
//        Document myDoc = collection.find().first();  
//        System.out.println(myDoc.toJson());  
          
           // 003获取集合中的全部文档  
//         MongoCursor<Document> cursor = collection.find().iterator();  
//         try {  
//         while (cursor.hasNext()) {  
//         System.out.println(cursor.next().toJson());  
//         }  
//         } finally {  
//         cursor.close();  
//         }  
  
           // 004获取全部文档的另一种方法  
//         for (Document cur : collection.find()) {  
//         System.out.println(cur.toJson());  
//         }  
  
           // 005根据条件获取某分文档 eq:==  
//         Document myDoc = collection.find(Filters.eq("i", 71)).first();  
//         System.out.println(myDoc.toJson());  
  
           // 006通过查询语句一次性获取多个数据  
//         Block<Document> printBlock = new Block<Document>() {  
//         public void apply(final Document document) {  
//         System.out.println(document.toJson());  
//         }  
//         };  
          // 获得所有大于50的  
//        collection.find(Filters.gt("i", 50)).forEach(printBlock);  
          // 大于50 小于 100  
//        collection.find(Filters.and(Filters.gt("i", 50), Filters.lte("i", 100))).forEach(printBlock);  
  
          // 007对输出文档进行排序,-1为递减，1为递增  
          // 官方文档的例子有误：http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/#sorting-documents  
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
        
        // 008选择性输出结果中的元素，0为不显示，1为显示  
        // 官方文档中的例子又不能用：http://mongodb.github.io/mongo-java-driver/3.0/driver/getting-started/quick-tour/#projecting-fields  
//         BasicDBObject exclude = new BasicDBObject();  
//         exclude.append("_id", 0);  
//         exclude.append("count", 1);  // 当字段的值为数字时，此处设置零时会报17287 error Code的错误
//         exclude.append("name", 1);  
//         exclude.append("info", 1); 
//         exclude.append("type", 1);
//         Document myDoc = collection.find().projection(exclude).first();
//         System.out.println(myDoc.toJson());
         
//         exclude.append("i", 1);
//         Document myDocSkip = collection.find().projection(exclude).skip(1).first(); 
//         System.out.println(myDocSkip.toJson());

         // exclude：排除，不包括；与之相反的为：include
         // 下面的方法为主要的排除方法，上面的可以用也可以不用
         // ①不显示_id
//         Document myDocFir = collection.find().projection(Projections.excludeId()).first(); 
//         System.out.println(myDocFir.toJson());  
         
         // ②不显示单个
//         Document myDocSec = collection.find().projection(Projections.exclude("name")).first();
//         System.out.println(myDocSec.toJson());
         
         // ③不显示多个
//         List<String> fieldNames = new ArrayList<String>();
//         fieldNames.add("_id");
//         fieldNames.add("count");
//         fieldNames.add("type");
//         Document myDocThi = collection.find().projection(Projections.exclude(fieldNames)).first();
//         System.out.println(myDocThi.toJson());
         
  
        /************************* 修改数据库中数据 *************************************/  
  
        // 修改时的参数：  
        // $inc 对指定的元素加  
        // $mul 乘  
        // $rename 修改元素名称  
        // $setOnInsert 如果以前没有这个元素则增加这个元素，否则不作任何更改  
        // $set 修改制定元素的值  
        // $unset 移除特定的元素  
        // $min 如果原始数据更大则不修改，否则修改为指定的值  
        // $max 与$min相反  
        // $currentDate 修改为目前的时间  
  
        // //修改第一个符合条件的数据  
        // $set 为修改   如下为两种方式
		// ①
//         collection.updateOne(Filters.eq("i", 10), new Document("$set", new  
//         Document("i", 110)));  
//         // ②推荐使用
//         collection.updateOne(Filters.eq("i", 1), Updates.set("i", 11));
  
        // 批量修改数据并且返回修改的结果，讲所有小于100的结果都加100  
//         UpdateResult updateResult = collection.updateMany(Filters.lt("i", 100),  
//         new Document("$inc", new Document("i", 100)));  
//         // 显示发生变化的行数  
//         System.out.println(updateResult.getModifiedCount()); 
		
         // 第二种 批量修改数据且返回修改结果，所有小于200的结果都加100(推荐)
//         UpdateResult updateResults = collection.updateMany(Filters.lt("i", 200), Updates.inc("i", 100));
//         System.out.println(updateResults.getModifiedCount());
		
        /************************** 删除数据 *****************************/  
        // 删除第一个符合条件的数据  
//         collection.deleteOne(Filters.eq("i", 211));  
  
        // 删除所有符合条件的数据，并且返回结果  
//        DeleteResult deleteResult = collection.deleteMany(Filters.gte("i", 200)); 
		
        // 输出删除的行数  
//        System.out.println(deleteResult.getDeletedCount());  
        
        /*************************** 程序块，一次执行多条语句 ********************************/  
        // 按照语句先后顺序执行  
		// 官网给出的例子：http://mongodb.github.io/mongo-java-driver/3.2/driver/getting-started/quick-tour/#bulk-operations
		// 有明显地错误，即，new InsertOneModel<Document>中没有Document这个类型，且例子运行后只插入了4、5、6
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
  
        // 不按照语句先后顺序执行  
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
	    
		/***************************  Aggregates聚合 ********************************/  
        
	  // 将_id大于4的记录，每个_id的值扩大10倍
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
	  
	   // 获取全部文档
	   printAll();
	    
	}


	/**
	 * 打印
	 */
	private void printAll() {
		for (Document cur : collection.find()) {  
	         System.out.println(cur.toJson());  
	    }
	}
}
