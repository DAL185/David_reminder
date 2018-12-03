package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class Guest_member{

	String name;
	String description;
	String time;
	String priority;
	
	
public Guest_member(String name,String description,String time,String priority){

		this.name=name;
		this.description=description;
		this.time=time;
		this.priority=priority;
	}
	public Guest_member(){}
	
	public String searchguest(String na)  throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from patient_member_info where name='"+na+"' order by pubdate desc,finish " ;
		rs=st.executeQuery(sql);
		//System.out.println(sql);
		JSONArray result=new JSONArray();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String description=rs.getString("description");
			String pubdate=rs.getString("pubdate");
			String time=rs.getString("time");
			String priority=rs.getString("priority");
			String finish=rs.getString("finish");
			obj.put("id",id);
			obj.put("name",name);
			obj.put("description",description);
			obj.put("pubdate",pubdate);
			obj.put("time",time);
			obj.put("priority",priority);
			obj.put("finish",finish);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public boolean have_reminder(String guest_name) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		Integer year = rightNow.get(Calendar.YEAR); 
		Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
		Integer day = rightNow.get(rightNow.DAY_OF_MONTH);
		//String TimeNow12 = year+"-"+month+"-"+day+" "+hour12+":"+minute+":"+second+":"+millisecond;
		String pubdate = year+"-"+month+"-"+day;
		//DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="select * from patient_member_info where name='"+guest_name+"' and pubdate='"+pubdate+"' and finish='No' " ;
		//System.out.println(sql);
		java.sql.ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
			flag=true;
		}
		conn.close();
		st.close();
		return flag;
	}
	
	public boolean finish_reminder(String id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="update patient_member_info set finish='Yes' where id='"+id+"' ";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	private static Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/reminder?characterEncoding=utf8";
		String username = "root";
		String password = "";
		Connection conn=null;
		try{
			Class.forName(driver); //classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url,username,password);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
}
