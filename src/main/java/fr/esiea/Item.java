package fr.esiea;

public class Item {
    private String name;

    private int sellIn;
    private int quality;
    private int id;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName(){
        return name;
    }

    public int getSellIn(){
        return sellIn;
    }

    public int getQuality(){
        return quality;
    }

    public void setSellIn(int pSellIn){
        sellIn = pSellIn;
    }

    public void setQuality(int pQuality){
        quality = pQuality;
    }
    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
