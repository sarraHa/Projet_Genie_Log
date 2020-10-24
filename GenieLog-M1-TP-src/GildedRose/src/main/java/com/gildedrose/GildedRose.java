package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String adgedBrie = "Aged Brie";
    public static final String backstagePasses = "Backstage passes to a TAFKAL80ETC concert";
    public static final String conjured = "Conjured Mana Cake";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";


    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQuality( Item agedBrie ) {
        agedBrie.quality = agedBrie.quality + 1;
    }

    private void updateSellin( Item agedBrie ) {
        agedBrie.sellIn = agedBrie.sellIn - 1;
    }

    private void updateAgedBrie(Item agedBrie ){

        // Aged Brie quality < 50
        if(agedBrie.quality < 50){
            updateQuality(agedBrie);
            updateSellin( agedBrie );
        
        }else{
            updateSellin(agedBrie);   
        }
        
        if(agedBrie.sellIn < 0 && agedBrie.quality < 50){
            updateQuality(agedBrie);
        }
    }


    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (items[i].quality > 0) {

                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        // si c'est un produit ordinaire
                        items[i].quality = items[i].quality - 1;
                    }
                }

            } else {

                if( items[i].name.equals(adgedBrie)){
                    updateAgedBrie( items[i]);
                }

                                
                if (items[i].quality < 50) {
                    // Backstage passes
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        items[i].quality = items[i].quality + 1;
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }


            // update sellIn of all products unless Sulfuras
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros") && !items[i].name.equals(adgedBrie)) {

                items[i].sellIn = items[i].sellIn - 1;
            }


            // if sellin < 0
            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        //Une fois que la date de péremption est passée, la qualité se dégrade deux fois plus rapidement.
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } 
            }
        }
    }
}