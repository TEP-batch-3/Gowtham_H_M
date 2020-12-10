package questiongenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActionDAO {
	static Connection currentCon = null;
	static Statement stmt = null;
	static String insert = null;
	static String entityId = null;
	static String conceptId = null;
	static String operationId = null;
	static String fieldId = null;
	static PreparedStatement ps=null;
	static int recAdded = 0;
	static ActionBean ab = new ActionBean();
	
public int addEntity() {
	// TODO Auto-generated method stub
	String entityTitle;
	int entityUsage;
	entityTitle =ab.getentity_title();
	entityUsage = ab.getentity_usage();
	try {
	try {
		currentCon = ConnectionManager.getConnection();
		}
		catch(Exception e) {
			System.out.println("error creating connection:"+e);
		}
	
	ResultSet rs= null;
	String query1 = "select count(*) from tbl_entity where upper(title)= ?";
	ps = currentCon.prepareStatement(query1);
	ps.setString(1, entityTitle);
	rs = ps.executeQuery();
	boolean flag = false;
	while(rs.next())
	{
		if(rs.getInt(1) > 0)
		{
			flag = true;
			recAdded = 2 ;
		}
	}
	if(!flag)
	{
		String query2 = "SELECT MAX(entity_id) from tbl_entity";
		String query3 = "INSERT into tbl_entity(entity_id,title,usage) values (?,?,?)";
		ps = currentCon.prepareStatement(query2);
		rs = ps.executeQuery();
		int entity_id = 0;
		
		while(rs.next())
		{
			entity_id = rs.getInt(1) +1;
			ps = currentCon.prepareStatement(query3);
			ps.setInt(1, entity_id);
			ps.setString(2, entityTitle);
			ps.setInt(3, entityUsage);
			recAdded = ps.executeUpdate();
//			if(recAdded > 0)
//			{
//				//addFieldType(entity_id,entityTitle);
//				String query4 = "update tbl_entity set usage = 0 where usage is not null";
//				ps = currentCon.prepareStatement(query4);
//				ps.executeUpdate();
//				//System.out.println(recAdded);
//				
//			}
		}
	}
	
	}catch(Exception e) {
		System.out.println(e);
	}
	return recAdded;
}

public int addConcept() {
	// TODO Auto-generated method stub
	String conceptTitle;
	boolean scenario_driven;
	boolean entity_driven;
	boolean operation_driven;
	conceptTitle =ActionBean.getconcept_title();
	scenario_driven = ab.getconcept_scenario_driven() ;
	entity_driven = ab.getconcept_enetiy_driven() ;
	operation_driven = ab.getconcept_operation_driven() ;
	try {
	try {
		currentCon = ConnectionManager.getConnection();
		}
		catch(Exception e) {
			System.out.println("error creating connection:"+e);
		}
	
	ResultSet rs= null;
	String query1 = "select count(*) from TBL_CONCEPT where upper(title)= ?";
	ps = currentCon.prepareStatement(query1);
	ps.setString(1, conceptTitle);
	rs = ps.executeQuery();
	boolean flag = false;
	while(rs.next())
	{
		if(rs.getInt(1) > 0)
		{
			flag = true;
			recAdded = 2 ;
		}
	}
	if(!flag)
	{
		String query2 = "SELECT MAX(concept_id) from TBL_CONCEPT";
		String query3 = "INSERT into TBL_CONCEPT(concept_id,title,scenario_driven,entity_driven,operation_driven) values (?,?,?,?,?)";
		ps = currentCon.prepareStatement(query2);
		rs = ps.executeQuery();
		int concept_id;
		
		while(rs.next())
		{
			concept_id = rs.getInt(1) +1;
			ps = currentCon.prepareStatement(query3);
			
			ps.setInt(1, concept_id);
			ps.setString(2, conceptTitle);
			ps.setBoolean(3,scenario_driven );
			ps.setBoolean(4, entity_driven);
			ps.setBoolean(5, operation_driven);
			recAdded = ps.executeUpdate();
//			if(recAdded > 0)
//			{
//				//addFieldType(entity_id,entityTitle);
//				String query4 = "update tbl_entity set usage = 0 where usage is not null";
//				ps = currentCon.prepareStatement(query4);
//				ps.executeUpdate();
//				//System.out.println(recAdded);
//				
//			}
		}
	}
	
	}catch(Exception e) {
		System.out.println(e);
	}
	return recAdded;
}

public int addFields() {
	// TODO Auto-generated method stub
	String FieldTitle;
	FieldTitle =ab.getfield_title();
	try {
	try {
		currentCon = ConnectionManager.getConnection();
		}
		catch(Exception e) {
			System.out.println("error creating connection:"+e);
		}
	
	ResultSet rs= null;
	String query1 = "select count(*) from TBL_FIELD where upper(title)= ?";
	ps = currentCon.prepareStatement(query1);
	ps.setString(1, FieldTitle);
	rs = ps.executeQuery();
	boolean flag = false;
	while(rs.next())
	{
		if(rs.getInt(1) > 0)
		{
			flag = true;
			recAdded = 2 ;
		}
	}
	if(!flag)
	{
		String query2 = "SELECT MAX(field_id) from TBL_FIELD";
		String query3 = "INSERT into TBL_FIELD(field_id,title) values (?,?)";
		ps = currentCon.prepareStatement(query2);
		rs = ps.executeQuery();
		int field_id = 0;
		
		while(rs.next())
		{
			field_id = rs.getInt(1) +1;
			ps = currentCon.prepareStatement(query3);
			ps.setInt(1, field_id);
			ps.setString(2, FieldTitle);
			recAdded = ps.executeUpdate();
		}
	}
	
	}catch(Exception e) {
		System.out.println(e);
	}
	return recAdded;
}

public int addOpeartion() {
	// TODO Auto-generated method stub
	String OperationTitle;
	OperationTitle =ab.getoperation_title();
	try {
	try {
		currentCon = ConnectionManager.getConnection();
		}
		catch(Exception e) {
			System.out.println("error creating connection:"+e);
		}
	
	ResultSet rs= null;
	String query1 = "select count(*) from TBL_OPERATION where upper(title)= ?";
	ps = currentCon.prepareStatement(query1);
	ps.setString(1, OperationTitle);
	rs = ps.executeQuery();
	boolean flag = false;
	while(rs.next())
	{
		if(rs.getInt(1) > 0)
		{
			flag = true;
			recAdded = 2 ;
		}
	}
	if(!flag)
	{
		String query2 = "SELECT MAX(operation_id) from TBL_OPERATION";
		String query3 = "INSERT into TBL_OPERATION(operation_id,title) values (?,?)";
		ps = currentCon.prepareStatement(query2);
		rs = ps.executeQuery();
		int operation_id = 0;
		
		while(rs.next())
		{
			operation_id = rs.getInt(1) +1;
			ps = currentCon.prepareStatement(query3);
			ps.setInt(1, operation_id);
			ps.setString(2, OperationTitle);
			recAdded = ps.executeUpdate();
		}
	}
	
	}catch(Exception e) {
		System.out.println(e);
	}
	return recAdded;
}

}
