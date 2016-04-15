package model;



public class BitLevel {
    private int level;
    private String bits;



    public BitLevel(int level, String bits) {
        this.level = level;
        this.bits = bits;
    }



    public int getLevel() {
        return level;
    }



    public void setLevel(int level) {
        this.level = level;
    }



    public String getBits() {
        return bits;
    }



    public void setBits(String bits) {
        this.bits = bits;
    }
}
