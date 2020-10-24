package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";

    public static final int qualityMaximumValue = 50;
    public static final int qualityMinimumValue =  0;

    public static final int sellIn = 50;



    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateQuality( Item item ) {
        item.quality = item.quality + 1;
    }

    private void updateQualityOtherItems( Item item ) {
        item.quality = item.quality - 1;
    }

    private void updateSellin( Item item ) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean qualityUnderMaxValue( Item item ) {
        return item.quality < qualityMaximumValue;
    }



    private void updateAgedBrie(Item agedBrie ){
        if(qualityUnderMaxValue(agedBrie)){
            updateQuality(agedBrie);
            updateSellin( agedBrie );
        
        }else{
            updateSellin(agedBrie);   
        }        
        if(agedBrie.sellIn < 0 && qualityUnderMaxValue(agedBrie) ){
            updateQuality(agedBrie);
        }
    }

    private void updateBackstage(Item backstage ){
        if( qualityUnderMaxValue(backstage) ){
            updateQuality(backstage);
        }
        if (backstage.sellIn < 11) {
            if ( qualityUnderMaxValue(backstage) ) {
                updateQuality(backstage);
            }
        }
        if (backstage.sellIn < 6) {
            if ( qualityUnderMaxValue(backstage) ) {
                updateQuality(backstage);
            }
        }
        updateSellin(backstage);
        if (backstage.sellIn < 0) {
            backstage.quality = backstage.quality - backstage.quality;
        }
    }

    private void UpdateOtherItems( Item item){
        if (item.quality > qualityMinimumValue) {
            updateQualityOtherItems(item);
        }
        updateSellin(item);
        if (item.sellIn < 0) {
            if (item.quality > qualityMinimumValue) {
                updateQualityOtherItems(item);
            }
        }
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            if( items[i].name.equals(sulfuras)){
                continue;
            }else if( items[i].name.equals(agedBrie)){
                updateAgedBrie( items[i]);
            }else if (items[i].name.equals(backstage)) {
                updateBackstage(items[i]);
            }else{
                UpdateOtherItems( items[i]);
            }
        }
    }
}