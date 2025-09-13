package bg.sofia.uni.fmi.mjt.gameplatform.store.item.Category;
import bg.sofia.uni.fmi.mjt.gameplatform.store.item.StoreItem;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Game implements StoreItem 
{
    private String title;
    private BigDecimal price;
    private LocalDateTime releaseDate;
    private String genre;
    private double totalRating;
    private int ratingCount;



public Game(String title, BigDecimal price, LocalDateTime releaseDate, String genre){
    setTitle(title);
    setPrice(price);
    setReleaseDate(releaseDate);
    setGenre(genre);
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
    //specific for game
    public String getGenre()
    {
        return genre;
    }
    public void setGenre(String genre)
    {
        this.genre=genre;
    }
}
