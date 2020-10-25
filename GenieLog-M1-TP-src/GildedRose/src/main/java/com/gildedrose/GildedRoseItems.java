package com.gildedrose;


public abstract class GildedRoseItems {

    public static final int qualityMaximumValue = 50;
    public static final int qualityMinimumValue =  0;

    GildedRoseItems(){

    }

    protected boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
    }

    protected boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    protected void updateQuality( Item item ) {
        if(qualityUnderMaxValue(item)){
            item.quality = item.quality + 1;        
        }
    }

    protected void setQualityTo0(Item backstage) {
        backstage.quality = backstage.quality - backstage.quality;
    }

    protected void update( Item item) {
        updateQuality(item);
        if(sellInUnder0(item)){
            updateQuality(item);
        }
    }
    
}