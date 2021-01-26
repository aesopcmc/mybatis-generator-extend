package cn.aesop.example;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

//    private static final long serialVersionUID = 2727612503629396628L;

    /**
     * 自增Id
     * id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
