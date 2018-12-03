package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;

public class Member{

	String id;
	String name;
	String description;
	String time;
	String priority;
	
	public Member(String id,String name,String description,String time,String priority){
		
		this.id=id;
		this.name=name;
		this.description=description;
		this.time=time;
		this.priority=priority;
		
	}
	public Member(){}
	
	public String search_member() throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from patient_member_info order by priority asc; " ;
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
			obj.put("id",id);
			obj.put("name",name);
			obj.put("description",description);
			obj.put("pubdate",pubdate);
			obj.put("time",time);
			obj.put("priority",priority);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public String find_member(String keywords) throws Exception{
		Connection conn=getConn();
		Statement st=(Statement) conn.createStatement();
		ResultSet rs=null;
		String sql="select * from patient_member_info where id='"+keywords+"' OR name='"+keywords+"' order by pubdate desc; " ;
		rs=st.executeQuery(sql);
		//rs.last();
		System.out.println(rs.getRow());
		JSONArray result=new JSONArray();
		//rs.beforeFirst();
		while(rs.next()){
			JSONObject obj=new JSONObject();
			int id=rs.getInt("id");
			String name=rs.getString("name");
			String description=rs.getString("description");
			String pubdate=rs.getString("pubdate");
			String time=rs.getString("time");
			String priority=rs.getString("priority");
			obj.put("id",id);
			obj.put("name",name);
			obj.put("description",description);
			obj.put("pubdate",pubdate);
			obj.put("time",time);
			obj.put("priority",priority);
			result.put(obj);
		}
		conn.close();
		st.close();
		rs.close();
		return result.toString();
	}
	
	public boolean add_member() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		//TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
		//Calendar cal = Calendar.getInstance();
		//Date date = cal.getTime();
		Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		Integer year = rightNow.get(Calendar.YEAR); 
		Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
		Integer day = rightNow.get(rightNow.DAY_OF_MONTH);
		//String TimeNow12 = year+"-"+month+"-"+day+" "+hour12+":"+minute+":"+second+":"+millisecond;
		String pubdate = year+"-"+month+"-"+day;
		//DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="insert into patient_member_info(name,description,pubdate,time,priority)values('"+name+"','"+description+"','"+pubdate+"','"+time+"','"+priority+"')";
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	
	public JSONObject edit_searchmember(String r_name) throws Exception{
		Connection conn=getConn();
		Statement st0=(Statement) conn.createStatement();
		Statement st1=(Statement) conn.createStatement();
		Statement st2=(Statement) conn.createStatement();
		Statement st3=(Statement) conn.createStatement();
		Statement st4=(Statement) conn.createStatement();
		Statement st5=(Statement) conn.createStatement();
		Statement st6=(Statement) conn.createStatement();
		Statement st7=(Statement) conn.createStatement();
		
		ResultSet rs0=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		ResultSet rs3=null;
		ResultSet rs4=null;
		ResultSet rs5=null;
		ResultSet rs6=null;
		ResultSet rs7=null;
		Calendar rightNow = Calendar.getInstance(TimeZone.getTimeZone("EST"));
		Integer year = rightNow.get(Calendar.YEAR); 
		Integer month = rightNow.get(Calendar.MONTH)+1; //第一个月从0开始，所以得到月份＋1
		Integer day = rightNow.get(rightNow.DAY_OF_MONTH);
		//String TimeNow12 = year+"-"+month+"-"+day+" "+hour12+":"+minute+":"+second+":"+millisecond;
		String pubdate_now = year+"-"+month+"-"+day;
		//System.out.println(pubdate_now);
		String sql0="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=0; " ;
		String sql1="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=1; " ;
		String sql2="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=2; " ;
		String sql3="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=3; " ;
		String sql4="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=4; " ;
		String sql5="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=5; " ;
		String sql6="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=6; " ;
		String sql7="select pubdate from patient_member_info where name='"+r_name+"' and finish='No'and datediff('"+pubdate_now+"',pubdate)=7; " ;
		//System.out.println(sql);
		rs0=st0.executeQuery(sql0);
		rs1=st1.executeQuery(sql1);
		rs2=st2.executeQuery(sql2);
		rs3=st3.executeQuery(sql3);
		rs4=st4.executeQuery(sql4);
		rs5=st5.executeQuery(sql5);
		rs6=st6.executeQuery(sql6);
		rs7=st7.executeQuery(sql7);
		
		rs0.last();
		rs1.last();
		rs2.last();
		rs3.last();
		rs4.last();
		rs5.last();
		rs6.last();
		rs7.last();
		int num0=rs0.getRow();
		int num1=rs1.getRow();
		int num2=rs2.getRow();
		int num3=rs3.getRow();
		int num4=rs4.getRow();
		int num5=rs5.getRow();
		int num6=rs6.getRow();
		int num7=rs7.getRow();
		//System.out.println(num0);
		//System.out.println(num2);
		//System.out.println(num3);
		//int[] num_array=new int[]{num1,num2,num3,num4,num5,num6,num7};
		
		//JSONArray result=new JSONArray();
		
		JSONObject obj=new JSONObject();
		rs0.beforeFirst();
		rs1.beforeFirst();
		rs2.beforeFirst();
		rs3.beforeFirst();
		rs4.beforeFirst();
		rs5.beforeFirst();
		rs6.beforeFirst();
		rs7.beforeFirst();

		obj.put("0",num0);
		obj.put("1",num1);
		obj.put("2",num2);
		obj.put("3",num3);
		obj.put("4",num4);
		obj.put("5",num5);
		obj.put("6",num6);
		obj.put("7",num7);
		//result.put(obj);
		
		conn.close();
		st0.close();
		st1.close();
		st2.close();
		st3.close();
		st4.close();
		st5.close();
		st6.close();
		st7.close();
		
		rs0.close();
		rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		rs5.close();
		rs6.close();
		rs7.close();
		return obj;
	}
	

	public boolean edit_member() throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		DateFormat d=DateFormat.getDateTimeInstance();
		//String pubdate = d.format(new Date());//获取系统当前时间
		String sql="update patient_member_info set name='"+name+"',description='"+description+"',time='"+time+"',priority='"+priority+"' where id='"+id+"' ";
		//System.out.println(sql);
		if(st.executeUpdate(sql)>0){
			flag=true;
		}	
		conn.close();
		st.close();
		return flag;
	}
	
	
	public boolean del_member(String id) throws Exception{
		Connection conn=getConn();
		boolean flag=false;
		Statement st=(Statement) conn.createStatement();
		//DateFormat d=DateFormat.getDateTimeInstance();
		//String date=d.format(new Date());
		//String date=dateFormat.format( now );
		String sql="delete from patient_member_info where id='"+id+"'";
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
