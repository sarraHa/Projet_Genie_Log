package com.gildedrose;

class Backstage extends GildedRoseItems {
    Item backstage ; 
    public static final int qualityMaximumValue = 50;

    Backstage(Item item){
        this.backstage = item; 
    }


    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    private void setQualityTo0(Item backstage){
        backstage.quality = backstage.quality - backstage.quality;
    }

    public void updateBackstage(){
        updateQuality(backstage);
        if (this.backstage.sellIn < 11) { updateQuality(this.backstage); }
        if (this.backstage.sellIn < 6) { updateQuality(this.backstage); }
        if (sellInUnder0(this.backstage)) { setQualityTo0(this.backstage); }
    }

}