package cn.aesop.example.enums;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/24 16:02
 */
public enum ModelNameEnum {
    YC(0,"粤C"),
    YK(1,"粤K"),
    YB(2,"粤B");

    private int index;
    private String name;

    ModelNameEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
