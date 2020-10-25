package com.gildedrose;

class Backstage {
    Item backstage ; 
    public static final int qualityMaximumValue = 50;

    Backstage(Item item){
        this.backstage = item; 
    }


    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }

    private void updateQuality( Item item ) {
        if(qualityUnderMaxValue(item)){
            item.quality = item.quality + 1;        
        }
    }

    private boolean sellInUnder0( Item item ) {
        return item.sellIn < 0;
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