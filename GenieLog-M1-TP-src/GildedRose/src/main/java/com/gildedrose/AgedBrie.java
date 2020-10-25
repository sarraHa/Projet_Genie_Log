package com.gildedrose;

class AgedBrie extends GildedRoseItems {
    Item agedBrie ; 
    public static final int qualityMaximumValue = 50;

    AgedBrie(Item item){
        this.agedBrie = item; 
    }

    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    public void updateAgedBrie( ){
        updateQuality(this.agedBrie);
        if(sellInUnder0(this.agedBrie)){
            updateQuality(this.agedBrie);
        }
    }
}