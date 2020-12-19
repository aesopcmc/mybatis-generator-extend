package cn.aesop.example.enums;

/**
 * @author Aesop(chao_c_c @ 163.com)
 * @date 2019/10/24 16:02
 */
public enum DeleteFlagEnum {
    VALID(0,"可用"),
    DELETE(1,"已删除");

    private int index;
    private String name;

    DeleteFlagEnum(int index, String name) {
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
