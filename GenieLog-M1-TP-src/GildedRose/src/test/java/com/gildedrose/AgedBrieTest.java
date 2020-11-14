package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class AgedBrieTest{

   
    


    //"Aged Brie" augmente sa qualité (`quality`) plus le temps passe.
    @Test
    void qualityAgedBrie() {

        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality + 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( 1 ));
    }


    //"Aged Brie" when sellIn < 0 
    // la qualité augmente de 2 fois
    @Test
    void qualityAgedBrieSellInNegative() {

        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Aged Brie", -2, 9) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality + 2;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( -3 ));

    }

        //- La qualité d'un produit n'est jamais de plus de 50. pour "Aged Brie"
        @Test
        void qualityNotsuperiorto50_AdjBrie() {
                
            // name, sellIn, quality
            Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
            GildedRose app = new GildedRose(items);
            int expectedQuality = 50;
            app.updateQuality();

            assertThat(app.items[0].quality, is( expectedQuality)) ;
            assertThat(app.items[0].sellIn, is( 1)) ;

        }


        //- La qualité d'un produit n'est jamais de plus de 50. pour "Aged Brie"
        @Test
        void qualityNotsuperiorto50SellInNegative() {
                
            // name, sellIn, quality
            Item[] items = new Item[] { new Item("Aged Brie", -4, 49) };
            GildedRose app = new GildedRose(items);
            int expectedQuality = 50;
            app.updateQuality();

            assertThat(app.items[0].quality, is( expectedQuality)) ;
            assertThat(app.items[0].sellIn, is( -5)) ;

        }

        @Test
        void AgedBrieQualitySuperiorto50() {
            
            // name, sellIn, quality
            
            Item[] items = new Item[] { new Item("Aged Brie", -10, 60) };
            GildedRose app = new GildedRose(items);
            int expectedQuality = app.items[0].quality ;
            app.updateQuality();

            assertThat(app.items[0].quality, is( expectedQuality ));
        }

}
    