package com.zs.mongodb.test;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;

public class ArrayToListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List s = Arrays.asList(
				 new InsertOneModel<>(new Document("_id", 4)),
				 new InsertOneModel<>(new Document("_id", 5)),
				 new InsertOneModel<>(new Document("_id", 6)),
				 new UpdateOneModel<>(new Document("_id", 1),
				 new Document("$set", new Document("x", 2))), 
				 new DeleteOneModel<>(new Document("_id", 2)), 
				 new ReplaceOneModel<>(new Document("_id", 3), 
				 new Document("_id", 3).append("x", 4)));
		System.out.println(s.get(2).getClass());
	}

}
