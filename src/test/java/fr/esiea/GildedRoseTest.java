package fr.esiea;

import static junit.framework.Assert.assertEquals;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class GildedRoseTest {



    @Test
    public void non_specific_object_quality_and_price_decrease_by_one () {

        Item item = new Item("apple",2,10);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality())
                .as("Apple quality")
                .isEqualTo(9);

        solftly.assertThat(item.getSellIn())
                .as("Apple price")
                .isEqualTo(1);

        solftly.assertAll();
    }

    @Test
    public void aged_brie_quality_and_price () {

        Item item = new Item("Aged Brie",0,40);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality())
                .as("Aged Brie quality")
                .isEqualTo(42);

        solftly.assertThat(item.getSellIn())
                .as("Aged Brie price")
                .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void backstage_passes_quality_and_price () {

        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",0,40);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality())
                .as("Backstage passes quality")
                .isEqualTo(0);

        solftly.assertThat(item.getSellIn())
                .as("Backstage passes price")
                .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void non_specific_object_negative_price() {

        Item item = new Item("apple",0,40);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.updateQuality();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.getQuality())
                .as("Apple quality")
                .isEqualTo(38);

        solftly.assertThat(item.getSellIn())
                .as("Apple price")
                .isEqualTo(-1);

        solftly.assertAll();
    }

    @Test
    public void non_specific_object_to_string() {

        Item item = new Item("apple",0,40);
        Item[] items = new Item[] {item};

        GildedRose tavern = new GildedRose(items);

        tavern.toString();

        SoftAssertions solftly = new SoftAssertions();
        solftly.assertThat(item.toString())
                .as("Apple description")
                .isEqualTo("apple, 0, 40");

        solftly.assertAll();
    }
}