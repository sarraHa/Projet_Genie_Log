package com.gildedrose;


public abstract class GildedRoseItems {

    public static final int qualityMaximumValue = 50;
    public static final int qualityMinimumValue =  0;
    
    GildedRoseItems(){

    }

    protected boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
    }

    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    protected void updateQuality( Item item ) {
        if(qualityUnderMaxValue(item)){
            item.quality = item.quality + 1;        
        }
    }

}