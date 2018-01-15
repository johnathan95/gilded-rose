package fr.esiea;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void sellinPlusOneCase() {
        Item[] items = new Item[] {new Item("test", 2, 10)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();
        assertEquals(9 , gildedRose.items[0].quality);
        assertEquals(1, gildedRose.items[0].sellIn);
    }
}

