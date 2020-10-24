package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest{


/*#################################### Other Items testes #################################*/

    // Tester le nom sellIN , quality
    @Test
    void testProperties(){
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        assertThat(app.items[0].name, is( "+5 Dexterity Vest" ));
        assertThat(app.items[0].sellIn, is( 10));
        assertThat(app.items[0].quality, is(20));
    }

    // test tostring
    @Test
    void testToString() {
        
        // name, sellIn, quality
        
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 5, 8) };
        GildedRose app = new GildedRose(items);

        assertThat(app.items[0].toString(), is( "+5 Dexterity Vest, 5, 8" ));
    }


    //Tester le SellIn d'un produit ordinaire ( sellIn > 0)
    @Test
    void sellInProduitOrdinaire() {
        
        // name, sellIn, quality
        
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality - 1;
        int expectedSellIn = app.items[0].sellIn - 1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
        assertThat(app.items[0].sellIn, is( expectedSellIn ));
    }
      
    //Tester la quality d'un produit ordinaire ( sellIn < 0) et qualité < 0
        
    @Test
    void ordinaryItemWithNegativeSellInAndNegativeQuality() {        
        // name, sellIn, quality

        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -1, -5) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = app.items[0].quality;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality ));
    }

    //La qualité (`quality`) d'un produit ne peut jamais être négative.
    @Test
    void testNegativeQuality() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 5, 0) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
    }

    //- Une fois que la date de péremption est passée, la qualité se dégrade deux fois plus rapidement.
    @Test
    void qualitywhensellinisnegativ() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", -2, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 20-2;
        int expectedSellIn= -2 -1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
        assertThat(app.items[0].sellIn, is( expectedSellIn )) ;
    }

    @Test
    void qualitywhenSellIn0() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Elixir of the Mongoose", 0, 2) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 2-2;
        int expectedSellIn= 0-1;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality )) ;
        assertThat(app.items[0].sellIn, is( expectedSellIn )) ;
    }

    /*#################################### Fin Ordinare Item #################################*/

    /*##################################### Aged Brie #################################*/

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
    
    //################ fin aged brie ##########################"/


    
    //################ Backstage testes ##########################"/
    
    //- La qualité d'un produit n'est jamais de plus de 50.
    @Test
    void qualityNotsuperiorto50() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 4)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 21;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 14)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_1() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 21;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 14)) ;

    }



    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_2() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 9, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 22;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 8)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    @Test
    void qualityBackstagePasses_3() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 10 + 3;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }


    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    //la quality ne peut pas etre plus de 50
    @Test
    void qualityBackstageAfterConcert() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 0;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( -1)) ;

    }

    //"Backstage passes", comme le "Aged Brie", augmente sa qualité (`quality`) plus le temps passe (`sellIn`) ; La qualité augmente de 2 quand il reste 10 jours ou moins et de 3 quand il reste 5 jours ou moins, mais la qualité tombe à 0 après le concert.
    //la quality ne peut pas etre plus de 50
    @Test
    void qualityBackstagePassesSuperiorto50() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 50;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }
    
    //################ end Backstage testes ##########################"/

    /*################ Sulfuras testes ######################################*/
    
    //"Sulfuras", étant un objet légendaire, n'a pas de date de péremption et ne perd jamais en qualité (`quality`)
    //Juste une précision, un produit ne peut jamais voir sa qualité augmenter au-dessus de 50, cependant "Sulfuras" est un objet légendaire et comme tel sa qualité est de 80 et il ne change jamais.

    @Test
    void qualitySulfuras() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 80;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;

    }


    @Test
    void qualitySulfurasWithNegativeSellIn() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 20;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( app.items[0].sellIn)) ;

    }
   // @Test
  /*  void test1() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 4, 20) };
        GildedRose app = new GildedRose(items);
        int expectedQuality= 20;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3)) ;

    }
    */

    /*################ End Sulfuras testes ######################################*/

    
    /*################ Conjured testes ######################################*/

    
    //marche pas encore
    //- les éléments "Conjured" voient leur qualité se dégrader de deux fois plus vite que les objets normaux.
    @Test
    void qualityConjured() {
                
        // name, sellIn, quality
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        int expectedQuality = 6 - 2;
        app.updateQuality();

        assertThat(app.items[0].quality, is( expectedQuality)) ;
        assertThat(app.items[0].sellIn, is( 3-1)) ;

    }
}
