package dev.bean;

// https://github.com/yennanliu/JavaHelloWorld/blob/main/src/main/java/Advances/ComparableComparator/Goods.java

import java.util.Arrays;
import java.util.Comparator;

public class Data implements Comparable {

    private String id;
    private String createTime;
    private String[] dataPoints;

    public Data(String id, String createTime, String[] dataPoints) {
        this.id = id;
        this.createTime = createTime;
        this.dataPoints = dataPoints;
    }

    public Data() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String[] getDataPoints() {
        return dataPoints;
    }

    public void setDataPoints(String[] dataPoints) {
        this.dataPoints = dataPoints;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", createTime='" + createTime + '\'' +
                ", dataPoints=" + Arrays.toString(dataPoints) +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        if (o instanceof Data){
            Data data = (Data) o;
//
            if (data.createTime.equals("others")){
                return -1;
            }
            else if (Integer.valueOf(this.id) > Integer.valueOf(data.id)){
                return 1;
            }
            else if (Integer.valueOf(this.id) < Integer.valueOf(data.id)){
                return -1;
            }
            else{
                return 0;
            }
        }
        throw new RuntimeException("input (price) type mismatch!");
    }

}
