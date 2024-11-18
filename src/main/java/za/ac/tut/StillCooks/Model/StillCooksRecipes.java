package za.ac.tut.StillCooks.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tblRecipes")
public class StillCooksRecipes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String ingredients;

    @Column(name = "total_time", nullable = false)
    private String totalTime;

    @Column(name = "num_steps", nullable = false)
    private int numSteps;

    @Column(name = "avg_rating")
    private Double avgRating;

    @Column(name = "num_reviews")
    private Integer numReviews;

    @Column(name = "recipe_url", nullable = false)
    private String recipeURL;

    private String region;

    @Column(name = "image_link")
    private String imageLink;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public void setNumSteps(int numSteps) {
        this.numSteps = numSteps;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public Integer getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public String getRecipeURL() {
        return recipeURL;
    }

    public void setRecipeURL(String recipeURL) {
        this.recipeURL = recipeURL;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StillCooksRecipes recipe = (StillCooksRecipes) o;
        return numSteps == recipe.numSteps &&
                Objects.equals(id, recipe.id) &&
                Objects.equals(title, recipe.title) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(totalTime, recipe.totalTime) &&
                Objects.equals(avgRating, recipe.avgRating) &&
                Objects.equals(numReviews, recipe.numReviews) &&
                Objects.equals(recipeURL, recipe.recipeURL) &&
                Objects.equals(region, recipe.region) &&
                Objects.equals(imageLink, recipe.imageLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ingredients, totalTime, numSteps, avgRating, numReviews, recipeURL, region, imageLink);
    }

}
