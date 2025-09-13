package bg.sofia.uni.fmi.mjt.gameplatform.store;

import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.Category.Game;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.Category.DLC;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.Category.GameBundle;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.filter.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GameStoreTest {

    public static void main(String[] args) {

        // 1️⃣ Create some games
        Game game1 = new Game("Cyber Adventure", new BigDecimal("59.99"),
                LocalDateTime.of(2025, 11, 1, 0, 0), "Action");
        Game game2 = new Game("Fantasy Quest", new BigDecimal("39.99"),
                LocalDateTime.of(2024, 6, 15, 0, 0), "RPG");

        // 2️⃣ Create DLC and bundle
        DLC dlc1 = new DLC("Cyber Adventure: Expansion", new BigDecimal("19.99"),
                LocalDateTime.of(2025, 12, 1, 0, 0), game1);

        Game[] bundleGames = {game1, game2};
        GameBundle bundle = new GameBundle("Adventure Pack", new BigDecimal("89.99"),
                LocalDateTime.of(2025, 11, 5, 0, 0), bundleGames);

        // 3️⃣ Create store
        StoreItem[] items = {game1, game2, dlc1, bundle};
        GameStore store = new GameStore(items);

        // 4️⃣ Test filtering
        ItemFilter priceFilter = new PriceItemFilter(new BigDecimal("50.00"), new BigDecimal("100.00"));
        ItemFilter ratingFilter = new RatingItemFilter(0); // everything
        StoreItem[] filtered = store.findItemByFilters(new ItemFilter[]{priceFilter, ratingFilter});

        System.out.println("Filtered items by price 50-100:");
        for (StoreItem item : filtered) {
            System.out.println(item.getTitle() + " - $" + item.getPrice());
        }

        // 5️⃣ Test promo codes
        store.applyDiscount("VAN40"); // 40% off
        System.out.println("\nPrices after VAN40 discount:");
        for (StoreItem item : items) {
            System.out.println(item.getTitle() + " - $" + item.getPrice());
        }

        store.applyDiscount("100YO"); // 100% off
        System.out.println("\nPrices after 100YO discount:");
        for (StoreItem item : items) {
            System.out.println(item.getTitle() + " - $" + item.getPrice());
        }

        // 6️⃣ Test rating
        store.rateItem(game1, 5);
        store.rateItem(game1, 4);
        store.rateItem(game2, 3);

        System.out.println("\nGame ratings:");
        for (StoreItem item : items) {
            System.out.println(item.getTitle() + " - Rating: " + item.getRating());
        }

        // 7️⃣ Test Title filter
        ItemFilter titleFilter = new TitleItemFilter("Cyber", false);
        StoreItem[] cyberItems = store.findItemByFilters(new ItemFilter[]{titleFilter});
        System.out.println("\nItems with 'Cyber' in title:");
        for (StoreItem item : cyberItems) {
            System.out.println(item.getTitle());
        }
    }
}
