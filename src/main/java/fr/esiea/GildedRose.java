package fr.esiea;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            String itemName = items[i].getName();
            switch(itemName){
                case "Aged Brie":
                    items[i] = updateAgedBrie(items[i]);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i] = updateBackstage(items[i]);
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    // Rien à faire
                    break;
                default:
                    items[i] = updateNonSpecificItem(items[i]);
            }
        }
    }

    public Item updateAgedBrie(Item item){
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0) {
            if (item.getQuality()< 50) {
                item.setQuality(item.getQuality() + 1);
            }
        }
        return item;
    }

    public Item updateBackstage(Item item){
        if (item.getQuality()< 50) {
            item.setQuality(item.getQuality() + 1);
            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0) {
            item.setQuality(0);
        }
        return item;
    }

    public Item updateNonSpecificItem(Item item){
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
        item.setSellIn(item.getSellIn() - 1);

        if (item.getSellIn() < 0) {
            if (item.getQuality() > 0) {
                item.setQuality(item.getQuality() - 1);
            }
        }
        return item;
    }
}
