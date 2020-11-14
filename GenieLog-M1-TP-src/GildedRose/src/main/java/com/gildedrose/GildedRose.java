package com.gildedrose;

class GildedRose {

    public static final String AGEDBRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            GildedRoseItems gildedRoseItem = getItemByName(item);
            gildedRoseItem.update(item);
        }
    }

    private GildedRoseItems getItemByName(Item item) {
        switch (item.name) {
            case SULFURAS:
                return new Sulfuras();
            case AGEDBRIE:
                return new AgedBrie();
            case BACKSTAGE:
                return new Backstage();
            case CONJURED:
                return new Conjured();
            default:
                return new OtherItems();
        }
    }
}
