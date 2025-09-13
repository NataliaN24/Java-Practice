package bg.sofia.uni.fmi.mjt.gameplatform.store.item.Category;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GameBundle implements StoreItem
{
    private String title;
    private BigDecimal price;
    private LocalDateTime releaseDate;
    private Game[] games;
    private double totalRating;
    private int ratingCount;

public GameBundle(String title, BigDecimal price, LocalDateTime releaseDate, Game[] games) {
    setTitle(title);
        setPrice(price);
        setReleaseDate(releaseDate);
        setGames(games);
        rate(0.0);
    }

      @Override
    public String getTitle(){
        return title;
    }
     @Override
    public BigDecimal getPrice(){
        return price;
    }
     @Override
    public double getRating(){
        if(ratingCount == 0)
        {
            return 0.0;
        }
        return totalRating/ratingCount;
    }
     @Override
    public LocalDateTime getReleaseDate(){
        return releaseDate;
    }
     @Override
    public void setTitle(String title){
        this.title=title;
    }
     @Override
    public void setPrice(BigDecimal price){
        this.price=price.setScale(2);
    }
     @Override
    public void setReleaseDate(LocalDateTime releaseDate){
        this.releaseDate=releaseDate;
    }
     @Override
    public void rate(double rating){
        if(rating >=1 && rating <=5)
        {
            totalRating +=rating;
            ratingCount++;
        }
    }
    //specific for game bundle
    public void setGames(Game[]games)
    {
        this.games=games;
    }
    public Game[]getGames() {
        return games;
    }

}