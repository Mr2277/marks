package marks.entity;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class Info implements RowMapper<Info> {
    private String num;
    private String valuetitle;
    private String category3;
    private String interyear;
    public Info(){

    }
    public Info(String num,String valuetitle,String category3,String interyear){
        this.num=num;
        this.valuetitle=valuetitle;
        this.category3=category3;
        this.interyear=interyear;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getValuetitle() {
        return valuetitle;
    }

    public void setValuetitle(String valuetitle) {
        this.valuetitle = valuetitle;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getInteryear() {
        return interyear;
    }

    public void setInteryear(String interyear) {
        this.interyear = interyear;
    }

    @Override
    public Info mapRow(ResultSet resultSet, int i) throws SQLException {
        Info info=new Info();
        info.setNum(resultSet.getString("num"));
        info.setCategory3(resultSet.getString("category3"));
        info.setValuetitle(resultSet.getString("valuetitle"));
        info.setInteryear(resultSet.getString("interyear"));
        return info;
    }
}
