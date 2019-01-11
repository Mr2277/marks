package marks.controller;

import com.alibaba.fastjson.JSONArray;
import marks.entity.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

@RestController
@RequestMapping("/")
public class TestController {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;
    //private  S
    @RequestMapping("sizheng")
    public String getCategory3(@RequestParam("category3") String cate3) throws SQLException {

        //System.out.println(cate3);
        String url = "jdbc:mysql://10.168.7.245:3306/Unilnest?characterEncoding=UTF-8";
        //连接的数据库时使用的用户名
        String username = "root";
        //连接的数据库时使用的密码
        String password = "zhirong123";

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        Connection conn = DriverManager.getConnection(url, username, password);
        //String sql=String.format("select * from szcategory3 where category='体育锻炼' ",category3);
        //System.out.println(sql);
       String s= "SELECT * FROM  sz WHERE  category3 like '%"+ cate3 + "%'" ;//+"order by interyear";
      // System.out.println(s);
        PreparedStatement preparedStatement=conn.prepareStatement(s);
        //preparedStatement.setString(1,"体育锻炼");
        ResultSet resultSet=preparedStatement.executeQuery();
       // preparedStatement.
        //System.out.println(resultSet.next());
        //Map<String,List<Map<String,Integer>>>mapMap=new HashMap<>();
        //Map<String,Integer>map1=new HashMap<>();
         //List<Map<String,Integer>>list=new ArrayList<>();
        //Map<String,String>map=new HashMap<>();
          List<Map<String,Object>>list=new ArrayList<>();
         // Map<String,Object>map=new HashMap<>();
        while (resultSet.next()) {
            //System.out.println(resultSet.getString("num") + "," + resultSet.getString("valuetitle") + "," + resultSet.getString("category3") + "," + resultSet.getString("interyear"));
            Map<String,Object>map=new HashMap<>();

            String key = "num,valuetitle,category3,interyear";
            String num = resultSet.getString("num");
            String valuetitle = resultSet.getString("valuetitle");
            String category3 = resultSet.getString("category3");
            //Integer num=Integer.parseInt(resultSet.getString("num"));
            String interyear = resultSet.getString("interyear");
            String value = num + "," + valuetitle + "," + category3 + "," + interyear;
            //System.out.println(value+"vvvv");
            //map.put(key, value);
            map.put("num",num);
            map.put("valuetitle",valuetitle);
            map.put("category3",category3);
            map.put("interyear",interyear);
            //System.out.println(map.size() +"hhhhhhhhh"+map.get(key));

            list.add(map);
            //map.clear();
        }
          /*
           for(int i=0;i<list.size();i++){
               Map<String,Object>map1=new HashMap<>();
                map1=list.get(i);
               for (String key : map1.keySet()) {
                   System.out.println(key + " ：" + map1.get(key));
               }
           }
           */
           String json= JSONArray.toJSONString(list);
           //System.out.println(json);
           //System.out.println(JSONArray.toJSON(list));
            /*
            String num=resultSet.getString("num");
            String valuetitle=resultSet.getString("valuetitle");
            String category3=resultSet.getString("category3");
            //Integer num=Integer.parseInt(resultSet.getString("num"));
            String interyear=resultSet.getString("interyear");
            String key="num,valuetitle,category3,interyear";
            String value=num+","+valuetitle+","+category3+","+interyear;
            map.put(key,value);
        }
           System.out.println(map.size());
            /*
            Map<String,Integer>map=new HashMap<>();
            String valuetitle=resultSet.getString("valuetitle");
            Integer num=Integer.parseInt(resultSet.getString("num"));
            String interyear=resultSet.getString("interyear");
            map.put(valuetitle,num);
               // System.out.println(map.size());
            if(mapMap.get(interyear)==null){
                //                               List<Map<String,Integer>>list=new ArrayList<>();
                list.clear();
                //mapMap.put(interyear,map);
                //System.out.println(mapMap.get(interyear).size()+"TTTTTT");
                list.add(map);
                mapMap.put(interyear,list);
                System.out.println(list.size() +",,,,"+mapMap.size()+".....");
            }
            else{
                //List list1=mapMap.get(interyear);
                //System.out.println(list1.size()+"befooo");
                //list1.add(map);
                list=mapMap.get(interyear);
                list.add(map);
                mapMap.put(interyear,list);
                //System.out.println(list1.size()+"atfer");
                System.out.println( list.size()+"   else  "+mapMap.size()+"   else  ");

            }

            //mapMap.get(interyear).put(valuetitle,num);

            map.clear();
            // System.out.print(resultSet.getString("valuetitle"));
           // System.out.print(resultSet.getString("category3"));
           // System.out.print(resultSet.getString("interyear"));

        }
        System.out.println(mapMap.size());


        //System.out.println(mapMap.get("2014").size());
       // System.out.println(mapMap.get("2015").size());

        Iterator<String> iterator = mapMap.keySet().iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            List list1=mapMap.get(key);
            System.out.println(list1.size());

        }
        //不推荐使用这种方式来加载驱动
       // String param="%"+category3+"%";
        //String sql=String.format("select * from szcategory3 where category3 like '%s' order by interyear",category3);
        //String sql="select * from szcategory3 where category3 like '%"+category3+"%' order by interyear";
        //System.out.println(sql);
        //String sql="select * from szcategory3 where category3=?";
        //List<Info>list=jdbcTemplate.query(sql,new Info(),new Object[]{category3});
        //System.out.println(list.size());
        //System.out.println(jdbcTemplate.query("select * from szcategory3 where category3 = '体育锻炼'",new Info()    ).size());
       //Map<String,Object>map= jdbcTemplate.queryForMap("select * from szcategory3 where category3='体育锻炼' ");
        //jdbcTemplate.
       // System.out.println(map.size());
        /*
        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet( );
            if(entries != null) {
                Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                while(iterator.hasNext( )) {
                    Entry<String, Object> entry =(Entry<String, Object>) iterator.next( );
                    Object key = entry.getKey( );
                    Object value = entry.getValue();
                    System.out.println(key+":"+value);
                }
            }
        }

    */


    return json;
    }
}
