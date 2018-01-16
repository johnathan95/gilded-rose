package fr.esiea;

import static junit.framework.Assert.assertEquals;

import org.assertj.core.api.SoftAssertions;
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

    public void non_specific_object_quality_and_price_decrease_by_one () {

        Item item = new Item("apple",2,10);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.quality)
                .as("Apple quality")
                .isEqualTo(9);

        solftly.assertThat(item.sellIn)
                .as("Apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

}

