package com.gildedrose;

class AgedBrie {
    Item agedBrie ; 
    public static final int qualityMaximumValue = 50;

    AgedBrie(Item item){
        this.agedBrie = item; 
    }

    private void updateQuality( Item item ) {
        if(qualityUnderMaxValue(item)){
            item.quality = item.quality + 1;        
        }
    }

    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    private boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
    }

    public void updateAgedBrie( ){
        updateQuality(this.agedBrie);
        if(sellInUnder0(this.agedBrie)){
            updateQuality(this.agedBrie);
        }
    }
}