/**
 * Created by anna.mameko on 6/23/2017.
 */
public class Price {

    private final String colour;
    private final String font;

    public Price(String colour, String font) {
        this.colour = colour;
        this.font = font;
    }

    public String getColour() {
        return colour;
    }

    public String getFont() {
        return font;
    }

    @Override
    public String toString() {
        return "Price{" +
                "colour='" + colour + '\'' +
                ", font='" + font + '\'' +
                '}';
    }
}
