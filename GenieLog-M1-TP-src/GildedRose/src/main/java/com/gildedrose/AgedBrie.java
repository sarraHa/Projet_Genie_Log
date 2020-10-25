package com.gildedrose;

class AgedBrie {


    public static final int qualityMaximumValue = 50;


    
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

    private void updateAgedBrie(Item agedBrie ){
        updateQuality(agedBrie);
        if(sellInUnder0(agedBrie)){
            updateQuality(agedBrie);
        }
    }



}