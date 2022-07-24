package sl.springboot.test.java8.generic.bean;

import java.util.Date;

public class MasterWrapper<T extends Master> {
    private T obj;
    private Date createDate;
    public MasterWrapper(T obj){
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
