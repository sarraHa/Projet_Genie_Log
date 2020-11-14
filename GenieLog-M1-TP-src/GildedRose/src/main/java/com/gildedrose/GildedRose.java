package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String agedBrie = "Aged Brie";
    public static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    public static final String sulfuras = "Sulfuras, Hand of Ragnaros";
    public static final String conjured = "Conjured Mana Cake";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            GildedRoseItems gildedRoseItem = getItemByName(item);
            gildedRoseItem.update(item);
        }
    }

    private GildedRoseItems getItemByName(Item item){
        switch(item.name) {
            case sulfuras:
                Sulfuras sulfuras = new Sulfuras();
                return sulfuras;
            case agedBrie:
                AgedBrie agedBrie = new AgedBrie();
                return agedBrie;
            case backstage:
                Backstage backstage = new Backstage();
                return backstage;
            case conjured:
                Conjured conjured = new Conjured();
                return conjured;
            default:
                OtherItems otherItems = new OtherItems();
                return otherItems;
        }
    }

}