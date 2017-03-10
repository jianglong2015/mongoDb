package com.mongodb.connection;

import java.util.Iterator;
import java.util.Set;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.QueryOperators;

/**
 * @author jianglong
 *
 * Feb 28, 2017
 */
public class MongoConnection {
	static DB db=null;
    static DBCollection collection=null;
    static {
    	try{
			Mongo mongo=new Mongo("localhost",27017);
			db=mongo.getDB("runoob");
			if(db.authenticate("test1", "123".toCharArray())){
				System.out.println("success");
				collection=db.getCollection("test1");
			}else{
				System.out.println("error");
			}			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//add();
		MongoConnection main=new MongoConnection();
		if(collection!=null){
			//main.search();
			main.add();
		}
        
	}
	
	public  void add(){
		BasicDBObject stul=new BasicDBObject();
        stul.put("name", "jack");
        stul.put("age", "25");
        BasicDBObject sight1=new BasicDBObject();
        sight1.put("left", 1.5);
        sight1.put("right", 1.2);
        stul.put("sight", sight1);
        BasicDBObject stul2=new BasicDBObject();
        stul2.put("name", "lucy");
        stul2.put("age", "22");
        BasicDBObject sight2=new BasicDBObject();
        sight2.put("left", 1.0);
        sight2.put("right", 1.3);
        stul2.put("sight", sight1);
        collection.insert(stul);
        collection.insert(stul2);
	}
    public  void search(){
    	Set<String> colls=db.getCollectionNames();
    	showData(colls);
        BasicDBObject query=new BasicDBObject();
        query.put("name", "lucy");
        collection.remove(query);
    }
    /** 
    * 遍历显示结果 
    * @param result 
    */  
    @SuppressWarnings("rawtypes")   
    public void showData(Iterable result){  
         Iterator it = result.iterator();   
         while(it.hasNext())    
            {    
                System.out.println(it.next());    
           }    
       }    

}
